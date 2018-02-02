package com.tencent.mm.ui.mogic;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class WxViewPager$c extends a {
    final /* synthetic */ WxViewPager zfx;

    WxViewPager$c(WxViewPager wxViewPager) {
        this.zfx = wxViewPager;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(WxViewPager.class.getName());
        f cj = f.cj();
        cj.setScrollable(bZ());
        if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE && WxViewPager.b(this.zfx) != null) {
            cj.setItemCount(WxViewPager.b(this.zfx).getCount());
            cj.setFromIndex(WxViewPager.c(this.zfx));
            cj.setToIndex(WxViewPager.c(this.zfx));
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(WxViewPager.class.getName());
        bVar.setScrollable(bZ());
        if (this.zfx.canScrollHorizontally(1)) {
            bVar.addAction(Downloads.RECV_BUFFER_SIZE);
        }
        if (this.zfx.canScrollHorizontally(-1)) {
            bVar.addAction(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                if (!this.zfx.canScrollHorizontally(1)) {
                    return false;
                }
                this.zfx.ah(WxViewPager.c(this.zfx) + 1);
                return true;
            case 8192:
                if (!this.zfx.canScrollHorizontally(-1)) {
                    return false;
                }
                this.zfx.ah(WxViewPager.c(this.zfx) - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean bZ() {
        return WxViewPager.b(this.zfx) != null && WxViewPager.b(this.zfx).getCount() > 1;
    }
}
