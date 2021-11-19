package com.java8.functions;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lamdas {

	public static void main(String[] args) {
		
		String panda = "Panda";
		String dog = "Dog";
		String cat = "cat";
		String horse = "horse";
		String cow = "cow";
		String rabbit = "rabbit";
		String empty = "    ";
		
		List<String> allAnimals = List.of(panda, dog, cat, horse, cow, rabbit, empty);
		
		//print all animamls
		allAnimals.forEach(System.out::println);
		
		//real animals
		List<String> realAnimals = allAnimals.stream().map(s -> s.trim()).collect(Collectors.toList());
		realAnimals.forEach(System.out::println);
		
		//Normalized to upper case
		List<String> uppercaseAnimals = realAnimals.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		uppercaseAnimals.forEach(System.out::println);
		
		// Not horse
		List<String> notHorse = uppercaseAnimals.stream().filter(s -> !s.equalsIgnoreCase("horse")).collect(Collectors.toList());
		notHorse.forEach(System.out::println);
		
		// Filter chaining
		Predicate<String> notCat = s -> !s.equalsIgnoreCase("cat");
		Predicate<String> notDog = s -> !s.equalsIgnoreCase(dog);
		Predicate<String> notCatAndDog = notCat.and(notDog);
		
		List<String> noCatDog = uppercaseAnimals.stream().filter(notCatAndDog).collect(Collectors.toList());
		noCatDog.forEach(System.out::println);
		
		
		
		

	}

}
