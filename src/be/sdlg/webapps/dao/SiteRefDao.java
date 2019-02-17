package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.SiteRef;


@Repository
public class SiteRefDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT id, study_id, site_id from site_ref";
	private class SiteRefRowMapper implements RowMapper<SiteRef> {
		@Override
		public SiteRef mapRow(ResultSet rs, int rowCount) throws SQLException {
			SiteRef sr = new SiteRef();
			sr.id = rs.getLong(1);
			sr.studyId = rs.getLong(2);
			sr.siteId = rs.getLong(3);
			return sr;
		}
	}
	public List<SiteRef> findByStudyId(String id) {
		List<SiteRef> queryForObject = (List<SiteRef>) jdbcTemplate.query(strSqlSelect + " where study_id in (?) ",
	               new Object[] { id }, new SiteRefRowMapper());
		return queryForObject;
	    
	}
}
