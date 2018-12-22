package hcmute.edu.vn.uservice.service.impl;

import hcmute.edu.vn.uservice.api.v1.dto.UserDto;
import hcmute.edu.vn.uservice.exception.NotFoundException;
import hcmute.edu.vn.uservice.model.User;
import hcmute.edu.vn.uservice.repository.RoleRepository;
import hcmute.edu.vn.uservice.repository.UserRepository;
import hcmute.edu.vn.uservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public User findByFirstnameAndLastname(String firstname, String lastname) {
        Optional<User> user = userRepository.findByFirstnameAndLastname(firstname,lastname);
        if(!user.isPresent())
            throw new NotFoundException("User Not Found!!!");
        return user.get();
    }

    @Override
    public User findByEmailAndStatus (String email,int status){
        Optional<User> user = userRepository.findByEmailAndStatus(email,status);
        if(!user.isPresent())
            throw new NotFoundException("User Not Found!!!");
        return user.get();
    }

    @Override
    public User updateUser (UserDto userDto,int id){
        User update = userRepository.findById(id).get();
        update.setEmail(userDto.getEmail());
        update.setAddress(userDto.getAddress());
        update.setPassword(userDto.getPassword());
        update.setBirthday(userDto.getBirthday());
        update.setFirstname(userDto.getFirstname());
        update.setLastname(userDto.getLastname());
        update.setAvatar(userDto.getAvatar());
        update.setGender(userDto.getGender());
        return userRepository.save(update);
    }

    @Override
    public User resetPassword(int id){
        User reset = userRepository.findById(id).get();
        reset.setPassword("12345678");
        return userRepository.save(reset);
    }
}
