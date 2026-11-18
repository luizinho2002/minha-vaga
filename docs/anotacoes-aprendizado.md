# MinhaVaga - Anotações

## Variáveis

Uma variável guarda um valor que pode ser utilizado pelo programa.

Exemplo:

`String empresa = "CELEPAR;"`

- `String` é o tipo do dado.
- `empresa` é o nome da variável.
- `=` atribui o valor à variável.
- `"CELEPAR"` é o valor armazenado.

Outro exemplo:

`String cargo = "Estágio em Desenvolvimento";`

- Tipo: `String`
- Nome da variável: `cargo`
- Valor: `"Estágio em Desenvolvimento"`

Ao alterar o valor armazenado em uma variável e executar o programa novamente, a saída também muda.

## Entrada de dados com Scanner

`import java.util.Scanner;`

Importa a classe `Scanner` para que possamos receber informações via terminal.

`Scanner scanner = new Scanner(System.in);`

Aqui estamos criando um objeto do tipo `Scanner` para receber essas informações via terminal.

`System.out.print("Digitr a empresa: ");`

Pede para o usuário o nome da empresa.

`String empresa = scanner.nextLine();`

Lê o nome que o usuário digitou e armazena na variável `empresa`.

`scanner.close();`

Fecha o `Scanner`, pois não vamos mais receber informações via terminal.

## Validação com if

`if (empresa.isBlank()) {`

Se o nome da empresa estiver vazaio, com espaços ou tabulações, o programa executa o código dentro do `if`.

`System.out.println("O nome da empresa é obrigatório.");`

Exibe a mensagem quando a condição do `if` é verdadeira.

`scanner.close();`

Fecha o `Scanner`, pois não vamos mais receber informações pelo terminal.

`return;`

Encerra a execução do método `main`, impedindo o restante do programa de continuar.