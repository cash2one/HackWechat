package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new 1();
    public int fIr;
    public int fIs;
    public String fIt;
    public String fnp;
    public int jHc;
    public int scene;

    public final String toString() {
        return "AppBrandStatObject{preScene=" + this.fIs + ", preSceneNote='" + this.fIt + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.fnp + '\'' + ", usedState=" + this.jHc + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fIs);
        parcel.writeString(this.fIt);
        parcel.writeInt(this.scene);
        parcel.writeString(this.fnp);
        parcel.writeInt(this.jHc);
        parcel.writeInt(this.fIr);
    }

    protected AppBrandStatObject(Parcel parcel) {
        this.fIs = parcel.readInt();
        this.fIt = parcel.readString();
        this.scene = parcel.readInt();
        this.fnp = parcel.readString();
        this.jHc = parcel.readInt();
        this.fIr = parcel.readInt();
    }
}
