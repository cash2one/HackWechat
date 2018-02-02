package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryHandleItem> CREATOR = new Creator<RecoveryHandleItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
            recoveryHandleItem.ned = parcel.readString();
            recoveryHandleItem.clientVersion = parcel.readString();
            recoveryHandleItem.aAM = parcel.readString();
            recoveryHandleItem.processName = parcel.readString();
            recoveryHandleItem.zRB = parcel.readString();
            recoveryHandleItem.timestamp = parcel.readLong();
            return recoveryHandleItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryHandleItem[i];
        }
    };
    public String aAM;
    public String clientVersion;
    public String ned;
    public String processName;
    public long timestamp;
    public String zRB;

    public final String cDl() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ned);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.aAM);
        stringBuffer.append(",");
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.zRB);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    public final boolean aaM(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.ned = split[0];
            this.clientVersion = split[1];
            this.aAM = split[2];
            this.processName = split[3];
            this.zRB = split[4];
            this.timestamp = Long.valueOf(split[5]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ned);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.aAM);
        parcel.writeString(this.processName);
        parcel.writeString(this.zRB);
        parcel.writeLong(this.timestamp);
    }
}
