package com.interframe.system.web.vo;

import java.util.ArrayList;
import java.util.List;

/**
* TODO easyui datagrid组件数据封装
* @ClassName: DataGrid
* @author jason
 */
public class DataGrid<T> {
	
	private long total;
	private List<T> rows;
	
	public void addRow(T obj){
		if(rows == null)
			rows = new ArrayList<T>();
		rows.add(obj);
	}
	
	public void addAllRow(List<T> list){
		if(list != null){
			if(rows != null){
				rows.addAll(list);
			}
			else
				this.rows = list;
		}
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		if(rows == null){
			rows = new ArrayList<T>(); 
		}
		this.rows = rows;
	}
	
	
}
