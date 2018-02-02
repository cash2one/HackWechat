package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g.a;
import org.json.JSONObject;

public final class c {
    private static com.tencent.mm.aq.a.a.c lcT;

    static /* synthetic */ boolean a(a aVar, c cVar) {
        if (!h(aVar)) {
            return false;
        }
        JSONObject NT = h.NT("discoverRecommendEntry");
        CharSequence optString = NT.optString("wording");
        NT.optString("androidIcon");
        cVar.yIP.setVisibility(0);
        cVar.mxT.setVisibility(0);
        cVar.mxT.setText(optString);
        cVar.yIM.setVisibility(0);
        cVar.yIM.setImageResource(R.g.bGW);
        return true;
    }

    static {
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDy = true;
        aVar.hDA = true;
        lcT = aVar.PK();
    }

    private static boolean h(a aVar) {
        com.tencent.mm.plugin.webview.fts.topstory.a.a aVar2 = (com.tencent.mm.plugin.webview.fts.topstory.a.a) aVar.r(com.tencent.mm.plugin.webview.fts.topstory.a.a.class);
        if (aVar2 == null || bh.ov(aVar2.tnm)) {
            return false;
        }
        return true;
    }
}
