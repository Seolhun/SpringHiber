package com.shun.blog.model.common;

import lombok.Data;

@Data
public class Paging {
	// 참조할 때의 엔티티 키 값
	private Long id;
	
	// 게시판 종류
	private String tableName;
	private String kind;
	private String pfName;
	private String entityName;
	
	// 현재 페이지
	private int currentPage;
	// 페이지 제한 수
	private int limit;
	
	private String question;
	// 검색 종류 설정
	private int searchType;
	// 검색어
	private String searchText;
	// 게시판 날짜 검색용
	private int searchDate;
	
	// 총 게시물 갯수
	private int totalCount;
	// 총 페이지 갯수
	private int totalPage;
	
	// 총 페이지 블록 수
	private int totalBlock;
	// 페이지 블록 제한 수
	private int blockLimit;
	// 현재 블록 위치
	private int currentBlock;
	// 게시물 시작 블록번호
	private int blockStartNo;
	// 게시물 끝 블록번호
	private int blockEndNo;
	
	private int prev_cPage;
	private int next_cPage;

	public Paging() {

	}
	
	public Paging(int cPage, int searchType, String searchText, int searchDate, int limit, String kind, String pfName){
		this.currentPage = cPage;
		this.searchType = searchType;
		this.searchText = question;
		this.searchDate=searchDate;
		this.kind=kind;
		this.limit = limit;
	}

	public Paging(int cPage, int searchType, String searchText, int searchDatesDate, int limit) {
		this.currentPage = cPage;
		this.searchType = searchType;
		this.searchText = searchText;
		this.limit = limit;
		this.searchDate = searchDatesDate;
	}

	public Paging(int currentPage, int searchType, String searchText, int searchDate, int limit, String tableName) {
		this.currentPage = currentPage;
		this.searchType = searchType;
		this.searchText = searchText;
		this.searchDate = searchDate;
		this.limit = limit;
		this.tableName = tableName;
	}
}