package entities.enums;

public enum CourseStatus {
	NOT_STARTED("N�o iniciado"),
	IN_PROGRESS("Em progresso"),
	FINISHED("Finalizado");
	
	private String description;
	
	CourseStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
