package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    public List<WeakReference<a>> kIv;
    private String qov;

    public interface a {
        void brL();
    }

    public f() {
        this.kIv = new ArrayList();
        this.qov = "";
        this.qov = com.tencent.mm.plugin.shake.c.c.a.brX();
    }

    public final void e(String str, long j, int i) {
        d dVar = null;
        x.i("MicroMsg.ShakeCardMsgMgr", "msg_id is " + j);
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            return;
        }
        Map y;
        if (i == 0) {
            b bVar;
            x.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            y = bi.y(str, "sysmsg");
            if (y != null) {
                b bVar2 = new b();
                String str2 = (String) y.get(".sysmsg.begintime");
                if (TextUtils.isEmpty(str2) || !wP(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is " + str2);
                    bVar2.qow = 0;
                } else {
                    bVar2.qow = Integer.valueOf(str2).intValue();
                }
                str2 = (String) y.get(".sysmsg.endtime");
                if (TextUtils.isEmpty(str2) || !wP(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is " + str2);
                    bVar2.qox = 0;
                } else {
                    bVar2.qox = Integer.valueOf(str2).intValue();
                }
                bVar2.qoy = (String) y.get(".sysmsg.entrancename");
                str2 = (String) y.get(".sysmsg.activitytype");
                if (TextUtils.isEmpty(str2) || !wP(str2)) {
                    bVar2.qoz = 1;
                } else {
                    bVar2.qoz = Integer.valueOf(str2).intValue();
                }
                x.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is " + str2);
                str2 = (String) y.get(".sysmsg.flowcontrollevelmin");
                if (TextUtils.isEmpty(str2) || !wP(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is " + str2);
                    bVar2.qoA = 0;
                } else {
                    bVar2.qoA = Integer.valueOf(str2).intValue();
                }
                bVar2.qoC = (String) y.get(".sysmsg.shakecardentrancetip");
                str2 = (String) y.get(".sysmsg.flowcontrollevelmax");
                if (TextUtils.isEmpty(str2) || !wP(str2)) {
                    x.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is " + str2);
                    bVar2.qoB = 0;
                } else {
                    bVar2.qoB = Integer.valueOf(str2).intValue();
                }
                bVar = bVar2;
            }
            if (bVar == null) {
                x.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            } else {
                x.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
                if (!com.tencent.mm.plugin.shake.c.c.a.brx()) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
                }
                x.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + bVar.qow + "  endtime:" + bVar.qox + "  flowlevelmin:" + bVar.qoA + "  flowlevelmax:" + bVar.qoB + " entrancename:" + bVar.qoy + " activitytype:" + bVar.qoz);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmR, Integer.valueOf(bVar.qow));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmS, Integer.valueOf(bVar.qox));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmT, bVar.qoy);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmX, Integer.valueOf(bVar.qoz));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmU, Integer.valueOf(bVar.qoA));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmV, Integer.valueOf(bVar.qoB));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmW, bVar.qoC);
            }
            brK();
        } else if (i == 1) {
            x.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            y = bi.y(str, "sysmsg");
            if (y != null) {
                d dVar2 = new d();
                dVar2.qoD = (String) y.get(".sysmsg.reddotid");
                dVar2.qoE = (String) y.get(".sysmsg.reddotdesc");
                dVar2.qoF = (String) y.get(".sysmsg.reddottext");
                dVar = dVar2;
            }
            if (dVar == null) {
                x.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            } else {
                x.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + dVar.qoD);
                x.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.qov);
                if (TextUtils.isEmpty(dVar.qoD)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
                } else if (TextUtils.isEmpty(this.qov)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
                    com.tencent.mm.s.c.Bq().p(262154, true);
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xmY, dVar.qoD);
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xmZ, dVar.qoE);
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xna, dVar.qoF);
                    asi();
                } else if (!this.qov.equals(dVar.qoD)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
                    com.tencent.mm.s.c.Bq().p(262154, true);
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xmY, dVar.qoD);
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xmZ, dVar.qoE);
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.xna, dVar.qoF);
                    asi();
                } else if (this.qov.equals(dVar.qoD)) {
                    x.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
                }
            }
            brK();
        }
        com.tencent.mm.plugin.shake.c.c.a.brw();
    }

    private static void brK() {
        com.tencent.mm.sdk.b.a.xef.m(new pb());
    }

    private static boolean wP(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void asi() {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.brL();
                    }
                }
            }
        }
    }
}
