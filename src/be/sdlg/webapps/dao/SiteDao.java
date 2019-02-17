package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.Country;
import be.sdlg.webapps.model.Site;

@Repository
public class SiteDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static final String strSqlSelect  = "SELECT l.id, l.country_id, l.type_id, l.code, l.label, r.code, r.label from sites l inner join countries r on l.country_id = r.id ";
	private class SiteRowMapper implements RowMapper<Site> {

		@Override
		public Site mapRow(ResultSet rs, int rowCount) throws SQLException {
			Site site = new Site();
			site.id = rs.getLong(1);
			site.countryId = rs.getLong(2);
			site.typeId = rs.getLong(3);
			site.code = rs.getString(4);
			site.label = rs.getString(5);
			
			return site;
		}
	}
	public List<Site> findAll() {
		List<Site> queryForObject = (List<Site>) jdbcTemplate.query(strSqlSelect , new SiteRowMapper());
		return queryForObject;
	}
}
