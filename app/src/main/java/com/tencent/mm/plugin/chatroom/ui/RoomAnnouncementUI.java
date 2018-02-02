package com.tencent.mm.plugin.chatroom.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public class RoomAnnouncementUI extends MMActivity {
    private String iQs;
    private WebView lbq;
    private boolean lbr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lbr = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.iQs = getIntent().getStringExtra("RoomInfo_Id");
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.lbq != null) {
            this.lbq.setVisibility(8);
            ((ViewGroup) this.lbq.getParent()).removeView(this.lbq);
            this.lbq.removeAllViews();
            this.lbq.destroy();
            this.lbq = null;
            System.gc();
        }
        super.onDestroy();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected final void initView() {
        setMMTitle(R.l.eGv);
        this.lbq = a.l(this, R.h.cYG);
        this.lbq.getSettings().setJavaScriptEnabled(true);
        this.lbq.getSettings().cIw();
        this.lbq.getSettings().setBuiltInZoomControls(true);
        this.lbq.getSettings().setUseWideViewPort(true);
        this.lbq.getSettings().setLoadWithOverviewMode(true);
        this.lbq.getSettings().cIr();
        this.lbq.getSettings().cIq();
        this.lbq.getSettings().setGeolocationEnabled(false);
        this.lbq.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.lbq.setWebChromeClient(new 1(this));
        this.lbq.setWebViewClient(new 2(this));
        setBackBtn(new 3(this));
        this.lbq.loadUrl(getString(R.l.dQw, new Object[]{w.cfi()}));
    }

    public final int getLayoutId() {
        return R.i.dcO;
    }
}
