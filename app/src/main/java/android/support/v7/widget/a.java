package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.g;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    protected final a Mm = new a(this);
    protected final Context Mn;
    protected ActionMenuView Mo;
    protected ActionMenuPresenter Mp;
    protected int Mq;
    protected ai Mr;
    private boolean Ms;
    private boolean Mt;

    protected class a implements am {
        private boolean Mu = false;
        int Mv;
        final /* synthetic */ a Mw;

        protected a(a aVar) {
            this.Mw = aVar;
        }

        public final a a(ai aiVar, int i) {
            this.Mw.Mr = aiVar;
            this.Mv = i;
            return this;
        }

        public final void p(View view) {
            super.setVisibility(0);
            this.Mu = false;
        }

        public final void q(View view) {
            if (!this.Mu) {
                this.Mw.Mr = null;
                super.setVisibility(this.Mv);
            }
        }

        public final void ar(View view) {
            this.Mu = true;
        }
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.Mn = context;
        } else {
            this.Mn = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        aF(obtainStyledAttributes.getLayoutDimension(k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.Mp != null) {
            ActionMenuPresenter actionMenuPresenter = this.Mp;
            if (!actionMenuPresenter.Nw) {
                actionMenuPresenter.Nv = actionMenuPresenter.mContext.getResources().getInteger(g.abc_max_action_buttons);
            }
            if (actionMenuPresenter.eg != null) {
                actionMenuPresenter.eg.h(true);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Ms = false;
        }
        if (!this.Ms) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.Ms = true;
            }
        }
        if (d == 1 || d == 3) {
            this.Ms = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 9) {
            this.Mt = false;
        }
        if (!this.Mt) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.Mt = true;
            }
        }
        if (d == 10 || d == 3) {
            this.Mt = false;
        }
        return true;
    }

    public void aF(int i) {
        this.Mq = i;
        requestLayout();
    }

    public ai c(int i, long j) {
        if (this.Mr != null) {
            this.Mr.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                z.d(this, 0.0f);
            }
            ai q = z.U(this).q(1.0f);
            q.d(j);
            q.a(this.Mm.a(q, i));
            return q;
        }
        q = z.U(this).q(0.0f);
        q.d(j);
        q.a(this.Mm.a(q, i));
        return q;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.Mr != null) {
                this.Mr.cancel();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        if (this.Mp != null) {
            return this.Mp.showOverflowMenu();
        }
        return false;
    }

    protected static int g(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int b(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
