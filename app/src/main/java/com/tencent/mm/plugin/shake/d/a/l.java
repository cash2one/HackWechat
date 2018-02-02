package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends b {
    private static boolean bgH = false;
    private static boolean oxo = false;
    private Context context;
    private boolean fni = false;
    private a qpS = new a();
    private long qpU;

    static /* synthetic */ void Jg(String str) {
        c cVar;
        String[] strArr = null;
        if (bh.ov(str)) {
            cVar = null;
        } else {
            c cVar2;
            Map y = bi.y(str, "tvinfo");
            if (y != null) {
                String str2 = (String) y.get(".tvinfo.username");
                if (bh.ov(str2)) {
                    cVar = null;
                } else {
                    c nVar = new n();
                    nVar.field_username = str2;
                    nVar.field_iconurl = bh.ou((String) y.get(".tvinfo.iconurl"));
                    nVar.field_title = bh.ou((String) y.get(".tvinfo.title"));
                    nVar.field_deeplink = bh.ou((String) y.get(".tvinfo.deeplinkjumpurl"));
                    nVar.field_createtime = bh.getLong((String) y.get(".tvinfo.createtime"), 0);
                    cVar2 = nVar;
                }
            } else {
                cVar2 = null;
            }
            cVar = cVar2;
        }
        if (cVar != null) {
            o brE = m.brE();
            Cursor a = brE.gJP.a("shaketvhistory", null, "username=?", new String[]{cVar.field_username}, null, null, null, 2);
            if (a.moveToFirst()) {
                strArr = new n();
                strArr.b(a);
                a.close();
            } else {
                x.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:" + r10);
                a.close();
            }
            if (strArr != null) {
                x.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                brE = m.brE();
                if (bh.ov(cVar.field_username)) {
                    x.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    return;
                }
                brE.gJP.update("shaketvhistory", cVar.vI(), "username=?", new String[]{cVar.field_username});
                return;
            }
            x.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            m.brE().b(cVar);
        }
    }

    static /* synthetic */ boolean a(l lVar, String str) {
        List arrayList = new ArrayList();
        e Jl = e.Jl(str);
        if (Jl == null || Jl.hOf == null) {
            x.w("Micromsg.ShakeTVService", "parse url fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parse url: link=" + Jl.hOf + ", title=" + Jl.title + ", thumburl=" + Jl.thumbUrl);
        d dVar = new d();
        dVar.field_username = Jl.hOf;
        dVar.field_nickname = Jl.title;
        dVar.field_distance = Jl.fCU;
        dVar.field_sns_bgurl = Jl.thumbUrl;
        dVar.field_type = 7;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean b(l lVar, String str) {
        f Jm = f.Jm(str);
        List arrayList = new ArrayList();
        if (Jm == null || Jm.userName == null) {
            x.w("Micromsg.ShakeTVService", "parse user fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parse user: username=" + Jm.userName + ", nickname=" + Jm.bgo + ", showchat=" + Jm.qqa);
        d dVar = new d();
        dVar.field_username = Jm.userName;
        dVar.field_nickname = Jm.bgo;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = Jm.qqa;
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(l lVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeTVService";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            lVar.e(arrayList, 2);
            return false;
        }
        a Jo = com.tencent.mm.plugin.shake.e.c.Jo(str);
        if (Jo == null) {
            x.e("Micromsg.ShakeTVService", "shakeTV resCallback xml error");
            bgH = false;
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = bh.ou(Jo.field_subtitle);
        dVar.field_nickname = bh.ou(Jo.field_topic);
        dVar.field_distance = bh.ou(Jo.field_title);
        if (Jo.field_thumburl != null) {
            dVar.field_sns_bgurl = Jo.field_thumburl;
        }
        dVar.field_type = 8;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        dVar.field_reserved2 = (int) bh.Wo();
        arrayList.add(dVar);
        d brs = m.brC().brs();
        if (brs.field_type == 8 && dVar.field_distance.equals(brs.field_distance) && dVar.field_nickname.equals(brs.field_nickname) && dVar.field_reserved2 - brs.field_reserved2 < 1800) {
            x.d("Micromsg.ShakeTVService", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + brs.field_reserved2);
            m.brC().vZ(brs.field_shakeItemID);
        }
        m.brC().a(dVar, true);
        lVar.e(arrayList, 1);
        x.d("Micromsg.ShakeTVService", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(l lVar, String str) {
        List arrayList = new ArrayList();
        m$b Ji = m$b.Ji(str);
        if (Ji == null || Ji.qpY == null) {
            x.w("Micromsg.ShakeTVService", "parse pay fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + Ji.qpY + ", title=" + Ji.title + ", thumbUrl=" + Ji.thumbUrl);
        d dVar = new d();
        dVar.field_username = Ji.qpY;
        dVar.field_nickname = Ji.title;
        dVar.field_sns_bgurl = Ji.thumbUrl;
        dVar.field_distance = Ji.pbN;
        dVar.field_type = 9;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean e(l lVar, String str) {
        List arrayList = new ArrayList();
        m.c Jj = m.c.Jj(str);
        if (Jj == null || Jj.id == null) {
            x.w("Micromsg.ShakeTVService", "parse product fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + Jj.id + ", title=" + Jj.title + ", thumbUrl=" + Jj.thumbUrl);
        d dVar = new d();
        dVar.field_username = Jj.id;
        dVar.field_nickname = Jj.title;
        dVar.field_sns_bgurl = Jj.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean f(l lVar, String str) {
        List arrayList = new ArrayList();
        m.d Jk = m.d.Jk(str);
        if (Jk == null || bh.ov(Jk.qpZ)) {
            x.w("Micromsg.ShakeTVService", "parse TempSession fail");
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = Jk.qpZ;
        dVar.field_nickname = Jk.title;
        dVar.field_distance = Jk.username;
        dVar.field_sns_bgurl = Jk.thumbUrl;
        dVar.field_type = 12;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean g(l lVar, String str) {
        List arrayList = new ArrayList();
        m.a Jh = m.a.Jh(str);
        if (Jh == null || bh.ov(Jh.path)) {
            x.w("Micromsg.ShakeTVService", "parse appBrand fail");
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = Jh.username;
        dVar.field_nickname = Jh.title;
        dVar.field_reserved3 = Jh.path;
        dVar.field_sns_bgurl = Jh.thumbUrl;
        dVar.field_reserved2 = Jh.version;
        dVar.field_type = 13;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    public l(Context context, com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
        this.context = context;
        bgH = false;
    }

    public final void start() {
        if (this.qnR == null) {
            x.w("Micromsg.ShakeTVService", "shakeGetListener == null");
        } else if (this.context instanceof Activity) {
            bgH = true;
            this.qpU = System.currentTimeMillis();
            this.qpS.a(av.CTRL_INDEX, new 1(this));
        } else {
            x.e("Micromsg.ShakeTVService", "context not an Activity");
            this.qnR.d(new ArrayList(), 0);
        }
    }

    public final void init() {
        if (!oxo) {
            if (this.qpS.bsc()) {
                oxo = true;
            } else {
                x.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void brp() {
        super.brp();
        this.qpS.vi();
        if (bgH) {
            long currentTimeMillis = System.currentTimeMillis() - this.qpU;
            x.d("Micromsg.ShakeTVService", "destroyShakeMgr, costTime=%s, isRunning=%s", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(bgH)});
            g.pQN.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis)});
            bgH = false;
        }
    }

    public final void resume() {
    }

    private void e(List<d> list, long j) {
        if (this.qnR != null) {
            this.qnR.d(list, j);
        }
    }
}
