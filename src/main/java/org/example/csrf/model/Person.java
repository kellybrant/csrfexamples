package org.example.csrf.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Data
public class Person {

    @Valid
    @Size(min=3, message = "First Name is too short")
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
    	return new StringBuilder()
    			.append("\nfirstName : ").append(firstName)
    			.append("\nlastName  : ").append(lastName)
    			.append("\n")
    			.toString();
    }

}
