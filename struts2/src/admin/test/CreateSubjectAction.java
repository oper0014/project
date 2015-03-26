package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.databean.SerSubjectDTO;
import test.databean.SubjectDTO;
import test.databean.stSearchDTO;
import test.interceptor.SuperIbatis;

/*
 * ���°˻� ����
 * */
public class CreateSubjectAction implements SuperIbatis,Preparable,ModelDriven{
	private SqlMapClient sqlMapper;
	private List<SubjectDTO> list = new ArrayList<SubjectDTO>();
	private List<MemberDTO> list2 = new ArrayList<MemberDTO>();
	private SerSubjectDTO dto;
	public String execute() throws Exception{

		System.out.println("����˻� DTO");
		System.out.println("getGrade:"+dto.getGrade());
		System.out.println("getTerm:"+dto.getTerm());
		System.out.println("getYear:"+dto.getYear());
		
		try {
			if(dto.getTerm().equals("All")){
				if(dto.getGrade().equals("All")){
					list = sqlMapper.queryForList("admin.subjectSer1",dto);//���� ��� ������
				}else{
					list = sqlMapper.queryForList("admin.subjectSer2",dto);//���� ��� ������
				}
				
			}else{
				if(dto.getGrade().equals("All")){
					list = sqlMapper.queryForList("admin.subjectSer3",dto);//���� ��� ������
				}else{
					list = sqlMapper.queryForList("admin.subjectSer4",dto);//���� ��� ������
				}	
			}
			
			list2 = sqlMapper.queryForList("admin.professorall");//�����̸� ��� ������
			
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
		dto=new SerSubjectDTO();		//dto�� �����ϸ� ���Թ޴°͵�
	}
	public List<SubjectDTO> getList() {
		return list;
	}
	public List<MemberDTO> getList2() {
		return list2;
	}
	
}
