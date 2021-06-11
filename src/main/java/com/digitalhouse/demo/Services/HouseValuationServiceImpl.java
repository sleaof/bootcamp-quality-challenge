package com.digitalhouse.demo.Services;


import com.digitalhouse.demo.DTOs.DistrictDTO;
import com.digitalhouse.demo.DTOs.HomeDTO;
import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.DTOs.RoomDTO;
import com.digitalhouse.demo.Repository.DisctrictRepository;
import com.digitalhouse.demo.Repository.DisctrictRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class HouseValuationServiceImpl implements HouseValuationService {

    @Autowired
    public DisctrictRepository disctrictRepository;


    @Override
    public HomeDTO home(PropertsDTO propertsDTO) {
        HomeDTO homeDTO = new HomeDTO();
        homeDTO.setPropertyValue(propertyValue(propertsDTO));
        homeDTO.setBiggestRoom(biggestRoom(propertsDTO));
        homeDTO.setTotalSquareMeters(totalSquareMeters(propertsDTO));
        homeDTO.setSquareMetersPerRoom(squareMetersPerRoom(propertsDTO));
        return homeDTO;
    }


    //Total de metros quadrados
    public Double totalSquareMeters(PropertsDTO propertsDTO) {

        Double cAux1 = 1.0;
        for (int i = 0; i < propertsDTO.getRoom().size(); i++) {
            cAux1 += propertsDTO.getRoom().get(i).getRoom_length() * propertsDTO.getRoom().get(i).getRoom_width();
        }

        return cAux1;
    }

    //Valor da propriedade
    public Object propertyValue(PropertsDTO propertsDTO) {

//        Double valueDistrict = disctrictRepository.loadDB()
//                .stream().filter(x -> x.getNameDistrict().contentEquals(propertsDTO.getProp_name()))
//                .findFirst().get().getSquareMeterValue();

        Double valueDistrict = 0.0;
        int sizeDistrict = disctrictRepository.loadDB().size();
        for (int i = 0; i < sizeDistrict; i++){
        Boolean findDistrict = disctrictRepository.loadDB().get(i)
                .getNameDistrict().toLowerCase(Locale.ROOT)
               .equals(propertsDTO.getProp_district()
                        .toLowerCase(Locale.ROOT));
            if (findDistrict == true){
            valueDistrict = disctrictRepository.loadDB().get(i).getSquareMeterValue();
        }

        }
        Double propertyValue = totalSquareMeters(propertsDTO) * valueDistrict;

        return propertyValue;
    }

    //Maior comodo
    public Optional<Map.Entry<String, Double>> biggestRoom(PropertsDTO propertsDTO) {
       HashMap<String, Double> biggest = new HashMap<>();
//        Double value = Collections.max (squareMetersPerRoom(propertsDTO).values());
//        String name = squareMetersPerRoom(propertsDTO).entrySet();

        return squareMetersPerRoom(propertsDTO).entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .findFirst();
    }

    //Metros quadrados por comodo
    public HashMap<String, Double> squareMetersPerRoom(PropertsDTO propertsDTO) {

        HashMap<String, Double> metersandRoom = new HashMap<>(); ;
        for (int i = 0; i < propertsDTO.getRoom().size(); i++) {
            String  cAux2 = propertsDTO.getRoom().get(i).getRoom_name();
            Double aux2 = propertsDTO.getRoom().get(i).getRoom_length() * propertsDTO.getRoom().get(i).getRoom_width();
            metersandRoom.put(cAux2, aux2);
        }
        System.out.println(metersandRoom);
        return metersandRoom;
    }

}