package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryStatusItem> CREATOR = new Creator<RecoveryStatusItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
            recoveryStatusItem.processName = parcel.readString();
            recoveryStatusItem.ned = parcel.readString();
            recoveryStatusItem.clientVersion = parcel.readString();
            recoveryStatusItem.zRm = parcel.readInt();
            recoveryStatusItem.zRp = parcel.readInt();
            recoveryStatusItem.zRo = parcel.readInt();
            recoveryStatusItem.timestamp = parcel.readLong();
            return recoveryStatusItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryStatusItem[i];
        }
    };
    public String clientVersion;
    public String ned;
    public String processName;
    public long timestamp;
    public int zRm;
    public int zRo;
    public int zRp;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.ned);
        parcel.writeString(this.clientVersion);
        parcel.writeInt(this.zRm);
        parcel.writeInt(this.zRp);
        parcel.writeInt(this.zRo);
        parcel.writeLong(this.timestamp);
    }

    public final boolean aaM(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.processName = split[0];
            this.ned = split[1];
            this.clientVersion = split[2];
            this.zRm = Integer.valueOf(split[3]).intValue();
            this.zRp = Integer.valueOf(split[4]).intValue();
            this.zRo = Integer.valueOf(split[5]).intValue();
            this.timestamp = Long.valueOf(split[6]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final String cDl() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.ned);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.zRm);
        stringBuffer.append(",");
        stringBuffer.append(this.zRp);
        stringBuffer.append(",");
        stringBuffer.append(this.zRo);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }
}
