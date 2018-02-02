package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new Creator<DrmInitData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrmInitData[i];
        }
    };
    private int aen;
    public final SchemeData[] ais;
    public final int ait;

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (b.acn.equals(SchemeData.a(schemeData))) {
            return b.acn.equals(SchemeData.a(schemeData2)) ? 0 : 1;
        } else {
            return SchemeData.a(schemeData).compareTo(SchemeData.a(schemeData2));
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    private DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2;
        if (z) {
            schemeDataArr2 = (SchemeData[]) schemeDataArr.clone();
        } else {
            schemeDataArr2 = schemeDataArr;
        }
        Arrays.sort(schemeDataArr2, this);
        for (int i = 1; i < schemeDataArr2.length; i++) {
            if (SchemeData.a(schemeDataArr2[i - 1]).equals(SchemeData.a(schemeDataArr2[i]))) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + SchemeData.a(schemeDataArr2[i]));
            }
        }
        this.ais = schemeDataArr2;
        this.ait = schemeDataArr2.length;
    }

    DrmInitData(Parcel parcel) {
        this.ais = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.ait = this.ais.length;
    }

    public final DrmInitData O(String str) {
        Object obj;
        for (SchemeData schemeData : this.ais) {
            if (!t.h(schemeData.type, str)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return this;
        }
        SchemeData[] schemeDataArr = new SchemeData[this.ais.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            SchemeData schemeData2;
            SchemeData schemeData3 = this.ais[i];
            if (t.h(schemeData3.type, str)) {
                schemeData2 = schemeData3;
            } else {
                schemeData2 = new SchemeData(schemeData3.uuid, str, schemeData3.mimeType, schemeData3.data, schemeData3.aiu);
            }
            schemeDataArr[i] = schemeData2;
        }
        return new DrmInitData(schemeDataArr);
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = Arrays.hashCode(this.ais);
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
        return Arrays.equals(this.ais, ((DrmInitData) obj).ais);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.ais, 0);
    }
}
