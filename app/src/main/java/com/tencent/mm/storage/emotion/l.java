package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends i<k> implements a {
    public static final String[] gJN = new String[]{i.a(k.gJc, "EmotionRewardInfo")};
    public e gJP;

    public l(e eVar) {
        super(eVar, k.gJc, "EmotionRewardInfo", null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final acb Yb(String str) {
        acb com_tencent_mm_protocal_c_acb = null;
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.gJP.a("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                try {
                    acb com_tencent_mm_protocal_c_acb2 = new acb();
                    com_tencent_mm_protocal_c_acb2.aF(a.getBlob(0));
                    com_tencent_mm_protocal_c_acb = com_tencent_mm_protocal_c_acb2;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", new Object[]{bh.i(e)});
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return com_tencent_mm_protocal_c_acb;
    }
}
