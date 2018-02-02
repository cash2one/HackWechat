package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Message;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.af;

class VideoRecorderPreviewUI$2 extends af {
    final /* synthetic */ VideoRecorderPreviewUI rZP;

    VideoRecorderPreviewUI$2(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.rZP = videoRecorderPreviewUI;
    }

    public final void handleMessage(Message message) {
        this.rZP.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.rZP.mController.hideTitleView();
    }
}
