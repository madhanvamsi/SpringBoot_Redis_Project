package org.Tayana.Sprinb_Boot_RedisClient.dto;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Merchant_redis")
public class Merchant implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable = false)
	private String fname;
	@Column(nullable = false)
	private String lname;
	@Column(nullable = false, unique = true)
	private long phone;
	
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + "]";
	}
	
	
	

}
