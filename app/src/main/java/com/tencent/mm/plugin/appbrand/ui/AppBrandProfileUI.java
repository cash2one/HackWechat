package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public final class AppBrandProfileUI extends DrawStatusBarActivity implements OnClickListener, a {
    private String jKk;
    private t jKm;
    private long jLk = 0;
    private LinearLayout jLl;
    private TableLayout jLm;
    private ImageView jLn;
    private TextView jLo;
    private TextView jLp;
    private TextView jLq;
    private View jLr;
    private View jLs;
    private TextView jLt;
    private a jLu;
    private WxaExposedParams jLv;
    private boolean jLw = false;
    private g jLx;

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        if (appBrandProfileUI.jLx == null || !appBrandProfileUI.jLx.isShowing()) {
            appBrandProfileUI.jLx = new g(appBrandProfileUI, g.ztp, false);
            appBrandProfileUI.jLx.rKC = new 3(appBrandProfileUI);
            appBrandProfileUI.jLx.rKD = new 4(appBrandProfileUI);
        }
        appBrandProfileUI.jLx.bUk();
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, t tVar, long j) {
        boolean z = false;
        if (!appBrandProfileUI.isFinishing() && !appBrandProfileUI.xIq && tVar != null) {
            if ((appBrandProfileUI.jKm == null || !bh.ou(appBrandProfileUI.jKm.iPN).equals(tVar.iPN)) && appBrandProfileUI.jLn != null) {
                b.Jj().a(appBrandProfileUI.jLn, tVar.iPN, com.tencent.mm.modelappbrand.a.a.Ji(), new f());
            }
            if ((appBrandProfileUI.jKm == null || !bh.ou(appBrandProfileUI.jKm.fpL).equals(tVar.fpL)) && appBrandProfileUI.jLo != null) {
                appBrandProfileUI.jLo.setText(tVar.fpL);
                appBrandProfileUI.setMMTitle(tVar.fpL);
            }
            if ((appBrandProfileUI.jKm == null || !bh.ou(appBrandProfileUI.jKm.signature).equals(tVar.signature)) && appBrandProfileUI.jLp != null) {
                if (bh.ov(tVar.signature)) {
                    appBrandProfileUI.jLp.setText("");
                    appBrandProfileUI.jLp.setVisibility(8);
                } else {
                    appBrandProfileUI.jLp.setText(tVar.signature);
                    appBrandProfileUI.jLp.setVisibility(0);
                }
            }
            if ((appBrandProfileUI.jKm == null || !bh.ou(tVar.acf()).equals(appBrandProfileUI.jKm.acf())) && appBrandProfileUI.jLq != null) {
                appBrandProfileUI.jLq.setText(tVar.acf());
                appBrandProfileUI.jLr.setVisibility(0);
            }
            if (appBrandProfileUI.jLu != null) {
                List list = tVar.iPl;
                if (bh.cA(list)) {
                    appBrandProfileUI.jLu.VU.setVisibility(8);
                } else {
                    a.a(appBrandProfileUI.jLu, list);
                    appBrandProfileUI.jLu.VU.setVisibility(0);
                }
                appBrandProfileUI.jLu.mAppId = tVar.appId;
                if (j != appBrandProfileUI.jLk && (2 & j) > 0) {
                    appBrandProfileUI.jLu.VU.setVisibility(8);
                }
            }
            if ((appBrandProfileUI.jKm == null || !bh.ou(tVar.hpu).equals(appBrandProfileUI.jKm.hpu)) && appBrandProfileUI.jLt != null) {
                appBrandProfileUI.jLt.setText(tVar.hpu);
            }
            if (appBrandProfileUI.jKm == null || appBrandProfileUI.jKm.iPF != tVar.iPF) {
                if (tVar.iPF != 0) {
                    z = true;
                }
                appBrandProfileUI.dh(z);
            }
            appBrandProfileUI.jKm = tVar;
            appBrandProfileUI.jLk = j;
        }
    }

    public static void a(Context context, String str, String str2, WxaExposedParams wxaExposedParams) {
        if (!bh.ov(str)) {
            if (context == null) {
                context = ac.getContext();
            }
            Intent putExtra = new Intent(context, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", 3).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", wxaExposedParams);
            if (wxaExposedParams != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", 6);
                bundle.putString("stat_app_id", wxaExposedParams.appId);
                bundle.putString("stat_url", wxaExposedParams.fCp);
                putExtra.putExtra("_stat_obj", bundle);
            }
            if (!(context instanceof Activity)) {
                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(putExtra);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!bh.ov(this.jKk)) {
            q.abY().j(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jKk = stringExtra;
        if (bh.ov(stringExtra)) {
            finish();
        } else {
            di(true);
        }
    }

    public final void onBackPressed() {
        if (VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
        bM(6, 1);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jKk = stringExtra;
        if (bh.ov(stringExtra)) {
            finish();
            return;
        }
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
        getIntent().setExtrasClassLoader(getClassLoader());
        this.jLv = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        setBackBtn(new 1(this), com.tencent.mm.plugin.appbrand.q.f.itj);
        addIconOptionMenu(0, j.gYx, i.iyl, new 2(this));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1));
        cmS();
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(h.ixe, this.jLl, true);
        View inflate2 = from.inflate(h.ixd, this.jLl, true);
        this.jLm = (TableLayout) inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwq);
        a(this.jLm);
        this.jLn = (ImageView) inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.cDM);
        this.jLo = (TextView) inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwm);
        this.jLp = (TextView) inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwi);
        this.jLq = (TextView) inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwo);
        this.jLr = inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwn);
        this.jLu = new a(this, inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwh));
        this.jLs = inflate.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwk);
        this.jLt = (TextView) this.jLs.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwl);
        dh(true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        inflate2.setClickable(false);
        inflate2.setLongClickable(false);
        View findViewById = inflate2.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwj);
        inflate = inflate2.findViewById(com.tencent.mm.plugin.appbrand.q.g.iwp);
        findViewById.setOnClickListener(this);
        inflate.setOnClickListener(this);
        di(true);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        View scrollView = new ScrollView(this);
        scrollView.setBackgroundResource(d.isA);
        this.jLl = new LinearLayout(this);
        this.jLl.setOrientation(1);
        scrollView.addView(this.jLl, new LayoutParams(-1, -2));
        ((FrameLayout) view).addView(scrollView);
    }

    protected final void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = getIntent().getBooleanExtra("key_can_swipe_back", true);
        }
    }

    protected final void initActivityCloseAnimation() {
        if (!this.jLw) {
            super.initActivityCloseAnimation();
        }
    }

    private void dh(boolean z) {
        if (this.jLs != null) {
            if (z) {
                this.jLs.setVisibility(8);
                return;
            }
            this.jLs.setVisibility(0);
            this.jLs.setOnClickListener(this);
        }
    }

    private void bM(int i, int i2) {
        b(i, i2, bh.Wo());
    }

    private void b(int i, int i2, long j) {
        String str = this.jKm == null ? null : this.jKm.appId;
        if (!bh.ov(str)) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 3);
            String ou = bh.ou(getIntent().getStringExtra("key_scene_note"));
            int i3 = 0;
            WxaAttributes f = com.tencent.mm.plugin.appbrand.app.f.Zh().f(str, new String[]{"appInfo", "brandIconURL", "nickname"});
            if (f != null) {
                i3 = f.abZ().hoL;
            }
            i3 += 1000;
            x.d("MicroMsg.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[]{Integer.valueOf(13919), str, Integer.valueOf(intExtra), ou, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            com.tencent.mm.plugin.report.service.g.pQN.h(13919, new Object[]{str, Integer.valueOf(intExtra), ou, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)});
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        q.abY().j(this);
    }

    public final void onClick(View view) {
        if (view.getId() == com.tencent.mm.plugin.appbrand.q.g.iwk) {
            if (this.jKm != null && !bh.ov(this.jKm.appId)) {
                com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", l.pq(this.jKm.appId)).putExtra("forceHideShare", true));
                bM(2, 1);
            }
        } else if (view.getId() == com.tencent.mm.plugin.appbrand.q.g.iwj) {
            if (this.jKm != null) {
                Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                appBrandStatObject.fIs = c.f(appBrandStatObject.scene, bundleExtra);
                appBrandStatObject.fIt = c.g(appBrandStatObject.scene, bundleExtra);
                com.tencent.mm.plugin.appbrand.launching.precondition.g.jzg.a(this, this.jKm.username, null, null, 0, -1, appBrandStatObject, null, null);
                bM(4, 1);
                if (appBrandStatObject.fIs == 6) {
                    this.jLw = true;
                    finish();
                }
            }
        } else if (view.getId() == com.tencent.mm.plugin.appbrand.q.g.iwp) {
            t qN = q.qN(this.jKk);
            if (qN == null) {
                x.w("MicroMsg.AppBrandProfileUI", "attrs is null.");
                return;
            }
            Serializable hashMap = new HashMap();
            hashMap.put("desc", "");
            hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(1));
            hashMap.put("title", qN.fpL);
            hashMap.put("img_url", qN.iPN);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            com.tencent.mm.bm.d.a((MMActivity) view.getContext(), ".ui.transmit.SelectConversationUI", intent, 1, new 5(this, qN, view));
        }
    }

    private void di(boolean z) {
        e.post(new 6(this, z), "AppBrandProfile");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (lVar.iYZ == 3 && (lVar.obj instanceof String) && !bh.ov(this.jKk) && this.jKk.equals((String) lVar.obj)) {
            di(false);
        }
    }

    private void a(TableLayout tableLayout) {
        if (tableLayout != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int childCount = tableLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = tableLayout.getChildAt(i2);
                if (childAt instanceof TableRow) {
                    TableRow tableRow = (TableRow) childAt;
                    if (tableRow.getChildCount() > 1) {
                        View childAt2 = tableRow.getChildAt(0);
                        if (childAt2 != null && (childAt2 instanceof TextView)) {
                            ((TextView) childAt2).setMaxWidth((i / 2) - tableRow.getPaddingLeft());
                        }
                    }
                }
            }
        }
    }
}
