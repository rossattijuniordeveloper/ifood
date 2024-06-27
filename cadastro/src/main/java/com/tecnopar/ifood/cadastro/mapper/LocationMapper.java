package com.tecnopar.ifood.cadastro.mapper;

import com.tecnopar.ifood.cadastro.dto.LocationDTO;
import com.tecnopar.ifood.cadastro.models.Location;

public interface LocationMapper {
    Location toLocation(LocationDTO locationDTO);
    
    LocationDTO toLocationDTO(Location location);
}
