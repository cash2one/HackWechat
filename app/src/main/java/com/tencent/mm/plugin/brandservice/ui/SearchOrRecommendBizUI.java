package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.brandservice.a.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import com.tencent.mm.z.ar;

public class SearchOrRecommendBizUI extends MMActivity implements b {
    private int kEP = 0;
    private BizSearchResultItemContainer kFj;
    private int kFm = 0;
    private ProgressDialog kGT = null;
    private SearchViewNotRealTimeHelper kGU;

    protected final int getLayoutId() {
        return R.i.deZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEP = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.kFm = getIntent().getIntExtra("fromScene", 0);
        initView();
        if (g.asj()) {
            ar.CG().a(456, new 1(this));
            ar.CG().a(new g(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!bh.ov(stringExtra)) {
            new af(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SearchOrRecommendBizUI kGV;

                public final void run() {
                    this.kGV.kGU.ZR(stringExtra);
                    this.kGV.kGU.zmE.performClick();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        y.Mn().LZ();
    }

    protected final void initView() {
        setMMTitle(R.l.dXn);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI kGV;

            {
                this.kGV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kGV.aWs();
                this.kGV.finish();
                return true;
            }
        });
        this.kGU = (SearchViewNotRealTimeHelper) findViewById(R.h.cKe);
        SearchViewNotRealTimeHelper searchViewNotRealTimeHelper = this.kGU;
        searchViewNotRealTimeHelper.yig.setTextColor(getResources().getColor(R.e.btv));
        this.kGU.U(getString(R.l.dXn));
        searchViewNotRealTimeHelper = this.kGU;
        searchViewNotRealTimeHelper.yig.setHintTextColor(getResources().getColor(R.e.bsN));
        this.kGU.yig.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        searchViewNotRealTimeHelper = this.kGU;
        if (searchViewNotRealTimeHelper.zgk != null) {
            searchViewNotRealTimeHelper.zgk.setVisibility(8);
        }
        this.kGU.zmF = new a(this) {
            final /* synthetic */ SearchOrRecommendBizUI kGV;

            {
                this.kGV = r1;
            }

            public final boolean oK(String str) {
                vR(str);
                return true;
            }

            public final void vR(String str) {
                if (bh.ov(str)) {
                    h.bu(this.kGV.mController.xIM, this.kGV.getString(R.l.dXl));
                    return;
                }
                this.kGV.aWs();
                this.kGV.kFj.aU(str, 0);
            }

            public final void asB() {
                this.kGV.showVKB();
            }
        };
        this.kFj = (BizSearchResultItemContainer) findViewById(R.h.cJm);
        this.kFj.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI kGV;

            {
                this.kGV = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.kGV.kGU.clearFocus();
                this.kGV.aWs();
                return false;
            }
        });
        c fVar = new f(this);
        fVar.kGP = g.ask();
        this.kFj.a(fVar);
        this.kFj.d(1);
        this.kFj.dW(false);
        this.kFj.kFN = 1;
        this.kFj.lw(this.kFm);
        this.kFj.kFJ = this;
    }

    public final void asq() {
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.kGT = h.a(context, getString(R.l.dXm), true, new OnCancelListener(this) {
            final /* synthetic */ SearchOrRecommendBizUI kGV;

            {
                this.kGV = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                BizSearchResultItemContainer a = this.kGV.kFj;
                ar.CG().c(a.kFI);
                a.kFG.kFT = false;
            }
        });
    }

    public final void asr() {
        if (this.kGT != null) {
            this.kGT.dismiss();
            this.kGT = null;
        }
    }
}
