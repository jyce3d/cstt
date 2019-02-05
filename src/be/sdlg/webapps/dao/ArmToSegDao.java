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
	
	public static final String strSqlSelect  = "SELECT  stoa.study_id, s.id as segment_id, s.code, s.description, a.id as arm_id, a.code, a.description, stoa.ratio FROM\r\n" + 
			"lnksegtoarms stoa INNER JOIN segments s on stoa.segment_id = s.id\r\n" + 
			"INNER JOIN arms a on stoa.arm_id = a.id ";
	private class ArmToSegRowMapper implements RowMapper<ArmToSeg> {

		@Override
		public ArmToSeg mapRow(ResultSet rs, int rowCount) throws SQLException {
			ArmToSeg armToSeg = new ArmToSeg();
			armToSeg.studyId = rs.getLong(1);
			armToSeg.segmentId = rs.getLong(2);
			armToSeg.armId = rs.getLong(5);
			armToSeg.ratio = rs.getFloat(8);
			Arm arm =new Arm();
			arm.id = rs.getLong(5);
			arm.armCode = rs.getString(6);
			arm.armDescription = rs.getString(7);
			armToSeg.arm = arm;
			
			Segment segment = new Segment();
			segment.id = rs.getLong(2);
			segment.segmentCode = rs.getString(3);
			segment.segmentDescription = rs.getString(4);
			armToSeg.segment = segment;
			
			return armToSeg;
		}
	}
	public List<ArmToSeg> findByStudyId(String id) {
		List<ArmToSeg> queryForObject = (List<ArmToSeg>) jdbcTemplate.query(strSqlSelect + " where stoa.study_id in (?) ",
	               new Object[] { id }, new ArmToSegRowMapper());
		return queryForObject;
	    
	}
	
}
