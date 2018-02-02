package com.google.android.exoplayer2.e;

import android.text.TextUtils;

final class d$a {
    public final boolean apo;
    public final String mimeType;

    public d$a(String str, boolean z) {
        this.mimeType = str;
        this.apo = z;
    }

    public final int hashCode() {
        return (this.apo ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != d$a.class) {
            return false;
        }
        d$a com_google_android_exoplayer2_e_d_a = (d$a) obj;
        if (TextUtils.equals(this.mimeType, com_google_android_exoplayer2_e_d_a.mimeType) && this.apo == com_google_android_exoplayer2_e_d_a.apo) {
            return true;
        }
        return false;
    }
}
