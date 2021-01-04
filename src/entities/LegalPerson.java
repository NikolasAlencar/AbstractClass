package entities;

public final class LegalPerson extends Person{

	private Integer nEmployees;
	
	public LegalPerson() {
	}
	
	public LegalPerson(String name, Double income, Integer nEmployees) {
		super(name, income);
		this.nEmployees = nEmployees;
	}

	public Integer getnEmployees() {
		return nEmployees;
	}

	public void setnEmployees(Integer nEmployees) {
		this.nEmployees = nEmployees;
	}

	@Override
	public double calcTax() {
		Double tax1 = getIncome() * 0.16;
		if (getnEmployees() > 10) {
			tax1 = getIncome() * 0.14;
		}
		return tax1;
	}

	@Override
	public String toString() {
		return getName()
				+ ": $ "
				+ String.format("%.2f", calcTax());
	}
}