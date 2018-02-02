package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

public class FaceCharacteristicsResult implements Parcelable {
    public static final Creator<FaceCharacteristicsResult> CREATOR = new 1();
    public int errCode;
    public String fnL;
    public FaceStatus mfZ;

    protected FaceCharacteristicsResult(Parcel parcel) {
        this.errCode = parcel.readInt();
        this.fnL = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mfZ, i);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.fnL);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FaceCharacteristicsResult{mStatus=" + this.mfZ + ", errCode=" + this.errCode + ", errMsg='" + this.fnL + '\'' + '}';
    }

    public static boolean pq(int i) {
        return i >= 10 && i < 100;
    }

    public static boolean pr(int i) {
        return i > 0 && i < 10;
    }

    public static boolean ps(int i) {
        return i <= 0;
    }

    public final void aa(int i, String str) {
        this.errCode = i;
        this.fnL = str;
    }
}
