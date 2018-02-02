package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference extends Preference {
    private TextView znA;
    Region zny;
    private CharSequence znz;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    public final void a(Region region) {
        if (region == null || t.ov(region.getName()) || t.ov(region.getCode())) {
            x.e("MicroMsg.ZonePreference", "setZoneItem item = null");
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.zny = region;
    }

    public final void setSummary(CharSequence charSequence) {
        this.znz = charSequence;
        cyd();
    }

    private void cyd() {
        if (this.znA != null) {
            if (this.znz == null || t.ov(this.znz.toString())) {
                this.znA.setVisibility(8);
            } else {
                this.znA.setVisibility(0);
            }
            this.znA.setText(this.znz);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnP, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.zny != null) {
            ((TextView) view.findViewById(R.h.cZV)).setText(this.zny.getName());
            this.znA = (TextView) view.findViewById(R.h.cPH);
            cyd();
        }
    }
}
