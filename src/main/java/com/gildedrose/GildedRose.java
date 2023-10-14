package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  private void updateBackstage(Item item) {
      if (item.sellIn < 6) {
      Quality_increase(item);
      Quality_increase(item);
      Quality_increase(item);
    } else if (item.sellIn < 11) {
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
      if(isAgedBrie(items[i])){
        Quality_increase(items[i]);
      }else { 
        if (!isSulfuras(items[i])) {
          Quality_decrease(items[i]);
        }
     } 
    updateSellIn(items[i]);
    handleExpiredItem(items[i]);
 } 
} 


private void handleExpiredItem(Item item) {
  if (item.sellIn < 0) {
    if (isAgedBrie(item)) {
      Quality_increase(item);
    } else if (isBackstagePass(item)) {
      item.quality = 0;
    } else if (!isSulfuras(item)) {
      Quality_decrease(item);
    }
  }
}

private void updateSellIn(Item item) {
  if (!isSulfuras(item)) {
    item.sellIn--;
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
