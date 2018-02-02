package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView {
    private static final int[] Tw = new int[]{0};
    int TA;
    int TB;
    protected int TC;
    private Field TD;
    private a TE;
    final Rect Tx;
    int Ty;
    int Tz;

    private static class a extends android.support.v7.c.a.a {
        boolean AW = true;

        public a(Drawable drawable) {
            super(drawable);
        }

        public final boolean setState(int[] iArr) {
            if (this.AW) {
                return super.setState(iArr);
            }
            return false;
        }

        public final void draw(Canvas canvas) {
            if (this.AW) {
                super.draw(canvas);
            }
        }

        public final void setHotspot(float f, float f2) {
            if (this.AW) {
                super.setHotspot(f, f2);
            }
        }

        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.AW) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public final boolean setVisible(boolean z, boolean z2) {
            if (this.AW) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ListViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Tx = new Rect();
        this.Ty = 0;
        this.Tz = 0;
        this.TA = 0;
        this.TB = 0;
        try {
            this.TD = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.TD.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
    }

    public void setSelector(Drawable drawable) {
        this.TE = drawable != null ? new a(drawable) : null;
        super.setSelector(this.TE);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.Ty = rect.left;
        this.Tz = rect.top;
        this.TA = rect.right;
        this.TB = rect.bottom;
    }

    protected void drawableStateChanged() {
        boolean z = true;
        super.drawableStateChanged();
        P(true);
        Drawable selector = getSelector();
        if (selector != null) {
            if (!(ff() && isPressed())) {
                z = false;
            }
            if (z) {
                selector.setState(getDrawableState());
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.Tx.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.Tx);
                selector.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.TC = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected boolean ff() {
        return false;
    }

    void a(int i, View view) {
        Rect rect = this.Tx;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.Ty;
        rect.top -= this.Tz;
        rect.right += this.TA;
        rect.bottom += this.TB;
        try {
            boolean z = this.TD.getBoolean(this);
            if (view.isEnabled() != z) {
                this.TD.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
        }
    }

    public final int P(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i4);
            if (listPaddingTop != i3) {
                i3 = listPaddingTop;
                view2 = null;
            } else {
                view2 = view;
            }
            view = adapter.getView(i4, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i4 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
            if (listPaddingBottom >= i2) {
                return i2;
            }
        }
        return listPaddingBottom;
    }

    protected final void P(boolean z) {
        if (this.TE != null) {
            this.TE.AW = z;
        }
    }
}
