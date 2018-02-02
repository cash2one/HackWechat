package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.sdk.platformtools.x;

public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new 1();
    public static final GeneralControlWrapper vAJ = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper vAK = new GeneralControlWrapper(1);
    public int vAL;

    public GeneralControlWrapper(xd xdVar) {
        this.vAL = xdVar.wht;
        x.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public GeneralControlWrapper(int i) {
        this.vAL = i;
        x.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public final boolean cdz() {
        boolean z = (this.vAL & 8192) != 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + z);
        return z;
    }

    public final boolean cdA() {
        boolean z = (this.vAL & 2) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + z);
        return z;
    }

    public final boolean cdB() {
        boolean z = (this.vAL & 64) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + z);
        return z;
    }

    public final boolean cdC() {
        boolean z = (this.vAL & 2048) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean cdD() {
        boolean z = (this.vAL & 16384) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean cdE() {
        boolean z = (this.vAL & WXMediaMessage.THUMB_LENGTH_LIMIT) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = " + z);
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.vAL));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vAL);
    }

    private GeneralControlWrapper(Parcel parcel) {
        this.vAL = parcel.readInt();
    }
}
