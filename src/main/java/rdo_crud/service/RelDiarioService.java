package rdo_crud.service;

import java.util.List;

import rdo_crud.model.RelDiario;


public interface RelDiarioService {
	
	public List<RelDiario> listAllRDO();
	//public List listAllRDO();
	
	public void addRDO(RelDiario rdo);
	
	public void updateRDO(RelDiario rdo);
	
	public void deleteRDO(int id);
	
	public RelDiario findRDOById(int id);
	
}
