package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$FriendMobileUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$FriendMobileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://findfriend/mobile")) {
            return new k(str, 20, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{20};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 20) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        URISpanHandlerSet.a(this.fhe).startActivity(new Intent(URISpanHandlerSet.a(this.fhe), MobileFriendUI.class));
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://findfriend/mobile")) {
            return false;
        }
        Intent intent = new Intent(URISpanHandlerSet.a(this.fhe), MobileFriendUI.class);
        if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        URISpanHandlerSet.a(this.fhe).startActivity(intent);
        return true;
    }
}
