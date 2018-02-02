package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.k;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class ac extends a {
    final RecyclerView Va;
    final a Wj = new 1(this);

    public ac(RecyclerView recyclerView) {
        this.Va = recyclerView;
    }

    final boolean gb() {
        RecyclerView recyclerView = this.Va;
        return !recyclerView.Uc || recyclerView.Ul || recyclerView.TP.et();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (gb() || this.Va.TV == null) {
            return false;
        }
        h hVar = this.Va.TV;
        m mVar = hVar.Va.TN;
        RecyclerView$q recyclerView$q = hVar.Va.UB;
        if (hVar.Va == null) {
            return false;
        }
        int paddingTop;
        int i2;
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                paddingTop = z.h(hVar.Va, 1) ? (hVar.mHeight - hVar.getPaddingTop()) - hVar.getPaddingBottom() : 0;
                if (z.g(hVar.Va, 1)) {
                    i2 = paddingTop;
                    paddingTop = (hVar.mWidth - hVar.getPaddingLeft()) - hVar.getPaddingRight();
                    break;
                }
            case 8192:
                paddingTop = z.h(hVar.Va, -1) ? -((hVar.mHeight - hVar.getPaddingTop()) - hVar.getPaddingBottom()) : 0;
                if (z.g(hVar.Va, -1)) {
                    i2 = paddingTop;
                    paddingTop = -((hVar.mWidth - hVar.getPaddingLeft()) - hVar.getPaddingRight());
                    break;
                }
            default:
                paddingTop = 0;
                i2 = 0;
                break;
        }
        if (i2 == 0 && paddingTop == 0) {
            return false;
        }
        hVar.Va.scrollBy(paddingTop, i2);
        return true;
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(RecyclerView.class.getName());
        if (!gb() && this.Va.TV != null) {
            h hVar = this.Va.TV;
            m mVar = hVar.Va.TN;
            RecyclerView$q recyclerView$q = hVar.Va.UB;
            if (z.h(hVar.Va, -1) || z.g(hVar.Va, -1)) {
                bVar.addAction(8192);
                bVar.setScrollable(true);
            }
            if (z.h(hVar.Va, 1) || z.g(hVar.Va, 1)) {
                bVar.addAction(Downloads.RECV_BUFFER_SIZE);
                bVar.setScrollable(true);
            }
            b.zW.f(bVar.zX, new k(b.cc().a(hVar.a(mVar, recyclerView$q), hVar.b(mVar, recyclerView$q), false, 0)).zX);
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !gb()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.TV != null) {
                recyclerView.TV.onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}
