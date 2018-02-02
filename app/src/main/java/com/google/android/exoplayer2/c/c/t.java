package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.c.u.c;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j$a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class t implements d {
    public static final g aiT = new 1();
    private static final long aoN = ((long) com.google.android.exoplayer2.i.t.ak("AC-3"));
    private static final long aoO = ((long) com.google.android.exoplayer2.i.t.ak("EAC3"));
    private static final long aoP = ((long) com.google.android.exoplayer2.i.t.ak("HEVC"));
    private final List<q> aoQ;
    private final j aoR;
    private final SparseIntArray aoS;
    private final c aoT;
    private final SparseArray<u> aoU;
    private final SparseBooleanArray aoV;
    private f aoW;
    private int aoX;
    private boolean aoY;
    private u aoZ;
    private final int mode;

    public t() {
        this((byte) 0);
    }

    private t(byte b) {
        this(0);
    }

    private t(int i) {
        this(1, new q(0), new e(0));
    }

    public t(int i, q qVar, c cVar) {
        this.aoT = (c) a.Y(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.aoQ = Collections.singletonList(qVar);
        } else {
            this.aoQ = new ArrayList();
            this.aoQ.add(qVar);
        }
        this.aoR = new j(9400);
        this.aoV = new SparseBooleanArray();
        this.aoU = new SparseArray();
        this.aoS = new SparseIntArray();
        jB();
    }

    public final void a(f fVar) {
        this.aoW = fVar;
        j$a com_google_android_exoplayer2_c_j_a = new j$a(-9223372036854775807L);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(e eVar) {
        int lF;
        int read;
        int i = 1;
        Object obj = this.aoR.data;
        if (9400 - this.aoR.position < n.CTRL_BYTE) {
            lF = this.aoR.lF();
            if (lF > 0) {
                System.arraycopy(obj, this.aoR.position, obj, 0, lF);
            }
            this.aoR.l(obj, lF);
        }
        while (this.aoR.lF() < n.CTRL_BYTE) {
            lF = this.aoR.asN;
            read = eVar.read(obj, lF, 9400 - lF);
            if (read == -1) {
                return -1;
            }
            this.aoR.cU(lF + read);
        }
        read = this.aoR.asN;
        int i2 = this.aoR.position;
        while (i2 < read && obj[i2] != (byte) 71) {
            i2++;
        }
        this.aoR.cR(i2);
        int i3 = i2 + n.CTRL_BYTE;
        if (i3 > read) {
            return 0;
        }
        int readInt = this.aoR.readInt();
        if ((8388608 & readInt) != 0) {
            this.aoR.cR(i3);
            return 0;
        }
        int i4;
        boolean z = (4194304 & readInt) != 0;
        int i5 = (2096896 & readInt) >> 8;
        if ((readInt & 32) != 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if ((readInt & 16) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.mode != 2) {
            readInt &= 15;
            int i6 = this.aoS.get(i5, readInt - 1);
            this.aoS.put(i5, readInt);
            if (i6 == readInt) {
                if (i2 != 0) {
                    this.aoR.cR(i3);
                    return 0;
                }
            }
        }
        i = 0;
        if (i4 != 0) {
            this.aoR.cV(this.aoR.readUnsignedByte());
        }
        if (i2 != 0) {
            u uVar = (u) this.aoU.get(i5);
            if (uVar != null) {
                if (i != 0) {
                    uVar.jx();
                }
                this.aoR.cU(i3);
                uVar.a(this.aoR, z);
                this.aoR.cU(read);
            }
        }
        this.aoR.cR(i3);
        return 0;
    }

    private void jB() {
        this.aoV.clear();
        this.aoU.clear();
        SparseArray jA = this.aoT.jA();
        int size = jA.size();
        for (int i = 0; i < size; i++) {
            this.aoU.put(jA.keyAt(i), jA.valueAt(i));
        }
        this.aoU.put(0, new q(new a(this)));
        this.aoZ = null;
    }
}
