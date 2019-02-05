package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.User;

@Repository
public class UserDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public static final String strSqlSelect  = "SELECT u.id, u.username, u.password, u.enabled, u.role_id, a.authority FROM users u inner join authorities a on u.role_id = a.id";
	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowCount) throws SQLException {
     	   User usr = new User();
     	   try {
     		   usr.id = rs.getLong(1);
     		   usr.userName = rs.getString(2);
     		   usr.password = rs.getString(3);
     		   usr.enabled = rs.getLong(4);
     		   usr.roleId = rs.getLong(5);
     		   usr.roleName = rs.getString(6);
     	   }catch (SQLException e) {
     			e.printStackTrace();
      	   }
 		   return usr;
		}
		
	}
	
	public User findOne(long id) {
		Object queryForObject = jdbcTemplate.queryForObject(strSqlSelect + " where u.id = ? ",
	               new Object[] { id }, new UserRowMapper());
		return  (User) queryForObject;
	    
	}
	
	public void delete(Long id) {
	       jdbcTemplate.update("DELETE users WHERE id = ? ", id);
	}
	public void save(User user) {
		if (user.id == null) {
			jdbcTemplate.update("insert into users(username,password, enabled, role_id) VALUES(?,?,?,?)",
					user.userName, user.password, user.enabled, user.roleId);
		} else {
			jdbcTemplate.update("update users set username=?; password=?, enabled=?, role_id=? where id=?",
					user.userName, user.password, user.enabled, user.roleId,user.id);
			
		}
	} 
	
	public List<User> findByIds(String ids) {
		List<User> queryForObject = (List<User>) jdbcTemplate.query(strSqlSelect + " where u.id in (?) ",
	               new Object[] { ids }, new UserRowMapper());
		return queryForObject;
	    
	}
	
}
