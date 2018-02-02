package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.ag;

class c$4 implements b {
    final /* synthetic */ long hAU;
    final /* synthetic */ ProgressDialog lpj;
    final /* synthetic */ c lpk;
    final /* synthetic */ Context val$context;

    c$4(c cVar, ProgressDialog progressDialog, long j, Context context) {
        this.lpk = cVar;
        this.lpj = progressDialog;
        this.hAU = j;
        this.val$context = context;
    }

    public final void ou(final int i) {
        ag.y(new Runnable(this) {
            final /* synthetic */ c$4 lpq;

            public final void run() {
                CharSequence format;
                if (this.lpq.lpj != null) {
                    this.lpq.lpj.dismiss();
                }
                if (i == 0) {
                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - this.lpq.hAU)) / 1.0E9f)});
                } else if (i == 1) {
                    format = "Database recovery canceled.";
                } else {
                    format = "Database recovery failed.";
                }
                Toast.makeText(this.lpq.val$context, format, 0).show();
            }
        });
    }
}
