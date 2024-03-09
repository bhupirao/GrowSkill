package com.growSkill.Controller;

import com.growSkill.Exception.LoginException;
import com.growSkill.Model.LoginDTO;
import com.growSkill.Service.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @Autowired
    private CustomerLogin loginService;

    @PostMapping("/customerlogin")
    public ResponseEntity<String> logInUserHandler(@RequestBody LoginDTO dto) throws LoginException {

        String result = loginService.logIntoAccount(dto);



        return new ResponseEntity<String>(result, HttpStatus.OK );


    }

    @PostMapping("/customerlogout")
    public String logoutUserHandler(@RequestParam(required = false) String key) throws LoginException {
        return loginService.logOutFromAccount(key);

    }

}
