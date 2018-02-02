package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s {
    final b QB;
    final a QC = new a();
    final List<View> QD = new ArrayList();

    s(b bVar) {
        this.QB = bVar;
    }

    final void aM(View view) {
        this.QD.add(view);
        this.QB.aQ(view);
    }

    final boolean aN(View view) {
        if (!this.QD.remove(view)) {
            return false;
        }
        this.QB.aR(view);
        return true;
    }

    final void a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.QB.getChildCount();
        } else {
            childCount = aT(i);
        }
        this.QC.g(childCount, z);
        if (z) {
            aM(view);
        }
        this.QB.addView(view, childCount);
    }

    final int aT(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.QB.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int aW = i - (i2 - this.QC.aW(i2));
            if (aW == 0) {
                while (this.QC.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += aW;
        }
        return -1;
    }

    final View getChildAt(int i) {
        return this.QB.getChildAt(aT(i));
    }

    final void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.QB.getChildCount();
        } else {
            childCount = aT(i);
        }
        this.QC.g(childCount, z);
        if (z) {
            aM(view);
        }
        this.QB.attachViewToParent(view, childCount, layoutParams);
    }

    final int getChildCount() {
        return this.QB.getChildCount() - this.QD.size();
    }

    final int eF() {
        return this.QB.getChildCount();
    }

    final View aU(int i) {
        return this.QB.getChildAt(i);
    }

    final void detachViewFromParent(int i) {
        int aT = aT(i);
        this.QC.aV(aT);
        this.QB.detachViewFromParent(aT);
    }

    final int indexOfChild(View view) {
        int indexOfChild = this.QB.indexOfChild(view);
        if (indexOfChild == -1 || this.QC.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.QC.aW(indexOfChild);
    }

    final boolean aO(View view) {
        return this.QD.contains(view);
    }

    public final String toString() {
        return this.QC.toString() + ", hidden list:" + this.QD.size();
    }
}
