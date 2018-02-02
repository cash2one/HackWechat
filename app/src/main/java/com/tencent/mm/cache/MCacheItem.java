package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MCacheItem implements Parcelable {
    public static final Creator<MCacheItem> CREATOR = new 1();
    private c gBz;

    public MCacheItem(Parcel parcel) {
        this.gBz = c(parcel);
    }

    public MCacheItem(c cVar) {
        this.gBz = cVar;
    }

    private c c(Parcel parcel) {
        Class cls = Class.forName(parcel.readString());
        try {
            this.gBz = (c) cls.newInstance();
        } catch (Exception e) {
        }
        try {
            for (Field type : c.D(cls).hSY) {
                Method method = (Method) a.gBB.get(type.getType());
                if (method != null) {
                    try {
                        method.invoke(null, new Object[]{parcel, type, this.gBz});
                    } catch (Throwable e2) {
                        x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e2)});
                    }
                }
            }
            return this.gBz;
        } catch (Throwable e22) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e22)});
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gBz.getClass().getName());
        for (Field type : c.D(this.gBz.getClass()).hSY) {
            Method method = (Method) a.gBA.get(type.getType());
            if (method != null) {
                try {
                    method.invoke(null, new Object[]{parcel, type, this.gBz});
                } catch (Throwable e) {
                    x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
    }
}
