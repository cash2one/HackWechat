package com.tencent.mm.ui.bizchat;

import android.content.Context;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.contact.a.a$b;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static Map<String, c> ynj = new HashMap();
    public CharSequence iil;
    public long kGB = -1;
    public String username;
    public String yni;
    private b ynk = new b(this);
    a ynl = new a(this);

    static /* synthetic */ c YV(String str) {
        if (str == null) {
            return null;
        }
        if (ynj.containsKey(str) && ynj.get(str) != null) {
            return (c) ynj.get(str);
        }
        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
        com_tencent_mm_aq_a_a_c_a.hDD = com.tencent.mm.api.a.bZ(str);
        com_tencent_mm_aq_a_a_c_a.hDA = true;
        com_tencent_mm_aq_a_a_c_a.hDX = true;
        com_tencent_mm_aq_a_a_c_a.hDP = g.bBB;
        c PK = com_tencent_mm_aq_a_a_c_a.PK();
        ynj.put(str, PK);
        return PK;
    }

    public a(int i) {
        super(4, i);
    }

    public final void bH(Context context) {
        this.iil = i.c(context, this.iil, com.tencent.mm.bv.a.aa(context, com.tencent.mm.plugin.selectcontact.a.c.bvK));
    }

    public final a$b WQ() {
        return this.ynk;
    }

    protected final com.tencent.mm.ui.contact.a.a.a WR() {
        return this.ynl;
    }
}
