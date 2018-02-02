package com.google.android.exoplayer2.c;

import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.d;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;

public final class i {
    private static final String[] aiI = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] aiJ = new int[]{44100, 48000, 32000};
    private static final int[] aiK = new int[]{32, 64, 96, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, ar.CTRL_INDEX, 224, 256, 288, 320, d.CTRL_INDEX, 384, 416, FileUtils.S_IRWXU};
    private static final int[] aiL = new int[]{32, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, e.CTRL_INDEX, JsApiSetBackgroundAudioState.CTRL_INDEX, 176, ar.CTRL_INDEX, 224, 256};
    private static final int[] aiM = new int[]{32, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, ar.CTRL_INDEX, 224, 256, 320, 384};
    private static final int[] aiN = new int[]{32, 40, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, ar.CTRL_INDEX, 224, 256, 320};
    private static final int[] aiO = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, e.CTRL_INDEX, JsApiSetBackgroundAudioState.CTRL_INDEX};
    public int afs;
    public int aiP;
    public int bitrate;
    public int channels;
    public String mimeType;
    public int sampleRate;
    public int version;

    public static int cl(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = aiJ[i5];
        if (i2 == 2) {
            i5 = i6 / 2;
        } else if (i2 == 0) {
            i5 = i6 / 4;
        } else {
            i5 = i6;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? aiK[i4 - 1] : aiL[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? aiM[i4 - 1] : aiN[i4 - 1];
        } else {
            i4 = aiO[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    public static boolean a(int i, i iVar) {
        int i2 = 2;
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i3 = (i >>> 19) & 3;
        if (i3 == 1) {
            return false;
        }
        int i4 = (i >>> 17) & 3;
        if (i4 == 0) {
            return false;
        }
        int i5 = (i >>> 12) & 15;
        if (i5 == 0 || i5 == 15) {
            return false;
        }
        int i6 = (i >>> 10) & 3;
        if (i6 == 3) {
            return false;
        }
        int i7;
        int i8 = aiJ[i6];
        if (i3 == 2) {
            i7 = i8 / 2;
        } else if (i3 == 0) {
            i7 = i8 / 4;
        } else {
            i7 = i8;
        }
        int i9 = (i >>> 9) & 1;
        if (i4 == 3) {
            i8 = i3 == 3 ? aiK[i5 - 1] : aiL[i5 - 1];
            i5 = 384;
            i6 = i8;
            i8 = (((i8 * 12000) / i7) + i9) * 4;
        } else {
            if (i3 == 3) {
                i5 = i4 == 2 ? aiM[i5 - 1] : aiN[i5 - 1];
                i8 = 1152;
            } else {
                i5 = aiO[i5 - 1];
                i8 = i4 == 1 ? 576 : 1152;
                if (i4 == 1) {
                    i6 = i5;
                    i5 = i8;
                    i8 = 72000;
                    i8 = ((i8 * i6) / i7) + i9;
                }
            }
            i6 = i5;
            i5 = i8;
            i8 = 144000;
            i8 = ((i8 * i6) / i7) + i9;
        }
        String str = aiI[3 - i4];
        if (((i >> 6) & 3) == 3) {
            i2 = 1;
        }
        i6 *= 1000;
        iVar.version = i3;
        iVar.mimeType = str;
        iVar.afs = i8;
        iVar.sampleRate = i7;
        iVar.channels = i2;
        iVar.bitrate = i6;
        iVar.aiP = i5;
        return true;
    }
}
