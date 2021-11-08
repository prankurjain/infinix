package com.example.infinix.serviceimpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.infinix.entity.Bill;
import com.example.infinix.exception.BillIdNotFoundException;
import com.example.infinix.repository.BillRepository;
import com.example.infinix.service.IBillService;

@Service
public class BillService implements IBillService {

	@Autowired
	BillRepository billRepository;
	@Override
	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}
	@Override
	public Bill getBill(int id) throws BillIdNotFoundException {
		// TODO Auto-generated method stub
		return billRepository.findById(id).orElseThrow(()-> new BillIdNotFoundException("Bill id is not found"));
	}
	@Override
	public List<Bill> getBillsWrtDate(String date) throws BillIdNotFoundException {
		// TODO Auto-generated method stub
		return billRepository.findByDueDate(date);
	}

}
