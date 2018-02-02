package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;

public final class e extends a {
    public static final int ieT = c.ak("vide");
    public static final int ieU = c.ak("soun");
    public static final int ieV = c.ak("hint");
    long duration = 0;
    long ieW = 0;
    long ieX = 0;
    long ieY = 0;

    public e(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final boolean a(RandomAccessFile randomAccessFile, byte[] bArr) {
        Object obj;
        Object obj2 = null;
        Object obj3 = null;
        int read = randomAccessFile.read(bArr);
        Object obj4 = null;
        while (read >= 8) {
            long j;
            int y = c.y(bArr, 0);
            int y2 = c.y(bArr, 4);
            int i;
            if (y2 == a.ake) {
                byte[] bArr2 = new byte[4];
                y2 = randomAccessFile.read(bArr2);
                if (y2 < 4) {
                    y2 = -1;
                } else {
                    y2 += 0;
                    if (bArr2[0] == (byte) 0) {
                        if (c.a(randomAccessFile, 8)) {
                            i = y2 + 8;
                            y2 = randomAccessFile.read(bArr);
                            if (y2 < 8) {
                                y2 = -1;
                            } else {
                                i += y2;
                                this.ieW = c.z(bArr, 0);
                                this.duration = c.z(bArr, 4);
                            }
                        } else {
                            y2 = -1;
                        }
                    } else if (c.a(randomAccessFile, 16)) {
                        y2 += 16;
                        int read2 = randomAccessFile.read(bArr2);
                        if (read2 < 4) {
                            y2 = -1;
                        } else {
                            y2 += read2;
                            this.ieW = c.z(bArr2, 0);
                            i = randomAccessFile.read(bArr);
                            if (i < 8) {
                                y2 = -1;
                            } else {
                                i += y2;
                                this.duration = c.P(bArr);
                            }
                        }
                    } else {
                        y2 = -1;
                    }
                    y2 = i;
                }
                if (y2 <= 0) {
                    x.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    return false;
                }
                j = (long) ((y - read) - y2);
                obj = obj3;
                obj3 = obj2;
                obj2 = 1;
                obj4 = obj;
            } else if (y2 == a.akf) {
                int read3;
                if (c.a(randomAccessFile, 8)) {
                    read3 = randomAccessFile.read(bArr, 0, 4);
                    if (read3 < 4) {
                        read3 = -1;
                    } else {
                        this.ieX = (long) c.y(bArr, 0);
                        read3 += 8;
                    }
                } else {
                    read3 = -1;
                }
                if (read3 <= 0) {
                    x.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    return false;
                }
                long j2 = (long) ((y - read) - read3);
                obj2 = obj4;
                obj4 = obj3;
                int i2 = 1;
                j = j2;
            } else if (y2 == a.ajS) {
                this.ieY = randomAccessFile.getFilePointer() - ((long) read);
                j = (long) (y - read);
                obj3 = obj2;
                obj2 = obj4;
                i = 1;
            } else {
                j = (long) (y - 8);
                obj = obj3;
                obj3 = obj2;
                obj2 = obj4;
                obj4 = obj;
            }
            if (obj2 != null && obj3 != null && obj4 != null) {
                break;
            } else if (!c.a(randomAccessFile, j)) {
                return false;
            } else {
                read = randomAccessFile.read(bArr);
                obj = obj4;
                obj4 = obj2;
                obj2 = obj3;
                obj3 = obj;
            }
        }
        obj = obj3;
        obj3 = obj2;
        obj2 = obj4;
        obj4 = obj;
        return (obj2 == null || obj3 == null || obj4 == null) ? false : true;
    }
}
