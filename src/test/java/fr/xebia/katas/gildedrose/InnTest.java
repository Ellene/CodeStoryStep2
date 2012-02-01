package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class InnTest {

	private Inn inn = new Inn();

	@Test
	public void should_test_the_truth() throws Exception {
		assertThat(true).isTrue();
	}

	@Test
	public void quality_should_degrade_twice_when_sell_date_passed() {
		Item item = new Item("Elixir of the Mongoose", 0, 10);
		setItem(item);

		inn.updateQuality();

		assertThat(item.getQuality()).isEqualTo(8);
	}

	@Test
	public void quality_should_never_become_negative() {
		Item item = new Item("Elixir of the Mongoose", 10, 0);
		setItem(item);

		inn.updateQuality();

		assertThat(item.getQuality()).isEqualTo(0);
	}


	@Test
	public void aged_brie_quality_should_increase() {
		Item item = new Item("Aged Brie", 10, 20);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(21);
	}
	
	@Test
	public void quality_should_never_exceed_50() {
		Item item = new Item("Aged Brie", 10, 50);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(50);
	}
	
	@Test
	public void sulfuras_quality_should_be_unchanged() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 25);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(25);
	}
	
	@Test
	public void sulfuras_sellIn_should_be_unchanged() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 25);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getSellIn()).isEqualTo(10);
	}
	
	@Test
	public void backstage_quality_should_increase_when_sellIn_more_than_10() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(21);
	}
	
	@Test
	public void backstage_quality_should_increase_by_2_when_sellIn_less_or_equal_to_10() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(22);
	}
	
	@Test
	public void backstage_quality_should_increase_by_3_when_sellIn_less_or_equal_to_5() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(23);
	}
	
	@Test
	public void backstage_quality_should_drop_to_0_when_sellIn_is_0() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		setItem(item);
		
		inn.updateQuality();
		
		assertThat(item.getQuality()).isEqualTo(0);
	}
	
	private void setItem(Item item) {
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		inn.setItems(items);
	}


}
