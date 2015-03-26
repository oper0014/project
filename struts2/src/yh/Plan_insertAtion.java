package yh;


import test.databean.class_planDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Plan_insertAtion implements SuperIbatis, ModelDriven, Preparable{
	public static SqlMapClient sqlMapper;
	private class_planDTO dto = null;
	public String exectue(){
		return "success";
	}

	public void prepare() throws Exception {

	}

	public Object getModel() {

		return null;
	}

	public void setIbatis(SqlMapClient sqlMapper) {
		
	}

}
