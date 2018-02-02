package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.e;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends e {
    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            Object linkedList = new LinkedList();
            String a = com.tencent.mm.platformtools.n.a(bwVar.vGX);
            String a2 = com.tencent.mm.platformtools.n.a(bwVar.vGY);
            ar.Hg();
            String str = ((String) c.CU().get(2, null)).equals(a) ? a2 : a;
            String a3 = com.tencent.mm.platformtools.n.a(bwVar.vGZ);
            x.d("MicroMsg.TrackMsgExtension", "cmd " + a3);
            Map y = bi.y(a3, "sysmsg");
            if (y != null) {
                try {
                    String aZ;
                    String ba;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("talk  " + str + "\r\n");
                    stringBuffer.append("from fromUser " + a + "\r\n");
                    stringBuffer.append("from toUser " + a2 + "\r\n");
                    String str2 = (String) y.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                    double Dz = Dz((String) y.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                    stringBuffer.append("lat " + Dz + "\r\n");
                    double Dz2 = Dz((String) y.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                    stringBuffer.append("lng " + Dz2 + "\r\n");
                    stringBuffer.append("times " + bh.getInt((String) y.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + "\r\n");
                    int i = 0;
                    while (true) {
                        a3 = (String) y.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                        if (bh.ov(a3)) {
                            break;
                        }
                        i++;
                        linkedList.add(a3);
                    }
                    stringBuffer.append("userNameList size " + linkedList.size() + "\r\n");
                    x.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                    if (str.equals(l.aVu().nRR)) {
                        aZ = aZ(linkedList);
                        ba = bh.ov(aZ) ? ba(linkedList) : null;
                    } else {
                        ba = null;
                        aZ = null;
                    }
                    l.aVv().a(str, linkedList, Dz, Dz2, str2, aZ, ba);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    private static double Dz(String str) {
        if (str == null) {
            return 0.0d;
        }
        return bh.getDouble(str, 0.0d);
    }

    private static String aZ(List<String> list) {
        List<String> aVC = l.aVu().aVC();
        List linkedList = new LinkedList();
        for (String str : list) {
            String str2;
            Object obj;
            for (String equals : aVC) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(q.FS())) {
                return str2;
            }
        }
        return null;
    }

    private static String ba(List<String> list) {
        List<String> aVC = l.aVu().aVC();
        List linkedList = new LinkedList();
        for (String str : aVC) {
            Object obj;
            for (String equals : list) {
                String equals2;
                if (equals2.equals(str)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            equals2 = (String) linkedList.get(i);
            if (!equals2.equals(q.FS())) {
                return equals2;
            }
        }
        return null;
    }
}
