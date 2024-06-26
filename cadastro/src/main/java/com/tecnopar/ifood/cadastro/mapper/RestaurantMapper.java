package com.tecnopar.ifood.cadastro.mapper;

import org.mapstruct.Mapper;

import com.tecnopar.ifood.cadastro.dto.RestaurantDTO;
import com.tecnopar.ifood.cadastro.models.Restaurant;

@Mapper(componentModel = "cdi")
public interface RestaurantMapper {
    
    public Restaurant toRestaurant(RestaurantDTO restaurantDTO);

//    public RestaurantDTO toRestaurantDTO(Restaurant restaurant);
}
