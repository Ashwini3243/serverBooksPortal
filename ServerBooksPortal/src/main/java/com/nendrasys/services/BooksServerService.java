package com.nendrasys.services;

import com.nendrasys.model.BooksInfo;
import java.io.IOException;
import java.util.List;

public interface BooksServerService {
    List<BooksInfo> getBookDetails();
    String saveBooksData(BooksInfo booksInfo);
    BooksInfo getBooksDetailsById(int bookId);
    public String booksListInXmlById(int bookId) throws IOException;
    public String booksListInXml() throws IOException;


}
