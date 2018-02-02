package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class g$102 implements i {
    final /* synthetic */ String mWt;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ String tJq;

    g$102(g gVar, String str, String str2, i iVar) {
        this.tIj = gVar;
        this.mWt = str;
        this.tJq = str2;
        this.tIg = iVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        if (bitmap == null || objArr == null || objArr.length <= 0) {
            g.a(this.tIj, this.tIg, "shareEmoticon:fail", null);
        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
            g.a(this.tIj, this.tIg, "shareEmoticon:fail", null);
        } else if (str.equals(this.mWt)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                String i = g.i(file);
                ar.Hg();
                FileOp.x(file.getAbsolutePath(), EmojiLogic.H(c.Fp(), "", i));
                g.a(this.tIj, i, this.tJq);
                return;
            }
            g.a(this.tIj, this.tIg, "shareEmoticon:fail", null);
        } else {
            g.a(this.tIj, this.tIg, "shareEmoticon:fail", null);
        }
    }
}
