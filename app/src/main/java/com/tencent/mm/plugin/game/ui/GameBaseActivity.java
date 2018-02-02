package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity extends MMActivity {
    private long mStartTime = 0;
    private int nlH = 1;
    private long nlI = 0;
    private long nlJ = 0;

    public abstract int aRr();

    public abstract int aRs();

    public abstract int aRt();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        if (this.mStartTime == 0) {
            this.mStartTime = System.currentTimeMillis();
        }
        this.nlJ = System.currentTimeMillis();
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.nlI += System.currentTimeMillis() - this.nlJ;
    }

    public void onDestroy() {
        if (this.mStartTime != 0) {
            x.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", getClass().getSimpleName(), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Long.valueOf(this.nlI));
            if (aRq()) {
                ap.a(this.nlH, aRr(), aRs(), (long) aRt(), "", null, "", r8 / 1000, this.nlI / 1000, null);
            }
        }
        super.onDestroy();
    }

    public boolean aRq() {
        return true;
    }
}
