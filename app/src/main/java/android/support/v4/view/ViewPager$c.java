package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class ViewPager$c extends a {
    final /* synthetic */ ViewPager zx;

    ViewPager$c(ViewPager viewPager) {
        this.zx = viewPager;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        f a = a.a(accessibilityEvent);
        a.setScrollable(bZ());
        if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE && ViewPager.b(this.zx) != null) {
            a.setItemCount(ViewPager.b(this.zx).getCount());
            a.setFromIndex(ViewPager.c(this.zx));
            a.setToIndex(ViewPager.c(this.zx));
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(ViewPager.class.getName());
        bVar.setScrollable(bZ());
        if (this.zx.canScrollHorizontally(1)) {
            bVar.addAction(Downloads.RECV_BUFFER_SIZE);
        }
        if (this.zx.canScrollHorizontally(-1)) {
            bVar.addAction(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                if (!this.zx.canScrollHorizontally(1)) {
                    return false;
                }
                this.zx.ah(ViewPager.c(this.zx) + 1);
                return true;
            case 8192:
                if (!this.zx.canScrollHorizontally(-1)) {
                    return false;
                }
                this.zx.ah(ViewPager.c(this.zx) - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean bZ() {
        return ViewPager.b(this.zx) != null && ViewPager.b(this.zx).getCount() > 1;
    }
}
