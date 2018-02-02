package com.tencent.mm.plugin.backup.i;

import android.database.Cursor;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.w.c.a;
import com.tencent.mm.plugin.w.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.LinkedList;

class a$3 extends c<jp> {
    final /* synthetic */ a kus;

    a$3(a aVar) {
        this.kus = aVar;
        this.xen = jp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final jp jpVar = (jp) bVar;
        if (!(jpVar == null || !(jpVar instanceof jp) || jpVar.fAm == null)) {
            x.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent.");
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ a$3 kuu;

                public final void run() {
                    jp jpVar = jpVar;
                    x.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[]{Boolean.valueOf(jpVar.fAm.fAp)});
                    if (jpVar.fAm.fAp) {
                        g.pQN.a(466, 13, 1, false);
                        return;
                    }
                    byte[] bArr = jpVar.fAm.fAn;
                    if (bArr == null) {
                        x.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
                        g.pQN.a(466, 14, 1, false);
                        return;
                    }
                    int i = jpVar.fAm.fAo;
                    if (e.oFx == null) {
                        e.oFx = new e();
                    }
                    e eVar = e.oFx;
                    x.i("MicroMsg.MsgSynchronizeServer", "msg synchronize start, loginDevice[%d]", new Object[]{Integer.valueOf(i)});
                    g.pQN.a(466, 0, 1, false);
                    eVar.oFD = bh.Wp();
                    eVar.oFz = bArr;
                    eVar.fAo = i;
                    d.aqe().aqh();
                    eVar.oFy.oFs = eVar;
                    eVar.oFy.oFr = false;
                    com.tencent.mm.plugin.w.c cVar = eVar.oFy;
                    long Wp = bh.Wp();
                    LinkedList linkedList = new LinkedList();
                    Cursor c = d.aqe().aqf().Fd().c(s.hfk, com.tencent.mm.plugin.backup.a.g.aox(), "*");
                    if (c.getCount() == 0) {
                        x.i("MicroMsg.MsgSynchronizePack", "empty conversation!");
                        c.close();
                    } else {
                        c.moveToFirst();
                        x.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count:%d", new Object[]{Integer.valueOf(c.getCount())});
                        while (!cVar.oFr) {
                            aj aeVar = new ae();
                            aeVar.b(c);
                            if (!bh.ov(aeVar.field_username)) {
                                x.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s msgCnt:%d", new Object[]{aeVar.field_username, Integer.valueOf(d.aqe().aqf().Fa().EM(aeVar.field_username))});
                                if (d.aqe().aqf().Fa().EM(aeVar.field_username) > 0) {
                                    linkedList.add(new a(aeVar.field_username));
                                }
                            }
                            if (!c.moveToNext()) {
                                c.close();
                                x.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bh.bz(Wp));
                                break;
                            }
                        }
                        c.close();
                    }
                    x.i("MicroMsg.MsgSynchronizeServer", "calculateConversationList finish. conversationList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
                    if (linkedList.size() == 0) {
                        x.e("MicroMsg.MsgSynchronizeServer", "No conversation to synchronize");
                        long bz = bh.bz(eVar.oFD);
                        g.pQN.a(466, 1, 1, false);
                        g.pQN.a(466, 5, 0, false);
                        g.pQN.a(466, 7, bz, false);
                        g.pQN.a(466, 11, 0, false);
                        g.pQN.a(466, 12, 0, false);
                        g.pQN.h(14108, new Object[]{Integer.valueOf(0), Long.valueOf(bz), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i)});
                    } else if (com.tencent.mm.plugin.w.b.oFq < 0) {
                        eVar.oFy.b(linkedList, (long) com.tencent.mm.plugin.w.b.oFq);
                    } else {
                        eVar.oFy.b(linkedList, bh.bz((long) ((((com.tencent.mm.plugin.w.b.oFq * 24) * 60) * 60) * 1000)));
                    }
                }
            });
        }
        return false;
    }
}
