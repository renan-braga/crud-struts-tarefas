package org.apache.struts.example.crud.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.example.crud.bd.Conexao;
import org.apache.struts.example.crud.model.Tarefa;

public class TarefaDao implements ITarefaDao {

    private static ArrayList<Tarefa> tarefas;

	private Conexao conexao = null;
	ResultSet rs;
	
	public TarefaDao() {
		this.conexao = Conexao.getInstance();
	}
	
	public List<Tarefa> listarTarefas() {
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		String sql = "SELECT * FROM tarefa";
		try {
			PreparedStatement pstm = conexao.getConexao().prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt(1));
				tarefa.setDescricao(rs.getString(2));
				tarefa.setFinalizado(rs.getBoolean(3));
				tarefa.setDtFinalizado(rs.getDate(4) != null ? rs.getDate(4).toLocalDate() : null);
				tarefa.setDtCriacao(rs.getDate(5) != null ? rs.getDate(5).toLocalDate() : null);
				tarefa.setDtUltAt(rs.getDate(6) != null ? rs.getDate(6).toLocalDate() : null);
				tarefa.setExcluido(rs.getBoolean(7));
				if(!tarefa.isExcluido()) {
					tarefas.add(tarefa);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarefas;
		
	}
    public Tarefa getTarefa(Integer id) {
        Tarefa tarefa = null;
        for (Tarefa tarefaTemp : listarTarefas()) {
            tarefa = tarefaTemp;
            if (tarefa.getId().equals(id)) {
                break;
            }
        }
        return tarefa;
    }

    public void update(Tarefa tarefa) {
        tarefa.setDtUltAt(LocalDate.now());
        
        String sql = "UPDATE tarefa SET descricao=?, finalizado=?, dt_finalizado=?, dt_criacao=?, dt_ult_alt=?, excluido=? WHERE id=?";
        
        try {
			PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(sql);
			preparedStatement.setString(1, tarefa.getDescricao());
			preparedStatement.setBoolean(2, tarefa.isFinalizado());

			preparedStatement.setDate(3, tarefa.getDtFinalizado() != null 
					? Date.valueOf(tarefa.getDtFinalizado())
					: null);
			
			preparedStatement.setDate(4, tarefa.getDtCriacao() != null 
					? Date.valueOf(tarefa.getDtCriacao())
					: null);			
			
			preparedStatement.setDate(5, tarefa.getDtUltAt() != null 
					? Date.valueOf(tarefa.getDtUltAt())
					: null);		
			
			preparedStatement.setBoolean(6, tarefa.isExcluido());
			preparedStatement.setInt(7, tarefa.getId());
			
			preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
        
    }

    public void insert(Tarefa tarefa) {
        tarefa.setDtCriacao(LocalDate.now());
        tarefa.setFinalizado(false);
        tarefa.setExcluido(false);

        String sql = "INSERT INTO tarefa (descricao, finalizado, dt_finalizado, dt_criacao, dt_ult_alt, excluido) VALUES (?,?,?,?,?,?)";
        
        try {
			PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(sql);
			preparedStatement.setString(1, tarefa.getDescricao());
			preparedStatement.setBoolean(2, tarefa.isFinalizado());

			preparedStatement.setDate(3, tarefa.getDtFinalizado() != null 
					? Date.valueOf(tarefa.getDtFinalizado())
					: null);
			
			preparedStatement.setDate(4, tarefa.getDtCriacao() != null 
					? Date.valueOf(tarefa.getDtCriacao())
					: null);			
			
			preparedStatement.setDate(5, tarefa.getDtUltAt() != null 
					? Date.valueOf(tarefa.getDtUltAt())
					: null);		
			
			preparedStatement.setBoolean(6, tarefa.isExcluido());
			preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
        
    }


    public void delete(Integer id) {
    	Tarefa tarefa = getTarefa(id);
    	tarefa.setExcluido(true);
    	tarefa.setDtUltAt(LocalDate.now());
    	update(tarefa);
    }

}
