package hcmute.edu.vn.adservice.controller;

import hcmute.edu.vn.adservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.adservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.adservice.api.v1.dto.UserDto;
import hcmute.edu.vn.adservice.api.v1.mapper.UserMapper;
import hcmute.edu.vn.adservice.model.User;
import hcmute.edu.vn.adservice.service.RoleService;
import hcmute.edu.vn.adservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @GetMapping("/alluser")
    public DataReturnList<UserDto> getAllUsers() {

        //get all product was not deleted
        DataReturnList<UserDto> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all users");
        dataReturnList.setData(userService.findAll(roleService.findById(2))
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList()));

        return dataReturnList;
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable (value="id") int id){
        User user = userService.deleteUser(id);
        DataReturnOne<UserDto> returnOne = new DataReturnOne<>();
        returnOne.setSuccess("success");
        returnOne.setMessage("Xoa user thanh cong");
        return ResponseEntity.ok(returnOne);
    }
}
