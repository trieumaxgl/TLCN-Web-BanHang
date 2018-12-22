package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.model.User;
import hcmute.edu.vn.adservice.repository.UserRepository;
import hcmute.edu.vn.adservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User deleteUser (int id){
        User update = userRepository.findById(id).get();
        update.setStatus(0);
        return userRepository.save(update);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            throw new NotFoundException("User is Empty !!!");
        return users;
    }
}
