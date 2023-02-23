package com.crmsystem.registration.serviceimplementation;

import com.crmsystem.registration.entity.UserRegistry;
import com.crmsystem.registration.exceptions.UserNotLoggedInException;
import com.crmsystem.registration.repository.RegistrationRepository;
import com.crmsystem.registration.service.IsLoggedInService;
import com.crmsystem.registration.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class IsUserLoggedInImpl implements IsLoggedInService {
    @Autowired
    private RegistrationRepository repository;
    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails isLoggedIn() {

        //retrieving the token attribute from current session:
        String token=(String) request.getSession().getAttribute("token");

        if(token!=null){
            String email = (String) request.getSession().getAttribute("email");
            UserRegistry user=repository.findByEmail(email);

            return new UserDetails(true,user.getName(), user.getCity(), user.getPincode(),
                    user.getMobileNumber(), user.getAddress1(), user.getAddress2(), user.getState());
        }else{
            throw new UserNotLoggedInException("User is not Logged in");
        }
    }
}
