package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p {
    public static void a(String str, d dVar) {
        if (dVar != null) {
            b(str, dVar);
        }
    }

    public static void b(String str, d dVar) {
        if (!bh.ov(str) && dVar != null) {
            blu mN = mN(str);
            dVar.q("Source", (mN == null ? -1 : mN.cOY) + ",");
            dVar.q("SnsStatExt", a(mN));
        }
    }

    public static blu mN(String str) {
        if (bh.ov(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        blt com_tencent_mm_protocal_c_blt = new blt();
        try {
            com_tencent_mm_protocal_c_blt.aF(decode);
        } catch (Exception e) {
            x.e("MicroMsg.SnsStatExtUtil", "", new Object[]{e});
        }
        return com_tencent_mm_protocal_c_blt.wPl;
    }

    public static String a(String str, PString pString) {
        if (bh.ov(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        blt com_tencent_mm_protocal_c_blt = new blt();
        try {
            com_tencent_mm_protocal_c_blt.aF(decode);
            String str2 = com_tencent_mm_protocal_c_blt.wPl.wPp;
            String str3 = com_tencent_mm_protocal_c_blt.wPl.wPo;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(com_tencent_mm_protocal_c_blt.wPl.cOY), URLEncoder.encode(a(com_tencent_mm_protocal_c_blt.wPl), "UTF-8")});
            pString.value = com_tencent_mm_protocal_c_blt.wPn == null ? "" : com_tencent_mm_protocal_c_blt.wPn.nbS;
            return str2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String a(blu com_tencent_mm_protocal_c_blu) {
        if (com_tencent_mm_protocal_c_blu != null) {
            String str = com_tencent_mm_protocal_c_blu.wPp;
            String str2 = "";
            if (!bh.ov(str)) {
                String[] split = str.split("\\|");
                if (split != null && split.length > 0) {
                    str2 = split[0];
                }
            }
            try {
                return String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_blu.wPq), URLEncoder.encode(str2, "UTF-8"), com_tencent_mm_protocal_c_blu.wPo});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.SnsStatExtUtil", "", new Object[]{e});
            }
        }
        return "";
    }

    public static String z(au auVar) {
        if (auVar == null) {
            return "";
        }
        String str = null;
        if (auVar.aNc()) {
            a fT = a.fT(auVar.field_content);
            if (fT == null || bh.ov(fT.fGG)) {
                return "";
            }
            str = fT.fGG;
        }
        if (!auVar.cji()) {
            return str;
        }
        r nF = t.nF(auVar.field_imgPath);
        if (nF == null || bh.ov(nF.fGG)) {
            return "";
        }
        return nF.fGG;
    }
}
