package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a;
import java.util.List;

public class AppBrandSOSUI extends FTSSOSMoreWebViewUI {
    private View jLL;
    private String jLM;
    private String jLN;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.a.bqk, 0);
        this.jLN = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        x.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.jLN);
        g.pQN.h(13929, this.jLN, "", Integer.valueOf(1), Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.jLN);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
    }

    public void onDestroy() {
        if (this.scene == 3 || this.scene == 16) {
            g.pQN.h(13929, this.jLN, b.hjy, Integer.valueOf(2), Integer.valueOf(this.scene));
        }
        super.onDestroy();
    }

    public final boolean akL() {
        this.jLL.setVisibility(8);
        return super.akL();
    }

    public final void a(String str, String str2, List<a.b> list, FTSEditTextView.b bVar) {
        if (!TextUtils.isEmpty(str2)) {
            this.jLL.setVisibility(8);
        }
        try {
            this.juQ.e(10001, null);
        } catch (RemoteException e) {
            x.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", e);
        }
        super.a(str, str2, list, bVar);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        this.jLM = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.jLL = getLayoutInflater().inflate(R.i.dam, (ViewGroup) view, false);
        View findViewById = this.jLL.findViewById(R.h.cyM);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppBrandSOSUI jLO;

            {
                this.jLO = r1;
            }

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(this.jLO.jLM)) {
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", this.jLO.jLM);
                    intent.putExtra("geta8key_scene", 41);
                    intent.putExtra("show_long_click_popup_menu", false);
                    d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        if (TextUtils.isEmpty(this.jLM)) {
            findViewById.setVisibility(8);
            this.jLL.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.jLL.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.jLL);
            return;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.jLL;
            int paddingLeft = this.jLL.getPaddingLeft();
            Rect rect = new Rect();
            int bSz = bSz();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                bSz += akM();
            }
            bSz = (height - rect.height() < 0 || iArr[1] <= 200) ? bSz + rect.top : bSz + (height - rect.height());
            view2.setPadding(paddingLeft, bSz + this.jLL.getPaddingTop(), this.jLL.getPaddingRight(), this.jLL.getPaddingBottom());
        }
        addContentView(this.jLL, layoutParams);
    }

    private int akM() {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(bh.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        return i;
    }
}
