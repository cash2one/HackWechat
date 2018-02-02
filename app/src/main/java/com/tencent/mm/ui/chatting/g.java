package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.j;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.base.MMListPopupWindow;

public final class g implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private LayoutInflater DF;
    private int height;
    private Context mContext = null;
    private int mCount;
    OnItemClickListener yqY = null;
    private ViewGroup yqZ = null;
    private b yra = null;
    private MMListPopupWindow yrb;
    private int yrc = R.m.eYU;
    private int yrd;
    j yre = null;
    private boolean yrf = true;

    private class b extends BaseAdapter {
        final /* synthetic */ g yrg;

        private b(g gVar) {
            this.yrg = gVar;
        }

        public final /* synthetic */ Object getItem(int i) {
            return Fp(i);
        }

        public final int getCount() {
            return this.yrg.mCount;
        }

        private j Fp(int i) {
            return (j) this.yrg.yre.hpL.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = (TextView) this.yrg.DF.inflate(R.i.dpq, viewGroup, false);
            } else {
                view2 = (TextView) view;
            }
            j Fp = Fp(i);
            view2.setTag(Fp);
            view2.setText(i.a(this.yrg.mContext, Fp.name));
            return view2;
        }
    }

    public g(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.yqZ = viewGroup;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        cro();
        this.yra = new b();
    }

    @SuppressLint({"WrongCall"})
    public final boolean a(j jVar, int i, int i2, boolean z) {
        if (isShowing() || jVar == null || jVar.hpL == null || jVar.hpL.size() <= 0) {
            return false;
        }
        this.yrf = false;
        this.yre = jVar;
        this.mCount = jVar.hpL.size();
        this.yra.notifyDataSetChanged();
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        a a = a.a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.dpq, null)).getPaint(), jVar.hpL, i);
        this.yrd = (i2 - (this.yra.getCount() * this.mContext.getResources().getDimensionPixelSize(R.f.bvR))) - this.mContext.getResources().getDimensionPixelSize(R.f.bvc);
        new StringBuilder("showPointY=").append(i2).append("verticalOffset=").append(this.yrd);
        this.yrb = new MMListPopupWindow(this.mContext, null, 0);
        this.yrb.setOnDismissListener(this);
        this.yrb.SY = this.yqY;
        this.yrb.setAdapter(this.yra);
        this.yrb.cpn();
        this.yrb.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bGy));
        this.yrb.setAnimationStyle(this.yrc);
        this.yrb.SN = a.kbo;
        this.yrb.setVerticalOffset(this.yrd);
        this.yrb.SW = this.yqZ;
        this.yrb.setContentWidth(b(this.yra));
        this.yrb.fe();
        this.yrb.show();
        this.yrb.ybR.setOnKeyListener(this);
        this.yrb.ybR.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.e.btQ)));
        this.yrb.ybR.setSelector(this.mContext.getResources().getDrawable(R.g.bEJ));
        this.yrb.ybR.setDividerHeight(1);
        this.yrb.ybR.setVerticalScrollBarEnabled(false);
        this.yrb.ybR.setHorizontalScrollBarEnabled(false);
        return true;
    }

    public final boolean isShowing() {
        return this.yrb != null && this.yrb.inJ.isShowing();
    }

    public final boolean cro() {
        if (!isShowing()) {
            return false;
        }
        this.yrb.dismiss();
        return true;
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
            if (this.yqZ == null) {
                this.yqZ = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.yqZ);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onDismiss() {
    }
}
