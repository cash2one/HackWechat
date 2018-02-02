package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.mm.plugin.appbrand.media.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;

public final class d extends b {
    private int hOV = 2;
    private byte[] jAp;
    private FileOutputStream mFileOutputStream;
    private String mFilePath = "";

    public final boolean f(String str, int i, int i2, int i3) {
        boolean z = true;
        x.i("MicroMsg.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mFilePath = str;
        this.hOV = i2;
        x.i("MicroMsg.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[]{Integer.valueOf(Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5))});
        if (Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5) == -1) {
            j.kV(17);
            return false;
        }
        x.i("MicroMsg.MP3AudioEncoder", "lame MPEG version:%d", new Object[]{Integer.valueOf(Mp3EncodeJni.getVersion())});
        try {
            this.mFileOutputStream = new FileOutputStream(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "init", new Object[0]);
            j.kV(18);
            z = false;
        }
        return z;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        if (this.jAl <= 0) {
            x.e("MicroMsg.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[]{Integer.valueOf(this.jAl)});
            return false;
        } else if (this.mFileOutputStream == null) {
            x.e("MicroMsg.MP3AudioEncoder", "mFileOutputStream is null");
            return false;
        } else {
            int i2;
            if (this.jAp == null) {
                x.i("MicroMsg.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[]{Integer.valueOf(this.hOV), Integer.valueOf(this.jAl), Integer.valueOf((int) (7200.0d + (((double) (this.jAl * this.hOV)) * 1.25d)))});
                this.jAp = new byte[i2];
            }
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < sArr.length; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
            }
            i2 = Mp3EncodeJni.encode(sArr, sArr, i / 2, this.jAp);
            x.d("MicroMsg.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(sArr.length), Integer.valueOf(i2)});
            if (i2 > 0) {
                x.d("MicroMsg.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                try {
                    this.mFileOutputStream.write(this.jAp, 0, i2);
                    c(this.jAp, i2, false);
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "encode write", new Object[0]);
                    j.kV(20);
                    return false;
                }
            }
            x.e("MicroMsg.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[]{Integer.valueOf(i2)});
            return false;
        }
    }

    public final void flush() {
        x.i("MicroMsg.MP3AudioEncoder", "flush");
        if (this.mFileOutputStream == null || this.jAp == null) {
            x.e("MicroMsg.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
            return;
        }
        int flush = Mp3EncodeJni.flush(this.jAp);
        if (flush > 0) {
            try {
                this.mFileOutputStream.write(this.jAp, 0, flush);
                c(this.jAp, flush, true);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "flush write", new Object[0]);
                j.kV(20);
                return;
            }
        }
        x.e("MicroMsg.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[]{Integer.valueOf(flush)});
    }

    public final void close() {
        x.i("MicroMsg.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "close", new Object[0]);
                j.kV(20);
            }
            this.mFileOutputStream = null;
        }
    }
}
