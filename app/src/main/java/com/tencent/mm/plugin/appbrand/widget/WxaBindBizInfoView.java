package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ag.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView extends LinearLayout {
    private static int jVu = a.fromDPToPix(ac.getContext(), 15);
    private static int jVv = a.fromDPToPix(ac.getContext(), 30);
    private TextView jJn;
    public List<WxaEntryInfo> jVn;
    private View jVo;
    private ImageView jVp;
    private TextView jVq;
    private LinearLayout jVr;
    private ViewGroup jVs;
    private View jVt;

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.jVn = new LinkedList();
        View inflate = View.inflate(getContext(), h.ixf, this);
        this.jVo = inflate.findViewById(g.cif);
        this.jVp = (ImageView) inflate.findViewById(g.coL);
        this.jJn = (TextView) inflate.findViewById(g.cSh);
        this.jVq = (TextView) inflate.findViewById(g.bYZ);
        this.jVt = inflate.findViewById(g.cxh);
        this.jVr = (LinearLayout) inflate.findViewById(g.bYG);
        this.jVs = (ViewGroup) inflate.findViewById(g.crp);
    }

    public final void dn(boolean z) {
        if (this.jVs.getMeasuredWidth() != 0) {
            WxaEntryInfo wxaEntryInfo;
            if (this.jVn.isEmpty()) {
                setVisibility(8);
                wxaEntryInfo = null;
            } else {
                setVisibility(0);
                wxaEntryInfo = (WxaEntryInfo) this.jVn.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.jVp, this.jJn);
            }
            this.jVq.setText(getContext().getString(j.dUs, new Object[]{Integer.valueOf(this.jVn.size())}));
            List list = this.jVn;
            this.jVr.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = (this.jVs.getMeasuredWidth() - this.jVs.getPaddingLeft()) - this.jVs.getPaddingRight();
                int i = measuredWidth / (jVv + jVu);
                if (i > size) {
                    this.jVt.setVisibility(8);
                } else {
                    this.jVt.setVisibility(0);
                    i = (measuredWidth - this.jVt.getMeasuredWidth()) / (jVv + jVu);
                }
                measuredWidth = Math.min(i, size);
                if (measuredWidth > 1) {
                    for (size = 0; size < measuredWidth; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(getContext());
                        imageView.setLayoutParams(new LayoutParams(jVv + jVu, jVv));
                        imageView.setPadding(0, 0, jVu, 0);
                        this.jVr.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                x.i("MicroMsg.WxaBindBizInfoView", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.jVn.size() == 1) {
                this.jVo.setVisibility(0);
                this.jVs.setTag(((WxaEntryInfo) this.jVn.get(0)).username);
                return;
            }
            this.jVo.setVisibility(8);
            this.jVs.setTag(null);
        } else if (z) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ WxaBindBizInfoView jVw;

                {
                    this.jVw = r1;
                }

                public final boolean onPreDraw() {
                    this.jVw.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.jVw.dn(false);
                    return true;
                }
            });
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                Bitmap kg = m.kg(wxaEntryInfo.username);
                if (kg == null || kg.isRecycled()) {
                    b.Jj().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
                } else {
                    imageView.setImageBitmap(kg);
                }
            }
            if (textView != null) {
                textView.setText(bh.ou(wxaEntryInfo.title));
            }
        }
    }
}
