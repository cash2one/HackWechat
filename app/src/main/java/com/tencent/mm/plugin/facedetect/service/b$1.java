package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a$b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a$b {
    final /* synthetic */ long miv;
    final /* synthetic */ b miw;

    b$1(b bVar, long j) {
        this.miw = bVar;
        this.miv = j;
    }

    public final void zN(String str) {
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[]{Long.valueOf(bh.bA(this.miv)), str});
        if (!bh.ov(str)) {
            Intent intent = new Intent(ac.getContext(), FaceUploadVideoService.class);
            intent.putExtra("key_video_file_name", str);
            intent.putExtra("k_bio_id", this.miw.mgb);
            intent.putExtra("key_app_id", this.miw.mAppId);
            ac.getContext().startService(intent);
        }
    }
}
