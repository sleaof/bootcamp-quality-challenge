package com.digitalhouse.demo.Services;


import com.digitalhouse.demo.DTOs.HomeDTO;
import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.Repository.DisctrictRepository;
import com.digitalhouse.demo.Repository.DisctrictRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class HouseValuationServiceImpl implements HouseValuationService {


    public DisctrictRepository disctrictRepository;

    public HouseValuationServiceImpl(DisctrictRepositoryImpl disctrictRepository) {
        this.disctrictRepository = disctrictRepository;
    }

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

        Double cAux1 = 0.0;
        for (int i = 0; i < propertsDTO.getRoom().size(); i++) {
            cAux1 += propertsDTO.getRoom().get(i).getRoom_length() * propertsDTO.getRoom().get(i).getRoom_width();
        }

        return cAux1;
    }

    //Valor da propriedade
    public Double propertyValue(PropertsDTO propertsDTO) {

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
        }if (valueDistrict == 0.0){
                System.out.println("erro");
            }
        }
        Double propertyValue = totalSquareMeters(propertsDTO) * valueDistrict;

        return propertyValue;
    }

    //Maior comodo
    public Map.Entry<String, Double> biggestRoom(PropertsDTO propertsDTO) {
       HashMap<String, Double> biggest = new HashMap<>();
        return squareMetersPerRoom(propertsDTO).entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .findFirst().get();
    }

    //Metros quadrados por comodo
    public HashMap<String, Double> squareMetersPerRoom(PropertsDTO propertsDTO) {

        HashMap<String, Double> metersandRoom = new HashMap<>(); ;
        for (int i = 0; i < propertsDTO.getRoom().size(); i++) {
            String  cAux2 = propertsDTO.getRoom().get(i).getRoom_name();
            Double aux2 = propertsDTO.getRoom().get(i).getRoom_length() * propertsDTO.getRoom().get(i).getRoom_width();
            metersandRoom.put(cAux2, aux2);
        }
        return metersandRoom;
    }

}