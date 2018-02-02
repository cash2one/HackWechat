package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.e;

public interface l {

    public static class a {
        private static final android.support.v4.e.a<e, Bitmap> jNj = new android.support.v4.e.a();

        public static l b(Context context, e eVar) {
            Bitmap bitmap = (Bitmap) jNj.remove(eVar);
            if (bitmap != null && !bitmap.isRecycled()) {
                return new e(context, eVar, bitmap);
            }
            if (eVar.Yy()) {
                return new d(context, eVar);
            }
            if (eVar.Yz()) {
                return new b(context, eVar);
            }
            return new g(context, eVar);
        }

        public static void a(e eVar, Bitmap bitmap) {
            if (eVar != null && bitmap != null && !bitmap.isRecycled()) {
                jNj.put(eVar, bitmap);
            }
        }
    }

    void a(d dVar);

    void akA();

    void akz();

    void bA(String str, String str2);

    View getView();
}
