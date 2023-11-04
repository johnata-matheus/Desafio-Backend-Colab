package br.com.colab.dtos.request;

import br.com.colab.models.Champion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequestDto {
  private String name;
  private String image;
  private String description;
  private Champion champion;
}
