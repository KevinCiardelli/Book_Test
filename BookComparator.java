/*
 * creates a comparator for sorting books by color
 *
 * Kevin Ciardelli
 */

import java.util.Comparator;

public class BookComparator implements Comparator<Book>
{
  public int compare(Book b, Book c){
    return b.getColor().compareTo(c.getColor());
  }
}
