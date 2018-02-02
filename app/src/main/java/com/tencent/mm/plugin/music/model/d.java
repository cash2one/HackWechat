package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.av.a;
import com.tencent.mm.av.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public f<String, Bitmap> gzu = new f(5);
    public a oJu;
    public g oJv = new g(this) {
        final /* synthetic */ d oJx;

        {
            this.oJx = r1;
        }

        public final void lC(String str) {
        }

        public final Bitmap a(String str, b bVar) {
            return null;
        }

        public final void a(String str, View view, b bVar) {
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            x.i(str2, str3, objArr);
            final a aVar = (a) view.getTag();
            if (bVar.bitmap != null && aVar != null) {
                this.oJx.a(aVar, bVar.bitmap);
                final int[] o = c.o(bVar.bitmap);
                if (!aVar.e(o)) {
                    h.bdA().M(aVar.field_musicId, o[0], o[1]);
                }
                if (this.oJx.oJu != null) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 oJz;

                        public final void run() {
                            this.oJz.oJx.oJu.a(aVar, o);
                        }
                    });
                }
            }
        }
    };
    public af oJw = new af(Looper.getMainLooper());

    public final void a(a aVar, Bitmap bitmap) {
        x.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", new Object[]{aVar.field_musicId});
        this.gzu.put(aVar.field_musicId, bitmap);
    }
}
