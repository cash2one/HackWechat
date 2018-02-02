package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import b.c.b.e;
import com.tencent.mm.pluginsdk.ui.j;

public final class b extends j implements com.tencent.mm.ad.d.a {

    public static final class a {
        private static com.tencent.mm.pluginsdk.ui.j.a pxR;
        public static final a pxS = new a();

        private a() {
        }

        public static com.tencent.mm.pluginsdk.ui.j.a bly() {
            return pxR;
        }

        public static void a(com.tencent.mm.pluginsdk.ui.j.a aVar) {
            e.i(aVar, "loader");
            pxR = aVar;
        }

        public static void a(ImageView imageView, String str) {
            b bVar;
            e.i(imageView, "iv");
            e.i(str, "tag");
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str);
            } else {
                bVar = (b) drawable;
            }
            bVar.qw(str);
            imageView.setImageDrawable(bVar);
        }
    }

    private b(String str) {
        a aVar = a.pxS;
        super(a.bly(), str);
    }

    public final void jh(String str) {
        e.i(str, "tag");
        super.jh(str);
    }
}
