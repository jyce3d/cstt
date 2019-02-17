package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.SiteCalendar;



@Repository
public class SiteCalendarDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, site_id, date, status from site_calendar ";
	private class SiteCalendarRowMapper implements RowMapper<SiteCalendar> {
		@Override
		public SiteCalendar mapRow(ResultSet rs, int rowCount) throws SQLException {
			SiteCalendar sc = new SiteCalendar();
			sc.id = rs.getLong(1);
			sc.siteId = rs.getLong(2);
			sc.date = rs.getDate(3);
			sc.status = rs.getInt(4);
			return sc;
		}


	}
	public List<SiteCalendar> findAll() {
		List<SiteCalendar> queryForObject = (List<SiteCalendar>) jdbcTemplate.query(strSqlSelect , new SiteCalendarRowMapper());
		return queryForObject;
	}
	public List<SiteCalendar> findByIds(String id) {
		List<SiteCalendar> queryForObject = (List<SiteCalendar>) jdbcTemplate.query(strSqlSelect + " where id in (?) ",
	               new Object[] { id }, new SiteCalendarRowMapper());
		return queryForObject;
	    
	}

}
