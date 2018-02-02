package com.tencent.mm.plugin.appbrand.compat.a;

import android.graphics.Bitmap;
import android.view.View;
import java.util.List;

public interface b {

    public interface e {
        View a(h hVar);
    }

    public interface g {
        f abA();

        f abB();
    }

    public interface h extends d {
        f abE();

        void b(f fVar);

        float getRotation();

        String getSnippet();

        String getTitle();

        void hideInfoWindow();

        boolean isInfoWindowShown();

        void qw(String str);

        void remove();

        void setRotation(float f);

        void showInfoWindow();
    }

    public interface j {
        void b(h hVar);
    }

    public interface o extends d {
    }

    public interface p {
        void a(Iterable<f> iterable);

        void jN(int i);

        void jO(int i);

        void jP(int i);

        void jQ(int i);

        void q(Bitmap bitmap);

        void setDottedLine(boolean z);
    }

    b a(c cVar);

    h a(i iVar);

    o a(p pVar);

    void a(double d, double d2, int i);

    void a(e eVar);

    void a(j jVar);

    void a(k kVar);

    void a(l lVar);

    void a(m mVar);

    void a(n nVar);

    boolean a(View view, double d, double d2);

    f abu();

    q abv();

    i abw();

    c abx();

    p aby();

    void animateTo(double d, double d2);

    boolean b(View view, double d, double d2);

    void c(List<f> list, int i);

    void clean();

    f e(double d, double d2);

    View getView();

    int getZoomLevel();

    void jM(int i);

    void setCenter(double d, double d2);
}
