package com.tencent.mm.storage;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ag extends a {
    public int xyp;
    public LinkedList<Integer> xyq = new LinkedList();
    public LinkedList<Integer> xyr = new LinkedList();
    public LinkedList<Integer> xyt = new LinkedList();
    public LinkedList<Long> xyu = new LinkedList();
    public LinkedList<Long> xyv = new LinkedList();
    public LinkedList<Long> xyw = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.xyp);
            aVar.d(2, 2, this.xyq);
            aVar.d(3, 2, this.xyr);
            aVar.d(4, 2, this.xyt);
            aVar.d(5, 3, this.xyu);
            aVar.d(6, 3, this.xyv);
            aVar.d(7, 3, this.xyw);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fR(1, this.xyp) + 0) + e.a.a.a.c(2, 2, this.xyq)) + e.a.a.a.c(3, 2, this.xyr)) + e.a.a.a.c(4, 2, this.xyt)) + e.a.a.a.c(5, 3, this.xyu)) + e.a.a.a.c(6, 3, this.xyv)) + e.a.a.a.c(7, 3, this.xyw);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.xyq.clear();
                this.xyr.clear();
                this.xyt.clear();
                this.xyu.clear();
                this.xyv.clear();
                this.xyw.clear();
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
                ag agVar = (ag) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        agVar.xyp = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        agVar.xyq.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 3:
                        agVar.xyr.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 4:
                        agVar.xyt.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 5:
                        agVar.xyu.add(Long.valueOf(aVar3.Avy.rz()));
                        return 0;
                    case 6:
                        agVar.xyv.add(Long.valueOf(aVar3.Avy.rz()));
                        return 0;
                    case 7:
                        agVar.xyw.add(Long.valueOf(aVar3.Avy.rz()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
