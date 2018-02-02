package com.tencent.mm.plugin.y.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.LinkedList;

public interface a {

    public static class a {
        private static a oZN = null;

        public static void a(a aVar) {
            oZN = aVar;
        }

        public static a bis() {
            return oZN;
        }
    }

    f Hg(String str);

    void Hh(String str);

    void Z(LinkedList<String> linkedList);

    Bitmap a(String str, int i, float f);

    void bR(String str, int i);

    i biq();

    Cursor bir();

    void c(f fVar);

    void d(f fVar);

    Cursor df(int i, int i2);

    void e(f fVar);

    Cursor k(int[] iArr);

    Cursor uv(int i);
}
