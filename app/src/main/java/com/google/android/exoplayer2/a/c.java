package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class c {
    public static final c afx = new c(new int[]{2}, 2);
    final int[] afy;
    private final int afz;

    public static c u(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        return (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? afx : new c(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    private c(int[] iArr, int i) {
        if (iArr != null) {
            this.afy = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.afy);
        } else {
            this.afy = new int[0];
        }
        this.afz = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Arrays.equals(this.afy, cVar.afy) && this.afz == cVar.afz) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.afz + (Arrays.hashCode(this.afy) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.afz + ", supportedEncodings=" + Arrays.toString(this.afy) + "]";
    }
}
