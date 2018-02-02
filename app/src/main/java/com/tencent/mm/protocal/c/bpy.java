package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpy extends bdf {
    public String ksU;
    public String ngo;
    public int pbl;
    public int vIB;
    public int vIC;
    public int vID;
    public String vZq;
    public String wRD;

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
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.vZq != null) {
                aVar.g(3, this.vZq);
            }
            if (this.wRD != null) {
                aVar.g(4, this.wRD);
            }
            if (this.ksU != null) {
                aVar.g(5, this.ksU);
            }
            aVar.fU(6, this.vIB);
            aVar.fU(7, this.vIC);
            aVar.fU(8, this.vID);
            aVar.fU(9, this.pbl);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.vZq != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZq);
            }
            if (this.wRD != null) {
                r0 += e.a.a.b.b.a.h(4, this.wRD);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksU);
            }
            return (((r0 + e.a.a.a.fR(6, this.vIB)) + e.a.a.a.fR(7, this.vIC)) + e.a.a.a.fR(8, this.vID)) + e.a.a.a.fR(9, this.pbl);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
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
            bpy com_tencent_mm_protocal_c_bpy = (bpy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bpy.wJr = feVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bpy.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bpy.vZq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bpy.wRD = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bpy.ksU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bpy.vIB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bpy.vIC = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bpy.vID = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bpy.pbl = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
