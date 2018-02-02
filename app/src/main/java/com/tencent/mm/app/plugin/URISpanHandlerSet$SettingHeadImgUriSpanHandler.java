package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$SettingHeadImgUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$SettingHeadImgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://setting/setheadimage")) {
            return new k(str, 6, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{6};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 6) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://setting/setheadimage")) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", q.FS());
        intent.putExtra("Contact_Nick", q.FU());
        intent.putExtra("User_Avatar", true);
        if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        d.b(URISpanHandlerSet.a(this.fhe), "profile", ".ui.ContactInfoUI", intent);
        return true;
    }
}
