package com.tencent.mm.plugin.ipcall.a;

import android.content.Intent;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

class i$5 extends c<qs> {
    final /* synthetic */ i nDs;

    i$5(i iVar) {
        this.nDs = iVar;
        this.xen = qs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qs qsVar = (qs) bVar;
        if (qsVar instanceof qs) {
            Intent intent = new Intent(ac.getContext(), IPCallDialUI.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("IPCallTalkUI_contactId", qsVar.fIx.fIy);
            intent.putExtra("IPCallTalkUI_countryCode", qsVar.fIx.fIz);
            intent.putExtra("IPCallTalkUI_nickname", qsVar.fIx.bgo);
            intent.putExtra("IPCallTalkUI_phoneNumber", qsVar.fIx.fIA);
            ac.getContext().startActivity(intent);
        }
        return false;
    }
}
