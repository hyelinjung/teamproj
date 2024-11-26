package com.asklepios.hospitalreservation_asklepios.VO;

public class LikeVO {
    private String board_user_id;
    private boolean liked;
    private String board_sequence;
    private String like_id;

    public String getBoard_user_id() {
        return board_user_id;
    }

    public void setBoard_user_id(String board_user_id) {
        this.board_user_id = board_user_id;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getBoard_sequence() {
        return board_sequence;
    }

    public void setBoard_sequence(String board_sequence) {
        this.board_sequence = board_sequence;
    }

    public String getLike_id() {
        return like_id;
    }

    public void setLike_id(String like_id) {
        this.like_id = like_id;
    }
}
