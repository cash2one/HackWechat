package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;

public final class a implements d {
    private long currentPosition;
    private String filePath;
    private String iEa;
    public com.tencent.mm.plugin.appbrand.k.a jzZ = null;

    public a(String str, String str2) {
        this.filePath = str;
        this.iEa = str2;
        this.jzZ = bs(str, str2);
    }

    public final boolean isOpen() {
        return this.jzZ != null;
    }

    public final void open() {
        x.i("MicroMsg.WxaAudioDataSource", "open");
        if (this.jzZ == null) {
            this.jzZ = bs(this.filePath, this.iEa);
        }
        this.currentPosition = 0;
        if (this.jzZ != null) {
            this.jzZ.seek(0);
        }
    }

    private static com.tencent.mm.plugin.appbrand.k.a bs(String str, String str2) {
        long nanoTime = System.nanoTime();
        if (bh.ov(str2)) {
            x.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
            return null;
        }
        z zVar = new z(new File(str2));
        if (!zVar.iFn) {
            zVar.close();
            x.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
            return null;
        } else if (zVar.ZX()) {
            InputStream pI = zVar.pI(str);
            if (pI == null) {
                zVar.close();
                x.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", new Object[]{str});
                return null;
            }
            zVar.close();
            x.d("MicroMsg.WxaAudioDataSource", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
            return (com.tencent.mm.plugin.appbrand.k.a) pI;
        } else {
            zVar.close();
            x.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
            return null;
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        if (this.jzZ == null) {
            x.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
        } else if (j < 0 || i < 0 || i2 <= 0) {
            x.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bArr == null || i + i2 <= bArr.length) {
            if (((long) i2) + j > getSize()) {
                x.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(getSize())});
            }
            if (this.currentPosition != j) {
                this.jzZ.seek((int) j);
                this.currentPosition = j;
            }
            i3 = this.jzZ.read(bArr, i, i2);
            if (i3 >= 0) {
                this.currentPosition += (long) i3;
            }
        } else {
            x.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)});
        }
        return i3;
    }

    public final long getSize() {
        if (this.jzZ != null) {
            return (long) this.jzZ.jGP.limit();
        }
        x.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
        return 0;
    }

    public final int Jy() {
        String str;
        if (this.jzZ == null) {
            this.jzZ = bs(this.filePath, this.iEa);
        }
        if (this.jzZ == null) {
            x.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
            return 4;
        } else {
            try {
                byte[] bArr = new byte[64];
                this.jzZ.seek(0);
                this.jzZ.read(bArr);
                str = new String(bArr);
            } catch (Exception e) {
                x.e("MicroMsg.WxaAudioDataSource", "getAudioType", new Object[]{e});
                str = null;
                return str == null ? 0 : 0;
            } finally {
                str = this.jzZ;
                str.seek(0);
            }
            if (str == null && str.contains("ftyp")) {
                x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
                return 1;
            }
        }
    }

    public final void close() {
        if (this.jzZ != null) {
            x.i("MicroMsg.WxaAudioDataSource", "close");
            this.jzZ.close();
            this.jzZ = null;
        }
    }
}
