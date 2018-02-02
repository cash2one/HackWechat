package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Creator<PrivFrame> CREATOR = new 1();
    public final String aqS;
    public final byte[] aqT;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.aqS = str;
        this.aqT = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.aqS = parcel.readString();
        this.aqT = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (t.h(this.aqS, privFrame.aqS) && Arrays.equals(this.aqT, privFrame.aqT)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.aqS != null ? this.aqS.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.aqT);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aqS);
        parcel.writeByteArray(this.aqT);
    }
}
