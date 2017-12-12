package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class TESTRetirement {

	@Test
	public void testRetirement() {
		Retirement r = new Retirement(41,0.09,25,0.03,11000,3221);
		assertEquals(r.TotalAmountSaved(),1640407.93053,0.01);
		assertEquals(r.AmountToSave(r.TotalAmountSaved()),319.5827,0.01);
	}
}
