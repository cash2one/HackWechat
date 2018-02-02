package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class alc extends a {
    public int fCV;
    public String wsj;
    public String wsn;
    public String wso;
    public String wsp;
    public avj wsq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wsj == null) {
                throw new b("Not all required fields were included: session_data");
            }
            aVar.fU(1, this.fCV);
            if (this.wsj != null) {
                aVar.g(2, this.wsj);
            }
            if (this.wsn != null) {
                aVar.g(3, this.wsn);
            }
            if (this.wso != null) {
                aVar.g(4, this.wso);
            }
            if (this.wsp != null) {
                aVar.g(5, this.wsp);
            }
            if (this.wsq != null) {
                aVar.fW(6, this.wsq.bke());
                this.wsq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.fCV) + 0;
            if (this.wsj != null) {
                r0 += e.a.a.b.b.a.h(2, this.wsj);
            }
            if (this.wsn != null) {
                r0 += e.a.a.b.b.a.h(3, this.wsn);
            }
            if (this.wso != null) {
                r0 += e.a.a.b.b.a.h(4, this.wso);
            }
            if (this.wsp != null) {
                r0 += e.a.a.b.b.a.h(5, this.wsp);
            }
            if (this.wsq != null) {
                return r0 + e.a.a.a.fT(6, this.wsq.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wsj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: session_data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alc com_tencent_mm_protocal_c_alc = (alc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_alc.fCV = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alc.wsj = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alc.wsn = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alc.wso = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alc.wsp = aVar3.Avy.readString();
                    return 0;
                case 6:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_avj = new avj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avj.a(aVar4, com_tencent_mm_protocal_c_avj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alc.wsq = com_tencent_mm_protocal_c_avj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
