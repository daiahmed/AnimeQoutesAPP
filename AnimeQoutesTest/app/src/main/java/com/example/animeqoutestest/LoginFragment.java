package com.example.animeqoutestest;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Initialize the EditText fields
        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);

        // Set up the login button
        Button loginButton = view.findViewById(R.id.Fragment_login_button);
        loginButton.setOnClickListener(v -> {
            if (validateInput()) {
                // Proceed with the login logic
                loginClick(view);
            }
        });

        return view;
    }

    private boolean validateInput() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("Username is required");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return false;
        }

        return true;
    }
    public void loginClick(View view) {
        // Create a new instance of ListViewFragment
        ListViewFragment listViewFragment = new ListViewFragment();

        // Replace the current fragment with the ListViewFragment
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, listViewFragment) // R.id.fragment_container is the ID of the container where the fragment should be loaded
                .addToBackStack(null) // Optionally add this transaction to the back stack, so the user can navigate back
                .commit();
    }
}