package admin.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.databean.CreateSubjectDTO;
import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;

public class UpdateSubjectAction implements SuperIbatis,Preparable,ModelDriven{
	//private String snumber;
	private String flag2;
	private SqlMapClient sqlMapper;
	private SubjectDTO dto;
	public String execute() throws Exception{
		//System.out.println("UpdateSubjectAction :snumber:"+snumber);
		System.out.println("dto :snumber:"+dto.getSnumber());
		System.out.println("flag2 :flag2:"+flag2);
		if(flag2.equals("0")){
			dto=(SubjectDTO)sqlMapper.queryForObject("admin.subjectOne", dto.getSnumber());
		}
		else if(flag2.equals("1")){
			
			System.out.println(dto.getCount());
			System.out.println(dto.getGrade());
			System.out.println(dto.getMax());
			System.out.println(dto.getProid());
			System.out.println(dto.getSclass());
			System.out.println(dto.getSsection());
			System.out.println(dto.getSname());
			sqlMapper.update("admin.updatesubjectOne", dto);
		}
		else if(flag2.equals("2")){
			sqlMapper.update("admin.deletesubjectOne", dto.getSnumber());
			return "delete";
		}

		String result ="success";
		return result;
	}
	
	
	
	
	public SubjectDTO getDto() {
		return dto;
	}
	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new SubjectDTO();		//dto�� �����ϸ� ���Թ޴°͵�
	}


	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	
}
