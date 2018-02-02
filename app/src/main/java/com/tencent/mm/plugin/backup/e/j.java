package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class j {
    public static void a(byte[] bArr, int i, short s, PByteArray pByteArray, int i2) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write("GSMW".getBytes());
                byteArrayOutputStream.write(n.eh(i));
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 1});
                byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
                if (!(s == (short) 1 || s == (short) 2)) {
                    bArr = k.b(bArr, d.aop());
                }
                byteArrayOutputStream.write(n.eh(bArr.length + 20));
                byteArrayOutputStream.write(n.eh(0));
                byteArrayOutputStream.write(bArr);
                pByteArray.value = byteArrayOutputStream.toByteArray();
                if (i2 == 1) {
                    CRC32 crc32 = new CRC32();
                    crc32.update(pByteArray.value);
                    System.arraycopy(n.eh((int) crc32.getValue()), 0, pByteArray.value, 16, 4);
                }
                try {
                    byteArrayOutputStream.reset();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker pack err.", new Object[0]);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.reset();
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.reset();
                            byteArrayOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            byteArrayOutputStream = null;
            x.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker pack err.", new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.reset();
                byteArrayOutputStream.close();
            }
        } catch (Throwable th2) {
            e = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.reset();
                byteArrayOutputStream.close();
            }
            throw e;
        }
    }

    public static int a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(n.eh(i));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & 255), (byte) (s2 & 255)});
            byteArrayOutputStream.write(n.eh(i2));
            byteArrayOutputStream.write(n.eh(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            return (int) crc32.getValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker getCheckSum error.", new Object[i3]);
            return i3;
        }
    }

    public static String Y(byte[] bArr) {
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & 255) + " ";
            r0++;
        }
        x.e("MicroMsg.BackupPacker", "dumpErr errBuf:%s", new Object[]{str});
        return str;
    }
}
