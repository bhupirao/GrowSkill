package com.growSkill.Service;

import com.growSkill.Exception.LoginException;
import com.growSkill.Model.CurrentCustomerSession;
import com.growSkill.Model.Customer;
import com.growSkill.Model.LoginDTO;
import com.growSkill.Model.RandomStringGenerator;
import com.growSkill.Repository.CurrentCustomerSessionDao;
import com.growSkill.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerLoginImpl implements CustomerLogin{


    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CurrentCustomerSessionDao sessionDao;


    @Override
    public String logIntoAccount(LoginDTO dto) throws LoginException {
        Customer existingCus=customerRepo.findByMobileNo(dto.getMobileNo());

        if(existingCus==null){
            throw new LoginException("Please Enter a Valid Mobile No");
        }
        Optional<CurrentCustomerSession> vaildUserSessionOpt =sessionDao.findById(Math.toIntExact(existingCus.getCustomerId()));

        if(vaildUserSessionOpt.isPresent()){
            throw new LoginException("User already Logged in with this number");
        }
        if(existingCus.getPassword().equals(dto.getPassword())) {

            String key = RandomStringGenerator.generateRandomString(6);



            CurrentCustomerSession currentCustomerSession = new CurrentCustomerSession(Math.toIntExact(existingCus.getCustomerId()),key, LocalDateTime.now());

            sessionDao.save(currentCustomerSession);

            return currentCustomerSession.toString();
        }
        else
            throw new LoginException("Please Enter a valid password");

    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
        CurrentCustomerSession validCustomerSession = sessionDao.findByUuid(key);


        if(validCustomerSession == null) {
            throw new LoginException("User Not Logged In with this number");

        }


        sessionDao.delete(validCustomerSession);


        return "Logged Out !";
    }
}
