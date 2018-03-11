package rdo_crud.service;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import rdo_crud.model.User;
import rdo_crud.service.UserService;
import rdo_crud.vo.VOUsuario;

/**
 * @author Aldrovando
 * Version 2.0
 */
@Path("/web")
public class ServiceLoginJR {
	@Autowired
	UserService userService;
	User user;
	
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsuario validaUsuario(VOUsuario vo) {
		vo.setUserValido(false);
		if(vo.getUsuario().equals("Java") && vo.getPassword().equals("Revolutions")){
			vo.setUserValido(true);
		}
                vo.setPassword("#######");
		return vo;
	}
        
    @POST
	@Path("/registrarUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsuario registrarUsuario(VOUsuario vo) {
		vo.setUserValido(false);
		if(vo.getUsuario().equals("Java") && vo.getPassword().equals("Revolutions")){
			vo.setUserValido(true);
		}
		return vo;
	}
    
}
