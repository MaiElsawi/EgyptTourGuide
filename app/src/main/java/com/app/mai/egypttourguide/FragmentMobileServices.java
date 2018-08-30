package com.app.mai.egypttourguide;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentMobileServices extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// change action bar title
        getActivity().setTitle("Mobile Services Places");
// Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mobile_services, container, false);
        TextView vodafone = rootView.findViewById(R.id.voda);
        TextView orange = rootView.findViewById(R.id.orange);
        TextView etisalat = rootView.findViewById(R.id.etisalat);
        vodafone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vodafoneURL = "http://www.vodafone.com.eg/vodafoneportalWeb/en/P609278041288855462173";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(vodafoneURL));
                startActivity(i);
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orangeURL = "https://www.orange.eg/en/find-store";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(orangeURL));
                startActivity(i);
            }
        });
        etisalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etisalatURL = "http://www.etisalat.eg/etisalat/portal/find_a_shop_en";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(etisalatURL));
                startActivity(i);
            }
        });


        return rootView;
    }
}

