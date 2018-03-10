package rdo_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rdo_crud.dao.RelDiarioDao;
import rdo_crud.model.RelDiario;


@Service
public class RelDiarioServiceImpl implements RelDiarioService {

	RelDiarioDao relDiarioDao;
	
	@Autowired
	public void setRelDiarioDao(RelDiarioDao relDiarioDao) {
		this.relDiarioDao = relDiarioDao;
	}

	public List<RelDiario> listAllRDO() {
	//public List listAllRDO() {
		return relDiarioDao.listAllRDO();
	}

	public void addRDO(RelDiario rdo) {
		relDiarioDao.addRDO(rdo);
	}

	public void updateRDO(RelDiario rdo) {
		relDiarioDao.updateRDO(rdo);	
	}

	public void deleteRDO(int id) {
		relDiarioDao.deleteRDO(id);
	}

	public RelDiario findRDOById(int id) {
		return relDiarioDao.findRDOById(id);
	}

}
