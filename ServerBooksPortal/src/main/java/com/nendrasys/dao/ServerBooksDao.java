package com.nendrasys.dao;

import com.nendrasys.model.BooksInfo;
import java.util.List;

public interface ServerBooksDao {

    int saveBooksData(BooksInfo booksInfo);
    int getCount();
    List<BooksInfo> getBookDetails();
    BooksInfo getBooksDetailsById(int bookId);
/*    BooksInfo BookIdExistValidation(BooksInfo booksInfo);*/
}
