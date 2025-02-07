package com.asklepios.hospitalreservation_asklepios.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//질문 과 의사 답변vo client ->server
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionVO {
    private int id;
    private String title;
    private String content;
    private String date;
    private String tag;
    private String sub;
    private String user_id;

}
