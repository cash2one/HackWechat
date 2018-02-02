package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.protocal.c.byk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public byj tiP;

    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        if (i != TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN) {
            return null;
        }
        a.ee(1, 0);
        a.zA(0);
        b tkVar = new tk();
        tkVar.fLY.fLZ = ac.getContext().getResources().getStringArray(R.c.bqQ);
        tkVar.fLY.fpr = 1;
        com.tencent.mm.sdk.b.a.xef.m(tkVar);
        byte[] aW = com.tencent.mm.plugin.wear.model.a.bOt().thH.aW(bArr);
        if (aW == null) {
            return null;
        }
        try {
            byj com_tencent_mm_protocal_c_byj = new byj();
            com_tencent_mm_protocal_c_byj.aF(aW);
            byk com_tencent_mm_protocal_c_byk = new byk();
            int i2 = 20;
            String str = null;
            while (i2 > 0) {
                str = q.FS();
                if (bh.ov(str)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    i2--;
                }
            }
            if (bh.ov(str)) {
                return null;
            }
            com_tencent_mm_protocal_c_byk.vIy = str;
            str = w.e(ac.getContext().getSharedPreferences(ac.cfs(), 0));
            String cfi = w.cfi();
            if (str.equals("language_default")) {
                com_tencent_mm_protocal_c_byk.lOo = cfi;
            } else {
                com_tencent_mm_protocal_c_byk.lOo = str;
            }
            aW = com.tencent.mm.plugin.wear.model.a.bOt().thH.aX(com_tencent_mm_protocal_c_byk.toByteArray());
            if (aW == null) {
                return null;
            }
            this.tiP = com_tencent_mm_protocal_c_byj;
            b tlVar = new tl();
            tlVar.fMa.fpr = 9;
            com.tencent.mm.sdk.b.a.xef.a(tlVar, Looper.getMainLooper());
            return aW;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
            return null;
        }
    }
}
