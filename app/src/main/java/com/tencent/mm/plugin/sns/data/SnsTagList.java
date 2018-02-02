package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList implements Parcelable {
    public static final Creator<SnsTagList> CREATOR = new 1();
    private int qQT = 0;
    private List<Long> qQU = new LinkedList();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.qQT = this.qQU.size();
        parcel.writeInt(this.qQT);
        for (Long longValue : this.qQU) {
            parcel.writeLong(longValue.longValue());
        }
    }
}
