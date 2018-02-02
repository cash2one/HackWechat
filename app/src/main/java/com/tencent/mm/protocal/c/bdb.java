package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class bdb extends a {
    public String nfX;
    public int vYh;
    public b vZC;
    public String vZU;
    public int wJl;
    public int wJm;
    public LinkedList<bip> wJn = new LinkedList();
    public String wJo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZU == null) {
                throw new e.a.a.b("Not all required fields were included: MD5");
            } else if (this.nfX == null) {
                throw new e.a.a.b("Not all required fields were included: Url");
            } else if (this.wJo == null) {
                throw new e.a.a.b("Not all required fields were included: OriginalMD5");
            } else {
                if (this.vZU != null) {
                    aVar.g(1, this.vZU);
                }
                aVar.fU(2, this.wJl);
                if (this.nfX != null) {
                    aVar.g(3, this.nfX);
                }
                aVar.fU(4, this.wJm);
                aVar.d(5, 8, this.wJn);
                if (this.vZC != null) {
                    aVar.b(6, this.vZC);
                }
                if (this.wJo != null) {
                    aVar.g(7, this.wJo);
                }
                aVar.fU(8, this.vYh);
                return 0;
            }
        } else if (i == 1) {
            if (this.vZU != null) {
                r0 = e.a.a.b.b.a.h(1, this.vZU) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wJl);
            if (this.nfX != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfX);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.wJm)) + e.a.a.a.c(5, 8, this.wJn);
            if (this.vZC != null) {
                r0 += e.a.a.a.a(6, this.vZC);
            }
            if (this.wJo != null) {
                r0 += e.a.a.b.b.a.h(7, this.wJo);
            }
            return r0 + e.a.a.a.fR(8, this.vYh);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wJn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vZU == null) {
                throw new e.a.a.b("Not all required fields were included: MD5");
            } else if (this.nfX == null) {
                throw new e.a.a.b("Not all required fields were included: Url");
            } else if (this.wJo != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: OriginalMD5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdb com_tencent_mm_protocal_c_bdb = (bdb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bdb.vZU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdb.wJl = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdb.nfX = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdb.wJm = aVar3.Avy.ry();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bip = new bip();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bip.a(aVar4, com_tencent_mm_protocal_c_bip, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdb.wJn.add(com_tencent_mm_protocal_c_bip);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdb.vZC = aVar3.cJD();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bdb.wJo = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bdb.vYh = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
