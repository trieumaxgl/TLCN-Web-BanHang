package hcmute.edu.vn.adservice.api.v1.mapper;

import hcmute.edu.vn.adservice.api.v1.dto.Attach_FileDTO;
import hcmute.edu.vn.adservice.model.Attach_File;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper
public interface Attach_FileMapper {
    Attach_FileMapper INSTANCE = Mappers.getMapper(Attach_FileMapper.class);

    @Mappings({
            @Mapping(source = "items.id",target = "itemId")
    })
    Attach_FileDTO AttachFileToAttachFileDTO(Attach_File attachFile);
}
