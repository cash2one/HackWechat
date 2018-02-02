package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;

@a
class URISpanHandlerSet$EnterRoomUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$EnterRoomUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        if (str.startsWith("weixin://jump/mainframe/")) {
            int lastIndexOf = str.trim().lastIndexOf("/");
            if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                String substring = str.trim().substring(lastIndexOf + 1);
                if (s.eV(substring)) {
                    ar.Hg();
                    com.tencent.mm.l.a WO = c.EY().WO(substring);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        x xVar = new x();
                        xVar.setUsername(substring);
                        ar.Hg();
                        c.EY().R(xVar);
                    }
                }
                Intent putExtra = new Intent(URISpanHandlerSet.a(this.fhe), ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                if (URISpanHandlerSet.a(this.fhe) instanceof Service) {
                    putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                URISpanHandlerSet.a(this.fhe).startActivity(putExtra);
                return true;
            }
        }
        return false;
    }
}
