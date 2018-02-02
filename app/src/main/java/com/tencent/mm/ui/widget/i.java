package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.cb.a$c;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.cb.a.d;
import com.tencent.mm.cb.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.q;

public class i implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private static int kGp;
    private static int kGq;
    private static boolean zun = false;
    private LayoutInflater DF;
    private DisplayMetrics bpg;
    private Context mContext = null;
    private View oaW;
    public p$d rKD;
    private n rKE;
    private View yIE = null;
    private MMListPopupWindow yrb;
    public OnDismissListener znd;
    private a zuh = null;
    private q zui;
    private int zuj;
    private boolean zuk = false;
    public View zul;
    public OnCreateContextMenuListener zum;
    public boolean zuo = false;

    public i(Context context, View view) {
        this.mContext = context;
        this.yIE = view;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        cyP();
    }

    public i(Context context) {
        this.mContext = context;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
    }

    public final void c(View view, OnCreateContextMenuListener onCreateContextMenuListener, p$d com_tencent_mm_ui_base_p_d) {
        this.yIE = view;
        cyP();
        this.rKD = com_tencent_mm_ui_base_p_d;
        if (view instanceof AbsListView) {
            x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new 1(this, onCreateContextMenuListener));
            return;
        }
        x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view");
        view.setOnLongClickListener(new 2(this, onCreateContextMenuListener));
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, p$d com_tencent_mm_ui_base_p_d, int i2, int i3) {
        this.rKD = com_tencent_mm_ui_base_p_d;
        this.yIE = view;
        cyP();
        this.rKE.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rKE, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rKE.ycc) {
            ((o) menuItem).ycf = adapterContextMenuInfo;
        }
        if (i2 == 0 && i3 == 0) {
            bQ(0, 0);
        } else {
            bQ(i2, i3);
        }
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, p$d com_tencent_mm_ui_base_p_d, int i, int i2) {
        this.rKD = com_tencent_mm_ui_base_p_d;
        this.yIE = view;
        if (!(view instanceof TextView) && (i == 0 || i2 == 0)) {
            cyP();
        }
        this.rKE.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rKE, view, null);
        if (i == 0 && i2 == 0) {
            bQ(0, 0);
        } else {
            bQ(i, i2);
        }
    }

    private boolean fm(int i, int i2) {
        if (isShowing() || cyO()) {
            return false;
        }
        if (this.zum != null) {
            this.zum.onCreateContextMenu(this.rKE, this.yIE, null);
        }
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(f.dpq, null);
        int count = this.zuh.getCount() * this.mContext.getResources().getDimensionPixelSize(a$c.bvR);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a$c.zza);
        ListAdapter listAdapter = this.zuh;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count2 = listAdapter.getCount();
        int i5 = 0;
        while (i5 < count2) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view2 = null;
            } else {
                itemViewType = i4;
                view2 = view;
            }
            view = listAdapter.getView(i5, view2, new FrameLayout(this.mContext));
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i5++;
            i4 = itemViewType;
        }
        i4 = a.ab(this.mContext, a$c.zzb);
        if (i3 >= i4) {
            i4 = i3;
        }
        boolean z = true;
        if (this.rKE.size() >= 3) {
            z = false;
        }
        if (!this.zuk) {
            if (this.zul != null) {
                this.zul.setSelected(true);
            } else {
                this.yIE.setSelected(true);
            }
        }
        if (this.zuo) {
            fn(i, i2);
        } else {
            aa.a a = aa.a(this.mContext, i4, i, i2, count, dimensionPixelSize, z);
            this.zuj = i2 - this.mContext.getResources().getDimensionPixelSize(a$c.zza);
            x.d("MicroMsg.MMPopupMenu", "showPointY=" + i2 + "verticalOffset=" + this.zuj);
            this.yrb = new MMListPopupWindow(this.mContext, null, 0);
            this.yrb.setOnDismissListener(this);
            this.yrb.SY = new OnItemClickListener(this) {
                final /* synthetic */ i zuq;

                {
                    this.zuq = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.zuq.rKD != null) {
                        this.zuq.rKD.onMMMenuItemSelected(this.zuq.rKE.getItem(i), i);
                    }
                    if (this.zuq.yrb != null && this.zuq.yrb.inJ.isShowing()) {
                        this.zuq.yrb.dismiss();
                    }
                }
            };
            this.yrb.setAdapter(this.zuh);
            this.yrb.cpn();
            this.yrb.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.bGy));
            this.yrb.setAnimationStyle(a.yhp);
            this.yrb.SN = a.kbo;
            this.yrb.setVerticalOffset(a.rMP);
            this.yrb.SW = this.yIE;
            this.yrb.setContentWidth(i4);
            this.yrb.fe();
            this.yrb.show();
            this.yrb.ybR.setOnKeyListener(this);
            this.yrb.ybR.setDivider(new ColorDrawable(this.mContext.getResources().getColor(b.btQ)));
            this.yrb.ybR.setSelector(this.mContext.getResources().getDrawable(d.bEJ));
            this.yrb.ybR.setDividerHeight(0);
            this.yrb.ybR.setVerticalScrollBarEnabled(false);
            this.yrb.ybR.setHorizontalScrollBarEnabled(false);
        }
        return true;
    }

    private void fn(int i, int i2) {
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a$c.bvJ);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(a$c.bvv);
        this.zui = new q(this.mContext);
        this.zui.setWidth(-2);
        this.zui.setHeight(-2);
        this.zui.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.bGy));
        View linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(b.white));
        for (int i3 = 0; i3 < this.rKE.size(); i3++) {
            TextView textView = (TextView) this.DF.inflate(f.zzr, null, false);
            textView.setBackground(this.mContext.getResources().getDrawable(d.bEJ));
            if (i3 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i3 == this.rKE.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(((MenuItem) this.rKE.ycc.get(i3)).getTitle());
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ i zuq;

                public final void onClick(View view) {
                    if (this.zuq.rKD != null) {
                        this.zuq.rKD.onMMMenuItemSelected(this.zuq.rKE.getItem(i3), i3);
                    }
                    this.zuq.zui.dismiss();
                }
            });
            linearLayout.addView(textView);
        }
        linearLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.zui.setContentView(linearLayout);
        this.zui.showAtLocation(this.yIE, 0, i, i2 - measuredHeight);
    }

    private boolean isShowing() {
        return this.yrb != null && this.yrb.inJ.isShowing();
    }

    private boolean cyO() {
        return this.zui != null && this.zui.isShowing();
    }

    public final boolean cro() {
        if (isShowing()) {
            if (this.yrb == null) {
                return true;
            }
            this.yrb.dismiss();
            return true;
        } else if (!cyO()) {
            return false;
        } else {
            if (this.zui == null) {
                return true;
            }
            this.zui.dismiss();
            return true;
        }
    }

    public boolean bQ(int i, int i2) {
        int i3;
        if (!((this.yIE.equals(this.oaW) && zun) || (i == 0 && i2 == 0))) {
            kGp = i;
            kGq = i2;
        }
        this.oaW = null;
        int i4 = kGp;
        int i5 = kGq;
        zun = false;
        if (this.bpg == null) {
            this.bpg = this.mContext.getResources().getDisplayMetrics();
        }
        if (this.yIE != null) {
            int[] iArr = new int[2];
            this.yIE.getLocationOnScreen(iArr);
            if (i4 == 0) {
                i4 = iArr[0] + (this.yIE.getWidth() / 2);
            }
            i3 = iArr[1];
            int height = iArr[1] + this.yIE.getHeight();
            if (i3 < 0) {
                i3 = 0;
            }
            if (height > this.bpg.heightPixels) {
                height = this.bpg.heightPixels;
            }
            if (i5 == 0) {
                int i6 = (i3 + height) / 2;
                i3 = i4;
                i4 = i6;
                x.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                if (isShowing() || !cyO()) {
                    return fm(i3, i4);
                }
                return fm(i3, i4) & cro();
            }
        }
        i3 = i4;
        i4 = i5;
        x.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (isShowing()) {
        }
        return fm(i3, i4);
    }

    private void initView() {
        cro();
        this.rKE = new n();
        this.zuh = new a(this, (byte) 0);
        this.bpg = this.mContext.getResources().getDisplayMetrics();
    }

    private void cyP() {
        this.yIE.setOnTouchListener(new 5(this));
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDismiss() {
        if (!this.zuk) {
            if (this.zul != null) {
                this.zul.setSelected(false);
            } else {
                this.yIE.setSelected(false);
            }
        }
        if (this.znd != null) {
            this.znd.onDismiss();
        }
    }
}
