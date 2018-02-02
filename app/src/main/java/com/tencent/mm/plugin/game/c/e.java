package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public int ktM;
    public int ktm;
    public boolean nfA;
    public cu nfB;
    public int nfC;
    public cg nfD;
    public LinkedList<String> nfE = new LinkedList();
    public String nfe;
    public String nfj;
    public String nfl;
    public String nfn;
    public String nfo;
    public String nfp;
    public String nfq;
    public String nfr;
    public int nfs;
    public r nft;
    public int nfu;
    public boolean nfv;
    public LinkedList<String> nfw = new LinkedList();
    public boolean nfx;
    public boolean nfy;
    public boolean nfz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.nfo == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                if (this.nfn != null) {
                    aVar.g(1, this.nfn);
                }
                if (this.nfo != null) {
                    aVar.g(2, this.nfo);
                }
                if (this.nfp != null) {
                    aVar.g(3, this.nfp);
                }
                if (this.nfe != null) {
                    aVar.g(4, this.nfe);
                }
                if (this.nfq != null) {
                    aVar.g(5, this.nfq);
                }
                if (this.nfj != null) {
                    aVar.g(6, this.nfj);
                }
                if (this.nfr != null) {
                    aVar.g(7, this.nfr);
                }
                aVar.fU(8, this.nfs);
                if (this.nft != null) {
                    aVar.fW(9, this.nft.bke());
                    this.nft.a(aVar);
                }
                aVar.fU(10, this.ktm);
                aVar.fU(11, this.nfu);
                if (this.nfl != null) {
                    aVar.g(12, this.nfl);
                }
                aVar.al(13, this.nfv);
                aVar.d(14, 1, this.nfw);
                aVar.al(15, this.nfx);
                aVar.fU(16, this.ktM);
                aVar.al(17, this.nfy);
                aVar.al(18, this.nfz);
                aVar.al(19, this.nfA);
                if (this.nfB != null) {
                    aVar.fW(20, this.nfB.bke());
                    this.nfB.a(aVar);
                }
                aVar.fU(21, this.nfC);
                if (this.nfD != null) {
                    aVar.fW(22, this.nfD.bke());
                    this.nfD.a(aVar);
                }
                aVar.d(23, 1, this.nfE);
                return 0;
            }
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfo != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfo);
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfp);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.nfq != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfq);
            }
            if (this.nfj != null) {
                r0 += e.a.a.b.b.a.h(6, this.nfj);
            }
            if (this.nfr != null) {
                r0 += e.a.a.b.b.a.h(7, this.nfr);
            }
            r0 += e.a.a.a.fR(8, this.nfs);
            if (this.nft != null) {
                r0 += e.a.a.a.fT(9, this.nft.bke());
            }
            r0 = (r0 + e.a.a.a.fR(10, this.ktm)) + e.a.a.a.fR(11, this.nfu);
            if (this.nfl != null) {
                r0 += e.a.a.b.b.a.h(12, this.nfl);
            }
            r0 = ((((((r0 + (e.a.a.b.b.a.dX(13) + 1)) + e.a.a.a.c(14, 1, this.nfw)) + (e.a.a.b.b.a.dX(15) + 1)) + e.a.a.a.fR(16, this.ktM)) + (e.a.a.b.b.a.dX(17) + 1)) + (e.a.a.b.b.a.dX(18) + 1)) + (e.a.a.b.b.a.dX(19) + 1);
            if (this.nfB != null) {
                r0 += e.a.a.a.fT(20, this.nfB.bke());
            }
            r0 += e.a.a.a.fR(21, this.nfC);
            if (this.nfD != null) {
                r0 += e.a.a.a.fT(22, this.nfD.bke());
            }
            return r0 + e.a.a.a.c(23, 1, this.nfE);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nfw.clear();
            this.nfE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfn == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.nfo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a rVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    eVar.nfo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    eVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    eVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    eVar.nfq = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eVar.nfj = aVar3.Avy.readString();
                    return 0;
                case 7:
                    eVar.nfr = aVar3.Avy.readString();
                    return 0;
                case 8:
                    eVar.nfs = aVar3.Avy.ry();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        rVar = new r();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rVar.a(aVar4, rVar, a.a(aVar4))) {
                        }
                        eVar.nft = rVar;
                    }
                    return 0;
                case 10:
                    eVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 11:
                    eVar.nfu = aVar3.Avy.ry();
                    return 0;
                case 12:
                    eVar.nfl = aVar3.Avy.readString();
                    return 0;
                case 13:
                    eVar.nfv = aVar3.cJC();
                    return 0;
                case 14:
                    eVar.nfw.add(aVar3.Avy.readString());
                    return 0;
                case 15:
                    eVar.nfx = aVar3.cJC();
                    return 0;
                case 16:
                    eVar.ktM = aVar3.Avy.ry();
                    return 0;
                case 17:
                    eVar.nfy = aVar3.cJC();
                    return 0;
                case 18:
                    eVar.nfz = aVar3.cJC();
                    return 0;
                case 19:
                    eVar.nfA = aVar3.cJC();
                    return 0;
                case 20:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        rVar = new cu();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rVar.a(aVar4, rVar, a.a(aVar4))) {
                        }
                        eVar.nfB = rVar;
                    }
                    return 0;
                case 21:
                    eVar.nfC = aVar3.Avy.ry();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        rVar = new cg();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rVar.a(aVar4, rVar, a.a(aVar4))) {
                        }
                        eVar.nfD = rVar;
                    }
                    return 0;
                case 23:
                    eVar.nfE.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
