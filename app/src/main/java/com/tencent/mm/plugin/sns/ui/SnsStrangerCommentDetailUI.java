package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.b$b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

public class SnsStrangerCommentDetailUI extends MMActivity implements b$b {
    private static int rGU = 4;
    private int cOY;
    private ImageView hvY;
    private TextView kSZ;
    private long qQJ;
    private a rDC = new a(this) {
        final /* synthetic */ SnsStrangerCommentDetailUI rGV;

        {
            this.rGV = r1;
        }

        public final void a(String str, l lVar) {
            ae.aNT().post(new 1(this));
        }
    };
    private ListView rGL;
    private SnsCommentFooter rGM;
    private View rGN;
    private LinearLayout rGO;
    private List<View> rGP;
    private a rGQ;
    private boolean rGR = false;
    private boolean rGS = false;
    private x rGT;
    private ao rry;
    private m ryi;
    private int rzE = -1;
    private String talker;

    static /* synthetic */ void a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, m mVar, String str) {
        if (str != null && !str.trim().equals("")) {
            al.a.a(snsStrangerCommentDetailUI.talker, 3, str, mVar, snsStrangerCommentDetailUI.cOY);
        }
    }

    static /* synthetic */ void b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.rGT == null) {
            snsStrangerCommentDetailUI.rGT = new x();
            return;
        }
        if (!com.tencent.mm.l.a.fZ(snsStrangerCommentDetailUI.rGT.field_type)) {
            s.e(snsStrangerCommentDetailUI.rGT);
        }
        if (snsStrangerCommentDetailUI.rGT.AF()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(j.dVK);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(j.dVH);
        }
        h.a(snsStrangerCommentDetailUI, "", strArr, "", false, new 6(snsStrangerCommentDetailUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.qKq);
        this.qQJ = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.talker = getIntent().getStringExtra("INTENT_TALKER");
        this.ryi = ae.bvv().eR(this.qQJ);
        this.cOY = getIntent().getIntExtra("INTENT_SOURCE", -1);
        g.Dk();
        this.rGT = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(this.talker);
        if (this.ryi == null || this.talker == null) {
            finish();
            return;
        }
        this.rry = new ao(this);
        ae.bvA().c(this.rDC);
        initView();
    }

    public void onResume() {
        ae.bvq().a(this);
        super.onResume();
    }

    public void onPause() {
        ae.bvq().b(this);
        super.onPause();
    }

    protected void onDestroy() {
        ae.bvA().j(this.rDC);
        ae.bvs().K(this);
        if (this.rGQ != null) {
            this.rGQ.aUn();
        }
        super.onDestroy();
    }

    protected final void initView() {
        this.rGL = (ListView) findViewById(f.qAF);
        this.rGM = (SnsCommentFooter) findViewById(f.qBF);
        this.rGN = View.inflate(this, i.g.qHT, null);
        this.rGO = (LinearLayout) this.rGN.findViewById(f.qBg);
        this.hvY = (ImageView) this.rGN.findViewById(f.qAx);
        this.kSZ = (TextView) this.rGN.findViewById(f.qBk);
        b.b(this.hvY, this.ryi.field_userName, true);
        this.kSZ.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(this.ryi.field_userName), this.kSZ.getTextSize()));
        bBv();
        for (int i = 0; i < this.rGP.size(); i++) {
            ap apVar = new ap();
            apVar.fus = this.ryi.byq();
            apVar.index = i;
            apVar.rBS = this.rGP;
            ((View) this.rGP.get(i)).setTag(apVar);
            ((View) this.rGP.get(i)).setOnClickListener(new 9(this));
        }
        this.rGL.addHeaderView(this.rGN);
        this.rGQ = new a(this, this);
        this.rGL.post(new 10(this));
        this.rGL.setAdapter(this.rGQ);
        this.rGL.setOnScrollListener(new 11(this));
        SnsCommentFooter snsCommentFooter = this.rGM;
        2 2 = new 2(this);
        snsCommentFooter.bAK();
        this.rGM.bAO();
        this.rGM.bAR();
        this.rGM.a(new 3(this));
        this.rGM.LW(getString(j.qLZ) + this.talker + getString(j.qKg));
        1 1 = new 1(this);
        setBackBtn(new 4(this));
        addIconOptionMenu(0, i$e.bDI, new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI rGV;

            {
                this.rGV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsStrangerCommentDetailUI.b(this.rGV);
                return true;
            }
        });
    }

    private void bBv() {
        this.rGO.removeAllViews();
        int b = BackwardSupportUtil.b.b(this, (float) rGU);
        List list = this.ryi.bxV().wQo.vYd;
        this.rGP = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            View mMImageView = new MMImageView(this);
            mMImageView.setPadding(b, b, b, b);
            this.rGO.addView(mMImageView, new LayoutParams(-2, -2));
            Bitmap EC = ae.bvs().a((aqr) list.get(i), mMImageView, hashCode(), an.xyY).EC();
            if (EC == null) {
                int i2;
                switch (this.ryi.field_type) {
                    case 1:
                        i2 = i$e.byV;
                        break;
                    case 2:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    case 3:
                        i2 = i.i.dvD;
                        break;
                    case 4:
                        i2 = i.i.dvn;
                        break;
                    case 5:
                        i2 = i.i.dvA;
                        break;
                    case 6:
                        i2 = i.i.dvm;
                        break;
                    case 7:
                        i2 = i$e.byV;
                        break;
                    case 8:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    default:
                        i2 = i.i.dvD;
                        break;
                }
                if (i2 != 0) {
                    mMImageView.setImageResource(i2);
                }
            } else {
                mMImageView.setImageBitmap(EC);
            }
            this.rGP.add(mMImageView);
        }
    }

    protected final int getLayoutId() {
        return i.g.qHh;
    }

    public final void JT(String str) {
        bBv();
    }

    public final void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void aF(String str, boolean z) {
    }
}
