package com.example.homedical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homedical.Medical;
import com.example.homedical.R;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private MedicalAdapter mMedicalAdapter;
    public void setConfig (RecyclerView recyclerView, Context context, List<Medical> medicals, List<String> keys){
        mContext = context;
        mMedicalAdapter = new MedicalAdapter(medicals,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mMedicalAdapter);
    }

    class MedicalitemView extends RecyclerView.ViewHolder {
        private TextView mProblem;
        private TextView mName;

        private String key;

        public MedicalitemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.medical_list_item,parent ,false));
            mProblem = (TextView) itemView.findViewById(R.id.problem_textview);
            mName = (TextView) itemView.findViewById(R.id.name_textview);

        }

        public void bind(Medical medical, String key){
            mProblem.setText(medical.getProblem());
            mName.setText(medical.getName());
            this.key = key;
        }
    }

    class MedicalAdapter extends RecyclerView.Adapter<MedicalitemView >{
        private List<Medical> mMedicalList;
        private List<String> keys;

        public MedicalAdapter(List<Medical> mMedicalList, List<String> keys) {
            this.mMedicalList = mMedicalList;
            this.keys = keys;
        }

        @NonNull
        @Override
        public MedicalitemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MedicalitemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MedicalitemView holder, int position) {
            holder.bind(mMedicalList.get(position), keys.get(position));
        }

        @Override
        public int getItemCount() {
            return mMedicalList.size();
        }
    }
}
