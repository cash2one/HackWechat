package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class c$a {
    public final String aXw;
    public final Object bbw;

    c$a(String str, Object obj) {
        this.aXw = str;
        this.bbw = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c$a)) {
            return false;
        }
        c$a com_google_android_gms_tagmanager_c_a = (c$a) obj;
        return this.aXw.equals(com_google_android_gms_tagmanager_c_a.aXw) && this.bbw.equals(com_google_android_gms_tagmanager_c_a.bbw);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.aXw.hashCode()), Integer.valueOf(this.bbw.hashCode())});
    }

    public final String toString() {
        return "Key: " + this.aXw + " value: " + this.bbw.toString();
    }
}
