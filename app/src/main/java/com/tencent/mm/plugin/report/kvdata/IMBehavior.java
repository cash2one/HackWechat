package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public class IMBehavior extends a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.opType);
            if (this.chattingOp != null) {
                aVar.fW(2, this.chattingOp.bke());
                this.chattingOp.a(aVar);
            }
            if (this.msgOp != null) {
                aVar.fW(3, this.msgOp.bke());
                this.msgOp.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.opType) + 0;
            if (this.chattingOp != null) {
                r0 += e.a.a.a.fT(2, this.chattingOp.bke());
            }
            if (this.msgOp != null) {
                return r0 + e.a.a.a.fT(3, this.msgOp.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a iMBehaviorChattingOP;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iMBehavior.opType = aVar3.Avy.ry();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        iMBehaviorChattingOP = new IMBehaviorMsgOP();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.msgOp = iMBehaviorChattingOP;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
