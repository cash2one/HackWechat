package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IPCallFeedbackDialogUI extends MMActivity {
    private g nKv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
        this.nKv = new g(this, this.mController.xIM, getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0));
        this.nKv.setOnDismissListener(new 1(this));
        this.nKv.getWindow().setSoftInputMode(16);
        this.nKv.show();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        x.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
        super.onResume();
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        x.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
        super.onDestroy();
    }

    public void finish() {
        x.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
        if (this.nKv != null && this.nKv.isShowing()) {
            this.nKv.dismiss();
            this.nKv = null;
        }
        super.finish();
    }
}
