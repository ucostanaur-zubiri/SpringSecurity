package eus.hekuntza.zubiri.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  
    private Long id;
    
    @NotEmpty
    private String username;
    
    @NotEmpty(message = "Password should not be empty")
    private String password;
}
