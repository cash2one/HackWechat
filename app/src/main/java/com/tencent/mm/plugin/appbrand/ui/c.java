package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;

public final class c extends a {
    static c bB(String str, String str2) {
        c cVar = new c();
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_title", str);
        bundle.putString("extra_tip", str2);
        cVar.setArguments(bundle);
        return cVar;
    }

    public final void onResume() {
        super.onResume();
        getActivity().setTitle(getArguments() == null ? "" : getArguments().getString("extra_title"));
    }

    public final void initView() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(i.ixX);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(lx(50), lx(50));
        layoutParams.topMargin = lx(91);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        View textView = new TextView(getContext());
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#B2B2B2"));
        textView.setGravity(17);
        textView.setText(getArguments() == null ? "" : getArguments().getString("extra_tip"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = lx(16);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        ((ViewGroup) this.Iv).addView(linearLayout, new LayoutParams(-1, -1));
        com.tencent.mm.plugin.appbrand.report.a.a(this.irz, "", "", 0, "", this.jKU);
    }
}
