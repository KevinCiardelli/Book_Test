/*
 * program to test methods in Fiction and NonFiction
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class BookTestTwo
{
	public static void main (String [] args)
	{
		// create book objects
		Book b1 = new NonFiction();
		Book b2 = new Fiction("Harry Potter and the Sorcerer's Stone", 223,
			"brown", Genre.FANTASY);
		Book b3 = new NonFiction();
		Book b4 = new Fiction();
		Book b5 = new NonFiction("Mastering the Art of French Cooking", 68,
			"green", 641);
		Book b6 = new Fiction("Inimitable Jeeves", 253, "ecru",
			Genre.HUMOR);

		// assign books random ratings
		List<Book> books = new ArrayList<>(Arrays.asList
			(b1, b2, b3, b4, b5, b6));
		for (Book b: books)
		{
			b.setRating(b.randomRating());
		}

		// print properties of books
		System.out.println("\nHere are the books in our collection:\n");
		int count = 0;
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext())
		{
			System.out.println(++count + "\n" + iter.next() + "\n");
		}

		// use new superclass methods
		System.out.println("What is book 2's rating? " + b2.getRating());
		System.out.println("We like Harry Potter, so let's change that to a 5");
		b2.setRating(5);
		System.out.println(b2.getRating());

		// use methods from subclasses
		Fiction f4 = (Fiction) b4;
		Fiction f6 = (Fiction) b6;
		System.out.println("\nAre books 4 and 6 in the same genre? "
			+ (f4.isSameGenre(f6) ? "yes" : "no"));
		System.out.println("What are their genres?");
		System.out.println("4 is " + f4.getGenre());
		System.out.println("6 is " + f6.getGenre());

		NonFiction n1 = (NonFiction) b1;
		NonFiction n3 = (NonFiction) b3;
		System.out.println("\nDo books 1 and 3 have the same call number "
			+ (n1.hasSameCallNumber(n3) ? "yes" : "no"));
		System.out.printf("1 %03d  3 %03d\n", n1.getCallNumber(),
			n3.getCallNumber());
		NonFiction n5 = (NonFiction) b5;
		System.out.println("Do books 1 and 5 have the same call number "
			+ (n1.hasSameCallNumber(n5) ? "yes" : "no"));
		System.out.printf("1 %03d  5 %03d\n", n1.getCallNumber(),
			n5.getCallNumber());

		// sort using comparator (sorts by color)
		System.out.println("\nLet's sort the books by color:\n");
		books.sort(new BookComparator());
		for (Book b : books)
		{
			System.out.printf("%-10s%-10s\n", b.getColor(), b.getTitle());
		}

		// use map to count copies of each title
		// (sorts by title since uses compareTo() from key's class)
		System.out.println("\nSince we have some duplicates, let's tally "
			+ "the collection in a TreeMap:\n");
		Map<String, Integer> bookCounts = new TreeMap<>();
		for (Book b : books)
		{
			String title = b.getTitle();
			Integer tally = bookCounts.get(title);
			tally = (tally == null) ? 1 : tally+1;
			bookCounts.put(title, tally);
		}
		for (Map.Entry<String, Integer>  pair: bookCounts.entrySet())
		{
			System.out.printf("%-40s%d\n",pair.getKey(), pair.getValue());
		}
	}
}
