package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.c.b;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static int tML = 4;
    private static ByteOrder tMM = ByteOrder.BIG_ENDIAN;
    private volatile String gAT = "";
    private File iFl;
    volatile boolean iFn = false;
    private volatile int tMN;
    private volatile int tMO = 0;
    volatile bxs tMP = null;
    private volatile LinkedList<vy> tMQ = null;
    private volatile String tMR = "";

    public e(File file) {
        boolean z = false;
        this.iFl = file;
        if (ZY()) {
            z = true;
        }
        this.iFn = z;
    }

    public final m eV(String str, String str2) {
        if (bh.cA(this.tMQ) || this.tMO < tML || bh.ov(str)) {
            x.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            return null;
        }
        Iterator it = this.tMQ.iterator();
        while (it.hasNext()) {
            vy vyVar = (vy) it.next();
            if (bh.ou(vyVar.wgp).equals(str)) {
                String str3 = vyVar.wgr;
                Object obj = (bh.ov(str3) || !(str3.startsWith("video/") || str3.startsWith("audio/"))) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[]{str});
                    return null;
                } else if (((long) vyVar.ktH) <= 5242880) {
                    try {
                        x.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[]{str});
                        return new m(vyVar.wgr, str2, new b(this.iFl, ((long) this.tMO) + vyVar.wgq, (long) vyVar.ktH));
                    } catch (IOException e) {
                        x.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[]{str, Long.valueOf(vyVar.wgq), Integer.valueOf(vyVar.ktH), vyVar.wgr, e.getMessage()});
                    }
                } else {
                    x.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[]{Integer.valueOf(vyVar.ktH), Long.valueOf(5242880), str, Long.valueOf(vyVar.wgq), vyVar.wgr});
                }
            }
        }
        return null;
    }

    private boolean ZY() {
        boolean z = false;
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(this.iFl, "r").getChannel();
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e.getMessage());
        }
        if (fileChannel != null) {
            try {
                fileChannel.position(0);
                ByteBuffer allocate = ByteBuffer.allocate(tML);
                allocate.order(tMM);
                fileChannel.read(allocate);
                this.tMN = allocate.getInt(0);
                z = a(fileChannel);
            } catch (Exception e2) {
                x.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e2.getMessage());
            } finally {
                b(fileChannel);
            }
        }
        return z;
    }

    private boolean a(FileChannel fileChannel) {
        if (this.tMN <= 0) {
            return false;
        }
        try {
            fileChannel.position((long) tML);
            ByteBuffer allocate = ByteBuffer.allocate(this.tMN);
            allocate.order(tMM);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                return false;
            }
            this.tMP = new bxs();
            this.tMP.aF(array);
            this.tMQ = this.tMP.wYr;
            this.tMR = this.tMP.wYs;
            this.gAT = this.tMP.nfe;
            this.tMO = tML + this.tMN;
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e.getMessage());
            return false;
        }
    }

    private static void b(FileChannel fileChannel) {
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException e) {
            }
        }
    }
}
