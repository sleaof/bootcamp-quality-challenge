package com.digitalhouse.demo.Services;


import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.Repository.DisctrictRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;



@Service
public class HouseValuationServiceImpl implements HouseValuationService {

    @Autowired
    public DisctrictRepositoryImpl disctrictRepository;

    PropertsDTO propertsDTO;

    //Total de metros quadrados
    private Double totalSquareMeters() {

        Double cAux1 = null;
        //metros quadrados da casa
        for (int i = 0; i < propertsDTO.getRoom().size(); i++) {
            cAux1 += propertsDTO.getRoom().get(i).getRoom_length() * propertsDTO.getRoom().get(i).getRoom_width();
        }
        return cAux1;
    }

    //Valor da propriedade
    private Double propertyValue() {
        prope
        Double valueDistrict = disctrictRepository.loadDB().stream()
                .filter(districtDTO -> districtDTO.getNameDistrict().equals(district))
                .mapToDouble(districtDTO -> districtDTO.getSquareMeterValue())
                .average()
                .getAsDouble();

        Double propertyValue = totalSquareMeters() * valueDistrict;
        return propertyValue;
    }

    //Maior comodo
    private HashMap<String, Double> biggestRoom() {
        return squareMetersPerRoom().stream().max(Comparator.comparing(String::valueOf)).get();
    }

    //Metros quadrados por comodo
    private List<HashMap<String, Double>> squareMetersPerRoom() {
        String cAux2 = "";
        List<HashMap<String, Double>> squareMetersPerRoom = new ArrayList<>();
        for (int i = 0; i < propertsDTO.getRoom().size(); i++) {
            HashMap<String, Double> metersandRoom = new HashMap<>();
            cAux2 = propertsDTO.getRoom().get(i).getRoom_name();
            metersandRoom.put(cAux2, totalSquareMeters());
            squareMetersPerRoom.add(metersandRoom);
        }
        return squareMetersPerRoom;
    }

    @Override
    public PropertsDTO home(PropertsDTO propertsDTO) {
        return propertsDTO;
    }
}
