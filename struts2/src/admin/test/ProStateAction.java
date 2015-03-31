package admin.test;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.interceptor.SuperIbatis;

public class ProStateAction implements SuperIbatis {
	
	private SqlMapClient sqlMapper = null;
	private String result = "update";
	private String id;
	
	
	public String execute(){
		System.out.println(id);
		try {
			sqlMapper.update("pro.prostate", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;
	}

	
	
}
