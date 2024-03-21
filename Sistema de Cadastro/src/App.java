import java.util.*;

public class App {
    static Turma[] turmas = new Turma[10];
    static Campus[] campi = new Campus[10];
    static Curso[] cursos = new Curso[10];
    static Estudante[] alunos = new Estudante[10];
    static Matricula[] matriculas = new Matricula[10];
    static int quantidadeCurso = 0;
    static int quantidadeTurma = 0;
    static int quantidadeCampus = 0;
    static int quantidadeEstudante = 0;
    static int quantidadeMatricula = 0;
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int escolha = 0;

        do {
            limparConsole(); // Limpar Tela
            exibirMenu();
            escolha = teclado.nextInt();
            teclado.nextLine(); // Consumir Quebra de Linha
            limparConsole(); // Limpar Tela
            tomarDecisao(escolha);
        } while (escolha != 0);
    }

    public static void tomarDecisao(int escolha) {
        switch (escolha) {
            case 1:
                cadastrarTurma();
                break;
            case 2:
                cadastrarCampus();
                break;
            case 3:
                cadastrarCurso();
                break;
            case 4:
                cadastrarEstudante();
                break;
            case 5:
                cadastrarMatricula();
                break;   
            case 6:
                gerarRelatorio();
                break;
            default:
                if(escolha != 0){
                    System.out.println("Opção Inválida!");
                }
                break;
        }
    }

    public static void gerarRelatorio() {
        if(quantidadeTurma > 0){
            System.out.println("============ TURMAS CADASTRADAS ============");
            for (int i = 0; i < quantidadeTurma; i++) {
                System.out.println("Nome Turma: " + turmas[i].nome);
                System.out.println("Número Mínimo: " + turmas[i].numeroMinimo);
                System.out.println("Ano de Ingresso: " + turmas[i].anoIngresso);
                System.out.println("--------------------------------------------");            
            }
            System.out.println("");
        }   

        if(quantidadeCampus > 0){
                System.out.println("============= CAMPI CADASTRADOS ============");
            for (int i = 0; i < quantidadeCampus; i++) {
                System.out.println("Nome Campus: " + campi[i].nome);
                System.out.println("Cidade: " + campi[i].cidade);
                System.out.println("Endereço : " + campi[i].endereco);
                System.out.println("--------------------------------------------");  
            }
            System.out.println("");
        }

        if(quantidadeCurso > 0) {
            System.out.println("============ CURSOS CADASTRADOS ============");
            for (int i = 0; i < quantidadeCurso; i++) {
                System.out.println("Nome do Curso: " + cursos[i].nome);
                System.out.println("Modalidade do Curso: " + cursos[i].modalidade);
                System.out.println("Duração do Curso: " + cursos[i].duracao);
                System.out.println("-------------------------------------------"); 
            }
            System.out.println("");
        }

        if(quantidadeEstudante > 0){
            System.out.println("========== ESTUDANTES CADASTRADOS ==========");
            for (int i = 0; i < quantidadeEstudante; i++) {
                System.out.println("Nome do Estudante: " + alunos[i].nome);
                System.out.println("CPF do Estudante: " + alunos[i].cpf);
                System.out.println("Telefone Estudante: " + alunos[i].telefone);
                System.out.println("Endereço Estudante: " + alunos[i].endereco);
                System.out.println("Data de Nascimento: " + alunos[i].dataNascimento);
                System.out.println("--------------------------------------------");
            }
            System.out.println("");
        }

        if(quantidadeMatricula > 0){
            System.out.println("========== MATRÍCULAS CADASTRADAS ==========");
            for (int i = 0; i < quantidadeMatricula; i++) {
                System.out.println("RA da Matrícula: " + matriculas[i].ra);                
                System.out.println("Data da Matrícula: " + matriculas[i].data);
                System.out.println("Status da Matrícula: " + matriculas[i].situacao);
                System.out.println("--------------------------------------------");
            }
            System.out.println("");
        }
        teclado.nextLine(); // Aguardar Entrada (Ler Relatório) para Seguir o Código
    }


    public static void cadastrarMatricula() {
        Matricula matricula = new Matricula();
        System.out.printf("RA da Matrícula: ");
        matricula.ra = teclado.nextLine();
        System.out.printf("Data de Matrícula: ");
        matricula.data = teclado.nextLine();
        System.out.printf("Status da Matricula: ");
        matricula.situacao = teclado.nextBoolean();
        matriculas[quantidadeMatricula] = matricula;
        quantidadeMatricula++; 
    }

    public static void cadastrarEstudante() {
        Estudante aluno = new Estudante();
        System.out.printf("Nome do Aluno: ");
        aluno.nome = teclado.nextLine();
        System.out.printf("CPF do Aluno: ");
        aluno.cpf = teclado.nextLine();
        System.out.printf("Telefone do Aluno: ");
        aluno.telefone = teclado.nextLine();
        System.out.printf("Endereço do Aluno: ");
        aluno.endereco = teclado.nextLine();
        System.out.printf("Data de Nascimento: ");
        aluno.dataNascimento = teclado.nextLine();
        alunos[quantidadeEstudante] = aluno;
        quantidadeEstudante++;
    }

    public static void cadastrarCurso() {
        Curso curso = new Curso();
        System.out.printf("Nome do Curso: ");
        curso.nome = teclado.nextLine();
        System.out.printf("Duração do Curso: ");
        curso.duracao = teclado.nextLine(); 
        System.out.printf("Modalidade do Curso: "); 
        curso.modalidade = teclado.nextLine();
        cursos[quantidadeCurso] = curso;
        quantidadeCurso++;
    }

    public static void cadastrarCampus() {
        Campus campus = new Campus();
        System.out.printf("Nome do Campus: ");
        campus.nome = teclado.nextLine();
        System.out.printf("Cidade do Campus: ");
        campus.cidade = teclado.nextLine();
        System.out.printf("Endereço do Campus:");
        campus.endereco = teclado.nextLine();
        campi[quantidadeCampus] = campus;
        quantidadeCampus++;
    }

    public static void cadastrarTurma() {
        Turma turma = new Turma();
        System.out.printf("Digite o Nome da Turma: ");
        turma.nome = teclado.nextLine();
        System.out.printf("Digite o Número Mínimo de Alunos: ");
        turma.numeroMinimo = teclado.nextInt();
        System.out.printf("Digite o Ano de Ingresso: ");
        turma.anoIngresso = teclado.nextInt();
        turmas[quantidadeTurma] = turma;
        quantidadeTurma++;
    }

    public static void exibirMenu() {
        System.out.println("========= MENU PRINCIPAL =========");
        System.out.println("1. Cadastro de Turma");
        System.out.println("2. Cadastro de Campus");
        System.out.println("3. Cadastro de Curso");
        System.out.println("4. Cadastro de Estudante");
        System.out.println("5. Cadastro de Matrícula");
        System.out.println("6. Exibir Tudo");
        System.out.println("0. Sair");
        System.out.println("==================================");
    }

    public static void limparConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) { // Limpar Console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // Limpar Console no Linux ou MacOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar a tela: " + e.getMessage());
        }
    }
}
