package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.media.encode.c.a;
import com.tencent.mm.sdk.platformtools.x;

public class b implements c {
    String jAi = "audio/mp4a-latm";
    String jAj = "audio/mpeg";
    a jAk = null;
    int jAl = 0;
    int jAm = 0;
    byte[] jAn;
    int jAo = 0;

    public final void kW(int i) {
        x.i("MicroMsg.AudioEncoder", "mMinBufferSize:%d", new Object[]{Integer.valueOf(this.jAl)});
        this.jAl = i;
    }

    public final void a(a aVar) {
        this.jAk = aVar;
    }

    public final void kX(int i) {
        x.i("MicroMsg.AudioEncoder", "setEncodeBuffFrameSize frameSize:%d", new Object[]{Integer.valueOf(i)});
        this.jAm = i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        this.jAn = new byte[(i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)];
    }

    public boolean f(String str, int i, int i2, int i3) {
        return false;
    }

    public boolean a(boolean z, byte[] bArr, int i) {
        return false;
    }

    public void flush() {
    }

    public void close() {
    }

    public final void c(byte[] bArr, int i, boolean z) {
        if (this.jAk == null) {
            x.e("MicroMsg.AudioEncoder", "mEncodeListener is null, return");
        } else if (this.jAm == 0) {
            x.e("MicroMsg.AudioEncoder", "no frameSize, return");
        } else {
            if (i > this.jAm) {
                x.w("MicroMsg.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jAm)});
            }
            x.d("MicroMsg.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[]{Integer.valueOf(this.jAo), Integer.valueOf(i)});
            int i2 = this.jAo + i;
            if (i2 >= this.jAm && bArr != null) {
                x.d("MicroMsg.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[]{Integer.valueOf(i2)});
                if (i2 > this.jAn.length) {
                    x.i("MicroMsg.AudioEncoder", "expand the end codeBuffer:%d", new Object[]{Integer.valueOf(i2)});
                    Object obj = this.jAn;
                    this.jAn = new byte[i2];
                    System.arraycopy(obj, 0, this.jAn, 0, this.jAo);
                }
                System.arraycopy(bArr, 0, this.jAn, this.jAo, i);
                this.jAk.b(this.jAn, i2, false);
                this.jAo = 0;
            } else if (bArr != null) {
                System.arraycopy(bArr, 0, this.jAn, this.jAo, i);
                this.jAo = i2;
                x.d("MicroMsg.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[]{Integer.valueOf(this.jAo)});
            }
            if (z) {
                x.i("MicroMsg.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[]{Integer.valueOf(this.jAo)});
                this.jAk.b(this.jAn, this.jAo, z);
                this.jAo = 0;
            }
        }
    }
}
