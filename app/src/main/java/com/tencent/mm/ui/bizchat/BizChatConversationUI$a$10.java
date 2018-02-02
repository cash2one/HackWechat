package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import java.util.LinkedList;

class BizChatConversationUI$a$10 implements Runnable {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$10(a aVar) {
        this.ynJ = aVar;
    }

    public final void run() {
        x.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Cursor kj = y.Mi().kj(a.a(this.ynJ));
        if (kj.moveToFirst()) {
            while (!kj.isAfterLast()) {
                com.tencent.mm.ag.a.a aVar = new com.tencent.mm.ag.a.a();
                aVar.b(kj);
                kj.moveToNext();
                c ag = y.Mh().ag(aVar.field_bizChatId);
                if (ag.Mu()) {
                    if (ag.Mt()) {
                        linkedList2.add(ag.field_bizChatServId);
                    } else {
                        linkedList.add(ag.field_bizChatServId);
                    }
                }
            }
        }
        kj.close();
        if (linkedList2.size() > 0) {
            y.Ml().a(linkedList2, a.a(this.ynJ));
        }
        a.a(this.ynJ, linkedList);
        if (linkedList.size() > 0) {
            y.Ml().b(linkedList, a.a(this.ynJ));
        }
    }
}
