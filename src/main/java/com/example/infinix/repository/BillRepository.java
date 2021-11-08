package com.example.infinix.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.infinix.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

	List<Bill> findByDueDate(String date);

	
}
