package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o extends i {
    private static final Map<String, Bitmap> rjX = new WeakHashMap();
    ViewPager rjY;
    a rjZ;
    AdLandingControlView rka;
    private int rkb = 0;
    private int rkc = 0;
    boolean rkd = true;

    public o(Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
        this.rka = new AdLandingControlView(context);
    }

    public final void bwH() {
        this.rjZ.wX(this.rjY.yF);
        if (this.rkd) {
            this.rjZ.wY(0);
            this.rkd = false;
        } else {
            this.rjZ.wY(this.rkc);
        }
        super.bwH();
    }

    public final void bwI() {
        this.rjZ.wY(-1);
        super.bwI();
    }

    public final void Q(Map<String, Object> map) {
        super.Q(map);
        if (map.containsKey("startIndex")) {
            try {
                this.rkb = ((Integer) map.get("startIndex")).intValue();
                this.rjY.d(this.rkb, false);
            } catch (Exception e) {
            }
        }
    }

    public final void bxg() {
        super.bxg();
        this.rjY.d(this.rkb, false);
    }

    protected final void bxa() {
        a aVar;
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = (windowManager.getDefaultDisplay().getWidth() - ((int) ((n) this.rji).rgO)) - ((int) ((n) this.rji).rgP);
        int height = windowManager.getDefaultDisplay().getHeight();
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.rjY.yE == null) {
            u aVar2 = new a(this.context, layoutInflater, (n) this.rji, this.backgroundColor);
            this.rjY.zo = new 1(this, aVar2);
            this.rjY.a(aVar2);
            aVar = aVar2;
        } else {
            a aVar3 = (a) this.rjY.yE;
            aVar3.rkg = (n) this.rji;
            aVar = aVar3;
        }
        this.rka.eR(((n) this.rji).rgv.size(), 0);
        if (((n) this.rji).rgy) {
            this.rjY.setLayoutParams(new LayoutParams(width, height));
        } else if (((n) this.rji).rgv.size() > 0) {
            m mVar = (m) ((n) this.rji).rgv.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i = 0;
            Iterator it = mVar.rgv.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                int i2 = (int) (((float) i) + sVar.rgM);
                if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u uVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u) sVar;
                    View inflate = layoutInflater.inflate(g.qGU, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(f.qDB)).setText(uVar.rhh);
                    ((TextView) inflate.findViewById(f.qDB)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = ((TextView) inflate.findViewById(f.qDB)).getPaddingBottom() + ((i2 + ((TextView) inflate.findViewById(f.qDB)).getPaddingTop()) + ((TextView) inflate.findViewById(f.qDB)).getHeight());
                } else if (sVar instanceof l) {
                    Button button = (Button) layoutInflater.inflate(g.qGM, null).findViewById(f.qDG);
                    button.setText(((l) sVar).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    int paddingTop = button.getPaddingTop() + i2;
                    if (sVar.rgR > 0.0f && ((int) sVar.rgR) != Integer.MAX_VALUE) {
                        paddingTop = (int) (((float) paddingTop) + sVar.rgR);
                    } else if (sVar.height <= 0.0f || ((int) sVar.height) == Integer.MAX_VALUE) {
                        paddingTop += button.getHeight();
                    } else {
                        paddingTop = (int) (((float) paddingTop) + sVar.height);
                    }
                    i = button.getPaddingBottom() + paddingTop;
                } else if (sVar instanceof p) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = sVar.rgM;
                    float f4 = sVar.rgN;
                    if (sVar instanceof p) {
                        p pVar = (p) sVar;
                        f = pVar.height;
                        f2 = pVar.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i = i2 + height;
                    } else {
                        i = (int) (((f * ((float) width)) / f2) + ((float) i2));
                    }
                    i = (int) (((float) ((int) (((float) i) + f3))) + f4);
                } else if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                    i = i2 + height;
                } else if (sVar instanceof q) {
                    q qVar = (q) sVar;
                    if (qVar.rgH == 1) {
                        i = i2 + height;
                    } else if (((int) qVar.width) > 0) {
                        i = ((((int) qVar.height) * width) / ((int) qVar.width)) + i2;
                    } else {
                        i = (int) (qVar.height + ((float) i2));
                    }
                } else if (sVar instanceof w) {
                    w wVar = (w) sVar;
                    if (wVar.rho != 1) {
                        i = i2 + height;
                    } else if (((int) wVar.width) > 0) {
                        i = ((((int) wVar.height) * width) / ((int) wVar.width)) + i2;
                    } else {
                        i = (int) (wVar.height + ((float) i2));
                    }
                } else if (sVar instanceof v) {
                    i = i2 + height;
                } else {
                    i = i2;
                }
                i = (int) (sVar.rgN + ((float) i));
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(width, i);
            layoutParams.leftMargin = (int) ((n) this.rji).rgO;
            layoutParams.rightMargin = (int) ((n) this.rji).rgP;
            this.rjY.setLayoutParams(layoutParams);
        }
        this.rjZ = aVar;
        aVar.notifyDataSetChanged();
    }

    public final View bwW() {
        View view = this.contentView;
        this.rjY = (ViewPager) view.findViewById(f.qDT);
        this.rka = (AdLandingControlView) view.findViewById(f.qDC);
        return view;
    }

    protected final int bjK() {
        return g.qGW;
    }

    public final boolean S(JSONObject jSONObject) {
        if (super.S(jSONObject)) {
            return true;
        }
        return false;
    }

    public final LinkedList<JSONObject> bxp() {
        a aVar = this.rjZ;
        LinkedList<JSONObject> linkedList = new LinkedList();
        for (String str : aVar.rkl.keySet()) {
            a aVar2 = (a) aVar.rkl.get(str);
            if (!(aVar2 == null || aVar2.rkr.size() == 0)) {
                for (int i = 0; i < aVar2.rkr.size(); i++) {
                    i iVar = (i) aVar2.rkr.get(i);
                    JSONObject jSONObject = new JSONObject();
                    if (iVar.S(jSONObject)) {
                        linkedList.add(jSONObject);
                    }
                }
            }
        }
        return linkedList;
    }
}
