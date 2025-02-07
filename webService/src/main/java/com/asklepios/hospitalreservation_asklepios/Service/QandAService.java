package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation_asklepios.Repository.IF_QandAMapper;
import com.asklepios.hospitalreservation_asklepios.VO.QuestionVO;
import com.asklepios.hospitalreservation_asklepios.VO.Question_imgVO;
import com.asklepios.hospitalreservation_asklepios.VO.QuestionlistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class QandAService {

    @Value("${filePath}")
    private String path;
    @Autowired
    private IF_QandAMapper qandAMapper;


    //이미지 로컬에 저장 후에 디비 저장
    public boolean save_local_img(List<MultipartFile> files,int id){
        try {
            String uploadpath = new File(path).getAbsolutePath();//절대경로로 변환
            File f = new File(uploadpath);//file객체 생성
            if (!f.exists())f.mkdir();
            if (!files.isEmpty()) {
                for (MultipartFile file : files) {
                    String originalFilename = file.getOriginalFilename();
                    System.out.println(originalFilename);
                    String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
                    String local_upload = UUID.randomUUID().toString() + extension;
                    Path p = Paths.get(uploadpath + "/"+local_upload);
                    Files.write(p, file.getBytes()); //로컬에 저장
                    qandAMapper.save_qanda_img(new Question_imgVO(local_upload, id, originalFilename));
                }
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage()+"파일 등록 실패");
            return false;
        }
    }

    public boolean save_text(List<MultipartFile> files, QuestionVO vo){
        System.out.println("질문 텍스트 저장");
        vo.setUser_id("lin99");
        qandAMapper.save_qanda_text(vo);
        System.out.println(vo.getId());
       return save_local_img(files,vo.getId());
    }

    //의사 답변 저장
    public boolean answer(QuestionVO vo,String userId){
        try{
            QuestionlistVO answervo =qandAMapper.pre_getDoctorInfo(userId);
            System.out.println("answervo"+answervo);
            answervo.setId(vo.getId());
            answervo.setContent(vo.getContent());
            System.out.println("answervo"+answervo);
            //저장할 dto생성
            qandAMapper.save_answer(answervo);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //화면리스트 가져오기
    public List<QuestionlistVO> getList(){
        return qandAMapper.list();
    }


    //큐앤에이 화면 자세히보기 - 질문자와 답변자 함께 가져옴
    //answer 테이블에 대부분의 정보가 들어있어서 닥터 이름만 join해서 가져오면됨
    public QuestionlistVO showdeatil(int question_id){
        QuestionlistVO vo =qandAMapper.detailQandA(question_id);
        vo.setAnswerlist(qandAMapper.show_detail_getDoctorInfo(question_id));
        return vo;
    }

    //해당 질문 제목 가져오기
    public String getSubject(int questionId){
        return qandAMapper.getSubjuct(questionId);
    }

}
