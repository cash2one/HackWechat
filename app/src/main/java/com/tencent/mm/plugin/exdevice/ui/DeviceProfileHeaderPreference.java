package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    protected MMActivity iqt;
    private String kAv;
    private String lRA;
    private boolean lRB;
    private ImageView lRr;
    private TextView lRs;
    private TextView lRt;
    private TextView lRu;
    private View lRv;
    TextView lRw;
    private boolean[] lRx;
    private OnClickListener[] lRy;
    String lRz;
    private CharSequence vA;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lRx = new boolean[6];
        this.lRy = new OnClickListener[6];
        this.lRB = false;
        this.iqt = (MMActivity) context;
        this.lRB = false;
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lRx = new boolean[6];
        this.lRy = new OnClickListener[6];
        this.lRB = false;
        this.iqt = (MMActivity) context;
        this.lRB = false;
    }

    public final void onBindView(View view) {
        x.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.lRr = (ImageView) view.findViewById(R.h.bLD);
        this.lRs = (TextView) view.findViewById(R.h.cyA);
        this.lRt = (TextView) view.findViewById(R.h.cdd);
        this.lRu = (TextView) view.findViewById(R.h.cbu);
        this.lRv = view.findViewById(R.h.cde);
        this.lRw = (TextView) view.findViewById(R.h.cbt);
        w(this.lRr, 0);
        w(this.lRs, 2);
        w(this.lRt, 1);
        w(this.lRu, 3);
        w(this.lRv, 4);
        w(this.lRw, 5);
        this.lRB = true;
        if (this.lRB) {
            this.lRs.setText(this.vA);
            this.lRu.setText(this.kAv);
            this.lRw.setText(this.lRz);
            dJ(this.lRA);
        } else {
            x.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.lRB);
        }
        super.onBindView(view);
    }

    private void w(View view, int i) {
        view.setVisibility(this.lRx[i] ? 8 : 0);
        view.setOnClickListener(this.lRy[i]);
    }

    public final void B(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        switch (i) {
            case 0:
                view = this.lRr;
                break;
            case 1:
                view = this.lRt;
                break;
            case 2:
                view = this.lRs;
                break;
            case 3:
                view = this.lRu;
                break;
            case 4:
                view = this.lRv;
                break;
            case 5:
                view = this.lRw;
                break;
            default:
                return;
        }
        boolean[] zArr = this.lRx;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final void a(int i, OnClickListener onClickListener) {
        View view;
        switch (i) {
            case 0:
                view = this.lRr;
                break;
            case 1:
                view = this.lRt;
                break;
            case 2:
                view = this.lRs;
                break;
            case 3:
                view = this.lRu;
                break;
            case 4:
                view = this.lRv;
                break;
            case 5:
                view = this.lRw;
                break;
            default:
                return;
        }
        this.lRy[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void setName(CharSequence charSequence) {
        this.vA = charSequence;
        if (this.lRs != null) {
            this.lRs.setText(charSequence);
        }
    }

    public final void zj(String str) {
        this.kAv = str;
        if (this.lRu != null) {
            this.lRu.setText(str);
        }
    }

    public final void dJ(String str) {
        this.lRA = str;
        if (this.lRr != null) {
            c$a com_tencent_mm_aq_a_a_c_a = new c$a();
            Bitmap CZ = d.CZ(R.g.bBZ);
            if (!(CZ == null || CZ.isRecycled())) {
                CZ = d.a(CZ, true, 0.5f * ((float) CZ.getWidth()));
                if (!(CZ == null || CZ.isRecycled())) {
                    com_tencent_mm_aq_a_a_c_a.hDQ = new BitmapDrawable(CZ);
                }
            }
            if (CZ == null || CZ.isRecycled()) {
                com_tencent_mm_aq_a_a_c_a.hDP = R.g.bBZ;
            }
            com_tencent_mm_aq_a_a_c_a.hDY = true;
            o.PA().a(this.lRA, this.lRr, com_tencent_mm_aq_a_a_c_a.PK());
        }
    }
}
