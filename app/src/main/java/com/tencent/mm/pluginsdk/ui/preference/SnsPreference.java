package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference extends Preference implements g {
    private MMActivity fmM;
    private List<aqr> list;
    private String mTitle;
    private int mkA;
    private an qQS;
    private QDisFadeImageView vuc;
    private QDisFadeImageView vud;
    private QDisFadeImageView vue;
    private ImageView vuf;
    private ImageView vug;
    private ImageView vuh;
    private a vui;

    static class a extends ColorDrawable {
        public a() {
            super(-7829368);
        }
    }

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fmM = (MMActivity) context;
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.vuc = null;
        this.vud = null;
        this.vue = null;
        this.vuf = null;
        this.vug = null;
        this.vuh = null;
        this.mkA = 255;
        this.list = new LinkedList();
        this.vui = new a();
        this.fmM = (MMActivity) context;
        this.mTitle = context.getString(R.l.dWx);
        setLayoutResource(R.i.dnt);
    }

    private void cco() {
        ImageView imageView;
        int i = 0;
        if (this.vuc != null) {
            this.vuc.setImageResource(R.e.white);
            this.vuc.setVisibility(4);
        }
        if (this.vud != null) {
            this.vud.setImageResource(R.e.white);
            this.vud.setVisibility(4);
        }
        if (this.vue != null) {
            this.vue.setImageResource(R.e.white);
            this.vue.setVisibility(4);
        }
        if (this.vuc != null && this.list.size() > 0) {
            int i2;
            ImageView imageView2;
            this.vuc.setVisibility(0);
            if (f.ze()) {
                n.qQy.b((aqr) this.list.get(0), this.vuc, this.fmM.hashCode(), this.qQS);
                imageView = this.vuf;
                if (((aqr) this.list.get(0)).ktN == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            } else {
                this.vuc.setImageResource(R.g.bEh);
                imageView2 = this.vuf;
            }
            imageView = imageView2;
            i2 = 8;
            imageView.setVisibility(i2);
        }
        if (this.vud != null && this.list.size() >= 2) {
            this.vud.setVisibility(0);
            if (f.ze()) {
                n.qQy.b((aqr) this.list.get(1), this.vud, this.fmM.hashCode(), this.qQS);
                this.vug.setVisibility(((aqr) this.list.get(1)).ktN == 6 ? 0 : 8);
            } else {
                this.vud.setImageResource(R.g.bEh);
            }
        }
        if (this.vue != null && this.list.size() >= 3) {
            this.vue.setVisibility(0);
            if (f.ze()) {
                n.qQy.b((aqr) this.list.get(2), this.vue, this.fmM.hashCode(), this.qQS);
                imageView = this.vuh;
                if (((aqr) this.list.get(2)).ktN != 6) {
                    i = 8;
                }
                imageView.setVisibility(i);
                return;
            }
            this.vue.setImageResource(R.g.bEh);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnx, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.vuc = (QDisFadeImageView) view.findViewById(R.h.cpl);
        this.vuc.setAlpha(this.mkA);
        this.vuc.setImageDrawable(this.vui);
        this.vud = (QDisFadeImageView) view.findViewById(R.h.cpm);
        this.vud.setAlpha(this.mkA);
        this.vud.setImageDrawable(this.vui);
        this.vue = (QDisFadeImageView) view.findViewById(R.h.cpn);
        this.vue.setAlpha(this.mkA);
        this.vue.setImageDrawable(this.vui);
        TextView textView = (TextView) view.findViewById(R.h.bJV);
        if (!bh.ov(this.mTitle)) {
            textView.setText(this.mTitle);
            LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.tencent.mm.bv.a.aa(this.mContext, R.f.bvb);
            textView.setLayoutParams(layoutParams);
        }
        this.vuf = (ImageView) view.findViewById(R.h.cOR);
        this.vug = (ImageView) view.findViewById(R.h.cOS);
        this.vuh = (ImageView) view.findViewById(R.h.cOT);
        this.vuf.setVisibility(8);
        this.vug.setVisibility(8);
        this.vuh.setVisibility(8);
        cco();
        if (view != null && this.list != null) {
            view.setContentDescription(this.mContext.getString(R.l.eBe, new Object[]{Integer.valueOf(this.list.size())}));
        }
    }

    public final void SG(String str) {
        if (str != null) {
            this.list.clear();
            ar.Hg();
            af WO = c.EY().WO(str);
            if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                this.qQS = an.xyU;
            } else if (str.equals(q.FS())) {
                this.qQS = an.xyU;
            } else {
                this.qQS = an.xyV;
            }
            b moVar = new mo();
            moVar.fEv.username = str;
            com.tencent.mm.sdk.b.a.xef.m(moVar);
            if (moVar.fEw.fEx != null) {
                this.list.add(moVar.fEw.fEx);
            }
            if (moVar.fEw.fEy != null) {
                this.list.add(moVar.fEw.fEy);
            }
            if (moVar.fEw.fEz != null) {
                this.list.add(moVar.fEw.fEz);
            }
            cco();
        }
    }
}
