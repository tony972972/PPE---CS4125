/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcome;

/**
 *
 * @author 35383
 */
// This class contains data for an individual item in a
// shopping cart.



public class ShoppingCartItem implements Cloneable
{
	public String itemName;
	public int itemCost;
	public int quantity;
	

	

	public ShoppingCartItem(String itemName, int itemCost,
		int quantity)
	{
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.quantity = quantity;
		
	}

// The add method is a quick method for combining two similar
// items. It doesn't perform any checks to insure that they are
// similar, however. You use this method when adding items to a
// cart, rather than storing two instances of the same item, you
// add the quantities together.

	public void add(ShoppingCartItem otherItem)
	{
		this.quantity = this.quantity + otherItem.quantity;
	}

// The subtract method is similar to the add method, but it
// removes a certain quantity of items.

	public void subtract(ShoppingCartItem otherItem)
	{
		this.quantity = this.quantity - otherItem.quantity;
	}

// You can store items in a hash table if you implement hashCode. It's
// always a good idea to do this.

	public int hashCode()
	{
		return itemName.hashCode() + itemCost;
	}

// The equals method  only compares the item names and item costs. Technically, this is
// not the way that equals was intended to work.

	public boolean equals(Object other)
	{
		if (this == other) return true;

		if (!(other instanceof ShoppingCartItem))
			return false;

		ShoppingCartItem otherItem =
			(ShoppingCartItem) other;

		return (itemName.equals(otherItem.itemName)) &&
			(itemCost == otherItem.itemCost);
	}

// Create a copy of this object

	public ShoppingCartItem copy()
	{
		return new ShoppingCartItem(itemName, itemCost,
			quantity);
	}

// Create a printable version of this object

	public String toString()
	{
		return itemName+" cost: "+itemCost+" qty: "+quantity;
	}
}

