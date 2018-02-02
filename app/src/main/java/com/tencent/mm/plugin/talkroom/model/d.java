package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements com.tencent.mm.ae.d {
    public final b b(a aVar) {
        int i = 1;
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
        } else if (bwVar.ngq != 56) {
            x.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(bwVar.ngq)});
        } else {
            String a = n.a(bwVar.vGX);
            String a2 = n.a(bwVar.vGY);
            ar.Hg();
            if (!((String) c.CU().get(2, null)).equals(a)) {
                a2 = a;
            }
            ar.Hg();
            com.tencent.mm.l.a WO = c.EY().WO(a2);
            if (WO == null || ((int) WO.gJd) == 0) {
                ar.Hg();
                c.EY().R(new com.tencent.mm.storage.x(a2));
            }
            String a3 = n.a(bwVar.vGZ);
            x.d("MicroMsg.TalkRoomExtension", "talkroom xml:" + a3);
            Map y = bi.y(a3, "talkroominfo");
            if (y != null) {
                try {
                    int i2;
                    String str;
                    String ba;
                    if (Mq((String) y.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        Mq((String) y.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    Object linkedList = new LinkedList();
                    Mq((String) y.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) y.get(str + ".username");
                        if (bh.ov(a3)) {
                            break;
                        }
                        int Mq = Mq((String) y.get(str + ".memberid"));
                        bnh com_tencent_mm_protocal_c_bnh = new bnh();
                        com_tencent_mm_protocal_c_bnh.ksU = a3;
                        com_tencent_mm_protocal_c_bnh.wQe = Mq;
                        linkedList.add(com_tencent_mm_protocal_c_bnh);
                        i3++;
                    }
                    if (a2.equals(b.bEC().sbR)) {
                        str = aZ(linkedList);
                        ba = bh.ov(str) ? ba(linkedList) : null;
                    } else {
                        ba = null;
                        str = null;
                    }
                    e bED = b.bED();
                    if (i2 != 0) {
                        i = 0;
                    }
                    bED.a(a2, linkedList, str, ba, i);
                } catch (Throwable e) {
                    x.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    x.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }

    private static int Mq(String str) {
        int i = 0;
        if (!bh.ov(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            }
        }
        return i;
    }

    private static String aZ(List<bnh> list) {
        List<bnh> aVC = b.bEC().aVC();
        List linkedList = new LinkedList();
        for (bnh com_tencent_mm_protocal_c_bnh : list) {
            Object obj;
            for (bnh com_tencent_mm_protocal_c_bnh2 : aVC) {
                if (com_tencent_mm_protocal_c_bnh2.ksU.equals(com_tencent_mm_protocal_c_bnh.ksU)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(com_tencent_mm_protocal_c_bnh.ksU);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(q.FS())) {
                return str;
            }
        }
        return null;
    }

    private static String ba(List<bnh> list) {
        List<bnh> aVC = b.bEC().aVC();
        List linkedList = new LinkedList();
        for (bnh com_tencent_mm_protocal_c_bnh : aVC) {
            Object obj;
            for (bnh com_tencent_mm_protocal_c_bnh2 : list) {
                if (com_tencent_mm_protocal_c_bnh2.ksU.equals(com_tencent_mm_protocal_c_bnh.ksU)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(com_tencent_mm_protocal_c_bnh.ksU);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(q.FS())) {
                return str;
            }
        }
        return null;
    }
}
