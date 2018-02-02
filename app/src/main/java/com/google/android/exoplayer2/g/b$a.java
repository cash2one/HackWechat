package com.google.android.exoplayer2.g;

import android.text.TextUtils;

final class b$a {
    public final int aef;
    public final String mimeType;
    public final int sampleRate;

    public b$a(int i, int i2, String str) {
        this.aef = i;
        this.sampleRate = i2;
        this.mimeType = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b$a com_google_android_exoplayer2_g_b_a = (b$a) obj;
        if (this.aef == com_google_android_exoplayer2_g_b_a.aef && this.sampleRate == com_google_android_exoplayer2_g_b_a.sampleRate && TextUtils.equals(this.mimeType, com_google_android_exoplayer2_g_b_a.mimeType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.aef * 31) + this.sampleRate) * 31);
    }
}
