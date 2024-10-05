package model;
import java.util.Date;

public class Tutor extends Pessoa{
    private int numDeAnimais;
    private String adocoes;
    private String status;

    public Tutor(){}

    public Tutor(String nome, String dataDeNascimento, String genero, String cpf,
                 String endereco, String telefone, String email, String senha,
                 int idTutor, int numDeAnimais, String adocoes, String status) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);
        this.addPapel("idTutor", idTutor);
        this.numDeAnimais = numDeAnimais;
        this.adocoes = adocoes;
        this.status = status;
    }

    public int getNumDeAnimais() {
        return numDeAnimais;
    }

    public void setNumDeAnimais(int numDeAnimais) {
        this.numDeAnimais = numDeAnimais;
    }

    public String getAdocoes() {
        return adocoes;
    }

    public void setAdocoes(String adocoes) {
        this.adocoes = adocoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "nome='" + getNome() + '\'' +
                ", dataDeNascimento='" + getDataDeNascimento() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", papeis=" + getPapeis() +
                ", numDeAnimais=" + numDeAnimais +
                ", adocoes='" + adocoes + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
