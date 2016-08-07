package com.example.reginelae.firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by reginelae on 8/6/2016.
 */
public class UserAdapter extends ArrayAdapter <Contacts> {

    private Context context;
    private int resource;
    private ArrayList<Contacts> objects;

    TextView tvName, tvNumber;

    public UserAdapter(Context context, int resource, ArrayList<Contacts> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }


    public View getView(LayoutInflater inflater,int position, View convertView, ViewGroup container){

        Contacts contacts = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource,container, false);
            View view = inflater.inflate(R.layout.display_contact_adapter, container, false);

            tvName = (TextView) convertView.findViewById(R.id.name);
            tvNumber = (TextView) convertView.findViewById(R.id.number);

            tvName.setText(contacts.getName());
            tvNumber.setText(contacts.getNumber());
        }
        return convertView;
    }
}
