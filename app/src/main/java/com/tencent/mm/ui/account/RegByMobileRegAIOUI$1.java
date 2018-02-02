package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class RegByMobileRegAIOUI$1 extends c<iy> {
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$1(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
        this.xen = iy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        iy iyVar = (iy) bVar;
        if (iyVar == null || iyVar.fzB == null) {
            return false;
        }
        x.i("MicroMsg.RegByMobileRegAIOUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", new Object[]{iyVar.fzB.content, iyVar.fzB.url});
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", iyVar.fzB.content);
        intent.putExtra("key_disaster_url", iyVar.fzB.url);
        intent.setClass(ac.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ac.getContext().startActivity(intent);
        return true;
    }
}
