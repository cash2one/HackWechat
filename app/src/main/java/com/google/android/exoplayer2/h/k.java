package com.google.android.exoplayer2.h;

import android.os.Handler;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.n;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.util.Collections;

public final class k implements d, t<Object> {
    private final a aAU;
    private final n aAV;
    private final b aAW;
    private int aAX;
    private long aAY;
    private long aAZ;
    private long aBa;
    private long aBb;
    private long aBc;
    private final Handler acI;

    public k() {
        this(null, null);
    }

    public k(Handler handler, a aVar) {
        this(handler, aVar, (byte) 0);
    }

    private k(Handler handler, a aVar, byte b) {
        this(handler, aVar, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, b.aBV);
    }

    private k(Handler handler, a aVar, int i, b bVar) {
        this.acI = handler;
        this.aAU = aVar;
        this.aAV = new n(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
        this.aAW = bVar;
        this.aBc = -1;
    }

    public final synchronized void ls() {
        if (this.aAX == 0) {
            this.aAY = this.aAW.elapsedRealtime();
        }
        this.aAX++;
    }

    public final synchronized void cQ(int i) {
        this.aAZ += (long) i;
    }

    public final synchronized void lt() {
        int i = 0;
        synchronized (this) {
            com.google.android.exoplayer2.i.a.an(this.aAX > 0);
            long elapsedRealtime = this.aAW.elapsedRealtime();
            int i2 = (int) (elapsedRealtime - this.aAY);
            this.aBa += (long) i2;
            this.aBb += this.aAZ;
            if (i2 > 0) {
                int i3;
                n.a aVar;
                float f = (float) ((this.aAZ * 8000) / ((long) i2));
                n nVar = this.aAV;
                int sqrt = (int) Math.sqrt((double) this.aAZ);
                if (nVar.aCA != 1) {
                    Collections.sort(nVar.aCy, n.aCv);
                    nVar.aCA = 1;
                }
                if (nVar.aCD > 0) {
                    n.a[] aVarArr = nVar.aCz;
                    i3 = nVar.aCD - 1;
                    nVar.aCD = i3;
                    aVar = aVarArr[i3];
                } else {
                    aVar = new n.a((byte) 0);
                }
                i3 = nVar.aCB;
                nVar.aCB = i3 + 1;
                aVar.index = i3;
                aVar.weight = sqrt;
                aVar.value = f;
                nVar.aCy.add(aVar);
                nVar.aCC += sqrt;
                while (nVar.aCC > nVar.aCx) {
                    i3 = nVar.aCC - nVar.aCx;
                    aVar = (n.a) nVar.aCy.get(0);
                    if (aVar.weight <= i3) {
                        nVar.aCC -= aVar.weight;
                        nVar.aCy.remove(0);
                        if (nVar.aCD < 5) {
                            n.a[] aVarArr2 = nVar.aCz;
                            int i4 = nVar.aCD;
                            nVar.aCD = i4 + 1;
                            aVarArr2[i4] = aVar;
                        }
                    } else {
                        aVar.weight -= i3;
                        nVar.aCC -= i3;
                    }
                }
                if (this.aBa >= 2000 || this.aBb >= 524288) {
                    float f2;
                    n nVar2 = this.aAV;
                    if (nVar2.aCA != 0) {
                        Collections.sort(nVar2.aCy, n.aCw);
                        nVar2.aCA = 0;
                    }
                    float f3 = 0.5f * ((float) nVar2.aCC);
                    i3 = 0;
                    while (i < nVar2.aCy.size()) {
                        aVar = (n.a) nVar2.aCy.get(i);
                        i3 += aVar.weight;
                        if (((float) i3) >= f3) {
                            f2 = aVar.value;
                            break;
                        }
                        i++;
                    }
                    f2 = nVar2.aCy.isEmpty() ? Float.NaN : ((n.a) nVar2.aCy.get(nVar2.aCy.size() - 1)).value;
                    this.aBc = Float.isNaN(f2) ? -1 : (long) f2;
                }
            }
            long j = this.aAZ;
            long j2 = this.aBc;
            if (!(this.acI == null || this.aAU == null)) {
                this.acI.post(new 1(this, i2, j, j2));
            }
            int i5 = this.aAX - 1;
            this.aAX = i5;
            if (i5 > 0) {
                this.aAY = elapsedRealtime;
            }
            this.aAZ = 0;
        }
    }
}
