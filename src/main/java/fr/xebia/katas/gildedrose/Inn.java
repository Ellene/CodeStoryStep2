package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
	private List<AdvancedItem> items;

	public Inn() {
		items = new ArrayList<AdvancedItem>();
		items.add(new AdvancedItem("+5 Dexterity Vest", 10, 20));
		items.add(new AdvancedItem("Aged Brie", 2, 0));
		items.add(new AdvancedItem("Elixir of the Mongoose", 5, 7));
		items.add(new AdvancedItem("Sulfuras, Hand of Ragnaros", 0, 80));
		items
				.add(new AdvancedItem("Backstage passes to a TAFKAL80ETC concert", 15,
						20));
		items.add(new AdvancedItem("Conjured Mana Cake", 3, 6));
	}

	public void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			AdvancedItem item = items.get(i);
			updateAdvancedItemQuality(item);
		}

	}

	private void updateAdvancedItemQuality(AdvancedItem item) {
		// quality decrease
		if (!item.getName().equals("Aged Brie")
				&& !item.getName().equals(
						"Backstage passes to a TAFKAL80ETC concert")) {
			if (item.getQuality() > 0) {
				if (!item.getName().equals(
						"Sulfuras, Hand of Ragnaros")) {
					decreaseQuality(item);
					if(item.getName().equals(
						"Conjured")) {
						decreaseQuality(item);
					}
				} 
			}
		} else {
			//quality increase
			if (item.getQuality() < 50) {
				increaseQuality(item);

				if (item.getName().equals(
						"Backstage passes to a TAFKAL80ETC concert")) {
					increaseBackstageItemQuality(item);
				}
			}
		}

		decreaseSellIn(item);

		// sell date has passed
		if (item.getSellIn() < 0) {
			if (!item.getName().equals("Aged Brie")) {
				if (!item.getName().equals(
						"Backstage passes to a TAFKAL80ETC concert")) {
					if (item.getQuality() > 0) {
						if (!item.getName().equals(
								"Sulfuras, Hand of Ragnaros")) {
							decreaseQuality(item);
						}
					}
				} else {
					item.setQuality(0);
				}
			} else {
				if (item.getQuality() < 50) {
					increaseQuality(item);
				}
			}
		}
	}
	

	private void decreaseSellIn(AdvancedItem item) {
		if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			item.setSellIn(item.getSellIn() - 1);
		}
	}

	private void increaseBackstageItemQuality(AdvancedItem item) {
		if (item.getSellIn() < 11) {
			if (item.getQuality() < 50) {
				increaseQuality(item);
			}
		}

		if (item.getSellIn() < 6) {
			if (item.getQuality() < 50) {
				increaseQuality(item);
			}
		}
	}

	private void increaseQuality(AdvancedItem item) {
		item.setQuality(item.getQuality() + 1);
	}

	private void decreaseQuality(AdvancedItem item) {
		item.setQuality(item.getQuality() - 1);
	}

	public List<AdvancedItem> getAdvancedItems() {
		return items;
	}
	

	public void setAdvancedItems(List<AdvancedItem> items) {
		this.items = items;
	}

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		new Inn().updateQuality();
	}

}
