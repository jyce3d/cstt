package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.Segment;


@Repository
public class SegmentDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, code, description from segments  ";
	private class SegmentRowMapper implements RowMapper<Segment> {

		@Override
		public Segment mapRow(ResultSet rs, int rowCount) throws SQLException {
			Segment seg = new Segment();
			seg.id = rs.getLong(1);
			seg.segmentCode = rs.getString(2);
			seg.segmentDescription = rs.getString(3);
			return seg;
		}
	}
	public List<Segment> findAll() {
		List<Segment> queryForObject = (List<Segment>) jdbcTemplate.query(strSqlSelect , new SegmentRowMapper());
		return queryForObject;
	    
	}

}
