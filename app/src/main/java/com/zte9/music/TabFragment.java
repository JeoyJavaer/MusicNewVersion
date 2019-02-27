package com.zte9.music;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {


    private TextView     mTvContent;
    private CharSequence mContent;

    public TabFragment() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getString("content");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvContent = (TextView) view.findViewById(R.id.tv_content);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(mContent)) {
            mTvContent.setText(mContent);
        }
    }
}
