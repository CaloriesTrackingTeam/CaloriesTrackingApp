package com.example.caloriestracking.Response;

public class ResponseLogin {
    private String status;
    private String message;
    private DataLoginT3 data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLoginT3 getData() {
        return data;
    }

    public void setData(DataLoginT3 data) {
        this.data = data;
    }

    public ResponseLogin(String status, String message, DataLoginT3 data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
