package g.a.b;

import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    g.a.a.a AyZ = new g.a.a.a();
    g.a.c.b Aza = new g.a.c.b();
    short[] Azb = new short[ar.CTRL_INDEX];
    short[] Azc = new short[12];
    short[] Azd = new short[12];
    short[] Aze = new short[12];
    short[] Azf = new short[12];
    short[] Azg = new short[ar.CTRL_INDEX];
    g.a.c.a[] Azh = new g.a.c.a[4];
    short[] Azi = new short[114];
    g.a.c.a Azj = new g.a.c.a(4);
    a Azk = new a(this);
    a Azl = new a(this);
    b Azm = new b(this);
    int Azn = -1;
    int Azo = -1;
    int Azp;

    class b {
        final /* synthetic */ a Azv;
        a[] Azw;
        int Azx;
        int Azy;
        int Azz;

        b(a aVar) {
            this.Azv = aVar;
        }
    }

    public a() {
        for (int i = 0; i < 4; i++) {
            this.Azh[i] = new g.a.c.a(6);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) {
        int i;
        this.Aza.AzF = inputStream;
        g.a.a.a aVar = this.AyZ;
        aVar.cKr();
        aVar.AyY = outputStream;
        aVar = this.AyZ;
        aVar.AyX = 0;
        aVar.AvW = 0;
        g.a.c.b.b(this.Azb);
        g.a.c.b.b(this.Azg);
        g.a.c.b.b(this.Azc);
        g.a.c.b.b(this.Azd);
        g.a.c.b.b(this.Aze);
        g.a.c.b.b(this.Azf);
        g.a.c.b.b(this.Azi);
        b bVar = this.Azm;
        int i2 = 1 << (bVar.Azx + bVar.Azy);
        for (i = 0; i < i2; i++) {
            g.a.c.b.b(bVar.Azw[i].AzA);
        }
        for (i = 0; i < 4; i++) {
            g.a.c.b.b(this.Azh[i].AzC);
        }
        this.Azk.cKt();
        this.Azl.cKt();
        g.a.c.b.b(this.Azj.AzC);
        g.a.c.b bVar2 = this.Aza;
        bVar2.wPs = 0;
        bVar2.AzE = -1;
        for (i = 0; i < 5; i++) {
            bVar2.wPs = (bVar2.wPs << 8) | bVar2.AzF.read();
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        long j2 = 0;
        i = 0;
        i2 = 0;
        int i6 = 0;
        while (true) {
            if (j >= 0 && j2 >= j) {
                break;
            }
            int Jo;
            int i7 = this.Azp & ((int) j2);
            int i8;
            int i9;
            if (this.Aza.d(this.Azb, (i6 << 4) + i7) == 0) {
                bVar = this.Azm;
                a aVar2 = bVar.Azw[((i & 255) >>> (8 - bVar.Azx)) + ((((int) j2) & bVar.Azz) << bVar.Azx)];
                if ((i6 < 7 ? 1 : null) == null) {
                    g.a.c.b bVar3 = this.Aza;
                    Jo = this.AyZ.Jo(i3);
                    i = 1;
                    do {
                        i8 = (Jo >> 7) & 1;
                        Jo = (byte) (Jo << 1);
                        int d = bVar3.d(aVar2.AzA, ((i8 + 1) << 8) + i);
                        i = (i << 1) | d;
                        if (i8 != d) {
                            while (i < 256) {
                                i = bVar3.d(aVar2.AzA, i) | (i << 1);
                            }
                        }
                        i = (byte) i;
                    } while (i < 256);
                    i = (byte) i;
                } else {
                    bVar2 = this.Aza;
                    i = 1;
                    do {
                        i = bVar2.d(aVar2.AzA, i) | (i << 1);
                    } while (i < 256);
                    i = (byte) i;
                }
                g.a.a.a aVar3 = this.AyZ;
                byte[] bArr = aVar3.AyV;
                i9 = aVar3.AvW;
                aVar3.AvW = i9 + 1;
                bArr[i9] = i;
                if (aVar3.AvW >= aVar3.AyW) {
                    aVar3.cKs();
                }
                Jo = i6 < 4 ? 0 : i6 < 10 ? i6 - 3 : i6 - 6;
                j2 = 1 + j2;
                i6 = Jo;
            } else {
                int i10;
                if (this.Aza.d(this.Azc, i6) == 1) {
                    int i11;
                    if (this.Aza.d(this.Azd, i6) != 0) {
                        if (this.Aza.d(this.Aze, i6) == 0) {
                            i = i4;
                        } else {
                            if (this.Aza.d(this.Azf, i6) == 0) {
                                i = i2;
                            } else {
                                i = i5;
                                i5 = i2;
                            }
                            i2 = i4;
                        }
                        i4 = i2;
                        i2 = i5;
                        i5 = 0;
                        Jo = i3;
                        i11 = i;
                        i = i6;
                        i6 = i11;
                    } else if (this.Aza.d(this.Azg, (i6 << 4) + i7) == 0) {
                        i = i6 < 7 ? 9 : 11;
                        i6 = i3;
                        i11 = i5;
                        i5 = 1;
                        Jo = i4;
                        i4 = i2;
                        i2 = i11;
                    } else {
                        i = i6;
                        i6 = i3;
                        i11 = i2;
                        i2 = i5;
                        i5 = 0;
                        Jo = i4;
                        i4 = i11;
                    }
                    if (i5 == 0) {
                        i5 = this.Azl.a(this.Aza, i7) + 2;
                        if (i < 7) {
                            i = 8;
                        } else {
                            i = 11;
                        }
                        i7 = Jo;
                        i3 = i6;
                        i9 = i;
                        i6 = i4;
                        i4 = i2;
                    } else {
                        i7 = Jo;
                        i3 = i6;
                        i9 = i;
                        i6 = i4;
                        i4 = i2;
                    }
                } else {
                    i7 = this.Azk.a(this.Aza, i7) + 2;
                    i = i6 < 7 ? 7 : 10;
                    g.a.c.a[] aVarArr = this.Azh;
                    Jo = i7 - 2;
                    if (Jo >= 4) {
                        Jo = 3;
                    }
                    Jo = aVarArr[Jo].a(this.Aza);
                    if (Jo >= 4) {
                        i9 = (Jo >> 1) - 1;
                        i8 = ((Jo & 1) | 2) << i9;
                        if (Jo < 14) {
                            short[] sArr = this.Azi;
                            i10 = (i8 - Jo) - 1;
                            g.a.c.b bVar4 = this.Aza;
                            i5 = 1;
                            Jo = 0;
                            for (i6 = 0; i6 < i9; i6++) {
                                int d2 = bVar4.d(sArr, i10 + i5);
                                i5 = (i5 << 1) + d2;
                                Jo |= d2 << i6;
                            }
                            i5 = i7;
                            i6 = i4;
                            i9 = i;
                            i7 = i3;
                            i4 = i2;
                            i3 = Jo + i8;
                        } else {
                            g.a.c.b bVar5 = this.Aza;
                            i5 = 0;
                            for (Jo = i9 - 4; Jo != 0; Jo--) {
                                bVar5.AzE >>>= 1;
                                i9 = (bVar5.wPs - bVar5.AzE) >>> 31;
                                bVar5.wPs -= bVar5.AzE & (i9 - 1);
                                i5 = (i5 << 1) | (1 - i9);
                                if ((bVar5.AzE & WebView.NIGHT_MODE_COLOR) == 0) {
                                    bVar5.wPs = (bVar5.wPs << 8) | bVar5.AzF.read();
                                    bVar5.AzE <<= 8;
                                }
                            }
                            i9 = i8 + (i5 << 4);
                            g.a.c.a aVar4 = this.Azj;
                            g.a.c.b bVar6 = this.Aza;
                            i6 = 1;
                            i5 = 0;
                            for (Jo = 0; Jo < aVar4.AzD; Jo++) {
                                i10 = bVar6.d(aVar4.AzC, i6);
                                i6 = (i6 << 1) + i10;
                                i5 |= i10 << Jo;
                            }
                            Jo = i9 + i5;
                            if (Jo < 0) {
                                break;
                            }
                            i5 = i7;
                            i6 = i4;
                            i9 = i;
                            i7 = i3;
                            i4 = i2;
                            i3 = Jo;
                        }
                    } else {
                        i5 = i7;
                        i6 = i4;
                        i9 = i;
                        i7 = i3;
                        i4 = i2;
                        i3 = Jo;
                    }
                }
                if (((long) i3) < j2 && i3 < this.Azo) {
                    g.a.a.a aVar5 = this.AyZ;
                    i = (aVar5.AvW - i3) - 1;
                    if (i < 0) {
                        i += aVar5.AyW;
                        i2 = i5;
                    } else {
                        i2 = i5;
                    }
                    while (i2 != 0) {
                        if (i >= aVar5.AyW) {
                            i = 0;
                        }
                        byte[] bArr2 = aVar5.AyV;
                        i10 = aVar5.AvW;
                        aVar5.AvW = i10 + 1;
                        Jo = i + 1;
                        bArr2[i10] = aVar5.AyV[i];
                        if (aVar5.AvW >= aVar5.AyW) {
                            aVar5.cKs();
                        }
                        i2--;
                        i = Jo;
                    }
                    j2 = ((long) i5) + j2;
                    i5 = i4;
                    i = this.AyZ.Jo(0);
                    i4 = i7;
                    i2 = i6;
                    i6 = i9;
                }
            }
        }
        if (Jo != -1) {
            return false;
        }
        this.AyZ.cKs();
        this.AyZ.cKr();
        this.Aza.AzF = null;
        return true;
    }

    public final boolean ci(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = i % 9;
        i /= 9;
        int i3 = i % 5;
        int i4 = i / 5;
        int i5 = 0;
        for (i = 0; i < 4; i++) {
            i5 += (bArr[i + 1] & 255) << (i * 8);
        }
        if (i2 > 8 || i3 > 4 || i4 > 4) {
            i = false;
        } else {
            b bVar = this.Azm;
            if (!(bVar.Azw != null && bVar.Azx == i2 && bVar.Azy == i3)) {
                bVar.Azy = i3;
                bVar.Azz = (1 << i3) - 1;
                bVar.Azx = i2;
                i2 = 1 << (bVar.Azx + bVar.Azy);
                bVar.Azw = new a[i2];
                for (i = 0; i < i2; i++) {
                    bVar.Azw[i] = new a(bVar);
                }
            }
            i = 1 << i4;
            this.Azk.Jp(i);
            this.Azl.Jp(i);
            this.Azp = i - 1;
            i = 1;
        }
        if (i == 0 || i5 < 0) {
            return false;
        }
        if (this.Azn != i5) {
            this.Azn = i5;
            this.Azo = Math.max(this.Azn, 1);
            g.a.a.a aVar = this.AyZ;
            i5 = Math.max(this.Azo, Downloads.RECV_BUFFER_SIZE);
            if (aVar.AyV == null || aVar.AyW != i5) {
                aVar.AyV = new byte[i5];
            }
            aVar.AyW = i5;
            aVar.AvW = 0;
            aVar.AyX = 0;
        }
        return true;
    }
}
