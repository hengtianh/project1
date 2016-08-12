package com.maker.utils;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {
	private int pageSize = 5;
	private int pageIndex = 1;
	private int pageCount;
	private int recordCount;
	int size = 5;
	private int[] pages;
	
	private List<T> list = new ArrayList<>();
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount() {
		this.pageCount = (recordCount-1)/pageSize+1;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int[] getPages() {
		if(pageCount>=size){
			pages = new int[size];
			for(int i=1; i<=5; i++){
				pages[i-1] = pageIndex-size+i+(size-1)/2;//5-2  5-1 5-0 5+1 5+2  (size-1)/2
			}
		}else{
			pages = new int[pageCount];
			for(int i=0; i<pageCount; i++){
				pages[i] = i+1;
			}
		}
		return pages;
	}
	public void setPages(int[] pages) {
		this.pages = pages;
	}
	
}
