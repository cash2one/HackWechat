package com.tencent.mm.bf;

import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> mP(String str) {
        ArrayList<String> arrayList = new ArrayList();
        h[] V = l.Ty().V(str, 10);
        if (V != null) {
            for (h hVar : V) {
                arrayList.add(hVar.field_sayhicontent);
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> mQ(String str) {
        ArrayList<String> arrayList = new ArrayList();
        j[] W = l.Tz().W(str, 10);
        if (W != null) {
            for (j jVar : W) {
                arrayList.add(jVar.field_sayhicontent);
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> mR(String str) {
        ArrayList<String> arrayList = new ArrayList();
        ar.Hg();
        Cursor EG = c.Fa().EG(str);
        if (!(EG == null || EG.getCount() == 0)) {
            if (EG.moveToFirst()) {
                int i = 0;
                while (!EG.isAfterLast()) {
                    cf auVar = new au();
                    auVar.b(EG);
                    EG.moveToNext();
                    if (auVar.cjg()) {
                        arrayList.add(auVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            EG.close();
        }
        return arrayList;
    }

    public static ArrayList<String> x(int i, String str) {
        ArrayList<String> arrayList = new ArrayList();
        f[] U = l.Tw().U(str, 10);
        if (U != null) {
            for (f fVar : U) {
                if (fVar.field_type == 1) {
                    arrayList.add(bh.ou(d.Xu(fVar.field_msgContent).content));
                }
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[]{Integer.valueOf(i)});
        return arrayList;
    }

    public static ArrayList<au> b(long[] jArr) {
        ArrayList<au> arrayList = new ArrayList();
        if (jArr != null) {
            for (long dH : jArr) {
                ar.Hg();
                arrayList.add(c.Fa().dH(dH));
            }
        }
        return arrayList;
    }
}
