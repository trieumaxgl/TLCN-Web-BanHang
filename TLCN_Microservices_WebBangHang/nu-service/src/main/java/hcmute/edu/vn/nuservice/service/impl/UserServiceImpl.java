package hcmute.edu.vn.nuservice.service.impl;

import hcmute.edu.vn.nuservice.api.v1.dto.UserDto;
import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.model.Cart;
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

        return userRepository.save(userCreate);
    }

    @Override
    public User findByEmailAndStatus(String email, int status){
        Optional<User> user = userRepository.findByEmailAndStatus(email,status);
        if(!user.isPresent())
            throw new NotFoundException("User Not Found!!!");
        return user.get();
    }

    @Override
    public User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBirthday(userDto.getBirthday());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setStatus(1);
        return user;
    }

    @Override
    public User updateUser(int id){
        User update = userRepository.findById(id).get();
        return userRepository.save(update);
    }
}
