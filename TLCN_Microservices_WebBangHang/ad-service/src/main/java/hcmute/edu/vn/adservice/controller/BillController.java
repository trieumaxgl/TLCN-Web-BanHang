package hcmute.edu.vn.adservice.controller;

import hcmute.edu.vn.adservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.adservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.adservice.api.v1.dto.BillDto;
import hcmute.edu.vn.adservice.api.v1.dto.BillitemDto;
import hcmute.edu.vn.adservice.api.v1.mapper.BillMapper;
import hcmute.edu.vn.adservice.api.v1.mapper.BillitemMapper;
import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.model.Bill;
import hcmute.edu.vn.adservice.service.BillService;
import hcmute.edu.vn.adservice.service.BillitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/bill/")
@CrossOrigin
public class BillController {
    @Autowired
    private BillitemService billitemService;
    @Autowired
    private BillService billService;
    @Autowired
    private BillitemMapper billitemMapper;
    @Autowired
    private BillMapper billMapper;

    @GetMapping("/billitem/{id}")
    public DataReturnList<BillitemDto> getBillItem(@PathVariable int id){
        Bill bill = billService.findById(id);

        DataReturnList<BillitemDto> billItemDtoDataReturnList=new DataReturnList<>();
        billItemDtoDataReturnList.setData(billitemService.retrieveAllBillItem(bill.getId())
                .stream()
                .map(billitemMapper::billItemToBillItemDto)
                .collect(Collectors.toList()));
        billItemDtoDataReturnList.setMessage("Get All Item in Bill!!!");
        return billItemDtoDataReturnList;
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<Object> getBill(@PathVariable int id){
        Bill bill = billService.findById(id);
        if(bill == null)
            throw new NotFoundException("Khong co hoa don nay!!");
        DataReturnOne<BillDto> returnOne=new DataReturnOne<>();
        returnOne.setData(billMapper.billToBillDto(bill));
        returnOne.setMessage("Get All Item in Bill!!!");
        return ResponseEntity.ok(returnOne);
    }

    @GetMapping("/billitem/load")
    public DataReturnList<BillDto> getAllItems() {

        //get all product was not deleted
        DataReturnList<BillDto> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all bill");
        dataReturnList.setData(billService.findAll(1)
                .stream()
                .map(billMapper::billToBillDto)
                .collect(Collectors.toList()));

        return dataReturnList;
    }
}
