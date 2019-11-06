package com.martinarroyo.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    // Get a reference to our repository
    private WordRepository mRepository;
    // LiveData member for caching
    private LiveData<List<Word>> mAllWords;

    // Constructor
    public WordViewModel(Application application){
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }

    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }


}
