package hcmute.edu.vn.adservice.controller;
import hcmute.edu.vn.adservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.adservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.adservice.api.v1.dto.PermissionDTO;
import hcmute.edu.vn.adservice.api.v1.mapper.PermissionMapper;
import hcmute.edu.vn.adservice.model.Permission;
import hcmute.edu.vn.adservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @Autowired
    PermissionMapper permissionMapper;

    @GetMapping
    public DataReturnList<PermissionDTO> getAllPermission(){

        //delFlag is not delete
        int delFlag = 0;

        DataReturnList<PermissionDTO> returnList = new DataReturnList<>();

        returnList.setMessage("get all permission");
        returnList.setData(permissionService.findAll(delFlag)
                .stream()
                .map(permissionMapper::permissionTopermissionDTO)
                .collect(Collectors.toList()));

        return returnList;
    }

    @GetMapping("/{id}")
    public DataReturnOne<PermissionDTO> getPermission(@PathVariable(value = "id") int id){

        //delFlag is not delete
        int status = 0;

        DataReturnOne<PermissionDTO> returnOne = new DataReturnOne<>();
        returnOne.setMessage("get permission");
        returnOne.setData(permissionService.findById(id, status)
                .map(permissionMapper::permissionTopermissionDTO).get());

        return returnOne;
    }

    @PostMapping
    public ResponseEntity<Object> createPermission(@RequestBody Permission permission){

        Permission savePermission = permissionService.savePermission(permission);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        savePermission.getId()
                ).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePermission(@PathVariable(value = "id") int id,
                                                   @RequestBody Permission permission){
        permission.setId(id);
        return ResponseEntity.accepted().body(permissionService.savePermission(permission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePermission(@PathVariable(value = "id") int id){

        //set delFlag was deleted
        int status = 1;

        return ResponseEntity.accepted().body(permissionService.deletePermission(id, status));
    }
}
