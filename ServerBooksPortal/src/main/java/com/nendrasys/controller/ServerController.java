package com.nendrasys.controller;

import com.nendrasys.Validations.AddBookValidation;
import com.nendrasys.dao.ServerBooksDaoImpl;
import com.nendrasys.model.BooksInfo;
import com.nendrasys.services.BooksServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@Controller("ServerController")
@RequestMapping("/")
public class ServerController {

    @Autowired
    ServerBooksDaoImpl serverBooksDao;
    @Autowired
    BooksServerServiceImpl bookServerService;
    @Autowired
    AddBookValidation addBookValidator;

         // Add Book Form
           @RequestMapping(value = "/addBookForm")
            public String addBookForm(Model model) {
            BooksInfo booksInfo = new BooksInfo();
            int count = serverBooksDao.getCount();
            booksInfo.setBookId(count + 1);
            model.addAttribute("booksInfo", booksInfo);
            return "AddBookForm";
           }

          // Add book form Action
          @RequestMapping(value = "/addBookFormAction", method = RequestMethod.POST)
           public String saveBookData(@ModelAttribute("booksInfo") @Validated BooksInfo booksInfo, BindingResult result, Model model) {
             int id = serverBooksDao.getCount();
             id = id + 1;
             if (  booksInfo.getBookId()<=0 || booksInfo.getBookId()>id )
               result.rejectValue("bookId", "booksInfo.bookId.change");
                 new AddBookValidation().validate(booksInfo, result);
                 System.out.println(result);
                 try {
                     if (result.hasErrors()) {
                         return "AddBookForm";
                     } else {
                         String str = bookServerService.saveBooksData(booksInfo);
                         model.addAttribute("str", str);
                         return "AddBookFormSuccess";
                     }
                 } catch (DuplicateKeyException e) {
                     result.rejectValue("bookId","bookId.duplicate");
                 }
                 return "AddBookForm";
             }
            //Books List in table
            @RequestMapping(value = "/getBooksList", method = RequestMethod.GET)
            public String getBooksListDetails(Model model) {
                List<BooksInfo> booksInfoList = bookServerService.getBookDetails();
                model.addAttribute("BooksList", booksInfoList);
                return "AllBooksList";
            }

            //Books Details By iD
            @RequestMapping(value = "/getBooksById/{bookId}")
            public String getBooksListById(Model model, @PathVariable("bookId") String bookId) {
                Integer id1 = Integer.parseInt(bookId);
                BooksInfo booksInfo = bookServerService.getBooksDetailsById(id1);
                model.addAttribute("bookById", booksInfo);
                return "DisplayBooksById";
            }

            //books by id in xml
            @RequestMapping(value = "/getBookByIdInXml/{bookId}", produces = {"application/xml"})
            @ResponseBody
            public String getBooksXmlById(@PathVariable("bookId") int bookId) throws IOException {
                return bookServerService.booksListInXmlById(bookId);
            }

            //books list
            @RequestMapping(value = "/getBooksListInXml", produces = {"application/xml"})
            @ResponseBody
            public String getAllBooksInXml() throws IOException {
                return bookServerService.booksListInXml();
            }

            @RequestMapping("/h")
            public String home(){
        return "header";
    }


        }
