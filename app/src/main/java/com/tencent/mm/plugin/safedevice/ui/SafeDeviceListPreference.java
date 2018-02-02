package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;

public class SafeDeviceListPreference extends Preference implements e {
    private Context context;
    private ProgressDialog iln;
    private Button lgD;
    private int mode;
    c pRF;
    private boolean pRG;
    a pRH;
    b pRI;

    public interface a {
        void IA(String str);
    }

    public SafeDeviceListPreference(Context context) {
        this(context, null);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = -2;
        this.pRG = false;
        this.context = context;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(R.i.dnS, viewGroup2);
        }
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.pRG = true;
        this.lgD = (Button) view.findViewById(R.h.cat);
        initView();
        super.onBindView(view);
    }

    public final void vC(int i) {
        this.mode = i;
        initView();
    }

    private void UR() {
        ar.CG().b(362, this);
    }

    private void initView() {
        if (this.pRG) {
            switch (this.mode) {
                case -2:
                    setWidgetLayoutResource(R.i.dod);
                    return;
                case 1:
                    setWidgetLayoutResource(R.i.dfs);
                    if (this.lgD != null) {
                        this.lgD.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ SafeDeviceListPreference pRJ;

                            {
                                this.pRJ = r1;
                            }

                            public final void onClick(View view) {
                                h.a(this.pRJ.context, this.pRJ.context.getString(R.l.eGK, new Object[]{this.pRJ.pRF.field_name}), "", com.tencent.mm.bv.a.ac(this.pRJ.context, R.l.eGL), com.tencent.mm.bv.a.ac(this.pRJ.context, R.l.dEn), new 1(this.pRJ), new 2(this.pRJ));
                            }
                        });
                        return;
                    }
                    return;
                default:
                    setWidgetLayoutResource(R.i.dod);
                    return;
            }
        }
        x.d("MicroMsg.SafeDeviceListPreference", "has not binded");
    }

    public final void a(int i, int i2, String str, k kVar) {
        UR();
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i2 == 0 && i2 == 0) {
            f.bos().a(this.pRF, new String[0]);
            if (this.pRI != null) {
                this.pRI.Iz(this.ibD);
            }
        } else if (!com.tencent.mm.plugin.c.a.ift.a(this.context, i, i2, str)) {
            Toast.makeText(this.context, this.context.getString(R.l.eGM, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.pRH != null) {
                this.pRH.IA(this.pRF.field_uid);
            }
        }
    }
}
