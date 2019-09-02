package com.hshbic.ai.enums.knowledge;

public enum KnowledgeResCode {
	 SUCCESS("操作成功", "0000"), //
	 DEL_FAIL("删除数据失败", "0001"), //
	 UPDATE_FAIL("修改数据失败", "0002"), //
	 INSERT_FAIL("写入数据失败", "0003"), //
	 SQL_FAIL("获取数据库客户端失败", "0004"), //
	 IMPORT_FAIL("导入数据中错误信息", "0005"), //
	 VAIL_FAIL("数据检验，问题超出50或者答案超出300", "0006");
    // 成员变量  
	public final String name;  
	public final String code;  
    // 构造方法  
    private KnowledgeResCode(String name, String code) {  
        this.name = name;  
        this.code = code;  
    }  
    //覆盖方法  
    @Override  
    public String toString() {  
        return this.code+"_"+this.name;  
    }  


}
