package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
	/* MODULO DE CONEXÃO */
	
	// AULA 13
	
	//1º Parte: Parâmetros de conexão
	
	private String driver = "org.mariadb.jdbc.Driver";
	private String url_conexao = "jdbc:mariadb://localhost:3306/agenda_db?useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false\n";
    private String usuario = "estudo";
    private String senha = "7powerbsu@";
	
	
	//2° Parte: Método de conexão
    
    private Connection conectar() {
    	Connection testeConexao = null;
    	try {
			Class.forName(driver); // VAI LER O DRIVER DO BANCO DE DADOS.
			testeConexao = DriverManager.getConnection(url_conexao, usuario, senha);
			return testeConexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
    /*
    // TESTANDO A CONEXAO
    public void testeConexao() {
    	try {
    		Connection conexao = conectar();  // O OBJETO testeConexao invoca o método conectar.  
    		System.out.println(conexao);
    		conexao.close();
    		}
    	catch (Exception e) {
			System.out.println(e);
		}
    	
    } */
    
}
