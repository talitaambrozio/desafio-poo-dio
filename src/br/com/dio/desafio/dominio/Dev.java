package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>(); //Linked fará com q os
    // cursos inscritos sejam salvos na mesma ordem de inscrição
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    //obs: Set: não permite itens duplicados, se aplica a esse caso pois o dev nao pode se inscrever
    //mais de uma vez em um mesmo curso/mentoria

    //métodos
    public void inscreverBootcamp(Bootcamp bootcamp){
        //assim que se inscrever no Bootcamp, todo os cursos entrarão no Set de conteudosInscritos
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);//add esse Dev no Set de DevsInscritos

    }
    public void progredir(){
        //transfere um conteudo concluido do Set conteudosInscritos para o set conteudosConcluidos
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst(); //considerando que
        //os conteudos dos bootcamps obrigatoriamente sao realizados em ordem, então ele irá procurar
        //o primeiro conteudo do bootcamp(findfirst)
        if(conteudo.isPresent()){//se o conteudo está presente mesmo dentro do conteudosInscritos:
            this.conteudosConcluidos.add(conteudo.get()); //entao add ele no Set de conteudosConcluidos e:
            this.conteudosInscritos.remove(conteudo.get());//remove ele de conteudosInscritos
        }else{
            System.err.println("Você não está inscrito em nenhum conteúdo!");
        }
    }
    public double calcularTotalXp(){

        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

}
