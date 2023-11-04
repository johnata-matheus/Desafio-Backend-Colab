package br.com.colab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI customAPI(){
    return new OpenAPI().info(new Info().title("API ColabEduc").version("1.0.0").description("API desenvolvida com base em um jogo, onde é possivel gerenciar um campeão e suas respectivas habilidades."));
  }
}
