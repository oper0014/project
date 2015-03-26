package test.interceptor;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface SuperIbatis {
	public void setIbatis(SqlMapClient sqlMapper);

}
