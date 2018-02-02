package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.wcdb.database.SQLiteDatabase;

@URISpanHandlerSet$a
class URISpanHandlerSet$JumpActivityUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$JumpActivityUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        if (!str.toLowerCase().startsWith("weixin://jump/")) {
            return false;
        }
        String[] split = str.split("/");
        String str2 = split[split.length - 1];
        Intent intent;
        if ("mainframe".equalsIgnoreCase(str2)) {
            intent = new Intent(URISpanHandlerSet.a(this.fhe), LauncherUI.class);
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            intent.addFlags(67108864);
            URISpanHandlerSet.a(this.fhe).startActivity(intent);
        } else if ("shake".equalsIgnoreCase(str2)) {
            g.pQN.k(10221, "1");
            intent = new Intent();
            intent.addFlags(67108864);
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(URISpanHandlerSet.a(this.fhe), "shake", ".ui.ShakeReportUI", intent);
            if (URISpanHandlerSet.a(this.fhe) != null && (URISpanHandlerSet.a(this.fhe) instanceof Activity)) {
                ((Activity) URISpanHandlerSet.a(this.fhe)).finish();
            }
        } else if ("scanqrcode".equalsIgnoreCase(str2)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            intent.setFlags(65536);
            intent.addFlags(67108864);
            if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(URISpanHandlerSet.a(this.fhe), "scanner", ".ui.BaseScanUI", intent);
        }
        return true;
    }
}
