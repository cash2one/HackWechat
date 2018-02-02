package com.tencent.mm.ag;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends com.tencent.mm.sdk.e.i<g> {
    public static final String[] gJN = new String[]{com.tencent.mm.sdk.e.i.a(g.gJc, "BizKF")};
    public e gJP;

    public final /* synthetic */ boolean a(c cVar) {
        return b((g) cVar);
    }

    public i(e eVar) {
        super(eVar, g.gJc, "BizKF", null);
        this.gJP = eVar;
        eVar.fx("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        eVar.fx("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    }

    public final g kb(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gJP.a("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.b(a);
            a.close();
            return gVar;
        }
        x.w("MicroMsg.BizKFStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public static boolean a(g gVar) {
        if (gVar == null || System.currentTimeMillis() - gVar.field_updateTime < 86400000) {
            return false;
        }
        return true;
    }

    private boolean b(g gVar) {
        if (gVar == null || bh.ov(gVar.field_openId) || bh.ov(gVar.field_brandUsername)) {
            x.w("MicroMsg.BizKFStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.gJP.replace("BizKF", g.gJc.xjz, gVar.vI()) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[]{gVar.field_openId, gVar.field_brandUsername, Boolean.valueOf(z)});
        return z;
    }

    public final g kc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Cursor a = this.gJP.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.b(a);
            a.close();
            return gVar;
        }
        x.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + str);
        a.close();
        return null;
    }

    public final int d(LinkedList<g> linkedList) {
        if (linkedList.size() <= 0) {
            x.e("MicroMsg.BizKFStorage", "null kfs");
            return 0;
        }
        long dz;
        if (this.gJP instanceof h) {
            dz = ((h) this.gJP).dz(Thread.currentThread().getId());
        } else {
            dz = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            g gVar = (g) it.next();
            if (gVar == null || !b(gVar)) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        if (this.gJP instanceof h) {
            g.Dj().gQj.fS(dz);
        }
        x.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[]{Integer.valueOf(i)});
        return i;
    }
}
