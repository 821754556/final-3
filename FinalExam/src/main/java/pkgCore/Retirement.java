package pkgCore;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;

	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}

	public Retirement() {

	}

	public double AmountToSave(double TotalAmountSAved) {
		double dARK = dAnnualReturnWorking / 12;
		double dMW = iYearsToWork * 12;
		double ReturnVal = 0;
		if (dARK == 0) {
			ReturnVal = TotalAmountSaved() / dARK;
		} else {
			ReturnVal = TotalAmountSaved() * dARK / (Math.pow(1 + dARK, dARK) - 1);
		}
		return ReturnVal;
	}

	public double TotalAmountSaved() {
		double dARR = dAnnualReturnRetired / 12;
		double ReturnVal = 0;
		int dMR = iYearsRetired * 12;
		if (dARR == 0) {
			ReturnVal = iYearsRetired * (dRequiredIncome - dMonthlySSI);
		} else {
			ReturnVal = (dRequiredIncome - dMonthlySSI) * ((Math.pow(1 + dARR, dMR) - 1) / dARR)
					/ Math.pow(1 + dARR, dMR);
		}
		return ReturnVal;
	}

	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
}
