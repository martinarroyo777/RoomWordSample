package com.martinarroyo.roomwordsample;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    // Inserts a new entity/word into the word_table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    // Deletes all entities from the word_table
    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    List<Word> getAlphabetizedWords();
}
