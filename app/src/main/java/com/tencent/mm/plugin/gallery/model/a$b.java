package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.RandomAccessFile;

class a$b implements a {
    private Bitmap bitmap;
    private int ftE;
    String mFilePath;
    final /* synthetic */ a mQu;
    private String mQx;
    private long mQy;
    private int mQz;

    public a$b(a aVar, String str, int i, String str2, long j) {
        this(aVar, str, i, str2, j, (byte) 0);
    }

    private a$b(a aVar, String str, int i, String str2, long j, byte b) {
        this.mQu = aVar;
        this.mFilePath = str;
        this.mQy = j;
        this.mQx = str2;
        this.mQz = 12288;
        this.ftE = i;
    }

    public final boolean JB() {
        b a = a.a(this.mQu);
        String str = this.mFilePath;
        String str2 = this.mQx;
        long j = this.mQy;
        this.bitmap = a.mQB == null ? null : a.mQB.ql(String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)}).hashCode());
        if (this.bitmap != null) {
            x.d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", new Object[]{this.mFilePath});
            return true;
        }
        this.bitmap = j.a(this.mQy, this.ftE, this.mFilePath, this.mQx);
        if (this.bitmap == null) {
            return false;
        }
        a = a.a(this.mQu);
        str = this.mFilePath;
        str2 = this.mQx;
        j = this.mQy;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
            if (a.mQB != null) {
                d dVar = a.mQB;
                int hashCode = str.hashCode();
                if (dVar.mQS == null || dVar.mQS.size() <= 0) {
                    x.e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                } else if (bitmap == null) {
                    x.e("MicroMsg.DiskCache", "put bmp, value error: null");
                } else {
                    int i;
                    x.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[]{Integer.valueOf(hashCode), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                    if (dVar.mQS == null || dVar.mQS.size() <= 0) {
                        i = -1;
                    } else {
                        int aNP = dVar.aNP();
                        if (aNP < 0) {
                            x.d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", new Object[]{Integer.valueOf(dVar.mQU)});
                            aNP = dVar.mQU + 1 >= 25 ? 0 : dVar.mQU + 1;
                            x.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[]{Integer.valueOf(aNP)});
                            dVar.qk(aNP);
                            dVar.qj(aNP);
                        }
                        i = aNP;
                    }
                    if (i < 0) {
                        x.e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                    } else {
                        Object obj;
                        alf com_tencent_mm_protocal_c_alf = (alf) dVar.mQT.get(hashCode);
                        if (com_tencent_mm_protocal_c_alf == null) {
                            com_tencent_mm_protocal_c_alf = new alf();
                            com_tencent_mm_protocal_c_alf.key = hashCode;
                            obj = com_tencent_mm_protocal_c_alf;
                        } else {
                            alf com_tencent_mm_protocal_c_alf2 = com_tencent_mm_protocal_c_alf;
                        }
                        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                RandomAccessFile randomAccessFile = (RandomAccessFile) dVar.mQS.get(i);
                                obj.wst = randomAccessFile.length();
                                obj.wsu = i;
                                obj.length = byteArrayOutputStream.size();
                                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                randomAccessFile.seek(obj.wst);
                                randomAccessFile.write(toByteArray);
                                dVar.mQU = i;
                                x.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(obj.key), Long.valueOf(obj.wst), Integer.valueOf(obj.length), Integer.valueOf(obj.wsu)});
                                dVar.mpK = true;
                                dVar.mQT.put(hashCode, obj);
                            } catch (Exception e) {
                                obj = "write data error:%s";
                                x.e("MicroMsg.DiskCache", obj, new Object[]{e.getMessage()});
                            } finally {
                                d.f(byteArrayOutputStream);
                            }
                        } catch (Throwable e2) {
                            x.e("MicroMsg.DiskCache", "compress bmp error:%s", new Object[]{e2.getMessage()});
                            x.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                            d.f(byteArrayOutputStream);
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean JC() {
        x.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", new Object[]{this.mFilePath});
        a.b(this.mQu).bu(this.mFilePath);
        x.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", new Object[]{Integer.valueOf(a.b(this.mQu).size())});
        if (this.bitmap == null) {
            x.e("MircoMsg.CacheService", "decode file failed, %s ", new Object[]{this.mFilePath});
            return false;
        }
        b a = a.a(this.mQu);
        String str = this.mFilePath;
        Bitmap bitmap = this.bitmap;
        int i = this.mQz;
        if (a.mQA == null) {
            x.e("MicroMsg.GalleryCache", "cache is null");
        } else {
            a.mQA.l(str, new b.a(a, bitmap, i));
            a.hkZ.ca(str);
            a.hkZ.doNotify();
        }
        this.bitmap = null;
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a$b)) {
            return false;
        }
        return bh.az(this.mFilePath, "").equals(((a$b) obj).mFilePath);
    }

    public final int hashCode() {
        return bh.az(this.mFilePath, "").hashCode();
    }
}
