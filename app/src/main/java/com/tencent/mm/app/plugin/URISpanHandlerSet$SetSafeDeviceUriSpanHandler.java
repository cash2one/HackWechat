package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;

@URISpanHandlerSet$a
class URISpanHandlerSet$SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$SetSafeDeviceUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        return null;
    }

    final int[] uC() {
        return new int[0];
    }

    final boolean a(k kVar, f fVar) {
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://setting/account/safedevice")) {
            return false;
        }
        ar.Hg();
        String str2 = (String) c.CU().get(6, (Object) "");
        ar.Hg();
        String str3 = (String) c.CU().get(4097, (Object) "");
        Intent intent;
        if (!bh.ov(str2)) {
            intent = new Intent();
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.y(URISpanHandlerSet.a(this.fhe), "safedevice", ".ui.MySafeDeviceListUI");
        } else if (bh.ov(str3)) {
            intent = new Intent();
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.a(URISpanHandlerSet.a(this.fhe), "safedevice", ".ui.BindSafeDeviceUI", intent);
        } else {
            intent = new Intent(URISpanHandlerSet.a(this.fhe), BindMContactIntroUI.class);
            intent.putExtra("is_bind_for_safe_device", true);
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            MMWizardActivity.A(URISpanHandlerSet.a(this.fhe), intent);
        }
        return true;
    }
}
