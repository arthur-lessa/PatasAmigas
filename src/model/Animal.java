package model;
import java.util.Date;

public class Animal {

    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String sexo;
    private String historicoMedico;

    // Mudar para Date futuramente
    private String dataDeResgate;
    private String foto;
    private String statusDeAdocao;

    public Animal(String nome, String especie, String raca, int idade, String sexo, String historicoMedico, String dataDeResgate, String foto, String statusDeAdocao) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.historicoMedico = historicoMedico;
        this.dataDeResgate = dataDeResgate;
        this.foto = foto;
        this.statusDeAdocao = statusDeAdocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataDeResgate() {
        return dataDeResgate;
    }

    public void setDataDeResgate(String dataDeResgate) {
        this.dataDeResgate = dataDeResgate;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatusDeAdocao() {
        return statusDeAdocao;
    }

    public void setStatusDeAdocao(String statusDeAdocao) {
        this.statusDeAdocao = statusDeAdocao;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", historicoMedico='" + historicoMedico + '\'' +
                ", dataDeResgate='" + dataDeResgate + '\'' +
                ", foto='" + foto + '\'' +
                ", statusDeAdocao='" + statusDeAdocao + '\'' +
                '}';
    }
}
