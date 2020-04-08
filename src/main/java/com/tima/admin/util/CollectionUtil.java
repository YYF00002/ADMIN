package com.tima.admin.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.tima.admin.vo.TreeNodeVO;

/**
 * 集合(List,Map,Set)辅助类。
 * 
 * @date 2018年07月30日
 * @author YYF
 */
public class CollectionUtil {
	/**
	 * map根据KEY排序
	 * @param mapRes
	 * @return map
	 */
	public static Map<String, Object> sortMap(Map<String, Object> mapRes) {
		if (mapRes == null || mapRes.isEmpty()) {
			return null;
		}

		Map<String, Object> sortMap = new TreeMap<String, Object>(new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});

		sortMap.putAll(mapRes);

		return sortMap;
	}
	/**
	 * 按照muneCode属性去重
	 * @param list
	 * @return
	 */
	 public static List<TreeNodeVO> removeDuplicateTree(List<TreeNodeVO> list) {
	        Set<TreeNodeVO> set = new TreeSet<TreeNodeVO>(new Comparator<TreeNodeVO>() {
	            @Override
	            public int compare(TreeNodeVO o1, TreeNodeVO o2) {
	                //字符串,则按照asicc码升序排列
	                return o1.getMenuCode().compareTo(o2.getMenuCode());
	            }
	        });
	        set.addAll(list);
	        return new ArrayList<TreeNodeVO>(set);
	    }
}
