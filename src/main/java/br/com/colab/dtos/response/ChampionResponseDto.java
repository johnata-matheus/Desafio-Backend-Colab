package br.com.colab.dtos.response;

import java.util.List;

import br.com.colab.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionResponseDto {
  private Long id;
  private String name;
  private String description;
  private String class_champion;
  private List<Skill> skills;
}
