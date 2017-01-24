package gr.quizbomb.model.dto;

public class QuestionForQuizSimpler {
	
	private boolean selected;
	
	private Long id;

	private String text;
	
	public QuestionForQuizSimpler() {
		super();
	}

	public QuestionForQuizSimpler(boolean selected, Long id, String text) {
		super();
		this.selected = selected;
		this.id = id;
		this.text = text;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
