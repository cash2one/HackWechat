package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.c.u.b;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class t$b implements p {
    final /* synthetic */ t apb;
    private final i apc = new i(new byte[5]);
    private final SparseArray<u> apd = new SparseArray();
    private final SparseIntArray ape = new SparseIntArray();
    private final int pid;

    public t$b(t tVar, int i) {
        this.apb = tVar;
        this.pid = i;
    }

    public final void a(q qVar, f fVar, u$d com_google_android_exoplayer2_c_c_u_d) {
    }

    public final void b(j jVar) {
        if (jVar.readUnsignedByte() == 2) {
            q qVar;
            int cT;
            int i;
            int i2;
            if (t.c(this.apb) == 1 || t.c(this.apb) == 2 || t.d(this.apb) == 1) {
                qVar = (q) t.e(this.apb).get(0);
            } else {
                qVar = new q(((q) t.e(this.apb).get(0)).amG);
                t.e(this.apb).add(qVar);
            }
            jVar.cV(2);
            int readUnsignedShort = jVar.readUnsignedShort();
            jVar.cV(5);
            jVar.c(this.apc, 2);
            this.apc.cS(4);
            jVar.cV(this.apc.cT(12));
            if (t.c(this.apb) == 2 && t.f(this.apb) == null) {
                t.a(this.apb, t.g(this.apb).a(21, new b(21, null, null, new byte[0])));
                t.f(this.apb).a(qVar, t.h(this.apb), new u$d(readUnsignedShort, 21, 8192));
            }
            this.apd.clear();
            this.ape.clear();
            int lF = jVar.lF();
            while (lF > 0) {
                int i3;
                jVar.c(this.apc, 5);
                cT = this.apc.cT(8);
                this.apc.cS(3);
                int cT2 = this.apc.cT(13);
                this.apc.cS(4);
                int cT3 = this.apc.cT(12);
                int i4 = jVar.position;
                int i5 = i4 + cT3;
                i = -1;
                String str = null;
                List list = null;
                while (jVar.position < i5) {
                    int readUnsignedByte = jVar.readUnsignedByte();
                    int readUnsignedByte2 = jVar.readUnsignedByte() + jVar.position;
                    if (readUnsignedByte == 5) {
                        long aK = jVar.aK();
                        if (aK == t.jC()) {
                            i = 129;
                        } else if (aK == t.jD()) {
                            i = a.CTRL_INDEX;
                        } else if (aK == t.jE()) {
                            i = 36;
                        }
                    } else if (readUnsignedByte == 106) {
                        i = 129;
                    } else if (readUnsignedByte == 122) {
                        i = a.CTRL_INDEX;
                    } else if (readUnsignedByte == 123) {
                        i = 138;
                    } else if (readUnsignedByte == 10) {
                        str = jVar.readString(3).trim();
                    } else if (readUnsignedByte == 89) {
                        i = 89;
                        list = new ArrayList();
                        while (jVar.position < readUnsignedByte2) {
                            String trim = jVar.readString(3).trim();
                            int readUnsignedByte3 = jVar.readUnsignedByte();
                            byte[] bArr = new byte[4];
                            jVar.readBytes(bArr, 0, 4);
                            list.add(new u.a(trim, readUnsignedByte3, bArr));
                        }
                    }
                    jVar.cV(readUnsignedByte2 - jVar.position);
                }
                jVar.cR(i5);
                b bVar = new b(i, str, list, Arrays.copyOfRange(jVar.data, i4, i5));
                if (cT == 6) {
                    i3 = bVar.streamType;
                } else {
                    i3 = cT;
                }
                i = lF - (cT3 + 5);
                i2 = t.c(this.apb) == 2 ? i3 : cT2;
                if (t.i(this.apb).get(i2)) {
                    lF = i;
                } else {
                    Object f;
                    if (t.c(this.apb) == 2 && i3 == 21) {
                        f = t.f(this.apb);
                    } else {
                        f = t.g(this.apb).a(i3, bVar);
                    }
                    if (t.c(this.apb) != 2 || cT2 < this.ape.get(i2, 8192)) {
                        this.ape.put(i2, cT2);
                        this.apd.put(i2, f);
                    }
                    lF = i;
                }
            }
            i = this.ape.size();
            for (i2 = 0; i2 < i; i2++) {
                cT = this.ape.keyAt(i2);
                t.i(this.apb).put(cT, true);
                u uVar = (u) this.apd.valueAt(i2);
                if (uVar != null) {
                    if (uVar != t.f(this.apb)) {
                        uVar.a(qVar, t.h(this.apb), new u$d(readUnsignedShort, cT, 8192));
                    }
                    t.a(this.apb).put(this.ape.valueAt(i2), uVar);
                }
            }
            if (t.c(this.apb) != 2) {
                t.a(this.apb).remove(this.pid);
                t.a(this.apb, t.c(this.apb) == 1 ? 0 : t.d(this.apb) - 1);
                if (t.d(this.apb) == 0) {
                    t.h(this.apb).ju();
                    t.k(this.apb);
                }
            } else if (!t.j(this.apb)) {
                t.h(this.apb).ju();
                t.a(this.apb, 0);
                t.k(this.apb);
            }
        }
    }
}
