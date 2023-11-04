package br.com.colab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.colab.dtos.request.ChampionRequestDto;
import br.com.colab.dtos.response.ChampionResponseDto;
import br.com.colab.models.Champion;
import br.com.colab.services.ChampionService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/champions")
public class ChampionController {
  
  @Autowired
  private ChampionService championService;

  @Operation(summary = "Listar", description = "Método que retorna todos os campeões", tags = "Champions")
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ChampionResponseDto> getAllSkills(){
    List<ChampionResponseDto> skillsDto = championService.getAllChampions();

    return skillsDto;
  }

  @Operation(summary = "Buscar por id", description = "Método que retorna um campeão por id", tags = "Champions")
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ChampionResponseDto> getChampionById(@PathVariable (value = "id") Long id){
    return championService.findChampionById(id);
  }
  
  @Operation(summary = "Salvar", description = "Método que salva um campeão", tags = "Champions")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Champion createChampion(@RequestBody ChampionRequestDto championRequestDto){
    return championService.createChampion(championRequestDto);
  }

  @Operation(summary = "Editar por id", description = "Método que edita um campeão por id", tags = "Champions")
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Champion> updateChampion(@PathVariable (value = "id") Long id, @RequestBody ChampionRequestDto championRequestDto){
    return championService.updateChampionById(championRequestDto, id);
  }

  @Operation(summary = "Deletar por id", description = "Método que deleta um campeão por id", tags = "Champions")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Object> deleteChampion(@PathVariable (value = "id") Long id){
    return championService.deleteChampionById(id);
  }

}
