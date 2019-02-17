package be.sdlg.webapps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.sdlg.webapps.model.Study;

@Repository
public class StudyDao {
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public static final String strSqlSelect  = "select l.id, l.code, l.name, l.description, l.start_date, r.count from studies l inner join (select id, count(*) as count from users group by id) r on l.id = r.id ";
	private class StudyRowMapper implements RowMapper<Study> {

		@Override
		public Study mapRow(ResultSet rs, int rowCount) throws SQLException {
     	   Study study = new Study();
     	   try {
     		   study.id = rs.getLong(1);
     		   study.code = rs.getString(2);
     		   study.name = rs.getString(3);
     		   study.description = rs.getString(4);
     		   study.startDate = rs.getDate(5);
     		   study.patientCount = rs.getLong(6);
     	   }catch (SQLException e) {
     			e.printStackTrace();
      	   }
 		   return study;
		}
		
	}
	public List<Study> findByIds(String ids) {
		List<Study> queryForObject = (List<Study>) jdbcTemplate.query(strSqlSelect + " where l.id in (?) ",
	               new Object[] { ids }, new StudyRowMapper());
		return queryForObject;
	    
	}
	public Study findOne(Long id) {
		Object queryForObject = jdbcTemplate.queryForObject(strSqlSelect + " where l.id = ? ",
	               new Object[] { id }, new StudyRowMapper());
		return  (Study) queryForObject;
	    
	}

	public List<Study> findAll() {
		List<Study> queryForObject = (List<Study>) jdbcTemplate.query(strSqlSelect , new StudyRowMapper());
		return queryForObject;
	    
	}

}
