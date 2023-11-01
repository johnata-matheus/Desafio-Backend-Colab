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

@RestController
@RequestMapping("/champions")
public class ChampionController {
  
  @Autowired
  private ChampionService championService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ChampionResponseDto> getAllSkills(){
    List<ChampionResponseDto> skillsDto = championService.getAllChampions();

    return skillsDto;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ChampionResponseDto> getChampionById(@PathVariable (value = "id") Long id){
    return championService.findChampionById(id);
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Champion createChampion(@RequestBody ChampionRequestDto championRequestDto){
    return championService.createChampion(championRequestDto);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Champion> updateChampion(@PathVariable (value = "id") Long id, @RequestBody ChampionRequestDto championRequestDto){
    return championService.updateChampionById(championRequestDto, id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Object> deleteChampion(@PathVariable (value = "id") Long id){
    return championService.deleteChampionById(id);
  }

}
