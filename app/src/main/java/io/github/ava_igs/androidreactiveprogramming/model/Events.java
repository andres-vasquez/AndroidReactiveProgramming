package io.github.ava_igs.androidreactiveprogramming.model;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by andresvasquez on 4/23/17.
 */

public class Events {

    private PublishSubject<Integer> seekBarProgress = PublishSubject.create();
    private PublishSubject<String> textResult = PublishSubject.create();

    private static Events instance;

    public static Events getInstance() {
        if (instance == null) {
            instance = new Events();
        }
        return instance;
    }

    public Observable<Integer> getSeekBarProgress() {
        return seekBarProgress;
    }

    public void setSeekBarProgress(int seekBarProgress) {
        this.seekBarProgress.onNext(seekBarProgress);
    }

    public Observable<String> getTextResult() {
        return textResult;
    }

    public void setTextResult(String textResult) {
        this.textResult.onNext(textResult);
    }
}
