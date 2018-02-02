package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$24 implements OnClickListener {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$24(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void onClick(View view) {
        String kC = ImagePreviewUI.h(this.mUl).kC(ImagePreviewUI.g(this.mUl).intValue());
        if (bh.ov(kC)) {
            x.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[]{ImagePreviewUI.g(this.mUl)});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", kC);
        intent.putExtra("key_need_clip_video_first", true);
        d.b(this.mUl.mController.xIM, "mmsight", ".segment.MMSightEditUI", intent, 4370);
    }
}
