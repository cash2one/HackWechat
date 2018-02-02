package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;

public class IMBehaviorMsgOP extends a {
    public int appMsgInnerType;
    public int count;
    public int msgOpType;
    public int msgType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.msgType);
            aVar.fU(2, this.msgOpType);
            aVar.fU(3, this.appMsgInnerType);
            aVar.fU(4, this.count);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.msgType) + 0) + e.a.a.a.fR(2, this.msgOpType)) + e.a.a.a.fR(3, this.appMsgInnerType)) + e.a.a.a.fR(4, this.count);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                IMBehaviorMsgOP iMBehaviorMsgOP = (IMBehaviorMsgOP) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iMBehaviorMsgOP.msgType = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        iMBehaviorMsgOP.msgOpType = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        iMBehaviorMsgOP.appMsgInnerType = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        iMBehaviorMsgOP.count = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
