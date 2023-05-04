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

import jakarta.servlet.http.HttpServlet;
@CrossOrigin
@Controller
public class LaptopController extends HttpServlet {
	private LaptopDAO laptopDAO = new LaptopDAO();
	@GetMapping("/laptops")
	public String getLaptops(Model model) {
		List<Laptop> laptops = laptopDAO.selectAllLaptops();
		model.addAttribute("laptops", laptops);
		return "laptops";
	}
	@GetMapping("/laptops2")
	@ResponseBody
	public List<Laptop> getLaptops() throws IOException{
		return laptopDAO.selectAllLaptops();
	}
	@GetMapping("/laptop/{id}")
	public String getLaptop(Model model, @PathVariable String id) {
		model.addAttribute("id", id);
		Laptop laptop = laptopDAO.selectLaptop(Integer.valueOf(id));
		model.addAttribute("laptop", laptop);
		return "laptop-detail";
	}
	@GetMapping("/laptop2/{id}")
	@ResponseBody
	public Laptop getLaptop(@PathVariable String id) {
		return laptopDAO.selectLaptop(Integer.valueOf(id));
	}
	@GetMapping("/laptop/search")
	public String searchLaptops(Model model, @RequestParam String keyword) {
		List<Laptop> laptops = laptopDAO.searchLaptops("%" + keyword + "%");
		model.addAttribute("laptops", laptops);
		return "search-results";
	}
}
