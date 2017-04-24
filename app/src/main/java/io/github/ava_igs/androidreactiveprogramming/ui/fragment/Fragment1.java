package io.github.ava_igs.androidreactiveprogramming.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

import io.github.ava_igs.androidreactiveprogramming.R;
import io.github.ava_igs.androidreactiveprogramming.model.Events;

/**
 * Created by andresvasquez on 4/23/17.
 */

public class Fragment1 extends Fragment{

    private Context mContext;
    private EditText mFirstEditText;
    private SeekBar mFirstSeekBar;

    public Fragment1() {
    }

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
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
        View view=inflater.inflate(R.layout.fragment_1, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mFirstEditText=(EditText)view.findViewById(R.id.txtFirstText);
        mFirstSeekBar=(SeekBar)view.findViewById(R.id.firstSeekBar);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.mContext=context;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        mFirstEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Events.getInstance().setTextResult(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFirstSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    Events.getInstance().setSeekBarProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
