package com.tencent.mm.plugin.dbbackup;

import android.widget.Toast;
import com.tencent.mm.plugin.dbbackup.c.2;

class c$2$1 implements Runnable {
    final /* synthetic */ int lpl;
    final /* synthetic */ 2 lpo;

    c$2$1(2 2, int i) {
        this.lpo = 2;
        this.lpl = i;
    }

    public final void run() {
        CharSequence format;
        if (this.lpo.lpj != null) {
            this.lpo.lpj.dismiss();
        }
        if (this.lpl == 0) {
            String str = "Database (%s) backup succeeded, elapsed %.2f seconds.";
            Object[] objArr = new Object[2];
            objArr[0] = this.lpo.lpn ? "incremental" : "new";
            objArr[1] = Float.valueOf(((float) (System.nanoTime() - this.lpo.hAU)) / 1.0E9f);
            format = String.format(str, objArr);
        } else if (this.lpl == 1) {
            format = "Database backup canceled.";
        } else {
            format = "Database backup failed.";
        }
        Toast.makeText(this.lpo.val$context, format, 0).show();
    }
}
