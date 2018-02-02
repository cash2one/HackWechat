package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.z.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class b implements d {
    private static z<String, Integer> jAa = new z(50);
    private static z<String, Integer> jAb = new z(50);
    private static z<String, Integer> jAc = new z(50);
    private long currentPosition;
    private String filePath;
    private String iEa;
    private int iFu = -1;
    private int jAd = -1;
    public RandomAccessFile randomAccessFile;

    public b(String str, String str2) {
        this.filePath = str;
        this.iEa = str2;
        this.randomAccessFile = bt(str, str2);
        if (jAa.bt(str) && jAb.bt(str)) {
            this.jAd = ((Integer) jAa.get(str)).intValue();
            this.iFu = ((Integer) jAb.get(str)).intValue();
        } else if (bh.ov(str2)) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
        } else {
            com.tencent.mm.plugin.appbrand.appcache.z zVar = new com.tencent.mm.plugin.appbrand.appcache.z(new File(str2));
            if (!zVar.iFn) {
                zVar.close();
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
            } else if (zVar.ZX()) {
                a pH = zVar.pH(str);
                if (pH == null) {
                    zVar.close();
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
                } else if (pH.iFv <= 0 || pH.iFu <= 0) {
                    zVar.close();
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
                } else {
                    this.jAd = pH.iFv;
                    this.iFu = pH.iFu;
                    jAa.put(str, Integer.valueOf(this.jAd));
                    jAb.put(str, Integer.valueOf(this.iFu));
                    zVar.close();
                }
            } else {
                zVar.close();
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
            }
        }
    }

    public final boolean isOpen() {
        return this.randomAccessFile != null || this.jAd == -1 || this.iFu == -1;
    }

    public final void open() {
        x.i("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[]{Integer.valueOf(hashCode())});
        if (this.randomAccessFile == null) {
            this.randomAccessFile = bt(this.filePath, this.iEa);
        }
        this.currentPosition = 0;
        if (this.randomAccessFile != null) {
            this.randomAccessFile.seek((long) this.iFu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RandomAccessFile bt(String str, String str2) {
        Throwable e;
        if (bh.ov(str2)) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            return null;
        }
        x.i("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", new Object[]{str, Integer.valueOf(this.jAd), Integer.valueOf(this.iFu)});
        RandomAccessFile randomAccessFile;
        try {
            if (new File(str2).exists()) {
                randomAccessFile = new RandomAccessFile(str2, "r");
                x.d("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", new Object[]{Long.valueOf(randomAccessFile.length())});
                return randomAccessFile;
            }
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", new Object[]{str2});
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", e2, "", new Object[0]);
            return null;
        } catch (Throwable e3) {
            Throwable th = e3;
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            e2 = th;
            x.printErrStackTrace("MicroMsg.WxaAudioDataSourceBelow19", e2, "", new Object[0]);
            if (randomAccessFile2 == null) {
                return null;
            }
            try {
                randomAccessFile2.close();
                return null;
            } catch (IOException e4) {
                return null;
            }
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        if (this.randomAccessFile == null) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
        } else {
            if (this.currentPosition != j) {
                this.randomAccessFile.seek(((long) this.iFu) + j);
                this.currentPosition = j;
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
            } else if (j < 0 || i < 0 || i2 <= 0) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (bArr != null && i + i2 > bArr.length) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)});
            } else if (j >= ((long) this.jAd)) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[]{Long.valueOf(j), Integer.valueOf(this.jAd)});
            } else {
                if (((long) i2) + j >= ((long) this.jAd)) {
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.jAd)});
                    i2 = (int) (((long) this.jAd) - j);
                }
                i3 = this.randomAccessFile.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.currentPosition += (long) i3;
                } else {
                    x.e("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", new Object[]{Integer.valueOf(i3)});
                }
            }
        }
        return i3;
    }

    public final long getSize() {
        if (this.randomAccessFile != null) {
            return (long) this.jAd;
        }
        x.e("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
        return 0;
    }

    public final int Jy() {
        int i = 1;
        if (this.randomAccessFile == null) {
            this.randomAccessFile = bt(this.filePath, this.iEa);
        }
        if (jAc.bt(this.filePath)) {
            return ((Integer) jAc.get(this.filePath)).intValue();
        }
        if (this.randomAccessFile == null) {
            x.e("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
            return 4;
        } else {
            String str;
            try {
                byte[] bArr = new byte[64];
                this.randomAccessFile.seek((long) this.iFu);
                this.randomAccessFile.read(bArr);
                str = new String(bArr);
            } catch (Exception e) {
                x.e("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", new Object[]{e});
                str = null;
                return str == null ? 0 : 0;
            } finally {
                i = this.randomAccessFile;
                str = (long) this.iFu;
                i.seek(str);
            }
            if (str == null && str.contains("ftyp")) {
                x.d("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
                jAc.put(this.filePath, Integer.valueOf(i));
                return i;
            }
        }
    }

    public final void close() {
        if (this.randomAccessFile != null) {
            x.i("MicroMsg.WxaAudioDataSourceBelow19", "close %d", new Object[]{Integer.valueOf(hashCode())});
            this.randomAccessFile.close();
            this.randomAccessFile = null;
        }
    }
}
