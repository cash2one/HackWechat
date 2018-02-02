package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.design.widget.u.2;
import android.support.v4.view.z;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class TabLayout$a extends LinearLayout {
    private int kA = -1;
    private int kB = -1;
    u kC;
    final /* synthetic */ TabLayout kv;
    int kw;
    final Paint kx;
    int ky = -1;
    float kz;

    TabLayout$a(TabLayout tabLayout, Context context) {
        this.kv = tabLayout;
        super(context);
        setWillNotDraw(false);
        this.kx = new Paint();
    }

    protected final void onMeasure(int i, int i2) {
        Object obj = null;
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) == 1073741824 && TabLayout.j(this.kv) == 1 && TabLayout.m(this.kv) == 1) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                int max;
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    max = Math.max(i4, childAt.getMeasuredWidth());
                } else {
                    max = i4;
                }
                i3++;
                i4 = max;
            }
            if (i4 > 0) {
                if (i4 * childCount <= getMeasuredWidth() - (TabLayout.a(this.kv, 16) * 2)) {
                    i3 = 0;
                    while (i3 < childCount) {
                        Object obj2;
                        LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                        if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                            obj2 = obj;
                        } else {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            obj2 = 1;
                        }
                        i3++;
                        obj = obj2;
                    }
                } else {
                    TabLayout.n(this.kv);
                    TabLayout.o(this.kv);
                    obj = 1;
                }
                if (obj != null) {
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.kC == null || !this.kC.ls.isRunning()) {
            as();
            return;
        }
        this.kC.ls.cancel();
        f(this.ky, Math.round(((float) this.kC.ls.getDuration()) * (1.0f - this.kC.ls.getAnimatedFraction())));
    }

    final void as() {
        int i;
        int i2;
        View childAt = getChildAt(this.ky);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i = childAt.getLeft();
            i2 = childAt.getRight();
            if (this.kz > 0.0f && this.ky < getChildCount() - 1) {
                View childAt2 = getChildAt(this.ky + 1);
                i = (int) ((((float) i) * (1.0f - this.kz)) + (this.kz * ((float) childAt2.getLeft())));
                i2 = (int) ((((float) i2) * (1.0f - this.kz)) + (((float) childAt2.getRight()) * this.kz));
            }
        }
        e(i, i2);
    }

    private void e(int i, int i2) {
        if (i != this.kA || i2 != this.kB) {
            this.kA = i;
            this.kB = i2;
            z.E(this);
        }
    }

    final void f(int i, int i2) {
        if (this.kC != null && this.kC.ls.isRunning()) {
            this.kC.ls.cancel();
        }
        Object obj = z.I(this) == 1 ? 1 : null;
        View childAt = getChildAt(i);
        if (childAt == null) {
            as();
            return;
        }
        int i3;
        int i4;
        int left = childAt.getLeft();
        int right = childAt.getRight();
        if (Math.abs(i - this.ky) <= 1) {
            i3 = this.kA;
            i4 = this.kB;
        } else {
            int a = TabLayout.a(this.kv, 24);
            if (i < this.ky) {
                if (obj == null) {
                    i4 = right + a;
                    i3 = i4;
                }
            } else if (obj != null) {
                i4 = right + a;
                i3 = i4;
            }
            i4 = left - a;
            i3 = i4;
        }
        if (i3 != left || i4 != right) {
            u ay = aa.ay();
            this.kC = ay;
            ay.setInterpolator(a.eB);
            ay.setDuration(i2);
            ay.e(0.0f, 1.0f);
            ay.a(new 1(this, i3, left, i4, right));
            ay.ls.a(new 2(ay, new 2(this, i)));
            ay.ls.start();
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.kA >= 0 && this.kB > this.kA) {
            canvas.drawRect((float) this.kA, (float) (getHeight() - this.kw), (float) this.kB, (float) getHeight(), this.kx);
        }
    }
}
