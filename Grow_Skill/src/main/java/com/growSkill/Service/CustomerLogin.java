package com.growSkill.Service;

import com.growSkill.Exception.LoginException;
import com.growSkill.Model.LoginDTO;

public interface CustomerLogin {

    public String logIntoAccount(LoginDTO dto)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;

}
