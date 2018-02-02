package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class j extends b {
    public static boolean oxo = false;
    public static j qpT;
    private boolean fni = false;
    public a qpS = new a();
    private long qpU;

    static /* synthetic */ boolean a(j jVar, String str) {
        List arrayList = new ArrayList();
        e Jl = e.Jl(str);
        if (Jl == null || Jl.hOf == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse url fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parse url: link=" + Jl.hOf + ", title=" + Jl.title + ", thumburl=" + Jl.thumbUrl);
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
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean b(j jVar, String str) {
        f Jm = f.Jm(str);
        List arrayList = new ArrayList();
        if (Jm == null || Jm.userName == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse user fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parse user: username=" + Jm.userName + ", nickname=" + Jm.bgo + ", showchat=" + Jm.qqa);
        d dVar = new d();
        dVar.field_username = Jm.userName;
        dVar.field_nickname = Jm.bgo;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = Jm.qqa;
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(j jVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeMusicMgr";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            jVar.e(arrayList, 2);
            return false;
        }
        a Jo = c.Jo(str);
        if (Jo == null) {
            x.e("Micromsg.ShakeMusicMgr", "shakeTV resCallback xml error");
            jVar.e(arrayList, 4);
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
            x.d("Micromsg.ShakeMusicMgr", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + brs.field_reserved2);
            m.brC().vZ(brs.field_shakeItemID);
        }
        m.brC().a(dVar, true);
        jVar.e(arrayList, 1);
        x.d("Micromsg.ShakeMusicMgr", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(j jVar, String str) {
        List arrayList = new ArrayList();
        m.b Ji = m.b.Ji(str);
        if (Ji == null || Ji.qpY == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse pay fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + Ji.qpY + ", title=" + Ji.title + ", thumbUrl=" + Ji.thumbUrl);
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
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean e(j jVar, String str) {
        List arrayList = new ArrayList();
        m.c Jj = m.c.Jj(str);
        if (Jj == null || Jj.id == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse product fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + Jj.id + ", title=" + Jj.title + ", thumbUrl=" + Jj.thumbUrl);
        d dVar = new d();
        dVar.field_username = Jj.id;
        dVar.field_nickname = Jj.title;
        dVar.field_sns_bgurl = Jj.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.brC().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    public static j a(l.a aVar) {
        if (qpT == null || qpT.qnR == null) {
            qpT = new j(aVar);
        }
        return qpT;
    }

    private j(l.a aVar) {
        super(aVar);
    }

    public final void start() {
        if (this.qnR == null) {
            x.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        this.qpU = System.currentTimeMillis();
        this.qpS.a(367, new 1(this));
    }

    public final void init() {
        if (!oxo) {
            if (this.qpS.bsc()) {
                oxo = true;
            } else {
                x.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void brp() {
        this.qpS.vi();
        super.brp();
    }

    public final void resume() {
    }

    private void e(List<d> list, long j) {
        if (this.qnR != null) {
            this.qnR.d(list, j);
        }
    }
}
