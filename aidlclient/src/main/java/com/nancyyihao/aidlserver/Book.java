package com.nancyyihao.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jumper on 2016/9/7.
 */
public class Book implements Parcelable {
    private String bookName;
    private int bookId;

    public Book(){}

    public Book(int bookId, String bookName){
        this.bookId = bookId ;
        this.bookName = bookName ;
    }

    public Book(Parcel parcel){
        bookName = parcel.readString();
        bookId = parcel.readInt();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeInt(bookId);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>(){

        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }

    };

    @Override
    public String toString() {
        return "{" + "bookId = " + bookId +
                     " bookName = " + bookName +
                "}" ;
    }
}
