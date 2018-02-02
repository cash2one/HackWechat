package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

interface s$b {
    t aP(View view);

    void aQ(View view);

    void aR(View view);

    void addView(View view, int i);

    void attachViewToParent(View view, int i, LayoutParams layoutParams);

    void detachViewFromParent(int i);

    View getChildAt(int i);

    int getChildCount();

    int indexOfChild(View view);

    void removeAllViews();

    void removeViewAt(int i);
}
