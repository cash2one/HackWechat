package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.FTSEditTextView$b;
import com.tencent.mm.ui.fts.widget.a;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private View jLL;
    private String jLM;
    private String jLN;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jLN = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        x.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[]{this.jLN});
        g.pQN.h(13929, new Object[]{this.jLN, "", Integer.valueOf(1), Integer.valueOf(this.scene)});
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.jLN);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
    }

    protected final void initView() {
        super.initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1052684));
        cmS();
        AJ(WebView.NIGHT_MODE_COLOR);
    }

    protected final void akN() {
        super.akN();
        if (this.qca != null) {
            this.qca.findViewById(R.h.bIc).setVisibility(8);
            ((ImageView) this.qca.findViewById(R.h.bIa)).setImageResource(R.g.bAk);
            FTSEditTextView fTSEditTextView = (FTSEditTextView) this.qca.findViewById(R.h.cki);
            fTSEditTextView.jCP.setImageResource(R.k.dvM);
            ((ImageButton) fTSEditTextView.findViewById(R.h.bWg)).setImageResource(R.k.dvL);
            fTSEditTextView.yig.setHintTextColor(1711276032);
            fTSEditTextView.yig.setTextColor(WebView.NIGHT_MODE_COLOR);
            k.a(this);
        }
    }

    protected final int akH() {
        if (VERSION.SDK_INT >= 23 && (!h.zj() || !AppBrandNearbyWebViewUI.akI())) {
            ae.g(getWindow());
            return -1052684;
        } else if (VERSION.SDK_INT >= 21) {
            return n.isf;
        } else {
            return super.akH();
        }
    }

    public void onDestroy() {
        if (this.scene == 3 || this.scene == 16) {
            g.pQN.h(13929, new Object[]{this.jLN, b.hjy, Integer.valueOf(2), Integer.valueOf(this.scene)});
        }
        super.onDestroy();
    }

    public final boolean akL() {
        this.jLL.setVisibility(8);
        return super.akL();
    }

    public final void a(String str, String str2, List<a.b> list, FTSEditTextView$b fTSEditTextView$b) {
        if (!TextUtils.isEmpty(str2)) {
            this.jLL.setVisibility(8);
        }
        try {
            this.juQ.e(10001, null);
        } catch (RemoteException e) {
            x.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[]{e});
        }
        super.a(str, str2, list, fTSEditTextView$b);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        this.jLM = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.jLL = getLayoutInflater().inflate(R.i.dam, (ViewGroup) view, false);
        View findViewById = this.jLL.findViewById(R.h.cyM);
        findViewById.setOnClickListener(new 1(this));
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

    protected final void h(int i, Bundle bundle) {
        super.h(i, bundle);
        switch (i) {
            case 142:
                this.handler.post(new 2(this, bundle.getString("fts_key_json_data"), bundle.getInt("fts_key_is_cache_data", 0), bundle.getInt("fts_key_is_expired", 1)));
                return;
            default:
                return;
        }
    }
}
