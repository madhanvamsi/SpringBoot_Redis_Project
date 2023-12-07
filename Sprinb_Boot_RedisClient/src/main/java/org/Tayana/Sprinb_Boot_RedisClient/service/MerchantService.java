package org.Tayana.Sprinb_Boot_RedisClient.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.Tayana.Sprinb_Boot_RedisClient.dao.MerchantDao;
import org.Tayana.Sprinb_Boot_RedisClient.dto.Merchant;
import org.Tayana.Sprinb_Boot_RedisClient.dto.ResponseStructure;
import org.Tayana.Sprinb_Boot_RedisClient.exception.IdNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService 
{
	@Autowired
	 private MerchantDao mdao;
	
	public ResponseEntity<ResponseStructure<Merchant>> save(Merchant merchant)
	{
		ResponseStructure<Merchant> structure=new ResponseStructure<Merchant>();
		structure.setData(mdao.saveMerchant(merchant));
		structure.setMessage("saved successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}
	

	public ResponseEntity<ResponseStructure<Map<Object,Object>>> findAll()
	{
		ResponseStructure<Map<Object,Object>> structure=new ResponseStructure<Map<Object,Object>>();
		structure.setData(mdao.findAll());
		structure.setMessage("Found in REDIS ");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Map<Object,Object>>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<List<Merchant>>> findAllInDB()
	{
		ResponseStructure<List<Merchant>> structure=new ResponseStructure<List<Merchant>>();
		structure.setData(mdao.findAllInDB());
		structure.setMessage("Found in database");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<List<Merchant>>> (structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Object>> findById(int id)
	{
		ResponseStructure<Object> structure=new ResponseStructure<Object>();
			structure.setData(mdao.FindById(id));
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Merchant find in REDIS ");
			return new ResponseEntity<ResponseStructure<Object>> (structure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Object>> findByIdInDB(int id)
	{
		ResponseStructure<Object> structure=new ResponseStructure<Object>();
		Optional<Merchant > mer=mdao.FindByIdInDB(id);
		if(mer.isPresent())
		{
			structure.setData(mdao.FindByIdInDB(id));
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Merchant find  in Data base ");
			return new ResponseEntity<ResponseStructure<Object>> (structure, HttpStatus.OK);
		}
		else
			 throw new IdNotFound();
	}
	
	public ResponseEntity<ResponseStructure> delete(int id)
	{
		ResponseStructure<Boolean> structure=new ResponseStructure<Boolean>();
			structure.setData(mdao.delete(id));
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("deleted");
			return new ResponseEntity<ResponseStructure> (structure, HttpStatus.OK);
	}
	
}
