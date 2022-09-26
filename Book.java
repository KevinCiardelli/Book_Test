/*
 * creates a book class
 *
 * Kevin Ciardelli
 */

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Random;

public abstract class Book implements Comparable<Book>
{

  private static int counter_books;
  private static LinkedHashSet<String> banned_books = new LinkedHashSet();

  public String title;
  public String color;
  public Genre genre;
  public int callnumber;
  public int rating;
  public int pages;


  public Book(String title, int pages, String color) {
    this.title= title;
    this.pages= pages;
    this.color= color;
    counter_books++;
  }
  public Book() {
    this("Designing with Objects", 512, "burgundy");
  }
  public static Set bannedBooks(){
    return banned_books;
  }
  public static void addBannedTitle(String t){
    banned_books.add(t.toUpperCase());
  }

  public static int numberOfBooks() {
    return counter_books;
  }

  public final void setTitle(String x) {
    title= x;
  }
  public final void setColor(String x) {
    color= x;
  }
  public final void setRating(int x){
    rating = x;
  }
  public final void setPages(int x) {
    pages= x;
  }

  public String getTitle(){
    return this.title;
  }
  public String getColor() {
    return this.color;
  }
  public int getRating() {
    return this.rating;
  }
  public int getPages() {
    return this.pages;
  }

  public abstract int randomRating();

  public boolean hasSamePages(Book b){
    if(this.pages==(b.pages)){
      return true;
    }
    return false;
  }

  public String toString()
  {
    return "title "+title+"\ncolor "+color+"\npages " +pages;
  }

  public boolean equals(Object b)
  {
    if(b instanceof Book)
    {
      Book c = (Book) b;
      if(this.pages==(c.pages)&&(this.title==(c.title))){
        return true;
      }
    }
    return false;
  }

  public int hashCode(){
    return (title.hashCode()+Integer.hashCode(pages));
  }

  //result > 0 ? "2" : result < 0 ? "public int compareTo(Book b){
  public int compareTo(Book b) {
    if(pages > b.pages){
      return 1;
    }
    else if(pages < b.pages){
      return -1;
    }
    return 0;
  }
  public int compare(Book b, Book c){
    return b.compareTo(c);
  }
}
