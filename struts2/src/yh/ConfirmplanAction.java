package yh;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;
import yh.pagingAction;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ConfirmplanAction implements Preparable,ModelDriven,SuperIbatis {	//윤호 - 해당과목 조회
	public static Reader reader;
	public static SqlMapClient sqlMapper_sub;
	private SubjectDTO dto=null;
	private Map sessionMap=null;
	private int totalSubject;
	private int currentPage = 1;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	private List<SubjectDTO> sub_list = new ArrayList<SubjectDTO>();
	private SqlMapClient sqlMapper;
	
	public ConfirmplanAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper_sub = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	public String execute()throws Exception{
		sub_list = sqlMapper_sub.queryForList("selectTwo");
		totalSubject = sub_list.size();
		page = new pagingAction(currentPage, totalSubject, blockCount, blockPage); // pagingAction 객체 생성.
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalSubject;
		
		if(page.getEndCount() < totalSubject)
			lastCount = page.getBlockCount() + 1;
		
		sub_list = sub_list.subList(page.getStartCount(), lastCount);
		return "success";
	}

	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new SubjectDTO();		//dto를 제외하면 주입받는것들
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper_sub=sqlMapper;
		}
}
