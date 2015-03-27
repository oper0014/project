package admin.test;

import java.util.ArrayList;
import java.util.List;

import test.databean.CreateSubjectDTO;
import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/*
 * ���°���
 * */
public class CreateSubjectProAction implements SuperIbatis,Preparable,ModelDriven{
	private SqlMapClient sqlMapper;
	private CreateSubjectDTO dto;
	private List<SubjectDTO> stimeList=new ArrayList<SubjectDTO>();
	public String execute() throws Exception{
	
		System.out.println("DTO");
		System.out.println("getGrade:"+dto.getGrade());
		System.out.println("getSsection:"+dto.getSsection());
		System.out.println("getTerm:"+dto.getTerm());
		System.out.println("getYear:"+dto.getYear());
		System.out.println("dto.getSclass():"+dto.getSclass());
		
		//time test
		//int count=(Integer)sqlMapper.queryForObject("admin.classCheck", dto);
		stimeList=sqlMapper.queryForList("admin.classCheck", dto);
		System.out.println("result stimeList size:"+stimeList.size());
		//where sday=#sday#, sclass=#sclass#
		//count >0
		String[] result1 = dto.getSclass().trim().replaceAll(" ", "").split(",");//��û�ϴ� �ð���
		for (int i = 0; i < stimeList.size(); i++) {	
			String[] result2 = stimeList.get(i).getSclass().trim().replaceAll(" ", "").split(",");
			//db�� ����� ���� ��¥ ���� ������ �ð���
			for (int j = 0; j < result1.length; j++) {
				for (int j2 = 0; j2 < result2.length; j2++) {
					if(result1[j].equals(result2[j2])){//��
						return "duplicate";//�ߺ�
					}
				}
			}
		}
		//�ش� ���ǽ� ���� ã��Integer.valueOf("123");
		int max=Integer.parseInt((String) sqlMapper.queryForObject("admin.maxClass",dto.getSclass()));// sqlMapper.queryForObject("admin.maxClass",dto.getSclass());
		//���� ��
		if(dto.getMax()<0 || dto.getMax()>max){
			return "maxerror";
		}
		
		//add subject
		sqlMapper.insert("admin.insertSubject", dto);
		

		return "success";
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
		dto=new CreateSubjectDTO();		//dto�� �����ϸ� ���Թ޴°͵�
	}
}
