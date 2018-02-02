package com.tencent.mm.plugin.api;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.j;

public final class b extends com.tencent.mm.plugin.mmsight.api.b {
    private d iou;
    private VideoTransPara iov;

    public final void a(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        j.b(videoTransPara);
        this.iov = videoTransPara;
    }

    public final d XX() {
        if (this.iov != null) {
            k.baK();
            this.iou = k.c(this.iov);
        }
        return this.iou;
    }
}
