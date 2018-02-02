package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public abstract class f {
    public final DataHolder aMc;
    public int aMy;
    private int aMz;

    public f(DataHolder dataHolder, int i) {
        this.aMc = (DataHolder) w.ag(dataHolder);
        boolean z = i >= 0 && i < this.aMc.aMn;
        w.ar(z);
        this.aMy = i;
        this.aMz = this.aMc.dl(this.aMy);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return v.b(Integer.valueOf(fVar.aMy), Integer.valueOf(this.aMy)) && v.b(Integer.valueOf(fVar.aMz), Integer.valueOf(this.aMz)) && fVar.aMc == this.aMc;
    }

    public final byte[] getByteArray(String str) {
        DataHolder dataHolder = this.aMc;
        int i = this.aMy;
        int i2 = this.aMz;
        dataHolder.m(str, i);
        return dataHolder.aMk[i2].getBlob(i, dataHolder.aMj.getInt(str));
    }

    public final int getInteger(String str) {
        DataHolder dataHolder = this.aMc;
        int i = this.aMy;
        int i2 = this.aMz;
        dataHolder.m(str, i);
        return dataHolder.aMk[i2].getInt(i, dataHolder.aMj.getInt(str));
    }

    public final String getString(String str) {
        return this.aMc.c(str, this.aMy, this.aMz);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aMy), Integer.valueOf(this.aMz), this.aMc});
    }
}
