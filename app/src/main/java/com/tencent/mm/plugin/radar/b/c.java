package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import b.c.b.e;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c implements b {
    private static final String TAG = TAG;
    public static final b pwC = new b((byte) 0);
    final Context context;
    private final af handler = new af();
    public final g pwA = new g(this);
    final c pwB;
    private final LinkedList<String> pwx = new LinkedList();
    public final HashMap<String, String> pwy = new HashMap();
    public final i pwz = new i(this);

    public c(c cVar, Context context) {
        e.i(cVar, "delegate");
        e.i(context, "context");
        this.pwB = cVar;
        this.context = context;
    }

    public static final /* synthetic */ x a(d dVar) {
        x xVar = new x();
        if (dVar != null) {
            xVar.setUsername(dVar.cjJ());
            xVar.di(dVar.cjM());
            xVar.cZ(dVar.vN());
            xVar.dc(dVar.vP());
            xVar.dd(dVar.vQ());
            xVar.de(dVar.vR());
            xVar.eD(dVar.cjK());
            xVar.dp(dVar.cjL());
            xVar.dq(dVar.getProvince());
            xVar.dr(dVar.getCity());
        } else {
            com.tencent.mm.sdk.platformtools.x.e(TAG, "verify is null! must be parsed error before!");
        }
        return xVar;
    }

    public static final /* synthetic */ void a(c cVar, x xVar, String str) {
        cVar.pwy.put(xVar.getUsername(), str);
        cVar.pwy.put(xVar.vS(), str);
    }

    public static final /* synthetic */ void bU(String str, int i) {
        fl flVar = new fl();
        flVar.fuJ.fuL = 0;
        flVar.fuJ.talker = str;
        flVar.fuJ.state = i;
        a.xef.m(flVar);
    }

    public final long HY(String str) {
        e.i(str, "username");
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this, new f(this, str, currentTimeMillis));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.pwE = linkedList;
        aVar.jKk = str;
        if (str != null) {
            aVar.pwD.add(str);
        }
        g.CG().d(new o(2, aVar.pwD, linkedList, "", ""));
        return currentTimeMillis;
    }

    public final e HZ(String str) {
        e eVar;
        e.i(str, "username");
        com.tencent.mm.kernel.c.a h = g.h(h.class);
        e.h(h, "service(IMessengerStorage::class.java)");
        x WO = ((h) h).EY().WO(str);
        if (WO == null || WO.AO() == 0) {
            if (this.pwx.contains(str)) {
                eVar = e.pwI;
            } else {
                eVar = e.pwH;
            }
        } else if (WO.AC()) {
            eVar = e.pwJ;
        } else if (this.pwy.containsKey(str)) {
            eVar = e.pwK;
        } else if (this.pwx.contains(str)) {
            eVar = e.pwI;
        } else {
            eVar = e.pwH;
        }
        com.tencent.mm.sdk.platformtools.x.d(TAG, "query username(%s) status %s", new Object[]{str, eVar});
        return eVar;
    }

    private final void H(x xVar) {
        if (this.pwx.contains(xVar.getUsername())) {
            this.pwx.remove(xVar.getUsername());
        }
        if (this.pwx.contains(xVar.vS())) {
            this.pwx.remove(xVar.vS());
        }
    }

    public final void a(int i, m mVar, Object obj) {
        e.i(mVar, "stg");
        com.tencent.mm.sdk.platformtools.x.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        com.tencent.mm.kernel.c.a h = g.h(h.class);
        e.h(h, "service(IMessengerStorage::class.java)");
        x WO = ((h) h).EY().WO(str);
        if (WO != null && WO.AC()) {
            com.tencent.mm.sdk.platformtools.x.d(TAG, "ContactStg onNotifyChange %s", new Object[]{str});
            I(WO);
        }
    }

    private final void I(x xVar) {
        H(xVar);
        this.pwy.remove(xVar.getUsername());
        this.pwy.remove(xVar.vS());
        this.handler.post(new j(this, xVar));
    }
}
