package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d implements OnScrollListener {
    private OnScrollListener vjo;
    private ArrayList<WeakReference<a>> vjp;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public d() {
        this(null);
    }

    public d(OnScrollListener onScrollListener) {
        this.vjp = new ArrayList();
        this.vjo = onScrollListener;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.vjo != null) {
            this.vjo.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            kS(true);
        } else {
            kS(false);
        }
        if (this.vjo != null) {
            this.vjo.onScrollStateChanged(absListView, i);
        }
    }

    public final void a(a aVar) {
        this.vjp.add(new WeakReference(aVar));
    }

    private void kS(boolean z) {
        for (int i = 0; i < this.vjp.size(); i++) {
            WeakReference weakReference = (WeakReference) this.vjp.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.onScrollStateChanged(z);
                } else {
                    this.vjp.remove(i);
                }
            } else {
                this.vjp.remove(i);
            }
        }
    }
}
