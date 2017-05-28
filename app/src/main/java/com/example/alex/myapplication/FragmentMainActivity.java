package com.example.alex.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.alex.myapplication.R.id.SpeciesView;



public class FragmentMainActivity extends Fragment {

    PetDbHelper mPetDbHelper;
    private OnFragmentInteractionListener mListener;




    public interface OnFragmentInteractionListener {
        void onPetSelected(String onPetLocationInList );
    }

    public static FragmentMainActivity newInstance() {
        return new FragmentMainActivity();
    }
    public FragmentMainActivity() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pet_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_pet_list);
        mPetDbHelper = new PetDbHelper(getContext());
        mPetDbHelper.initDb();
        String[] species = {"Dogs", "Cats", "Other"};

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(getContext(),R.layout.speciesview, species);

        ListView list=(ListView)getActivity().findViewById(SpeciesView);
        list.setAdapter(adapter);

        ListView listView = (ListView)getActivity().findViewById(SpeciesView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // Intent intent = null;
               Intent intent =null;

                    switch (position) {
                        case 0:
                            mListener.onPetSelected("Dogs");
                            break;
                        case 1:
                            mListener.onPetSelected("Cats");
                            break;
                        case 2:
                            mListener.onPetSelected("Other");
                            break;

                    }




                }


        });


    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }







}

/* public static FragmentMainActivity newInstance() {
        return new FragmentMainActivity();
    }

    public FragmentMainActivity() {
        // Required epublimpty public constructor
    }*/