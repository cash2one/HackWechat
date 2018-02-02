package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class di extends a {
    public b vIA;
    public dj vIt;
    public dk vIz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIz == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.vIt == null) {
                throw new e.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.vIA == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.vIz != null) {
                    aVar.fW(1, this.vIz.bke());
                    this.vIz.a(aVar);
                }
                if (this.vIt != null) {
                    aVar.fW(2, this.vIt.bke());
                    this.vIt.a(aVar);
                }
                if (this.vIA == null) {
                    return 0;
                }
                aVar.b(3, this.vIA);
                return 0;
            }
        } else if (i == 1) {
            if (this.vIz != null) {
                r0 = e.a.a.a.fT(1, this.vIz.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIt != null) {
                r0 += e.a.a.a.fT(2, this.vIt.bke());
            }
            if (this.vIA != null) {
                r0 += e.a.a.a.a(3, this.vIA);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vIz == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.vIt == null) {
                throw new e.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.vIA != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            di diVar = (di) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a dkVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dkVar = new dk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dkVar.a(aVar4, dkVar, a.a(aVar4))) {
                        }
                        diVar.vIz = dkVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        dkVar = new dj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dkVar.a(aVar4, dkVar, a.a(aVar4))) {
                        }
                        diVar.vIt = dkVar;
                    }
                    return 0;
                case 3:
                    diVar.vIA = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
