package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class VideoCompressUI$1 implements Runnable {
    final /* synthetic */ VideoCompressUI ozI;

    VideoCompressUI$1(VideoCompressUI videoCompressUI) {
        this.ozI = videoCompressUI;
    }

    public final void run() {
        VideoCompressUI.a(this.ozI, CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara());
        if (VideoCompressUI.a(this.ozI) == null) {
            x.e("VideoCompressUI", "VideoSendPreprocessTask para is null");
            this.ozI.setResult(0);
            this.ozI.finish();
            return;
        }
        e.post(VideoCompressUI.b(this.ozI), "video_remuxing_if_needed");
    }
}
