package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

class j$8 implements OnClickListener {
    final /* synthetic */ j nOi;

    j$8(j jVar) {
        this.nOi = jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(View view) {
        c aTC = i.aTC();
        synchronized (aTC.mpv) {
            if (i.aTB().aTr()) {
                if (aTC.nCg) {
                    aTC.aSY();
                    return;
                }
                aTC.nCg = true;
                Toast.makeText(ac.getContext(), R.l.ewv, 0).show();
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClass(ac.getContext(), IPCallTalkUI.class);
                intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
                d.bGk().a(intent, aTC.nCh);
                aTC.aSY();
                if (aTC.nBY != null) {
                    aTC.nBY.aTg();
                }
            }
        }
    }
}
