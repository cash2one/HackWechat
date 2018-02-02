package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.tencent.mm.cb.a$a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.q;
import java.util.Locale;

public class AutoFillListPopupWindowBase {
    ListAdapter FP;
    int PV;
    int SM;
    int SN;
    int SO;
    boolean SQ;
    boolean SR;
    boolean SS;
    int ST;
    private View SU;
    private int SV;
    View SW;
    private Drawable SX;
    private OnItemClickListener SY;
    private OnItemSelectedListener SZ;
    private Runnable Te;
    boolean Tf;
    private Rect ey;
    q inJ;
    a kau;
    private final f kav;
    private final e kaw;
    private final d kax;
    private final b kay;
    private boolean kaz;
    private Context mContext;
    private af mHandler;
    DataSetObserver mObserver;

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a$a.listPopupWindowStyle);
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet, int i) {
        this.SM = -2;
        this.PV = -2;
        this.SR = false;
        this.SS = false;
        this.ST = Integer.MAX_VALUE;
        this.SV = 0;
        this.kav = new f(this, (byte) 0);
        this.kaw = new e(this, (byte) 0);
        this.kax = new d(this, (byte) 0);
        this.kay = new b(this, (byte) 0);
        this.mHandler = new af();
        this.ey = new Rect();
        this.kaz = false;
        this.mContext = context;
        this.inJ = new q(context);
        this.inJ.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setVerticalOffset(int i) {
        this.SO = i;
        this.SQ = true;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.kau == null) {
            Context context = this.mContext;
            this.Te = new Runnable(this) {
                final /* synthetic */ AutoFillListPopupWindowBase kaA;

                {
                    this.kaA = r1;
                }

                public final void run() {
                    View view = this.kaA.SW;
                    if (view != null && view.getWindowToken() != null) {
                        this.kaA.show();
                    }
                }
            };
            this.kau = new a(context, !this.Tf);
            if (this.SX != null) {
                this.kau.setSelector(this.SX);
            }
            this.kau.setAdapter(this.FP);
            this.kau.setOnItemClickListener(this.SY);
            this.kau.setFocusable(true);
            this.kau.setFocusableInTouchMode(true);
            this.kau.setDivider(null);
            this.kau.setDividerHeight(0);
            this.kau.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ AutoFillListPopupWindowBase kaA;

                {
                    this.kaA = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = this.kaA.kau;
                        if (a != null) {
                            a.a(a, false);
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.kau.setOnScrollListener(this.kax);
            if (this.SZ != null) {
                this.kau.setOnItemSelectedListener(this.SZ);
            }
            View view = this.kau;
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
            i5 = this.kau.P(makeMeasureSpec, i5 - i);
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
                this.inJ.update(this.SW, this.SN, this.SO, this.inJ.getWidth(), this.inJ.getHeight());
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
        this.inJ.setTouchInterceptor(this.kaw);
        if (this.kaz) {
            this.inJ.showAtLocation(this.SW, 17, 0, 0);
        } else if (VERSION.SDK_INT >= 19) {
            this.inJ.showAsDropDown(this.SW, this.SN, this.SO, 53);
        } else {
            this.inJ.showAtLocation(this.SW, 53, this.SN, this.SO);
        }
        this.kau.setSelection(-1);
        if (!this.Tf || this.kau.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Tf) {
            this.mHandler.post(this.kay);
        }
    }

    public final void dismiss() {
        this.inJ.dismiss();
        anq();
        this.inJ.setContentView(null);
        this.kau = null;
        this.mHandler.removeCallbacks(this.kav);
    }

    private void anq() {
        if (this.SU != null) {
            ViewParent parent = this.SU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.SU);
            }
        }
    }

    public final void clearListSelection() {
        a aVar = this.kau;
        if (aVar != null) {
            a.a(aVar, true);
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.inJ.getInputMethodMode() == 2;
    }
}
