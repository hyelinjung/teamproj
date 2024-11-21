package com.asklepios.hospitalreservation_asklepios.Service;

import com.asklepios.hospitalreservation_asklepios.Dao.UserMapper;
import com.asklepios.hospitalreservation_asklepios.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IM_UserService implements IF_UserService{
    @Autowired
    UserMapper usermapper;

    @Override
    public boolean login(UserDto userDto) {
        System.out.println(userDto.getUser_id());
        System.out.println(userDto.getUser_password());
        String pwd = usermapper.selectPwd(userDto);
        System.out.println(userDto.getUser_password());
        if(userDto.getUser_password().equals(pwd)){
            System.out.println("일치");
        }else{
            System.out.println("불일치");
        }
        return true;
    }

}
