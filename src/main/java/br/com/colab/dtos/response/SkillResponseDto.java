package br.com.colab.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkillResponseDto { 
    private Long id;
    private String name;
    private String description;
    private String image;
}


