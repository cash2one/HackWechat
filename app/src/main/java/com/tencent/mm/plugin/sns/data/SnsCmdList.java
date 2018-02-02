package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Creator<SnsCmdList> CREATOR = new 1();
    private int qQM = 0;
    private int qQN = 0;
    public List<Integer> qQO = new LinkedList();
    public List<Integer> qQP = new LinkedList();

    public final void wt(int i) {
        this.qQO.add(Integer.valueOf(i));
    }

    public final void wu(int i) {
        this.qQP.add(Integer.valueOf(i));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        this.qQM = this.qQO.size();
        parcel.writeInt(this.qQM);
        for (int i3 = 0; i3 < this.qQM; i3++) {
            parcel.writeInt(((Integer) this.qQO.get(i3)).intValue());
        }
        this.qQN = this.qQP.size();
        parcel.writeInt(this.qQN);
        while (i2 < this.qQN) {
            parcel.writeInt(((Integer) this.qQP.get(i2)).intValue());
            i2++;
        }
    }
}
