package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

public final class h {
    private static final int[] ahi = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] ahj = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] ahk = new int[]{64, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, FileUtils.S_IWUSR, ar.CTRL_INDEX, 224, 256, 384, FileUtils.S_IRWXU, WXMediaMessage.TITLE_LENGTH_LIMIT, 640, 768, 896, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, Downloads.RECV_BUFFER_SIZE, 6144, 7680};

    public static Format a(byte[] bArr, String str, String str2) {
        i iVar = new i(bArr);
        iVar.cS(60);
        int i = ahi[iVar.cT(6)];
        int i2 = ahj[iVar.cT(4)];
        int cT = iVar.cT(5);
        cT = cT >= ahk.length ? -1 : (ahk[cT] * 1000) / 2;
        iVar.cS(10);
        return Format.a(str, "audio/vnd.dts", cT, -1, i + (iVar.cT(2) > 0 ? 1 : 0), i2, null, null, str2);
    }

    public static int f(byte[] bArr) {
        return ((((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2)) + 1) * 32;
    }

    public static int c(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int g(byte[] bArr) {
        return ((((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) | ((bArr[7] & 240) >> 4)) + 1;
    }
}
