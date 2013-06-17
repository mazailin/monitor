package com.ruyicai.systemmanage.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "sys_role_resource")
public class RoleResource implements Serializable {
	private static final long serialVersionUID = -6440111319590885401L;
	@Id
	@Column(name = "role_id", unique = false, nullable = false, insertable = true, updatable = true)
	private long role_id;
	@Id
	@Column(name = "resource_id", unique = false, nullable = false, insertable = true, updatable = true)
	private long resource_id;

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	public long getResource_id() {
		return resource_id;
	}

	public void setResource_id(long resource_id) {
		this.resource_id = resource_id;
	}

}
