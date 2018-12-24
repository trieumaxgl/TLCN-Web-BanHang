package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.model.Bill_Item;
import hcmute.edu.vn.adservice.repository.BillitemRepository;
import hcmute.edu.vn.adservice.service.BillitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillitemServiceImpl implements BillitemService {
    @Autowired
    private BillitemRepository billitemRepository;

    @Override
    public List<Bill_Item> retrieveAllBillItem(int billId) {
        List<Bill_Item> bill_items = billitemRepository.findById_BillId(billId);
        if(bill_items.isEmpty())
            throw new NotFoundException("Not Found Product in Your Bill");
        return bill_items;
    }
}
