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
	
	private String major;//占싯삼옙占쏙옙 占싻곤옙
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
	private int currentPage = 1;	//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	private int totalCount; 		// 占쏙옙 占쌉시뱄옙占쏙옙 占쏙옙
	private int blockCount = 10;	// 占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙  占쌉시뱄옙占쏙옙 占쏙옙
	private int blockPage = 5; 	// 占쏙옙 화占썽에 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙
	private String pagingHtml; 	//占쏙옙占쏙옙징占쏙옙 占쏙옙占쏙옙占쏙옙 HTML
	private pagingAction page; 	// 占쏙옙占쏙옙징 클占쏙옙占쏙옙
	private String grade_selected;//
	private String state_selected2;//占쏙옙占쏙옙처占쏙옙
	private String state_selected1;//占쏙옙占쏙옙처占쏙옙
	private String chk_info;//체크占쌘쏙옙
	
	public String execute() throws SQLException{
		
		
		
		list = sqlMapper.queryForList("board.selectMajorAll");//占싻곤옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙
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
		
		totalCount = list2.size(); // 占쏙옙체 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占싼댐옙.
		System.out.println("totalCount:::::"+totalCount);
		System.out.println("flag2:::::"+flag2);
			if(flag2==1){
				
				String[] result = chk_info.trim().replaceAll(" ", "").split(",");
				//System.out.println("result"+result);
				
				for (int j = 0; j < result.length; j++) {
					System.out.println(result[j]);
					System.out.println("grade_selected"+grade_selected);
					System.out.println("state_selected1"+state_selected1);
					System.out.println("state_selected2"+state_selected2);
					if(state_selected2.equals("복학처리"))
					{
						System.out.println("복학처리");
						sqlMapper.update("admin.st_update3b", result[j]);
						dto.setState("1");
					}
					if(state_selected1.equals("휴학처리"))
					{System.out.println("휴학처리");
						sqlMapper.update("admin.st_update3a", result[j]);
						dto.setState("2");
					}
					if(grade_selected.equals("학년업"))
					{
						String gradeinfor=(String)sqlMapper.queryForObject("admin.selectGrade",result[j]);
						
						if(gradeinfor.equals("1학년"))
							{sqlMapper.update("admin.st_update2a", result[j]);	
							dto.setGrade("2학년");
							}
						else if(gradeinfor.equals("2학년"))
							{sqlMapper.update("admin.st_update2b", result[j]);	
							dto.setGrade("3학년");
							}
						else if(gradeinfor.equals("3학년"))
							{sqlMapper.update("admin.st_update2c", result[j]);
							dto.setGrade("4학년");
							}
					}//else					
				}//for
				
				if(dto.getMajor().equals("All") ){list2 = sqlMapper.queryForList("admin.stall2",dto);}
				else{list2 = sqlMapper.queryForList("admin.stall",dto);}
			}
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
		dto=new stSearchDTO();		//dto占쏙옙 占쏙옙占쏙옙占싹몌옙 占쏙옙占쌉받는것듸옙
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
