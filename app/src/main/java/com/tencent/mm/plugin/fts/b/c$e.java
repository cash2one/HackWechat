package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.b.c.f;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

class c$e extends a {
    final /* synthetic */ c mNG;
    private List<au> mNL = new ArrayList();
    private StringBuffer mNM;

    public c$e(c cVar, List<au> list) {
        this.mNG = cVar;
        this.mNL.addAll(list);
        this.mNM = new StringBuffer();
    }

    public final boolean execute() {
        List<f> arrayList = new ArrayList();
        for (au auVar : this.mNL) {
            f fVar = new f(this.mNG, (byte) 0);
            fVar.fqm = auVar.field_msgId;
            fVar.talker = auVar.field_talker;
            fVar.hVE = auVar.field_createTime;
            fVar.content = auVar.field_content;
            fVar.msgType = auVar.getType();
            fVar.mNO = auVar.field_isSend;
            if (c.a(fVar)) {
                fVar.aNf();
                if (fVar.isAvailable()) {
                    arrayList.add(fVar);
                }
            }
        }
        this.mNM.append("{MsgId: ");
        for (f fVar2 : arrayList) {
            this.mNM.append(fVar2.fqm);
            this.mNM.append(",");
            this.mNM.append(fVar2.talker);
            this.mNM.append(",");
            this.mNM.append(fVar2.hVE);
            this.mNM.append(" ");
        }
        this.mNM.append("count: ");
        this.mNM.append(arrayList.size());
        this.mNM.append("}");
        if (arrayList.size() > 0) {
            this.mNG.mNy.beginTransaction();
            for (f fVar3 : arrayList) {
                this.mNG.mNy.a(fVar3.mNN, fVar3.fqm, fVar3.talker, fVar3.hVE, fVar3.mNP, fVar3.mNQ);
            }
            this.mNG.mNy.commit();
        }
        return true;
    }

    public final String getName() {
        return "InsertMessageTask";
    }

    public final String ado() {
        return this.mNM.toString();
    }
}
