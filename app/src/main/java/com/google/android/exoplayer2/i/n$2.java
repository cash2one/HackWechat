package com.google.android.exoplayer2.i;

import java.util.Comparator;

class n$2 implements Comparator<n$a> {
    n$2() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n$a com_google_android_exoplayer2_i_n_a = (n$a) obj;
        n$a com_google_android_exoplayer2_i_n_a2 = (n$a) obj2;
        if (com_google_android_exoplayer2_i_n_a.value < com_google_android_exoplayer2_i_n_a2.value) {
            return -1;
        }
        return com_google_android_exoplayer2_i_n_a2.value < com_google_android_exoplayer2_i_n_a.value ? 1 : 0;
    }
}
