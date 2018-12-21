package hcmute.edu.vn.adservice.api.v1.mapper;

import hcmute.edu.vn.adservice.api.v1.dto.BillDto;
import hcmute.edu.vn.adservice.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper {
    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);

    @Mappings({
            @Mapping(source = "user.id", target = "user"),
    })
    BillDto billToBillDto(Bill bill);
}
