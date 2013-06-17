 package com.ruyicai.common.vo;
 
 public class Accordion
 {
   private String name;
   private UlTag ul;
 
   public Accordion()
   {
   }
 
   public Accordion(String name, UlTag ul)
   {
     this.name = name;
     this.ul = ul;
   }
   public String getName() {
     return this.name;
   }
 
   public void setName(String name) {
     this.name = name;
   }
 
   public UlTag getUl() {
     return this.ul;
   }
 
   public void setUl(UlTag ul) {
     this.ul = ul;
   }
 
   public String toString() {
     String format = "<div class = \"trendsTree\"><div class=\"accordionHeader\"><h2><span>Folder</span>%s</h2></div><div class=\"accordionContent\">%s</div></div>";
     if (this.name == null) {
       this.name = "";
     }
     if (this.ul == null) {
       return String.format(format, new Object[] { this.name, "" });
     }
     return String.format(format, new Object[] { this.name, this.ul.toString() });
   }
 }

