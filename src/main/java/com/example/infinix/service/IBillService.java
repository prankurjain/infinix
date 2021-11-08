package com.example.infinix.service;


import java.util.List;



import com.example.infinix.entity.Bill;
import com.example.infinix.exception.BillIdNotFoundException;


public interface IBillService {

	List<Bill> getAllBills();

	Bill getBill(int id) throws BillIdNotFoundException;

	List<Bill> getBillsWrtDate(String date) throws BillIdNotFoundException;

}
