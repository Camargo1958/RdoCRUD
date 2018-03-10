package rdo_crud.model;

public class RelDiario {
	private Integer id;
	private String id_cliente;
	private String id_obra;
	private String data_rel;
	private String hora_rel;
	private String atividade_executada;
	private String status_rel;
	
	public RelDiario() {
		super();
	}
	public RelDiario(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getId_obra() {
		return id_obra;
	}
	public void setId_obra(String id_obra) {
		this.id_obra = id_obra;
	}
	public String getData_rel() {
		return data_rel;
	}
	public void setData_rel(String data_rel) {
		this.data_rel = data_rel;
	}
	public String getHora_rel() {
		return hora_rel;
	}
	public void setHora_rel(String hora_rel) {
		this.hora_rel = hora_rel;
	}
	public String getAtividade_executada() {
		return atividade_executada;
	}
	public void setAtividade_executada(String atividade_executada) {
		this.atividade_executada = atividade_executada;
	}
	public String getStatus_rel() {
		return status_rel;
	}
	public void setStatus_rel(String status_rel) {
		this.status_rel = status_rel;
	}



}
