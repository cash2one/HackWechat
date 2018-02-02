package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

public final class z implements Closeable {
    public static final ByteOrder iFk = ByteOrder.BIG_ENDIAN;
    private volatile int aIt;
    public final File iFl;
    private volatile FileChannel iFm;
    public volatile boolean iFn;
    private volatile int iFo;
    private volatile int iFp;
    private volatile int iFq;
    public volatile Map<String, a> iFr;
    public volatile FileStructStat iFs;

    public z(File file) {
        int i;
        boolean z = true;
        this.iFm = null;
        this.iFn = true;
        this.aIt = -1;
        this.iFo = 0;
        this.iFp = 0;
        this.iFq = -1;
        this.iFr = null;
        this.iFl = file;
        if (this.iFl == null || !this.iFl.exists()) {
            i = 0;
        } else if (this.iFl.length() <= 14) {
            i = 0;
        } else {
            boolean z2 = true;
        }
        if (i == 0 || !ZY()) {
            z = false;
        }
        this.iFn = z;
    }

    public z(String str) {
        this(new File(str));
    }

    public final void close() {
        if (this.iFm != null) {
            try {
                this.iFm.close();
                this.iFm = null;
            } catch (IOException e) {
            }
        }
    }

    public final a pH(String str) {
        int i = 0;
        if (this.iFr == null || bh.ov(str)) {
            String str2 = "MicroMsg.AppBrandWxaPkg";
            String str3 = "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.iFr == null);
            if (this.iFr != null) {
                i = this.iFr.size();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str;
            x.e(str2, str3, objArr);
            return null;
        }
        return (a) this.iFr.get(a.py(str));
    }

    public final InputStream pI(String str) {
        a pH = pH(str);
        if (pH == null) {
            return null;
        }
        try {
            ByteBuffer map = this.iFm.map(MapMode.READ_ONLY, (long) pH.iFu, (long) pH.iFv);
            map.order(iFk);
            map.limit(pH.iFv);
            return new a(map);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[]{str, Integer.valueOf(pH.iFu), Integer.valueOf(pH.iFv), bh.i(e)});
            return null;
        }
    }

    public final boolean ZX() {
        if (!this.iFn || this.iFm == null || this.iFo <= 4) {
            x.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[]{Boolean.valueOf(this.iFn), this.iFm, Integer.valueOf(this.iFp)});
            return false;
        } else if (this.iFr != null && this.iFq >= 0 && this.iFq == this.iFr.size()) {
            return true;
        } else {
            try {
                this.iFm.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.iFo);
                allocate.order(iFk);
                this.iFm.read(allocate);
                byte[] array = allocate.array();
                this.iFq = a.A(array, 0);
                Map aVar = new android.support.v4.e.a();
                a aVar2 = null;
                int i = 4;
                for (int i2 = 0; i2 < this.iFq; i2++) {
                    int A = a.A(array, i);
                    i += 4;
                    String str = new String(array, i, A);
                    i += A;
                    int A2 = a.A(array, i);
                    i += 4;
                    int A3 = a.A(array, i);
                    i += 4;
                    aVar2 = new a(this.iFl.getAbsolutePath(), str, A2, A3);
                    aVar.put(str, aVar2);
                }
                this.iFr = aVar;
                if (aVar2 == null || ((long) (aVar2.iFu + aVar2.iFv)) <= this.iFl.length()) {
                    return true;
                }
                x.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[]{Integer.valueOf(aVar2.iFu), Integer.valueOf(aVar2.iFv), Long.valueOf(this.iFl.length())});
                return false;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[]{bh.i(e)});
                return false;
            }
        }
    }

    private boolean ZY() {
        if (this.iFm == null) {
            try {
                this.iFm = new RandomAccessFile(this.iFl, "r").getChannel();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[]{bh.i(e)});
            }
        }
        if (this.iFm == null) {
            return false;
        }
        try {
            this.iFm.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(iFk);
            this.iFm.read(allocate);
            if ((byte) -66 != allocate.get(0) || (byte) -19 != allocate.get(13)) {
                return false;
            }
            byte[] array = allocate.array();
            this.aIt = a.A(array, 1);
            this.iFo = a.A(array, 5);
            this.iFp = a.A(array, 9);
            return true;
        } catch (Throwable e2) {
            x.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[]{bh.i(e2)});
        }
    }
}
