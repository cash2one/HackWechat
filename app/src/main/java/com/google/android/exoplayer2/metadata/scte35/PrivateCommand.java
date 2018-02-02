package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;

public final class PrivateCommand extends SpliceCommand {
    public static final Creator<PrivateCommand> CREATOR = new 1();
    public final long aqU;
    public final long aqV;
    public final byte[] aqW;

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.aqU = j2;
        this.aqV = j;
        this.aqW = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.aqU = parcel.readLong();
        this.aqV = parcel.readLong();
        this.aqW = new byte[parcel.readInt()];
        parcel.readByteArray(this.aqW);
    }

    static PrivateCommand a(j jVar, int i, long j) {
        long aK = jVar.aK();
        byte[] bArr = new byte[(i - 4)];
        jVar.readBytes(bArr, 0, bArr.length);
        return new PrivateCommand(aK, bArr, j);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.aqU);
        parcel.writeLong(this.aqV);
        parcel.writeInt(this.aqW.length);
        parcel.writeByteArray(this.aqW);
    }
}
