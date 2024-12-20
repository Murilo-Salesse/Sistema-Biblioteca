import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Autor autor1 = new Autor(1, "Stephen King", LocalDate.parse("21/09/1947 00:00:00", formatter));
        Autor autor2 = new Autor(2, "J.K. Rowling", LocalDate.parse("31/07/1965 00:00:00", formatter));

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        Livro livro1 = new Livro(1, "Misery", true, LocalDateTime.parse("10/08/2024 00:00:00", formatter),  LocalDateTime.parse("19/12/2024 00:00:00", formatter), autor1);
        Livro livro2 = new Livro(2, "The Shining", false, LocalDateTime.parse("15/05/2022 00:00:00", formatter),LocalDateTime.parse("20/07/2023 00:00:00", formatter), autor1);
        Livro livro3 = new Livro(3, "Carrie", true, LocalDateTime.parse("01/01/2021 00:00:00", formatter), LocalDateTime.parse("15/03/2021 00:00:00", formatter), autor1);
        Livro livro4 = new Livro(4, "Harry Potter and the Sorcerer's Stone", true,LocalDateTime.parse("01/09/1997 00:00:00", formatter),LocalDateTime.parse("20/12/2024 00:00:00", formatter), autor2);
        Livro livro5 = new Livro(5, "Harry Potter and the Chamber of Secrets", false,LocalDateTime.parse("02/07/1998 00:00:00", formatter),LocalDateTime.parse("15/11/2023 00:00:00", formatter), autor2);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (sim/nao): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("sim")) {
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro.getId() + ": " + livro.getTitle());
                    }

                    System.out.println("Digite o ID do livro que você deseja emprestar:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                    if (livroSelecionado != null && livroSelecionado.getAvailable()) {
                        System.out.println("Digite seu nome:");
                        String nomeUsuario = scanner.nextLine();

                        biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
                        System.out.println("O livro " + livroSelecionado.getTitle() + " foi emprestado para " + nomeUsuario);
                    } else {
                        System.out.println("Livro não encontrado ou não disponível para empréstimo.");
                    }
                }
            } else if (resposta.equals("nao")) {
                System.out.println("Obrigado por utilizar o sistema da biblioteca.");
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
            }
        }

        scanner.close();
    }
}