package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private ImageView ihQ;
    private TextView ihV;
    private TextView iny;
    private x jLe;
    private TextView pjY;
    private a pjZ;
    private boolean pka = false;

    public interface a {
        void a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.ihQ = (ImageView) view.findViewById(R.h.bXn);
        this.ihV = (TextView) view.findViewById(R.h.bYa);
        this.pjY = (TextView) view.findViewById(R.h.bXK);
        this.iny = (TextView) view.findViewById(R.h.bXx);
        this.pka = true;
        initView();
        super.onBindView(view);
    }

    public final void hk(boolean z) {
        if (this.pjZ != null) {
            if (z) {
                this.ihV.setTextColor(r.gb(this.mContext));
                this.ihV.setText(R.l.eMy);
                this.ihV.setCompoundDrawablesWithIntrinsicBounds(R.g.bGx, 0, 0, 0);
                return;
            }
            this.ihV.setTextColor(r.gc(this.mContext));
            this.ihV.setText(R.l.eMF);
            this.ihV.setCompoundDrawablesWithIntrinsicBounds(R.g.bGw, 0, 0, 0);
        }
    }

    private void initView() {
        if (!this.pka || this.jLe == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.pka + "contact = " + this.jLe);
            return;
        }
        String str = this.jLe.field_username;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = " + str);
        if (this.ihQ != null && this.jLe.field_username.equals(str)) {
            b.a(this.ihQ, str);
        }
        if (this.pjY != null) {
            this.pjY.setText(this.jLe.AP());
        }
        if (this.pjZ != null) {
            this.pjZ.a(this);
            CharSequence hint = this.pjZ.getHint();
            if (hint != null) {
                this.iny.setText(hint);
                this.iny.setVisibility(0);
                return;
            }
            this.iny.setVisibility(8);
        }
    }

    public final void a(x xVar, a aVar) {
        Assert.assertTrue(xVar != null);
        this.jLe = xVar;
        this.pjZ = aVar;
        initView();
    }
}
