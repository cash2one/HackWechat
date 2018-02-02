package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class PluginPreference extends Preference implements a {
    private MMActivity fmM;
    private ImageView hvY;
    int mkA;
    String qhk;
    String qhl;
    private String qhm;
    private int qhn;
    private int qho;
    boolean qhp;

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhm = "";
        this.qhn = -1;
        this.qho = 8;
        this.qhp = false;
        this.hvY = null;
        this.mkA = 255;
        this.fmM = (MMActivity) context;
        setLayoutResource(R.i.dnt);
        n.Jz().a(this);
    }

    public final boolean IZ(String str) {
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO == null || ((int) WO.gJd) == 0) {
            x.e("MicroMsg.PluginPreference", "plugin do not exist");
            return false;
        }
        this.qhk = WO.field_username;
        this.qhl = WO.AP();
        setKey("settings_plugins_list_#" + this.qhk);
        return true;
    }

    private void bnP() {
        if (this.hvY != null) {
            b.a(this.hvY, this.qhk);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnI, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hvY = (ImageView) view.findViewById(R.h.cpk);
        this.hvY.setAlpha(this.mkA);
        TextView textView = (TextView) view.findViewById(R.h.cQE);
        if (textView != null) {
            textView.setVisibility(this.qho);
            textView.setText(this.qhm);
            if (this.qhn != -1) {
                textView.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.fmM, this.qhn));
            }
        }
        textView = (TextView) view.findViewById(R.h.czm);
        if (textView != null) {
            textView.setVisibility(this.qhp ? 0 : 8);
        }
        bnP();
    }

    public final void jh(String str) {
        if (this.qhk != null && this.qhk.equals(str)) {
            new com.tencent.mm.sdk.platformtools.af(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ PluginPreference qhq;

                {
                    this.qhq = r1;
                }

                public final void run() {
                    this.qhq.bnP();
                }
            });
        }
    }
}
