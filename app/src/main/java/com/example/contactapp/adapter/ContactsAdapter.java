package com.example.contactapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.MainActivity;
import com.example.contactapp.R;
import com.example.contactapp.dp.entity.Contact;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    // 1-variable

    private Context context;
    private ArrayList<Contact> contactsList;
    private MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.email = itemView.findViewById(R.id.email);

        }


    }

    public ContactsAdapter(Context context, ArrayList<Contact> contactsList, MainActivity mainActivity) {
        this.context = context;
        this.contactsList = contactsList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contact_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Contact contact = contactsList.get(holder.getAdapterPosition());

        holder.name.setText(contact.getName());
        holder.email.setText(contact.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.addAndEditContacts(true, contact, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}
