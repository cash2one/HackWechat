package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.plugin.biz.b$a;
import com.tencent.mm.sdk.platformtools.bh;

public final class d implements n {
    public final boolean Sm(String str) {
        return f.eE(str);
    }

    public final Object Sn(String str) {
        Object ca = y.Mj().ca(str);
        if (ca != null && !bh.ov(ca.field_userId) && ca.field_userId.equals(str)) {
            return ca;
        }
        j jVar = new j();
        jVar.field_userId = str;
        return jVar;
    }

    public final c So(String str) {
        a aVar = new a();
        aVar.hDD = e.ku(str);
        aVar.hDA = true;
        aVar.hDX = true;
        aVar.hDP = b$a.bBB;
        return aVar.PK();
    }

    public final String bP(Object obj) {
        return ((j) obj).field_userName;
    }

    public final String bQ(Object obj) {
        return ((j) obj).field_headImageUrl;
    }

    public final String bR(Object obj) {
        return ((j) obj).field_userId;
    }
}
