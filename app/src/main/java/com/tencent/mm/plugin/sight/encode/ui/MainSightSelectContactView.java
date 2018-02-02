package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.sight.encode.ui.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, a, l {
    public ListView Fv;
    boolean qwD = false;
    public MMFragmentActivity qwI;
    public int qxh;
    public d qxi;
    Animation qxj;
    public c qxk;
    public View qxl;
    public a qxm;
    public LinearLayout qxn;
    private View qxo;
    private int qxp = -1;
    private int qxq = -1;
    public HashSet<String> qxr;
    public HashSet<String> qxs;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void btE() {
        if (this.qxn != null) {
            this.qxn.getChildAt(0).setVisibility(0);
            this.qxl.setVisibility(8);
            z(true, false);
            this.qxm.btu();
        }
    }

    public final void btD() {
        if (this.qxn != null) {
            this.qxn.getChildAt(0).setVisibility(8);
            this.qxl.setVisibility(0);
            List list = this.qxk.qwQ;
            list.remove("@search.tencent");
            list.remove("@sns.tencent");
            list.remove("@draft.tencent");
            b(list, false, true);
            this.qxm.btv();
            if (!this.qxm.AI()) {
                this.qxm.btw();
            }
            this.qxm.btx();
        }
    }

    public final void btF() {
        this.Fv.post(new Runnable(this) {
            final /* synthetic */ MainSightSelectContactView qxt;

            {
                this.qxt = r1;
            }

            public final void run() {
                if (this.qxt.qxp != this.qxt.qxk.getCount() || this.qxt.qxm.btt() < this.qxt.qxq) {
                    if (this.qxt.qxo != null) {
                        this.qxt.Fv.removeFooterView(this.qxt.qxo);
                    }
                    int d = this.qxt.qxq;
                    if (this.qxt.qxq < 0 || this.qxt.qxq > this.qxt.qxm.btt()) {
                        d = this.qxt.qxm.btt();
                    }
                    this.qxt.qxp = this.qxt.qxk.getCount();
                    this.qxt.qxq = d;
                    int i = 0;
                    int i2 = 0;
                    while (i < this.qxt.qxk.getCount()) {
                        View view = this.qxt.qxk.getView(i, null, this.qxt.Fv);
                        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        i2 += view.getMeasuredHeight();
                        if (i2 < d) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    d -= i2;
                    if (d > 0) {
                        this.qxt.qxo = new View(this.qxt.getContext());
                        this.qxt.qxo.setLayoutParams(new LayoutParams(-1, d));
                        this.qxt.qxo.setBackgroundResource(R.e.black);
                        this.qxt.Fv.addFooterView(this.qxt.qxo);
                    }
                }
            }
        });
    }

    private void b(List<String> list, boolean z, boolean z2) {
        if (!this.qwD && list != null) {
            if (z) {
                this.qxs.clear();
                this.qxr.clear();
                c.qwS = true;
                c.qwT = false;
            }
            if (this.qxk != null) {
                c cVar = this.qxk;
                cVar.clearCache();
                cVar.qwQ = list;
                cVar.notifyDataSetChanged();
            }
            if (z2) {
                btF();
            } else if (this.qxo != null) {
                this.Fv.removeFooterView(this.qxo);
            }
        }
    }

    public final void z(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        Collection<String> arrayList2 = new ArrayList();
        ar.Hg();
        Collection ciE = c.Fd().ciE();
        ciE.remove(q.FS());
        arrayList2.addAll(ciE);
        if (z) {
            arrayList.addAll(this.qxs);
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(arrayList2);
        }
        b(arrayList, z2, true);
    }

    public final Activity getActivity() {
        return this.qwI;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.qxr.contains(aVar.jLe.field_username);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.qxs.contains(aVar.jLe.field_username);
    }

    public final ListView btG() {
        return this.Fv;
    }

    public final LinkedList<String> btH() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(this.qxs);
        return linkedList;
    }

    public final boolean btI() {
        return this.qxs == null ? true : this.qxs.isEmpty();
    }

    final String hC(int i) {
        com.tencent.mm.ui.contact.a.a Gm = this.qxk.Gm(i);
        if (Gm == null) {
            return null;
        }
        af afVar = Gm.jLe;
        if (afVar != null) {
            return afVar.field_username;
        }
        return null;
    }

    public static boolean wo(int i) {
        return i == -1;
    }

    public final void bI(List<String> list) {
        b(list, false, false);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            bh.hideVKB(absListView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.qxn != null && absListView != null && this.qxn.getHeight() > 0 && this.qwI != null) {
            int height = this.qxn.getHeight() - this.qwI.getSupportActionBar().getHeight();
            int i4 = -this.qxn.getTop();
            if (i4 >= 0) {
                this.qxm.as(((float) i4) / ((float) height));
                boolean z = this.qxn.getTop() < 0 && this.qxn.getTop() <= (-height);
                this.qxm.if(z);
            }
        }
    }
}
