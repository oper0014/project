package admin.test;

import java.util.ArrayList;
import java.util.List;

import test.databean.ClassroomDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;


public class CreateclassroomAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private int flag2;
	private String croom;
	private String cmax;
	private String chk_info;
	private String class_selected;
	private List<ClassroomDTO> list = new ArrayList<ClassroomDTO>();
	//private SerSubjectDTO dto;
	
	public String execute() throws Exception{
		
		try{
		if(flag2==1){//flag2가 1이면 강의실 추가 insert
			System.out.println("classroom add");
			ClassroomDTO dto= new ClassroomDTO();
			dto.setCmax(cmax);
			dto.setCroom(croom);
			sqlMapper.update("admin.classroomUpdate", dto);
		}
		if(class_selected.equals("delete")){// 강의실 삭제
			System.out.println("classroom delete");
			String[] result = chk_info.trim().replaceAll(" ", "").split(",");
			for (int i = 0; i < result.length; i++) {
				sqlMapper.update("admin.classroomDelete",Integer.parseInt( result[i]));	
			}
			
			
		}
		}catch(Exception e){}
		//강의실 목록 받아오기
		list = sqlMapper.queryForList("admin.classroomAll");
		
		return "success";
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	public List<ClassroomDTO> getList() {
		return list;
	}
	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}
	public void setClass_selected(String class_selected) {
		this.class_selected = class_selected;
	}
	public void setCroom(String croom) {
		this.croom = croom;
	}
	public void setCmax(String cmax) {
		this.cmax = cmax;
	}
	public void setChk_info(String chk_info) {
		this.chk_info = chk_info;
	}
	
	
}
