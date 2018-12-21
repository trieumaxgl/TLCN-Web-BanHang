package hcmute.edu.vn.uservice.service.impl;

import hcmute.edu.vn.uservice.model.Bill;
import hcmute.edu.vn.uservice.model.User;
import hcmute.edu.vn.uservice.repository.BillRepository;
import hcmute.edu.vn.uservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    BillRepository billRepository;

    @Override
    public Bill addBill( User user) {
        Date date = new Date();
        Bill bill = new Bill();
        bill.setTotal(Long.valueOf(0));
        bill.setStatus(1);
        bill.setAddress(user.getAddress());
        bill.setPhone(user.getPhone());
        bill.setDate(date);
        bill.setUser(user);
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(int id,Long total){
        Bill updateBill = billRepository.findById(id).get();
        updateBill.setTotal(total);
        return billRepository.save(updateBill);
    }
}
