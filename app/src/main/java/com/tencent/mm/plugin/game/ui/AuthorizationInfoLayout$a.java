package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

class AuthorizationInfoLayout$a extends LinearLayout {
    private String jcZ;
    private Context mContext;

    public AuthorizationInfoLayout$a(Context context, String str) {
        super(context);
        this.mContext = context;
        this.jcZ = str;
        setGravity(16);
        setOrientation(0);
        setLayoutParams(new LayoutParams(-1, -2));
        View textView = new TextView(this.mContext);
        textView.setText(this.jcZ);
        textView.setTextSize(1, 16.0f * a.eu(this.mContext));
        textView.setTextColor(Color.parseColor("#737373"));
        textView.setGravity(16);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.g.bEx, 0, 0, 0);
        textView.setCompoundDrawablePadding(20);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.leftMargin = 10;
        textView.setLayoutParams(layoutParams);
        addView(textView);
    }
}
