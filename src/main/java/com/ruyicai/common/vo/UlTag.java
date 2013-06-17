 package com.ruyicai.common.vo;
 
 import java.util.Iterator;
 import java.util.List;
 
 public class UlTag
 {
   private String clazz;
   private List<LiTag> li;
 
   public UlTag()
   {
   }
 
   public UlTag(String clazz, List<LiTag> liList)
   {
     this.li = liList;
     this.clazz = clazz;
   }
 
   public List<LiTag> getLi() {
     return this.li;
   }
 
   public void setLi(List<LiTag> liList) {
     this.li = liList;
   }
 
   public String getClazz() {
     return this.clazz;
   }
 
   public void setClazz(String clazz) {
     this.clazz = clazz;
   }
 
   public String toString()
   {
     StringBuilder sb = new StringBuilder();
     if ((this.li != null) && (this.li.size() > 0)) {
       if ((this.clazz == null) || ("".equals(this.clazz))) {
         sb.append("<ul>");
       } else {
         sb.append("<ul class=\"");
         sb.append(this.clazz).append("\">");
       }
 
       for (Iterator it = this.li.iterator(); it.hasNext(); ) {
         sb.append(((LiTag)it.next()).toString());
       }
 
       sb.append("</ul>");
     }
     return sb.toString();
   }
 }

