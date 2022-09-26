import java.util.Random;

public class NonFiction extends Book
{
  public NonFiction(){
    this("Designing with Objects", 512, "burgundy", 005);
  }
  public NonFiction(String title, int pages, String color, int x){
    this.title = title;
    this.pages = pages;
    this.color = color;
    this.callnumber = x;
  }

  public void setCallNumber(int x){
    callnumber = x;
  }
  public int getCallNumber(){
    return callnumber;
  }
  public boolean hasSameCallNumber(Book b){
    return (this.callnumber == b.callnumber);
  }
  public int randomRating(){

    if (callnumber <= 333){
      int rand = new Random().nextInt(5 - 3 +1) + 3;
      return rand;
    }
    else if(callnumber <= 666 && callnumber>333){
      int rand = new Random().nextInt(3 - 1 +1) + 1;
      return rand;
    }
    else{
      int rand = new Random().nextInt(4 - 2 +1) + 2;
      return rand;
    }
  }
  public String toString(){

    if(this.callnumber == 005){
      return "title "+title+"\ncolor "+color+"\npages " +pages+ "\nrating "+rating+"\nnumber 005";
    }
    return "title "+title+"\ncolor "+color+"\npages " +pages+ "\nrating "+rating+"\nnumber " +callnumber;
  }
}
