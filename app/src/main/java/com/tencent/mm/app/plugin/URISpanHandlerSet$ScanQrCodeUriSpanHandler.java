package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$ScanQrCodeUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$ScanQrCodeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        boolean z2 = false;
        if (!str.equals("weixin://scanqrcode/")) {
            return false;
        }
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            if (bundle != null && bundle.getInt("fromScene") == 100) {
                z2 = true;
            }
            if (!z2) {
                intent.addFlags(67108864);
            }
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            if (z2) {
                d.b(URISpanHandlerSet.a(this.fhe), "scanner", ".ui.SingleTopScanUI", intent);
                return true;
            }
            d.b(URISpanHandlerSet.a(this.fhe), "scanner", ".ui.BaseScanUI", intent);
            return true;
        }
        x.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
        return true;
    }
}
