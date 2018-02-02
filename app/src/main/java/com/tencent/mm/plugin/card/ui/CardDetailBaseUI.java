package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.v;

public abstract class CardDetailBaseUI extends DrawStatusBarActivity {
    private TextView jJn;
    private View jNv;
    private ImageView kQn;
    private TextView kQo;
    ImageView kQp;
    private View kQq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jNv = v.fv(this.mController.xIM).inflate(R.i.dbU, null);
        this.jNv.setBackgroundColor(getResources().getColor(R.e.bre));
        this.jJn = (TextView) this.jNv.findViewById(R.h.cSi);
        this.kQo = (TextView) this.jNv.findViewById(R.h.cPB);
        this.kQn = (ImageView) this.jNv.findViewById(R.h.bLi);
        this.kQp = (ImageView) this.jNv.findViewById(R.h.cvO);
        this.kQq = this.jNv.findViewById(R.h.divider);
        if (this.mController.contentView != null && ((ViewGroup) this.mController.contentView).getChildCount() > 0) {
            View childAt = ((ViewGroup) this.mController.contentView).getChildAt(0);
            ((ViewGroup) this.mController.contentView).removeView(childAt);
            View linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            linearLayout.addView(this.jNv, new LinearLayout.LayoutParams(-1, displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(R.f.buF) : getResources().getDimensionPixelSize(R.f.buG)));
            linearLayout.addView(childAt);
            ((ViewGroup) this.mController.contentView).addView(linearLayout);
        }
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.kQn.setOnClickListener(new 1(this, onMenuItemClickListener));
    }

    public final void setMMTitle(String str) {
        this.jJn.setText(str);
    }

    public final void nR(int i) {
        this.jJn.setTextColor(i);
    }

    public final void setMMSubTitle(String str) {
        this.kQo.setText(str);
    }

    public final void A(int i, boolean z) {
        this.jNv.setBackgroundColor(i);
        if (z) {
            this.jJn.setTextColor(getResources().getColor(R.e.black));
            this.kQo.setTextColor(getResources().getColor(R.e.black));
            this.kQn.setImageResource(R.g.bAk);
            this.kQp.setImageResource(R.g.bAr);
            this.kQq.setBackgroundColor(getResources().getColor(R.e.brh));
            return;
        }
        this.jJn.setTextColor(getResources().getColor(R.e.white));
        this.kQo.setTextColor(getResources().getColor(R.e.white));
        this.kQn.setImageResource(R.g.byy);
        this.kQp.setImageResource(R.g.bDI);
        this.kQq.setBackgroundColor(getResources().getColor(R.e.bsL));
    }

    public final void ea(boolean z) {
        this.kQp.setVisibility(z ? 0 : 8);
    }

    public final boolean noActionBar() {
        return false;
    }
}
