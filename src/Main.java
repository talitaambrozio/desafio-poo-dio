import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
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


        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do Curso Java");
        curso1.setCargaHoraria(8);

        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição do Curso JavaScript");
        curso2.setCargaHoraria(7);

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao do Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("Talita");
        dev1.inscreverBootcamp(bootcamp);


        Dev dev2 = new Dev();
        dev2.setNome("Joao");
        dev2.inscreverBootcamp(bootcamp);

        System.out.println("-------------------------------");
        System.out.println("Conteúdos inscritos de " + dev1.getNome() + dev1.getConteudosInscritos());
        dev1.progredir();
        System.out.println("Conteúdos inscritos de " + dev1.getNome() + dev1.getConteudosInscritos());
        System.out.println("Conteúdos concluidos de " + dev1.getNome() + dev1.getConteudosConcluidos());

        System.out.println("Total de Xp de " + dev1.getNome() + ": "+ dev1.calcularTotalXp());

        System.out.println("--------------------------------");
        System.out.println("Conteúdos inscritos de " + dev2.getNome() + dev2.getConteudosInscritos());
        dev2.progredir();
        System.out.println("Conteúdos inscritos de " + dev2.getNome() + dev2.getConteudosInscritos());
        System.out.println("Conteúdos concluidos de "+ dev2.getNome() + dev2.getConteudosConcluidos());
        System.out.println("Total de Xp de  " + dev2.getNome() + ": " + dev2.calcularTotalXp());


    }
}
