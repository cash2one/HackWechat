package com.tencent.mm.plugin.qqmail.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p$a;
import com.tencent.mm.plugin.qqmail.b.p$c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private String feh;
    private af handler;
    private d mfB = new d(this);
    private long ppZ;
    private MMWebView ptK;
    private View ptL;
    private p$a ptM = new p$a(this) {
        final /* synthetic */ MailWebViewUI ptN;

        {
            this.ptN = r1;
        }

        public final void onSuccess(String str, Map map) {
            this.ptN.handler.post(new 1(this, str));
        }

        public final void onError(int i, String str) {
            this.ptN.handler.post(new 2(this, str));
        }
    };

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        if (mailWebViewUI.ptK != null && str != null) {
            if (mailWebViewUI.feh == null) {
                mailWebViewUI.ptK.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
                return;
            }
            mailWebViewUI.ptK.loadDataWithBaseURL(mailWebViewUI.feh, str, "text/html", ProtocolPackage.ServerEncoding, null);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        String stringExtra = mailWebViewUI.getIntent().getStringExtra("uri");
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        Map hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.feh = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String az = bh.az(mailWebViewUI.getIntent().getStringExtra("method"), "get");
        if (az == null || az.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            x.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            return;
        }
        p$c com_tencent_mm_plugin_qqmail_b_p_c = new p$c();
        com_tencent_mm_plugin_qqmail_b_p_c.ppl = false;
        com_tencent_mm_plugin_qqmail_b_p_c.toBundle(new Bundle());
        try {
            if (az.equals("get")) {
                mailWebViewUI.ppZ = ((Long) new ReadMailProxy(mailWebViewUI.mfB, mailWebViewUI.ptM).REMOTE_CALL("get", new Object[]{stringExtra, hashMap, r5})).longValue();
                return;
            }
            mailWebViewUI.ppZ = ((Long) new ReadMailProxy(mailWebViewUI.mfB, mailWebViewUI.ptM).REMOTE_CALL("post", new Object[]{stringExtra, hashMap, r5})).longValue();
        } catch (Exception e) {
            x.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", new Object[]{az, e.getMessage()});
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            return;
        }
        String substring = str.substring(33);
        final int i = bh.getInt(substring, 480);
        x.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:" + substring);
        mailWebViewUI.ptK.post(new Runnable(mailWebViewUI) {
            final /* synthetic */ MailWebViewUI ptN;

            public final void run() {
                View view = (View) this.ptN.ptK.getParent();
                if (view != null) {
                    int width = view.getWidth();
                    if (i > width) {
                        int i = 10;
                        float f = ((float) width) / ((float) i);
                        while (f < this.ptN.ptK.getScale()) {
                            i--;
                            if (i > 0) {
                                this.ptN.ptK.zoomOut();
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    protected final int getLayoutId() {
        return R.i.dpV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new af();
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            setMMTitle(stringExtra);
        }
        this.mfB.I(new 2(this));
    }

    protected void onStop() {
        this.ptK.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        this.ptK.setVisibility(8);
        this.ptK.destroy();
        this.ptK = null;
        this.mfB.release();
        super.onDestroy();
    }

    protected final void initView() {
        this.ptL = findViewById(R.h.cYE);
        if (this.ptL != null) {
            this.ptL.setVisibility(8);
        }
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.ptK = a.cn(this.mController.xIM);
        this.ptK.setBackgroundDrawable(com.tencent.mm.bv.a.b(this, R.e.btq));
        ((FrameLayout) findViewById(R.h.bYF)).addView(this.ptK);
        this.ptK.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            MMWebView mMWebView = this.ptK;
            if (VERSION.SDK_INT >= 8) {
                mMWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            }
        }
        this.ptK.getSettings().cIs();
        this.ptK.getSettings().setSupportZoom(true);
        this.ptK.getSettings().setBuiltInZoomControls(true);
        this.ptK.setWebViewClient(new 3(this));
        this.ptK.setWebChromeClient(new 4(this));
        this.ptK.cyV();
        setBackBtn(new 5(this));
    }
}
