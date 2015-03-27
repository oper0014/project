package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.databean.ClassroomDTO;
import test.databean.SerSubjectDTO;
import test.databean.SubjectDTO;
import test.databean.stSearchDTO;
import test.interceptor.SuperIbatis;

/*
 * 占쏙옙占승검삼옙 占쏙옙占쏙옙
 * */
public class CreateSubjectAction implements SuperIbatis,Preparable,ModelDriven{
	private SqlMapClient sqlMapper;
	private List<SubjectDTO> list = new ArrayList<SubjectDTO>();
	private List<MemberDTO> list2 = new ArrayList<MemberDTO>();
	private List<ClassroomDTO> list3 = new ArrayList<ClassroomDTO>();
	private SerSubjectDTO dto;
	public String execute() throws Exception{

		System.out.println("占쏙옙占쏙옙講占� DTO");
		System.out.println("getGrade:"+dto.getGrade());
		System.out.println("getTerm:"+dto.getTerm());
		System.out.println("getYear:"+dto.getYear());
		list2 = sqlMapper.queryForList("admin.professorall");//List professor
		list3 = sqlMapper.queryForList("admin.classroomAll");//List classroom
		
		try {
			if(dto.getTerm()==null){
				dto.setTerm("All");
			}
			if(dto.getGrade()==null){
				dto.setGrade("All");
			}
			if(dto.getTerm().equals("All")){
				if(dto.getGrade().equals("All")){
					list = sqlMapper.queryForList("admin.subjectSer1",dto);//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙
				}else{
					list = sqlMapper.queryForList("admin.subjectSer2",dto);//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙
				}
				
			}else{
				if(dto.getGrade().equals("All")){
					list = sqlMapper.queryForList("admin.subjectSer3",dto);//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙
				}else{
					list = sqlMapper.queryForList("admin.subjectSer4",dto);//占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙
				}	
			}
			
			
			
		} catch (Exception e) {e.printStackTrace();}
		
		String result ="success";
		return result;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new SerSubjectDTO();		//dto占쏙옙 占쏙옙占쏙옙占싹몌옙 占쏙옙占쌉받는것듸옙
	}
	public List<SubjectDTO> getList() {
		return list;
	}
	public List<MemberDTO> getList2() {
		return list2;
	}
	public List<ClassroomDTO> getList3() {
		return list3;
	}
	
}
