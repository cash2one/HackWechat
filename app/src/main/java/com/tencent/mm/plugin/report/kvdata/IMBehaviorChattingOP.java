package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bq.a;

public class IMBehaviorChattingOP extends a {
    public int changeNotifyStatus;
    public int changeSaveAddress;
    public int changeTop;
    public int changeUnread;
    public int expose;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.changeUnread);
            aVar.fU(2, this.changeTop);
            aVar.fU(3, this.changeNotifyStatus);
            aVar.fU(4, this.changeSaveAddress);
            aVar.fU(5, this.expose);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.changeUnread) + 0) + e.a.a.a.fR(2, this.changeTop)) + e.a.a.a.fR(3, this.changeNotifyStatus)) + e.a.a.a.fR(4, this.changeSaveAddress)) + e.a.a.a.fR(5, this.expose);
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
                IMBehaviorChattingOP iMBehaviorChattingOP = (IMBehaviorChattingOP) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iMBehaviorChattingOP.changeUnread = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        iMBehaviorChattingOP.changeTop = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        iMBehaviorChattingOP.changeNotifyStatus = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        iMBehaviorChattingOP.changeSaveAddress = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        iMBehaviorChattingOP.expose = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
