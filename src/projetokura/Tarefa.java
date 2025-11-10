package projetokura;

import java.time.LocalDate; //para data
import java.util.Scanner; //para scanf do java

public class Tarefa {
    private String titulo;
    private Materia materia; //pq materia é classe.
    private String descricao;
    private LocalDate dataEntrega;
    private Prioridade prioridade; // enum Prioridade
    private boolean checklist; // true concluida farse não concluida

    // Construtor.
    public Tarefa(String titulo, Materia materia, String descricao, LocalDate dataEntrega, Prioridade prioridade) {
        this.titulo = titulo;
        this.materia = materia;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.prioridade = prioridade;
        this.checklist = false;
    }

    public static Tarefa criarNovaTarefa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nCriar nova tarefa");
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Matéria: ");
        String nomeMateria = sc.nextLine();
        Materia materia = new Materia(nomeMateria);

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Data de entrega (AAAA-MM-DD): ");
        LocalDate dataEntrega = LocalDate.parse(sc.nextLine());

        System.out.print("Prioridade (Alta / Média / Baixa): ");
        String prioridade = sc.nextLine();

        System.out.println("Tarefa criada com sucesso!\n");
        return new Tarefa(titulo, materia, descricao, dataEntrega, prioridade);
    }

    public void excluirTarefa() {
        this.ativa = false;
        System.out.println("🗑️ Tarefa excluída: " + this.titulo);
    }

    public void alterarTarefa() {
        if (!ativa) {
            System.out.println("❌ Esta tarefa foi excluída e não pode ser alterada.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nAlterar tarefa");
        System.out.println("Pressione ENTER para manter o valor atual ou digite 'cancelar' a qualquer momento para desistir.");

        // Cópias temporárias (só confirma no final)
        String novoTitulo = this.titulo;
        Materia novaMateria = this.materia;
        String novaDescricao = this.descricao;
        LocalDate novaDataEntrega = this.dataEntrega;
        String novaPrioridade = this.prioridade;

        // Título
        System.out.print("Título atual (" + this.titulo + "): ");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) {
            System.out.println("?Alteração cancelada.");
            return;
        } else if (!input.isEmpty()) {
            novoTitulo = input;
        }

        // Matéria
        System.out.print("Matéria atual (" + this.materia.getNome() + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) {
            System.out.println("Alteração cancelada.");
            return;
        } else if (!input.isEmpty()) {
            novaMateria = new Materia(input);
        }

        // 🔸 Descrição
        System.out.print("Descrição atual (" + this.descricao + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) {
            System.out.println("Alteração cancelada.");
            return;
        } else if (!input.isEmpty()) {
            novaDescricao = input;
        }

        // 🔸 Data de entrega
        System.out.print("Data de entrega atual (" + this.dataEntrega + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) {
            System.out.println("Alteração cancelada.");
            return;
        } else if (!input.isEmpty()) {
            novaDataEntrega = LocalDate.parse(input);
        }

        // 🔸 Prioridade
        System.out.print("Prioridade atual (" + this.prioridade + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("cancelar")) {
            System.out.println("Alteração cancelada.");
            return;
        } else if (!input.isEmpty()) {
            novaPrioridade = input;
        }

        // Confirmar alterações
        this.titulo = novoTitulo;
        this.materia = novaMateria;
        this.descricao = novaDescricao;
        this.dataEntrega = novaDataEntrega;
        this.prioridade = novaPrioridade;

        System.out.println("✅ Alterações salvas com sucesso!\n");
    }

    @Override
    public String toString() {
        if (!ativa) {
            return "(Tarefa excluída)";
        }
        return "Tarefa {" +
                "\n  Título: " + titulo +
                "\n  Matéria: " + materia +
                "\n  Descrição: " + descricao +
                "\n  Data de Entrega: " + dataEntrega +
                "\n  Prioridade: " + prioridade +
                "\n}";
    }
}
