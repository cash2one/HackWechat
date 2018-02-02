package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.j.b;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class AppBrandStarListUI$a extends Fragment {
    private View jLW;
    private RecyclerView jLX;
    private e jLY;
    private GridLayoutManager jLZ;
    private View jMa;
    private TextView jMb;
    boolean jMc = false;
    final ArrayList<i> jMd = new ArrayList(10);
    private final a jMe = new a(this) {
        final /* synthetic */ AppBrandStarListUI$a jMg;

        {
            this.jMg = r1;
        }

        public final void a(String str, l lVar) {
            if (2 == lVar.iYZ || 3 == lVar.iYZ) {
                List jF = f.Zn().jF(b.iJS);
                if (this.jMg.getActivity() != null) {
                    this.jMg.getActivity().runOnUiThread(new 1(this, jF));
                }
            }
        }
    };
    private c jMf = c.jMs;

    static /* synthetic */ void b(AppBrandStarListUI$a appBrandStarListUI$a) {
        if (appBrandStarListUI$a.jLW != null && appBrandStarListUI$a.jLZ != null) {
            int width = appBrandStarListUI$a.jLW.getWidth() / com.tencent.mm.bv.a.aa(appBrandStarListUI$a.getActivity(), e.isO);
            if (width != appBrandStarListUI$a.jLZ.Rw) {
                appBrandStarListUI$a.jLZ.aZ(width);
                appBrandStarListUI$a.jLZ.requestLayout();
            }
        }
    }

    static /* synthetic */ void g(AppBrandStarListUI$a appBrandStarListUI$a) {
        appBrandStarListUI$a.jMc = true;
        appBrandStarListUI$a.jLW.post(new Runnable(appBrandStarListUI$a) {
            final /* synthetic */ AppBrandStarListUI$a jMg;

            {
                this.jMg = r1;
            }

            public final void run() {
                this.jMg.a(c.jMq);
            }
        });
    }

    final void a(c cVar) {
        this.jMf = cVar;
        if (this.jLY != null) {
            this.jLY.b(0, this.jMd.size(), cVar.tag);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jLW = layoutInflater.inflate(h.ixs, null);
        this.jLX = (RecyclerView) this.jLW.findViewById(g.iwA);
        getActivity();
        this.jLZ = new GridLayoutManager();
        this.jLY = new e(this);
        this.jLX.a(new d(this));
        this.jLX.a(new 3(this));
        this.jLX.a(this.jLZ);
        this.jLX.a(this.jLY);
        this.jMa = this.jLW.findViewById(g.iwy);
        this.jMb = (TextView) this.jLW.findViewById(g.iwz);
        this.jLW.post(new 4(this));
        f.Zn().a(this.jMe, c.Dm().oAt.getLooper());
        return this.jLW;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        f.Zn().j(this.jMe);
        try {
            for (Field field : getClass().getFields()) {
                if (field.isAccessible()) {
                    field.set(this, null);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.jLW != null) {
            final ViewTreeObserver viewTreeObserver = this.jLW.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ AppBrandStarListUI$a jMg;
                    int jMo = 0;

                    public final void onGlobalLayout() {
                        int i = this.jMo + 1;
                        this.jMo = i;
                        if (i >= 2) {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                            AppBrandStarListUI$a.b(this.jMg);
                        }
                    }
                });
            }
        }
    }

    void akO() {
        if (this.jMb != null && this.jMa != null) {
            if (this.jMd.size() >= 10) {
                this.jMa.setVisibility(0);
                this.jMb.setText(getResources().getString(j.iBs, new Object[]{Integer.valueOf(10)}));
                return;
            }
            this.jMa.setVisibility(8);
        }
    }
}
