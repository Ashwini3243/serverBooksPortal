package com.nendrasys.services;

import com.nendrasys.dao.ServerBooksDaoImpl;
import com.nendrasys.model.BooksInfo;
import com.nendrasys.model.BooksList;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

public class OxmServices {

    private Marshaller marshaller;
    ServerBooksDaoImpl stdDaoImpl;
    private Unmarshaller unmarshaller;

    public ServerBooksDaoImpl getStdDaoImpl() {
        return stdDaoImpl;
    }

    public void setStdDaoImpl(ServerBooksDaoImpl stdDaoImpl) {
        this.stdDaoImpl = stdDaoImpl;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public String booksListInXmlById(BooksInfo booksInfo) throws IOException {
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult=new StreamResult(stringWriter);
        getMarshaller().marshal(booksInfo,streamResult );
        return stringWriter.toString();
    }

    public String BooksListInXml(BooksList booksInfo) throws IOException {
        StringWriter stringWriter=new StringWriter();
        getMarshaller().marshal(booksInfo,new StreamResult(stringWriter));
        return stringWriter.toString();
    }

}
