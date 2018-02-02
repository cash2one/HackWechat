package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.WebView;

class a$a extends t {
    TextView inu;
    TextView khr;

    public a$a(View view, int i) {
        super(view);
        this.khr = (TextView) view.findViewById(b.kgK);
        this.inu = (TextView) view.findViewById(b.bYS);
        switch (i) {
            case 1:
                this.khr.setText("L");
                this.inu.setTextColor(-7829368);
                return;
            case 2:
                this.khr.setText("I");
                this.inu.setTextColor(WebView.NIGHT_MODE_COLOR);
                return;
            case 3:
                this.khr.setText(QLog.TAG_REPORTLEVEL_COLORUSER);
                this.inu.setTextColor(Color.rgb(0, 0, d.CTRL_INDEX));
                return;
            case 4:
                this.khr.setText(QLog.TAG_REPORTLEVEL_USER);
                this.inu.setTextColor(-65536);
                return;
            default:
                this.khr.setText("L");
                this.inu.setTextColor(-7829368);
                return;
        }
    }
}
