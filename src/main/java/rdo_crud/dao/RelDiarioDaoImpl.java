package rdo_crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import rdo_crud.model.RelDiario;

@Repository
public class RelDiarioDaoImpl implements RelDiarioDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
		throws DataAccessException{
			  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		}
	
	public List<RelDiario> listAllRDO() {
	//public List listAllRDO() {
		  String sql = "SELECT id, id_cliente, id_obra, data_rel, hora_rel"
		  		+ ", atividade_executada, status_rel FROM rel_diario";
		  
		  List<RelDiario> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new RDOMapper());
		  //List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new RDOMapper());
		  
		  return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(RelDiario rdo){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(rdo != null){
		   parameterSource.addValue("id", rdo.getId());
		   parameterSource.addValue("id_cliente", rdo.getId_cliente());
		   parameterSource.addValue("id_obra", rdo.getId_obra());
		   parameterSource.addValue("data_rel", rdo.getData_rel());
		   parameterSource.addValue("hora_rel", rdo.getHora_rel());
		   parameterSource.addValue("atividade_executada", rdo.getAtividade_executada());
		   parameterSource.addValue("status_rel", rdo.getStatus_rel());
		  }
		  return parameterSource;
		 }
	
	private static final class RDOMapper implements RowMapper<RelDiario>{

		//@SuppressWarnings("unused")
		public RelDiario mapRow(ResultSet rs, int rowNum) throws SQLException {
		   RelDiario rdo = new RelDiario();
		   rdo.setId(rs.getInt("id"));
		   rdo.setId_cliente(rs.getString("id_cliente"));
		   rdo.setId_obra(rs.getString("id_obra"));
		   rdo.setData_rel(rs.getString("data_rel"));
		   rdo.setHora_rel(rs.getString("hora_rel"));
		   rdo.setAtividade_executada(rs.getString("atividade_executada"));
		   rdo.setStatus_rel(rs.getString("status_rel"));
		   
		   return rdo;
		  }
		  
	}
	
	public void addRDO(RelDiario rdo) {
		String sql = "INSERT INTO rel_diario(id_cliente, id_obra, data_rel,hora_rel,atividade_executada,status_rel)"
		  		+ "VALUES(:id_cliente, :id_obra, :data_rel, :hora_rel, :atividade_executada, :status_rel)";
				    
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(rdo));
		
	}

	public void updateRDO(RelDiario rdo) {
		String sql = "UPDATE rel_diario SET id_cliente = :id_cliente, id_obra = :id_obra,data_rel = :data_rel"
				+ ", hora_rel = :hora_rel, atividade_executada = :atividade_executada, status_rel = :status_rel  WHERE id = :id";
				  
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(rdo));
		
	}

	public void deleteRDO(int id) {
		  String sql = "DELETE FROM rel_diario WHERE id = :id";
		  
		  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new RelDiario(id)));
		
	}

	public RelDiario findRDOById(int id) {
		  String sql = "SELECT * FROM rel_diario WHERE id = :id";
		  
		  return namedParameterJdbcTemplate
		.queryForObject(sql, getSqlParameterByModel(new RelDiario(id)), new RDOMapper());
	}

}
