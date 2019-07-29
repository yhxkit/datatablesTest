package com.example.demo19072901.controllers;


import com.example.demo19072901.entities.DTResult;
import com.example.demo19072901.entities.User;
import com.example.demo19072901.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Slf4j
@Controller
public class MainController {

    private UserService userService;


    public MainController(UserService userService){
        this.userService = userService;
    }


    @GetMapping({"","/"})
    public String main(){
        return "main";
    }

    @PostMapping("/getTable")
    @ResponseBody
    public DTResult<User> table(int draw, int start, int length, @RequestParam("search[value]") String value){
        //왜 파이널인지 잘 모르겠지만
      Page<User> searchedUsers = userService.search(start,length,value);

      log.debug(searchedUsers+"");

      if(searchedUsers != null){
        return new DTResult<>(draw, searchedUsers.getTotalElements(), searchedUsers.getTotalElements(), searchedUsers.getContent());
      }else{
          return new DTResult<>(draw, 0,0, Collections.emptyList());
      }
    }








}
