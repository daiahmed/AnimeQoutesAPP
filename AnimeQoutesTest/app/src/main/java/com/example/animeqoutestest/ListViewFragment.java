package com.example.animeqoutestest;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);

        // Create a list of ListItem objects
        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new ListItem(R.drawable.sidebiy, "The only way to do great work is to love what you do"));
        items.add(new ListItem(R.drawable.girlwithflower, "The best place to find a helping hand is at the end of your own arm."));
        items.add(new ListItem(R.drawable.samurairedgirl, "In the middle of difficulty lies opportunity."));
        items.add(new ListItem(R.drawable.japanesesamuraiboy, "It is not the strongest of the species that survives, nor the most intelligent that survives. It is the one that is most adaptable to change."));
        items.add(new ListItem(R.drawable.boyonmoon, "The future belongs to those who believe in the beauty of their dreams."));
        items.add(new ListItem(R.drawable.boywithearth, "The journey of a thousand miles begins with a single step"));
        items.add(new ListItem(R.drawable.splash_screen_pic, "Life is what happens when you're busy making other plans."));

        // Initialize the ListView and set the adapter
        ListView listView = rootView.findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(requireContext(), items);
        listView.setAdapter(customAdapter);

        // Set the item click listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            ListItem selectedItem = items.get(position);
            Intent intent = new Intent(getActivity(), DescriptionActivity.class);
            intent.putExtra("quote", selectedItem.getDescription());
            intent.putExtra("image", selectedItem.getImageResId());
            startActivity(intent);
        });

        return rootView;
    }
}