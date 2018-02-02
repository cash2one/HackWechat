package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao {
    private static HashMap<String, b> qXv = new HashMap();
    private static LinkedList<a> qXw = new LinkedList();
    private static c qXx = new 1();

    static /* synthetic */ a cd(String str, int i) {
        Iterator it = qXw.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == i && !bh.ov(str) && !bh.ov(aVar.id) && str.equals(aVar.id)) {
                return aVar;
            }
        }
        return null;
    }

    public static void init() {
        a.xef.b(qXx);
    }

    public static void WK() {
        a.xef.c(qXx);
    }

    private static boolean uA() {
        if (!d.OQ("translate")) {
            return false;
        }
        String value = g.zY().getValue("TranslateSnsOff");
        if (bh.ov(value)) {
            return true;
        }
        if (bh.VI(value) == 0) {
            return true;
        }
        return false;
    }

    public static void a(Menu menu, boolean z) {
        if (!uA()) {
            return;
        }
        if (z) {
            menu.add(0, 14, 0, j.qMz);
        } else {
            menu.add(0, 15, 0, j.qMz);
        }
    }

    public static void b(Menu menu, boolean z) {
        if (!uA()) {
            return;
        }
        if (z) {
            menu.add(0, 16, 0, j.qMB);
        } else {
            menu.add(0, 17, 0, j.qMB);
        }
    }

    public static void o(m mVar) {
        if (mVar != null) {
            String bxW = mVar.bxW();
            x.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[]{bxW});
            if (mVar.field_snsId == 0) {
                x.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                qXv.remove(bxW);
                d(bxW, 1, null, null);
                return;
            }
            if (qXv.containsKey(bxW)) {
                b bVar = (b) qXv.get(bxW);
                if (!bVar.hik || bVar.hlj) {
                    qXv.remove(bxW);
                } else {
                    x.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[]{bxW});
                    d(bVar.id, 1, bVar.result, bVar.hqd);
                    return;
                }
            }
            if (mVar.bxV() != null) {
                String str = mVar.bxV().wQl;
                b rnVar = new rn();
                rnVar.fJp.id = bxW;
                rnVar.fJp.fJq = str;
                rnVar.fJp.type = 2;
                a.xef.m(rnVar);
                bZ(mVar.bxW(), 1);
                a aVar = new a((byte) 0);
                aVar.id = bxW;
                aVar.qXy = str;
                aVar.type = 2;
                qXw.add(aVar);
            }
        }
    }

    public static void a(b bVar) {
        if ((bVar.fWj & 2) != 0) {
            bVar.qXA = false;
        } else if ((bVar.fWj & 4) != 0) {
            bVar.qXB = false;
        }
        qXv.put(bVar.id, bVar);
    }

    private static void b(b bVar) {
        if ((bVar.fWj & 2) != 0) {
            bVar.qXA = true;
        } else if ((bVar.fWj & 4) != 0) {
            bVar.qXB = true;
        }
        qXv.put(bVar.id, bVar);
    }

    public static void p(m mVar) {
        if (mVar != null) {
            String bxW = mVar.bxW();
            b(Kr(bxW));
            b qkVar = new qk();
            qkVar.fHX.type = 1;
            qkVar.fHX.id = bxW;
            a.xef.m(qkVar);
            x.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[]{bxW});
        }
    }

    public static void a(com.tencent.mm.plugin.sns.ui.m mVar) {
        if (mVar != null && mVar.qTX != null) {
            long j;
            String str = mVar.nje;
            StringBuilder stringBuilder = new StringBuilder();
            if (mVar.qTX.wMw != 0) {
                j = (long) mVar.qTX.wMw;
            } else {
                j = mVar.qTX.wMz;
            }
            String eb = eb(mVar.rse, stringBuilder.append(j).toString());
            if (qXv.containsKey(eb)) {
                b bVar = (b) qXv.get(eb);
                if (!bVar.hik || bh.ov(bVar.result)) {
                    qXv.remove(eb);
                } else {
                    x.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[]{eb});
                    d(bVar.id, 2, bVar.result, bVar.hqd);
                    return;
                }
            }
            b rnVar = new rn();
            rnVar.fJp.id = eb;
            rnVar.fJp.fJq = str;
            rnVar.fJp.type = 3;
            a.xef.m(rnVar);
            bZ(eb, 2);
            a aVar = new a((byte) 0);
            aVar.id = eb;
            aVar.qXy = str;
            aVar.type = 3;
            qXw.add(aVar);
            x.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[]{aVar.id});
        }
    }

    public static void b(com.tencent.mm.plugin.sns.ui.m mVar) {
        if (mVar != null) {
            String eb = eb(mVar.rse, (mVar.qTX.wMw != 0 ? (long) mVar.qTX.wMw : mVar.qTX.wMz));
            b(Kr(eb));
            b qkVar = new qk();
            qkVar.fHX.type = 2;
            qkVar.fHX.id = eb;
            a.xef.m(qkVar);
            x.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[]{eb});
        }
    }

    private static void bZ(String str, int i) {
        if (!qXv.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.hqd = null;
            bVar.result = null;
            bVar.hik = false;
            bVar.hlj = false;
            bVar.qXB = true;
            bVar.qXA = true;
            qXv.put(str, bVar);
        }
        b qjVar = new qj();
        qjVar.fHW.type = i;
        qjVar.fHW.id = str;
        a.xef.m(qjVar);
    }

    private static void d(String str, int i, String str2, String str3) {
        if (qXv.containsKey(str)) {
            b bVar = (b) qXv.get(str);
            bVar.hqd = str3;
            bVar.result = str2;
            bVar.hik = true;
            bVar.hlj = bh.ov(str2);
            qXv.put(str, bVar);
        }
        if (bh.ov(str2)) {
            Toast.makeText(ac.getContext(), j.qMA, 1).show();
        }
        b qiVar = new qi();
        qiVar.fHU.type = i;
        qiVar.fHU.id = str;
        qiVar.fHU.result = str2;
        qiVar.fHU.fHV = str3;
        a.xef.m(qiVar);
    }

    public static String eb(String str, String str2) {
        return str + ";" + str2;
    }

    public static HashMap<String, b> bvY() {
        return qXv;
    }

    public static void ca(String str, int i) {
        if (qXv.containsKey(str)) {
            b bVar = (b) qXv.get(str);
            bVar.fWj |= i;
            qXv.put(str, bVar);
        }
    }

    public static void cb(String str, int i) {
        if (qXv.containsKey(str)) {
            b bVar = (b) qXv.get(str);
            bVar.fWj &= i ^ -1;
            if (i != 2 && i == 4) {
                bVar.qXB = true;
            }
            qXv.put(str, bVar);
        }
    }

    public static boolean cc(String str, int i) {
        if (!qXv.containsKey(str)) {
            return false;
        }
        if ((((b) qXv.get(str)).fWj & i) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.fWj & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b Kr(String str) {
        if (qXv.containsKey(str)) {
            return (b) qXv.get(str);
        }
        return null;
    }
}
