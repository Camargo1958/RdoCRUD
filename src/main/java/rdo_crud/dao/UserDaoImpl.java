package rdo_crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import rdo_crud.model.User;

/**
 * @author Aldrovando
 * Version 2.0
 */
@Repository
public class UserDaoImpl implements UserDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
		throws DataAccessException{
			  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		}
	
	public List<User> listAllUsers() {
		  String sql = "SELECT id, user_name, email, password, function"
		  		+ ", cust_lic, lic_val, cust_name FROM users";
		  
		  List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		  
		  return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(User user){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(user != null){
		   parameterSource.addValue("id", user.getId());
		   parameterSource.addValue("user_name", user.getUser_name());
		   parameterSource.addValue("email", user.getEmail());
		   parameterSource.addValue("password", user.getPassword());
		   parameterSource.addValue("function", user.getFunction());
		   parameterSource.addValue("cust_lic", user.getCust_lic());
		   parameterSource.addValue("lic_val", user.getLic_val());
		   parameterSource.addValue("cust_name", user.getCust_name());
		  }
		  return parameterSource;
		 }
	
	private static final class UserMapper implements RowMapper<User>{

		//@SuppressWarnings("unused")
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User user = new User();
		   user.setId(rs.getInt("id"));
		   user.setUser_name(rs.getString("user_name"));
		   user.setEmail(rs.getString("email"));
		   user.setPassword(rs.getString("password"));
		   user.setFunction(rs.getString("function"));
		   user.setCust_lic(rs.getString("cust_lic"));
		   user.setLic_val(rs.getInt("lic_val"));		   
		   user.setCust_name(rs.getString("cust_name"));
		   
		   return user;
		  }
		  
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO users(user_name, email, password,function,cust_lic,lic_val,cust_name)"
		  		+ "VALUES(:user_name, :email, :password, :function, :cust_lic, :lic_val, :cust_name)";
				    
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
		
	}
	
	public void updateUser(User user) {
		String sql = "UPDATE users SET user_name = :user_name, email = :email,password = :password"
				+ ", function = :function, cust_lic = :cust_lic, lic_val = :lic_val, cust_name = :cust_name  WHERE id = :id";
				  
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
		
	}
	
	public void deleteUser(int id) {
		  String sql = "DELETE FROM users WHERE id = :id";
		  
		  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));
		
	}
	
	/* (non-Javadoc)
	 * @see rdo_crud.dao.UserDao#findUserById(int)
	 */
	public User findUserById(int id) {
		  String sql = "SELECT * FROM users WHERE id = :id";
		  //System.out.println("SQL: "+sql);
		  
		  User user1 = new User("Invalid");
		  
		  try
		  {
			  return namedParameterJdbcTemplate
			.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());
		  }
		  catch (EmptyResultDataAccessException e)
		  {
			  return user1;
		  }
	}
	
	public User findUserByName(String user_name) {
		  String sql = "SELECT * FROM users WHERE user_name = :user_name";
		  //System.out.println("user_name = "+ user_name);
		  //System.out.println("SQL: "+sql);
		  
		  User user1 = new User("Invalid");
		  
		  try
		  {
			  return namedParameterJdbcTemplate
			.queryForObject(sql, getSqlParameterByModel(new User(user_name)), new UserMapper());
		  }
		  catch (EmptyResultDataAccessException e)
		  {
			  return user1;
		  }
		  
	}
	
	
}
