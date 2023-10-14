package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  void testQualityAgedBrieSellin0Quality50() {
    Item element = new Item("Aged Brie", 0, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "the quality changed");  }

    @Test
    void testQualityAgedBrie0_0() {
      Item element = new Item("Aged Brie", 0, 0);
      GildedRose app = new GildedRose(new Item[] {element});
      app.updateQuality();
      assertTrue(element.quality > 0, "the quality of Aged Brie does not increase with time");
    }

  @Test
  void testQuality_1_2() {
    Item element = new Item("normal ", -1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the quality of normal items decrease twice as fast as normal items when sellIn is negative and quality is 2");
  }
  
  @Test
    void testQualitySulfurasSellInNegativeQuality() {
      Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 1);
      GildedRose app = new GildedRose(new Item[] {element});
      app.updateQuality();
      assertEquals(1, element.quality, "the quality of Sulfuras, Hand of Ragnaros items does not decrease  items when sellIn is negative and quality is 1");
    }

   @Test
  void testQualityBackstageSellInNegativeQuality4() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 54);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the qualite of BACKSTAGE passes does not equals 0 when sellIn is negative and quality is 54");
  }
// sellIn =0
  @Test
  void testQualityBackstageSellIn0Quality4() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(8, element.quality, "the qualite of BACKSTAGE passes does not equals 0 when sellIn is 0 and quality is 5");
  }
  // sellIn <11
  @Test
  void testSellinMoreThan11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(22, element.quality);
  }

  // quality49
  @Test
  void testquality49() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality);
  }
  //sellin11
  @Test
  void testsellin11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(21, element.quality);
  }
  @Test  
  void testString() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo, -1, 0", element.toString(), "the string is not correct");
  }
}
