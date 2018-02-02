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

class c$1 implements i {
    final /* synthetic */ String hAS;
    final /* synthetic */ String mWt;
    final /* synthetic */ a mWu;
    final /* synthetic */ c mWv;
    final /* synthetic */ Context val$context;

    c$1(c cVar, String str, Context context, String str2, a aVar) {
        this.mWv = cVar;
        this.mWt = str;
        this.val$context = context;
        this.hAS = str2;
        this.mWu = aVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.GameJsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
        a aVar;
        c cVar;
        if (bitmap == null || objArr == null || objArr.length <= 0) {
            aVar = this.mWu;
            cVar = this.mWv;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("addToEmoticon:fail", null));
        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
            aVar = this.mWu;
            cVar = this.mWv;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("addToEmoticon:fail", null));
        } else if (str.equals(this.mWt)) {
            File file = new File(objArr[0].toString());
            if (file.exists()) {
                String i = g.i(file);
                ar.Hg();
                FileOp.x(file.getAbsolutePath(), EmojiLogic.H(c.Fp(), "", i));
                this.mWv.a(this.val$context, i, this.hAS, this.mWu);
                return;
            }
            aVar = this.mWu;
            cVar = this.mWv;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("addToEmoticon:fail", null));
        } else {
            aVar = this.mWu;
            cVar = this.mWv;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("addToEmoticon:fail", null));
        }
    }
}
