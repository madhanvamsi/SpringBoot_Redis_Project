package org.Tayana.Sprinb_Boot_RedisClient.controller;


import java.util.List;
import java.util.Map;
import org.Tayana.Sprinb_Boot_RedisClient.dto.Merchant;
import org.Tayana.Sprinb_Boot_RedisClient.dto.ResponseStructure;
import org.Tayana.Sprinb_Boot_RedisClient.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
  
	@Autowired
	private MerchantService service;
	
	
	@PostMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> save(@RequestBody Merchant merchant)
	{
		return service.save(merchant);
	}
	
	@GetMapping("/merchant")
	public ResponseEntity<ResponseStructure<Map<Object, Object>>>  findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/merchantInDB")
	public ResponseEntity<ResponseStructure<List<Merchant>>>  findAllInDb()
	{
		return service.findAllInDB();
	}
	
	@GetMapping("/merchant/{id}")
	public ResponseEntity<ResponseStructure<Object>> findById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@GetMapping("/merchant/{db_id}")
	public ResponseEntity<ResponseStructure<Object>> findByIdInDb(@PathVariable int db_id)
	{
		return service.findByIdInDB(db_id);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure> delete(@PathVariable int id)
	{
		return service.delete(id);
	}

}

