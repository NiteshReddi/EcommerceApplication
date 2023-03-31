package main.app.response;

import lombok.Data;

@Data
public class RestServiceResponse {

    private int statusCode;

    private String statusMessage;
}
