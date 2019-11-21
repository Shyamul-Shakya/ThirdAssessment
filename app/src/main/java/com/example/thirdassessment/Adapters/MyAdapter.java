package com.example.thirdassessment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.thirdassessment.Modules.Students;
import com.example.thirdassessment.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context context;
    List<Students> studentsList;

    public MyAdapter(Context context, List<Students> stuList){
        this.context = context;
        this.studentsList = stuList;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View  view = inflater.inflate(R.layout.student_view, parent, false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, final int position) {
        final Students student = studentsList.get(position);

        holder.profile.setImageResource(student.getImg());
        holder.nametxt.setText(student.getName());
        holder.agetxt.setText(student.getAge());
        holder.addresstxt.setText(student.getAddress());
        holder.gendertxt.setText(student.getGender());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentsList.remove(student);

                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView profile, delete;
        TextView nametxt, agetxt, gendertxt, addresstxt;

        public MyHolder(View view){
            super(view);

            profile = view.findViewById(R.id.profileimg);
            nametxt = view.findViewById(R.id.nameview);
            agetxt = view.findViewById(R.id.ageview);
            addresstxt = view.findViewById(R.id.addressview);
            gendertxt = view.findViewById(R.id.genderview);
            delete = view.findViewById(R.id.delete);
        }
    }
}
