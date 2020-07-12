package com.example.radyapp.PatientSide.FragmentsP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.AppointmentsAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.PatientSide.AdaptersP.PatientAppointmentAdapter;
import com.example.radyapp.PatientSide.ModelsP.PatientApppointmentModel;
import com.example.radyapp.R;

import java.util.ArrayList;


public class PatientAppointmentFragment extends Fragment {
    View view;
    RecyclerView appointmentsRv;
    PatientAppointmentAdapter appointmentsAdapter;
    ArrayList<PatientApppointmentModel> patientAppointmentModels;
    ArrayList<PrescriptionModel> prescriptionModels;

    public PatientAppointmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        attachAdapter();

        refreshAdapter();

        return view;

    }

    private void attachAdapter() {

        appointmentsRv.setAdapter(appointmentsAdapter);
    }

    private void addData() {
        for (int i=0;i<10;i++)
        patientAppointmentModels.add(new PatientApppointmentModel());
    }

    private void refreshAdapter() {

        appointmentsAdapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        appointmentsRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        patientAppointmentModels=new ArrayList<>(3);
    }

    private void initAdapter() {
        appointmentsAdapter =new PatientAppointmentAdapter(patientAppointmentModels,prescriptionModels,0);
    }

    private void attachId() {
        appointmentsRv=view.findViewById(R.id.patient_appointments_rv1);
    }
}