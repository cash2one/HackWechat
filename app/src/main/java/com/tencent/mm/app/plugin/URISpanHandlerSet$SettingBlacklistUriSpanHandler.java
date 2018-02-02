package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.z.x;
import com.tencent.wcdb.database.SQLiteDatabase;

@URISpanHandlerSet$a
class URISpanHandlerSet$SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$SettingBlacklistUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://setting/blacklist")) {
            return new k(str, 14, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{14};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 14) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        aq hB = x.hB(URISpanHandlerSet.a(this.fhe).getString(R.l.enF));
        Intent intent = new Intent();
        intent.setClass(URISpanHandlerSet.a(this.fhe), SelectContactUI.class);
        intent.putExtra("Contact_GroupFilter_Type", hB.getType());
        intent.putExtra("Contact_GroupFilter_DisplayName", hB.AP());
        intent.addFlags(67108864);
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        URISpanHandlerSet.a(this.fhe).startActivity(intent);
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://setting/blacklist")) {
            return false;
        }
        aq hB = x.hB(URISpanHandlerSet.a(this.fhe).getString(R.l.enF));
        Intent intent = new Intent();
        intent.setClass(URISpanHandlerSet.a(this.fhe), AddressUI.class);
        intent.putExtra("Contact_GroupFilter_Type", hB.getType());
        intent.putExtra("Contact_GroupFilter_DisplayName", hB.AP());
        intent.addFlags(67108864);
        if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        URISpanHandlerSet.a(this.fhe).startActivity(intent);
        return true;
    }
}
