package org.apache.struts.example.crud.service;

import org.apache.struts.example.crud.dao.ITarefaDao;
import org.apache.struts.example.crud.dao.TarefaDao;
import org.apache.struts.example.crud.model.Tarefa;

import java.util.List;

public class DefaultTarefaService implements TarefaService {

    private ITarefaDao dao;

    public DefaultTarefaService() {
        this.dao = new TarefaDao();
    }

    public List<?> listarTarefas() {
    	return dao.listarTarefas();
    }

    public void updateTarefa(Tarefa tarefa) {
        dao.update(tarefa);
    }

    public void deleteTarefa(Integer id) {
        dao.delete(id);
    }

    public Tarefa getTarefa(Integer id) {
        return dao.getTarefa(id);
    }

    public void insertTarefa(Tarefa tarefa) {
        dao.insert(tarefa);
    }

}
