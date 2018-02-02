package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

class k$7 implements OnItemClickListener {
    final /* synthetic */ int hLI;
    final /* synthetic */ List msj;
    final /* synthetic */ String nNI;
    final /* synthetic */ Context val$context;
    final /* synthetic */ OnDismissListener vuJ;
    final /* synthetic */ m vuM;
    final /* synthetic */ Bundle vuN;

    k$7(String str, List list, Context context, m mVar, OnDismissListener onDismissListener, int i, Bundle bundle) {
        this.nNI = str;
        this.msj = list;
        this.val$context = context;
        this.vuM = mVar;
        this.vuJ = onDismissListener;
        this.hLI = i;
        this.vuN = bundle;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CharSequence replace = this.nNI.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
        String str = (String) this.msj.get(i);
        x.i("MicroMsg.MailPhoneMenuHelper", str);
        Intent intent;
        if (this.val$context.getString(R.l.dSx).equals(str)) {
            intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(replace).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bh.k(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
            g.pQN.k(10112, "1");
            this.vuM.dismiss();
            if (this.vuJ != null) {
                this.vuJ.onDismiss(null);
            }
        } else if (this.val$context.getString(R.l.dSy).equals(str)) {
            g.pQN.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            intent = new Intent();
            intent.putExtra("IPCallTalkUI_phoneNumber", replace);
            d.b(this.val$context, "ipcall", ".ui.IPCallDialUI", intent);
            this.vuM.dismiss();
            if (this.vuJ != null) {
                this.vuJ.onDismiss(null);
            }
        } else if (this.val$context.getString(R.l.dSq).equals(str)) {
            String[] stringArray;
            if (k.ccq() && k.ccr()) {
                stringArray = this.val$context.getResources().getStringArray(R.c.bqW);
            } else {
                stringArray = k.ccq() ? new String[]{this.val$context.getResources().getString(R.l.dSp)} : new String[]{this.val$context.getResources().getString(R.l.dSw)};
            }
            this.val$context.getResources().getString(R.l.dSv);
            h.a(this.val$context, this.nNI, stringArray, "", new 1(this, replace), new 2(this));
            this.vuM.dismiss();
        } else if (this.val$context.getString(R.l.dSs).equals(str)) {
            c.a(this.val$context, replace, replace);
            g.pQN.k(10115, "1");
            if (this.vuJ != null) {
                this.vuJ.onDismiss(null);
            }
            this.vuM.dismiss();
            Toast.makeText(this.val$context, this.val$context.getString(R.l.dEt), 1).show();
        } else if (this.val$context.getString(R.l.dSt).equals(str)) {
            x.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
        } else if (k.vuI.equals(str)) {
            k.a((Activity) this.val$context, this.nNI, this.vuN);
            this.vuM.dismiss();
            if (this.vuJ != null) {
                this.vuJ.onDismiss(null);
            }
        } else {
            x.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
            this.vuM.dismiss();
            if (this.vuJ != null) {
                this.vuJ.onDismiss(null);
            }
        }
    }
}
