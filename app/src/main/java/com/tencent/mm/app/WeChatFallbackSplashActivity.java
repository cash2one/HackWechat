package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.splash.d.a;
import com.tencent.mm.splash.d.b;
import com.tencent.mm.splash.e;
import java.io.File;

public class WeChatFallbackSplashActivity extends Activity {
    private Runnable ffQ = new Runnable(this) {
        private long ffR = -1;
        final /* synthetic */ WeChatFallbackSplashActivity ffS;

        {
            this.ffS = r3;
        }

        public final void run() {
            if (this.ffR == -1) {
                this.ffR = System.currentTimeMillis();
            }
            if (WeChatFallbackSplashActivity.ud()) {
                e.a("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
                this.ffS.finish();
                this.ffS.overridePendingTransition(a.bpQ, a.bqa);
            } else if (System.currentTimeMillis() - this.ffR >= 80000) {
                e.a("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
                this.ffS.finish();
                this.ffS.overridePendingTransition(a.bpQ, a.bqa);
            } else {
                this.ffS.mHandler.postDelayed(this.ffS.ffQ, 100);
            }
        }
    };
    private Handler mHandler;

    static /* synthetic */ boolean ud() {
        String chh = com.tencent.mm.splash.a.chh();
        if (!new File(chh).exists()) {
            e.a("MicroMsg.FigLeaf", "dex opt dir not exists.", new Object[0]);
        } else if (new File(chh + "/main-process-blocking").exists()) {
            return false;
        }
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.xlw);
        e.a("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("splash-activity");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.postDelayed(this.ffQ, 100);
    }

    public void onBackPressed() {
        e.a("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
    }
}
