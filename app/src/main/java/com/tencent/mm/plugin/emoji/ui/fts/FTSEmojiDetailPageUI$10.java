package com.tencent.mm.plugin.emoji.ui.fts;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class FTSEmojiDetailPageUI$10 implements i {
    final /* synthetic */ FTSEmojiDetailPageUI lEU;

    FTSEmojiDetailPageUI$10(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.lEU = fTSEmojiDetailPageUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(FTSEmojiDetailPageUI.a(this.lEU).field_encrypturl)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                FTSEmojiDetailPageUI.a(this.lEU).field_md5 = g.i(file);
                FTSEmojiDetailPageUI fTSEmojiDetailPageUI = this.lEU;
                ar.Hg();
                FTSEmojiDetailPageUI.a(fTSEmojiDetailPageUI, EmojiLogic.H(c.Fp(), "", FTSEmojiDetailPageUI.a(this.lEU).field_md5));
                FileOp.x(file.getAbsolutePath(), FTSEmojiDetailPageUI.e(this.lEU));
                ag.y(new Runnable(this) {
                    final /* synthetic */ FTSEmojiDetailPageUI$10 lEX;

                    {
                        this.lEX = r1;
                    }

                    public final void run() {
                        FTSEmojiDetailPageUI.d(this.lEX.lEU);
                    }
                });
            }
        }
    }
}
