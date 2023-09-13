package org.example.converter;

import org.example.dao.AuthorDao;
import org.example.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements Converter<String, Author> {


    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return authorDao.findByid(Long.parseLong(source));
    }

}