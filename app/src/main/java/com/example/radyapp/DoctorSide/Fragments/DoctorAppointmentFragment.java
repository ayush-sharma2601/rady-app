package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.AppointmentsAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.R;

import java.util.ArrayList;


public class DoctorAppointmentFragment extends Fragment {
    View view;
    RecyclerView appointmentsRv;
    AppointmentsAdapter appointmentsAdapter;
    ArrayList<DocAppointmentModel> docAppointmentModels;

    public DoctorAppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_doctor_appointments, container, false);

        attachId();

        attachLayout();

        initArrarList();

        addData();


        initAdapter();

        refreshAdapter();
        return view;

    }

    private void addData() {
        for (int i=0;i<10;i++)
        docAppointmentModels.add(new DocAppointmentModel("Rishabh","Mareez ka to mazak mat udao"));
    }

    private void refreshAdapter() {

        appointmentsAdapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        appointmentsRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        docAppointmentModels=new ArrayList<>(3);
    }

    private void initAdapter() {
        appointmentsAdapter =new AppointmentsAdapter(docAppointmentModels);
    }

    private void attachId() {
        appointmentsRv=view.findViewById(R.id.doctor_appointments_rv1);
    }
}