package com.crmsystem.registration.serviceimplementation;

import com.crmsystem.registration.entity.UserRegistry;
import com.crmsystem.registration.repository.RegistrationRepository;
import com.crmsystem.registration.service.LoginService;
import com.crmsystem.registration.vo.Captcha;
import com.crmsystem.registration.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RegistrationRepository repository;

    public boolean login(String email, String password, int captchaAnswer, HttpServletRequest request) {
        UserRegistry user = repository.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
        if (user != null) {
            String hashedPassword = "";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(password.getBytes());
                hashedPassword = new String(messageDigest.digest());

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("No Algorithm exist for hashing password");
            }

            if (hashedPassword.equals(user.getPassword())) {


                Captcha captcha = (Captcha) request.getSession().getAttribute("captcha");

                if (captcha != null && captcha.getAnswer() == captchaAnswer) {

                    //generating and setting the attribute token against the current session:
                    String token = UUID.randomUUID().toString();
                    request.getSession().setAttribute("token", token);
                    request.getSession().setAttribute("email", email);

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }else{
            return false;
        }
    }


    //function for logging out:
    @Override
    public void logout(HttpServletRequest request) {
        //removing the attribute named token:
        request.getSession().removeAttribute("token");
    }


}
