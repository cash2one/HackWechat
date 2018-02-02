package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.l;

public abstract class q implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private int LZ;
    private ViewTreeObserver Md;
    private ViewGroup Me;
    private int dividerHeight;
    private View hH;
    private BaseAdapter kPo;
    private boolean kaz = false;
    protected Context mContext;
    private boolean tGi = false;
    private MMListPopupWindow yrb;
    private int yrc = l.gYO;
    private OnCancelListener znc;
    private OnDismissListener znd;
    private boolean zne = true;
    private View znf;
    private int zng;
    private int znh = 0;
    private int zni = 0;
    private int znj = 0;
    private float znk = 0.0f;
    private float znl = 0.0f;

    public abstract BaseAdapter asU();

    public q(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.LZ = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        this.dividerHeight = b.b(this.mContext, 1.0f);
        this.znh = resources.getDimensionPixelSize(e.bvJ) * 2;
        this.zni = resources.getDimensionPixelSize(e.bvR);
        this.znj = b.b(this.mContext, 36.0f);
        this.kPo = asU();
    }

    public final void nv(boolean z) {
        this.kaz = z;
        if (z) {
            this.yrc = l.gYN;
        } else {
            this.yrc = l.gYO;
        }
    }

    public boolean dM() {
        int height;
        boolean z;
        Rect rect = new Rect();
        if (this.mContext instanceof ActionBarActivity) {
            height = ((ActionBarActivity) this.mContext).getSupportActionBar().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            height = displayMetrics.widthPixels > displayMetrics.heightPixels ? b.b(this.mContext, 40.0f) : b.b(this.mContext, 49.0f);
        }
        int dimensionPixelSize = height - this.mContext.getResources().getDimensionPixelSize(e.bvJ);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height2 - rect.height() < 0 || iArr[1] <= 200) {
                height = rect.top + dimensionPixelSize;
            } else {
                height = (height2 - rect.height()) + dimensionPixelSize;
            }
        } else {
            height = dimensionPixelSize;
        }
        this.tGi = aZW();
        if (this.yrb == null || true == this.zne) {
            this.yrb = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.yrb.setOnDismissListener(this);
        this.yrb.SY = this;
        this.yrb.setAdapter(this.kPo);
        this.yrb.cpn();
        this.yrb.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.gUU));
        this.yrb.setAnimationStyle(this.yrc);
        this.yrb.SN = 0;
        this.yrb.SW = this.hH;
        if (this.hH != null) {
            z = this.Md == null;
            this.Md = this.hH.getViewTreeObserver();
            x.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                this.Md.addOnGlobalLayoutListener(this);
            }
        }
        this.yrb.setVerticalOffset(height);
        this.yrb.kaz = this.kaz;
        this.yrb.setContentWidth(Math.min(b(this.kPo), this.LZ));
        this.yrb.fe();
        if (!(this.znk == 0.0f || this.znl == 0.0f)) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            z = displayMetrics2.widthPixels > displayMetrics2.heightPixels;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int height3 = height > rect2.height() ? rect2.height() : height;
            x.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[]{Float.valueOf(this.znk), Float.valueOf(this.znl), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(z ? (int) (this.znl * ((float) height3)) : (int) (this.znk * ((float) height3)))});
            height = Math.round((float) (height / this.zni));
            if (height <= 0 || this.kPo == null) {
                x.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                dimensionPixelSize = (this.zni * height) + this.znh;
                if (dimensionPixelSize == 0 || dimensionPixelSize >= this.kPo.getCount() * this.zni) {
                    x.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[]{Integer.valueOf(dimensionPixelSize), Integer.valueOf(this.kPo.getCount() * this.zni)});
                } else {
                    this.yrb.SM = (((height - 1) * this.zni) + this.znh) + this.znj;
                }
            }
        }
        if (!(this.yrb == null || this.znf == null)) {
            MMListPopupWindow mMListPopupWindow = this.yrb;
            View view = this.znf;
            boolean isShowing = mMListPopupWindow.inJ.isShowing();
            if (isShowing) {
                mMListPopupWindow.anq();
            }
            mMListPopupWindow.SU = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.yrb.SV = this.zng;
        }
        this.yrb.show();
        this.yrb.ybR.setOnKeyListener(this);
        this.yrb.ybR.setSelector(new ColorDrawable(this.mContext.getResources().getColor(d.transparent)));
        this.yrb.ybR.setDividerHeight(0);
        this.yrb.ybR.setVerticalScrollBarEnabled(true);
        this.yrb.ybR.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean aZW() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.yrb.dismiss();
        }
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.Me == null) {
                this.Me = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.Me);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onDismiss() {
        this.yrb = null;
        if (this.Md != null) {
            if (!this.Md.isAlive()) {
                this.Md = this.hH.getViewTreeObserver();
            }
            this.Md.removeGlobalOnLayoutListener(this);
            this.Md = null;
        }
        if (this.znc != null) {
            this.znc.onCancel(null);
        }
        if (this.znd != null) {
            this.znd.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.yrb != null && this.yrb.inJ.isShowing();
    }

    public void onGlobalLayout() {
        x.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[]{Boolean.valueOf(isShowing()), Boolean.valueOf(this.hH.isShown())});
        if (isShowing()) {
            View view = this.hH;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.tGi != aZW()) {
                this.yrb.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        x.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
    }
}
