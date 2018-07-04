package com.anuja.restws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.anuja.restws.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {
	List<Passenger> passengers = new ArrayList<>();
	int currentID = 123;
	
	
	@Override
	public List<Passenger> getPassenger(int start, int size) {
		System.out.println(start);
		System.out.println(size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(agent);
		
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> keys = allHeaders.keySet();
		for(String key : keys) {
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookieKey = cookies.keySet();
		for(String key : cookieKey) {
			System.out.println("Cookies-------------");
			System.out.println(key);
			System.out.println(cookies.get(key).getValue());
		}
	}

}
