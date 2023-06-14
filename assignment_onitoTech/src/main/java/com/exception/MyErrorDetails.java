package com.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyErrorDetails {
	
	private LocalDateTime time;
	private String message;
	private String description;

}
