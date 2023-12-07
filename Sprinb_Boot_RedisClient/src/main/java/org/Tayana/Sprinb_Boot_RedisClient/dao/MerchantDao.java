package org.Tayana.Sprinb_Boot_RedisClient.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.Tayana.Sprinb_Boot_RedisClient.dto.Merchant;
import org.Tayana.Sprinb_Boot_RedisClient.repository.MercRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class MerchantDao 
{
	@Autowired
	private MercRepository repository;
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	public static final String KEY="merchant";
	
	
	//save method
	public Merchant saveMerchant(Merchant merchant)
	{
		template.opsForHash().put("merchant", merchant.getId(), merchant.toString());
		repository.save(merchant);
		return merchant;
	}
	
	//finding an object using primary key in REDIS 
	public Object FindById(int id)
	{
		return template.opsForHash().get("merchant", id);
	}
	
	//finding an object using PK in database
	public Optional<Merchant> FindByIdInDB(int id)
	{
		return repository.findById(id);
	}
	
	//listing all the entries in redis
	public Map<Object, Object> findAll()
	{
		return  template.opsForHash().entries(KEY);
	}
	
	//listing all the entries in database
	public List<Merchant> findAllInDB()
	{
		return repository.findAll();
	}
	
	//deleting an object on both REDIS and database
	public boolean delete(int id)
	{
		template.opsForHash().delete(KEY,id);
		repository.deleteById(id);
		return true;
	}
	
	public void saveAll(Map<String, Object> map)
	{
		template.opsForHash().putAll(KEY, map);
	}
	
}
