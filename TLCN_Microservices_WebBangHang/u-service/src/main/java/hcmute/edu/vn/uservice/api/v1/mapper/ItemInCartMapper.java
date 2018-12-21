package hcmute.edu.vn.uservice.api.v1.mapper;

import hcmute.edu.vn.uservice.api.v1.dto.ItemInCartDto;
import hcmute.edu.vn.uservice.model.Cart_Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemInCartMapper {
    ItemInCartMapper INSTANCE = Mappers.getMapper(ItemInCartMapper.class);

    @Mappings({
            @Mapping(source = "id.items.id", target = "id"),
            @Mapping(source = "id.items.name", target = "name"),
            @Mapping(source = "id.items.description", target = "description"),
            @Mapping(source = "id.items.price", target = "price"),
            @Mapping(source = "id.items.types.name", target = "type")
    })
    ItemInCartDto cartItemToItemInCartDto(Cart_Item cartProduct);
}
