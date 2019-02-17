package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.Arm;
import be.sdlg.webapps.model.ArmToSeg;
import be.sdlg.webapps.model.Segment;

@Repository
public class ArmToSegDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, study_id, segment_id, arm_id, ratio, predecessor_id FROM lnksegtoarms ";
	private class ArmToSegRowMapper implements RowMapper<ArmToSeg> {

		@Override
		public ArmToSeg mapRow(ResultSet rs, int rowCount) throws SQLException {
			ArmToSeg armToSeg = new ArmToSeg();
			armToSeg.id = rs.getLong(1);
			armToSeg.studyId = rs.getLong(2);
			armToSeg.segmentId = rs.getLong(3);
			armToSeg.armId = rs.getLong(4);
			armToSeg.ratio = rs.getFloat(5);
			armToSeg.predecessorId = rs.getLong(6);
			
			
			return armToSeg;
		}
	}
	public List<ArmToSeg> findByStudyId(Long id) {
		List<ArmToSeg> queryForObject = (List<ArmToSeg>) jdbcTemplate.query(strSqlSelect + " where study_id in (?) ",
	               new Object[] { id }, new ArmToSegRowMapper());
		return queryForObject;
	    
	}
	
}
