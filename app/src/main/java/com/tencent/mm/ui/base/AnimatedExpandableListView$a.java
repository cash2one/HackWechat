package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.mm.ui.base.AnimatedExpandableListView.b;
import com.tencent.mm.ui.base.AnimatedExpandableListView.d;

public abstract class AnimatedExpandableListView$a extends BaseExpandableListAdapter {
    private SparseArray<d> xXt = new SparseArray();
    private AnimatedExpandableListView xXu;

    public abstract View d(int i, int i2, View view);

    public abstract int xI(int i);

    static /* synthetic */ void a(AnimatedExpandableListView$a animatedExpandableListView$a, int i) {
        d En = animatedExpandableListView$a.En(i);
        En.mUX = true;
        En.xXF = 0;
        En.xXE = true;
    }

    static /* synthetic */ void a(AnimatedExpandableListView$a animatedExpandableListView$a, int i, int i2) {
        d En = animatedExpandableListView$a.En(i);
        En.mUX = true;
        En.xXF = i2;
        En.xXE = false;
    }

    final d En(int i) {
        d dVar = (d) this.xXt.get(i);
        if (dVar != null) {
            return dVar;
        }
        dVar = new d((byte) 0);
        this.xXt.put(i, dVar);
        return dVar;
    }

    public final int getChildType(int i, int i2) {
        if (En(i).mUX) {
            return 0;
        }
        return 1;
    }

    public final int getChildTypeCount() {
        return 2;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        d En = En(i);
        if (!En.mUX) {
            return d(i, i2, view);
        }
        View view2;
        if (view instanceof b) {
            view2 = view;
        } else {
            view2 = new b(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(-1, 0));
        }
        if (i2 < En.xXF) {
            view2.getLayoutParams().height = 0;
            return view2;
        }
        int i3;
        final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
        b bVar = (b) view2;
        bVar.xXz.clear();
        Drawable divider = expandableListView.getDivider();
        int measuredWidth = viewGroup.getMeasuredWidth();
        int dividerHeight = expandableListView.getDividerHeight();
        if (divider != null) {
            bVar.xNm = divider;
            bVar.xXA = measuredWidth;
            bVar.dividerHeight = dividerHeight;
            divider.setBounds(0, 0, measuredWidth, dividerHeight);
        }
        measuredWidth = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        dividerHeight = 0;
        int height = viewGroup.getHeight();
        int xI = xI(i);
        for (i3 = En.xXF; i3 < xI; i3++) {
            View d = d(i, i3, null);
            d.measure(measuredWidth, makeMeasureSpec);
            dividerHeight += d.getMeasuredHeight();
            if (dividerHeight >= height) {
                bVar.di(d);
                dividerHeight += ((xI - i3) - 1) * (dividerHeight / (i3 + 1));
                break;
            }
            bVar.di(d);
        }
        Object tag = bVar.getTag();
        if (tag == null) {
            i3 = 0;
        } else {
            i3 = ((Integer) tag).intValue();
        }
        Animation animatedExpandableListView$c;
        if (En.xXE && r2 != 1) {
            animatedExpandableListView$c = new AnimatedExpandableListView$c(bVar, 0, dividerHeight, En);
            AnimatedExpandableListView.coJ();
            animatedExpandableListView$c.setDuration(150);
            animatedExpandableListView$c.setAnimationListener(new 1(this, i, bVar));
            bVar.startAnimation(animatedExpandableListView$c);
            bVar.setTag(Integer.valueOf(1));
            return view2;
        } else if (En.xXE || r2 == 2) {
            return view2;
        } else {
            if (En.xXG == -1) {
                En.xXG = dividerHeight;
            }
            animatedExpandableListView$c = new AnimatedExpandableListView$c(bVar, En.xXG, 0, En);
            AnimatedExpandableListView.coJ();
            animatedExpandableListView$c.setDuration(150);
            xI = i;
            final d dVar = En;
            final b bVar2 = bVar;
            animatedExpandableListView$c.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ AnimatedExpandableListView$a xXw;

                public final void onAnimationEnd(Animation animation) {
                    this.xXw.En(xI).mUX = false;
                    expandableListView.collapseGroup(xI);
                    this.xXw.notifyDataSetChanged();
                    dVar.xXG = -1;
                    bVar2.setTag(Integer.valueOf(0));
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            bVar.startAnimation(animatedExpandableListView$c);
            bVar.setTag(Integer.valueOf(2));
            return view2;
        }
    }

    public final int getChildrenCount(int i) {
        d En = En(i);
        if (En.mUX) {
            return En.xXF + 1;
        }
        return xI(i);
    }
}
