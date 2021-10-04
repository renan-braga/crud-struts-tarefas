package org.apache.struts.example.crud.bd;

import org.apache.struts.example.crud.dao.TarefaDao;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println(new TarefaDao().listarTarefas().get(0).toString());
	}

}
