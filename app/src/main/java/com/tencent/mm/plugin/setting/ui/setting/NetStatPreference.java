package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean qhd;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.qhd = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.faM, i, 0);
        if (obtainStyledAttributes.getInt(R.n.faN, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.qhd = z;
        obtainStyledAttributes.recycle();
        setSummary(context.getString(R.l.eMa, new Object[]{Integer.valueOf(15)}));
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnG, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        View netStatGroup;
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.atY);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.qhd;
            Object charSequence = DateFormat.format(netStatGroup.getContext().getString(R.l.eiw, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.pBl.setText(charSequence);
            x.d("MicroMsg.NetStatGroup", "NetStat dataTime = " + charSequence);
            netStatGroup.qhc.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                View netStatUnit = new NetStatUnit(netStatGroup.getContext());
                k iz = q.Tg().iz(i2 + i3);
                if (iz != null) {
                    if (z) {
                        x.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[]{Integer.valueOf(iz.hRC), Integer.valueOf(iz.hRY), Integer.valueOf(iz.hRM), Integer.valueOf(iz.hSa), Integer.valueOf(iz.hRO)});
                        netStatUnit.dr(iz.hRY + iz.hRM, iz.hRO + iz.hSa);
                    } else {
                        x.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[]{Integer.valueOf(iz.hRC), Integer.valueOf(iz.hRX), Integer.valueOf(iz.hRL), Integer.valueOf(iz.hRZ), Integer.valueOf(iz.hRN)});
                        netStatUnit.dr(iz.hRX + iz.hRL, iz.hRN + iz.hRZ);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.qhc.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(R.h.cID);
        linearLayout.removeAllViews();
        View netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.qhd;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), R.i.doR, netStatGroup2);
        netStatGroup2.qhc = (LinearLayout) netStatGroup2.findViewById(R.h.atY);
        netStatGroup = new NetStatRuler(netStatGroup2.getContext());
        netStatGroup.setTag(z2 ? "wifi" : "mobile");
        netStatGroup.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.qhc.addView(netStatGroup);
        linearLayout.addView(netStatGroup2);
    }
}
