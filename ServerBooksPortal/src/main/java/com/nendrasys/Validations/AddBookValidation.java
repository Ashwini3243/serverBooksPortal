package com.nendrasys.Validations;

import com.nendrasys.model.BooksInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddBookValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return BooksInfo.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors error) {
      ValidationUtils.rejectIfEmptyOrWhitespace(error, "bookId", "bookInfo.bookId.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(error, "bookName", "booksInfo.bookName.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(error, "bookAuthor", "booksInfo.bookAuthor.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(error, "bookDesc", "booksInfo.bookDesc.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(error, "inPrice", "booksInfo.inPrice.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(error, "usPrice", "booksInfo.usPrice.empty");

      BooksInfo booksInfo =  (BooksInfo) obj;

    if (booksInfo.getInPrice()==0 ) {
           error.rejectValue("inPrice", "bookInfo.inPrice.length");
      }
      if (booksInfo.getUsPrice()==0  ) {
          error.rejectValue("usPrice", "bookInfo.usPrice.length");
      }
      if (booksInfo.getBookId()==0 && booksInfo.getBookId()<0 ) {
          error.rejectValue("bookId", "bookInfo.bookId.length");
      }
      if(booksInfo.getBookName().length()>100){
          error.rejectValue("bookName","bookInfo.bookName.length");
      }
      if(booksInfo.getBookAuthor().length()>50){
          error.rejectValue("bookAuthor","bookInfo.bookAuthor.length");
      }
      if(booksInfo.getBookDesc().length()>500){
          error.rejectValue("bookDesc","bookInfo.bookDesc.length");
      }
      if(booksInfo.getInPrice()>100000){
          error.rejectValue("inPrice","bookInfo.inPrice.length1");
      }
      if(booksInfo.getUsPrice()>100000){
          error.rejectValue("usPrice","bookInfo.usPrice.length1");
      }
      if(booksInfo.getBookId()>1000){
          error.rejectValue("bookId","bookInfo.bookId.length1");
      }
    }
}

