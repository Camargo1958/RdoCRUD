package rdo_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rdo_crud.model.User;
import rdo_crud.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	 @Autowired
	 UserService userService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("user/user_page");
	  
	  List<User> list = userService.listAllUsers();
	  model.addObject("listUser", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = new User();
	  model.addObject("userForm", user);
	  
	  return model;
	 }

	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = userService.findUserById(id);
	  model.addObject("userForm", user);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("user_form") User user){
	  
	  if(user != null && user.getId() != null){
		   userService.updateUser(user);
		  } else {
		   userService.addUser(user);
		  } 
	 
	  	return new ModelAndView("redirect:/user/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
  
	  userService.deleteUser(id);
	  	  
	  return new ModelAndView("redirect:/user/list");
	 }
	 
	 @RequestMapping(value="/verify1/{id}", method=RequestMethod.GET)
	 public ModelAndView verify1(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = userService.findUserById(id);
	  model.addObject("userForm", user);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/verify2/{user_name}", method=RequestMethod.GET)
	 public ModelAndView verify2(@PathVariable("user_name") String user_name){
	  ModelAndView model = new ModelAndView("user/user_form");
	  //System.out.println("verify2 user_name: "+ user_name);
	  User user = userService.findUserByName(user_name);
	  //if(user != null) {
		  model.addObject("userForm", user);
/*	  }else{
		  user = new User("Invalid");
		  model.addObject("userForm", user);
	  }*/
	  return model;
	 }
	 
}
