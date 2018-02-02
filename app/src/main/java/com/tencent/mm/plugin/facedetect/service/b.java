package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    String mAppId = "";
    long mgb = -1;

    public final void B(Intent intent) {
        this.mgb = intent.getLongExtra("k_bio_id", -1);
        this.mAppId = intent.getStringExtra("key_app_id");
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[]{Long.valueOf(this.mgb), this.mAppId});
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
        if (a.aHt().mkZ && (a.aHt().aHw() == a$a.mlB || a.aHt().aHw() == a$a.mlC || a.aHt().aHw() == a$a.mlD)) {
            a.aHt().a(new 1(this, bh.Wq()));
            return;
        }
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    }
}
