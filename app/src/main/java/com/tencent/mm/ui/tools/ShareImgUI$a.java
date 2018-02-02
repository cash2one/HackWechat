package com.tencent.mm.ui.tools;

import android.net.Uri;
import com.tencent.mm.pluginsdk.k.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.tools.ShareImgUI.c;
import java.io.File;

class ShareImgUI$a implements Runnable {
    private Uri aMK;
    final /* synthetic */ ShareImgUI zmI;
    private c zmR;

    public ShareImgUI$a(ShareImgUI shareImgUI, Uri uri, c cVar) {
        this.zmI = shareImgUI;
        this.aMK = uri;
        this.zmR = cVar;
    }

    public final void run() {
        this.zmI.filePath = ShareImgUI.a(this.zmI, this.aMK);
        if (bh.ov(this.zmI.filePath) || !new File(this.zmI.filePath).exists()) {
            if (ShareImgUI.aab(this.zmI.getContentResolver().getType(this.aMK)) == 3) {
                this.zmI.filePath = d.a(this.zmI.getContentResolver(), this.aMK);
            } else {
                this.zmI.filePath = d.a(this.zmI.getContentResolver(), this.aMK, 1);
            }
        }
        if (this.zmR != null) {
            this.zmR.cxB();
        }
    }
}
