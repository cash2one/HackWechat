package com.tencent.mm.platformtools;

import com.tencent.mm.bq.b;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;

public final class n {
    public static bdn N(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(bArr);
        return com_tencent_mm_protocal_c_bdn;
    }

    public static byte[] a(bdn com_tencent_mm_protocal_c_bdn) {
        if (com_tencent_mm_protocal_c_bdn == null || com_tencent_mm_protocal_c_bdn.wJD == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_bdn.wJD.toByteArray();
    }

    public static byte[] a(bdn com_tencent_mm_protocal_c_bdn, byte[] bArr) {
        return (com_tencent_mm_protocal_c_bdn == null || com_tencent_mm_protocal_c_bdn.wJD == null) ? bArr : com_tencent_mm_protocal_c_bdn.wJD.toByteArray();
    }

    public static String a(bdo com_tencent_mm_protocal_c_bdo) {
        if (com_tencent_mm_protocal_c_bdo == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_bdo.wJF;
    }

    public static bdo os(String str) {
        if (str == null) {
            return null;
        }
        bdo com_tencent_mm_protocal_c_bdo = new bdo();
        com_tencent_mm_protocal_c_bdo.UA(str);
        return com_tencent_mm_protocal_c_bdo;
    }

    public static String a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.cdp();
    }

    public static String b(bdn com_tencent_mm_protocal_c_bdn) {
        if (com_tencent_mm_protocal_c_bdn == null || com_tencent_mm_protocal_c_bdn.wJD == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_bdn.wJD.cdp();
    }
}
