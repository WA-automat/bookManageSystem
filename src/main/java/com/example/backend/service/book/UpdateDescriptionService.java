package com.example.backend.service.book;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
public interface UpdateDescriptionService {
	public String updateDescription(String reader,
	                                String title,
	                                String author,
	                                String newDescription);
}
