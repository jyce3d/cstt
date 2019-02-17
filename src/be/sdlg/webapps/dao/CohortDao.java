package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.ArmToSeg;
import be.sdlg.webapps.model.Cohort;


@Repository
public class CohortDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, armtoseg_id, study_id, code, description, predecessor_id, bc_interval_, bc_after_event_id, bc_target_event_id from cohorts ";
	private class CohortRowMapper implements RowMapper<Cohort> {

		@Override
		public Cohort mapRow(ResultSet rs, int rowCount) throws SQLException {
			Cohort cohort= new Cohort();
			cohort.id = rs.getLong(1);
			cohort.armToSegId = rs.getLong(2);
			cohort.studyId = rs.getLong(3);
			cohort.code = rs.getString(4);
			cohort.Description = rs.getString(5);
			cohort.predecessorId = rs.getLong(6);
			cohort.bcInterval = rs.getFloat(7);
			cohort.bcAfterEventId = rs.getLong(8);
			cohort.bcTargetEventId = rs.getLong(9);
			return cohort;
		}
	}
	public List<Cohort> findByStudyId(String id) {
		List<Cohort> queryForObject = (List<Cohort>) jdbcTemplate.query(strSqlSelect + " where study_id in (?) ",
	               new Object[] { id }, new CohortRowMapper());
		return queryForObject;
	    
	}
	public List<Cohort> findByArmToSegId(Long id) {
		List<Cohort> queryForObject = (List<Cohort>) jdbcTemplate.query(strSqlSelect + " where armtoseg_id in (?) ",
	               new Object[] { id }, new CohortRowMapper());
		return queryForObject;

	}
}
