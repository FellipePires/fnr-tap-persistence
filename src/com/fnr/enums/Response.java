package com.fnr.enums;

public enum Response {
	POST_SUCCESS(true, "Cadastro realizado com sucesso!"),
	POST_FAILED(false, "Cadastro não realizado"),
	
	UPDATE_SUCCESS(true, "Alteração realizada com sucesso!"),
	UPDATE_FAILED(false, "Alteração não realizada"),
	
	DELETE_SUCCESS(true, "Remoção realizada com sucesso!"),
	DELETE_FAILED(false, "Remoção não realizada");
	
	private String message;
	private boolean status;
	
	private Response(boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
