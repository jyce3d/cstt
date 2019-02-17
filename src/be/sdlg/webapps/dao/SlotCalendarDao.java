package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.SlotCalendar;


@Repository
public class SlotCalendarDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT l.id, l.site_calendar_id, l.study_event_inst_id, l.site_ref_id, r.site_id from slot_calendar l inner join site_ref r on l.site_ref_id = r.id ";
	private class SlotCalendarRowMapper implements RowMapper<SlotCalendar> {
		@Override
		public SlotCalendar mapRow(ResultSet rs, int rowCount) throws SQLException {
			SlotCalendar slotCalendar = new SlotCalendar();
			slotCalendar.id = rs.getLong(1);
			slotCalendar.siteCalendarId = rs.getLong(2);
			slotCalendar.studyEventInstId = rs.getLong(3);
			slotCalendar.siteRefId= rs.getLong(4);
			return slotCalendar;
		}
	}
	public List<SlotCalendar> findBySiteIds(String id) {
		List<SlotCalendar> queryForObject = (List<SlotCalendar>) jdbcTemplate.query(strSqlSelect + " where r.site_id in (?) ",
	               new Object[] { id }, new SlotCalendarRowMapper());
		return queryForObject;
	    
	}

}
