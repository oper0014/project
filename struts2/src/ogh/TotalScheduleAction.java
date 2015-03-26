package ogh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;






import test.databean.TotalsubjectDTO;
import test.interceptor.SuperIbatis;


public class TotalScheduleAction implements Preparable,ModelDriven,SuperIbatis{

	
	private SqlMapClient sqlMapper = null;
	private List<TotalsubjectDTO> list = new ArrayList<TotalsubjectDTO>();
	String result ="success";
	private TotalsubjectDTO dto = null;
	
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;
	}
	
	public String execute(){	
		try{
			list=sqlMapper.queryForList("subject.selectAll");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public List getList(){
		return list;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
