package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.model.Bill;
import hcmute.edu.vn.adservice.repository.BillRepository;
import hcmute.edu.vn.adservice.repository.BillitemRepository;
import hcmute.edu.vn.adservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill findById(int id){
        Optional<Bill> bill = billRepository.findById(id);
        if(!bill.isPresent())
            throw new NotFoundException("User Not Found!!!");
        return bill.get();
    }

    @Override
    public List<Bill> findAll(int status){
        return billRepository.findAll();
    }
}
