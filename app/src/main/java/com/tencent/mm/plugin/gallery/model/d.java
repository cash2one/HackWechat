package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    private File mQR;
    List<RandomAccessFile> mQS;
    SparseArray<alf> mQT;
    int mQU;
    boolean mpK = true;

    d(File file) {
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            x.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[]{file.getAbsolutePath(), Boolean.valueOf(mkdirs)});
        }
        this.mQR = file;
        this.mQT = new SparseArray();
    }

    final void aNM() {
        File file = new File(this.mQR, "cache.idx");
        ale com_tencent_mm_protocal_c_ale = new ale();
        String absolutePath = file.getAbsolutePath();
        if (!bh.ov(absolutePath)) {
            try {
                com_tencent_mm_protocal_c_ale.aF(bh.readFromFile(absolutePath));
            } catch (Throwable e) {
                x.e("MicroMsg.DiskCache", "load index file error");
                x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                qk(-1);
                com_tencent_mm_protocal_c_ale = new ale();
            } catch (Throwable e2) {
                x.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[]{Long.valueOf(file.length())});
                x.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                qk(-1);
                com_tencent_mm_protocal_c_ale = new ale();
            }
        }
        this.mQT.clear();
        Iterator it = com_tencent_mm_protocal_c_ale.wss.iterator();
        while (it.hasNext()) {
            alf com_tencent_mm_protocal_c_alf = (alf) it.next();
            this.mQT.put(com_tencent_mm_protocal_c_alf.key, com_tencent_mm_protocal_c_alf);
        }
    }

    final synchronized void qj(int i) {
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (this.mQS != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mQR, qm(i)), "rw");
                        this.mQS.remove(i);
                        this.mQS.add(i, randomAccessFile);
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.DiskCache", "create data file error: %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.mQS = null;
                }
            }
            this.mQS = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.mQS.add(new RandomAccessFile(new File(this.mQR, qm(i2)), "rw"));
            }
        }
    }

    final void qk(int i) {
        int i2 = 0;
        if (this.mQS != null && this.mQS.size() > 0) {
            if (i < 0) {
                new File(this.mQR, "cache.idx").delete();
                this.mQT.clear();
            } else {
                SparseArray sparseArray = new SparseArray();
                for (int i3 = 0; i3 < this.mQT.size(); i3++) {
                    alf com_tencent_mm_protocal_c_alf = (alf) this.mQT.valueAt(i3);
                    if (com_tencent_mm_protocal_c_alf.wsu != i) {
                        sparseArray.put(this.mQT.keyAt(i3), com_tencent_mm_protocal_c_alf);
                    }
                    x.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alf.key), Long.valueOf(com_tencent_mm_protocal_c_alf.wst), Integer.valueOf(com_tencent_mm_protocal_c_alf.length)});
                }
                this.mQT = sparseArray;
                aNN();
            }
            if (i < 0) {
                aNO();
                while (i2 < 25) {
                    new File(this.mQR, qm(25)).delete();
                    i2++;
                }
                return;
            }
            f((Closeable) this.mQS.get(i));
            new File(this.mQR, qm(i)).delete();
        }
    }

    static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                x.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[]{closeable.getClass().getName(), e.getMessage()});
                x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
    }

    final void aNN() {
        ale com_tencent_mm_protocal_c_ale = new ale();
        for (int i = 0; i < this.mQT.size(); i++) {
            com_tencent_mm_protocal_c_ale.wss.add(0, (alf) this.mQT.valueAt(i));
            x.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[]{Integer.valueOf(r0.key), Long.valueOf(r0.wst), Integer.valueOf(r0.length), Integer.valueOf(r0.wsu)});
        }
        try {
            bh.q(new File(this.mQR, "cache.idx").getAbsolutePath(), com_tencent_mm_protocal_c_ale.toByteArray());
        } catch (Throwable e) {
            x.e("MicroMsg.DiskCache", "save index data error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
        }
    }

    final synchronized void aNO() {
        if (this.mQS != null && this.mQS.size() > 0) {
            for (RandomAccessFile f : this.mQS) {
                f(f);
            }
        }
    }

    public final Bitmap ql(int i) {
        if (this.mQS == null || this.mQS.size() <= 0) {
            x.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            return null;
        }
        alf com_tencent_mm_protocal_c_alf = (alf) this.mQT.get(i);
        if (com_tencent_mm_protocal_c_alf == null) {
            return null;
        }
        byte[] bArr = new byte[com_tencent_mm_protocal_c_alf.length];
        try {
            x.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_alf.wst), Integer.valueOf(com_tencent_mm_protocal_c_alf.length)});
            RandomAccessFile randomAccessFile = (RandomAccessFile) this.mQS.get(com_tencent_mm_protocal_c_alf.wsu);
            randomAccessFile.seek(com_tencent_mm_protocal_c_alf.wst);
            randomAccessFile.read(bArr, 0, com_tencent_mm_protocal_c_alf.length);
            Bitmap bl = com.tencent.mm.sdk.platformtools.d.bl(bArr);
            if (bl != null) {
                x.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[]{Integer.valueOf(bl.getWidth()), Integer.valueOf(bl.getHeight())});
                return bl;
            }
            this.mQT.remove(i);
            return bl;
        } catch (Throwable e) {
            x.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[]{Integer.valueOf(i), e.getMessage()});
            x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            this.mQT.remove(i);
            return null;
        }
    }

    private static String qm(int i) {
        return "cache.data" + (i == 0 ? "" : "." + i);
    }

    public final synchronized int aNP() {
        int i = 0;
        synchronized (this) {
            if (this.mQS != null && this.mQS.size() > 0) {
                try {
                    int i2 = -1;
                    for (RandomAccessFile length : this.mQS) {
                        i2++;
                        if (length.length() < 2097152) {
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
            }
        }
        return i;
    }

    public final void aNQ() {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.mQU).commit();
    }
}
