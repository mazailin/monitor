package com.ruyicai.systemmanage.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//@Entity
//@Table(name = "sys_user")
public class User implements UserDetails, java.io.Serializable {
	private static final long serialVersionUID = 5677668216199325571L;
	private static final short MAX_FAILED_LOGIN_ATTEMPTS = 3;
	@Id
    @GeneratedValue
   	@Column(name = "id")
	private long id;
	/**
	 * 用户名
	 */
	@Column(name = "name")
	private String name;
	
 	@Column(name = "loginName")
    private String loginname;   

   	@Column(name = "password")
    private String password;   

   	@Column(name = "description")
    private String description;   

   	@Column(name = "workID")
    private String workid;   

   	@Column(name = "groupID")
    private Integer groupid;   

   	@Column(name = "STATE")
    private Integer state;   

   	@Column(name = "INTIME")
    private java.util.Date intime;   

   	@Column(name = "BEGINTIME")
    private java.util.Date begintime;   

   	@Column(name = "ENDTIME")
    private java.util.Date endtime;   

   	@Column(name = "CALLNO")
    private String callno;   

   	@Column(name = "AGCTYPE")
    private Integer agctype;   

   	@Column(name = "CALLCOUNT")
    private Integer callcount;   

   	@Column(name = "AGCLINENO")
    private Integer agclineno;   

	// @ManyToOne
	// private Role role;
	@Column(name = "role_id")
	private String roleId;

	/**
	 * An attribute to track the number of failed login attempts
	 */
	@Transient
	private int failedLoginAttempts;

	/**
	 * 权限
	 */
	@Transient
	private Collection<GrantedAuthority> authorities;
	/**
	 * 账号未过期
	 */
	@Transient
	private boolean accountNonExpired = true;
	/**
	 * 账号未锁定
	 */
	@Transient
	private boolean accountNonLocked = true;
	/**
	 * 证书未过期
	 */
	@Transient
	private boolean credentialsNonExpired = true;
	/**
	 * 是否启用
	 */
	@Transient
	private boolean enabled = true;
	/**
	 * 登录IP
	 */
	@Transient
	private String login_ip;
	/**
	 * 登录时间
	 */
	@Transient
	private Date login_time;
	/**
	 * 数据库中登录历史ID
	 */
	@Transient
	private int login_history_id;
	/**
	 * 用户是否已填完基本信息
	 */
	@Transient
	private boolean info_integrated;
	public User(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String role) {
		this.roleId = role;
	}

	
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Transient 
	public String getUsername() {
		return name;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		if (this.state>1||this.getFailedLoginAttempts() >= MAX_FAILED_LOGIN_ATTEMPTS) {
			return false;
		}
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(boolean enabled) {
		this.enabled=enabled;
	}

	/**
	 * @return the login_ip
	 */
	@Transient 
	public String getLogin_ip() {
		return login_ip;
	}

	/**
	 * @param login_ip
	 *            the login_ip to set
	 */
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	/**
	 * @return the login_time
	 */
	@Transient 
	public Date getLogin_time() {
		return login_time;
	}

	/**
	 * @param login_time
	 *            the login_time to set
	 */
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	/**
	 * @return the login_history_id
	 */
	@Transient 
	public int getLogin_history_id() {
		return login_history_id;
	}

	/**
	 * @param login_history_id
	 *            the login_history_id to set
	 */
	public void setLogin_history_id(int login_history_id) {
		this.login_history_id = login_history_id;
	}

	/**
	 * @return the info_integrated
	 */
	public boolean isInfo_integrated() {
		return info_integrated;
	}

	/**
	 * @param info_integrated
	 *            the info_integrated to set
	 */
	public void setInfo_integrated(boolean info_integrated) {
		this.info_integrated = info_integrated;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.name = username;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param accountNonExpired
	 *            the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked
	 *            the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired
	 *            the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	@Transient 
	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWorkid() {
		return workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public java.util.Date getIntime() {
		return intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public java.util.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.util.Date begintime) {
		this.begintime = begintime;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public Integer getAgctype() {
		return agctype;
	}

	public void setAgctype(Integer agctype) {
		this.agctype = agctype;
	}

	public Integer getCallcount() {
		return callcount;
	}

	public void setCallcount(Integer callcount) {
		this.callcount = callcount;
	}

	public Integer getAgclineno() {
		return agclineno;
	}

	public void setAgclineno(Integer agclineno) {
		this.agclineno = agclineno;
	}
	public String toString(ToStringStyle style) {
		return new ToStringBuilder(this, style)
            .append("id", getId())
            .append("name", getName())
            .append("loginName", getLoginname())
            .append("password", getPassword())
            .append("description", getDescription())
            .append("workID", getWorkid())
            .append("groupID", getGroupid())
            .append("STATE", getState())
            .append("INTIME", getIntime())
            .append("BEGINTIME", getBegintime())
            .append("ENDTIME", getEndtime())
            .append("CALLNO", getCallno())
            .append("AGCTYPE", getAgctype())
            .append("CALLCOUNT", getCallcount())
            .append("AGCLINENO", getAgclineno())
            .append("role_id", getRoleId())
            .toString();
	}
}
