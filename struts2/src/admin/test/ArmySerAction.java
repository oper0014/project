package admin.test;

import java.util.ArrayList;
import java.util.List;

import pjs.ArmyDTO;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.databean.ArmySerDTO;
import test.interceptor.SuperIbatis;
/*
 * 군입영 처리 
 * 서동우
 */
public class ArmySerAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private ArmySerDTO dto;
	private int flag2;
	private int state;
	private String chk_info;//체크박스
	private List<ArmyDTO> list = new ArrayList<ArmyDTO>();
	public String execute() throws Exception{
	
		System.out.println("flag2:"+flag2);
		System.out.println("state"+state);
		if(flag2==1){
			list = sqlMapper.queryForList("admin.armyall",state);//군입영 목록 가져옴
		}
		else if(flag2==2){
		System.out.println("chk_info"+chk_info);
		String[] result = chk_info.trim().replaceAll(" ", "").split(",");//공백제거뒤 ,로 끊어서 배열에 저장
			for (int j = 0; j < result.length; j++) {
				sqlMapper.update("admin.updatearmy", result[j]);//처리상태로
				sqlMapper.update("admin.updatearmy2", result[j]);//휴학상태를 3으로 군휴학
			}
			//list = sqlMapper.queryForList("admin.armyser",dto);//군입영 목록 가져옴

		}
		
		
		return "success";
	}
	
	public void setChk_info(String chk_info) {
		this.chk_info = chk_info;
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	public List<ArmyDTO> getList() {
		return list;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}
	

}
