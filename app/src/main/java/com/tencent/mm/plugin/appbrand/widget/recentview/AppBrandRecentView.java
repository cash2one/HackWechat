package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.util.AttributeSet;
import android.view.View;

public abstract class AppBrandRecentView extends RecyclerView {
    public b kfc;
    public com.tencent.mm.plugin.appbrand.widget.recentview.d.a kfd;

    public interface a {
        boolean a(View view, a aVar, float f, float f2);

        boolean b(View view, a aVar, float f, float f2);
    }

    public abstract void a(a aVar);

    public abstract RecyclerView$a fm();

    public abstract int getCount();

    public abstract void refresh();

    public abstract void release();

    public AppBrandRecentView(Context context) {
        super(context);
    }

    public AppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
