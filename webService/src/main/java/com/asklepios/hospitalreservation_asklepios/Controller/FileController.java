package com.asklepios.hospitalreservation_asklepios.Controller;

import com.asklepios.hospitalreservation_asklepios.Service.QandAService;
import com.asklepios.hospitalreservation_asklepios.VO.QuestionVO;
import com.asklepios.hospitalreservation_asklepios.VO.QuestionlistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    private QandAService service;

    //질문이 입력
/*
    @PostMapping("/file_upload")
    @ResponseBody
    public ResponseEntity<String> file_upload(@RequestParam(value = "file",required = false)List<MultipartFile> file
            ,@ModelAttribute QuestionVO questionVO){

        //질문을 작성한 사용자 확인
        if (file==null || file.isEmpty()){
            boolean result =service.save_text(questionVO);
            return result ?ResponseEntity.ok().body("success"):ResponseEntity.badRequest().body("fail");
        }
        boolean result =service.save_text_w_img(file,questionVO);
        return result ?ResponseEntity.ok().body("success"):ResponseEntity.badRequest().body("fail");

    }
*/

   /* //답변 저장
    @PostMapping("/answer")
    @ResponseBody
    public ResponseEntity<String> answer_doctor(@ModelAttribute QuestionVO vo){
        String id = "lind99";
       boolean result = service.answer(vo,id);
       if (result){
           return ResponseEntity.ok().body("success");
       }
        return ResponseEntity.badRequest().body("fail");
    }
    //큐엔에이 리스트 가져오기
    @GetMapping("/qandaList")
    @ResponseBody
    public ResponseEntity<String> qandalist(){
        List<QuestionlistVO> list =service.getList();
        System.out.println(list);

        return ResponseEntity.ok().body("success");
    }
    //현재 사용자 구하기
    @GetMapping("/test")
    public void test(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String result = ((UserDetails) authentication.getPrincipal()).getUsername();
            System.out.println(result);
            //lin99
        }
    }

    //질문 자세히 보기
    @GetMapping("/show")
    public void show(int id){
        QuestionlistVO vo = service.showdeatil(id);
        System.out.println("시간확인"+vo.getDate());
        String date = vo.getDate();
        String result = getWrittenTime(date);
        System.out.print("전처리 시간"+result);
        vo.setDate(result);
        //의사답변 시간 전처리
        for(QuestionlistVO answer :vo.getAnswerlist()){
            String answer_date =answer.getDate();
            answer.setDate(getWrittenTime(answer_date));
        }
        System.out.println(vo);
    }

    //의사 답변 화면 - 질문 제목이 필요한 경우
    @GetMapping("/answerPage")
    public void answerPage(int questionId){
        String subject = service.getSubject(questionId);
        System.out.println(subject);
    }

//게시글 작성 시간과 현재 시간을 계산함
    String getWrittenTime(String db_date){

       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime formatted_date = LocalDateTime.parse(db_date,formatter);
       LocalDateTime current_time =LocalDateTime.now();
       Duration get_between_date = Duration.between(formatted_date,current_time);
       long day = get_between_date.toDays();
       long hour =get_between_date.toHours();
       long minutes =get_between_date.toMinutes();
       System.out.printf("day:hour:minutes %d:%d:%d",day,hour,minutes);
        *//*현재 시간을 기준으로 1시간 이하 차이 -> 몇 분전 으로 표시
        초 차이 -> 방금 전으로 표시
        * 1시간 차이 -> 몇 시간 전으로 표시
        * 하루 차이 -> 몇 일전으로 표시*//*
        if (day>6){
            System.out.print("7일 넘게 차이남");
            String[] split_date =db_date.split("");
            return split_date[0];
        }else if(day>0){
            System.out.print("day를 기준으로 차이남");
            return day+"일";
        }else if (hour>0){
            System.out.print("hour를 기준으로 차이남");
            return hour+"시간";
        }else if (minutes>0){
            System.out.print("minutes를 기준으로 차이남");
            return minutes+"분";
        }else {
            return "방금 전";
        }

    }*/

}
