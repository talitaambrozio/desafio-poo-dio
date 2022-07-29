import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso(); //instanciando o objeto curso
        Curso curso2 = new Curso(); //instanciando o objeto curso
        Mentoria mentoria1 = new Mentoria();

        mentoria1.setTitulo("Mentoria de java");
        mentoria1.setDescricao("Descrição da Mentoria de Java");
        mentoria1.setData(LocalDate.now());
        System.out.println(mentoria1);

        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do Curso Java");
        curso1.setCargaHoraria(8);

        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição do Curso JavaScript");
        curso2.setCargaHoraria(7);

        System.out.println(curso1);
        System.out.println(curso2);

    }
}
