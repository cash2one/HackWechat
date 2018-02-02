package com.google.android.gms.c;

import java.util.Arrays;

public final class l$a {
    public final int aXy;
    public final int aXz;

    public l$a(int i, int i2) {
        this.aXy = i;
        this.aXz = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l$a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        l$a com_google_android_gms_c_l_a = (l$a) obj;
        return com_google_android_gms_c_l_a.aXy == this.aXy && com_google_android_gms_c_l_a.aXz == this.aXz;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aXy), Integer.valueOf(this.aXz)});
    }
}
