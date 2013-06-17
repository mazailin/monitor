 package com.ruyicai.common.vo;
 
 public class CateSelector
 {
   private String html;
 
   public CateSelector(String name, String action, String optionname, String tabid, String[] names, String[] values)
   {
     StringBuilder sb = new StringBuilder();
     String select = "%s<select onchange=\"onSelectChange('%s','%s',this.value,'%s')\" >%s</select><li class=\"line\">line</li>";
     for (int i = 0; i < names.length; ++i) {
       sb.append(String.format("<option value='%s'>%s</option>", new Object[] { values[i], names[i] }));
     }
 
     this.html = String.format(select, new Object[] { name, action, optionname, tabid, sb.toString() });
   }
 
   public String getHtml()
   {
     return this.html;
   }
 
   public void setHtml(String html) {
     this.html = html;
   }
 }
