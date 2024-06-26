package com.tecnopar.ifood.cadastro;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "restaurante")
public class RestaurantResource {

    @GET  
    @Tag(name = "restaurante")
    public List<Restaurant> search() {
    	return Restaurant.listAll();
    }    
    @POST
    @Transactional
    @Tag(name = "restaurante")
    public Response insert(Restaurant dto) {
    	dto.persist();        
        return Response.status(Status.CREATED).build();
    }
    @PUT
    @Path("{id}")
    @Tag(name = "restaurante")
    @Transactional
    public void update(@PathParam("id") Long id, Restaurant dto){
       Optional<Restaurant> restaurantOp = Restaurant.findByIdOptional(id);        
       if(restaurantOp.isEmpty()){
        throw new NotFoundException();
       }
       Restaurant restaurant = restaurantOp.get();
       restaurant.name = dto.name;
       restaurant.owner = dto.owner;
       restaurant.persist();
    }
    @DELETE
    @Path("{id}")
    @Tag(name = "restaurante")
    @Transactional
    public void delete(@PathParam("id") Long id, Restaurant dto){
       Optional<Restaurant> restaurantOp = Restaurant.findByIdOptional(id);        
       restaurantOp.ifPresentOrElse(Restaurant::delete, () -> {
            throw new NotFoundException();
        });
    }
    
    // ///////////////////////////////
    //            PRATOS
    // //////////////////////////////
    @GET  
    @Path("{idRestaurant}/plate")    
    @Tag(name = "prato")
    public List<Restaurant> searchPlate(@PathParam("idRestaurant") Long idRestaurant) {
    	Optional<Restaurant> restaurantOp = Restaurant.findByIdOptional(idRestaurant);
    	if(restaurantOp.isEmpty()) {
    		throw new NotFoundException("Restaurante não existe!");    		
    	}   	
    	return Plate.list("restaurant", restaurantOp.get());    	
    }    
    @POST
    @Path("{idRestaurant}/plate")
    @Transactional
    @Tag(name = "prato")
    public Response insertPlate(@PathParam("idRestaurant") Long idRestaurant, Plate dto) {
        Optional<Restaurant> restaurantOp = Restaurant.findByIdOptional(idRestaurant);
        if(restaurantOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe!");
        }
        Plate plate = new Plate();
        plate.name = dto.name;
        plate.description = dto.description;
        plate.price = dto.price;
        plate.restaurant = restaurantOp.get();
        plate.persist();        
        return Response.status(Status.CREATED).build();
    }      
    @PUT
    @Path("{idRestaurant}/plate/{id}")
    @Transactional
    @Tag(name = "prato")
    public Response updatePlate(@PathParam("idRestaurant") Long idRestaurant,@PathParam("id") Long id, Plate dto){
        Optional<Restaurant> restaurantOp = Restaurant.findByIdOptional(idRestaurant);
        if(restaurantOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe!");
        }
        Optional<Plate> plateOp = Plate.findByIdOptional(id);
        if(plateOp.isEmpty()){
            throw new NotFoundException("Prato não existe!");
        }
        Plate plate = plateOp.get();
        plate.name = dto.name;
        plate.description = dto.description;
        plate.price = dto.price;
        plate.persist();
        return Response.status(Status.ACCEPTED).build();
    }
    @DELETE
    @Path("{idRestaurant}/plate/{id}")
    @Transactional
    @Tag(name = "prato")
    public void deletePlate(@PathParam("idRestaurant") Long idRestaurant,@PathParam("id") Long id){
        Optional<Restaurant> restaurantOp = Restaurant.findByIdOptional(idRestaurant);
        if(restaurantOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe!");
        }
        Optional<Plate> plateOp = Plate.findByIdOptional(id);
        if(plateOp.isEmpty()){
            throw new NotFoundException("Prato não existe!");
        }
        Plate plate = plateOp.get();
        plate.delete();
    }
}
