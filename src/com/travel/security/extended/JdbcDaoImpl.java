package com.travel.security.extended;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContextException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class JdbcDaoImpl extends JdbcDaoSupport implements UserDetailsService {

	protected MappingSqlQuery<GrantedAuthority> authoritiesByUsernameMapping;

	protected MappingSqlQuery<UserDetails> usersByUsernameMapping;

	private String usersByUsernameQuery;

	private boolean usernameBasedPrimaryKey = true;

	private String authoritiesByUsernameQuery;

	private String rolePrefix = "";

	/**
	 * @return the rolePrefix
	 */
	public String getRolePrefix() {
		return rolePrefix;
	}

	/**
	 * @param rolePrefix the rolePrefix to set
	 */
	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

	public JdbcDaoImpl() {

	}

	protected void initDao() throws ApplicationContextException {
		initMappingSqlQueries();
	}

	/**
	 * Extension point to allow other MappingSqlQuery objects to be substituted
	 * in a subclass
	 */
	@SuppressWarnings("unchecked")
	protected void initMappingSqlQueries() {
		this.usersByUsernameMapping = new UsersByUsernameMapping(getDataSource());
		this.authoritiesByUsernameMapping = new AuthoritiesByUsernameMapping(getDataSource());
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		List<UserDetails> users = usersByUsernameMapping.execute(username);

		if (users.size() == 0) {
			throw new UsernameNotFoundException("User not found");
		}

		UserDetails user = (UserDetails) users.get(0); 

		List<GrantedAuthority> dbAuths = authoritiesByUsernameMapping.execute(user.getUsername());

		addCustomAuthorities(user.getUsername(), dbAuths);

		if (dbAuths.size() == 0) {
			throw new UsernameNotFoundException("User has no GrantedAuthority");
		}

		String returnUsername = user.getUsername();

		if (!usernameBasedPrimaryKey) {
			returnUsername = username;
		}

		return new User(returnUsername, user.getPassword(), user.isEnabled(), true, true, true, dbAuths);
	}

	@SuppressWarnings("unchecked")
	protected void addCustomAuthorities(String username, List authorities) {
	}

	/**
	 * @return the usersByUsernameQuery
	 */
	public String getUsersByUsernameQuery() {
		return usersByUsernameQuery;
	}

	/**
	 * @param usersByUsernameQuery the usersByUsernameQuery to set
	 */
	public void setUsersByUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
	}

	/**
	 * @return the usernameBasedPrimaryKey
	 */
	public boolean isUsernameBasedPrimaryKey() {
		return usernameBasedPrimaryKey;
	}

	/**
	 * @param usernameBasedPrimaryKey the usernameBasedPrimaryKey to set
	 */
	public void setUsernameBasedPrimaryKey(boolean usernameBasedPrimaryKey) {
		this.usernameBasedPrimaryKey = usernameBasedPrimaryKey;
	}

	/**
	 * @return the authoritiesByUsernameQuery
	 */
	public String getAuthoritiesByUsernameQuery() {
		return authoritiesByUsernameQuery;
	}

	/**
	 * @param authoritiesByUsernameQuery the authoritiesByUsernameQuery to set
	 */
	public void setAuthoritiesByUsernameQuery(String authoritiesByUsernameQuery) {
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
	}

	/**
	 * Query object to look up a user's authorities.
	 */
	@SuppressWarnings("unchecked")
	protected class AuthoritiesByUsernameMapping extends MappingSqlQuery {
		protected AuthoritiesByUsernameMapping(DataSource ds) {
			super(ds, authoritiesByUsernameQuery);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		@SuppressWarnings("deprecation")
		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			String roleName = rolePrefix + rs.getString(2);
			GrantedAuthority authority = new GrantedAuthorityImpl(roleName);
			return authority;
		}
	}

	/**
	 * Query object to look up a user.
	 */
	@SuppressWarnings("unchecked")
	protected class UsersByUsernameMapping extends MappingSqlQuery {
		protected UsersByUsernameMapping(DataSource ds) {
			super(ds, usersByUsernameQuery);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		@SuppressWarnings("deprecation")
		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			String username = rs.getString(1);
			String password = rs.getString(2);
			String isActive = rs.getString(3);
			boolean enabled = false;
			if("Y".equals(isActive)){
				enabled = true;
			}
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			auths.add(new GrantedAuthorityImpl("HOLDER"));
			UserDetails user = new User(username, password, enabled, true, true, true, auths);

			return user;
		}
	}
}
