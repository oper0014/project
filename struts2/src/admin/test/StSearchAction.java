package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.action.MemberDTO;
import test.board.pagingAction;
import test.databean.MajorDTO;
import test.databean.stSearchDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class StSearchAction implements SuperIbatis,Preparable,ModelDriven {
	private SqlMapClient sqlMapper;
	private List<MajorDTO> list = new ArrayList<MajorDTO>();
	
	private String major;//�˻��� �а�
	private String grade;
	private int gender;
	private String state;
	private stSearchDTO dto=null;
	
	private int flag2;
	private List<MemberDTO> list2 = new ArrayList<MemberDTO>();
	private List<MemberDTO> list3 = new ArrayList<MemberDTO>();
	private List<MemberDTO> list4 = new ArrayList<MemberDTO>();
	private List<MemberDTO> list5 = new ArrayList<MemberDTO>();
	private List<MemberDTO> list6 = new ArrayList<MemberDTO>();
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private pagingAction page; 	// ����¡ Ŭ����
	private String grade_selected;//
	private String state_selected2;//����ó��
	private String state_selected1;//����ó��
	private String chk_info;//üũ�ڽ�
	
	public String execute() throws SQLException{
		
		
		
		list = sqlMapper.queryForList("board.selectMajorAll");//�а� ��� ������
		System.out.println("selectMajor:"+dto.getMajor());
		System.out.println("selectGrade:"+dto.getGrade());
		System.out.println("selectGender:"+dto.getGender());
		System.out.println("selectState:"+dto.getState());
		try{
		
		if(dto.getMajor().equals("All") ){
			if(dto.getGender()==0){
				if(dto.getGrade().equals("All"))
					list2 = sqlMapper.queryForList("admin.stall3a",dto);
				else
					list2 = sqlMapper.queryForList("admin.stall3",dto);
			}
			else{
				if(dto.getGrade().equals("All"))
					list2 = sqlMapper.queryForList("admin.stall2a",dto);
				else
					list2 = sqlMapper.queryForList("admin.stall2",dto);
			}
		}
		else{
			if(dto.getGender()==0){
				if(dto.getGrade().equals("All"))
					list2 = sqlMapper.queryForList("admin.stall4a",dto);
				else
					list2 = sqlMapper.queryForList("admin.stall4",dto);
			}
			else{
				if(dto.getGrade().equals("All"))
					list2 = sqlMapper.queryForList("admin.stalla",dto);
				else
					list2 = sqlMapper.queryForList("admin.stall",dto);	
			}	
		}
		
		totalCount = list2.size(); // ��ü �� ������ ���Ѵ�.
		System.out.println("totalCount:::::"+totalCount);
		
			if(flag2==1){
				
				String[] result = chk_info.trim().replaceAll(" ", "").split(",");
				
				for (int j = 0; j < result.length; j++) {
					System.out.println(result[j]);
					
					if(state_selected2 == null ){}//����ó��
					else{
						System.out.println("����");
						sqlMapper.update("admin.st_update3b", result[j]);
						dto.setState("1");
					}
					if(state_selected1 == null ){}//����ó��
					else{System.out.println("����");
						sqlMapper.update("admin.st_update3a", result[j]);
						dto.setState("2");
					}
					if(grade_selected == null ){}//�г��
					else{
						String gradeinfor=(String)sqlMapper.queryForObject("admin.selectGrade",result[j]);
						
						if(gradeinfor.equals("1�г�"))
							{sqlMapper.update("admin.st_update2a", result[j]);	
							dto.setGrade("2�г�");
							}
						else if(gradeinfor.equals("2�г�"))
							{sqlMapper.update("admin.st_update2b", result[j]);	
							dto.setGrade("3�г�");
							}
						else if(gradeinfor.equals("3�г�"))
							{sqlMapper.update("admin.st_update2c", result[j]);
							dto.setGrade("4�г�");
							}
					}//else					
				}//for
				
				if(dto.getMajor().equals("All") ){list2 = sqlMapper.queryForList("admin.stall2",dto);}
				else{list2 = sqlMapper.queryForList("admin.stall",dto);}
			}
			
			/*
			page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
			pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

			// ���� ���������� ������ ������ ���� ��ȣ ����.
			int lastCount = totalCount;

			// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
			list2 = list2.subList(page.getStartCount(), lastCount);
			 */
		}catch(Exception e){}
		String result2 ="success";
		return result2;
	}
	public List<MajorDTO> getList() {
		return list;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	
	public List<MemberDTO> getList2() {
		return list2;
	}

	public void setList2(List<MemberDTO> list2) {
		this.list2 = list2;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}
	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new stSearchDTO();		//dto�� �����ϸ� ���Թ޴°͵�
	}
	public stSearchDTO getDto() {
		return dto;
	}
	public void setDto(stSearchDTO dto) {
		this.dto = dto;
	}
	public int getFlag2() {
		return flag2;
	}
	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}
	public void setState_selected1(String state_selected1) {
		this.state_selected1 = state_selected1;
	}
	public void setState_selected2(String state_selected2) {
		this.state_selected2 = state_selected2;
	}
	public void setGrade_selected(String grade_selected) {
		this.grade_selected = grade_selected;
	}
	public void setChk_info(String chk_info) {
		this.chk_info = chk_info;
	}
	
}
