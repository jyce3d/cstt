package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.CohortRange;

@Repository
public class CohortRangeDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, cohort_id, begin, end, interval_, after_event_id, target_event_id from cohort_ranges ";
	private class CohortRangeRowMapper implements RowMapper<CohortRange> {

		@Override
		public CohortRange mapRow(ResultSet rs, int rowCount) throws SQLException {
			CohortRange cohortRange= new CohortRange();
			cohortRange.id = rs.getLong(1);
			cohortRange.cohortId =rs.getLong(2);
			cohortRange.begin = rs.getInt(3);
			cohortRange.end = rs.getInt(4);
			cohortRange.interval = rs.getFloat(5);
			cohortRange.afterEventId = rs.getLong(6);
			cohortRange.targetEventId = rs.getLong(7);
			return cohortRange;
		}
	}

	public List<CohortRange> findByCohortId(Long id) {
		List<CohortRange> queryForObject = (List<CohortRange>) jdbcTemplate.query(strSqlSelect + " where cohort_id in (?) ",
	               new Object[] { id }, new CohortRangeRowMapper());
		return queryForObject;
	    
	}

}
