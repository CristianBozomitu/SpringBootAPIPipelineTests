package com.example.demo.controller;


import jakarta.validation.constraints.NotNull;

public record ResponseTemplate<T>(@NotNull T data) {
}


