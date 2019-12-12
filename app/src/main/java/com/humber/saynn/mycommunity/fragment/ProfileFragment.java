package com.humber.saynn.mycommunity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humber.saynn.mycommunity.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ProfileFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.profile_fragment,container,false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment foodFragment = HorizontalFoodFragment.newInstance();
        Fragment musicFragent = HorizontalMusicFragment.newInstance();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.foodFragmentProfile,foodFragment);
        fragmentTransaction.replace(R.id.musicContainerProfile,musicFragent);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);

    }
}
