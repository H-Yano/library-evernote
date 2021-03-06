package library.domain.model.item;

import library.domain.model.item.bibliography.Book;

/**
 * *蔵書
 */
public class Item {
    ItemNumber itemNumber;
    Book book;
    ItemStatus status; // TODO 現在は未使用：明示的に持つべきか検討する

    @Deprecated
    Item() {
    }

    public Item(ItemNumber itemNumber, Book book) {
        this.itemNumber = itemNumber;
        this.book = book;
    }

    public Book book() {
        return book;
    }
    public ItemNumber itemNumber() {
        return itemNumber;
    }

    public String show() {
        return String.format("[%s] %s",
                itemNumber.toString(), book.show());
    }
    @Override
    public String toString() {
        return "Item{" +
                "itemNumber=" + itemNumber +
                ", book=" + book +
                ", status=" + status +
                '}';
    }
}
