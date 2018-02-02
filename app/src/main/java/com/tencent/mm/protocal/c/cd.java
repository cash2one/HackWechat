package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cd extends a {
    public int fCR;
    public int pKd;
    public String pLn;
    public int scene;
    public String vHq;
    public String vHr;
    public String vHs;
    public vu vHt;
    public String vHu;
    public int vHv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHq == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vHs == null) {
                throw new b("Not all required fields were included: payok_checksign");
            } else {
                if (this.vHq != null) {
                    aVar.g(1, this.vHq);
                }
                if (this.vHr != null) {
                    aVar.g(2, this.vHr);
                }
                aVar.fU(3, this.fCR);
                aVar.fU(4, this.pKd);
                aVar.fU(5, this.scene);
                if (this.vHs != null) {
                    aVar.g(6, this.vHs);
                }
                if (this.vHt != null) {
                    aVar.fW(7, this.vHt.bke());
                    this.vHt.a(aVar);
                }
                if (this.vHu != null) {
                    aVar.g(8, this.vHu);
                }
                if (this.pLn != null) {
                    aVar.g(9, this.pLn);
                }
                aVar.fU(10, this.vHv);
                return 0;
            }
        } else if (i == 1) {
            if (this.vHq != null) {
                r0 = e.a.a.b.b.a.h(1, this.vHq) + 0;
            } else {
                r0 = 0;
            }
            if (this.vHr != null) {
                r0 += e.a.a.b.b.a.h(2, this.vHr);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.fCR)) + e.a.a.a.fR(4, this.pKd)) + e.a.a.a.fR(5, this.scene);
            if (this.vHs != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHs);
            }
            if (this.vHt != null) {
                r0 += e.a.a.a.fT(7, this.vHt.bke());
            }
            if (this.vHu != null) {
                r0 += e.a.a.b.b.a.h(8, this.vHu);
            }
            if (this.pLn != null) {
                r0 += e.a.a.b.b.a.h(9, this.pLn);
            }
            return r0 + e.a.a.a.fR(10, this.vHv);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vHq == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vHs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: payok_checksign");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cdVar.vHq = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cdVar.vHr = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cdVar.fCR = aVar3.Avy.ry();
                    return 0;
                case 4:
                    cdVar.pKd = aVar3.Avy.ry();
                    return 0;
                case 5:
                    cdVar.scene = aVar3.Avy.ry();
                    return 0;
                case 6:
                    cdVar.vHs = aVar3.Avy.readString();
                    return 0;
                case 7:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a vuVar = new vu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = vuVar.a(aVar4, vuVar, a.a(aVar4))) {
                        }
                        cdVar.vHt = vuVar;
                    }
                    return 0;
                case 8:
                    cdVar.vHu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    cdVar.pLn = aVar3.Avy.readString();
                    return 0;
                case 10:
                    cdVar.vHv = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
