package com.anurag.wordservice.demo.dto;

public class WordRequest {
    private int count;
    private String sorting;
    private String text;
    
    public WordRequest(int count, String sorting, String text) {
		super();
		this.count = count;
		this.sorting = sorting;
		this.text = text;
	}
    
    public WordRequest() {
		super();
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSorting() {
		return sorting;
	}
	public void setSorting(String sorting) {
		this.sorting = sorting;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

    
}
