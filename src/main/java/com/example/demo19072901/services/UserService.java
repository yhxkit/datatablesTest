package com.example.demo19072901.services;

import com.example.demo19072901.entities.User;
import com.example.demo19072901.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
@Slf4j
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Page<User> search(int start, int length, @RequestParam(defaultValue = "") String value){
        log.debug("search page Value : "+Strings.isBlank(value)); //검색시 사용

        Page<User> users;

        if(Strings.isBlank(value)){
            users = userRepository.findAll(PageRequest.of(start/length, length));
        }else{
            users = userRepository.findByuserIdContains(value, PageRequest.of(start/length, length));
        }

        return users;
    }

}
