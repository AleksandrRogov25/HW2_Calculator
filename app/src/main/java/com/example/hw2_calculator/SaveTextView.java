package com.example.hw2_calculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class SaveTextView implements Parcelable {
    private TextView operation;

    public SaveTextView(TextView operation){
        this.operation = operation;
    }

    public TextView getOperation() {
        return operation;
    }

    public void setOperation(TextView operation) {
        this.operation = operation;
    }

    protected SaveTextView(Parcel in) {
    }

    public static final Creator<SaveTextView> CREATOR = new Creator<SaveTextView>() {
        @Override
        public SaveTextView createFromParcel(Parcel in) {
            return new SaveTextView(in);
        }

        @Override
        public SaveTextView[] newArray(int size) {
            return new SaveTextView[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
