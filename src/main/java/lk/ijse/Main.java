package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book=new Book();
        book.setId(1);
        book.setTitle("Hath pana");
        book.setPubYear(2011);
        book.setPrice(300);
        //book.setAuthor();

        Book book1=new Book();
        book1.setId(2);
        book1.setTitle("Anadre");
        book.setPubYear(2005);
        book.setPrice(350);
        book.setAuthor(new Author());

        List<Book>bookList=new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        Author author=new Author();
        author.setAuthorId(1);
        author.setName("Kumarathunga Munidasa");
        author.setCountry("Sri lanka");
        author.setBooks(bookList);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();


        /* Write an HQL query to retrieve all books published after the year 2010.*/
        Query query1 = session.createQuery("select title from Book where pubYear > :year");
        query1.setParameter("year",2010);
        List<String> titles = query1.list();
        for(String title : titles){
            System.out.println(title);
        }

       /* Write an HQL update query to increase the price of all books published by a specific
        author by 10%.*/
        Query query2 = session.createQuery("update Book set price = price + (price * 10.0 / 100.0)  where author.id = :author_id");
        query2.setParameter("author_id",1);
        int count = query2.executeUpdate();
        System.out.println(count);

        /*Write an HQL query to find the average price of all books.*/
        Query query3 = session.createQuery("select avg (price) from Book ");
        Object result = query3.uniqueResult();
        System.out.println(result);

        /*Write an HQL query to retrieve all authors along with the count of books they have written.*/
        Query query4 = session.createQuery("select a.name, count (b.title) from Author a left join a.books b group by a.id,a.name");
        List<Object[]> bookCount = query4.list();

        for(Object[] results : bookCount){
            System.out.println("Author: " + results[0] + ", Count: " + results[1]);
        }

        /*Write an HQL query using named parameters to retrieve books written by authors from a
        specific country.*/
        Query query5 = session.createQuery("select b from Book b join b.author a where a.country = :countryName");
        query5.setParameter("countryName","Sri Lanka");
        List<Book> bookList1 = query5.list();
        System.out.println(bookList1);

        /*Write an HQL query to find authors who have written more than the average number of
        books.*/
        Query query6 = session.createQuery("select a.name from Author a where (select count(b.title) from Book b where b.author = a) > " +
                "(select avg(count(b.title)) from Book b group by b.author)");
        List<String> authors = query6.list();
        for(String authorName : authors) {
            System.out.println(authorName);

            transaction.commit();
            session.close();
        }

    }
}