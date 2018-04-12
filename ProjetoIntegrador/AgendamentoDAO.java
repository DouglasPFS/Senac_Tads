package Agendamento.dao;
import Agendamento.model.Agendamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.*;
import java.text.*;
/**
 *
 * @author João Pedro
 */
public class AgendamentoDAO {
    Statement comando;
    
    //Insere dados no banco de dados de agendamento
    public void insere (String cpf_c, String servico, String nome_f,Date data_requisicao, Date hora_requsicao, Date data_atendimento, Date horario_atendimento, Date horario_termino) throws Exception {
        Conexao.conecta();
        try{
            if(procuraCadastro(cpf_c)){
                Agendamento novo = new Agendamento();
                ResultSet rs1=comando.executeQuery("select* from Cliente where CPF like '"+cpf_c+"';");
                ResultSet rs2=comando.executeQuery("select* from Funcionario where Servico like'"+servico+"'and where Nome like'"+nome_f+"';");
                while(rs1.next()){
                    novo.setID_Cliente(rs1.getInt("ID_Cliente"));
                    novo.setID_Funcionario(rs2.getInt("ID_Funcionario"));
                    novo.setID_Servico(rs2.getInt("ID_S"));
                    novo.setData_requsicao(data_requisicao);
                    novo.setHora_requisicao(hora_requsicao);
                    novo.setID_Status(1);
                    novo.setData_atendimento(data_atendimento);
                    novo.setHorario_atendimento(horario_atendimento);
                    novo.setHorario_termino(horario_termino);
                }
                comando.executeQuery("insert into Agenda (ID_C,ID_F,ID_Ser,Data_requisicao,Hora_requisicao,"
                        + "ID_S,Data_atendimento,Horario_atendimento,Horario_termino)"
                        + "VALUES('"+ novo.getID_cliente()+ "', '" + novo.getID_funcionario()+ "',"+ novo.getID_servico()
                        + ",'" + novo.getData_requisicao()+ "','"+ novo.getHora_requisicao()+",'" + novo.getID_Status()
                        + ",'" + novo.getData_atendimento()+",'" + novo.getHorario_ateindimento()+",'" + novo.getHorario_termino()+"')");
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
    }
    
    //Busca de clientes cadastrados
    public boolean procuraCadastro(String cpf) throws Exception{
        Conexao.conecta();
        
        comando = Conexao.statement;
        
        String busca=("select * from Cliente where CPF = '"+cpf+"';");
            

        
        ResultSet rs = comando.executeQuery(busca);
        
        int cont =0;
        while ( rs.next() ) 
            cont++;
        
        Conexao.desconecta();
        return cont>0;
    }
    
    //Busca de funcionários cadastrados
    public Vector<String> buscarFuncionarioS(String servico) throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        Vector<String> func = new Vector<String>();
        ResultSet rs;
        try{
            rs=comando.executeQuery("select * from Funcionario where Servico like '"+servico+"%';");
            while(rs.next()){
                String nome = new String();
                nome=rs.getString("Nome");
                func.add(nome);
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return func;
    }
    
    //Busca de funcionários cadastrados por região
    public Vector<String> buscarFuncionarioR(String regiao) throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        Vector<String> func = new Vector<String>();
        ResultSet rs;
        try{
            rs=comando.executeQuery("select * from Funcionario where Regiao like '"+regiao+"%';");
            while(rs.next()){
                String nome = new String();
                nome=rs.getString("Nome");
                func.add(nome);
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return func;
    }
    
    //Busca de agendamentos realizados em determinado período (definido pelo usuário)
    public Vector<Agendamento> buscarAgendamentosPeriodo(String data1, String data2, int id) throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        Vector<Agendamento> func = new Vector<Agendamento>();
        ResultSet rs;
        try{
            rs=comando.executeQuery("select * from Agenda A join Funcionario B on A.ID_F=B.ID"
                    + " where A.Data_atendimento>='"+data1+"%' and A.Data_Atendimento<='"+data2+
                    "%' and B.ID='"+id+"%' and A.Status = 'Agendado';");
            while(rs.next()){
                Agendamento dados = new Agendamento();
                dados.setID_Cliente(rs.getInt("ID_C"));
                dados.setID_Funcionario(rs.getInt("ID_F"));
                dados.setID_Servico(rs.getInt("ID_Ser"));
                dados.setData_requsicao(rs.getDate("Date_requisicao"));
                dados.setHora_requisicao(rs.getDate("Hora_requisicao"));
                dados.setID_Status(rs.getInt("ID_S"));
                dados.setData_atendimento(rs.getDate("Data_atendimento"));
                dados.setHorario_atendimento(rs.getDate("Horario_atendimento"));
                dados.setHorario_termino(rs.getDate("Horario_termino"));
                func.add(dados);
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return func;
    }
    
    //Busca de agendamentos em espera
    public Vector<Agendamento> buscarAgendamentosEspera() throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        Vector<Agendamento> agend = new Vector<Agendamento>();
        ResultSet rs;
        try{
            rs=comando.executeQuery("select * from Agenda A join Status B on"
                    + " A.Status = B.Tipo where A.Status like 'Espera'");
            while(rs.next()){
                Agendamento dados = new Agendamento();
                dados.setID_Cliente(rs.getInt("ID_C"));
                dados.setID_Funcionario(rs.getInt("ID_F"));
                dados.setID_Servico(rs.getInt("ID_Ser"));
                dados.setData_requsicao(rs.getDate("Date_requisicao"));
                dados.setHora_requisicao(rs.getDate("Hora_requisicao"));
                dados.setID_Status(rs.getInt("ID_S"));
                dados.setData_atendimento(rs.getDate("Data_atendimento"));
                dados.setHorario_atendimento(rs.getDate("Horario_atendimento"));
                dados.setHorario_termino(rs.getDate("Horario_termino"));
                agend.add(dados);
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return agend;
    }
    
    
    public Vector<Agendamento> buscarAgendamentoCanceladosPeriodo(String data1, String data2) throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        Vector<Agendamento> agend = new Vector<Agendamento>();
        ResultSet rs;
        try{
            rs=comando.executeQuery("select*from Agenda A join Status B on"
                    + " A.Status=B.Tipo where A.Data_atendimento>='"+data1+"' and"
                    + " A.Data_Atendimento<='"+data2+"' and A.Status like 'Cancelado'");
            while(rs.next()){
                Agendamento dados = new Agendamento();
                dados.setID_Cliente(rs.getInt("ID_C"));
                dados.setID_Funcionario(rs.getInt("ID_F"));
                dados.setID_Servico(rs.getInt("ID_Ser"));
                dados.setData_requsicao(rs.getDate("Date_requisicao"));
                dados.setHora_requisicao(rs.getDate("Hora_requisicao"));
                dados.setID_Status(rs.getInt("ID_S"));
                dados.setData_atendimento(rs.getDate("Data_atendimento"));
                dados.setHorario_atendimento(rs.getDate("Horario_atendimento"));
                dados.setHorario_termino(rs.getDate("Horario_termino"));
                agend.add(dados);
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return agend;
    }
    
    //Busca agendamentos realizados para o dia atual
    public Vector<Agendamento> buscarAgendamentosDia() throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        Vector<Agendamento> agend = new Vector<Agendamento>();
        ResultSet rs;
        try{
            rs=comando.executeQuery("select * from Agenda A where A.Data_Atendimento = date('now')");
            while(rs.next()){
                Agendamento dados = new Agendamento();
                dados.setID_Cliente(rs.getInt("ID_C"));
                dados.setID_Funcionario(rs.getInt("ID_F"));
                dados.setID_Servico(rs.getInt("ID_Ser"));
                dados.setData_requsicao(rs.getDate("Date_requisicao"));
                dados.setHora_requisicao(rs.getDate("Hora_requisicao"));
                dados.setID_Status(rs.getInt("ID_S"));
                dados.setData_atendimento(rs.getDate("Data_atendimento"));
                dados.setHorario_atendimento(rs.getDate("Horario_atendimento"));
                dados.setHorario_termino(rs.getDate("Horario_termino"));
                agend.add(dados);
            }
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return agend;
    }
    
    //Contagem de servicos realizados por funcionario
    public ResultSet contServicoRealizadoFunc() throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        ResultSet rs = null;
        try{
            rs=comando.executeQuery("select count (A.Protocolo)' as 'Servico Realizado'"
                    + " ,(B.ID) as 'Identificador' , (B.Nome) from Agenda A join Funcionario"
                    + " B on A.ID_F=B.ID join Status C on A.Status = C.Tipo where A.Status like"
                    + " 'Realizado' group by B.Nome order by count (A.Protocolo)desc");
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return rs;
    }
    
    //Contagem de servicos cancelados por funcionario
    public ResultSet contServicoCanceladoFunc() throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        ResultSet rs = null;
        try{
            rs=comando.executeQuery("select count (A.Protocolo)' as 'Servico Cancelado'"
                    + " ,(B.ID) as 'Identificador' , (B.Nome) from Agenda A join Funcionario"
                    + " B on A.ID_F=B.ID join Status C on A.Status = C.Tipo where A.Status like"
                    + " 'Cancelado' group by B.Nome order by count (A.Protocolo)desc");
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return rs;
    }
    
    //Contagem de servico mais realizado
    public ResultSet servicoMaisRealizado(String data1, String data2) throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        ResultSet rs = null;
        try{
            rs=comando.executeQuery("select count (A.Protocolo)' as 'Tipo de servico realizado'"
                    + " ,(B.ID_Servico) as 'Identificador' , (B.Tipo) from Agenda A join Servico"
                    + " B on A.Servico=B.Tipo join Status C on A.Status = C.Tipo where A.Data_Atendimento"
                    + " >='"+ data1 + "'and A.Data+Atendimento<='" + data2 + "' and A.Status like 'Realizado'"
                    + " group by B.Tipo order by count (A.Protocolo)desc");
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return rs;
    }
    
    public ResultSet servicoFuncionario(String Servico) throws Exception{
        Conexao.conecta();
        comando = Conexao.statement;
        ResultSet rs = null;
        try{
            rs=comando.executeQuery("select * from Servico A join Funcionario B on A.ID_Servico = B.ID_S where A.Tipo = '"+Servico+"';");
        } catch (SQLException e){
            System.out.println("ERRO!");
        } finally {
            Conexao.desconecta();
        }
        return rs;
    }
}
