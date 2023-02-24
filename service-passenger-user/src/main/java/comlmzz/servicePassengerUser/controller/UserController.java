package comlmzz.servicePassengerUser.controller;

import com.lmzz.dto.ResponseResult;
import com.lmzz.request.VerificationCodeDTO;
import comlmzz.servicePassengerUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return userService.loginOrRegister(passengerPhone);
    }
}
