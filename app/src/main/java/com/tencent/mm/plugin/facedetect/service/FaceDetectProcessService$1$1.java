package com.tencent.mm.plugin.facedetect.service;

import android.os.Bundle;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.1;

class FaceDetectProcessService$1$1 implements Runnable {
    final /* synthetic */ FaceResult miq;
    final /* synthetic */ 1 mir;

    FaceDetectProcessService$1$1(1 1, FaceResult faceResult) {
        this.mir = 1;
        this.miq = faceResult;
    }

    public final void run() {
        String a = n.a(this.miq);
        Bundle bundle = new Bundle();
        bundle.putInt("key_face_result_code", 0);
        bundle.putString("key_face_result_file_path", a);
        FaceDetectProcessService.a(this.mir.mip, bundle);
    }
}
