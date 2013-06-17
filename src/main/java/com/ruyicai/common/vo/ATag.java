 package com.ruyicai.common.vo;
 
 import java.lang.reflect.Method;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.utils.ReflectUtil;
import com.ruyicai.common.utils.ServerInitConfigUtil;
import com.ruyicai.common.utils.props.Props;
 
 public class ATag
 {
   private String tname;
   private Object tvalue;
   private boolean checked;
   private String target;
   private String width;
   private String height;
   private String rel;
   private String external;
   private String reloadFlag;
   private String href;
   private String value;
 
   public ATag()
   {
   }
 
   public ATag(String tname, Object tvalue, boolean checked, String target, String width, String height, String rel, String external, String reloadFlag, String href, String value)
   {
     this.tname = tname;
     this.tvalue = tvalue;
     this.checked = checked;
     this.target = target;
     this.width = width;
     this.height = height;
     this.rel = rel;
     this.external = external;
     this.reloadFlag = reloadFlag;
     this.href = href;
     this.value = value;
   }
 
   public String getTname()
   {
     return this.tname;
   }
 
   public void setTname(String tname) {
     this.tname = tname;
   }
 
   public Object getTvalue() {
     return this.tvalue;
   }
 
   public void setTvalue(Object tvalue) {
     this.tvalue = tvalue;
   }
 
   public boolean isChecked() {
     return this.checked;
   }
 
   public void setChecked(boolean checked) {
     this.checked = checked;
   }
 
   public String getValue() {
     return this.value;
   }
 
   public void setValue(String value) {
     this.value = value;
   }
 
   public String getTarget() {
     return this.target;
   }
 
   public void setTarget(String target) {
     this.target = target;
   }
 
   public String getWidth() {
     return this.width;
   }
 
   public void setWidth(String width) {
     this.width = width;
   }
 
   public String getHeight() {
     return this.height;
   }
 
   public void setHeight(String height) {
     this.height = height;
   }
 
   public String getRel() {
     return this.rel;
   }
 
   public void setRel(String rel) {
     this.rel = rel;
   }
 
   public String getExternal() {
     return this.external;
   }
 
   public void setExternal(String external) {
     this.external = external;
   }
 
   public String getReloadFlag() {
     return this.reloadFlag;
   }
 
   public void setReloadFlag(String reloadFlag) {
     this.reloadFlag = reloadFlag;
   }
 
   public String getHref() {
     if (this.href == null) {
       return null;
     }
     return ServerInitConfigUtil.BASE_URL + this.href;
   }
 
   public void setHref(String href) {
     this.href = href;
   }
 //<a href="<%=cxt %>/user/list" target="navTab" rel="userLiNav">用户管理</a>
   public String toString() {
     StringBuilder sb = new StringBuilder();
     try {
       sb.append("<a ");
       ReflectUtil ru = new ReflectUtil(this);
       String[] fieldsName = ru.getFieldsName();
       for (String name : fieldsName) {
         if (!"value".equals(name)) {
           Method m = ru.getGetter(name);
           if (m != null) {
             Object value = m.invoke(this, new Object[0]);
             if ((value != null) && (!"".equals(value))) {
               sb.append(" ").append(name).append("=\"");
               sb.append(m.invoke(this, new Object[0]));
               sb.append("\"");
             }
           }
         }
       }
 
       sb.append(">").append(getValue()).append("</a>");
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     return sb.toString();
   }
 }
