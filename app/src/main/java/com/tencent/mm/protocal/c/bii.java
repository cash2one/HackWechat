package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bii extends a {
    public LinkedList<String> wLK = new LinkedList();
    public LinkedList<String> wLL = new LinkedList();
    public LinkedList<Integer> wLM = new LinkedList();
    public LinkedList<Integer> wLN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.wLK);
            aVar.d(2, 1, this.wLL);
            aVar.d(3, 2, this.wLM);
            aVar.d(4, 2, this.wLN);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.c(1, 1, this.wLK) + 0) + e.a.a.a.c(2, 1, this.wLL)) + e.a.a.a.c(3, 2, this.wLM)) + e.a.a.a.c(4, 2, this.wLN);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.wLK.clear();
                this.wLL.clear();
                this.wLM.clear();
                this.wLN.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
                bii com_tencent_mm_protocal_c_bii = (bii) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bii.wLK.add(aVar3.Avy.readString());
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bii.wLL.add(aVar3.Avy.readString());
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bii.wLM.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bii.wLN.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
