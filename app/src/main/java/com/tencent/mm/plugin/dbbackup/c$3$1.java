package com.tencent.mm.plugin.dbbackup;

import android.widget.Toast;
import com.tencent.mm.plugin.dbbackup.c.3;

class c$3$1 implements Runnable {
    final /* synthetic */ int lpl;
    final /* synthetic */ 3 lpp;

    c$3$1(3 3, int i) {
        this.lpp = 3;
        this.lpl = i;
    }

    public final void run() {
        CharSequence format;
        if (this.lpp.lpj != null) {
            this.lpp.lpj.dismiss();
        }
        if (this.lpl == 0) {
            format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - this.lpp.hAU)) / 1.0E9f)});
        } else if (this.lpl == 1) {
            format = "Database recovery canceled.";
        } else {
            format = "Database recovery failed.";
        }
        Toast.makeText(this.lpp.val$context, format, 0).show();
    }
}
