package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u {
    public static final b tWi = new b();
    public static final j tWj = new j();
    public static final c tWk = new c();
    public static final l tWl = new l();
    public static final h tWm = new h();
    public static final ArrayList<t> tWn;

    static {
        ArrayList arrayList = new ArrayList();
        tWn = arrayList;
        arrayList.add(tWi);
        tWn.add(tWk);
        tWn.add(tWl);
        tWn.add(tWj);
    }

    public static void a(WXRTEditText wXRTEditText, t... tVarArr) {
        a(wXRTEditText, tWm, tVarArr);
        a(wXRTEditText, tWk, tVarArr);
        a(wXRTEditText, tWl, tVarArr);
        a(wXRTEditText, tWj, tVarArr);
    }

    private static void a(WXRTEditText wXRTEditText, o oVar, t... tVarArr) {
        int length = tVarArr.length;
        int i = 0;
        while (i < length) {
            if (oVar != tVarArr[i]) {
                i++;
            } else {
                return;
            }
        }
        oVar.a(wXRTEditText, null, null);
    }
}
