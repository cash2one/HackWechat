package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;

public final class t {
    public final a AfA = new a(8193, true);
    public final a AfB = new a(8194, false);
    public final a AfC = new a(8195, false);
    public final a AfD = new a(8196, false);
    public final a AfE = new a(8197, false);
    public final a AfF = new a(8198, true);
    public final a[] AfG = new a[]{this.Afo, this.Afp, this.Afq, this.Afr, this.Afs, this.Aft, this.Afu, this.Afv, this.Afw, this.Afx, this.Afy, this.Afz, this.AfA, this.AfB, this.AfC, this.AfD, this.AfE, this.AfF};
    public int AfH;
    public int AfI;
    public int AfJ;
    public int AfK;
    public byte[] Afc = new byte[20];
    public final a Afo = new a(0, true);
    public final a Afp = new a(1, true);
    public final a Afq = new a(2, true);
    public final a Afr = new a(3, true);
    public final a Afs = new a(4, true);
    public final a Aft = new a(5, true);
    public final a Afu = new a(6, true);
    public final a Afv = new a(Downloads.RECV_BUFFER_SIZE, true);
    public final a Afw = new a(4097, true);
    public final a Afx = new a(4098, true);
    public final a Afy = new a(4099, true);
    public final a Afz = new a(8192, false);
    public int fileSize;
    public int hXE;

    final void a(e eVar) {
        int i;
        int i2 = eVar.aif.getInt();
        int i3 = 0;
        a aVar = null;
        while (i3 < i2) {
            short s = eVar.aif.getShort();
            eVar.aif.getShort();
            for (a aVar2 : this.AfG) {
                if (aVar2.AfL == s) {
                    i = eVar.aif.getInt();
                    int i4 = eVar.aif.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i) && (aVar2.dzw == -1 || aVar2.dzw == i4)) {
                        aVar2.size = i;
                        aVar2.dzw = i4;
                        if (aVar == null || aVar.dzw <= aVar2.dzw) {
                            i3++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    }
                    throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: " + s);
        }
        this.Afo.dzw = 0;
        Arrays.sort(this.AfG);
        for (i = 1; i < this.AfG.length; i++) {
            if (this.AfG[i].dzw == -1) {
                this.AfG[i].dzw = this.AfG[i - 1].dzw;
            }
        }
    }

    public final void cGO() {
        int i = this.fileSize;
        for (int length = this.AfG.length - 1; length >= 0; length--) {
            a aVar = this.AfG[length];
            if (aVar.dzw != -1) {
                if (aVar.dzw > i) {
                    throw new j("Map is unsorted at " + aVar);
                }
                aVar.AfN = i - aVar.dzw;
                i = aVar.dzw;
            }
        }
        this.AfK = (((((this.Afo.AfN + this.Afp.AfN) + this.Afq.AfN) + this.Afr.AfN) + this.Afs.AfN) + this.Aft.AfN) + this.Afu.AfN;
        this.AfJ = this.fileSize - this.AfK;
    }

    public final void b(e eVar) {
        int i = 0;
        for (a exists : this.AfG) {
            if (exists.exists()) {
                i++;
            }
        }
        eVar.writeInt(i);
        for (a aVar : this.AfG) {
            if (aVar.exists()) {
                eVar.writeShort(aVar.AfL);
                eVar.writeShort((short) 0);
                eVar.writeInt(aVar.size);
                eVar.writeInt(aVar.dzw);
            }
        }
    }
}
