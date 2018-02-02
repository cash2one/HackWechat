package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.af.a;
import com.tencent.mm.ui.chatting.viewitems.af.b;
import com.tencent.mm.ui.chatting.viewitems.al.e;
import com.tencent.mm.ui.chatting.viewitems.al.f;
import com.tencent.mm.ui.chatting.viewitems.al.g;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.mm.ui.chatting.viewitems.i.c;
import com.tencent.mm.ui.chatting.viewitems.n.j;
import java.util.ArrayList;
import java.util.List;

public final class as {
    private static final List<b> yOL;

    public static b bs(au auVar) {
        for (b bVar : yOL) {
            if (bVar.aj(auVar.getType(), auVar.field_isSend == 1)) {
                try {
                    return (b) bVar.getClass().newInstance();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Chatting.ItemFactory", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public static int cvD() {
        return yOL.size() + 2;
    }

    public static int bt(au auVar) {
        for (int i = 0; i < yOL.size(); i++) {
            if (((b) yOL.get(i)).aj(auVar.getType(), auVar.field_isSend == 1)) {
                return i;
            }
        }
        return 0;
    }

    static {
        List arrayList = new ArrayList();
        yOL = arrayList;
        arrayList.add(new b());
        yOL.add(new a());
        yOL.add(new c$e());
        yOL.add(new d());
        yOL.add(new c());
        yOL.add(new i.b());
        yOL.add(new l$c());
        yOL.add(new l.b());
        yOL.add(new h.d());
        yOL.add(new h.c());
        yOL.add(new ac());
        yOL.add(new x.b());
        yOL.add(new s$b());
        yOL.add(new s.a());
        yOL.add(new ah$a());
        yOL.add(new ah$b());
        yOL.add(new z.a());
        yOL.add(new o.c());
        yOL.add(new o.b());
        yOL.add(new t.a());
        yOL.add(new ag.b());
        yOL.add(new ag.a());
        yOL.add(new y$b());
        yOL.add(new y$a());
        yOL.add(new f());
        yOL.add(new al.c());
        yOL.add(new g());
        yOL.add(new j());
        yOL.add(new al.d());
        yOL.add(new e());
        yOL.add(new ak());
        yOL.add(new ai());
        yOL.add(new aj());
        yOL.add(new ab.a());
        yOL.add(new ab.b());
        yOL.add(new am.c());
        yOL.add(new am$b());
        yOL.add(new q());
        yOL.add(new j.b());
        yOL.add(new j.c());
        yOL.add(new u());
        yOL.add(new v());
        yOL.add(new w());
        yOL.add(new k.c());
        yOL.add(new k.b());
        yOL.add(new d.c());
        yOL.add(new d.b());
        yOL.add(new g.c());
        yOL.add(new g.b());
        yOL.add(new e$c());
        yOL.add(new e.b());
        yOL.add(new f.c());
        yOL.add(new f.b());
        yOL.add(new m.b());
        yOL.add(new m.a());
        yOL.add(new x.a());
        yOL.add(new 1());
        yOL.add(new 2());
    }
}
