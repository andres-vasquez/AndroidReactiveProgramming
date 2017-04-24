package io.github.ava_igs.androidreactiveprogramming.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import io.github.ava_igs.androidreactiveprogramming.R;
import io.github.ava_igs.androidreactiveprogramming.model.Events;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by andresvasquez on 4/23/17.
 */

public class Fragment2 extends Fragment {

    private static final String LOG=Fragment2.class.getSimpleName();

    private Context mContext;
    private Subscription subscriptionText;
    private Subscription subscriptionProgress;

    private TextView mResultTextView;
    private SeekBar mSecondSeekBar;

    public Fragment2() {
    }

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Get Arguments
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_2, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mResultTextView=(TextView) view.findViewById(R.id.lblResult);
        mSecondSeekBar=(SeekBar)view.findViewById(R.id.secondSeekBar);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.mContext=context;
    }

    @Override
    public void onDestroy() {
        if (subscriptionText != null && !subscriptionText.isUnsubscribed()) {
            subscriptionText.unsubscribe();
        }

        if (subscriptionProgress != null && !subscriptionProgress.isUnsubscribed()) {
            subscriptionProgress.unsubscribe();
        }

        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subscribeEvents();
    }

    private void subscribeEvents() {
        subscriptionText =Events.getInstance().getTextResult()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String event) {
                        mResultTextView.setText(String.valueOf(event));
                    }
                });

        subscriptionProgress =Events.getInstance().getSeekBarProgress()
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer progress) {
                        mSecondSeekBar.setProgress(progress);
                    }
                });
    }
}
