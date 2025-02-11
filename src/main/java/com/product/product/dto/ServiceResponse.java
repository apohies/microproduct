package com.product.product.dto;

import lombok.Data;
import java.util.List;

@Data
public class ServiceResponse<T> {
    private T data;
    private String message;
    private String status;
    private List<String> errors;

    // Constructor para respuestas exitosas con datos
    public static <T> ServiceResponse<T> success(T data) {
        ServiceResponse<T> response = new ServiceResponse<>();
        response.setData(data);
        response.setStatus("SUCCESS");
        response.setMessage("Operación exitosa");
        return response;
    }

    // Constructor para respuestas exitosas con mensaje
    public static <T> ServiceResponse<T> success(String message) {
        ServiceResponse<T> response = new ServiceResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage(message);
        return response;
    }

    // Constructor para respuestas de error
    public static <T> ServiceResponse<T> error(String message, List<String> errors) {
        ServiceResponse<T> response = new ServiceResponse<>();
        response.setStatus("ERROR");
        response.setMessage(message);
        response.setErrors(errors);
        return response;
    }
}