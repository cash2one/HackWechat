package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.wcdb.database.SQLiteDatabase;

@URISpanHandlerSet$a
class URISpanHandlerSet$SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$SettingNotifyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://setting/notify")) {
            return new k(str, 9, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{9};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 9) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        d.y(URISpanHandlerSet.a(this.fhe), "setting", ".ui.setting.SettingsNotificationUI");
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://setting/notify")) {
            return false;
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        d.b(URISpanHandlerSet.a(this.fhe), "setting", ".ui.setting.SettingsNotificationUI", intent);
        return true;
    }
}
