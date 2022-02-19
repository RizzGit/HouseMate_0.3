package com.example.housemate_02;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.housemate_02.Book;

public class MySQLiteHelper extends SQLiteOpenHelper {//usiamo la classe OpenHelper pewr l'utilizzo dei DB

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "BookDB";

    // Books table name
    private static final String TABLE_BOOKS = "books";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//creazione del DB con la Tabella attraverso comando sqlite
        // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE books ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, "+
                "author TEXT )";

        // create books table
        db.execSQL(CREATE_BOOK_TABLE);//esecuzione della query
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//quando si aggiorna il DB aggiornando ogni volta la tabella dopo una modifica
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");

        // create fresh books table
        this.onCreate(db);
    }

    public void addBook(Book book){ //metodo per aggiungere un record
        //for logging
        Log.d("addBook", book.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getName()); // get title
        values.put(KEY_AUTHOR, book.getSurname()); // get author

        // 3. insert
        db.insert(TABLE_BOOKS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Book getBook(int id){//leggere record

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_BOOKS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        Book book = new Book();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setName(cursor.getString(1));
        book.setSurname(cursor.getString(2));

        //log
        Log.d("getBook("+id+")", book.toString());

        // 5. return book
        return book;
    }

    public List<Book> getAllBooks() {//legge tutti i record e li inserisce in una lista
        List<Book> books = new LinkedList<Book>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_BOOKS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setName(cursor.getString(1));
                book.setSurname(cursor.getString(2));

                // Add book to books
                books.add(book);
            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", books.toString());

        // return books
        return books;
    }

    public int updateBook(Book book) {//modifica record

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("Name", book.getName()); // get title
        values.put("Surname", book.getSurname()); // get author

        // 3. updating row
        int i = db.update(TABLE_BOOKS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(book.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    public void deleteBook(Book book) {//cancella record

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_BOOKS, //table name
                KEY_ID+" = ?",  // selections
                new String[] { String.valueOf(book.getId()) }); //selections args

        // 3. close
        db.close();

        //log
        Log.d("deleteBook", book.toString());

    }

}
