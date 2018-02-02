package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.Arrays;

public final class EventMessage implements Entry {
    public static final Creator<EventMessage> CREATOR = new 1();
    private int aen;
    public final long aqA;
    public final byte[] aqB;
    public final String aqz;
    public final long id;
    public final String value;

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.aqz = str;
        this.value = str2;
        this.aqA = j;
        this.id = j2;
        this.aqB = bArr;
    }

    EventMessage(Parcel parcel) {
        this.aqz = parcel.readString();
        this.value = parcel.readString();
        this.aqA = parcel.readLong();
        this.id = parcel.readLong();
        this.aqB = parcel.createByteArray();
    }

    public final int hashCode() {
        int i = 0;
        if (this.aen == 0) {
            int hashCode = ((this.aqz != null ? this.aqz.hashCode() : 0) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            this.aen = ((((((hashCode + i) * 31) + ((int) (this.aqA ^ (this.aqA >>> 32)))) * 31) + ((int) (this.id ^ (this.id >>> 32)))) * 31) + Arrays.hashCode(this.aqB);
        }
        return this.aen;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.aqA == eventMessage.aqA && this.id == eventMessage.id && t.h(this.aqz, eventMessage.aqz) && t.h(this.value, eventMessage.value) && Arrays.equals(this.aqB, eventMessage.aqB)) {
            return true;
        }
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aqz);
        parcel.writeString(this.value);
        parcel.writeLong(this.aqA);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.aqB);
    }
}
