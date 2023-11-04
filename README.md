# Desafio-Backend-Colab
Este projeto se trata de uma API desenvolvida com base em um jogo, onde é possivel gerenciar um campeão e suas respectivas habilidades. Assim, a mesma foi desenvolvida ultilizando Java, Java Spring e MYSQL como banco de dados.

# Requisitos
Para rodar esse projeto, você precisa ter o Java e o MYSQL instalados em sua máquina.

# Instalação
1. Clonar o repositório:
```
git clone https://github.com/johnata-matheus/Desafio-Backend-Colab.git
```
2. Instalar as depedências com maven

# Configuração
No projeto foi utilizada a porta 3308 do MYSQL. Dessa forma, se estiver usando outra porta do MYSQL, faça a alteração da mesma em src/main/resources/application.properties:

```
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3308/colab
```

# Documentação
Para saber como usar os ENDPOINTS e suas funcionalidades, confira a documentação da api, iniciando a aplicação e acessando: http://localhost:8080/swagger-ui/index.html

![image](https://github.com/johnata-matheus/Desafio-Backend-Colab/assets/105123252/d8869733-5e3a-481c-8f41-a275785dd81a)


```
Exemplo de um endpoint:

POST /skills
```
```json
[
  {
        "name" : "A ESPADA DARKIN",
  	"image" : "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg",
  	"description" : "Aatrox bate sua espada no chão, causando Dano Físico.",
  	"champion" : {
  		"id" : 1
  	}
  }
]
```

