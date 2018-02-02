package com.tencent.mm.z;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bs implements d {
    private Map<String, List<a>> hhS = new HashMap();
    private Map<String, List<a>> hhT = new HashMap();
    private Map<String, List<m>> hhU = new HashMap();
    private Map<String, l> hhV = new ConcurrentHashMap();

    public interface a {
        void a(com.tencent.mm.ae.d.a aVar);
    }

    @Deprecated
    public final void a(String str, a aVar, boolean z) {
        if (!bh.ov(str) && aVar != null) {
            Map map = z ? this.hhT : this.hhS;
            List list = (List) map.get(str);
            if (list == null) {
                list = new LinkedList();
                map.put(str, list);
            }
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
        }
    }

    @Deprecated
    public final void b(String str, a aVar, boolean z) {
        if (!bh.ov(str) && aVar != null) {
            List list = (List) (z ? this.hhT : this.hhS).get(str);
            if (list != null) {
                list.remove(aVar);
            }
        }
    }

    public final void a(String str, m mVar) {
        if (!bh.ov(str) && mVar != null) {
            List list;
            synchronized (this.hhU) {
                List list2 = (List) this.hhU.get(str);
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    this.hhU.put(str, linkedList);
                    list = linkedList;
                } else {
                    list = list2;
                }
            }
            synchronized (list) {
                if (!list.contains(mVar)) {
                    list.add(mVar);
                }
            }
        }
    }

    public final void b(String str, m mVar) {
        if (!bh.ov(str) && mVar != null) {
            List list;
            synchronized (this.hhU) {
                list = (List) this.hhU.get(str);
            }
            if (list != null) {
                synchronized (list) {
                    list.remove(mVar);
                }
            }
        }
    }

    public final void a(String str, l lVar) {
        if (!bh.ov(str) && lVar != null) {
            if (this.hhV.containsKey(str)) {
                x.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", str, bh.cgy());
            }
            this.hhV.put(str, lVar);
        }
    }

    public final void b(String str, l lVar) {
        if (!bh.ov(str) && lVar != null) {
            synchronized (this.hhV) {
                this.hhV.remove(str);
            }
        }
    }

    public final b b(com.tencent.mm.ae.d.a aVar) {
        bw bwVar = aVar.hmq;
        switch (bwVar.ngq) {
            case 10001:
                String a = n.a(bwVar.vGX);
                n.a(bwVar.vGZ);
                a(a, aVar, false);
                com.tencent.mm.plugin.report.d.pPH.k(10395, String.valueOf(bwVar.vHe));
                return null;
            case 10002:
                String a2 = n.a(bwVar.vGZ);
                if (bh.ov(a2)) {
                    x.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    return null;
                }
                Map map;
                String str;
                if (a2.startsWith("~SEMI_XML~")) {
                    Map Vo = ax.Vo(a2);
                    if (Vo == null) {
                        x.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        return null;
                    }
                    map = Vo;
                    str = "brand_service";
                } else {
                    int indexOf = a2.indexOf("<sysmsg");
                    if (indexOf == -1) {
                        x.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        return null;
                    }
                    x.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a2, a2.substring(indexOf));
                    Map y = bi.y(r0, "sysmsg");
                    if (y == null) {
                        x.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                        return null;
                    }
                    map = y;
                    str = (String) y.get(".sysmsg.$type");
                }
                x.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a2, str);
                if (str != null) {
                    List<m> list;
                    a(str, aVar, true);
                    synchronized (this.hhU) {
                        list = (List) this.hhU.get(str);
                    }
                    if (list == null || list.isEmpty()) {
                        x.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
                    } else {
                        x.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
                        synchronized (list) {
                            for (m b : list) {
                                b.b(str, map, aVar);
                            }
                        }
                    }
                    l lVar = (l) this.hhV.get(str);
                    if (lVar != null) {
                        return lVar.a(str, map, aVar);
                    }
                    x.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", str);
                }
                return null;
            default:
                x.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(bwVar.ngq));
                return null;
        }
    }

    @Deprecated
    private void a(String str, com.tencent.mm.ae.d.a aVar, boolean z) {
        List<a> list = (List) (z ? this.hhT : this.hhS).get(str);
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            return;
        }
        x.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (a a : list) {
            a.a(aVar);
        }
    }

    public final void h(au auVar) {
    }
}
