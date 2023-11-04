package br.com.colab.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionRequestDto {
  private String name;
  private String description;
  private String class_champion;
}
