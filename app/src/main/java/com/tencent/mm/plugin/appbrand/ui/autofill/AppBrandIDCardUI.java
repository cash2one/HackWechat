package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.LinkedList;
import org.json.JSONArray;

public class AppBrandIDCardUI extends DrawStatusBarActivity {
    public static final int jKK = g.itT;
    private String appId;
    public Fragment jNJ;
    public Fragment jNK;
    private bik jNL;
    private ed jNM;
    private LinkedList<Integer> jNN;
    private String jNO;
    private String jNP;
    private a jNt = new 1(this);
    private r jwL;

    static /* synthetic */ void d(AppBrandIDCardUI appBrandIDCardUI) {
        x.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
        appBrandIDCardUI.jNJ = new a();
        ((a) appBrandIDCardUI.jNJ).jNt = appBrandIDCardUI.jNt;
        appBrandIDCardUI.getSupportFragmentManager().aS().a(jKK, appBrandIDCardUI.jNJ, appBrandIDCardUI.jNJ.getClass().getSimpleName()).m(appBrandIDCardUI.jNJ.getClass().getSimpleName()).commit();
    }

    static /* synthetic */ void g(AppBrandIDCardUI appBrandIDCardUI) {
        x.i("MicroMsg.AppBrandIDCardUI", "switchToVerifyFragment");
        appBrandIDCardUI.jNK = new b();
        ((b) appBrandIDCardUI.jNK).jNt = appBrandIDCardUI.jNt;
        appBrandIDCardUI.getSupportFragmentManager().aS().a(jKK, appBrandIDCardUI.jNK, appBrandIDCardUI.jNK.getClass().getSimpleName()).m(appBrandIDCardUI.jNK.getClass().getSimpleName()).commit();
        if (appBrandIDCardUI.isSupportNavigationSwipeBack()) {
            appBrandIDCardUI.getSwipeBackLayout().mEnable = false;
        }
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
            finish();
            return;
        }
        this.appId = extras.getString("intent_appid", "");
        if (bh.ov(this.appId)) {
            x.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
            finish();
            return;
        }
        this.jNN = y(extras);
        if (bh.cA(this.jNN) || this.jNN.size() <= 0) {
            x.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
            Intent intent = new Intent();
            intent.putExtra("intent_err_code", 40003);
            intent.putExtra("intent_err_msg", "category_id is null");
            setResult(1, intent);
            finish();
            return;
        }
        this.mController.contentView.setBackgroundColor(-1052684);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        View frameLayout = new FrameLayout(this);
        frameLayout.setId(jKK);
        ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
        setBackBtn(new 2(this));
        getString(j.dGO);
        this.jwL = h.a(this, getString(j.ctB), true, new 3(this));
        this.jwL.show();
        this.jNt.akX();
    }

    public void onBackPressed() {
        back();
    }

    private void back() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
            return;
        }
        super.onBackPressed();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().mEnable = true;
        }
    }

    public void onSwipeBack() {
        back();
    }

    private static LinkedList<Integer> y(Bundle bundle) {
        LinkedList<Integer> linkedList = new LinkedList();
        try {
            x.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[]{bundle.getString("intent_category_id")});
            JSONArray jSONArray = new JSONArray(r1);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(Integer.valueOf(jSONArray.optInt(i)));
            }
            return linkedList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
