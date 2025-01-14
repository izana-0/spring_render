package com.setec.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "tbl_booked")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booked {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String phoneNumber;
	private String date;
	private String time;
	private int person;
	
	 @Override
	    public String toString() {
	        return "🆔 id : " + id + "\n" +
	               "👤 Name : " + name + " \n" +
	               "📧 Email : " + email + "\n" +
	               "📞 Phone Number : " + phoneNumber + "\n" +
	               "📅 Date : " + date + "\n" +
	               "⏰ Time : " + time + "\n" +
	               "👤 Person : " + person;
	    }
}

