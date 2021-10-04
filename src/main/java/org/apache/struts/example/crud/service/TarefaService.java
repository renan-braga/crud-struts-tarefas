package org.apache.struts.example.crud.service;

import org.apache.struts.example.crud.model.Tarefa;

import java.util.List;

public interface TarefaService {

    public List<?> listarTarefas();

    public void updateTarefa(Tarefa tarefa);

    public void deleteTarefa(Integer id);

    public Tarefa getTarefa(Integer id);

    public void insertTarefa(Tarefa tarefa);

}
