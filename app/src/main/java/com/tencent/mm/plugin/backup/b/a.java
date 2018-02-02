package com.tencent.mm.plugin.backup.b;

import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.k;
import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.e.j;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.zip.CRC32;

public final class a implements com.tencent.mm.plugin.backup.f.b.a {
    public static final byte[] kiV = "GSMW".getBytes();
    private String kiW;
    private int kiX;
    public af kiY = null;
    public a kiZ;
    public int mode = 0;

    static /* synthetic */ void a(a aVar, byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[4];
        dataInputStream.read(bArr2);
        if (Arrays.equals(kiV, bArr2)) {
            int readInt = dataInputStream.readInt();
            short readShort = dataInputStream.readShort();
            short readShort2 = dataInputStream.readShort();
            int readInt2 = dataInputStream.readInt();
            String format;
            if (readInt2 > 16777216) {
                format = String.format("loopRead size too large, size:%d", new Object[]{Integer.valueOf(readInt2)});
                x.e("MicroMsg.BackupCEngine", format);
                aVar.a(true, readInt, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                return;
            }
            int readInt3 = dataInputStream.readInt();
            x.i("MicroMsg.BackupCEngine", "read buf size[%d], seq[%d], version[%d], type[%d]", new Object[]{Integer.valueOf(readInt2), Integer.valueOf(readInt), Short.valueOf(readShort), Short.valueOf(readShort2)});
            byte[] bArr3 = new byte[(readInt2 - 20)];
            if (dataInputStream.read(bArr3) == bArr3.length) {
                Object obj;
                PByteArray pByteArray = new PByteArray();
                b.mN(bh.bx(bArr3));
                byte[] bArr4 = kiV;
                int aoo = b.aoo();
                if (readShort != (short) 1) {
                    format = String.format("unpack failed, getVersion[%d]", new Object[]{Short.valueOf(readShort)});
                    x.e("MicroMsg.BackupPacker", format);
                    pByteArray.value = format.getBytes();
                    obj = -1;
                } else if (aoo != 1 || readInt3 == j.a(bArr4, readInt, readShort, readShort2, readInt2, bArr3)) {
                    if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                        bArr3 = k.a(bArr3, d.aop());
                    }
                    pByteArray.value = bArr3;
                    obj = null;
                } else {
                    new CRC32().update(bArr3);
                    String Y = j.Y(bArr3);
                    format = String.format("unpack failed, calcSum[%d], checkSum[%d], seq[%d], type[%d], size[%d], crc[%d], last 100 bytes:%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), Y});
                    x.e("MicroMsg.BackupPacker", format);
                    pByteArray.value = format.getBytes();
                    obj = -2;
                }
                if (obj != null) {
                    aVar.a(true, readInt, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
                } else if (aVar.kiZ != null) {
                    aVar.kiZ.a(readInt, readShort2, pByteArray.value);
                } else {
                    aVar.a(false, readInt, readShort2, pByteArray.value);
                }
            }
        }
    }

    public final void connect(String str, int i) {
        this.mode = 2;
        this.kiW = str;
        this.kiX = i;
        Client.gUn = new 2(this);
    }

    public final void stop() {
        x.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
        if (this.mode == 1) {
            Java2C.stop();
            b.apf();
            this.mode = 0;
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            b.apf();
            this.mode = 0;
        }
    }

    public final void i(int i, byte[] bArr) {
        long Wp = bh.Wp();
        x.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bh.bx(bArr))});
        if (this.kiY == null || !this.kiY.getLooper().getThread().isAlive()) {
            HandlerThread Wf = e.Wf("BackupCEngine_sendHandler");
            Wf.setPriority(10);
            Wf.start();
            this.kiY = new af(Wf.getLooper());
            x.w("MicroMsg.BackupCEngine", "BackupCEngine send, new writerHandler:%d", new Object[]{Long.valueOf(Wf.getId())});
        }
        this.kiY.post(new 4(this, i, bArr, Wp));
    }

    public final int j(int i, byte[] bArr) {
        int send;
        long Wp = bh.Wp();
        if (this.mode == 1) {
            send = Java2C.send(this.kiW, this.kiX, bArr);
        } else if (this.mode == 2) {
            send = Client.Java2C.send(this.kiW, this.kiX, bArr);
            b.mN(bh.bx(bArr));
        } else {
            send = 0;
        }
        x.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", new Object[]{Integer.valueOf(send), Integer.valueOf(i), Integer.valueOf(bh.bx(bArr)), Long.valueOf(bh.bz(Wp))});
        return send;
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        ag.y(new 5(this, z, i, i2, bArr));
    }
}
