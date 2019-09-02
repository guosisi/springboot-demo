package com.hshbic.ai.enums.common;

import java.util.HashMap;
import java.util.Map;

public enum SysDictEnums {
	 Industry("industry","产线列表", "industryCategory"), //
     Type_Of_Corpus("corpusType","语料类型", "typeOfCorpus") ;

   // 成员变量  
	public final String name;
	public final String des;
	public final String code;  
   // 构造方法  
   private SysDictEnums(String name, String des, String code) {
       this.name = name;
       this.des = des;
       this.code = code;  
   }
    public static final Map<String, String> TYPE_MAP = new HashMap<String, String>();
    static {
        for (SysDictEnums sysDict : SysDictEnums.values()) {
            TYPE_MAP.put(sysDict.name, sysDict.code);
        }
    }
   //覆盖方法  
   @Override  
   public String toString() {  
       return this.code+"_"+this.name+"_"+this.des;
   }  

}
