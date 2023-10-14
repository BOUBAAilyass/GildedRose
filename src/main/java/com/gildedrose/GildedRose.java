package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  private void updateBackstage(Item item) {
    if (item.sellIn < 0) {
      item.quality = 0;
    } else if (item.sellIn < 5) {
      Quality_increase(item);
      Quality_increase(item);
      Quality_increase(item);
    } else if (item.sellIn < 10) {
      Quality_increase(item);
      Quality_increase(item);
    } else {
      Quality_increase(item);
    }
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (isBackstagePass(items[i])) {
        updateBackstage(items[i]);
      } else


      if (!isAgedBrie(items[i])) {
        
          if (!isSulfuras(items[i])) {
          Quality_decrease(items[i]);
        }
       
      } else {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;
        }
      }

      if (!isSulfuras(items[i])) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!isAgedBrie(items[i])) {
          if (!isBackstagePass(items[i])) {
            
              if (!isSulfuras(items[i])) {
              Quality_decrease(items[i]);
            }
          }} else {
          Quality_increase(items[i]);
        }
      }
    }
  }

  private void Quality_decrease(Item item) {
    if (item.quality > 0) {
      item.quality--;
    }
  }

  private void Quality_increase(Item item) {
    if (item.quality < 50) {
      item.quality++;
    }
  }

  private boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }

  private boolean isBackstagePass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

}
