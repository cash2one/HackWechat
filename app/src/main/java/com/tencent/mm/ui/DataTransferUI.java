package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

@a(19)
public class DataTransferUI extends MMBaseActivity {
    private r jLf;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(R.l.dGO);
        this.jLf = h.a((Context) this, getString(R.l.dEv), false, null);
        new 1(this).sendEmptyMessageDelayed(0, 60000);
        ai(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        ai(intent);
    }

    private void ai(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        x.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
    }

    protected void onPause() {
        x.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.jLf != null && this.jLf.isShowing()) {
            this.jLf.dismiss();
        }
    }
}
