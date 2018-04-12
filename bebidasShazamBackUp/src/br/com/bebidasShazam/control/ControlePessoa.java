package br.com.bebidasShazam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bebidasShazam.entites.ClientePF;
import br.com.bebidasShazam.entites.Endereco;
import br.com.bebidasShazam.persistence.EnderecoDAO;

@WebServlet("/ControlePessoa")
public class ControlePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControlePessoa() {
    	
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String acao = request.getParameter("acao");
    	
    	if(acao.equalsIgnoreCase("cadastrarPF")){
    		
    		try {
				
    			Endereco endereco = new Endereco();
        		
        		endereco.setLogradouro(request.getParameter("logradouro"));
        		endereco.setBairro(request.getParameter("bairro"));
        		endereco.setCep(request.getParameter("cep"));
        		endereco.setCidade(request.getParameter("cidade"));
        		endereco.setEstado(request.getParameter("estado"));
        		
        		EnderecoDAO enderecoDao = new EnderecoDAO();
        		
        		int idEndereco = enderecoDao.insertEndereco(endereco);
        		
        		ClientePF clientePf = new ClientePF();
        		
        		clientePf.setNome(request.getParameter("nome"));
        		clientePf.setTelefone(request.getParameter("telefone"));
        		clientePf.setCpf(Integer.parseInt(request.getParameter("cpf")));
        		clientePf.setEndereco(idEndereco);
        		
        		
        		
    			
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		execute(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);
		
	}

}
