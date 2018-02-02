package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.f.d$a;
import com.tencent.mm.plugin.appbrand.jsapi.f.g;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

public final class a {
    private static final int[] afm = new int[]{1, 2, 3, 6};
    private static final int[] afn = new int[]{48000, 44100, 32000};
    private static final int[] afo = new int[]{24000, 22050, 16000};
    private static final int[] afp = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] afq = new int[]{32, 40, 48, 56, 64, 80, 96, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, JsApiSetBackgroundAudioState.CTRL_INDEX, ar.CTRL_INDEX, 224, 256, 320, 384, FileUtils.S_IRWXU, WXMediaMessage.TITLE_LENGTH_LIMIT, 576, 640};
    private static final int[] afr = new int[]{69, 87, 104, 121, v.CTRL_INDEX, GameJsApiOperateGameCenterMsg.CTRL_BYTE, f.CTRL_INDEX, g.CTRL_INDEX, 278, d$a.CTRL_INDEX, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static Format a(j jVar, String str, String str2, DrmInitData drmInitData) {
        int i = afn[(jVar.readUnsignedByte() & ar.CTRL_INDEX) >> 6];
        int readUnsignedByte = jVar.readUnsignedByte();
        int i2 = afp[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.a(str, "audio/ac3", -1, -1, i2, i, null, drmInitData, str2);
    }

    public static Format b(j jVar, String str, String str2, DrmInitData drmInitData) {
        jVar.cV(2);
        int i = afn[(jVar.readUnsignedByte() & ar.CTRL_INDEX) >> 6];
        int readUnsignedByte = jVar.readUnsignedByte();
        int i2 = afp[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return Format.a(str, "audio/eac3", -1, -1, i2, i, null, drmInitData, str2);
    }

    public static a a(i iVar) {
        int i;
        int cT;
        int cT2;
        String str;
        int i2 = 1;
        int i3 = iVar.aCr + (iVar.aCq * 8);
        iVar.cS(40);
        if (iVar.cT(5) == 16) {
            i = 1;
        } else {
            byte b = (byte) 0;
        }
        iVar.cR(i3);
        int i4;
        int i5;
        if (i != 0) {
            String str2 = "audio/eac3";
            iVar.cS(21);
            cT = (iVar.cT(11) + 1) * 2;
            cT2 = iVar.cT(2);
            if (cT2 == 3) {
                i4 = afo[iVar.cT(2)];
                i = 6;
            } else {
                i = afm[iVar.cT(2)];
                i4 = afn[cT2];
            }
            cT2 = i * 256;
            i = iVar.cT(3);
            i5 = i4;
            str = str2;
            i3 = i5;
        } else {
            String str3 = "audio/ac3";
            iVar.cS(32);
            i3 = iVar.cT(2);
            i = iVar.cT(6);
            i4 = i / 2;
            if (i3 < 0 || i3 >= afn.length || i < 0 || i4 >= afr.length) {
                i = -1;
            } else {
                cT2 = afn[i3];
                if (cT2 == 44100) {
                    i = ((i % 2) + afr[i4]) * 2;
                } else {
                    i = afq[i4];
                    i = cT2 == 32000 ? i * 6 : i * 4;
                }
            }
            iVar.cS(8);
            i4 = iVar.cT(3);
            if (!((i4 & 1) == 0 || i4 == 1)) {
                iVar.cS(2);
            }
            if ((i4 & 4) != 0) {
                iVar.cS(2);
            }
            if (i4 == 2) {
                iVar.cS(2);
            }
            i3 = afn[i3];
            cT2 = 1536;
            i5 = i;
            i = i4;
            str = str3;
            cT = i5;
        }
        boolean lC = iVar.lC();
        i = afp[i];
        if (!lC) {
            i2 = 0;
        }
        return new a(str, i2 + i, i3, cT, cT2, (byte) 0);
    }

    public static int ix() {
        return 1536;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i;
        if (((byteBuffer.get(byteBuffer.position() + 4) & ar.CTRL_INDEX) >> 6) == 3) {
            i = 6;
        } else {
            i = afm[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
