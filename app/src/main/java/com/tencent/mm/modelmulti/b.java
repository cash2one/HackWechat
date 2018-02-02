package com.tencent.mm.modelmulti;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b implements a {
    Map<String, LinkedList<a>> hEB = new HashMap();
    LinkedBlockingQueue<a> hEC = new LinkedBlockingQueue();
    c hED;
    Map<Long, ao> hEE = new HashMap();
    int hEF;
    boolean hkG = false;
    long hkQ = 0;
    ak hyD = new ak(ar.Dm().oAt.getLooper(), new 2(this), false);
    final ak hyE = new ak(ar.Dm().oAt.getLooper(), new 4(this), true);
    Queue<b> hyz = new LinkedList();

    static /* synthetic */ void e(Map map, String str) {
        if (map.size() != 0 && !t.ov(str)) {
            Iterator it = map.values().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    ao aoVar = (ao) it.next();
                    if (aoVar != null && str.equals(aoVar.field_fromUserName)) {
                        ar.Hg();
                        if (c.Fa().F(str, aoVar.field_originSvrId).field_msgId != 0) {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[]{Long.valueOf(c.Fa().F(str, aoVar.field_originSvrId).field_msgId), Long.valueOf(c.Fa().F(str, aoVar.field_originSvrId).field_msgSvrId)});
                            bw bwVar = new bw();
                            bwVar.vHe = aoVar.field_newMsgId;
                            bwVar.vGX = n.os(aoVar.field_fromUserName);
                            bwVar.vGY = n.os(aoVar.field_toUserName);
                            bwVar.pbl = (int) aoVar.field_createTime;
                            bwVar.vGZ = n.os(aoVar.field_content);
                            bwVar.vHc = aoVar.field_msgSource;
                            bwVar.vHf = aoVar.field_msgSeq;
                            int i = aoVar.field_flag;
                            bwVar.ngq = 10002;
                            d.pPH.a(403, 35, 1, false);
                            ar.getSysCmdMsgExtension().b(new com.tencent.mm.ae.d.a(bwVar, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                        }
                    }
                }
            }
        }
    }

    b() {
    }

    public final void a(String str, l lVar) {
        if (!t.ov(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                com.tencent.mm.sdk.e.c aoVar = new ao();
                aoVar.field_originSvrId = longValue;
                if (ar.Hg().FK().b(aoVar, new String[0])) {
                    this.hEE.put(Long.valueOf(longValue), aoVar);
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[]{Long.valueOf(aoVar.xjy), Long.valueOf(longValue)});
                    return;
                }
                this.hEE.remove(Long.valueOf(longValue));
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange remove info svrId[%d]", new Object[]{Long.valueOf(longValue)});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetChatRoomMsgService", e, "summerbadcr onNotifyChange:", new Object[0]);
            }
        }
    }

    public final boolean a(a aVar, c cVar) {
        if (!b(aVar, cVar)) {
            return false;
        }
        this.hyD.J(0, 0);
        return true;
    }

    public final boolean a(a aVar) {
        if (aVar.hEK != 0) {
            return false;
        }
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr clearChatRoomMsg info:%s, stack[%s]", new Object[]{aVar, t.Ws()});
        if (!this.hEC.add(aVar)) {
            return false;
        }
        this.hyD.J(0, 0);
        return true;
    }

    private boolean b(a aVar, c cVar) {
        if (aVar == null || cVar == null || t.ov(aVar.hEI) || !aVar.hEI.equals(cVar.PU())) {
            return false;
        }
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg info:%s", new Object[]{aVar});
        synchronized (this.hEB) {
            LinkedList linkedList = (LinkedList) this.hEB.get(aVar.hEI);
            if (linkedList == null) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg new infos and add ret:%b, infos[%d], needGetInfosMap[%s]", new Object[]{Boolean.valueOf(linkedList.add(aVar)), Integer.valueOf(new LinkedList().hashCode()), this.hEB});
                this.hEB.put(aVar.hEI, linkedList);
            } else {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg infos size:%s ", new Object[]{Integer.valueOf(linkedList.size())});
                if (linkedList.contains(aVar)) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg infos already exist %s ", new Object[]{aVar});
                } else {
                    linkedList.addLast(aVar);
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg to infos first:%b, infos[%d], size:%d, needGetInfosMap[%s]", new Object[]{Boolean.valueOf(false), Integer.valueOf(linkedList.hashCode()), Integer.valueOf(linkedList.size()), this.hEB});
            }
            this.hED = cVar;
        }
        return true;
    }
}
