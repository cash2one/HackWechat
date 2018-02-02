package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.platformtools.x;

public class SightCaptureResult implements Parcelable {
    public static final Creator<SightCaptureResult> CREATOR = new 1();
    public boolean oqA = true;
    public String oqB = "";
    public String oqC = "";
    public String oqD = "";
    public String oqE = "";
    public int oqF = 0;
    public aqc oqG = new aqc();
    public String oqH = "";
    public boolean oqy = false;
    public boolean oqz = false;

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i, aqc com_tencent_mm_protocal_c_aqc) {
        this.oqA = z;
        this.oqB = str;
        this.oqC = str2;
        this.oqD = str3;
        this.oqF = i;
        this.oqG = com_tencent_mm_protocal_c_aqc;
        this.oqE = str4;
        this.oqy = true;
        this.oqz = false;
    }

    public SightCaptureResult(boolean z, String str) {
        this.oqA = z;
        this.oqH = str;
        this.oqy = false;
        this.oqz = true;
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        this.oqy = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.oqz = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.oqA = z;
        this.oqB = parcel.readString();
        this.oqC = parcel.readString();
        this.oqD = parcel.readString();
        this.oqE = parcel.readString();
        this.oqF = parcel.readInt();
        this.oqH = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.oqG = new aqc();
            this.oqG.aF(bArr);
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureResult", "read ext info error: %s", e.getMessage());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (this.oqy ? 1 : 0));
        if (this.oqz) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.oqA) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.oqB);
        parcel.writeString(this.oqC);
        parcel.writeString(this.oqD);
        parcel.writeString(this.oqE);
        parcel.writeInt(this.oqF);
        parcel.writeString(this.oqH);
        try {
            byte[] toByteArray = this.oqG.toByteArray();
            parcel.writeInt(toByteArray.length);
            parcel.writeByteArray(toByteArray);
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureResult", "write ext info error");
        }
    }
}
