package com.example.infinix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.infinix.entity.Bill;
import com.example.infinix.exception.BillIdNotFoundException;
import com.example.infinix.service.IBillService;

@RestController
public class BillController {

	@Autowired
	IBillService billService;
	
	@GetMapping("/bills")
	public ResponseEntity<?> getAllBills(){
		
		return new ResponseEntity<List<Bill>>(billService.getAllBills(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bills/{id}")
	 public ResponseEntity<?> getBill(@PathVariable("id") int id){
		
		try {
			return new ResponseEntity<Bill>(billService.getBill(id), HttpStatus.ACCEPTED);
		} catch (BillIdNotFoundException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/bills/due/{date}")
	 public ResponseEntity<?> getBill(@PathVariable("date") String date){
		System.out.println(date);
		try {
			return new ResponseEntity<List<Bill>>(billService.getBillsWrtDate(date), HttpStatus.ACCEPTED);
		} catch (BillIdNotFoundException e) {
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/")
	public String welcome(){
		
		return "Welcome to portal";
	}
}
