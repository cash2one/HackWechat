package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jc extends a {
    public String fon;
    public String nfe;
    public String pbP;
    public jf vPk;
    public jg vPl;
    public iz vPm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.pbP == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.vPk == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.vPm == null) {
                throw new b("Not all required fields were included: ActionInfo");
            } else {
                if (this.fon != null) {
                    aVar.g(1, this.fon);
                }
                if (this.nfe != null) {
                    aVar.g(2, this.nfe);
                }
                if (this.pbP != null) {
                    aVar.g(3, this.pbP);
                }
                if (this.vPk != null) {
                    aVar.fW(4, this.vPk.bke());
                    this.vPk.a(aVar);
                }
                if (this.vPl != null) {
                    aVar.fW(5, this.vPl.bke());
                    this.vPl.a(aVar);
                }
                if (this.vPm == null) {
                    return 0;
                }
                aVar.fW(6, this.vPm.bke());
                this.vPm.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.pbP != null) {
                r0 += e.a.a.b.b.a.h(3, this.pbP);
            }
            if (this.vPk != null) {
                r0 += e.a.a.a.fT(4, this.vPk.bke());
            }
            if (this.vPl != null) {
                r0 += e.a.a.a.fT(5, this.vPl.bke());
            }
            if (this.vPm != null) {
                r0 += e.a.a.a.fT(6, this.vPm.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.pbP == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.vPk == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.vPm != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActionInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jc jcVar = (jc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a jfVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jcVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    jcVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jcVar.pbP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jfVar = new jf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        jcVar.vPk = jfVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jfVar = new jg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        jcVar.vPl = jfVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        jfVar = new iz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jfVar.a(aVar4, jfVar, a.a(aVar4))) {
                        }
                        jcVar.vPm = jfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
