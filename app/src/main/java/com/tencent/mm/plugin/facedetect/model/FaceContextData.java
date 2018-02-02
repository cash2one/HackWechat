package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import junit.framework.Assert;

public class FaceContextData implements Parcelable {
    public static final Creator<FaceContextData> CREATOR = new 1();
    private static volatile FaceContextData mga = null;
    public long mgb = -1;

    public static void a(FaceContextData faceContextData) {
        if (faceContextData == null) {
            mga = null;
        } else if (mga != null) {
            b(faceContextData);
        } else {
            synchronized (FaceContextData.class) {
                if (mga != null) {
                    b(faceContextData);
                    return;
                }
                mga = faceContextData;
            }
        }
    }

    private static void b(FaceContextData faceContextData) {
        boolean z = (mga == null || faceContextData == null) ? false : true;
        Assert.assertTrue(z);
        mga.mgb = faceContextData.mgb;
    }

    public static synchronized FaceContextData aGt() {
        FaceContextData faceContextData;
        synchronized (FaceContextData.class) {
            faceContextData = mga;
        }
        return faceContextData;
    }

    protected FaceContextData(Parcel parcel) {
        this.mgb = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mgb);
    }
}
