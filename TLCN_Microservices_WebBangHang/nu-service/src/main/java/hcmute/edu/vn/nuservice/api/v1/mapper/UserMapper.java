package hcmute.edu.vn.nuservice.api.v1.mapper;

import hcmute.edu.vn.nuservice.api.v1.dto.UserDto;
import hcmute.edu.vn.nuservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "roles.id",target = "role")
    })

    UserDto userToUserDto(User user);

}
