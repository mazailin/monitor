
package com.ruyicai.systemmanage.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
/**
 * SysRoleBean is a mapping of sys_role Table.
 * @author tianshangjun
*/
//@Entity
//@Table(name = "sys_role")
public class SysRoleBean
    implements Serializable
{
	private static final long serialVersionUID = -1651448211086630411L;
	
   	@Id
    @GeneratedValue
   	@Column(name = "id")
    private Long id;   

   	@Column(name = "name")
    private String name;   

   	@Column(name = "description")
    private String description;   


    /**
     * Prefered methods to create a SysRoleBean is via the createSysRoleBean method in SysRoleManager or
     * via the factory class SysRoleFactory create method
     */
    public SysRoleBean()
    {
    }

    /**
     * Getter method for id.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sys_role.id</li>
     * <li>comments: 唯一索引</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.BIGINT</li>
     * </ul>
     *
     * @return the value of id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Setter method for id.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to id
     */
    public void setId(Long id)
    {

        this.id = id;
       
    }
    /**
     * Getter method for name.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sys_role.name</li>
     * <li>comments: 角色姓名</li>
     * <li>column size: 50</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter method for name.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to name
     */
    public void setName(String name)
    {

        this.name = name;
       
    }
    /**
     * Getter method for description.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sys_role.description</li>
     * <li>comments: 描述</li>
     * <li>column size: 255</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Setter method for description.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to description
     */
    public void setDescription(String description)
    {

        this.description = description;
       
    }
 

    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(SysRoleBean bean)
    {
        setId(bean.getId());
        setName(bean.getName());
        setDescription(bean.getDescription());
    }

    /**
     * return a dictionnary of the object
     */
	@JsonIgnore 
    public Map<String,String> getDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        dictionnary.put("name", getName() == null ? "" : getName().toString());
        dictionnary.put("description", getDescription() == null ? "" : getDescription().toString());
        return dictionnary;
    }

    /**
     * return a dictionnary of the pk columns
     */
	@JsonIgnore 
    public Map<String,String> getPkDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        return dictionnary;
    }

    /**
     * return a the value string representation of the given field
     */
    public String getValue(String column)
    {
        if (null == column || "".equals(column)) {
            return "";
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            return getId() == null ? "" : getId().toString();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? "" : getName().toString();
        } else if ("description".equalsIgnoreCase(column) || "description".equalsIgnoreCase(column)) {
            return getDescription() == null ? "" : getDescription().toString();
        }
        return "";
    }

    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof SysRoleBean)) {
			return false;
		}

		SysRoleBean obj = (SysRoleBean) object;
		return new EqualsBuilder()
            .append(getId(), obj.getId())
            .append(getName(), obj.getName())
            .append(getDescription(), obj.getDescription())
            .isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
            .append(getId())
            .append(getName())
            .append(getDescription())
            .toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
	    return toString(ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * you can use the following styles:
	 * <li>ToStringStyle.DEFAULT_STYLE</li>
	 * <li>ToStringStyle.MULTI_LINE_STYLE</li>
     * <li>ToStringStyle.NO_FIELD_NAMES_STYLE</li>
     * <li>ToStringStyle.SHORT_PREFIX_STYLE</li>
     * <li>ToStringStyle.SIMPLE_STYLE</li>
	 */
	public String toString(ToStringStyle style) {
		return new ToStringBuilder(this, style)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .toString();
	}


    public int compareTo(Object object)
    {
        SysRoleBean obj = (SysRoleBean) object;
        return new CompareToBuilder()
            .append(getId(), obj.getId())
            .append(getName(), obj.getName())
            .append(getDescription(), obj.getDescription())
            .toComparison();
   }
}
