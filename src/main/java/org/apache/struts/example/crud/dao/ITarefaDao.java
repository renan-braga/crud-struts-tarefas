package org.apache.struts.example.crud.dao;

import org.apache.struts.example.crud.model.Tarefa;

import java.util.List;

public interface ITarefaDao {

    public List listarTarefas();

    public Tarefa getTarefa(Integer id);

    public void update(Tarefa tarefa);

    public void insert(Tarefa tarefa);

    public void delete(Integer id);

}
