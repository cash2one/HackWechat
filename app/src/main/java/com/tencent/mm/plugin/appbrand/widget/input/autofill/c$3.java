package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListView;
import com.tencent.mm.bv.a;

class c$3 implements OnPreDrawListener {
    final /* synthetic */ int iIS;
    final /* synthetic */ c kar;
    final /* synthetic */ ListView kas;

    c$3(c cVar, ListView listView, int i) {
        this.kar = cVar;
        this.kas = listView;
        this.iIS = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onPreDraw() {
        this.kas.getViewTreeObserver().removeOnPreDrawListener(this);
        c cVar = this.kar;
        if (cVar.kab.inJ.isShowing() && cVar.kab.kau != null && cVar.kab.kau.getAdapter() != null && cVar.kab.kau.getAdapter().getCount() > 0) {
            View inputPanel = cVar.kaa.getInputPanel();
            if (inputPanel != null) {
                AutoFillListPopupWindowBase autoFillListPopupWindowBase;
                int fromDPToPix = a.fromDPToPix(cVar.kaa.getContext(), 8);
                int height = cVar.kab.kau.getChildAt(0).getHeight();
                int count = cVar.kab.kau.getAdapter().getCount() * height;
                int i = count + (fromDPToPix * 2);
                int i2 = (height * 3) + (fromDPToPix * 2);
                if (i > i2) {
                    i = i2 - (fromDPToPix * 2);
                } else {
                    i2 = i;
                    i = count;
                }
                cVar.kab.SM = i2;
                int[] iArr = new int[2];
                cVar.kaa.getView().getLocationInWindow(iArr);
                count = iArr[1] + cVar.kaa.getView().getHeight();
                inputPanel.getLocationInWindow(iArr);
                c cVar2 = cVar;
                int i3 = iArr[1];
                i2 = height;
                height = count;
                count = i3;
                while (true) {
                    if ((cVar2.kap == Integer.MIN_VALUE || cVar2.kap >= 0 - fromDPToPix) && count - height >= i + fromDPToPix) {
                        break;
                    } else if (height - cVar2.kaa.getView().getHeight() >= i) {
                        break;
                    } else if (i <= i2) {
                        break;
                    } else {
                        i -= i2;
                    }
                    cVar.kab.show();
                    autoFillListPopupWindowBase = cVar.kab;
                    cVar.kap = autoFillListPopupWindowBase.SQ ? 0 : autoFillListPopupWindowBase.SO;
                }
                cVar2.kab.SW = cVar2.kaa.getView();
                cVar2.kab.SM = i + (fromDPToPix * 2);
                cVar2.kab.setVerticalOffset(0 - fromDPToPix);
                cVar.kab.show();
                autoFillListPopupWindowBase = cVar.kab;
                if (autoFillListPopupWindowBase.SQ) {
                }
                cVar.kap = autoFillListPopupWindowBase.SQ ? 0 : autoFillListPopupWindowBase.SO;
            }
        }
        return true;
    }
}
