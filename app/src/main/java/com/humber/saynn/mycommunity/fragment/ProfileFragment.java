package com.humber.saynn.mycommunity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humber.saynn.mycommunity.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProfileFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Fragment f = HorizontalFoodFragment.newInstance();

        View v = inflater.inflate(R.layout.profile_fragment,container,false);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.foodFragmentProfile,f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        return v;
    }
}
