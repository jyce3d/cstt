package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.CountryCalendar;


@Repository
public class CountryCalendarDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, country_id, label, closed_date from country_calendar ";
	private class CountryCalendarRowMapper implements RowMapper<CountryCalendar> {

		@Override
		public CountryCalendar mapRow(ResultSet rs, int rowCount) throws SQLException {
			CountryCalendar countryCalendar = new CountryCalendar();
			countryCalendar.id = rs.getLong(1);
			countryCalendar.countryId = rs.getLong(2);
			countryCalendar.label = rs.getString(3);
			countryCalendar.closedDate = rs.getDate(4);
			return countryCalendar;
		}
	}
	public List<CountryCalendar> findAll() {
		List<CountryCalendar> queryForObject = (List<CountryCalendar>) jdbcTemplate.query(strSqlSelect , new CountryCalendarRowMapper());
		return queryForObject;
	    
	}
	public List<CountryCalendar> findByIds(String id) {
		List<CountryCalendar> queryForObject = (List<CountryCalendar>) jdbcTemplate.query(strSqlSelect + " where id in (?) ",
	               new Object[] { id }, new CountryCalendarRowMapper());
		return queryForObject;
	    
	}

}
