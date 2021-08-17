package com.app.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

	public static final Map<Integer, String> deptMap = new HashMap<>();
	
	static {
		deptMap.put(1, "Dinesh Kumar");
		deptMap.put(2, "Ravi Kumar");
		deptMap.put(3, "Satish Kumar");
		deptMap.put(4, "Mohit Kumar");
		deptMap.put(5, "Rohit Kumar");
		
	}
	
	@GetMapping("/info/{id}")
	public String getInfo(@PathVariable("id") Integer id) {
		return deptMap.get(id);
	}
	
	@GetMapping("/infos")
	public Map<Integer, String> getAllInfo() {
		return deptMap;
	}
	
	@PostMapping("/info/add")
	public Map<Integer, String> addInfo(@RequestBody Map<Integer, String> input) {
		deptMap.putAll(input);
		return deptMap;
	}
	
	@PutMapping("/info/update")
	public Map<Integer, String> updateInfo(@RequestBody Map<Integer, String> input) {
		input.forEach((k,v)->{
			deptMap.put(k, v);
		});
		return deptMap;
	}
	
	@DeleteMapping("/info/delete/{id}")
	public Map<Integer, String> deleteInfo(@PathVariable("id") Integer id) {
		deptMap.remove(id);
		return deptMap;
	}
}
