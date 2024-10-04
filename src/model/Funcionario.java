package model;
import java.util.Date;

public class Funcionario extends Pessoa {
    private String dataContratacao;
    private String cargo;
    private float salario;
    private String departamento;

    public Funcionario(String nome, String dataDeNascimento, String genero, String cpf,
                       String endereco, String telefone, String email, String senha,
                       int idFuncionario, String dataContratacao, String cargo, float salario,
                       String departamento) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);
        this.addPapel("idFuncionario", idFuncionario);
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", dataDeNascimento='" + getDataDeNascimento() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", papeis=" + getPapeis() +
                ", dataContratacao='" + dataContratacao + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario='" + salario + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
