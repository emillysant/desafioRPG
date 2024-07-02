# Sistema de Batalhas para RPG

O jogo Batalhas de RPG será capaz colocar personagens para se enfrentar em uma batalha. Nessa batalha, os personagens podem ter diferentes classes, que definem suas habilidades e como evoluem, níveis e itens. 

Personagens:
Terão nome, pontosDeVida, força, defesa, pontos de experiencia, nível... Além disso as classes filhas: Arqueiro, Mago, Guerreiro e Inimigo tem atriutos propriedades específicas.

Classes:
Nossos personagens pertencem a classes  distintas. Inicialmente, teremos as classes: arqueiro, guerreiro, mago e monstro. Cada classe define as habilidades, atributos iniciais, habilidades e evolução dos personagens a cada nível, 

|Arqueiro|Guerreiro|Mago|Monstro|
|---|---|---|---|

## Arqueiro

|Habilidade|Dano|Tempo de descanso (unidades)|Alvo|Pontos de Magia|
| --- | --- | --- | --- | --- |

|Atirar flecha|nível&ast;teto(força&ast;0.3+agilidade&ast;0.5)|4|Único|0|


## Guerreiro
|Habilidade|Dano|Tempo de descanso (unidades)|Alvo|Pontos de Magia|
| --- | --- | --- | --- | --- |
|Espada Flamejante|nível&ast;teto(força&ast;0.3+agilidade&ast;0.5 inteligência&ast;0.4)|7|Único|nível&ast;teto(inteligência+força&ast;0.2)|
|Golpe de espada|nível&ast;teto(agilidade&ast;0.3+força&ast;0.7)|5|Único|0|
|Socar|nível&ast;teto(agilidade&ast;0.1+força&ast;0.3)|4|Único|0|

## Mago
|Habilidade|Pontos de Vida|força|defesa
| --- | --- | --- |
|Punho de gelo|23|23|
|Bola de Fogo|23|23

### Inimigo

## Pontos de vida, magia e experiência

Os pontos de vida (PV) de um personagem definem sua resistência a golpes.

Os pontos de experiência (PE) servem para fazer um personagem passar para o próximo nível. A cada nível os pontos de experiência voltam a zero e são necessários mais pontos para subir de nível

## Batalhas
### 1. Início da Batalha:
○ Quando uma batalha começa, todos os personagens e inimigos
participantes são listados.
○ A ordem dos turnos é determinada por um atributo como
velocidade ou destreza, ou, a ordem clássica: personagem ->
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



