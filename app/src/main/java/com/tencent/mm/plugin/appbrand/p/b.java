package com.tencent.mm.plugin.appbrand.p;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private static LinkedList<d> gBH = new LinkedList();
    private static HashSet<a> jRC = new HashSet();
    private static boolean jRD = false;
    private static boolean jRE = false;

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String gIx;
        final /* synthetic */ int jRF = 10;

        AnonymousClass1(String str, int i) {
            this.gIx = str;
        }

        public final void run() {
            q hD;
            b.gBH.clear();
            if (s.eV(this.gIx)) {
                hD = ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh().hD(this.gIx);
            } else {
                hD = null;
            }
            int i = 100;
            int i2 = 0;
            while (i >= 100 && b.gBH.size() < this.jRF) {
                Cursor bz = ((h) g.h(h.class)).aZi().bz(this.gIx, i2);
                if (bz != null) {
                    i = bz.getCount();
                } else {
                    i = 0;
                }
                while (bz != null && bz.moveToNext()) {
                    cf auVar = new au();
                    auVar.ao(bz.getLong(0));
                    auVar.ap(bz.getLong(1));
                    auVar.aq(bz.getLong(2));
                    auVar.setContent(bz.getString(3));
                    auVar.eR(bz.getInt(4));
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str);
                        if (fT != null && b.lG(fT.type)) {
                            Object obj;
                            String a = b.a(auVar, s.eV(this.gIx), this.gIx);
                            af WO = ((h) g.h(h.class)).EY().WO(a);
                            String str2 = "";
                            if (hD != null) {
                                str2 = hD.gu(a);
                            }
                            d dVar = new d(auVar.field_createTime, fT.type, fT.title, auVar.field_msgId, WO.field_username, WO.AP(), WO.field_conRemark, str2, bh.az(fT.hdy, fT.appId), fT, auVar.field_msgSvrId);
                            Iterator it = b.gBH.iterator();
                            while (it.hasNext()) {
                                if (bh.fu(dVar.hdy, ((d) it.next()).hdy)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                dVar.desc = fT.title;
                                WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(dVar.fEt.hdx);
                                if (qK != null) {
                                    str = qK.field_nickname;
                                } else {
                                    try {
                                        str = dVar.fEt.fGA;
                                    } catch (Throwable th) {
                                        if (bz != null) {
                                            bz.close();
                                        }
                                    }
                                }
                                dVar.title = str;
                                dVar.imagePath = qK != null ? qK.field_brandIconURL : dVar.fEt.hdG;
                                b.gBH.add(dVar);
                            }
                            if (b.gBH.size() >= this.jRF) {
                                break;
                            }
                        }
                    }
                }
                if (bz != null) {
                    bz.close();
                }
                i2 += i;
            }
            x.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", new Object[]{Integer.valueOf(b.gBH.size())});
            ag.y(new 1(this));
        }
    }

    public interface a {
        void t(LinkedList<d> linkedList);
    }

    public static synchronized void reset() {
        synchronized (b.class) {
            jRD = false;
            jRE = false;
            gBH.clear();
            jRC.clear();
        }
    }

    public static synchronized void a(String str, a aVar) {
        synchronized (b.class) {
            if (jRD) {
                jRC.add(aVar);
            } else if (jRE) {
                aVar.t(gBH);
            } else {
                jRD = true;
                jRC.add(aVar);
                g.Dk();
                g.Dm().F(new AnonymousClass1(str, 10));
            }
        }
    }

    private static synchronized void done() {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandHistoryListLogic", "done");
            jRE = true;
            jRD = false;
            Iterator it = jRC.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.t(gBH);
                }
            }
            jRC.clear();
        }
    }

    public static boolean lG(int i) {
        return 33 == i || 36 == i;
    }

    protected static String a(au auVar, boolean z, String str) {
        if (auVar.field_isSend == 1) {
            return com.tencent.mm.z.q.FS();
        }
        String str2 = null;
        if (z) {
            str2 = ba.hP(auVar.field_content);
        }
        if (bh.ov(str2)) {
            return str;
        }
        return str2;
    }
}
