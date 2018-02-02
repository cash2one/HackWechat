package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jd extends a {
    public String kub;
    public String nfg;
    public jf vPk;
    public bfe vPn;
    public jk vPo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kub == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vPn == null) {
                throw new b("Not all required fields were included: ContactItem");
            } else {
                if (this.kub != null) {
                    aVar.g(1, this.kub);
                }
                if (this.vPk != null) {
                    aVar.fW(2, this.vPk.bke());
                    this.vPk.a(aVar);
                }
                if (this.vPn != null) {
                    aVar.fW(3, this.vPn.bke());
                    this.vPn.a(aVar);
                }
                if (this.vPo != null) {
                    aVar.fW(4, this.vPo.bke());
                    this.vPo.a(aVar);
                }
                if (this.nfg == null) {
                    return 0;
                }
                aVar.g(5, this.nfg);
                return 0;
            }
        } else if (i == 1) {
            if (this.kub != null) {
                r0 = e.a.a.b.b.a.h(1, this.kub) + 0;
            } else {
                r0 = 0;
            }
            if (this.vPk != null) {
                r0 += e.a.a.a.fT(2, this.vPk.bke());
            }
            if (this.vPn != null) {
                r0 += e.a.a.a.fT(3, this.vPn.bke());
            }
            if (this.vPo != null) {
                r0 += e.a.a.a.fT(4, this.vPo.bke());
            }
            if (this.nfg != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfg);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.kub == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vPn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ContactItem");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jd jdVar = (jd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a jfVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jdVar.kub = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jfVar = new jf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        jdVar.vPk = jfVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jfVar = new bfe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        jdVar.vPn = jfVar;
                    }
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jfVar = new jk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        jdVar.vPo = jfVar;
                    }
                    return 0;
                case 5:
                    jdVar.nfg = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
