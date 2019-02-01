package be.sdlg.webapps.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.User;

@Repository
public class UserDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	/*public User findOne(long id) {
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		Object queryForObject = jdbcTemplate.queryForObject("SELECT u.*, a.* FROM users u inner join authorities a on u.role_id = a.id where id = ? ",
	               new Object[] { id }, new <Insert row mapper here>);
		return  (User) queryForObject;
	    
	}*/
	
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
	
	/*public List<User> findByIds(String ids) {
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		Object queryForObject = jdbcTemplate.queryForObject("SELECT u.*, a.* FROM users u inner join authorities a on u.role_id = a.id where id in (?) ",
	               new Object[] { id }, new <Insert row mapper here>);
	}*/
	
}
