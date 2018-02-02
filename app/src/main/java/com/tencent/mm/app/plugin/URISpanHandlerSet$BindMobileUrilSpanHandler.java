package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$BindMobileUrilSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$BindMobileUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://setting/bindphone")) {
            return new k(str, 5, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{5};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 5) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        MMWizardActivity.A(URISpanHandlerSet.a(this.fhe), new Intent(URISpanHandlerSet.a(this.fhe), BindMContactIntroUI.class));
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://setting/bindphone")) {
            return false;
        }
        Intent intent = new Intent(URISpanHandlerSet.a(this.fhe), BindMContactIntroUI.class);
        if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        MMWizardActivity.A(URISpanHandlerSet.a(this.fhe), intent);
        return true;
    }
}
