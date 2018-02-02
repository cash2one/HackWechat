package com.google.android.exoplayer2.c.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import java.util.Collections;

public final class i implements h {
    private static final double[] ank = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private k alW;
    private String amW;
    private boolean ana;
    private long anj;
    private long anl;
    private final boolean[] anm = new boolean[4];
    private final a ann = new a();
    private long ano;
    private boolean anp;
    private long anq;
    private long anr;
    private boolean ans;
    private boolean ant;

    private static final class a {
        static final byte[] anu = new byte[]{(byte) 0, (byte) 0, (byte) 1};
        boolean anv;
        public int anw;
        public byte[] data = new byte[FileUtils.S_IWUSR];
        public int length;

        public final void d(byte[] bArr, int i, int i2) {
            if (this.anv) {
                int i3 = i2 - i;
                if (this.data.length < this.length + i3) {
                    this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length = i3 + this.length;
            }
        }
    }

    public final void jx() {
        h.a(this.anm);
        a aVar = this.ann;
        aVar.anv = false;
        aVar.length = 0;
        aVar.anw = 0;
        this.ano = 0;
        this.anp = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.jF();
        this.amW = dVar.jH();
        this.alW = fVar.ck(dVar.jG());
    }

    public final void c(long j, boolean z) {
        this.anq = j;
    }

    public final void b(j jVar) {
        int i = jVar.position;
        int i2 = jVar.asN;
        byte[] bArr = jVar.data;
        this.ano += (long) jVar.lF();
        this.alW.a(jVar, jVar.lF());
        while (true) {
            int a = h.a(bArr, i, i2, this.anm);
            if (a != i2) {
                long j;
                int i3 = jVar.data[a + 3] & 255;
                if (!this.ana) {
                    Object obj;
                    a aVar;
                    String str;
                    Object copyOf;
                    int i4;
                    int i5;
                    float f;
                    Format a2;
                    double d;
                    int i6;
                    Pair create;
                    int i7 = a - i;
                    if (i7 > 0) {
                        this.ann.d(bArr, i, a);
                    }
                    i = i7 < 0 ? -i7 : 0;
                    a aVar2 = this.ann;
                    if (aVar2.anv) {
                        aVar2.length -= i;
                        if (aVar2.anw == 0 && i3 == 181) {
                            aVar2.anw = aVar2.length;
                        } else {
                            aVar2.anv = false;
                            obj = 1;
                            if (obj != null) {
                                aVar = this.ann;
                                str = this.amW;
                                copyOf = Arrays.copyOf(aVar.data, aVar.length);
                                i4 = copyOf[5] & 255;
                                i5 = (i4 >> 4) | ((copyOf[4] & 255) << 4);
                                i4 = ((i4 & 15) << 8) | (copyOf[6] & 255);
                                f = 1.0f;
                                switch ((copyOf[7] & 240) >> 4) {
                                    case 2:
                                        f = ((float) (i4 * 4)) / ((float) (i5 * 3));
                                        break;
                                    case 3:
                                        f = ((float) (i4 * 16)) / ((float) (i5 * 9));
                                        break;
                                    case 4:
                                        f = ((float) (i4 * 121)) / ((float) (i5 * 100));
                                        break;
                                }
                                a2 = Format.a(str, "video/mpeg2", i5, i4, Collections.singletonList(copyOf), f);
                                j = 0;
                                i4 = (copyOf[7] & 15) - 1;
                                if (i4 >= 0 && i4 < ank.length) {
                                    d = ank[i4];
                                    i4 = aVar.anw;
                                    i6 = (copyOf[i4 + 9] & 96) >> 5;
                                    i4 = copyOf[i4 + 9] & 31;
                                    if (i6 != i4) {
                                        d *= (((double) i6) + 1.0d) / ((double) (i4 + 1));
                                    }
                                    j = (long) (1000000.0d / d);
                                }
                                create = Pair.create(a2, Long.valueOf(j));
                                this.alW.f((Format) create.first);
                                this.anl = ((Long) create.second).longValue();
                                this.ana = true;
                            }
                        }
                    } else if (i3 == 179) {
                        aVar2.anv = true;
                    }
                    aVar2.d(a.anu, 0, a.anu.length);
                    obj = null;
                    if (obj != null) {
                        aVar = this.ann;
                        str = this.amW;
                        copyOf = Arrays.copyOf(aVar.data, aVar.length);
                        i4 = copyOf[5] & 255;
                        i5 = (i4 >> 4) | ((copyOf[4] & 255) << 4);
                        i4 = ((i4 & 15) << 8) | (copyOf[6] & 255);
                        f = 1.0f;
                        switch ((copyOf[7] & 240) >> 4) {
                            case 2:
                                f = ((float) (i4 * 4)) / ((float) (i5 * 3));
                                break;
                            case 3:
                                f = ((float) (i4 * 16)) / ((float) (i5 * 9));
                                break;
                            case 4:
                                f = ((float) (i4 * 121)) / ((float) (i5 * 100));
                                break;
                        }
                        a2 = Format.a(str, "video/mpeg2", i5, i4, Collections.singletonList(copyOf), f);
                        j = 0;
                        i4 = (copyOf[7] & 15) - 1;
                        d = ank[i4];
                        i4 = aVar.anw;
                        i6 = (copyOf[i4 + 9] & 96) >> 5;
                        i4 = copyOf[i4 + 9] & 31;
                        if (i6 != i4) {
                            d *= (((double) i6) + 1.0d) / ((double) (i4 + 1));
                        }
                        j = (long) (1000000.0d / d);
                        create = Pair.create(a2, Long.valueOf(j));
                        this.alW.f((Format) create.first);
                        this.anl = ((Long) create.second).longValue();
                        this.ana = true;
                    }
                }
                if (i3 == 0 || i3 == 179) {
                    int i8 = i2 - a;
                    if (this.anp && this.ant && this.ana) {
                        this.alW.a(this.anj, this.ans ? 1 : 0, ((int) (this.ano - this.anr)) - i8, i8, null);
                    }
                    if (!this.anp || this.ant) {
                        this.anr = this.ano - ((long) i8);
                        j = this.anq != -9223372036854775807L ? this.anq : this.anp ? this.anj + this.anl : 0;
                        this.anj = j;
                        this.ans = false;
                        this.anq = -9223372036854775807L;
                        this.anp = true;
                    }
                    this.ant = i3 == 0;
                } else if (i3 == 184) {
                    this.ans = true;
                }
                i = a + 3;
            } else if (!this.ana) {
                this.ann.d(bArr, i, i2);
                return;
            } else {
                return;
            }
        }
    }

    public final void jy() {
    }
}
