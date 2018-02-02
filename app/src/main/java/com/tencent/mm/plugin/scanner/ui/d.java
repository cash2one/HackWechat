package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d extends Preference implements a {
    private f ilB;
    private TextView jJn = null;
    private ImageView lkk = null;
    private View mView = null;
    String ndc;
    String pLS;
    private TextView pUY = null;
    String pUZ;

    public d(Context context) {
        super(context);
        setLayoutResource(R.i.dpv);
        j.a(this);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lkk = (ImageView) view.findViewById(R.h.bWD);
        this.jJn = (TextView) view.findViewById(R.h.bWG);
        this.pUY = (TextView) view.findViewById(R.h.bWF);
        if (bh.ov(this.pUZ)) {
            this.lkk.setVisibility(8);
        } else {
            Bitmap a = j.a(new o(this.pUZ));
            if (a == null || a.isRecycled()) {
                try {
                    this.lkk.setImageBitmap(b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null)));
                } catch (IOException e) {
                    this.lkk.setImageBitmap(null);
                }
            } else {
                this.lkk.setImageBitmap(a);
                this.lkk.setBackgroundColor(0);
            }
        }
        if (bh.ov(this.pLS)) {
            this.jJn.setVisibility(8);
        } else {
            this.jJn.setText(i.b(this.mContext, this.pLS, this.jJn.getTextSize()));
        }
        if (bh.ov(this.ndc)) {
            this.pUY.setVisibility(8);
        } else {
            this.pUY.setText(this.ndc);
        }
        if (bh.ov(this.pLS) && bh.ov(this.pUZ)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.bWE);
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.f.bxN);
            linearLayout.setPadding(b.b(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (!bh.ov(str) && str.equals(this.pUZ) && bitmap != null && !bitmap.isRecycled()) {
            this.lkk.setImageBitmap(bitmap);
            this.lkk.setBackgroundColor(0);
            if (this.ilB != null) {
                this.ilB.notifyDataSetChanged();
            }
        }
    }
}
