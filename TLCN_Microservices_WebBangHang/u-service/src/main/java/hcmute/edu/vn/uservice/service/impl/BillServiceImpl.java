package hcmute.edu.vn.uservice.service.impl;

import hcmute.edu.vn.uservice.model.Bill;
import hcmute.edu.vn.uservice.repository.BillRepository;
import hcmute.edu.vn.uservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }
}
