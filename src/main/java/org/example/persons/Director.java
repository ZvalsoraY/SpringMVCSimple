package org.example.persons;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    //@NonNull
    private int id;
    //@NonNull
    @NotEmpty(message = "It is needed entry name!")
    @Size(min = 5, max = 32, message = "Length of name must be in 5 to 32 symbols.")
    private String name;
    //@NonNull
    @NotEmpty(message = "It is needed entry department!")
    @Size(min = 5, max = 32, message = "Length of department must be in 5 to 32 symbols.")
    private String department;
    private List<Integer> employees;
}
