package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class ax$1 implements i {
    final /* synthetic */ String mWt;
    final /* synthetic */ a mWu;
    final /* synthetic */ ax mXk;
    final /* synthetic */ Context val$context;

    ax$1(ax axVar, String str, Context context, a aVar) {
        this.mXk = axVar;
        this.mWt = str;
        this.val$context = context;
        this.mWu = aVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.GameJsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        a aVar;
        ax axVar;
        if (bitmap == null || objArr == null || objArr.length <= 0) {
            aVar = this.mWu;
            axVar = this.mXk;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:fail", null));
        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
            aVar = this.mWu;
            axVar = this.mXk;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:fail", null));
        } else if (str.equals(this.mWt)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                String i = g.i(file);
                ar.Hg();
                FileOp.x(file.getAbsolutePath(), EmojiLogic.H(c.Fp(), "", i));
                this.mXk.b(this.val$context, i, this.mWu);
                return;
            }
            aVar = this.mWu;
            axVar = this.mXk;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:fail", null));
        } else {
            aVar = this.mWu;
            axVar = this.mXk;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:fail", null));
        }
    }
}
