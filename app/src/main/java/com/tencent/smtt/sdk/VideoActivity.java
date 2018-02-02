package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.wcdb.database.SQLiteDatabase;

public class VideoActivity extends Activity {
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        y.hv(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            y hv = y.hv(super.getApplicationContext());
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            if (!TextUtils.isEmpty(null)) {
                bundleExtra.putString("videoUrl", null);
            }
            bundleExtra.putInt("callMode", 1);
            z zVar = hv.zYT;
            zVar.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            if (zVar.zYV == null) {
                h.nO(true).a(zVar.getContext().getApplicationContext(), null);
                aa cDV = h.nO(true).cDV();
                DexLoader dexLoader = cDV != null ? cDV.zZb : null;
                if (dexLoader != null && QbSdk.canLoadVideo(zVar.getContext())) {
                    zVar.zYV = new ac(dexLoader);
                }
            }
            if (zVar.zYV != null && zVar.zYU == null) {
                zVar.zYU = zVar.zYV.hw(zVar.getContext().getApplicationContext());
            }
            boolean z = false;
            if (zVar.cFa()) {
                bundleExtra.putInt("callMode", bundleExtra.getInt("callMode"));
                z = zVar.zYV.a(zVar.zYU, bundleExtra, zVar, null);
            }
            if (!z) {
                if (zVar.zYW != null) {
                    zVar.zYW.stopPlayback();
                }
                if (zVar.zYW == null) {
                    zVar.zYW = new VideoView(zVar.getContext());
                }
                zVar.mUrl = bundleExtra.getString("videoUrl");
                zVar.zYW.setVideoURI(Uri.parse(zVar.mUrl));
                zVar.zYW.setOnErrorListener(zVar);
                intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Context applicationContext = zVar.getContext().getApplicationContext();
                intent.setPackage(applicationContext.getPackageName());
                applicationContext.startActivity(intent);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        y.hv(this).n(this, 4);
    }

    protected void onPause() {
        super.onPause();
        y.hv(this).n(this, 3);
    }

    protected void onResume() {
        super.onResume();
        y.hv(this).n(this, 2);
    }

    protected void onStop() {
        super.onStop();
        y.hv(this).n(this, 1);
    }
}
