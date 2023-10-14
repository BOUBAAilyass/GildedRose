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
 private void updateConjured(Item item) {
    Quality_decrease(item);
    Quality_decrease(item);
  }


  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
        switch (items[i].name) {
        case "Aged Brie":
          Quality_increase(items[i]);
          break;
        case "Backstage passes to a TAFKAL80ETC concert":
          updateBackstage(items[i]);
          break;
        case "Conjured":
          updateConjured(items[i]);
          break;
        case "Sulfuras, Hand of Ragnaros":
          break;
        default:
          Quality_decrease(items[i]);
          break;
      }
      updateSellIn(items[i]);
      handleExpiredItem(items[i]);
    }
  } 


private void handleExpiredItem(Item item) {
  if (item.sellIn < 0) {
    switch (item.name) {
      case "Aged Brie":
        Quality_increase(item);
        break;
      case "Backstage passes to a TAFKAL80ETC concert":
        item.quality = 0;
        break;
      case "Conjured":
        updateConjured(item);
        break;
      case "Sulfuras, Hand of Ragnaros":
        break;
      default:
        Quality_decrease(item);
        break;
    }
  }
}

private void updateSellIn(Item item) {
  if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
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

}
