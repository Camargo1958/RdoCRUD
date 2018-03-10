package rdo_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rdo_crud.model.RelDiario;
import rdo_crud.service.RelDiarioService;

@Controller
@RequestMapping(value="/rdo")
public class RelDiarioController {
	
	 @Autowired
	 RelDiarioService relDiarioService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("rdo/rdo_page");
	  
	  List<RelDiario> list = relDiarioService.listAllRDO();
	  //List list = relDiarioService.listAllRDO();
	  model.addObject("listRdo", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("rdo/rdo_form");
	  
	  RelDiario relDiario = new RelDiario();
	  model.addObject("rdoForm", relDiario);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("rdo/rdo_form");
	  
	  RelDiario relDiario = relDiarioService.findRDOById(id);
	  model.addObject("rdoForm", relDiario);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("rdo_form") RelDiario relDiario){
	  
	  if(relDiario != null && relDiario.getId() != null){
		   relDiarioService.updateRDO(relDiario);
		  } else {
		   relDiarioService.addRDO(relDiario);
		  } 
	 
	  	return new ModelAndView("redirect:/rdo/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
  
	  relDiarioService.deleteRDO(id);;
	  	  
	  return new ModelAndView("redirect:/rdo/list");
	 }
	 
}
