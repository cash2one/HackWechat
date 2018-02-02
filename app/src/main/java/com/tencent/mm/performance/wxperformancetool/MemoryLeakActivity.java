package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.tencent.mm.ca.b;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.af;

@TargetApi(17)
public class MemoryLeakActivity extends Activity {
    private AlertDialog ibC;
    private String ibD;
    private af mHandler = new 1(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.daM);
        Builder builder = new Builder(this);
        builder.setTitle("memory leak");
        this.ibD = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + b.xCV + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new 2(this, replace));
        builder.setNegativeButton("cancel", new 3(this));
        builder.setOnDismissListener(new 4(this));
        this.ibC = builder.create();
        b.cln();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
    }

    protected void onDestroy() {
        super.onDestroy();
        a.ibG.remove(this.ibD);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ibC != null && this.ibC.isShowing()) {
            this.ibC.dismiss();
            this.ibC = null;
        }
    }
}
