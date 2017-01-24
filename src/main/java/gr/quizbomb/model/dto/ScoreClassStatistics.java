package gr.quizbomb.model.dto;

public class ScoreClassStatistics {
	
	private double score;
	
	private int count;
	
	private String name;

	public ScoreClassStatistics(String name) {
		super();
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
