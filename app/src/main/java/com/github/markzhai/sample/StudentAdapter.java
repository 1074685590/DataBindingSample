package com.github.markzhai.sample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2018/11/16 0016 on 上午 10:55
 */

class StudentAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private static final String TAG = "StudentAdapter";

    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;

    private ArrayList<Student> mStudents ;

    private LayoutInflater mLayoutInflater;
    final Random mRandom;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public StudentAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mStudents = new ArrayList<>();
        mRandom = new Random();
    }

    public interface OnItemClickListener {
        void onStudentClick(Student student);
    }

    @Override
    public int getItemViewType(int position) {
        Student student = mStudents.get(position);
        if (student.isFired.get()) {
            return ITEM_VIEW_TYPE_ON;
        } else {
            return ITEM_VIEW_TYPE_OFF;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding mBinding = null;
        if (viewType == ITEM_VIEW_TYPE_ON) {
            mBinding = DataBindingUtil.inflate(mLayoutInflater,
                    R.layout.item_student, parent, false);
        } else if (viewType == ITEM_VIEW_TYPE_OFF){
            mBinding = DataBindingUtil.inflate(mLayoutInflater,
                    R.layout.item_student_fired, parent, false);
        }
        return new BindingViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Student student = mStudents.get(position);
        holder.getBinding().setVariable(BR.student,student);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onStudentClick(student);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }


    public void setStudents(ArrayList<Student> students) {
        mStudents = students;
    }

    public void add(Student student) {
        int position = mRandom.nextInt(mStudents.size() + 1);
        mStudents.add(position, student);
        notifyItemInserted(position);
    }

    public void remove() {
        if (mStudents.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(mStudents.size());
        mStudents.remove(position);
        notifyItemRemoved(position);
    }
}
