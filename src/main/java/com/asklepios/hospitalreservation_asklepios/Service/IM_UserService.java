package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation_asklepios.Dao.UserMapper;
import com.asklepios.hospitalreservation_asklepios.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IM_UserService implements IF_UserService{
    @Autowired
    UserMapper usermapper;

    @Override
    public boolean login(UserVO userVO) {
        System.out.println(userVO.getUser_id());
        System.out.println(userVO.getUser_password());
        String pwd = usermapper.selectPwd(userVO);
        System.out.println(userVO.getUser_password());
        if(userVO.getUser_password().equals(pwd)){
            System.out.println("일치");
        }else{
            System.out.println("불일치");
        }
        return true;
    }

}
