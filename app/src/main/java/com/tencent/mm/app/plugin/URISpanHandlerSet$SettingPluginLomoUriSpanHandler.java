package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$SettingPluginLomoUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$SettingPluginLomoUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
            return new k(str, 12, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{12};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 12) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "weibo");
        d.b(URISpanHandlerSet.a(this.fhe), "profile", ".ui.ContactInfoUI", intent);
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://setting/plugin/lomo")) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "weibo");
        if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        d.b(URISpanHandlerSet.a(this.fhe), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
