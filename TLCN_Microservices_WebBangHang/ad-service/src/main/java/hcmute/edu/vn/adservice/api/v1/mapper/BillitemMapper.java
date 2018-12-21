package hcmute.edu.vn.adservice.api.v1.mapper;

import hcmute.edu.vn.adservice.api.v1.dto.BillitemDto;
import hcmute.edu.vn.adservice.model.Bill_Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillitemMapper {
    BillitemMapper INSTANCE = Mappers.getMapper(BillitemMapper.class);

    @Mappings({
            @Mapping(source = "id.items.id", target = "id"),
            @Mapping(source = "id.items.name", target = "name"),
            @Mapping(source = "id.items.description", target = "description"),
            @Mapping(source = "id.items.price", target = "price"),
            @Mapping(source = "id.items.types.id", target = "type")
    })
    BillitemDto billItemToBillItemDto(Bill_Item billItem);
}

