/*
 * creates a fiction subclass for books
 *
 * Kevin Ciardelli
 */
import java.util.Random;

public class Fiction extends Book
{
  public Fiction(){
    this("Murder on the Orient Express", 212, "white", Genre.MYSTERY);
  }
  public Fiction(String title, int pages, String color, Genre genre){
    this.title = title;
    this.pages = pages;
    this.color = color;
    this.genre = genre;
  }
  public void setGenre(Genre x){
    genre = x;
  }
  public Genre getGenre(){
    return this.genre;
  }
  public boolean isSameGenre(Object b){
    if(b instanceof Book) {
      Book c = (Book) b;
      if (this.genre == c.genre){
        return true;
      }
    }
    return false;
  }
  public int randomRating(){

    if (genre == Genre.MYSTERY){
      int rand = new Random().nextInt(5 - 3 +1) + 3;
      return rand;
    }
    else if(genre == Genre.FANTASY){
      int rand = new Random().nextInt(4 - 2 +1) + 2;
      return rand;
    }
    else if(genre == Genre.HUMOR){
      int rand = new Random().nextInt(5 - 1 +1) + 1;
      return rand;
    }
    return 0;
  }
  public String toString(){
    if (genre == Genre.MYSTERY){
      return "title "+title+"\ncolor "+color+"\npages " +pages+"\nrating "+rating+ "\ngenre MYSTERY";
    }
    else if (genre == Genre.FANTASY){
      return "title "+title+"\ncolor "+color+"\npages " +pages+"\nrating "+rating+ "\ngenre FANTASY";
    }
    else{
      return "title "+title+"\ncolor "+color+"\npages " +pages+"\nrating "+rating+ "\ngenre HUMOR";
    }
  }

}
