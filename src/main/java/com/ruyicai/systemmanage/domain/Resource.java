package com.ruyicai.systemmanage.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

//@Entity
//@Table(name = "sys_resource")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

 	@Id
    @GeneratedValue
   	@Column(name = "id")
    private String id;   

   	@Column(name = "name")
    private String name;   

   	@Column(name = "path")
    private String path;   

   	@Column(name = "parent")
    private String parent;   

   	@Column(name = "params")
    private String params;   

   	@Column(name = "leaf")
    private boolean leaf; // 0.0;   

   	@Column(name = "iconCls")
    private String iconcls;   

   	@Column(name = "headermenu")
    private Integer headermenu =0; // 0.0;   

   	@Column(name = "displayorder")
    private Integer displayorder =100; // 100.0;   

   	@Column(name = "description")
    private String description;   

   	@Column(name = "target")
    private String target;   

   	@Column(name = "rel")
    private String rel;   

   	@Column(name = "reloadFlag")
    private String reloadflag;   

   	@Column(name = "external")
    private String external;   

   	@Column(name = "width")
    private Integer width;   

   	@Column(name = "height")
    private Integer height;  
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "parent")
	@OrderBy(value="displayorder asc")
	private List<Resource> children = new ArrayList<Resource>();

	public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public int getHeadermenu() {
		return headermenu;
	}

	public void setHeadermenu(int headermenu) {
		this.headermenu = headermenu;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getIconcls() {
		return iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getReloadflag() {
		return reloadflag;
	}

	public void setReloadflag(String reloadflag) {
		this.reloadflag = reloadflag;
	}

	public String getExternal() {
		return external;
	}

	public void setExternal(String external) {
		this.external = external;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setHeadermenu(Integer headermenu) {
		this.headermenu = headermenu;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	/*
	 * @ManyToMany(cascade = { CascadeType.REFRESH}, fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name = "role_resource", joinColumns = { @JoinColumn(name =
	 * "resource_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	 * private Set<Role> roles = new HashSet<Role>(0);
	 */

	/*
	 * public Set<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<Role> roles) { this.roles = roles; }
	 */
}
