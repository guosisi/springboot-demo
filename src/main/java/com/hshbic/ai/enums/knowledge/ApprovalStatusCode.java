package com.hshbic.ai.enums.knowledge;

public enum ApprovalStatusCode {
	 Draft("草稿", "0"), //
	 UHome("待优家审核", "1"), //
	 Industry("待产业审核", "2"), //
	 Final("审核通过", "3");
   // 成员变量  
	public final String name;  
	public final String code;  
   // 构造方法  
   private ApprovalStatusCode(String name, String code) {  
       this.name = name;  
       this.code = code;  
   }  
   //覆盖方法  
   @Override  
   public String toString() {  
       return this.code+"_"+this.name;  
   }  

}
