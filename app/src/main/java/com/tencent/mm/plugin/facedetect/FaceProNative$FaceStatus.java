package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FaceProNative$FaceStatus implements Parcelable {
    public static final Creator<FaceProNative$FaceStatus> CREATOR = new 1();
    public Rect facerect;
    public float pitch;
    public int result;
    public float roll;
    public float[] xys;
    public float yaw;

    protected FaceProNative$FaceStatus(Parcel parcel) {
        this.result = parcel.readInt();
        this.facerect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.xys = parcel.createFloatArray();
        this.pitch = parcel.readFloat();
        this.yaw = parcel.readFloat();
        this.roll = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.result);
        parcel.writeParcelable(this.facerect, i);
        parcel.writeFloatArray(this.xys);
        parcel.writeFloat(this.pitch);
        parcel.writeFloat(this.yaw);
        parcel.writeFloat(this.roll);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
    }
}
