package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Creator<Metadata> CREATOR = new Creator<Metadata>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Metadata[0];
        }
    };
    public final Entry[] aqo;

    public Metadata(Entry... entryArr) {
        this.aqo = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this.aqo = new Entry[list.size()];
        list.toArray(this.aqo);
    }

    Metadata(Parcel parcel) {
        this.aqo = new Entry[parcel.readInt()];
        for (int i = 0; i < this.aqo.length; i++) {
            this.aqo[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.aqo, ((Metadata) obj).aqo);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.aqo);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aqo.length);
        for (Parcelable writeParcelable : this.aqo) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
