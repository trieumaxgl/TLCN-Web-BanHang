package hcmute.edu.vn.uservice.service;

import hcmute.edu.vn.uservice.model.Bill;
import hcmute.edu.vn.uservice.model.User;

public interface BillService {
    Bill addBill( User user);
    Bill updateBill(int id,Long total);
}
