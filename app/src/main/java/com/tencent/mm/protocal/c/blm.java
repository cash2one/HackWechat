package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class blm extends a {
    public int vWK;
    public int wOO;
    public int wOP;
    public int wOQ;
    public int wOR;
    public int wOS;
    public LinkedList<Integer> wOT = new LinkedList();
    public int wOU;
    public int wOV;
    public LinkedList<Integer> wOW = new LinkedList();
    public int wOX;
    public int wOY;
    public int wbh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wbh);
            aVar.fU(2, this.wOO);
            aVar.fU(3, this.vWK);
            aVar.fU(4, this.wOP);
            aVar.fU(5, this.wOQ);
            aVar.fU(6, this.wOR);
            aVar.fU(7, this.wOS);
            aVar.d(8, 2, this.wOT);
            aVar.fU(9, this.wOU);
            aVar.fU(10, this.wOV);
            aVar.d(11, 2, this.wOW);
            aVar.fU(12, this.wOX);
            aVar.fU(13, this.wOY);
            return 0;
        } else if (i == 1) {
            return ((((((((((((e.a.a.a.fR(1, this.wbh) + 0) + e.a.a.a.fR(2, this.wOO)) + e.a.a.a.fR(3, this.vWK)) + e.a.a.a.fR(4, this.wOP)) + e.a.a.a.fR(5, this.wOQ)) + e.a.a.a.fR(6, this.wOR)) + e.a.a.a.fR(7, this.wOS)) + e.a.a.a.c(8, 2, this.wOT)) + e.a.a.a.fR(9, this.wOU)) + e.a.a.a.fR(10, this.wOV)) + e.a.a.a.c(11, 2, this.wOW)) + e.a.a.a.fR(12, this.wOX)) + e.a.a.a.fR(13, this.wOY);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.wOT.clear();
                this.wOW.clear();
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
                blm com_tencent_mm_protocal_c_blm = (blm) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_blm.wbh = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_blm.wOO = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_blm.vWK = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_blm.wOP = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_blm.wOQ = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_blm.wOR = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_blm.wOS = aVar3.Avy.ry();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_blm.wOT.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 9:
                        com_tencent_mm_protocal_c_blm.wOU = aVar3.Avy.ry();
                        return 0;
                    case 10:
                        com_tencent_mm_protocal_c_blm.wOV = aVar3.Avy.ry();
                        return 0;
                    case 11:
                        com_tencent_mm_protocal_c_blm.wOW.add(Integer.valueOf(aVar3.Avy.ry()));
                        return 0;
                    case 12:
                        com_tencent_mm_protocal_c_blm.wOX = aVar3.Avy.ry();
                        return 0;
                    case 13:
                        com_tencent_mm_protocal_c_blm.wOY = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
