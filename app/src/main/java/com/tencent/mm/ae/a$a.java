package com.tencent.mm.ae;

import com.tencent.mm.protocal.c.bdf;

public class a$a<T extends bdf> {
    public int errCode;
    public int errType;
    public T fJJ;
    public String fnL;
    public k frb;
    public a hlZ;

    public static <T extends bdf> a$a<T> a(int i, int i2, String str, T t, k kVar, a aVar) {
        a$a<T> com_tencent_mm_ae_a_a = new a$a();
        com_tencent_mm_ae_a_a.errType = i;
        com_tencent_mm_ae_a_a.errCode = i2;
        com_tencent_mm_ae_a_a.fnL = str;
        com_tencent_mm_ae_a_a.fJJ = t;
        com_tencent_mm_ae_a_a.frb = kVar;
        com_tencent_mm_ae_a_a.hlZ = aVar;
        if (aVar != null) {
            aVar.a(i, i2, str, t, kVar);
        }
        return com_tencent_mm_ae_a_a;
    }
}
