package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.byv;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED));
        arrayList.add(Integer.valueOf(11010));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11010:
                byv com_tencent_mm_protocal_c_byv = new byv();
                try {
                    com_tencent_mm_protocal_c_byv.aF(bArr);
                } catch (IOException e) {
                }
                a.bOt().thJ.ct(com_tencent_mm_protocal_c_byv.wYG, com_tencent_mm_protocal_c_byv.wYS);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                ar.Hg();
                x WO = c.EY().WO(str);
                if (s.eV(str)) {
                    ar.Hg();
                    WO = c.EY().WO(str);
                    WO.eH(0);
                    ar.Hg();
                    c.EY().a(str, WO);
                    ar.Hg();
                    c.EX().b(new com.tencent.mm.ay.k(str, 0));
                } else {
                    s.n(WO);
                }
                com.tencent.mm.plugin.wear.model.c.a.ee(4, 0);
                break;
        }
        return null;
    }
}
