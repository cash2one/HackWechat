package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.y;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class BizInfoHeaderPreference extends Preference implements a, m.a.a, b {
    private MMActivity fmM;
    x jLe;
    d kEC;
    private boolean lRB = false;
    private TextView nqD;
    private ImageView pho;
    private ImageView php;
    private View phq;
    private TextView phr;
    String phs;

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        this.lRB = false;
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmM = (MMActivity) context;
        this.lRB = false;
    }

    public final void onBindView(View view) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.nqD = (TextView) view.findViewById(R.h.bXK);
        this.phr = (TextView) view.findViewById(R.h.bYb);
        this.php = (ImageView) view.findViewById(R.h.bNQ);
        this.pho = (ImageView) view.findViewById(R.h.bXn);
        this.phq = view.findViewById(R.h.bXo);
        this.lRB = true;
        initView();
        super.onBindView(view);
    }

    private boolean bjr() {
        return this.lRB && this.jLe != null;
    }

    final void initView() {
        boolean z = true;
        if (bjr()) {
            Bitmap d;
            this.nqD.setText(i.b(this.fmM, bh.ou(this.jLe.AP()) + " ", this.nqD.getTextSize()));
            if (this.kEC == null) {
                this.kEC = f.jS(this.jLe.field_username);
            }
            if (this.kEC != null) {
                this.phs = this.kEC.field_brandIconURL;
                d = m.d(this.kEC.field_username, this.kEC.field_brandIconURL, R.g.bEk);
            } else {
                d = com.tencent.mm.ad.b.a(this.jLe.field_username, true, -1);
                if (!(d == null || d.isRecycled())) {
                    d = com.tencent.mm.sdk.platformtools.d.a(d, false, (float) (d.getWidth() / 2));
                }
                if (d == null && !TextUtils.isEmpty(this.phs)) {
                    d = m.d(this.jLe.field_username, this.phs, R.g.bEk);
                }
            }
            if (d == null) {
                d = BitmapFactory.decodeResource(this.fmM.getResources(), R.g.bzZ);
            }
            if (!(d == null || d.isRecycled())) {
                this.pho.setImageBitmap(d);
            }
            this.pho.setTag(this.jLe.field_username);
            this.phq.setOnClickListener(new 1(this));
            if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                if (this.kEC != null) {
                    z = this.kEC.Lk();
                }
                if (z) {
                    if (!bh.ov(this.jLe.vN())) {
                        this.phr.setVisibility(0);
                        this.phr.setText(this.mContext.getString(R.l.dFe) + this.jLe.vN());
                    } else if (x.WB(this.jLe.field_username) || s.gD(this.jLe.field_username)) {
                        this.phr.setVisibility(8);
                    } else {
                        this.phr.setText(this.mContext.getString(R.l.dFe) + bh.ou(this.jLe.AR()));
                        this.phr.setVisibility(0);
                    }
                    if (this.jLe.AH()) {
                        this.php.setVisibility(8);
                        return;
                    } else {
                        this.php.setVisibility(0);
                        return;
                    }
                }
            }
            this.phr.setVisibility(8);
            if (this.jLe.AH()) {
                this.php.setVisibility(8);
                return;
            } else {
                this.php.setVisibility(0);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lRB + "contact = " + this.jLe);
    }

    public final void onDetach() {
        ar.Hg();
        c.EY().b(this);
        n.Jz().e(this);
        y.Mn().b(this);
    }

    public final void jh(String str) {
        if (!bjr()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lRB + "contact = " + this.jLe);
        } else if (bh.ou(str).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = " + str);
        } else if (str.equals(this.jLe.field_username)) {
            initView();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (bjr()) {
            String str = (String) obj;
            if (bh.ou(str).length() > 0 && this.jLe != null && this.jLe.field_username.equals(str)) {
                ar.Hg();
                this.jLe = c.EY().WO(str);
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lRB + "contact = " + this.jLe);
        }
    }

    public final void ki(String str) {
        if (this.jLe != null && str != null && str.equals(this.jLe.field_username)) {
            initView();
        }
    }
}
