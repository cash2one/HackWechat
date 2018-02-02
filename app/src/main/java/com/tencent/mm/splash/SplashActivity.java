package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.splash.d.a;
import java.util.Iterator;

public class SplashActivity extends Activity {
    private boolean xlQ = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a(this);
        e.a("WxSplash.SplashActivity", "onCreate", new Object[0]);
        if (!e.chq()) {
            e.a("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
            chC();
        }
        if (e.xlH != null) {
            e.xlH.c(this);
        }
    }

    protected void onResume() {
        super.onResume();
        e.a("WxSplash.SplashActivity", "onResume", new Object[0]);
    }

    protected void onPause() {
        e.a("WxSplash.SplashActivity", "onPause", new Object[0]);
        s.bYf();
        super.onPause();
    }

    protected void onDestroy() {
        e.b(this);
        e.a("WxSplash.SplashActivity", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (e.xlA != null) {
            e.xlA.a(this, i, strArr, iArr);
        }
    }

    private void chB() {
        if (e.xlA.b(this, new Runnable(this) {
            final /* synthetic */ SplashActivity xlR;

            {
                this.xlR = r1;
            }

            public final void run() {
                this.xlR.chB();
            }
        })) {
            chD();
        }
    }

    public final void chC() {
        if (e.xlA == null) {
            e.a("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
            chD();
        } else if (!e.xlA.a(this, new Runnable(this) {
            final /* synthetic */ SplashActivity xlR;

            {
                this.xlR = r1;
            }

            public final void run() {
                this.xlR.chB();
            }
        })) {
            chB();
        }
    }

    private void chD() {
        if (!this.xlQ) {
            this.xlQ = true;
            e.xlA = null;
            if (isFinishing()) {
                onBackPressed();
                return;
            }
            setResult(-100);
            int intExtra = getIntent().getIntExtra("hashcode", 0);
            Iterator it = e.xlx.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (intExtra == fVar.hashCode()) {
                    fVar.recreate();
                    e.a("WxSplash.SplashActivity", "do recreate", new Object[0]);
                    break;
                }
            }
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ SplashActivity xlR;

                {
                    this.xlR = r1;
                }

                public final void run() {
                    this.xlR.finish();
                    this.xlR.overridePendingTransition(a.bpQ, a.xlv);
                }
            }, 50);
        }
    }
}
