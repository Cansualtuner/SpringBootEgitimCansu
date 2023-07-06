package com.folksdev.account;

import com.folksdev.account.model.Account;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import kotlin.collections.SetsKt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		Customer customer= customerRepository.save(new Customer("","Huseyin","Husnu", (Set<Object>) new HashSet<>()));
		System.out.println(customer);

//		if (a == b) //false çünkü farklı objeler
//			a.equals(b) //true çünkü değerlere bakıyoruz.
//Nesnenin fiziksel değeri hash vb variabllerina göre nesnenin içine atıyor. hash code özel bir algoritmadır.

	}


	}

