package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity extends Activity {
    private int fqb;
    private int fqc;
    private String hKw;
    private String rsF = null;
    private c rsI = new 1(this);
    private boolean tvU = false;
    private String url;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        setContentView(R.i.dmy);
    }

    protected void onStart() {
        super.onStart();
        x.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!(this.tvU || getIntent() == null)) {
            this.rsF = getIntent().getStringExtra("key_string_for_scan");
            this.fqb = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.fqc = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            this.hKw = getIntent().getStringExtra("key_string_for_image_url");
            if (this.rsF != null) {
                b bzVar = new bz();
                bzVar.fqa.activity = this;
                bzVar.fqa.fov = this.rsF;
                bzVar.fqa.fqc = this.fqc;
                bzVar.fqa.fqb = this.fqb;
                bzVar.fqa.fqd = 6;
                bzVar.fqa.imagePath = this.hKw;
                bzVar.fqa.scene = 40;
                Bundle bundle = new Bundle();
                bundle.putString("stat_url", this.url);
                bundle.putInt("stat_scene", 4);
                bzVar.fqa.fqh = bundle;
                com.tencent.mm.sdk.b.a.xef.m(bzVar);
                com.tencent.mm.sdk.b.a.xef.b(this.rsI);
            }
        }
        this.tvU = true;
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        b ajVar = new aj();
        ajVar.fou.activity = this;
        ajVar.fou.fov = this.rsF;
        com.tencent.mm.sdk.b.a.xef.m(ajVar);
        com.tencent.mm.sdk.b.a.xef.c(this.rsI);
        finish();
    }
}
