package shoppingCart;

import java.util.GregorianCalendar;

public enum PromotionEnum {

	PROMO1("code1", new GregorianCalendar(2018, 5, 20), new GregorianCalendar(2018, 6, 20)),
	PROMO2("code2", new GregorianCalendar(2018, 5, 25), new GregorianCalendar(2018, 6, 2)),
	PROMO3("code3", new GregorianCalendar(2018, 6, 5), new GregorianCalendar(2018, 6, 18)),
	PROMO4("code4", new GregorianCalendar(2018, 6, 15), new GregorianCalendar(2018, 6, 20));
	
	private String code;
	private GregorianCalendar startDate, endDate;
	
	private PromotionEnum(String code, GregorianCalendar startDate, GregorianCalendar endDate)
	{
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	
	
}
