package net.javaguides.organizationservice.exception;

public class OrganizationAlreadyExist extends RuntimeException{
    private String message;

    public OrganizationAlreadyExist(String message){
        super(message);
        this.message=message;
    }
}
