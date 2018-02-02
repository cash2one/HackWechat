package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.17;
import com.tencent.mm.ui.tools.g.b;

class ImageGalleryUI$17$1 implements b {
    final /* synthetic */ 17 yFA;

    ImageGalleryUI$17$1(17 17) {
        this.yFA = 17;
    }

    public final void onAnimationStart() {
        if (this.yFA.yFy.yFj != null) {
            this.yFA.yFy.yFj.j(Boolean.valueOf(true));
        }
    }

    public final void onAnimationEnd() {
        ImageGalleryUI.p(this.yFA.yFy).post(new 1(this));
    }
}
