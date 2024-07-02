# Sistema de Batalhas para RPG

O jogo Batalhas de RPG será capaz colocar personagens para se enfrentar em uma batalha. Nessa batalha, os personagens podem ter diferentes classes, que definem suas habilidades e como evoluem, níveis e itens. 

Personagens:
Terão nome, pontosDeVida, força, defesa, pontos de experiencia, nível... Além disso as classes filhas: Arqueiro, Mago, Guerreiro e Inimigo tem atriutos propriedades específicas.

Classes:
Nossos personagens pertencem a classes  distintas. Inicialmente, teremos as classes: arqueiro, guerreiro, mago e monstro. Cada classe define as habilidades, atributos iniciais, habilidades e evolução dos personagens a cada nível, 


## Arqueiro
Arqueiro é um personagem especializado em combate à distância. 
Com um total de 100 pontos de vida, uma força de 25 e uma defesa de 5. 
A habilidade nativa "Atirar Flecha" complementa sua destreza e agilidade.

## Guerreiro

Guerreiro é um robusto combatente de curta distância, conhecido por sua resistência e poder de combate direto. 
Com 100 pontos de vida, uma força impressionante de 30 e uma defesa sólida de 30. Equipado com habilidades como "Espada Flamejante" e "Golpe de espada dupla".

## Mago

O MAgo é um conjurador. Com 100 pontos de vida, uma força de 36 e uma defesa de 12, ele equilibra sua fragilidade física com habilidades arcanas devastadoras. 
Equipado com um total de 10 pontos de magia, o Mago utiliza habilidades como "Punho de gelo" e "Bola de Fogo".

## Inimigo

Inimigo: Elfo das Sombras

    Pontos de Vida: 50
    Força: 8
    Defesa: 10
    Habilidades: Chicote (Tipo: Planta, Dano: 5)
    Tipo de Jogador: Elfo

Inimigo: Orc Gigante

    Pontos de Vida: 50
    Força: 10
    Defesa: 8
    Habilidades: Garras Afiadas (Tipo: Física, Dano: 5)
    Tipo de Jogador: Orc

Inimigo: Monstro Devorador

    Pontos de Vida: 50
    Força: 12
    Defesa: 12
    Habilidades: Bola de Fogo (Tipo: Mágica, Dano: 7)
    Tipo de Jogador: Monstro

## Pontos de vida e experiência

Os pontos de vida (PV) de um personagem definem sua resistência a golpes.

Os pontos de experiência (PE) servem para fazer um personagem passar para o próximo nível. A cada nível os pontos de experiência voltam a zero e são necessários mais pontos para subir de nível

## Batalhas
### 1. Início da Batalha:
○ Quando uma batalha começa, todos os personagens e inimigos
participantes são listados.
○ A ordem dos turnos é determinada pelo atributo
pontosDeVida, ou, a ordem clássica: personagem ->
inimigo -> personagem -> inimigo.

### 2. Execução de Turnos:
○ Cada personagem, em sua vez, pode escolher uma ação: atacar,
usar uma habilidade, defender ou fugir.
○ A ação é executada, e seus efeitos são aplicados (por exemplo,
dano ao inimigo, cura de um aliado, etc.).

○ Após a ação, o turno do personagem termina, e o próximo
personagem na ordem realiza sua ação.

### 3. Fim da Rodada:
○ Quando todos os personagens e inimigos tiverem completado
seus turnos, a rodada termina.
○ Se houver personagens ou inimigos ainda de pé, uma nova
rodada começa.
### 4. Fim do Combate:
○ O combate continua até que todos os inimigos ou todos os
personagens sejam derrotados.
○ Após a batalha, os personagens podem receber pontos de
experiência, itens, e outros prêmios.



