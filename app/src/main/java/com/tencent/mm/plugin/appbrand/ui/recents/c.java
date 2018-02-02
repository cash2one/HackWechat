package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.ui.recents.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

final class c extends h implements a {
    private ViewGroup jFk;
    private List<h> jPJ;
    private final a jPK;

    c(Activity activity, ViewGroup viewGroup) {
        if (activity == null || viewGroup == null) {
            throw new IllegalStateException("Unexpected parameters");
        }
        this.jPK = new a(this, activity, (byte) 0);
        ViewGroup linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.jFk = linearLayout;
        linearLayout = this.jFk;
        List arrayList = new ArrayList(2);
        h eVar = new e(activity, linearLayout);
        eVar.jQN = this;
        arrayList.add(eVar);
        eVar = new f(activity, linearLayout);
        eVar.jQN = this;
        arrayList.add(eVar);
        this.jPJ = arrayList;
        a(this.jPJ, this.jFk);
        ad(this.jPJ);
    }

    private void a(List<h> list, ViewGroup viewGroup) {
        if (list != null && list.size() != 0 && viewGroup != null) {
            View view;
            for (int i = 0; i < list.size(); i++) {
                viewGroup.addView(((h) list.get(i)).alv());
                if (i != list.size() - 1) {
                    view = new View(viewGroup.getContext());
                    view.setBackgroundColor(-1);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jPK.jPM, this.jPK.jPL);
                    layoutParams.gravity = 3;
                    viewGroup.addView(view, layoutParams);
                }
            }
            Context context = viewGroup.getContext();
            Drawable colorDrawable = new ColorDrawable(this.jPK.jPP);
            view = new ImageView(context);
            view.setImageDrawable(colorDrawable);
            view.setBackgroundColor(-1);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.jPK.jPQ);
            viewGroup.addView(view, 0, layoutParams2);
            View imageView = new ImageView(context);
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
            viewGroup.addView(imageView, layoutParams2);
            viewGroup.addView(new View(context), -1, this.jPK.jPO);
            imageView = new ImageView(context);
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
            viewGroup.addView(imageView, -1, this.jPK.jPQ);
        }
    }

    private static void ad(List<h> list) {
        if (list != null) {
            for (h dk : list) {
                dk.dk(false);
            }
        }
    }

    final void alu() {
        for (h alu : this.jPJ) {
            alu.alu();
        }
    }

    final void onDetached() {
        for (h onDetached : this.jPJ) {
            onDetached.onDetached();
        }
    }

    final void onResume() {
        for (h onResume : this.jPJ) {
            onResume.onResume();
        }
    }

    final View alv() {
        return this.jFk;
    }

    public final void a(h hVar, View view, boolean z) {
        if (this.jFk != null) {
            h hVar2;
            View childAt;
            int i;
            x.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", hVar, view, Boolean.valueOf(z));
            if (!(this.jFk == null || this.jPJ == null)) {
                for (int i2 = 0; i2 < this.jPJ.size() - 1; i2++) {
                    hVar2 = (h) this.jPJ.get(i2);
                    if (hVar2 != null) {
                        if (hVar2.alz()) {
                            int i3;
                            for (int i4 = i2 + 1; i4 < this.jPJ.size(); i4++) {
                                h hVar3 = (h) this.jPJ.get(i4);
                                if (hVar3 != null && hVar3.alz()) {
                                    i3 = 1;
                                    break;
                                }
                            }
                            i3 = 0;
                            if (i3 != 0) {
                                childAt = this.jFk.getChildAt(this.jFk.indexOfChild(hVar2.alv()) + 1);
                                if (childAt != null) {
                                    childAt.setVisibility(0);
                                }
                            }
                        } else {
                            childAt = this.jFk.getChildAt(this.jFk.indexOfChild(hVar2.alv()) + 1);
                            if (childAt != null) {
                                childAt.setVisibility(8);
                            }
                        }
                    }
                }
            }
            for (h hVar22 : this.jPJ) {
                childAt = hVar22.alv();
                if (childAt != null && childAt.getVisibility() == 0) {
                    x.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", hVar);
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i != 0) {
                this.jFk.setVisibility(0);
            } else {
                this.jFk.setVisibility(8);
            }
        }
    }
}
