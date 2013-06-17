 package com.ruyicai.common.vo;
 
 public class LiTag
 {
   private ATag a;
   private UlTag ul;
 
   public LiTag()
   {
   }
 
   public LiTag(ATag dwza, UlTag dwzul)
   {
     this.a = dwza;
     this.ul = dwzul;
   }
 
   public ATag getA() {
     return this.a;
   }
 
   public void setA(ATag dwza) {
     this.a = dwza;
   }
 
   public UlTag getUl() {
     return this.ul;
   }
 
   public void setUl(UlTag dwzul) {
     this.ul = dwzul;
   }
 
   public String toString()
   {
     StringBuilder sb = new StringBuilder();
     sb.append("<li>");
     if (this.a != null) {
       sb.append(this.a.toString());
     }
     if (this.ul != null) {
       sb.append(this.ul.toString());
     }
     sb.append("</li>");
     return sb.toString();
   }
 }

