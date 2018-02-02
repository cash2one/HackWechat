package com.tencent.c.a;

import android.content.Context;
import com.tencent.c.b.a;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static a zRT = null;

    public static void a(Context context, a aVar) {
        if (zRT == null) {
            zRT = new a(context);
        }
        a aVar2 = zRT;
        try {
            List gr = com.tencent.c.f.a.gr(aVar2.mContext);
            if (gr.size() == 0) {
                aVar.e(-10, null);
                return;
            }
            com.tencent.c.c.b.a aVar3 = new com.tencent.c.c.b.a();
            aVar3.zSB = a.cDp();
            aVar3.zSz = new com.tencent.c.c.b.c();
            aVar3.zSz.zTc = 6;
            aVar3.zSz.zSt = 1;
            aVar3.zSz.requestType = 0;
            aVar3.zSz.zTd = 0;
            aVar3.zSz.zTe = 0;
            aVar3.zSz.zTf = null;
            aVar3.zSz.zTg = 0;
            aVar3.zSz.zTk = 1;
            aVar3.zSA = new ArrayList();
            for (int i = 0; i < gr.size(); i++) {
                aVar3.zSA.add(a.a(aVar2.mContext, (a) gr.get(i), i));
            }
            byte[] a = aVar2.zRW.a(aVar3);
            if (a == null) {
                aVar.e(-20, null);
            } else {
                aVar.e(0, a);
            }
        } catch (Throwable th) {
            aVar.e(-100, null);
        }
    }
}
