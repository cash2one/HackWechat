package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecordParam implements Parcelable {
    public static final Creator<RecordParam> CREATOR = new 1();
    public int afs = 0;
    public String appId = "";
    public int duration = 0;
    public String gHg;
    public int jAv = 0;
    public int jAw = 0;
    public String jfm;
    public String processName = "";
    public int sampleRate = 0;
    public int scene = 0;

    public int describeContents() {
        return 0;
    }

    public RecordParam(Parcel parcel) {
        this.duration = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.jAv = parcel.readInt();
        this.jAw = parcel.readInt();
        this.jfm = parcel.readString();
        this.gHg = parcel.readString();
        this.scene = parcel.readInt();
        this.afs = parcel.readInt();
        this.processName = parcel.readString();
        this.appId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.duration);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.jAv);
        parcel.writeInt(this.jAw);
        parcel.writeString(this.jfm);
        parcel.writeString(this.gHg);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.afs);
        parcel.writeString(this.processName);
        parcel.writeString(this.appId);
    }
}
