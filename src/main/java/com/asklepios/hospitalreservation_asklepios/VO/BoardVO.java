package com.asklepios.hospitalreservation_asklepios.VO;

public class BoardVO {
    private String board_sequence=null;
    private String board_user_id=null;
    private String board_category=null;
    private String board_title=null;
    private String board_content=null;
    private String board_binary=null;
    private String board_viewcount=null;
    private String board_date=null;
    private String board_goodcount=null;

    @Override
    public String toString() {
        return "BoardVO{" +
                "board_sequence='" + board_sequence + '\'' +
                ", board_user_id='" + board_user_id + '\'' +
                ", board_category='" + board_category + '\'' +
                ", board_title='" + board_title + '\'' +
                ", board_content='" + board_content + '\'' +
                ", board_binary='" + board_binary + '\'' +
                ", board_viewcount='" + board_viewcount + '\'' +
                ", board_date='" + board_date + '\'' +
                ", board_goodcount='" + board_goodcount + '\'' +
                '}';
    }

    public String getBoard_sequence() {
        return board_sequence;
    }

    public void setBoard_sequence(String board_sequence) {
        this.board_sequence = board_sequence;
    }

    public String getBoard_user_id() {
        return board_user_id;
    }

    public void setBoard_user_id(String board_user_id) {
        this.board_user_id = board_user_id;
    }

    public String getBoard_category() {
        return board_category;
    }

    public void setBoard_category(String board_category) {
        this.board_category = board_category;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getBoard_binary() {
        return board_binary;
    }

    public void setBoard_binary(String board_binary) {
        this.board_binary = board_binary;
    }

    public String getBoard_viewcount() {
        return board_viewcount;
    }

    public void setBoard_viewcount(String board_viewcount) {
        this.board_viewcount = board_viewcount;
    }

    public String getBoard_date() {
        return board_date;
    }

    public void setBoard_date(String board_date) {
        this.board_date = board_date;
    }

    public String getBoard_goodcount() {
        return board_goodcount;
    }

    public void setBoard_goodcount(String board_goodcount) {
        this.board_goodcount = board_goodcount;
    }
}
