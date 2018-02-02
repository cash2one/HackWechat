package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$ProfileUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$ProfileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://contacts/profile/")) {
            return new k(str, 3, str.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
        }
        return null;
    }

    final int[] uC() {
        return new int[]{3};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 3) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        String str = (String) kVar.A(String.class);
        Intent intent = new Intent();
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("Contact_User", str);
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
            e.a(intent, str);
        }
        if (bh.ou(str).length() > 0) {
            d.b(URISpanHandlerSet.a(this.fhe), "profile", ".ui.ContactInfoUI", intent);
        }
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.startsWith("weixin://contacts/profile/")) {
            return false;
        }
        String replace = str.trim().replace("weixin://contacts/profile/", "").replace("/", "");
        if (bh.ov(replace)) {
            x.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
            return true;
        }
        Intent intent = new Intent();
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("Contact_User", replace);
        ar.Hg();
        af WO = c.EY().WO(replace);
        if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
            e.a(intent, replace);
        }
        d.b(URISpanHandlerSet.a(this.fhe), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
