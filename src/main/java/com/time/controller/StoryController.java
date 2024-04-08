package com.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.time.service.StoryScrapper;
import com.time.service.StoryScrapper.Item;

@RestController
public class StoryController {
	
	@Autowired
	private StoryScrapper storyScrapper;
	
	@GetMapping("/getTimeStories")
	public List<Item> fetchItems(){
		List<Item> ans =storyScrapper.fetch();
		return ans;
	}
}
