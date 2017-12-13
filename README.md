![GitHub Logo](/data/java.jpg)

#APS03

## Objetivo:
Implementar a comparação de objetos de forma que se possa ordenar objetos a partir de atributos arbitrários.

## Definição:

É possível comparar dois objetos a partir de seus atributos. Podemos comparar objetos com relação a sua identidade, equivalência ou ordem.

Um objeto é identico ao outro quando são o mesmo objeto, e nesse casso, a comparação deve ser realizada a partir das referências e o operador de igualdade (==). Um objeto é equivalente ao outro quando não conseguimos, a partir dos seus atributos, diferenciar entre ambos, mesmo que não sejam o mesmo objeto, e para realizar esta comparação implementamos o método "equals".

Para ordenar objetos é necessário que seja possível identificar uma ordem entre dois objetos, para que se possa afirma qual vem "antes". A ordenação pode ser realizada de diversas formas, e independente do que signifique para a aplicação, afirmar que um objeto vem antes do outro é o mesmo que afirmar que um objeto é "menor" que o outro, ou seja, dados dois objetos A e B, o objeto A "vem antes" de B, se A <= B.

A comparação de objetos com o objetivo de ordená-los não pode ser realizada com os operadores relacionais (<, >, <=, >=), uma vez que estes operadores iriam executar a comparação com relação às referências dos objetos, e não com relação ao seu conteúdo.

A linguagem de programação Java não provê um operador para comparar dois objetos com relação a sua ordenação, e também não provê um método na classe Object para tal fim. Apesar disso, a linguagem provê duas formas de comparação de objetos, uma forma de comparação natural para o objeto, implementada na própria classe, que utiliza a interface java.lang.Comparable<T>, e uma forma de comparação que permite o controle sobre a ordenação de forma externa a classe, permitindo uma ordenação não-natural, utilizando a interface java.util.Comparable<T>.

Em ambos os casos, um método de comparação é utilizado, retornando um inteiro, que pode ser, menor que zero, maior que zero, ou igual a zero.

Nesta APS, você deve demonstrar duas comparações de objetos Alunos, a primeira utilizando o Nome, e a segunda, utilizando a Empresa e o Email.