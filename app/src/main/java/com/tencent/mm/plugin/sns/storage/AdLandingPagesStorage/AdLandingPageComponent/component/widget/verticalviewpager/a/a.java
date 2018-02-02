package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public final class a extends RecyclerView$a<t> implements b {
    int bgColor;
    private Context context;
    private int kDP;
    private int kDQ;
    private LinearLayoutManager riF;
    c rmN;
    LinkedHashMap<String, i> rmO = new LinkedHashMap();
    private LayoutInflater rmP;

    public class a extends t {
        private LinearLayout iVC;
        final /* synthetic */ a rmQ;

        public a(a aVar, View view) {
            this.rmQ = aVar;
            super(view);
            this.iVC = (LinearLayout) view.findViewById(f.cIu);
        }
    }

    public a(c cVar, int i, Context context, LinearLayoutManager linearLayoutManager) {
        this.riF = linearLayoutManager;
        this.rmN = cVar;
        this.bgColor = i;
        this.context = context;
        this.rmP = (LayoutInflater) this.context.getSystemService("layout_inflater");
        int[] dv = ac.dv(this.context);
        this.kDP = dv[0];
        this.kDQ = dv[1];
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g.qGo, viewGroup, false));
    }

    public final void a(t tVar, int i) {
        x.i("ContentAdapter", "display page " + this.rmN.id + ", pos " + i);
        a aVar = (a) tVar;
        aVar.iVC.removeAllViews();
        s sVar = (s) this.rmN.rnP.get(i);
        i iVar = (i) this.rmO.get(sVar.rgK);
        int i2 = this.bgColor;
        if (sVar.rgT != null && sVar.rgT.length() > 0) {
            try {
                i2 = Color.parseColor(sVar.rgT);
                aVar.iVC.setBackgroundColor(i2);
            } catch (Exception e) {
                x.e("ContentAdapter", "parse cellBackgroundColor error: %s", new Object[]{sVar.rgT});
            }
        }
        if (iVar != null) {
            iVar.a((s) this.rmN.rnP.get(i));
        } else {
            iVar = am.a(aVar.iVC.getContext(), sVar, aVar.iVC, i2);
            if (iVar != null) {
                this.rmO.put(sVar.rgK, iVar);
            }
        }
        if (iVar != null) {
            if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
            }
            aVar.iVC.addView(iVar.getView());
        }
    }

    public final int getItemViewType(int i) {
        return i;
    }

    public final int getItemCount() {
        return this.rmN.rnP.size();
    }

    public final boolean xd(int i) {
        if (i < this.riF.eZ() || i > this.riF.fa()) {
            x.v("ContentAdapter", "index %d not visible");
            return false;
        }
        i iVar = (i) this.rmO.get(((s) this.rmN.rnP.get(i)).rgK);
        if (iVar == null) {
            return false;
        }
        x.v("ContentAdapter", "comp %s, inScreenH %d", new Object[]{iVar, Integer.valueOf(a(iVar))});
        return a(iVar) >= (iVar.getView().getHeight() >>> 1);
    }

    private int a(i iVar) {
        if (iVar != null) {
            View view = iVar.getView();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = view.getHeight() + i;
            x.v("ContentAdapter", "comp %s , top %d,bottom %d ", new Object[]{iVar, Integer.valueOf(i), Integer.valueOf(height)});
            if (i >= 0 && height <= this.kDQ) {
                return view.getHeight();
            }
            if (i < 0 && height > 0 && height <= this.kDQ) {
                return height;
            }
            if (i < 0 && height > this.kDQ) {
                return this.kDQ;
            }
            if (i < this.kDQ && height > this.kDQ) {
                return this.kDQ - i;
            }
        }
        return 0;
    }

    public final void a(int i, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b bVar) {
        s sVar = (s) this.rmN.rnP.get(i);
        i iVar = (i) this.rmO.get(sVar.rgK);
        if (iVar != null) {
            iVar.bwH();
            iVar.X(a(iVar), iVar.getView().getHeight(), this.kDQ);
            if (sVar.type == 61 || sVar.type == 62) {
                List<Integer> arrayList = new ArrayList();
                for (Entry entry : bVar.riE.entrySet()) {
                    if (((b$a) entry.getValue()).rfE) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer intValue : arrayList) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i && xd(intValue2)) {
                        i iVar2 = (i) this.rmO.get(((s) this.rmN.rnP.get(intValue2)).rgK);
                        if (iVar2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar2;
                            if (aVar.rfC && this.rmN.rnQ && intValue2 == 0) {
                                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bwF();
                            } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).rfC) {
                                aVar.bwF();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void xc(int i) {
        if (i < 0 || i >= this.rmN.rnP.size()) {
            x.w("ContentAdapter", "endExposure index[%d], size[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.rmN.rnP.size())});
            return;
        }
        i iVar = (i) this.rmO.get(((s) this.rmN.rnP.get(i)).rgK);
        if (iVar != null) {
            iVar.bwI();
        }
    }

    public final void onDestroy() {
        for (Entry value : this.rmO.entrySet()) {
            ((i) value.getValue()).bwG();
        }
    }
}
