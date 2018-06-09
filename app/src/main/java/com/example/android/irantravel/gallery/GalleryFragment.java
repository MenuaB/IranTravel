package com.example.android.irantravel.gallery;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.irantravel.R;

import java.util.ArrayList;

//import ir.beigirad.batoproject.R;

public class GalleryFragment extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayList<String> imageUrls;
    private int current;


    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance(ArrayList<String> imgUrls, int current) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, imgUrls);
        args.putInt(ARG_PARAM2, current);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUrls = getArguments().getStringArrayList(ARG_PARAM1);
            current = getArguments().getInt(ARG_PARAM2);
        }
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppTheme);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.black);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        pager=root.findViewById(R.id.gallery_vp);

        return root;
    }

    ViewPager pager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        pager = view.findViewById(R.id.gallery_pager);

        GallryAdapter adapter = new GallryAdapter(getChildFragmentManager(), imageUrls);
        pager.setAdapter(adapter);
        pager.setCurrentItem(current);
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        final ImageView next=view.findViewById(R.id.img_next);
        final ImageView prev=view.findViewById(R.id.img_prev);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(pager.getCurrentItem()+1,true);
                prev.setVisibility(View.VISIBLE);
                if (pager.getCurrentItem()==3){
                    next.setVisibility(View.GONE);
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(pager.getCurrentItem()-1,true);
                next.setVisibility(View.VISIBLE);
                if (pager.getCurrentItem()==0){
                    prev.setVisibility(View.GONE);
                }
            }
        });
        prev.setVisibility(View.GONE);

    }
}
