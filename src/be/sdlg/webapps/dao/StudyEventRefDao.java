package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.StudyEventRef;

@Repository
public class StudyEventRefDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, study_id, cohort_id, predecessor_id, site_id, study_event_model_ref_id, interval_, tol_low, tol_up, study_event_def_id FROM study_event_ref";
	private class StudyEventRefRowMapper implements RowMapper<StudyEventRef> {

		@Override
		public StudyEventRef mapRow(ResultSet rs, int rowCount) throws SQLException {
			StudyEventRef sr = new StudyEventRef();
			sr.id = rs.getLong(1);
			sr.studyId = rs.getLong(2);
			sr.cohortId = rs.getLong(3);
			sr.predecessorId = rs.getLong(4);
			sr.siteId = rs.getLong(5);
			sr.studyEventModelRefId = rs.getLong(6);
			sr.interval = rs.getFloat(7);
			sr.tolLow = rs.getFloat(8);
			sr.tolUp = rs.getFloat(9);
			sr.studyEventDefId = rs.getLong(10);

			return sr;
		}
	}
	public List<StudyEventRef> findByStudyId(String id) {
		List<StudyEventRef> queryForObject = (List<StudyEventRef>) jdbcTemplate.query(strSqlSelect + " where study_id in (?) ",
	               new Object[] { id }, new StudyEventRefRowMapper());
		return queryForObject;
	    
	}
}
