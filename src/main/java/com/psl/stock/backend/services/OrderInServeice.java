package com.psl.stock.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.psl.stock.backend.entities.OrderIn;
import com.psl.stock.backend.repositories.OrderInRepo;

@Service
public class OrderInServeice {

	@Autowired
	private OrderInRepo orderInRepo;

	public OrderIn addOrUpdate(OrderIn orderIn) {
		return orderInRepo.save(orderIn);
	}

	public boolean deleteById(Long id) {
		orderInRepo.deleteById(id);
		return true;
	}

	public Page<OrderIn> getAll(int pageNo, int pageSize, String field, String sortDir) {

		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(field).ascending();
		} else {
			sort = Sort.by(field).descending();
		}

		Pageable p = PageRequest.of(pageNo, pageSize, sort);

		return orderInRepo.findAll(p);
	}

	public OrderIn getIn(Long id) {
		return orderInRepo.findById(id).get();
	}
}
