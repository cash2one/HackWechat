package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.fe;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bj extends bdf {
    public String nhK;
    public ao nig;
    public ay nih;
    public j nii;
    public dr nij;
    public ec nik;
    public am nil;
    public cq nim;
    public cp nin;
    public cw nio;
    public q nip;
    public t niq;
    public String nir;
    public int nis;
    public boolean nit;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            if (this.nig != null) {
                aVar.fW(2, this.nig.bke());
                this.nig.a(aVar);
            }
            if (this.nih != null) {
                aVar.fW(3, this.nih.bke());
                this.nih.a(aVar);
            }
            if (this.nhK != null) {
                aVar.g(4, this.nhK);
            }
            if (this.nii != null) {
                aVar.fW(5, this.nii.bke());
                this.nii.a(aVar);
            }
            if (this.nij != null) {
                aVar.fW(6, this.nij.bke());
                this.nij.a(aVar);
            }
            if (this.nik != null) {
                aVar.fW(7, this.nik.bke());
                this.nik.a(aVar);
            }
            if (this.nil != null) {
                aVar.fW(8, this.nil.bke());
                this.nil.a(aVar);
            }
            if (this.nim != null) {
                aVar.fW(9, this.nim.bke());
                this.nim.a(aVar);
            }
            if (this.nin != null) {
                aVar.fW(10, this.nin.bke());
                this.nin.a(aVar);
            }
            if (this.nio != null) {
                aVar.fW(11, this.nio.bke());
                this.nio.a(aVar);
            }
            if (this.nip != null) {
                aVar.fW(12, this.nip.bke());
                this.nip.a(aVar);
            }
            if (this.niq != null) {
                aVar.fW(13, this.niq.bke());
                this.niq.a(aVar);
            }
            if (this.nir != null) {
                aVar.g(14, this.nir);
            }
            aVar.fU(15, this.nis);
            aVar.al(16, this.nit);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nig != null) {
                r0 += e.a.a.a.fT(2, this.nig.bke());
            }
            if (this.nih != null) {
                r0 += e.a.a.a.fT(3, this.nih.bke());
            }
            if (this.nhK != null) {
                r0 += e.a.a.b.b.a.h(4, this.nhK);
            }
            if (this.nii != null) {
                r0 += e.a.a.a.fT(5, this.nii.bke());
            }
            if (this.nij != null) {
                r0 += e.a.a.a.fT(6, this.nij.bke());
            }
            if (this.nik != null) {
                r0 += e.a.a.a.fT(7, this.nik.bke());
            }
            if (this.nil != null) {
                r0 += e.a.a.a.fT(8, this.nil.bke());
            }
            if (this.nim != null) {
                r0 += e.a.a.a.fT(9, this.nim.bke());
            }
            if (this.nin != null) {
                r0 += e.a.a.a.fT(10, this.nin.bke());
            }
            if (this.nio != null) {
                r0 += e.a.a.a.fT(11, this.nio.bke());
            }
            if (this.nip != null) {
                r0 += e.a.a.a.fT(12, this.nip.bke());
            }
            if (this.niq != null) {
                r0 += e.a.a.a.fT(13, this.niq.bke());
            }
            if (this.nir != null) {
                r0 += e.a.a.b.b.a.h(14, this.nir);
            }
            return (r0 + e.a.a.a.fR(15, this.nis)) + (e.a.a.b.b.a.dX(16) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bj bjVar = (bj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ao();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nig = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nih = feVar;
                    }
                    return 0;
                case 4:
                    bjVar.nhK = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new j();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nii = feVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new dr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nij = feVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new ec();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nik = feVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new am();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nil = feVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new cq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nim = feVar;
                    }
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nin = feVar;
                    }
                    return 0;
                case 11:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new cw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nio = feVar;
                    }
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.nip = feVar;
                    }
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        bjVar.niq = feVar;
                    }
                    return 0;
                case 14:
                    bjVar.nir = aVar3.Avy.readString();
                    return 0;
                case 15:
                    bjVar.nis = aVar3.Avy.ry();
                    return 0;
                case 16:
                    bjVar.nit = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
