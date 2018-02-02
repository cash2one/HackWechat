package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.cb.a.a;
import com.tencent.mm.sdk.platformtools.af;
import java.util.Locale;

public class MMListPopupWindow {
    private ListAdapter FP;
    private int PV;
    public int SM;
    public int SN;
    private int SO;
    private boolean SQ;
    private boolean SR;
    private boolean SS;
    int ST;
    public View SU;
    public int SV;
    public View SW;
    private Drawable SX;
    public OnItemClickListener SY;
    private OnItemSelectedListener SZ;
    private Runnable Te;
    private boolean Tf;
    private Rect ey;
    public q inJ;
    public boolean kaz;
    private Context mContext;
    private af mHandler;
    private DataSetObserver mObserver;
    public a ybR;
    private final f ybS;
    private final e ybT;
    private final d ybU;
    private final b ybV;

    private class b implements Runnable {
        final /* synthetic */ MMListPopupWindow ybW;

        private b(MMListPopupWindow mMListPopupWindow) {
            this.ybW = mMListPopupWindow;
        }

        public final void run() {
            this.ybW.clearListSelection();
        }
    }

    private class d implements OnScrollListener {
        final /* synthetic */ MMListPopupWindow ybW;

        private d(MMListPopupWindow mMListPopupWindow) {
            this.ybW = mMListPopupWindow;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.ybW.ybR != null && this.ybW.SU != null && this.ybW.FP != null && this.ybW.ybR != null) {
                if (this.ybW.ybR.getLastVisiblePosition() != this.ybW.FP.getCount() - 1 || this.ybW.ybR.getChildAt(this.ybW.ybR.getChildCount() - 1) == null || this.ybW.ybR.getChildAt(this.ybW.ybR.getChildCount() - 1).getBottom() > this.ybW.ybR.getHeight()) {
                    this.ybW.SU.setVisibility(0);
                } else {
                    this.ybW.SU.setVisibility(8);
                }
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.ybW.isInputMethodNotNeeded() && this.ybW.inJ.getContentView() != null) {
                this.ybW.mHandler.removeCallbacks(this.ybW.ybS);
                this.ybW.ybS.run();
            }
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listPopupWindowStyle);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.SM = -2;
        this.PV = -2;
        this.SR = false;
        this.SS = false;
        this.ST = Integer.MAX_VALUE;
        this.SV = 0;
        this.ybS = new f(this, (byte) 0);
        this.ybT = new e(this, (byte) 0);
        this.ybU = new d();
        this.ybV = new b();
        this.mHandler = new af();
        this.ey = new Rect();
        this.kaz = false;
        this.mContext = context;
        this.inJ = new q(context);
        this.inJ.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new c(this, (byte) 0);
        } else if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.mObserver);
        }
        this.FP = listAdapter;
        if (this.FP != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.ybR != null) {
            this.ybR.setAdapter(this.FP);
        }
    }

    public final void cpn() {
        this.Tf = true;
        this.inJ.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.inJ.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.inJ.setAnimationStyle(i);
    }

    public final void setVerticalOffset(int i) {
        this.SO = i;
        this.SQ = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.inJ.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            this.PV = (this.ey.left + this.ey.right) + i;
            return;
        }
        this.PV = i;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.ybR == null) {
            Context context = this.mContext;
            this.Te = new 1(this);
            this.ybR = new a(context, !this.Tf);
            if (this.SX != null) {
                this.ybR.setSelector(this.SX);
            }
            this.ybR.setAdapter(this.FP);
            this.ybR.setOnItemClickListener(this.SY);
            this.ybR.setFocusable(true);
            this.ybR.setFocusableInTouchMode(true);
            this.ybR.setDivider(null);
            this.ybR.setDividerHeight(0);
            this.ybR.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ MMListPopupWindow ybW;

                {
                    this.ybW = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = this.ybW.ybR;
                        if (a != null) {
                            a.a(a, false);
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.ybR.setOnScrollListener(this.ybU);
            if (this.SZ != null) {
                this.ybR.setOnItemSelectedListener(this.SZ);
            }
            View view = this.ybR;
            View view2 = this.SU;
            if (view2 != null) {
                anq();
                frameLayout = new FrameLayout(context);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                switch (this.SV) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.SV);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.PV, Integer.MIN_VALUE), 0);
            } else {
                frameLayout = view;
            }
            this.inJ.setContentView(frameLayout);
            i = 0;
        } else {
            this.inJ.getContentView();
            frameLayout = this.SU;
            i = frameLayout != null ? frameLayout.getMeasuredHeight() : 0;
        }
        Drawable background = this.inJ.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            i2 = this.ey.top + this.ey.bottom;
            if (!this.SQ) {
                this.SO = -this.ey.top;
            }
        } else {
            this.ey.setEmpty();
            i2 = 0;
        }
        if (this.inJ.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view3 = this.SW;
        int i4 = this.SO;
        Rect rect = new Rect();
        view3.getWindowVisibleDisplayFrame(rect);
        view3.getLocationOnScreen(new int[2]);
        int i5 = (z ? view3.getContext().getResources().getDisplayMetrics().heightPixels : rect.bottom) - i4;
        if (this.inJ.getBackground() != null) {
            this.inJ.getBackground().getPadding(this.ey);
            i5 -= this.ey.top + this.ey.bottom;
        }
        if (this.SR || this.SM == -1) {
            i = i5 + i2;
        } else {
            int makeMeasureSpec;
            switch (this.PV) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ey.left + this.ey.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ey.left + this.ey.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.PV, 1073741824);
                    break;
            }
            i5 = this.ybR.P(makeMeasureSpec, i5 - i);
            if (i5 > 0) {
                i += i2;
            }
            i += i5;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        q qVar;
        if (this.inJ.isShowing()) {
            if (this.PV == -1) {
                i2 = -1;
            } else if (this.PV == -2) {
                i2 = this.SW.getWidth();
            } else {
                i2 = this.PV;
            }
            if (this.SM == -1) {
                if (isInputMethodNotNeeded) {
                    i5 = i;
                } else {
                    i5 = -1;
                }
                if (isInputMethodNotNeeded) {
                    qVar = this.inJ;
                    if (this.PV != -1) {
                        i3 = 0;
                    }
                    qVar.setWindowLayoutMode(i3, 0);
                    i = i5;
                } else {
                    this.inJ.setWindowLayoutMode(this.PV == -1 ? -1 : 0, -1);
                    i = i5;
                }
            } else if (this.SM != -2) {
                i = this.SM;
            }
            this.inJ.update(i2, i);
            qVar = this.inJ;
            if (this.SS || this.SR) {
                z2 = false;
            }
            qVar.setOutsideTouchable(z2);
            if (this.kaz) {
                this.inJ.showAtLocation(this.SW, 17, 0, 0);
                return;
            } else {
                this.inJ.showAtLocation(this.SW, 53, this.SN, this.SO);
                return;
            }
        }
        if (this.PV == -1) {
            i2 = -1;
        } else if (this.PV == -2) {
            this.inJ.setWidth(this.SW.getWidth());
            i2 = 0;
        } else {
            this.inJ.setWidth(this.PV);
            i2 = 0;
        }
        if (this.SM == -1) {
            i = -1;
        } else if (this.SM == -2) {
            this.inJ.setHeight(i);
            i = 0;
        } else {
            this.inJ.setHeight(this.SM);
            i = 0;
        }
        this.inJ.setWindowLayoutMode(i2, i);
        qVar = this.inJ;
        if (this.SS || this.SR) {
            z2 = false;
        }
        qVar.setOutsideTouchable(z2);
        this.inJ.setTouchInterceptor(this.ybT);
        if (this.kaz) {
            this.inJ.showAtLocation(this.SW, 17, 0, 0);
        } else {
            this.inJ.showAtLocation(this.SW, 53, this.SN, this.SO);
        }
        this.ybR.setSelection(-1);
        if (!this.Tf || this.ybR.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Tf) {
            this.mHandler.post(this.ybV);
        }
    }

    public final void dismiss() {
        this.inJ.dismiss();
        anq();
        this.inJ.setContentView(null);
        this.ybR = null;
        this.mHandler.removeCallbacks(this.ybS);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.inJ.setOnDismissListener(onDismissListener);
    }

    public final void anq() {
        if (this.SU != null) {
            ViewParent parent = this.SU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.SU);
            }
        }
    }

    public final void fe() {
        this.inJ.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.ybR;
        if (aVar != null) {
            a.a(aVar, true);
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.inJ.getInputMethodMode() == 2;
    }
}
