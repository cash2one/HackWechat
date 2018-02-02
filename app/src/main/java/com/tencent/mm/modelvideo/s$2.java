package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.FileInputStream;

class s$2 implements Runnable {
    final /* synthetic */ s hVT;
    final /* synthetic */ String hVU;
    final /* synthetic */ String hVV;
    final /* synthetic */ String hVW;

    s$2(s sVar, String str, String str2, String str3) {
        this.hVT = sVar;
        this.hVU = str;
        this.hVV = str2;
        this.hVW = str3;
    }

    public final void run() {
        FileInputStream fileInputStream;
        int i;
        Throwable th;
        FileInputStream fileInputStream2;
        long bz;
        long Wp = bh.Wp();
        int bN = e.bN(this.hVU);
        int bN2 = e.bN(this.hVV);
        x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff now:%s size:%s,%s path:%s,%s", new Object[]{Long.valueOf(Wp), Integer.valueOf(bN), Integer.valueOf(bN2), this.hVU, this.hVV});
        if (bN2 != bN) {
            int i2 = (bN <= 0 ? 20 : 0) + ((bN2 <= 0 ? 10 : 0) + 106);
            g.pQN.h(12696, new Object[]{Integer.valueOf(i2), this.hVW, "", "", Integer.valueOf(bN2)});
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err File Size diff %d,%d path:%s org:%s", new Object[]{Integer.valueOf(bN), Integer.valueOf(bN2), this.hVU, this.hVV});
            return;
        }
        int i3;
        Object obj;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        try {
            fileInputStream = new FileInputStream(this.hVU);
            try {
                fileInputStream3 = new FileInputStream(this.hVV);
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
                    i3 = 0;
                    Object obj2 = null;
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read != fileInputStream3.read(bArr2)) {
                                obj2 = 1;
                            }
                            if (read == -1) {
                                break;
                            }
                            i2 = i3;
                            i3 = 0;
                            while (i3 < read) {
                                try {
                                    if (bArr[i3] != bArr2[i3]) {
                                        i2++;
                                    }
                                    i3++;
                                } catch (Throwable e) {
                                    Throwable th2 = e;
                                    fileInputStream4 = fileInputStream3;
                                    fileInputStream3 = fileInputStream;
                                    i = i2;
                                    th = th2;
                                }
                            }
                            i3 = i2;
                        } catch (Exception e2) {
                            th = e2;
                            fileInputStream2 = fileInputStream3;
                            fileInputStream3 = fileInputStream;
                            i = i3;
                            fileInputStream4 = fileInputStream2;
                        }
                    }
                    obj = obj2;
                } catch (Exception e3) {
                    th = e3;
                    fileInputStream4 = fileInputStream3;
                    fileInputStream3 = fileInputStream;
                    i = 0;
                    x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", new Object[]{bh.i(th)});
                    obj = 1;
                    fileInputStream2 = fileInputStream4;
                    i3 = i;
                    fileInputStream = fileInputStream3;
                    fileInputStream3 = fileInputStream2;
                    fileInputStream3.close();
                    fileInputStream.close();
                    if (obj == null) {
                        bz = bh.bz(Wp);
                        g.pQN.h(12696, new Object[]{Integer.valueOf(400), this.hVW, String.valueOf(i3), Long.valueOf(bz)});
                        x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bz), Integer.valueOf(i3), this.hVU, this.hVV});
                    }
                    x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(bN), Integer.valueOf(bN2), this.hVU, this.hVV});
                    g.pQN.h(12696, new Object[]{Integer.valueOf(107), this.hVW});
                    return;
                }
            } catch (Exception e4) {
                th = e4;
                fileInputStream3 = fileInputStream;
                i = 0;
                x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", new Object[]{bh.i(th)});
                obj = 1;
                fileInputStream2 = fileInputStream4;
                i3 = i;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                fileInputStream3.close();
                fileInputStream.close();
                if (obj == null) {
                    x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(bN), Integer.valueOf(bN2), this.hVU, this.hVV});
                    g.pQN.h(12696, new Object[]{Integer.valueOf(107), this.hVW});
                    return;
                }
                bz = bh.bz(Wp);
                g.pQN.h(12696, new Object[]{Integer.valueOf(400), this.hVW, String.valueOf(i3), Long.valueOf(bz)});
                x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bz), Integer.valueOf(i3), this.hVU, this.hVV});
            }
        } catch (Exception e5) {
            th = e5;
            i = 0;
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", new Object[]{bh.i(th)});
            obj = 1;
            fileInputStream2 = fileInputStream4;
            i3 = i;
            fileInputStream = fileInputStream3;
            fileInputStream3 = fileInputStream2;
            fileInputStream3.close();
            fileInputStream.close();
            if (obj == null) {
                bz = bh.bz(Wp);
                g.pQN.h(12696, new Object[]{Integer.valueOf(400), this.hVW, String.valueOf(i3), Long.valueOf(bz)});
                x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bz), Integer.valueOf(i3), this.hVU, this.hVV});
            }
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(bN), Integer.valueOf(bN2), this.hVU, this.hVV});
            g.pQN.h(12696, new Object[]{Integer.valueOf(107), this.hVW});
            return;
        }
        try {
            fileInputStream3.close();
        } catch (Exception e6) {
        }
        try {
            fileInputStream.close();
        } catch (Exception e7) {
        }
        if (obj == null) {
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(bN), Integer.valueOf(bN2), this.hVU, this.hVV});
            g.pQN.h(12696, new Object[]{Integer.valueOf(107), this.hVW});
            return;
        }
        bz = bh.bz(Wp);
        g.pQN.h(12696, new Object[]{Integer.valueOf(400), this.hVW, String.valueOf(i3), Long.valueOf(bz)});
        x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bz), Integer.valueOf(i3), this.hVU, this.hVV});
    }
}
