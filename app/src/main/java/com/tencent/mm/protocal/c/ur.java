package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ur extends a {
    public String desc;
    public String iIj;
    public String title;
    public uy vCU;
    public long vCV;
    public boolean wcC = false;
    public boolean wcD = false;
    public us wdX;
    public boolean wdY = false;
    public ux wdZ;
    public boolean wea = false;
    public vt web;
    public boolean wec = false;
    public vd wed;
    public boolean wee = false;
    public vn wef;
    public boolean weg = false;
    public boolean weh = false;
    public long wei;
    public boolean wej = false;
    public int wek = -1;
    public boolean wel = false;
    public boolean wem = false;
    public boolean wen = false;

    public final ur c(us usVar) {
        this.wdX = usVar;
        this.wdY = true;
        return this;
    }

    public final ur a(ux uxVar) {
        this.wdZ = uxVar;
        this.wea = true;
        return this;
    }

    public final ur a(vt vtVar) {
        this.web = vtVar;
        this.wec = true;
        return this;
    }

    public final ur a(vd vdVar) {
        this.wed = vdVar;
        this.wee = true;
        return this;
    }

    public final ur a(vn vnVar) {
        this.wef = vnVar;
        this.weg = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdX != null) {
                aVar.fW(1, this.wdX.bke());
                this.wdX.a(aVar);
            }
            if (this.wdZ != null) {
                aVar.fW(2, this.wdZ.bke());
                this.wdZ.a(aVar);
            }
            if (this.web != null) {
                aVar.fW(3, this.web.bke());
                this.web.a(aVar);
            }
            if (this.wed != null) {
                aVar.fW(4, this.wed.bke());
                this.wed.a(aVar);
            }
            if (this.wef != null) {
                aVar.fW(5, this.wef.bke());
                this.wef.a(aVar);
            }
            if (this.iIj != null) {
                aVar.g(6, this.iIj);
            }
            if (this.title != null) {
                aVar.g(7, this.title);
            }
            if (this.desc != null) {
                aVar.g(8, this.desc);
            }
            if (this.wej) {
                aVar.S(9, this.wei);
            }
            if (this.wel) {
                aVar.fU(101, this.wek);
            }
            if (this.wem) {
                aVar.S(11, this.vCV);
            }
            if (this.vCU == null) {
                return 0;
            }
            aVar.fW(12, this.vCU.bke());
            this.vCU.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wdX != null) {
                r0 = e.a.a.a.fT(1, this.wdX.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wdZ != null) {
                r0 += e.a.a.a.fT(2, this.wdZ.bke());
            }
            if (this.web != null) {
                r0 += e.a.a.a.fT(3, this.web.bke());
            }
            if (this.wed != null) {
                r0 += e.a.a.a.fT(4, this.wed.bke());
            }
            if (this.wef != null) {
                r0 += e.a.a.a.fT(5, this.wef.bke());
            }
            if (this.iIj != null) {
                r0 += e.a.a.b.b.a.h(6, this.iIj);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(7, this.title);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(8, this.desc);
            }
            if (this.wej) {
                r0 += e.a.a.a.R(9, this.wei);
            }
            if (this.wel) {
                r0 += e.a.a.a.fR(101, this.wek);
            }
            if (this.wem) {
                r0 += e.a.a.a.R(11, this.vCV);
            }
            if (this.vCU != null) {
                r0 += e.a.a.a.fT(12, this.vCU.bke());
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
            ur urVar = (ur) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            a usVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        usVar = new us();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = usVar.a(aVar4, usVar, a.a(aVar4))) {
                        }
                        urVar.wdX = usVar;
                    }
                    urVar.wdY = true;
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        usVar = new ux();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = usVar.a(aVar4, usVar, a.a(aVar4))) {
                        }
                        urVar.wdZ = usVar;
                    }
                    urVar.wea = true;
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        usVar = new vt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = usVar.a(aVar4, usVar, a.a(aVar4))) {
                        }
                        urVar.web = usVar;
                    }
                    urVar.wec = true;
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        usVar = new vd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = usVar.a(aVar4, usVar, a.a(aVar4))) {
                        }
                        urVar.wed = usVar;
                    }
                    urVar.wee = true;
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        usVar = new vn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = usVar.a(aVar4, usVar, a.a(aVar4))) {
                        }
                        urVar.wef = usVar;
                    }
                    urVar.weg = true;
                    return 0;
                case 6:
                    urVar.iIj = aVar3.Avy.readString();
                    urVar.weh = true;
                    return 0;
                case 7:
                    urVar.title = aVar3.Avy.readString();
                    urVar.wcC = true;
                    return 0;
                case 8:
                    urVar.desc = aVar3.Avy.readString();
                    urVar.wcD = true;
                    return 0;
                case 9:
                    urVar.wei = aVar3.Avy.rz();
                    urVar.wej = true;
                    return 0;
                case 11:
                    urVar.vCV = aVar3.Avy.rz();
                    urVar.wem = true;
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        usVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = usVar.a(aVar4, usVar, a.a(aVar4))) {
                        }
                        urVar.vCU = usVar;
                    }
                    urVar.wen = true;
                    return 0;
                case 101:
                    urVar.wek = aVar3.Avy.ry();
                    urVar.wel = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
