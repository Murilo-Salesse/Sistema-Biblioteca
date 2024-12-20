import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
        private List<Livro> livros = new ArrayList<Livro>();
        private List<Autor> autores = new ArrayList<Autor>();
        private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

        public void adicionarLivro(Livro livro) {
            livros.add(livro);
        }

        public List<Livro> listarLivros() {
            return livros;
        }

        public List<Livro> listarLivrosDisponiveis() {
            List<Livro> livrosDisponiveis = new ArrayList<>();
            for (Livro livro : livros) {
                if (livro.getAvailable()) {
                    livrosDisponiveis.add(livro);
                }
            }
            return livrosDisponiveis;
        }

        public Livro buscarLivroPorId(int id) {
            for (Livro livro : livros) {
                if (livro.getId() == id) {
                    return livro;
                }
            }
            return null;
        }

        public void atualizarLivro(int id, String novoTitulo) {
            for (Livro livro : livros) {
                if (livro.getId() == id) {
                    livro.setTitle(novoTitulo);
                    break;
                }
            }
        }

        public void removerLivro(int id) {
            livros.removeIf(livro -> livro.getId() == id);
        }


        public void adicionarAutor(Autor autor) {
            autores.add(autor);
        }

        public List<Autor> listarAutores() {
            return autores;
        }

        public void atualizarAutor(int id, String novoNome) {
            for (Autor autor : autores) {
                if (autor.getId() == id) {
                    autor.setName(novoNome);
                    break;
                }
            }
        }

        public void removerAutor(int id) {
            autores.removeIf(autor -> autor.getId() == id);
        }

        public void emprestarLivro(Livro livro, String nomeUsuario) {
            if (livro.getAvailable()) {
                Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
                emprestimos.add(emprestimo);
                livro.setAvailable(false);
            } else {
                System.out.println("Livro não disponível para empréstimo.");
            }
        }

        public void devolverLivro(int idEmprestimo) {
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()) {
                    emprestimo.devolverLivro();
                    break;
                }
            }
        }

        public List<Emprestimo> listarEmprestimos() {
            return emprestimos;
        }
}
