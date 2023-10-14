package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (!isAgedBrie(items[i]) && !isBackstagePass(items[i])) {
        
          if (!isSulfuras(items[i])) {
          Quality_decrease(items[i]);
        }
       
      } else {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;

          if (isBackstagePass(items[i])) {
            if (items[i].sellIn < 11) {
              Quality_increase(items[i]);
            }

            if (items[i].sellIn < 6) {
              Quality_increase(items[i]);
            }
          }
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
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
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
