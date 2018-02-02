package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public final class h extends a {
    private int[] amu;
    long duration;
    long ieW;
    long[] ieZ;
    List<g> ifb = new LinkedList();
    List<Pair> ifc = new LinkedList();
    long ifg;
    private long ifh;
    private long ifi;
    private long ifj;
    private long ifk;
    private int[] ifl;
    private int[] ifm;
    private int[] ifn;
    private long[] ifo;
    private int[] ifp;
    private int[] ifq;

    public h(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final void c(RandomAccessFile randomAccessFile) {
        byte[] bArr = new byte[8];
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        int read = randomAccessFile.read(bArr);
        while (read >= 8) {
            Object obj6;
            Object obj7;
            Object obj8;
            int y = c.y(bArr, 0);
            int y2 = c.y(bArr, 4);
            long j = 0;
            int i;
            int i2;
            int i3;
            Object obj9;
            if (y2 == a.akz) {
                this.ifg = randomAccessFile.getFilePointer();
                if (c.a(randomAccessFile, 4)) {
                    byte[] bArr2 = new byte[8];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        x.w("MicroMsg.StblAtom", "stts read entry count error");
                        j = -1;
                    } else {
                        int y3 = c.y(bArr2, 0);
                        long j2 = ((long) y3) * 8;
                        if (j2 > ((long) (y - 16)) || j2 <= 0) {
                            x.w("MicroMsg.StblAtom", "stts error entryCount : " + y3);
                            j = -1;
                        } else {
                            int i4 = 0;
                            i = 0;
                            this.ieZ = new long[(((int) (this.duration / this.ieW)) + 2)];
                            i2 = 1;
                            this.ieZ[0] = 1;
                            j = 0;
                            y2 = randomAccessFile.read(bArr2);
                            while (y2 >= 8) {
                                long j3 = ((long) y2) + j;
                                int y4 = c.y(bArr2, 0);
                                int y5 = c.y(bArr2, 4);
                                int i5 = i4;
                                int i6 = i2;
                                i2 = i;
                                i = 0;
                                y3 = i6;
                                while (i < y4) {
                                    g gVar = new g();
                                    gVar.ife = (long) y5;
                                    this.ifb.add(gVar);
                                    i5 += y5;
                                    i4 = i2 + 1;
                                    while (((long) i5) >= this.ieW && y3 < this.ieZ.length) {
                                        i5 = (int) (((long) i5) - this.ieW);
                                        this.ieZ[y3] = (long) i4;
                                        y3++;
                                    }
                                    i++;
                                    i2 = i4;
                                }
                                if (j3 >= j2) {
                                    x.d("MicroMsg.StblAtom", "read stts Atom end");
                                    long j4 = j3;
                                    y2 = y3;
                                    i3 = i2;
                                    j = j4;
                                    break;
                                }
                                i4 = i5;
                                i = i2;
                                i2 = y3;
                                j = j3;
                                y2 = randomAccessFile.read(bArr2);
                            }
                            y2 = i2;
                            i3 = i;
                            if (y2 < this.ieZ.length) {
                                this.ieZ[y2] = (long) i3;
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj = obj4;
                obj6 = obj3;
                obj7 = obj2;
                obj9 = obj5;
                obj5 = 1;
                obj8 = obj9;
            } else if (y2 == a.akC) {
                j = a(randomAccessFile, y);
                i2 = 1;
                obj7 = obj2;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (y2 == a.akF) {
                j = b(randomAccessFile, y);
                obj6 = obj3;
                i = 1;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (y2 == a.akG) {
                j = c(randomAccessFile, y);
                obj6 = obj3;
                i = 1;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (y2 == a.akD) {
                j = d(randomAccessFile, y);
                obj6 = obj3;
                obj7 = obj2;
                obj9 = obj5;
                obj5 = obj;
                i3 = 1;
                obj8 = obj9;
            } else if (y2 == a.akA) {
                j = e(randomAccessFile, y);
                obj8 = 1;
                obj6 = obj3;
                obj7 = obj2;
                obj5 = obj;
                obj = obj4;
            } else {
                obj8 = obj5;
                obj6 = obj3;
                obj7 = obj2;
                obj5 = obj;
                obj = obj4;
            }
            if (c.a(randomAccessFile, (((long) y) - j) - ((long) read))) {
                if (obj5 != null && obj7 != null && obj6 != null && obj != null && obj8 != null) {
                    x.i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                obj4 = obj;
                obj3 = obj6;
                obj2 = obj7;
                read = randomAccessFile.read(bArr);
                obj = obj5;
                obj5 = obj8;
            } else {
                throw new IOException("skip file error.");
            }
        }
        Wx();
    }

    private long a(RandomAccessFile randomAccessFile, int i) {
        this.ifh = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[12];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsc read entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = 12 * ((long) y);
        if (j > ((long) (i - 16)) || j <= 0) {
            x.w("MicroMsg.StblAtom", "stsc error entryCount : " + y);
            return -1;
        }
        x.d("MicroMsg.StblAtom", "handle stsc entryCount : " + y);
        this.ifl = new int[y];
        this.ifm = new int[y];
        int i2 = 0;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 12) {
            j2 += (long) read;
            this.ifl[i2] = c.y(bArr, 0);
            this.ifm[i2] = c.y(bArr, 4);
            i2++;
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stsc atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
        }
        return j2 + 8;
    }

    private long b(RandomAccessFile randomAccessFile, int i) {
        this.ifi = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stco read entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = 4 * ((long) y);
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stco error entryCount : " + y);
            return -1;
        }
        this.ifn = new int[(y + 1)];
        int i2 = 1;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.ifn[i2] = c.y(bArr, 0);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private long c(RandomAccessFile randomAccessFile, int i) {
        this.ifj = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "co64 read entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = ((long) y) * 8;
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stco error entryCount : " + y);
            return -1;
        }
        this.ifo = new long[(y + 1)];
        int read = randomAccessFile.read(bArr);
        int i2 = 1;
        long j2 = 0;
        while (read >= 8) {
            j2 += (long) read;
            y = i2 + 1;
            this.ifo[i2] = c.P(bArr);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = y;
        }
        return j2 + 8;
    }

    private long d(RandomAccessFile randomAccessFile, int i) {
        this.ifk = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsz read sample size error");
            return -1;
        }
        int y = c.y(bArr, 0);
        if (y > 0) {
            this.amu = new int[1];
            this.amu[0] = y;
            x.i("MicroMsg.StblAtom", "all sample size is the same. size : " + y);
            return 8;
        } else if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsz read entry count error");
            return -1;
        } else {
            y = c.y(bArr, 0);
            long j = 4 * ((long) y);
            if (j <= 0 || j > ((long) (i - 20))) {
                x.w("MicroMsg.StblAtom", "stco error entryCount : " + y);
                return -1;
            }
            this.amu = new int[(y + 1)];
            int i2 = 1;
            int read = randomAccessFile.read(bArr);
            long j2 = 0;
            while (read >= 4) {
                j2 += (long) read;
                int i3 = i2 + 1;
                this.amu[i2] = c.y(bArr, 0);
                if (j2 >= j) {
                    x.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                read = randomAccessFile.read(bArr);
                i2 = i3;
            }
            return j2 + 12;
        }
    }

    private long e(RandomAccessFile randomAccessFile, int i) {
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stss rread entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = 4 * ((long) y);
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stss error entryCount : " + y);
            return -1;
        }
        this.ifp = new int[y];
        int i2 = 0;
        int read = randomAccessFile.read(bArr);
        long j2 = 0;
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.ifp[i2] = c.y(bArr, 0);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stss atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private boolean Wx() {
        int i;
        int i2;
        int i3;
        long j = 0;
        int length = (this.ifn != null ? this.ifn.length : this.ifo.length) - 1;
        int length2 = this.ifl.length;
        for (i = 1; i < length2; i++) {
            this.ifl[i - 1] = this.ifl[i] - this.ifl[i - 1];
        }
        this.ifl[length2 - 1] = (length - this.ifl[length2 - 1]) + 1;
        this.ifq = new int[(length + 1)];
        this.ifq[0] = 0;
        i = 1;
        for (i2 = 0; i2 < length2; i2++) {
            int i4 = this.ifl[i2];
            i3 = this.ifm[i2];
            for (length = 0; length < i4; length++) {
                this.ifq[i] = this.ifq[i - 1] + i3;
                i++;
            }
        }
        for (i2 = 0; i2 < this.ieZ.length; i2++) {
            long j2;
            i4 = (int) this.ieZ[i2];
            i3 = iY(i4);
            i = this.ifq[i3 - 1] + 1;
            if (this.amu.length == 1) {
                j2 = ((long) (i4 - i)) * ((long) this.amu[0]);
            } else {
                j2 = 0;
                for (length2 = i; length2 <= i4; length2++) {
                    j2 += (long) this.amu[length2];
                }
            }
            this.ieZ[i2] = j2 + iZ(i3);
        }
        long j3 = 0;
        length = 0;
        i3 = 1;
        for (g gVar : this.ifb) {
            g gVar2;
            gVar2.size = this.amu[i3];
            i2 = iY(i3);
            if (i2 != length) {
                gVar2.start = iZ(i2);
            } else {
                gVar2.start = j3;
            }
            j3 = gVar2.start + ((long) gVar2.size);
            j += gVar2.ife;
            gVar2.ife = (long) ((((((float) j) * 1.0f) / ((float) this.ieW)) * 1000.0f) * 1000.0f);
            gVar2.id = i3;
            length = i2;
            i3++;
        }
        for (length = 0; length < this.ifp.length; length++) {
            gVar2 = (g) this.ifb.get(this.ifp[length] - 1);
            gVar2.iff = 1;
            x.d("MicroMsg.StblAtom", "stss key frame [%s %s]", new Object[]{r2.first, new Pair(Integer.valueOf(this.ifp[length] - 1), Long.valueOf(gVar2.ife)).second});
            this.ifc.add(r2);
        }
        return true;
    }

    private int iY(int i) {
        for (int i2 = 0; i2 < this.ifq.length; i2++) {
            if (i <= this.ifq[i2]) {
                return i2;
            }
        }
        return 0;
    }

    private long iZ(int i) {
        if (this.ifn != null) {
            return (long) this.ifn[i];
        }
        if (this.ifo != null) {
            return this.ifo[i];
        }
        return 0;
    }
}
