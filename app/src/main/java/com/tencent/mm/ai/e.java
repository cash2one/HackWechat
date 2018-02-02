package com.tencent.mm.ai;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.z.af;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class e extends af {
    public final boolean gN(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (i != 0 && i < 604372991) {
            g.pQN.h(336, 14);
            ar.Hg();
            h EV = c.EV();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username").append(" from rconversation, rcontact").append(", bizinfo where rconversation").append(".username = rcontact").append(".username and rconversation").append(".username = bizinfo").append(".username and ( rcontact").append(".verifyFlag & 8").append(" ) != 0 ");
            x.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[]{stringBuilder.toString()});
            Cursor a = EV.a(r1, null, 2);
            if (a != null && a.moveToFirst()) {
                aj ajVar;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef").append(" = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = a.getString(0);
                    if (!s.hl(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (a.moveToNext());
                a.close();
                x.d("MicroMsg.ConversationDataTransfer", "changed[%B] exec sql[%s]", new Object[]{Boolean.valueOf(true), stringBuilder.toString()});
                EV.fx("rconversation", r1);
                ar.Hg();
                aj WY = c.Fd().WY("officialaccounts");
                if (WY == null) {
                    WY = new ae("officialaccounts");
                    WY.ciy();
                    ar.Hg();
                    c.Fd().d(WY);
                    ajVar = WY;
                } else {
                    ajVar = WY;
                }
                ar.Hg();
                String ciI = c.Fd().ciI();
                if (bh.ov(ciI)) {
                    x.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    return;
                }
                ar.Hg();
                cf Ex = c.Fa().Ex(ciI);
                if (Ex == null || Ex.field_msgId == 0) {
                    x.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    return;
                }
                ajVar.ac(Ex);
                ajVar.setContent(Ex.field_talker + ":" + Ex.field_content);
                ajVar.dE(Integer.toString(Ex.getType()));
                ar.Hg();
                b uw = c.Fd().uw();
                if (uw != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Ex.dS("officialaccounts");
                    Ex.setContent(ajVar.field_content);
                    uw.a(Ex, pString, pString2, pInt, false);
                    ajVar.dF(pString.value);
                    ajVar.dG(pString2.value);
                    ajVar.eS(pInt.value);
                }
                ar.Hg();
                c.Fd().a(ajVar, ajVar.field_username);
            }
            if (a != null && !a.isClosed()) {
                a.close();
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
