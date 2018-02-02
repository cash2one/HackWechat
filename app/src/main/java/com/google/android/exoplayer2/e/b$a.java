package com.google.android.exoplayer2.e;

import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.t;

public class b$a extends Exception {
    public final boolean aqb;
    public final String aqc;
    public final String aqd;
    public final String mimeType;

    public b$a(Format format, Throwable th, boolean z, int i) {
        super("Decoder init failed: [" + i + "], " + format, th);
        this.mimeType = format.adV;
        this.aqb = z;
        this.aqc = null;
        this.aqd = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
    }

    public b$a(Format format, Throwable th, boolean z, String str) {
        String str2 = null;
        super("Decoder init failed: " + str + ", " + format, th);
        this.mimeType = format.adV;
        this.aqb = z;
        this.aqc = str;
        if (t.SDK_INT >= 21 && (th instanceof CodecException)) {
            str2 = ((CodecException) th).getDiagnosticInfo();
        }
        this.aqd = str2;
    }
}
