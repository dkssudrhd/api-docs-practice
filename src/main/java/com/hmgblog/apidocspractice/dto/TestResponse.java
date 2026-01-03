package com.hmgblog.apidocspractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestResponse {
    Long id;
    String title;
    String content;
}
