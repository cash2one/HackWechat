package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b implements a {
    public static final byte[] kiV = "GSMW".getBytes();
    private Socket jTs = null;
    private Boolean kqr = Boolean.valueOf(false);
    private ServerSocket kqs = null;
    private af kqt = null;
    private af kqu = new af(Looper.getMainLooper());
    private DataOutputStream kqv = null;
    private int kqw = 0;
    private int kqx = 0;
    private long kqy = 0;
    private Object lock = new Object();

    static /* synthetic */ void a(b bVar, int i) {
        x.i("MicroMsg.BakOldJavaEngine", "doListen port:%d", new Object[]{Integer.valueOf(((i >> 8) & 255) | ((i & 255) << 8))});
        bVar.kqs = null;
        try {
            x.i("MicroMsg.BakOldJavaEngine", "ip:" + InetAddress.getLocalHost().getHostAddress());
            try {
                x.i("MicroMsg.BakOldJavaEngine", "before init ");
                bVar.kqs = new ServerSocket(r1);
                x.i("MicroMsg.BakOldJavaEngine", "before accept server:  " + bVar.kqs.toString());
                bVar.jTs = bVar.kqs.accept();
                bVar.jTs.setKeepAlive(true);
                x.i("MicroMsg.BakOldJavaEngine", "after accept client:  " + bVar.jTs.toString());
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(bVar.jTs.getInputStream()));
                bVar.kqv = new DataOutputStream(new BufferedOutputStream(bVar.jTs.getOutputStream()));
                bVar.kqr = Boolean.valueOf(false);
                bVar.a(true, 0, 10001, null);
                while (!bVar.kqr.booleanValue()) {
                    bVar.a(dataInputStream);
                }
            } catch (IOException e) {
                x.e("MicroMsg.BakOldJavaEngine", "doListen %s", new Object[]{e});
                bVar.aqq();
                bVar.a(true, 0, 10005, ("doListenErr " + e).getBytes());
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BakOldJavaEngine", e2, "getHostAddress", new Object[0]);
        }
    }

    static /* synthetic */ void a(b bVar, String str, int i) {
        x.i("MicroMsg.BakOldJavaEngine", "doConnect serverIp:%s, port:%d", new Object[]{str, Integer.valueOf(((i & 255) << 8) | ((i >> 8) & 255))});
        try {
            InetAddress byName = InetAddress.getByName(str);
            x.i("MicroMsg.BakOldJavaEngine", "TCP  Connecting...");
            bVar.jTs = new Socket(byName, r0);
            bVar.jTs.setKeepAlive(true);
            x.i("MicroMsg.BakOldJavaEngine", "TCP connected" + bVar.jTs.toString());
            bVar.kqv = new DataOutputStream(new BufferedOutputStream(bVar.jTs.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(bVar.jTs.getInputStream());
            bVar.kqr = Boolean.valueOf(false);
            bVar.a(true, 0, 10002, null);
            while (!bVar.kqr.booleanValue()) {
                bVar.a(dataInputStream);
            }
        } catch (IOException e) {
            x.e("MicroMsg.BakOldJavaEngine", "doConnect %s", new Object[]{e});
            bVar.aqq();
            bVar.a(true, 0, 10004, ("doConnect " + e).getBytes());
        }
    }

    public b() {
        aqr();
    }

    public final void b(int i, List<ov> list) {
        x.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[]{Integer.valueOf(i)});
        aqr();
        e.post(new 1(this, i, list), "BackupJavaEngine_connect");
    }

    public final void aqp() {
        x.i("MicroMsg.BakOldJavaEngine", "close connect");
        aqq();
        a(true, 0, 10003, null);
    }

    private void aqq() {
        this.kqw = 0;
        this.kqx = 0;
        this.kqy = 0;
        this.kqr = Boolean.valueOf(true);
        try {
            synchronized (this.lock) {
                if (this.kqv != null) {
                    this.kqv.close();
                }
            }
        } catch (Exception e) {
        }
        try {
            if (this.jTs != null) {
                this.jTs.close();
            }
        } catch (Exception e2) {
        }
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        this.kqu.post(new 2(this, z, i, i2, bArr));
    }

    public final void i(int i, byte[] bArr) {
        if (this.kqt != null) {
            Z(bArr);
        } else {
            this.kqu.postDelayed(new 3(this, i, bArr), 200);
        }
    }

    public final int j(int i, byte[] bArr) {
        return 0;
    }

    public final void Z(byte[] bArr) {
        if (this.kqr.booleanValue()) {
            x.e("MicroMsg.BakOldJavaEngine", "engine has stop");
        } else {
            this.kqt.post(new 4(this, bArr));
        }
    }

    private void aqr() {
        if (this.kqt == null || !this.kqt.getLooper().getThread().isAlive()) {
            e.b(new 5(this), "BackupJavaEngine_handler").start();
        }
    }

    private void a(DataInputStream dataInputStream) {
        int i;
        while (!this.kqr.booleanValue() && this.kqw != 4) {
            try {
                if (kiV[this.kqw] == dataInputStream.readByte()) {
                    this.kqw++;
                } else {
                    long Wo = bh.Wo();
                    if (((long) this.kqx) - (Wo - this.kqy) < 10) {
                        if (this.kqx < 0) {
                            this.kqx = 0;
                        }
                        this.kqx++;
                        this.kqy = Wo;
                        i = 0;
                    } else {
                        boolean z = true;
                    }
                    if (i == 0) {
                        String format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[]{Integer.valueOf(this.kqw + 1), Integer.valueOf(kiV[this.kqw] & 255), Integer.valueOf(r1 & 255)});
                        x.e("MicroMsg.BakOldJavaEngine", format);
                        a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                    }
                    this.kqw = 0;
                }
            } catch (Exception e) {
                x.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[]{e});
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.kqr.booleanValue()) {
                    a(true, 0, 10006, ("read_error " + e).getBytes());
                }
                aqq();
                return;
            }
        }
        this.kqw = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            format = String.format("loopRead size to large:%d", new Object[]{Integer.valueOf(readInt2)});
            x.e("MicroMsg.BakOldJavaEngine", format);
            this.kqr = Boolean.valueOf(true);
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
            return;
        }
        int readInt3 = dataInputStream.readInt();
        x.i("MicroMsg.BakOldJavaEngine", "read buf size:" + readInt2);
        byte[] bArr = new byte[(readInt2 - 20)];
        i = 0;
        while (i < bArr.length) {
            int read = dataInputStream.read(bArr, i, bArr.length - i);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            } else {
                i += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        byte[] bArr2 = kiV;
        if (readShort != (short) 1) {
            format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(readShort)});
            x.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -1;
        } else if (com.tencent.mm.plugin.backup.f.b.aoo() != 1 || readInt3 == com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a(bArr2, readInt, readShort, readShort2, readInt2, bArr)) {
            if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                bArr = k.a(bArr, d.aop());
            }
            pByteArray.value = bArr;
            i = 0;
        } else {
            new CRC32().update(bArr);
            String Y = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.Y(bArr);
            format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), Y});
            x.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -2;
        }
        x.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[]{Integer.valueOf(i)});
        if (i != 0) {
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            return;
        }
        x.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt), Short.valueOf(readShort2)});
        a(false, readInt, readShort2, pByteArray.value);
    }
}
