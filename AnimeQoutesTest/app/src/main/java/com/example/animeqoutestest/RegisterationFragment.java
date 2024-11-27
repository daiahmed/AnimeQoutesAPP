package com.example.animeqoutestest;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class RegisterationFragment extends Fragment {

    // EditText fields
    private EditText firstName;
    private EditText lastName;
    private EditText userName;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private EditText phoneNumber;

    // Spinner for countries
    private Spinner spinnerCountry;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RegisterationFragment() {
        // Required empty public constructor
    }

    public static RegisterationFragment newInstance(String param1, String param2) {
        RegisterationFragment fragment = new RegisterationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registeration, container, false);

        // Initialize EditText fields
        firstName = view.findViewById(R.id.etFirstName);
        lastName = view.findViewById(R.id.etLasName);
        userName = view.findViewById(R.id.etUsername);
        email = view.findViewById(R.id.etEmail);
        password = view.findViewById(R.id.etPassword);
        confirmPassword = view.findViewById(R.id.etConfirmPassword);
        phoneNumber = view.findViewById(R.id.etPhoneNumber);

        // Initialize Spinner
        spinnerCountry = view.findViewById(R.id.countrySpinner);

        // Set up Spinner with an array of countries
        String[] countries = {"Select Country","Eygpt","Saudi Arabia","Palastine","United States", "Canada", "United Kingdom", "Germany", "France","Turkey",
                "Australia", "India", "China", "Japan", "Brazil"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        // Set up the submit button
        Button submitButton = view.findViewById(R.id.Register_button);
        submitButton.setOnClickListener(v -> {
            if (validateInput()) {
                // Proceed with the registration logic
                onRegistration(view);
            }
        });

        return view;
    }

    private boolean validateInput() {
        // Validate each EditText field
        if (TextUtils.isEmpty(firstName.getText().toString().trim())) {
            firstName.setError("First name is required");
            return false;
        }

        if (TextUtils.isEmpty(lastName.getText().toString().trim())) {
            lastName.setError("Last name is required");
            return false;
        }

        if (TextUtils.isEmpty(userName.getText().toString().trim())) {
            userName.setError("Username is required");
            return false;
        }

        if (TextUtils.isEmpty(email.getText().toString().trim())) {
            email.setError("Email is required");
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            password.setError("Password is required");
            return false;
        }
        if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
            confirmPassword.setError("Passwords do not match");
            return false;
        }
        if (TextUtils.isEmpty(confirmPassword.getText().toString().trim())) {
            confirmPassword.setError("Confirm password is required");
            return false;
        }



        if (TextUtils.isEmpty(phoneNumber.getText().toString().trim())) {
            phoneNumber.setError("phone number is required");
            return false;
        }


        return true;
    }
    public void onRegistration(View view) {
        // Create a new instance of ListViewFragment
        ListViewFragment listViewFragment = new ListViewFragment();

        // Replace the current fragment with the ListViewFragment
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, listViewFragment) // R.id.fragment_container is the ID of the container where the fragment should be loaded
                .addToBackStack(null) // Optionally add this transaction to the back stack, so the user can navigate back
                .commit();
    }


}