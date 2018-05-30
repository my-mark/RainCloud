package com.junsheng.community.poss.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * Created by liwei on 2016/5/9.
 */
public class Page<T> implements java.io.Serializable {

    //-- 分页参数 --//
    protected Integer pageNum = 1;
    protected Integer pageSize = -1;
    protected Integer pages = 1;

    //-- 返回结果 --//
    protected List<T> list = new ArrayList<>();
    protected Integer totalCount = -1;

    //-- 构造函数 --//
    public Page() {
    }

    public Page(int pageNum, int pageSize , int pages, long totalCount, List<T> data){
        this.pageNum=pageNum;
        if (pageNum < 1) {
            this.pageNum = 1;
        }
        this.pageSize = new Integer(pageSize);
        this.pages = new Integer(pages);
        this.totalCount = new Integer((int) totalCount);
		list.clear();
		list.addAll(data);
    }

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}



   
}