package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.Country;


@Repository
public class CountryDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, code, label from countries ";
	private class CountryRowMapper implements RowMapper<Country> {

		@Override
		public Country mapRow(ResultSet rs, int rowCount) throws SQLException {
			Country country = new Country();
			country.id = rs.getLong(1);
			country.code = rs.getString(2);
			country.label = rs.getString(3);
			return country;
		}
	}
	public List<Country> findAll() {
		List<Country> queryForObject = (List<Country>) jdbcTemplate.query(strSqlSelect , new CountryRowMapper());
		return queryForObject;
	    
	}
}
