package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements Runnable {
    final /* synthetic */ i jXw;

    i$3(i iVar) {
        this.jXw = iVar;
    }

    public final void run() {
        x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
        y q = m.q(i.a(this.jXw));
        if (q != null && i.a(this.jXw).isRunning() && q.getInputPanel() != null && q.getWidget() != null) {
            View widget = q.getWidget();
            View inputPanel = q.getInputPanel();
            if (!j.bK(widget) && q.adjustPositionOnFocused()) {
                if (inputPanel.getHeight() <= inputPanel.getMinimumHeight()) {
                    x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[]{Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(i.d(this.jXw))});
                    if (i.e(this.jXw) < 5) {
                        i.f(this.jXw);
                        return;
                    }
                    return;
                }
                i.g(this.jXw);
                x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[]{Integer.valueOf(inputPanel.getHeight())});
                ag.y(new 1(this, q, inputPanel.getHeight()));
                int[] iArr = new int[2];
                widget.getLocationOnScreen(iArr);
                int i = iArr[1];
                x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[]{Integer.valueOf(widget.getHeight()), Integer.valueOf(i), Boolean.valueOf(z.ak(widget))});
                if (i <= i.h(this.jXw)) {
                    int i2;
                    int i3;
                    int height = widget.getHeight() + i;
                    inputPanel.getLocationOnScreen(iArr);
                    int i4 = iArr[1];
                    if (!((z) widget).amK() || widget.getLayout() == null) {
                        i2 = height;
                        i3 = i;
                    } else {
                        i3 = i + ((z) widget).me(widget.getLayout().getLineForOffset(widget.getSelectionStart()));
                        int me = i + ((z) widget).me(widget.getLayout().getLineForOffset(widget.getSelectionStart()) + 1);
                        i2 = i3 - i >= widget.getHeight() ? height - widget.getLineHeight() : i3;
                        if (me - i >= widget.getHeight()) {
                            i3 = i2;
                            i2 = height;
                        } else {
                            i3 = i2;
                            i2 = me;
                        }
                    }
                    i2 += q.getInputPanelMarginBottom();
                    if (i4 < i2) {
                        i3 = Math.max(0, Math.min(i2 - i4, i3 - i.i(this.jXw)));
                        t tVar = i.a(this.jXw).jDS;
                        if (tVar != null) {
                            View view = tVar.getView();
                            if (view != null && widget != null) {
                                if (((z) widget).amO() || !((z) widget).amK()) {
                                    lU(amE() + i3);
                                    return;
                                }
                                i2 = tVar.getHeight();
                                i = view.getScrollY();
                                height = f.lI(tVar.getContentHeight());
                                widget.getHeight();
                                widget.getTop();
                                i2 = Math.max(0, Math.min((height - i) - i2, i3));
                                view.scrollBy(view.getScrollX(), i2);
                                lU((i3 - i2) + amE());
                            }
                        }
                    }
                }
            }
        }
    }

    private int amE() {
        View b = i.b(this.jXw);
        if (b != null) {
            return b.getScrollY();
        }
        return 0;
    }

    private void lU(int i) {
        x.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[]{Integer.valueOf(i)});
        View b = i.b(this.jXw);
        if (b != null) {
            b.scrollTo(0, i);
            i.j(this.jXw);
        }
    }
}
