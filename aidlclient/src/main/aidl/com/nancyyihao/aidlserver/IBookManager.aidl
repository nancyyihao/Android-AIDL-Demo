// IAIDLServer.aidl
package com.nancyyihao.aidlserver;
import  com.nancyyihao.aidlserver.Book;

// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
