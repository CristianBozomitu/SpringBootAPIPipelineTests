package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public class PostDto {
    @NotNull
    public Long id;
    @NotNull
    public String title;
    @NotNull
    public String content;
}
