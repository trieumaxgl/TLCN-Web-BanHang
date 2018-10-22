package hcmute.edu.vn.nuservice.service.impl;

import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.model.Role;
import hcmute.edu.vn.nuservice.model.User;
import hcmute.edu.vn.nuservice.repository.RoleRepository;
import hcmute.edu.vn.nuservice.repository.UserRepository;
import hcmute.edu.vn.nuservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public CrudRepository<User, Integer> getRepo() {
        return userRepository;
    }

    @Override
    public User findByEmailAndPassWord(String email, String passWord) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, passWord);
        if(!user.isPresent())
            throw new NotFoundException("User Not Found!!!");
        return user.get();
    }

    @Override
    public User registerUser(User user) {
        User userCreate =  userRepository.save(user);
        Role role = roleRepository.findByName("ROLE_USER").get();
        userCreate.setRoles(role);
        return userRepository.save(userCreate);
    }
}
