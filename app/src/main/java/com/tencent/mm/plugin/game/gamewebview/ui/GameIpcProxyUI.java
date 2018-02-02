package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class GameIpcProxyUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameIpcProxyUI", "onCreate");
        GameProcessActivityTask gameProcessActivityTask = (GameProcessActivityTask) getIntent().getParcelableExtra("task_object");
        String stringExtra = getIntent().getStringExtra("task_id");
        if (gameProcessActivityTask != null) {
            gameProcessActivityTask.a(this, new 1(this, gameProcessActivityTask, stringExtra));
            return;
        }
        setResult(1);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.GameIpcProxyUI", "onDestroy");
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void afg() {
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
    }
}
