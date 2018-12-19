package pratiksurela.com.dreamdrawer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pratiksurela.com.dreamdrawer.R;

public class HomeFragment extends Fragment {

    private Context context;
    private String TAG = "HomeFragment";
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        initView(view);

        return view;
    }

    private void initView(View view) {
        //Init All views here
    }
}