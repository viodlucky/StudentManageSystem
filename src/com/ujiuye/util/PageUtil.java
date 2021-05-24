package com.ujiuye.util;

public class PageUtil {
    private int page;
    private int rows;
    private int index;
    private int countRows;
    private int countPage;
    private int prevPage;
    private int nextPage;

    public PageUtil(String page,int countRows){
        this.rows = 5;
        this.countRows = countRows;
        init_page(page);
        init_index();
        init_countPage();
        init_prevPage();
        init_nextPage();
    }

    private void init_page(String page){
        if (page == null || "".equals(page)){
            this.page = 1;
        }else {
            this.page = Integer.parseInt(page);
        }
    }

    private void init_index(){
        this.index = (this.page-1) * this.rows;
    }

    private void init_countPage(){
        int mod = this.countRows % this.rows;
        if (mod == 0){
            this.countPage = this.countRows / this.rows;
        }else {
            this.countPage = this.countRows / this.rows + 1;
        }
    }

    private void init_prevPage(){
        if (this.page == 1){
            this.prevPage = 1;
        }else {
            this.prevPage = this.page - 1;
        }
    }

    private void init_nextPage(){
        if (this.page == this.countPage){
            this.nextPage = this.countPage;
        }else {
            this.nextPage = this.page + 1;
        }
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPage() {
        return countPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }
}
