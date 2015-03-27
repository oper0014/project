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
 * ���Կ� ó�� 
 * ������
 */
public class ArmySerAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private ArmySerDTO dto;
	private int flag2;
	private int state;
	private String chk_info;//üũ�ڽ�
	private List<ArmyDTO> list = new ArrayList<ArmyDTO>();
	public String execute() throws Exception{
	
		System.out.println("flag2:"+flag2);
		System.out.println("state"+state);
		if(flag2==1){
			list = sqlMapper.queryForList("admin.armyall",state);//���Կ� ��� ������
		}
		else if(flag2==2){
		System.out.println("chk_info"+chk_info);
		String[] result = chk_info.trim().replaceAll(" ", "").split(",");//�������ŵ� ,�� ��� �迭�� ����
			for (int j = 0; j < result.length; j++) {
				sqlMapper.update("admin.updatearmy", result[j]);//ó�����·�
				sqlMapper.update("admin.updatearmy2", result[j]);//���л��¸� 3���� ������
			}
			//list = sqlMapper.queryForList("admin.armyser",dto);//���Կ� ��� ������

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
