package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.dynamic.widget.c;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.wxawidget.b$c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int fvM;
    int iGL;
    MMSwitchBtn iVa;
    l iVb;
    String id;

    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        int i = e.khk;
        Object[] objArr = new Object[1];
        if (((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).IX().Ja()) {
            format = String.format("(%s)", new Object[]{c.adn()});
        } else {
            format = "";
        }
        objArr[0] = format;
        setMMTitle(getString(i, objArr));
        Intent intent = getIntent();
        this.id = intent.getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.appId = intent.getStringExtra("app_id");
        this.fvM = intent.getIntExtra("pkg_type", 0);
        this.iGL = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{this.id}));
        this.iVa = (MMSwitchBtn) findViewById(b.kgU);
        this.iVb = ((a) g.h(a.class)).Zk().uS(this.appId);
        if (this.iVb == null) {
            this.iVb = new l();
            this.iVb.field_appId = this.appId;
        }
        this.iVa.nB(this.iVb.field_openDebug);
        this.iVa.zvp = new 2(this);
        TextView textView = (TextView) findViewById(b.kgH);
        CharSequence fromHtml = Html.fromHtml(getString(e.khl), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new com.tencent.mm.plugin.appbrand.dynamic.html.b());
        if (fromHtml instanceof Spannable) {
            Spannable spannable = (Spannable) fromHtml;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, fromHtml.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new CustomURLSpan(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            fromHtml = spannableStringBuilder;
        }
        textView.setText(fromHtml);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(b.kgY).setOnClickListener(new 3(this));
        View findViewById = findViewById(b.khc);
        if (((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).IX().Ja()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WxaWidgetDebugUI iVc;

                {
                    this.iVc = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.iVc.mController.xIM, WxaWidgetSettingsUI.class);
                    intent.putExtra("app_id", this.iVc.appId);
                    intent.putExtra("pkg_type", this.iVc.fvM);
                    intent.putExtra("pkg_version", this.iVc.iGL);
                    this.iVc.startActivity(intent);
                }
            });
            return;
        }
        findViewById.setVisibility(8);
    }

    protected final int getLayoutId() {
        return b$c.khg;
    }
}
