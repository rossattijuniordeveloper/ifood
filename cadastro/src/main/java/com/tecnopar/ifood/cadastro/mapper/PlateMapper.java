package com.tecnopar.ifood.cadastro.mapper;

import com.tecnopar.ifood.cadastro.dto.PlateDTO;
import com.tecnopar.ifood.cadastro.models.Plate;

public interface PlateMapper {

    Plate toPlate(PlateDTO plateDTO); 

    PlateDTO toPlateDTO(Plate plate);
}
