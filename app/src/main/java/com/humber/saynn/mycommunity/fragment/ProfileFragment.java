package com.humber.saynn.mycommunity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.humber.saynn.mycommunity.R;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {

    public static final int PICTURE_REQUEST_CODE = 99;
    ImageView profileImage;
    TextView editPhotoText;
    Bitmap bitmap;

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.profile_fragment,container,false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage = view.findViewById(R.id.profileImage);
        editPhotoText = view.findViewById(R.id.editPhotoText);
        editPhotoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImageFile();
            }
        });

        Fragment foodFragment = HorizontalFoodFragment.newInstance();
        Fragment musicFragent = HorizontalMusicFragment.newInstance();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.foodFragmentProfile,foodFragment);
        fragmentTransaction.replace(R.id.musicContainerProfile,musicFragent);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);

    }

    private void chooseImageFile(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),
                PICTURE_REQUEST_CODE);
    }

        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == PICTURE_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(v.getContext().getContentResolver(), filePath);
                profileImage.setImageBitmap(bitmap);
                profileImage.setAdjustViewBounds(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
