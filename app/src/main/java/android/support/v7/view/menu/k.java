package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.a.d;
import android.support.v7.a.a.h;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import java.util.ArrayList;

public class k implements l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int LW = h.abc_popup_menu_item_layout;
    private final LayoutInflater DF;
    public boolean KX;
    public android.support.v7.view.menu.l.a LC;
    private final a LX;
    private final boolean LY;
    private final int LZ;
    private final int Ma;
    private final int Mb;
    public ListPopupWindow Mc;
    private ViewTreeObserver Md;
    private ViewGroup Me;
    private boolean Mf;
    private int Mg;
    public int Mh = 8388613;
    private final f eg;
    public View hH;
    private final Context mContext;

    private class a extends BaseAdapter {
        private int Lc = -1;
        private f Mi;
        final /* synthetic */ k Mj;

        public final /* synthetic */ Object getItem(int i) {
            return aE(i);
        }

        public a(k kVar, f fVar) {
            this.Mj = kVar;
            this.Mi = fVar;
            ds();
        }

        public final int getCount() {
            ArrayList dC = this.Mj.LY ? this.Mi.dC() : this.Mi.dA();
            if (this.Lc < 0) {
                return dC.size();
            }
            return dC.size() - 1;
        }

        public final h aE(int i) {
            ArrayList dC = this.Mj.LY ? this.Mi.dC() : this.Mi.dA();
            if (this.Lc >= 0 && i >= this.Lc) {
                i++;
            }
            return (h) dC.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.Mj.DF.inflate(k.LW, viewGroup, false);
            } else {
                inflate = view;
            }
            android.support.v7.view.menu.m.a aVar = (android.support.v7.view.menu.m.a) inflate;
            if (this.Mj.KX) {
                ListMenuItemView listMenuItemView = (ListMenuItemView) inflate;
                listMenuItemView.KX = true;
                listMenuItemView.KV = true;
            }
            aVar.a(aE(i));
            return inflate;
        }

        private void ds() {
            h hVar = this.Mj.eg.Ly;
            if (hVar != null) {
                ArrayList dC = this.Mj.eg.dC();
                int size = dC.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dC.get(i)) == hVar) {
                        this.Lc = i;
                        return;
                    }
                }
            }
            this.Lc = -1;
        }

        public final void notifyDataSetChanged() {
            ds();
            super.notifyDataSetChanged();
        }
    }

    private k(Context context, f fVar, View view) {
        this(context, fVar, view, false, android.support.v7.a.a.a.popupMenuStyle);
    }

    public k(Context context, f fVar, View view, boolean z, int i) {
        this(context, fVar, view, z, i, (byte) 0);
    }

    private k(Context context, f fVar, View view, boolean z, int i, byte b) {
        this.Mh = 0;
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
        this.eg = fVar;
        this.LX = new a(this, this.eg);
        this.LY = z;
        this.Ma = i;
        this.Mb = 0;
        Resources resources = context.getResources();
        this.LZ = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.hH = view;
        fVar.a((l) this, context);
    }

    public final boolean dM() {
        int i = 0;
        this.Mc = new ListPopupWindow(this.mContext, null, this.Ma, this.Mb);
        this.Mc.setOnDismissListener(this);
        this.Mc.SY = this;
        this.Mc.setAdapter(this.LX);
        this.Mc.setModal(true);
        View view = this.hH;
        if (view == null) {
            return false;
        }
        boolean z = this.Md == null;
        this.Md = view.getViewTreeObserver();
        if (z) {
            this.Md.addOnGlobalLayoutListener(this);
        }
        this.Mc.SW = view;
        this.Mc.Mh = this.Mh;
        if (!this.Mf) {
            ListAdapter listAdapter = this.LX;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            int i2 = 0;
            int i3 = 0;
            View view2 = null;
            while (i2 < count) {
                View view3;
                int itemViewType = listAdapter.getItemViewType(i2);
                if (itemViewType != i3) {
                    i3 = itemViewType;
                    view3 = null;
                } else {
                    view3 = view2;
                }
                if (this.Me == null) {
                    this.Me = new FrameLayout(this.mContext);
                }
                view2 = listAdapter.getView(i2, view3, this.Me);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                itemViewType = view2.getMeasuredWidth();
                if (itemViewType >= this.LZ) {
                    i = this.LZ;
                    break;
                }
                if (itemViewType <= i) {
                    itemViewType = i;
                }
                i2++;
                i = itemViewType;
            }
            this.Mg = i;
            this.Mf = true;
        }
        this.Mc.setContentWidth(this.Mg);
        this.Mc.fe();
        this.Mc.show();
        this.Mc.SL.setOnKeyListener(this);
        return true;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.Mc.dismiss();
        }
    }

    public void onDismiss() {
        this.Mc = null;
        this.eg.close();
        if (this.Md != null) {
            if (!this.Md.isAlive()) {
                this.Md = this.hH.getViewTreeObserver();
            }
            this.Md.removeGlobalOnLayoutListener(this);
            this.Md = null;
        }
    }

    public final boolean isShowing() {
        return this.Mc != null && this.Mc.SK.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = this.LX;
        aVar.Mi.a(aVar.aE(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hH;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.Mc.show();
            }
        }
    }

    public final void a(Context context, f fVar) {
    }

    public final void f(boolean z) {
        this.Mf = false;
        if (this.LX != null) {
            this.LX.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (pVar.hasVisibleItems()) {
            boolean z;
            k kVar = new k(this.mContext, pVar, this.hH);
            kVar.LC = this.LC;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            kVar.KX = z;
            if (kVar.dM()) {
                if (this.LC == null) {
                    return true;
                }
                this.LC.d(pVar);
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, boolean z) {
        if (fVar == this.eg) {
            dismiss();
            if (this.LC != null) {
                this.LC.a(fVar, z);
            }
        }
    }

    public final boolean D() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return 0;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
