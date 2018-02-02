package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private PowerManager tib = ((PowerManager) ac.getContext().getSystemService("power"));
    private KeyguardManager tic = ((KeyguardManager) ac.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, a> tje = new LinkedHashMap();

    private class a {
        String content;
        String rYX;
        final /* synthetic */ a tjf;

        public a(a aVar, String str, String str2) {
            this.tjf = aVar;
            this.rYX = str;
            this.content = str2;
        }
    }

    public static tn NO(String str) {
        b tnVar = new tn();
        tnVar.fMc.fpr = 1;
        tnVar.fMc.username = str;
        com.tencent.mm.sdk.b.a.xef.m(tnVar);
        return tnVar;
    }

    public final void bOJ() {
        if (NO(null).fMd.fMe != 0) {
            x.i("MicroMsg.wear.WearYoLogic", "current show yo");
            return;
        }
        synchronized (this.tje) {
            a aVar;
            Iterator it = this.tje.entrySet().iterator();
            if (it.hasNext()) {
                aVar = (a) ((Entry) it.next()).getValue();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                this.tje.remove(aVar.rYX);
            }
        }
        if (aVar != null) {
            int i;
            String str = aVar.content;
            bzo com_tencent_mm_protocal_c_bzo = new bzo();
            Map y = bi.y(str, "msg");
            if (y == null) {
                com_tencent_mm_protocal_c_bzo.ktN = 0;
            } else {
                com_tencent_mm_protocal_c_bzo.ktN = bh.getInt((String) y.get(".msg.yo.$type"), 0);
                com_tencent_mm_protocal_c_bzo.ksO = bh.getInt((String) y.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", aVar.rYX);
            try {
                intent.putExtra("key_data", com_tencent_mm_protocal_c_bzo.toByteArray());
            } catch (IOException e) {
            }
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (this.tic.inKeyguardRestrictedInputMode() || !this.tib.isScreenOn()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                intent.setClass(ac.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(ac.getContext(), WearYoNoLockUI.class);
            }
            ac.getContext().startActivity(intent);
        }
    }
}
