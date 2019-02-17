package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.WeeklyCalendar;



@Repository
public class WeeklyCalendarDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, site_id, day_of_week, closed from weekly_calendar ";
	private class WeeklyCalendarRowMapper implements RowMapper<WeeklyCalendar> {
		@Override
		public WeeklyCalendar mapRow(ResultSet rs, int rowCount) throws SQLException {
			WeeklyCalendar wkCalendar = new WeeklyCalendar();
			wkCalendar.id = rs.getLong(1);
			wkCalendar.siteId = rs.getLong(2);
			wkCalendar.dayOfWeek = rs.getInt(3);
			wkCalendar.closed = rs.getInt(4);
			return wkCalendar;
		}
	}
	public List<WeeklyCalendar> findBySiteIds(String ids) {
		List<WeeklyCalendar> queryForObject = (List<WeeklyCalendar>) jdbcTemplate.query(strSqlSelect + " where site_id in (?) ",
	               new Object[] { ids }, new WeeklyCalendarRowMapper());
		return queryForObject;
	    
	}
}
