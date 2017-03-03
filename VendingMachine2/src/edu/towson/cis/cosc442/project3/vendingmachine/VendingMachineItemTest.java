package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest 
{
	VendingMachineItem item;

	@Before
	public void setUp() throws Exception
	{
		item = new VendingMachineItem("snack", 2.0);
	}

	/**
	 * Test VendingMachineItem constructor for {@link VendingMachineItem} to see if a vending machine item can be created successfully.
	 */
	@Test
	public void testVendingMachineItem() 
	{
		assertEquals("snack", item.getName());
		assertEquals(2.0, item.getPrice(), 0);
	}
	
	/**
	 * Test VendingMachineItem constructor for {@link VendingMachineItem} to see if an incorrect vending machine item can be created successfully.
	 * Expected Result: VendingMachineException thrown.
	 */
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItemForInvalidCreation()
	{
			VendingMachineItem v = new VendingMachineItem("1230", -1.00);
	}

	/**
	 * Test getName method for {@link VendingMachineItem} to see if a vending machine items name can be returned properly.
	 */
	@Test
	public void testGetName() 
	{
		assertEquals("snack", item.getName());
	}
	
	/**
	 * Test getPrice method for {@link VendingMachineItem} to see if a vending machine items price can be returned successfully.
	 */
	@Test
	public void testGetPrice() 
	{
		assertEquals(2.0, item.getPrice(), 0);
	}
	
	/**
	 * Test getPrice method for {@link VendingMachineItem} to see if a vending machine items price can be returned successfully if the price is less than zero.
	 * Expected Result: exception will be thrown because the price of an item cannot be negative.
	 */
	@Test(expected = VendingMachineException.class)
	public void testGetPriceNegative() 
	{
		VendingMachineItem item2 = new VendingMachineItem("snack", -2.00);
		assertEquals(-2.00, item2.getPrice(), 0);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		item = null;
	}
}
