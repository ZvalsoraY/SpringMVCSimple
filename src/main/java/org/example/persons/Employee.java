package org.example.persons;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @NonNull
    private int id;
    @NonNull
    @NotEmpty(message = "It is needed entry name!")
    @Size(min = 5, max = 32, message = "Length of name must be in 5 to 32 symbols.")
    private String name;
    @NonNull
    private Level level;
}
