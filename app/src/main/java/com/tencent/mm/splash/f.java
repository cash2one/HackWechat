package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

final class f extends Activity {
    public String xlS;

    f() {
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
        setVisible(false);
        Intent intent = new Intent(this, e.chx());
        intent.putExtra("hashcode", hashCode());
        startActivityForResult(intent, 100);
    }

    protected final void onNewIntent(Intent intent) {
        e.a("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
        if (e.xlA != null && e.xlA.j(intent)) {
            finish();
        }
    }

    protected final void onResume() {
        super.onResume();
        e.a("WxSplash.SplashHackActivity", "onResume", new Object[0]);
    }

    protected final void onPause() {
        e.a("WxSplash.SplashHackActivity", "onPause", new Object[0]);
        super.onPause();
    }

    protected final void onDestroy() {
        e.a("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
        e.xlx.remove(this);
        setVisible(true);
        e.xlx.remove(this);
        super.onDestroy();
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        if (i != 100) {
            finish();
            e.a("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
        } else if (i2 != -100) {
            onBackPressed();
        }
    }
}
