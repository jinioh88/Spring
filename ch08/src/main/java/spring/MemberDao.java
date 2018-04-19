package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSouce) {
		this.jdbcTemplate = new JdbcTemplate(dataSouce);
	}
	
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query("select * from member where email=?", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("email"),rs.getString("password"),rs.getString("name"),rs.getTimestamp("regdate"));
				member.setId(rs.getLong("id"));
				return member;
			}
			
		},email);
		return result.isEmpty()? null:result.get(0);
	}
	
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query("select *from member", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("email"),rs.getString("password"),rs.getString("name"),
						rs.getTimestamp("regdate"));
				member.setId(rs.getLong("id"));
				return member;
			}
		});
		return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		return count;
	}
	
	public void update(Member member) {
		jdbcTemplate.update("update member set name=?, password=? where email=?",member.getName(),
				member.getPassword(),member.getEmail());
	}
	
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into member(email,password,name,regdate) "
																+"values(?,?,?,?)",new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				return pstmt;
			}
		},keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
}
