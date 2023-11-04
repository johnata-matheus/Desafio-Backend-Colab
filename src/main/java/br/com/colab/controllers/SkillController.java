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

import br.com.colab.dtos.request.SkillRequestDto;
import br.com.colab.dtos.response.SkillResponseDto;
import br.com.colab.models.Skill;
import br.com.colab.services.SkillService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/skills")
public class SkillController {

  @Autowired
  private SkillService skillService;

  @Operation(summary = "Listar", description = "Método que retorna todas as habilidades", tags = "Skills")
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<SkillResponseDto> getAllSkills(){
    List<SkillResponseDto> skillsDto = skillService.getAllSkills();

    return skillsDto;
  }

  @Operation(summary = "Buscar por id", description = "Método que retorna uma habilidade por id", tags = "Skills")
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<SkillResponseDto> getSkillById(@PathVariable (value = "id") Long id){
    return skillService.findSkillById(id);
  }

  @Operation(summary = "Salvar", description = "Método que salva uma habilidade", tags = "Skills")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Skill createSkill(@RequestBody SkillRequestDto skillRequestDto){
    return skillService.createSkill(skillRequestDto);
  }

  @Operation(summary = "Editar por id", description = "Método que edita uma habilidade por id", tags = "Skills")
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Skill> updateSkill(@PathVariable (value = "id") Long id, @RequestBody SkillRequestDto skillRequestDto){
    return skillService.updateSkillById(skillRequestDto, id);
  }

  @Operation(summary = "Deletar por id", description = "Método que deleta uma habilidade por id", tags = "Skills")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Object> deleteSkill(@PathVariable (value = "id") Long id){
    return skillService.deleteSkillById(id);
  }
}
