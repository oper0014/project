package admin.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import test.action.MemberDTO;
/*
 * list 간 합집합 , 교집합
 * list - union,intersection
 * 
 * Seo Dongwoo
 * */
public class ListUtil {
	public <T> List<T> union(List<T> list1,List<T> list2){
		Set<T> set = new HashSet<T>();
		set.addAll(list1);
		set.addAll(list2);
		return new ArrayList<T>(set);
	}
	public <T> List<T> intersection(List<T> list1,List<T> list2){
		List<T> list = new ArrayList<T>();
		for(T t : list2){
			if(list2.contains(t)){
				list.add(t);
			}
		}
		return list;
	}
}
