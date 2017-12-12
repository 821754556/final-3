package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class TESTRetirement {

	@Test
	public void testRetirement() {
		Retirement r = new Retirement(40,0.07,20,0.02,10000,2642);
		assertEquals(r.TotalAmountSaved(),1454485.55,0.01);
		assertEquals(r.AmountToSave(r.TotalAmountSaved()),554.13,0.01);
	}
}
