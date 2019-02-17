package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.Arm;

@Repository
public class ArmDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, code, description from arms  ";
	private class ArmRowMapper implements RowMapper<Arm> {

		@Override
		public Arm mapRow(ResultSet rs, int rowCount) throws SQLException {
			Arm arm = new Arm();
			arm.id = rs.getLong(1);
			arm.armCode = rs.getString(2);
			arm.armDescription = rs.getString(3);
			return arm;
		}
	}
	public List<Arm> findAll() {
		List<Arm> queryForObject = (List<Arm>) jdbcTemplate.query(strSqlSelect , new ArmRowMapper());
		return queryForObject;
	    
	}

		
}
