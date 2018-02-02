package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.i.t;

@TargetApi(16)
public final class a {
    public final boolean agL;
    public final boolean apn;
    public final boolean apo;
    public final CodecCapabilities apq;
    public final String mimeType;
    public final String name;

    public static a a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = false;
        this.name = (String) com.google.android.exoplayer2.i.a.Y(str);
        this.mimeType = str2;
        this.apq = codecCapabilities;
        if (!(z || codecCapabilities == null)) {
            if (t.SDK_INT < 19 || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                z3 = true;
                this.apn = z3;
                if (codecCapabilities != null) {
                    if (t.SDK_INT >= 21 || !codecCapabilities.isFeatureSupported("tunneled-playback")) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        z3 = true;
                        this.agL = z3;
                        if (!z2) {
                            if (codecCapabilities != null) {
                                if (t.SDK_INT >= 21 || !codecCapabilities.isFeatureSupported("secure-playback")) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                            }
                            this.apo = z4;
                        }
                        z4 = true;
                        this.apo = z4;
                    }
                }
                z3 = false;
                this.agL = z3;
                if (z2) {
                    if (codecCapabilities != null) {
                        if (t.SDK_INT >= 21) {
                        }
                        z3 = false;
                    }
                    this.apo = z4;
                }
                z4 = true;
                this.apo = z4;
            }
        }
        z3 = false;
        this.apn = z3;
        if (codecCapabilities != null) {
            if (t.SDK_INT >= 21) {
            }
            z3 = false;
            if (z3) {
                z3 = true;
                this.agL = z3;
                if (z2) {
                    if (codecCapabilities != null) {
                        if (t.SDK_INT >= 21) {
                        }
                        z3 = false;
                    }
                    this.apo = z4;
                }
                z4 = true;
                this.apo = z4;
            }
        }
        z3 = false;
        this.agL = z3;
        if (z2) {
            if (codecCapabilities != null) {
                if (t.SDK_INT >= 21) {
                }
                z3 = false;
            }
            this.apo = z4;
        }
        z4 = true;
        this.apo = z4;
    }

    public final CodecProfileLevel[] jJ() {
        return (this.apq == null || this.apq.profileLevels == null) ? new CodecProfileLevel[0] : this.apq.profileLevels;
    }

    @TargetApi(21)
    public final boolean a(int i, int i2, double d) {
        if (this.apq == null) {
            P("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = this.apq.getVideoCapabilities();
        if (videoCapabilities == null) {
            P("sizeAndRate.vCaps");
            return false;
        }
        if (!a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                P("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            }
            new StringBuilder("AssumedSupport [").append("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(t.aCI).append("]");
        }
        return true;
    }

    public final void P(String str) {
        new StringBuilder("NoSupport [").append(str).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(t.aCI).append("]");
    }

    @TargetApi(21)
    private static boolean a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
