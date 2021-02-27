package com.nendrasys.dao;

import com.nendrasys.model.BooksInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServerBooksDaoImpl implements ServerBooksDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveBooksData(BooksInfo booksInfo) {
        String query = "insert into booksData(bookId,bookName,bookAuthor,bookDesc,inPrice,usPrice ) values('" + booksInfo.getBookId() + "','" + booksInfo.getBookName() + "','" + booksInfo.getBookAuthor() + "','" + booksInfo.getBookDesc() + "','" + booksInfo.getInPrice() + "','" + booksInfo.getUsPrice() + "')";
        return jdbcTemplate.update(query);
    }

    @Override
    public int getCount() {
        String q="select count(*) from booksData";
        int count = getJdbcTemplate().queryForObject(q,Integer.class);
        System.out.println(count);
        return count;
    }

    @Override
    public List<BooksInfo> getBookDetails() {
        List<BooksInfo> booksInfoList = jdbcTemplate.query("select * from booksData ", new RowMapper<BooksInfo>() {
            @Override
            public BooksInfo mapRow(ResultSet rs, int i) throws SQLException {
                BooksInfo b = new BooksInfo();
                b.setBookId(rs.getInt("bookId"));
                b.setBookName(rs.getString("bookName"));
                b.setBookAuthor(rs.getString("bookAuthor"));
                b.setBookDesc(rs.getString("bookDesc"));
                b.setInPrice(rs.getDouble("inPrice"));
                b.setUsPrice(rs.getDouble("usPrice"));
                return b;
            }
        });
        return booksInfoList;
    }

    @Override
    public BooksInfo getBooksDetailsById(int bookId) {
        String QUERY1="SELECT * FROM booksData WHERE bookId = ?";
        BooksInfo booksInfo = (BooksInfo) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(BooksInfo.class), bookId);
        return booksInfo;
    }

 /*   @Override
    public BooksInfo BookIdExistValidation(BooksInfo booksInfo) {
        String QUERY1="SELECT * FROM booksData WHERE bookId = '"+booksInfo.getBookId()+"'";
        BooksInfo booksInfo1 = (BooksInfo) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(BooksInfo.class));
        return booksInfo1;
    }*/
}
