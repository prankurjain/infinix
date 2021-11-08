package com.example.infinix;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.infinix.entity.Bill;
import com.example.infinix.repository.BillRepository;

@SpringBootApplication
public class InfinixApplication implements CommandLineRunner {

	@Autowired
	BillRepository billRepository;
	public static void main(String[] args) {
		SpringApplication.run(InfinixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ArrayList<Bill>bills=new ArrayList<Bill>();
		bills.add(new Bill("124", "raju", "25-12-2021", 123, 1, 124, "30-12-2021"));
		bills.add(new Bill("125", "rajan", "23-12-2021", 123, 1, 124, "29-12-2021"));
		bills.add(new Bill("126", "rajesh", "22-12-2021", 123, 1, 124, "29-12-2021"));
		bills.add(new Bill("127", "raj", "25-12-2021", 123, 1, 124, "30-12-2021"));
		billRepository.saveAll(bills);
	}

}
