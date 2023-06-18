package pojos;

public enum Course {
	
	DAC(90000),DBDA(115000),DITISS(110000);
	
	private double fees;

	Course(double fees) {
		this.fees=fees;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	

}
