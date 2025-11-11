package projetokura.classes;

public class Materia {
    private String nome;

    // Construtor
    public Materia(String nome) {
        this.nome = nome;
    }

    public static Materia criarNovaMateria(String nome) {
        System.out.println("Matéria criada: " + nome);
        return new Materia(nome);
    }

    public void excluirMateria() {
        System.out.println("Matéria excluída: " + this.nome);
        this.nome = null; // "Exclui" logicamente a matéria
    }

    // Getters e Setters
    public String getNome() { // retorna o nome
        return nome;
    }
    public void setNome(String nome) { // Modifica o nome
        this.nome = nome;
    }

    // toString
    @Override
    public String toString() {
        return nome != null ? nome : "(Matéria excluída)";
    }
}

/*
@Override nesse caso estou usando para aparecer o nomezindo quando meche em vez dos numeros em hexa!
O que faz                           | Por que usar                                         
                                    |                                                      
Sobrescreve um método herdado       | Para mudar o comportamento padrão                    
Ajuda o compilador a detectar erros | Evita bugs por digitação errada                      
Melhora a legibilidade              | Mostra claramente que o método vem de uma classe pai 
*/