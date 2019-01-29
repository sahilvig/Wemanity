package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
	
     private Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 2), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 0), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3,6) };

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 4, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    public void testConjured() {
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        for(Item item : items){
        	//- Once the sell by date has passed, Quality degrades twice as fast
        	if(item.name.equalsIgnoreCase("+5 Dexterity Vest")){
        		assertEquals(0, item.quality);
        	}
        	//"Aged Brie" actually increases in Quality the older it gets
        	if(item.name.equalsIgnoreCase("Aged Brie")){
        		assertEquals(1, item.quality);
        	}
        	//The Quality of an item is never negative
        	if(item.name.equalsIgnoreCase("Elixir of the Mongoose")){
        		assertEquals(0, item.quality);
        	}
        	//The Quality of an item is never more than 50
        	//"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        	if(item.name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert") && item.sellIn == 5){
        		assertEquals(50, item.quality);
        	}
        	//"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        	if(item.name.equalsIgnoreCase("Sulfuras, Hand of Ragnaros") && item.sellIn == -1){
        		assertEquals(80, item.quality);
        	}
        	// "Conjured" items degrade in Quality twice as fast as normal items
        	if(item.name.equalsIgnoreCase("Conjured Mana Cake")){
        		assertEquals(4, item.quality);
        	}
        }
    	
    }

}
