package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ViewPager.h;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b.a;
import java.io.Serializable;

public class DummyViewPager extends AdLandingViewPager implements Serializable {
    protected int rmJ;

    public DummyViewPager(Context context, AttributeSet attributeSet) {
        int i = 0;
        super(context, attributeSet);
        f aVar = new a();
        if (VERSION.SDK_INT >= 11) {
            if (1 != (this.zr != null ? 1 : 0)) {
                i = 1;
            }
            this.zr = aVar;
            if (VERSION.SDK_INT >= 7) {
                if (this.rmD == null) {
                    try {
                        this.rmD = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                    } catch (NoSuchMethodException e) {
                    }
                }
                try {
                    if (this.rmD != null) {
                        this.rmD.invoke(this, new Object[]{Boolean.valueOf(true)});
                    }
                } catch (Exception e2) {
                }
            }
            this.zt = 1;
            if (i != 0) {
                populate();
            }
        }
        this.zo = new h(this) {
            final /* synthetic */ DummyViewPager rmK;

            {
                this.rmK = r1;
            }

            public final void af(int i) {
                super.af(i);
                if (i == 0) {
                    this.rmK.rmJ = this.rmK.getScrollX();
                }
            }
        };
    }

    public final int bxC() {
        return this.rmJ;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
