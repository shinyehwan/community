package com.ll.exam.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class ArticleDto {

	private long id;
	private String title;
	private String body;

}
