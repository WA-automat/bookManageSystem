package com.example.backend.controller;

import com.example.backend.service.book.UpdateDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateBookDescriptionController {

	@Autowired
	private UpdateDescriptionService updateDescriptionService;

	@RequestMapping("/update/{reader}/{title}/{author}/{newDescription}")
	public String update(
			@PathVariable("reader") String reader,
			@PathVariable("title") String title,
			@PathVariable("author") String author,
			@PathVariable("newDescription") String newDescription
	) {
		return updateDescriptionService.updateDescription(
				reader,title, author, newDescription
		);
	}

}
