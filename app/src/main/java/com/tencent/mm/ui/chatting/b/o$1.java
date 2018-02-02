package com.tencent.mm.ui.chatting.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class o$1 extends c<aq> {
    final /* synthetic */ o yAu;

    o$1(o oVar) {
        this.yAu = oVar;
        this.xen = aq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aq aqVar = (aq) bVar;
        if (aqVar instanceof aq) {
            cf cfVar = aqVar.foJ.fnB;
            o oVar = this.yAu;
            if (oVar.fhr.csx() != null) {
                int firstVisiblePosition = oVar.fhr.csx().getFirstVisiblePosition();
                int lastVisiblePosition = oVar.fhr.csx().getLastVisiblePosition();
                if (firstVisiblePosition < 0 || lastVisiblePosition >= oVar.fhr.csx().getAdapter().getCount()) {
                    x.i("MicroMsg.ChattingUI.GetImageImp", "invalid position %d-%d, cnt:%d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(oVar.fhr.csx().getAdapter().getCount())});
                } else {
                    for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                        au auVar = (au) oVar.fhr.csx().getAdapter().getItem(i);
                        if (!(cfVar == null || auVar == null || auVar.field_msgId != cfVar.field_msgId)) {
                            View childAt = oVar.fhr.csx().getChildAt(i - firstVisiblePosition);
                            View view = null;
                            if (cfVar.cje() || cfVar.cjh() || cfVar.cji()) {
                                view = childAt.findViewById(R.h.bTI);
                            } else if (cfVar.cjm()) {
                                view = childAt.findViewById(R.h.bTo);
                            }
                            if (view != null) {
                                int[] iArr = new int[2];
                                view.getLocationInWindow(iArr);
                                aqVar.foK.foL = iArr[0];
                                aqVar.foK.foM = iArr[1];
                                aqVar.foK.foN = view.getWidth();
                                aqVar.foK.foO = view.getHeight();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
