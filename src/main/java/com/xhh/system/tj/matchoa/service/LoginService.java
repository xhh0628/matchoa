package com.xhh.system.tj.matchoa.service;

import com.xhh.system.tj.matchoa.dto.ResultDTO;
import com.xhh.system.tj.matchoa.mapper.UserMapper;
import com.xhh.system.tj.matchoa.model.User;
import com.xhh.system.tj.matchoa.model.UserExample;
import com.xhh.system.tj.matchoa.returnCode.CustomizeErrorCode;
import com.xhh.system.tj.matchoa.returnCode.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public ResultDTO selectUserInfo(String userName, String password) {

        UserExample example=new UserExample();
        example.createCriteria()
                .andLoginNameEqualTo(userName);
       List<User> userList= userMapper.selectByExample(example);
       if (userList.size()!=0){
            if (userList.size()==1){
                if (userList.get(0).getLoginPwd().equals(password)){

                    return ResultDTO.okOf();
                }else {
                    return ResultDTO.errorOf(CustomizeErrorCode.USER_PASSWORD_ERROR);
                }
            }else {
                return ResultDTO.errorOf(CustomizeErrorCode.USER_REPEAT);
            }
       }else{
           return ResultDTO.errorOf(CustomizeErrorCode.USER_NOT_FOUND);
       }


    }

    public void createOrUpdateUser(User user) {
        User recode=userMapper.selectByPrimaryKey(user.getLoginName());
        if (recode !=null){
            //修改
            userMapper.updateByUserName(user);
        }else {
            //新增
        }
    }
}
