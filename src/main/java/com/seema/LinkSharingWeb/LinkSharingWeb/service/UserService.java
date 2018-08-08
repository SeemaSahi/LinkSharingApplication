package com.seema.LinkSharingWeb.LinkSharingWeb.service;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.User;
import com.seema.LinkSharingWeb.LinkSharingWeb.repository.UserRepository;
import com.seema.LinkSharingWeb.LinkSharingWeb.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseDTO save(User user) {
        if (Objects.isNull(user.getId())) {
            user.setDateCreated(new Date());
        }
        user.setLastUpdated(new Date());

        userRepository.save(user);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(true);
        responseDTO.setMessage("Employee is saved succesfully");
        return responseDTO;
    }

    public User validateLogin(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else
            return null;
    }
}
