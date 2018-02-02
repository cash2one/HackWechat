package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements a {
    private Context context;
    private String iconUrl;
    private TextView ihS;
    private f ilB;
    private ImageView jNs;
    private int lkw;
    private int pSo;
    private String title;

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }

    public CategoryWithTitlePreference(Context context) {
        this(context, null);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.title = "";
        this.lkw = 34;
        this.pSo = 34;
        setLayoutResource(R.i.dnu);
        this.context = context;
        j.a(this);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.ihS != null) {
                this.ihS.setVisibility(0);
                this.ihS.setText(charSequence);
                x.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.ihS.getText());
            }
        } else if (this.ihS != null) {
            this.ihS.setVisibility(8);
        }
        super.setTitle(charSequence);
    }

    public final void setTitle(int i) {
        if (this.ihS != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (bh.ov(this.title)) {
                this.ihS.setVisibility(8);
            } else {
                this.ihS.setVisibility(0);
                this.ihS.setText(this.title);
            }
        }
        super.setTitle(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ihS = (TextView) view.findViewById(16908310);
        this.jNs = (ImageView) view.findViewById(R.h.icon);
        LayoutParams layoutParams = this.jNs.getLayoutParams();
        layoutParams.width = b.b(this.context, (float) (this.lkw / 2));
        layoutParams.height = b.b(this.context, (float) (this.pSo / 2));
        this.jNs.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.ihS == null)) {
            this.ihS.setVisibility(0);
            this.ihS.setText(this.title);
            x.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.ihS.getText());
        }
        if (!bh.ov(this.iconUrl)) {
            Bitmap a = j.a(new o(this.iconUrl));
            if (a != null && !a.isRecycled()) {
                this.jNs.setImageBitmap(a);
                this.jNs.setVisibility(0);
            }
        }
    }

    public final void l(String str, Bitmap bitmap) {
        x.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!bh.ov(str) && str.equals(this.iconUrl) && bitmap != null && !bitmap.isRecycled() && this.jNs != null) {
            ag.y(new 1(this, bitmap));
        }
    }
}
