package entities;

public final class NaturalPerson extends Person {
	
	private Double health;
	
	public NaturalPerson() {
		
	}
	
	public NaturalPerson(String name, Double income, Double health) {
		super(name, income);
		this.health = health;
	}
	

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	@Override
	public double calcTax() {
		Double tax1 = 0.0;
		Double tax2 = 0.0;
		if (getIncome() < 20000.00) {
			tax1 += getIncome() * 0.15;
		}else if (getIncome() >= 20000.00) {
			tax1 += getIncome() * 0.25;
		}
		if (getHealth() > 0) {
			tax2 += health / 2;
		}
		return tax1 - tax2;
	}

	@Override
	public String toString() {
		return getName()
				+ ": $ "
				+ String.format("%.2f", calcTax());
	}
	

}