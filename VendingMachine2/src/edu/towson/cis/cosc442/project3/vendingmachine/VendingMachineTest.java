package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest 
{
	VendingMachine myVendingMachine;
	VendingMachineItem item1;
	VendingMachineItem item2;
	VendingMachineItem item3;
	VendingMachineItem item4;

	@Before
	public void setUp() throws Exception 
	{
		myVendingMachine = new VendingMachine();
		item1 = new VendingMachineItem("candy", 2.00);
		item2 = new VendingMachineItem("soda", 1.50);
		item3 = new VendingMachineItem("chips", 1.50);
		item4 = new VendingMachineItem("popcorn", .75);
	}
	
	/**
	 * Test addItem method for {@link VendingMachine} to see if an item can be added correctly.
	 */
	@Test
	public void testAddOneItem() 
	{
		myVendingMachine.addItem(item1, "A");
		assertEquals(item1, myVendingMachine.getItem("A"));
	}

	/**
	 * Test addItem method for {@link VendingMachine} to see if two items can be added correctly.
	 */
	@Test
	public void testAddSecondItem() 
	{
		myVendingMachine.addItem(item1, "A");
		myVendingMachine.addItem(item2, "B");
		assertEquals(item2, myVendingMachine.getItem("B"));
	}
	
	/**
	 * Test addItem method for {@link VendingMachine} to see if three items can be added correctly.
	 */
	@Test
	public void testAddThirdItem() 
	{
		myVendingMachine.addItem(item1, "A");
		myVendingMachine.addItem(item2, "B");
		myVendingMachine.addItem(item3, "C");
		assertEquals(item3, myVendingMachine.getItem("C"));
	}
	
	/**
	 * Test addItem method for {@link VendingMachine} to see if four items can be added correctly.
	 */
	@Test
	public void testAddFourthItem() 
	{
		myVendingMachine.addItem(item1, "A");
		myVendingMachine.addItem(item2, "B");
		myVendingMachine.addItem(item3, "C");
		myVendingMachine.addItem(item4, "D");
		assertEquals(item4, myVendingMachine.getItem("D"));
	}
	
	/**
	 * Test addItem method for {@link VendingMachine} to see if an item can be added to an incorrect slot.
	 * Expected Result: VendingMachineException being thrown indicating we cannot add an item to any incorrect slot.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddingItemToWrongSlot() 
	{
			myVendingMachine.addItem(item1, "Z");
	}
	
	/**
	 * Test addItem method for {@link VendingMachine} to see if an item can be added to an incorrect slot with an incorrect balance.
	 * Expected Result: VendingMachineException being thrown indicating we cannot add an item with an incorrect slot and balance to the machine.
	 */
	@Test (expected = VendingMachineException.class)
	public void testAddItemToWrongSlotWithIncorrectBalance() 
	{
			VendingMachineItem item5 = new VendingMachineItem("snack", -1.00);
			myVendingMachine.addItem(item5, "Z");
	}
	
	/**
	 * Test addItem method for {@link VendingMachine} to see if an item can be added to a slot already occupied by an item.
	 * Expected Result: VendingMachineException being thrown indicating we cannot add two items to the same slot.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemToAlreadyOccupiedSlot() 
	{
			myVendingMachine.addItem(item1, "A");
			VendingMachineItem item5 = new VendingMachineItem("item", 2.00);
			myVendingMachine.addItem(item5, "A");
	}
	
	/**
	 * Test RemoveItem method for {@link VendingMachine} to see if an item can be removed correctly.
	 */
	@Test
	public void testRemoveItem() 
	{
		myVendingMachine.addItem(item1, "A");
		myVendingMachine.removeItem("A");
		assertEquals(null, myVendingMachine.getItem("A"));
	}
	
	/**
	 * Test RemoveItem method for {@link VendingMachine} to see if an item can be removed that does not exist.
	 * Expected Result: VendingMachineException being thrown indicating that we cannot remove an item because it does not exist in that slot.
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemThatDoesNotExist()
	{	
			myVendingMachine.removeItem("A");
	}

	/**
	 * Test RemoveItem method for {@link VendingMachine} to see if an item can be removed from a slot that does not exist.
	 * Expected Result: VendingMachineException being thrown indicating that we cannot remove an it
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveIncorrectSlotItem()
	{
		myVendingMachine.addItem(item1, "Z");
		myVendingMachine.removeItem("Z");
	}
	
	/**
	 * Test insertMoney method for {@link VendingMachine} to see if money can be inserted properly.
	 */
	@Test
	public void testInsertMoney() 
	{
		myVendingMachine.insertMoney(2.00);
		assertEquals(2.00, myVendingMachine.getBalance(), 0.0);
	}
	
	/**
	 * Test insertMoney method for {@link VendingMachine} to see if money can be inserted properly.
	 * Expected Result: VendingMachineException being thrown indicating money cannot be inserted if it's of an invalid amount.
	 **/
	@Test(expected = VendingMachineException.class)
	public void testInsertInvalidAmountOfMoney() 
	{
		myVendingMachine.insertMoney(-2.00);
	}
	
	/**
	 * Test getBalance method for {@link VendingMachine} to see if a balance can be retrieved.
	 */
	@Test
	public void testGetBalance() 
	{
		assertEquals(0.0, myVendingMachine.getBalance(), 0.0);
	}

	/**
	 * Test makePurchase method for {@link VendingMachine} to see if an item can be purchased properly.
	 */
	@Test
	public void testMakePurchase() 
	{
		myVendingMachine.addItem(item2, "A");
		myVendingMachine.insertMoney(10.00);
		myVendingMachine.makePurchase("A");
		assertEquals(8.50, myVendingMachine.getBalance(), 0.00);
	}
	
	/**
	 * Test makePurchase method for {@link VendingMachine} to see if an item can be purchased properly when the money inserted is less than an items value.
	 */
	@Test
	public void testMakePurchaseWhenBalanceIsLessThanItemAmount() 
	{
		myVendingMachine.addItem(item1, "A");
		assertFalse(myVendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test makePurchase method for {@link VendingMachine} to see if an item can be purchased properly when an item does not exist in a slot.
	 */
	@Test
	public void testMakePurchaseWhenItemDoesNotExistInSlot()
	{
	}
	
	/**
	 * Test makePurchase method for {@link VendingMachine} to see if an item can be purchased properly when the item is null,
	 * and the money inserted is less than the items amount.
	 */
	@Test
	public void testMakePurchaseWhenItemIsNullAndBalanceIsLessThanItemPrice() 
	{
		VendingMachineItem item = new VendingMachineItem(null, 100.00);
		myVendingMachine.insertMoney(.50);
		myVendingMachine.addItem(item, "A");
		assertFalse(myVendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test returnChange method of {@link VendingMachine} to see if change can be returned.
	 */
	@Test
	public void testReturnChange() 
	{
		myVendingMachine.insertMoney(10.00);
		assertEquals(10.00, myVendingMachine.returnChange(), 0.00);
	}
	
	@After
	public void tearDown() throws Exception
	{
		myVendingMachine = null;
		item1 = null;
		item2 = null;
		item3 = null;
		item4 = null;
	}

}
