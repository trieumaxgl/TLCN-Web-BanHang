package hcmute.edu.vn.uservice.api.v1.mapper;

import hcmute.edu.vn.uservice.api.v1.dto.ItemDto;
import hcmute.edu.vn.uservice.model.Items;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto itemToItemDto(Items items);
}
