package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.model.Bill;

import java.util.List;

public interface BillService {
    Bill findById(int id);
    List<Bill> findAll(int status);
}
