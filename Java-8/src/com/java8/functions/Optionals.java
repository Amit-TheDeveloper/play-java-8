package com.java8.functions;

import java.util.Optional;

public class Optionals {
	
	public static void main(String[] args) {
		Optional<String> name = Optional.of("Amit");
		Optional<String> empty = Optional.empty();
		Optional<String> orelseTest = Optional.empty();
		
		System.out.println(name.isPresent() ? name.get() : "No name");
		System.out.println(empty.isPresent() ? name.get() : "No name");
		System.out.println(name.orElse("please put a name"));
		System.out.println(orelseTest.orElse("please put a name"));
	}
	
	
	
	

}
