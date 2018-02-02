package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData implements Parcelable {
    public static final Creator<RecoveryData> CREATOR = new Creator<RecoveryData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryData recoveryData = new RecoveryData();
            recoveryData.processName = parcel.readString();
            recoveryData.ned = parcel.readString();
            recoveryData.clientVersion = parcel.readString();
            recoveryData.zRz = parcel.readString();
            recoveryData.zRA = parcel.readArrayList(RecoveryData.class.getClassLoader());
            return recoveryData;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryData[i];
        }
    };
    public String clientVersion;
    public String ned;
    public String processName;
    public List<RecoveryStatusItem> zRA;
    public String zRz;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.ned);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.zRz);
        parcel.writeList(this.zRA);
    }
}
