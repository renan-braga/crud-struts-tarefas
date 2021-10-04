package org.apache.struts.example.crud.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts.example.crud.model.Tarefa;
import org.apache.struts.example.crud.service.DefaultTarefaService;
import org.apache.struts.example.crud.service.TarefaService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TarefaAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 7592442823977629322L;

	private TarefaService tarefaService = new DefaultTarefaService();
    
    private Tarefa tarefa;
    private List<?> tarefas;

    public void prepare() throws Exception {
        if (getTarefa() != null && getTarefa().getId() != null) {
            setTarefa(tarefaService.getTarefa(getTarefa().getId()));
        }
    }
    
    public String save() {
        if (getTarefa().getId() == null) {
            tarefaService.insertTarefa(getTarefa());
        } else {
            tarefaService.updateTarefa(getTarefa());
        }
        return SUCCESS;
    }

    public String delete() {
        tarefaService.deleteTarefa(getTarefa().getId());
        return SUCCESS;
    }

    public String list() {
        setTarefas(tarefaService.listarTarefas());
        return SUCCESS;
    }
    
    public String finalizar() {
    	getTarefa().setDtUltAt(LocalDate.now());
    	getTarefa().setDtFinalizado(LocalDate.now());
    	getTarefa().setFinalizado(true);
    	save();
    	return SUCCESS;
    }
    
    public String recomecar() {
    	getTarefa().setDtUltAt(LocalDate.now());
    	getTarefa().setFinalizado(false);
    	save();
    	return SUCCESS;
    }

	public List<?> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<?> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
