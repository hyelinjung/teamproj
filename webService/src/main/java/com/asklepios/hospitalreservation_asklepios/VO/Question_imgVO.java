package com.asklepios.hospitalreservation_asklepios.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question_imgVO {
    private int img_question_id;
    private String fileName;
    private int question_id;
    private String origin;

//    추후에 빌더 사용
    public Question_imgVO(String fileName, int question_id, String origin) {
        this.fileName = fileName;
        this.question_id = question_id;
        this.origin = origin;
    }
}
