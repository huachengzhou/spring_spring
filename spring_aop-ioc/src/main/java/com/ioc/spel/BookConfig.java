package com.ioc.spel;

import com.common.help.Zhou_Word;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zch.pojo.Book;

@Configuration
public class BookConfig {

    @Bean(name = "bookA")
    public Book getBook(){
        Book book = new Book();
        book.setAuthor("#{'blake'}");
        book.setBookmark("#{9.87E4}");
        Zhou_Word.getChineseName();
        return book;
    }
}
