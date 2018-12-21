package hcmute.edu.vn.adservice.controller;

import hcmute.edu.vn.adservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.adservice.api.v1.dto.BillDto;
import hcmute.edu.vn.adservice.api.v1.dto.BillitemDto;
import hcmute.edu.vn.adservice.api.v1.mapper.BillMapper;
import hcmute.edu.vn.adservice.api.v1.mapper.BillitemMapper;
import hcmute.edu.vn.adservice.model.Bill;
import hcmute.edu.vn.adservice.service.BillService;
import hcmute.edu.vn.adservice.service.BillitemService;
import org.springframework.beans.factory.annotation.Autowired;
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
        billItemDtoDataReturnList.setMessage("Get All Product in Cart!!!");
        return billItemDtoDataReturnList;
    }

    @GetMapping("/billitem/load")
    public DataReturnList<BillDto> getAllItems() {

        //get all product was not deleted
        DataReturnList<BillDto> dataReturnList = new DataReturnList<>();
        dataReturnList.setMessage("get all items");
        dataReturnList.setData(billService.findAll(1)
                .stream()
                .map(billMapper::billToBillDto)
                .collect(Collectors.toList()));

        return dataReturnList;
    }
}
