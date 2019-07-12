package com.mytoshika.auth.exception;

public class GenericResponse
{
    private String status;
    private String message;
    
    public GenericResponse()
    {
        super();
    }
    public GenericResponse(String status, String message)
    {
        super();
        this.status = status;
        this.message = message;
    }
    
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    @Override
    public String toString()
    {
        return "ErrorResponse [status=" + status + ", message=" + message + "]";
    }
}