package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@NoArgsConstructor
public class CreatePostDto {
    @NotNull
    public String title;

    @NotNull
    public String content;
}
