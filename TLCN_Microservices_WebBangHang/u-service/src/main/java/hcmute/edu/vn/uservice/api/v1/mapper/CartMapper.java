package hcmute.edu.vn.uservice.api.v1.mapper;

import hcmute.edu.vn.uservice.api.v1.dto.CartDto;
import hcmute.edu.vn.uservice.model.Cart_Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mappings({
            @Mapping(source = "id.items.id", target = "id"),
            @Mapping(source = "id.items.name", target = "name"),
            @Mapping(source = "id.items.description", target = "description"),
            @Mapping(source = "id.items.price", target = "price")
    })
    CartDto cartItemToCartDto(Cart_Item cartProduct);
}
