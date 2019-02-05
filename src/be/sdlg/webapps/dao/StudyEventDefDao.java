package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.StudyEventDef;


@Repository
public class StudyEventDefDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, code, description  from study_event_def";
	private class StudyEventDefRowMapper implements RowMapper<StudyEventDef> {

		@Override
		public StudyEventDef mapRow(ResultSet rs, int rowCount) throws SQLException {
			StudyEventDef sd = new StudyEventDef();
				sd.id=rs.getLong(1);
				sd.code = rs.getString(2);
				sd.description = rs.getString(3);
			return sd;
		}
	}
	public List<StudyEventDef> findAll() {
		List<StudyEventDef> queryForObject = (List<StudyEventDef>) jdbcTemplate.query(strSqlSelect , new StudyEventDefRowMapper());
		return queryForObject;
	}
}
