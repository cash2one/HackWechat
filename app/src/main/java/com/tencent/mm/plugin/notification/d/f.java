package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.c.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f implements ap {
    private static f oUE = null;
    c oUF = null;
    c oUG = null;
    private a oUH = null;
    private boolean oUI = false;
    private com.tencent.mm.sdk.b.c oUJ = new 1(this);
    private com.tencent.mm.sdk.b.c oUK = new 2(this);
    private com.tencent.mm.sdk.b.c oUL = new 3(this);
    private com.tencent.mm.sdk.b.c oUM = new 4(this);
    private com.tencent.mm.sdk.b.c oUN = new 5(this);
    private com.tencent.mm.sdk.b.c oUO = new 6(this);

    private f() {
        b.init();
        if (this.oUG == null) {
            this.oUG = new e();
        }
        if (this.oUF == null) {
            this.oUF = new d();
        }
    }

    public static FailSendMsgNotification ul(int i) {
        if (i == 2 && bgH().oUG != null) {
            x.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            return bgH().oUG.bgt();
        } else if (i != 1 || bgH().oUF == null) {
            return null;
        } else {
            x.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            return bgH().oUF.bgt();
        }
    }

    public static f bgH() {
        if (oUE == null) {
            oUE = new f();
            ar.Ha().a("plugin.notification", oUE);
        }
        return oUE;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.oUF.bgC();
        this.oUF.bgD();
        this.oUG.bgC();
        this.oUG.bgD();
        if (this.oUH == null) {
            this.oUH = new a();
        }
        Object obj = this.oUH;
        if (ar.Hj()) {
            x.d("MicroMsg.NotificationObserver", "added");
            try {
                ar.Hg();
                com.tencent.mm.z.c.Fd().a(obj);
                obj.oTO = true;
            } catch (Throwable e) {
                x.e("MicroMsg.NotificationObserver", "exception:%s", bh.i(e));
            }
        } else {
            x.e("MicroMsg.NotificationObserver", "account not ready!");
        }
        com.tencent.mm.sdk.b.a.xef.b(this.oUJ);
        com.tencent.mm.sdk.b.a.xef.b(this.oUK);
        com.tencent.mm.sdk.b.a.xef.b(this.oUL);
        com.tencent.mm.sdk.b.a.xef.b(this.oUM);
        com.tencent.mm.sdk.b.a.xef.b(this.oUN);
        com.tencent.mm.sdk.b.a.xef.b(this.oUO);
        com.tencent.mm.k.f.zR();
        ar.getNotification().fl(com.tencent.mm.k.f.zU());
        ar.getNotification().aV(false);
        x.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        this.oUF.bgE();
        this.oUF.bgF();
        this.oUG.bgE();
        this.oUG.bgF();
        if (this.oUH != null) {
            b bVar = this.oUH;
            if (ar.Hj()) {
                try {
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().b(bVar);
                } catch (Throwable e) {
                    x.e("MicroMsg.NotificationObserver", "exception:%s", bh.i(e));
                }
            }
        }
        com.tencent.mm.sdk.b.a.xef.c(this.oUJ);
        com.tencent.mm.sdk.b.a.xef.c(this.oUK);
        com.tencent.mm.sdk.b.a.xef.c(this.oUL);
        com.tencent.mm.sdk.b.a.xef.c(this.oUM);
        com.tencent.mm.sdk.b.a.xef.c(this.oUN);
        com.tencent.mm.sdk.b.a.xef.c(this.oUO);
        ar.getNotification().fl(0);
        ar.getNotification().aV(true);
        x.d("MicroMsg.SubCoreNotification", "onAccountRelease");
    }

    public static boolean bgI() {
        return bgH().oUI;
    }

    public static ArrayList<Long> U(au auVar) {
        if (auVar == null) {
            return null;
        }
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(auVar.field_msgId, auVar);
        ArrayList aZp = ((h) g.h(h.class)).aZi().aZp();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = aZp.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((au) it.next()).field_msgId));
        }
        return arrayList;
    }
}
