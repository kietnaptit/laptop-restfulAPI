package com.bth3.laptop;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServlet;
@CrossOrigin
@RestController
public class LaptopController {
	private LaptopDAO laptopDAO = new LaptopDAO();
	@GetMapping("/laptops")
	public List<Laptop> getLaptops() throws IOException{
		return laptopDAO.selectAllLaptops();
	}
	@GetMapping("/laptop/{id}")
	@ResponseBody
	public Laptop getLaptop(@PathVariable String id) {
		return laptopDAO.selectLaptop(Integer.valueOf(id));
	}
	@GetMapping("/laptop/search")
	public List<Laptop> searchLaptops(@RequestParam String keyword) {
		return laptopDAO.searchLaptops("%" + keyword + "%");
	}
}
