package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizBindWxaInfoPreference extends Preference {
    private static DisplayMetrics jRI = ac.getContext().getResources().getDisplayMetrics();
    private static int jVu = a.fromDPToPix(ac.getContext(), 15);
    private static int jVv = ac.getResources().getDimensionPixelSize(R.f.bvH);
    d ilX;
    private TextView jJn;
    List<WxaEntryInfo> jVn;
    private View jVo;
    private ImageView jVp;
    private TextView jVq;
    private LinearLayout jVr;
    private ViewGroup jVs;
    private View jVt;
    private OnClickListener lUQ;
    private volatile boolean phf;
    volatile boolean phg;
    private OnClickListener phh;

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected final void onBindView(View view) {
        this.jVo = view.findViewById(R.h.cif);
        this.jVp = (ImageView) view.findViewById(R.h.coL);
        this.jJn = (TextView) view.findViewById(R.h.cSh);
        this.jVq = (TextView) view.findViewById(R.h.bYZ);
        this.jVt = view.findViewById(R.h.cxh);
        this.jVr = (LinearLayout) view.findViewById(R.h.bYG);
        this.jVs = (ViewGroup) view.findViewById(R.h.crp);
        this.phf = true;
        this.phg = this.jVn != null;
        acD();
        super.onBindView(view);
    }

    private void init() {
        this.lUQ = new 1(this);
        this.phh = new 2(this);
    }

    final void acD() {
        if (this.phf && this.jVn != null && this.phg) {
            WxaEntryInfo wxaEntryInfo;
            this.phg = false;
            if (this.jVn.isEmpty()) {
                wxaEntryInfo = null;
            } else {
                wxaEntryInfo = (WxaEntryInfo) this.jVn.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.jVp, this.jJn);
            }
            this.jVq.setText(this.mContext.getString(R.l.dUs, new Object[]{Integer.valueOf(this.jVn.size())}));
            List list = this.jVn;
            this.jVr.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = this.jVs.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = jRI.widthPixels;
                }
                int paddingLeft = (measuredWidth - this.jVs.getPaddingLeft()) - this.jVs.getPaddingRight();
                measuredWidth = paddingLeft / (jVv + jVu);
                if (measuredWidth > size) {
                    this.jVt.setVisibility(8);
                } else {
                    this.jVt.setVisibility(0);
                    measuredWidth = (paddingLeft - this.jVt.getMeasuredWidth()) / (jVv + jVu);
                }
                paddingLeft = Math.min(measuredWidth, size);
                if (paddingLeft > 1) {
                    for (size = 0; size < paddingLeft; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(this.mContext);
                        imageView.setLayoutParams(new LayoutParams(jVv + jVu, jVv));
                        imageView.setPadding(0, 0, jVu, 0);
                        this.jVr.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                x.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.jVn.size() == 1) {
                this.jVo.setVisibility(0);
                this.jVs.setTag(((WxaEntryInfo) this.jVn.get(0)).username);
                this.jVs.setOnClickListener(this.lUQ);
                return;
            }
            this.jVo.setVisibility(8);
            this.jVs.setTag(null);
            this.jVs.setOnClickListener(this.phh);
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                b.Jj().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
            }
            if (textView != null) {
                textView.setText(bh.ou(wxaEntryInfo.title));
            }
        }
    }
}
