package com.tencent.mm.pluginsdk.model.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportUtil$ReportArgs implements Parcelable {
    public static final Creator<ReportUtil$ReportArgs> CREATOR = new 1();
    public int errCode;
    public String openId;
    public int pK;
    public String transaction;
    public String uC;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uC);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.transaction);
        parcel.writeString(this.openId);
    }

    private ReportUtil$ReportArgs(Parcel parcel) {
        this.uC = parcel.readString();
        this.errCode = parcel.readInt();
        this.transaction = parcel.readString();
        this.openId = parcel.readString();
    }
}
