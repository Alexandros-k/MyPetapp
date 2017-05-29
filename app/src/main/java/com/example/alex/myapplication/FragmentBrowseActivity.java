package com.example.alex.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.alex.myapplication.R.id.fragPetDetailsId;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBrowseActivity extends Fragment {


    PetDbHelper myDb;
    int i;

    public static final String ARG_PET_POSITION_IN_LIST = "pet_position_in_list";


    public static FragmentBrowseActivity newInstance(String petPositionInList) {
        FragmentBrowseActivity fragment = new FragmentBrowseActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PET_POSITION_IN_LIST, petPositionInList);
        fragment.setArguments(args);
        return fragment;
    }

    private String petPositionInList;

    public FragmentBrowseActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       if (getArguments() != null) {
            petPositionInList = getArguments().getString(ARG_PET_POSITION_IN_LIST);
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pet_details, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  getActivity().setContentView(R.layout.fragment_pet_details);

        myDb = new PetDbHelper(getActivity());


        final String petIntent =getActivity(). getIntent().getStringExtra(ARG_PET_POSITION_IN_LIST);

        final List<Pet> pet = myDb.getPets();

       PetAdaptrer petAdaptrer = new PetAdaptrer(getActivity(), R.layout.fragment_pet_details);
        ListView listview = (ListView) getActivity().findViewById(fragPetDetailsId);

        listview.setAdapter(petAdaptrer);
        for (i = 0; i < pet.size(); i++)

        {

            System.out.println(pet.get(i).getSpecies()+"   "+petIntent);
            if (pet.get(i).getSpecies().equals(petIntent)) {

                PetDataProvider petDataProvider = new PetDataProvider(
                        pet.get(i).getImageUri(), pet.get(i).getName(), pet.get(i).getBreed());
                petAdaptrer.add(petDataProvider);

            }
        }


        final ListView listView = (ListView) getActivity().findViewById(fragPetDetailsId);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                SharedPreferences preferences = getActivity().getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userDetailsName = preferences.getString("newUsername", "");
                System.out.println("auto einai2"+" "+ userDetailsName);
                if(!userDetailsName.isEmpty()) {


                    Intent intent = new Intent(getContext(), PetDetailsActivity.class);


                    String result = (String) listView.getItemAtPosition(position).toString();
                    intent.putExtra("Id", result);

                    startActivity(intent);
                }else{

                    Toast toast = Toast.makeText(getContext(), "please register first", Toast.LENGTH_SHORT);
                    toast.show();

                }

            }


        });
    }

    }





