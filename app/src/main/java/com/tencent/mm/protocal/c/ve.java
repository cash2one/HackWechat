package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ve extends a {
    public String desc;
    public String iIj;
    public String title;
    public uy vCU;
    public long vCV;
    public int version;
    public boolean wcC = false;
    public boolean wcD = false;
    public ux wdZ;
    public vk weS;
    public boolean weT = false;
    public LinkedList<uq> weU = new LinkedList();
    public boolean weV = false;
    public boolean weW = false;
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

    public final ve a(vk vkVar) {
        this.weS = vkVar;
        this.weT = true;
        return this;
    }

    public final ve av(LinkedList<uq> linkedList) {
        this.weU = linkedList;
        this.weV = true;
        return this;
    }

    public final ve b(ux uxVar) {
        this.wdZ = uxVar;
        this.wea = true;
        return this;
    }

    public final ve b(vt vtVar) {
        this.web = vtVar;
        this.wec = true;
        return this;
    }

    public final ve Uf(String str) {
        this.iIj = str;
        this.weh = true;
        return this;
    }

    public final ve Ug(String str) {
        this.title = str;
        this.wcC = true;
        return this;
    }

    public final ve Uh(String str) {
        this.desc = str;
        this.wcD = true;
        return this;
    }

    public final ve fA(long j) {
        this.wei = j;
        this.wej = true;
        return this;
    }

    public final ve CQ(int i) {
        this.wek = i;
        this.wel = true;
        return this;
    }

    public final ve b(vd vdVar) {
        this.wed = vdVar;
        this.wee = true;
        return this;
    }

    public final ve fB(long j) {
        this.vCV = j;
        this.wem = true;
        return this;
    }

    public final ve b(vn vnVar) {
        this.wef = vnVar;
        this.weg = true;
        return this;
    }

    public final ve CR(int i) {
        this.version = i;
        this.weW = true;
        return this;
    }

    public final ve a(uy uyVar) {
        this.vCU = uyVar;
        this.wen = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weS != null) {
                aVar.fW(1, this.weS.bke());
                this.weS.a(aVar);
            }
            aVar.d(2, 8, this.weU);
            if (this.wdZ != null) {
                aVar.fW(3, this.wdZ.bke());
                this.wdZ.a(aVar);
            }
            if (this.web != null) {
                aVar.fW(4, this.web.bke());
                this.web.a(aVar);
            }
            if (this.iIj != null) {
                aVar.g(5, this.iIj);
            }
            if (this.title != null) {
                aVar.g(6, this.title);
            }
            if (this.desc != null) {
                aVar.g(7, this.desc);
            }
            if (this.wej) {
                aVar.S(8, this.wei);
            }
            if (this.wel) {
                aVar.fU(91, this.wek);
            }
            if (this.wed != null) {
                aVar.fW(10, this.wed.bke());
                this.wed.a(aVar);
            }
            if (this.wem) {
                aVar.S(11, this.vCV);
            }
            if (this.wef != null) {
                aVar.fW(12, this.wef.bke());
                this.wef.a(aVar);
            }
            if (this.weW) {
                aVar.fU(13, this.version);
            }
            if (this.vCU == null) {
                return 0;
            }
            aVar.fW(14, this.vCU.bke());
            this.vCU.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.weS != null) {
                r0 = e.a.a.a.fT(1, this.weS.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(2, 8, this.weU);
            if (this.wdZ != null) {
                r0 += e.a.a.a.fT(3, this.wdZ.bke());
            }
            if (this.web != null) {
                r0 += e.a.a.a.fT(4, this.web.bke());
            }
            if (this.iIj != null) {
                r0 += e.a.a.b.b.a.h(5, this.iIj);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(6, this.title);
            }
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(7, this.desc);
            }
            if (this.wej) {
                r0 += e.a.a.a.R(8, this.wei);
            }
            if (this.wel) {
                r0 += e.a.a.a.fR(91, this.wek);
            }
            if (this.wed != null) {
                r0 += e.a.a.a.fT(10, this.wed.bke());
            }
            if (this.wem) {
                r0 += e.a.a.a.R(11, this.vCV);
            }
            if (this.wef != null) {
                r0 += e.a.a.a.fT(12, this.wef.bke());
            }
            if (this.weW) {
                r0 += e.a.a.a.fR(13, this.version);
            }
            if (this.vCU != null) {
                r0 += e.a.a.a.fT(14, this.vCU.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.weU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            ve veVar = (ve) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a vkVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new vk();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.weS = vkVar;
                    }
                    veVar.weT = true;
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new uq();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.weU.add(vkVar);
                    }
                    veVar.weV = true;
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new ux();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.wdZ = vkVar;
                    }
                    veVar.wea = true;
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new vt();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.web = vkVar;
                    }
                    veVar.wec = true;
                    return 0;
                case 5:
                    veVar.iIj = aVar3.Avy.readString();
                    veVar.weh = true;
                    return 0;
                case 6:
                    veVar.title = aVar3.Avy.readString();
                    veVar.wcC = true;
                    return 0;
                case 7:
                    veVar.desc = aVar3.Avy.readString();
                    veVar.wcD = true;
                    return 0;
                case 8:
                    veVar.wei = aVar3.Avy.rz();
                    veVar.wej = true;
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new vd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.wed = vkVar;
                    }
                    veVar.wee = true;
                    return 0;
                case 11:
                    veVar.vCV = aVar3.Avy.rz();
                    veVar.wem = true;
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new vn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.wef = vkVar;
                    }
                    veVar.weg = true;
                    return 0;
                case 13:
                    veVar.version = aVar3.Avy.ry();
                    veVar.weW = true;
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        vkVar = new uy();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = vkVar.a(aVar4, vkVar, a.a(aVar4))) {
                        }
                        veVar.vCU = vkVar;
                    }
                    veVar.wen = true;
                    return 0;
                case 91:
                    veVar.wek = aVar3.Avy.ry();
                    veVar.wel = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
