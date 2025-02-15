package com.asklepios.hospitalreservation_asklepios.Util;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class Profile_ImageUtil {
//    private ArrayList<String> extendNameArray = new ArrayList<String>() {
//        {
//            add("gif");
//            add("jpg");
//            add("png");
//            add("jpeg");
//        }
//    };

    //수정 -혜린
    @Value("${upload.file.path}")
    private String filePath;


    public String getFullPath(String fileName) {
        return filePath + fileName;
    }

    //이미지 저장 수정 -혜린
    public String storeFile(MultipartFile file) throws Exception {
            if(file == null || file.isEmpty()) {
                return null;
            } else {
                String path_string = filePath.toLowerCase();
                File save_file = new File(path_string);
                if (!save_file.exists()){
                    save_file.mkdir();
                }
                // 사진파일 client upload 한 원본 이름
                String originalFilename = file.getOriginalFilename();
                System.out.println(originalFilename);
                // 사진파일 server 저장을 위해 uuid + 원본 합친 이름
                String storeFileName = createStoreFileName(originalFilename);
                System.out.println("storeFileName:"+storeFileName);
                byte[] fileData = file.getBytes();
                Path path = Paths.get(filePath+"/"+storeFileName);
                /*File target = new File(filePath, storeFileName);*/
                /*FileCopyUtils.copy(fileData, target);*/
                Files.write(path,fileData);
                return storeFileName;
            }

    }

    public String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public String extractExt(String originalFilename) {
        int index = originalFilename.lastIndexOf(".");
        return originalFilename.substring(index + 1);
    }

    @GetMapping(value = "/download")
    @ResponseBody
    public FileSystemResource fileDownload(@RequestParam("filename") String fileName, HttpServletResponse response) {
        File file = new File(filePath + "/" + fileName);
        response.setContentType("application/download; charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        return new FileSystemResource(file);
    }
}
