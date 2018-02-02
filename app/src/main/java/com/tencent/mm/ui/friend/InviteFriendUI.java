package com.tencent.mm.ui.friend;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class InviteFriendUI extends MMActivity implements a {
    private ImageView hvY;
    private String zcF;
    private int zcG;
    private String zcH;
    private String zcI;
    private String zcJ;
    private Button zcK;
    private int zcL;
    private int zcM;
    private String zcN = null;
    private String zcO = null;

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        if (inviteFriendUI.zcL > 0 && inviteFriendUI.zcM > 0) {
            g.pQN.h(10991, Integer.valueOf(inviteFriendUI.zcL), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.zcM));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.epH);
        Intent intent = getIntent();
        this.zcG = intent.getIntExtra("friend_type", -1);
        this.zcH = intent.getStringExtra("friend_nick");
        this.zcF = intent.getStringExtra("friend_num");
        this.zcI = intent.getStringExtra("friend_googleID");
        this.zcJ = intent.getStringExtra("friend_googleItemID");
        this.zcF = bh.ou(this.zcF);
        this.zcN = intent.getStringExtra("friend_linkedInID");
        this.zcO = intent.getStringExtra("friend_linkedInPicUrl");
        initView();
        this.zcL = intent.getIntExtra("search_kvstat_scene", 0);
        this.zcM = intent.getIntExtra("search_kvstat_position", 0);
    }

    protected void onPause() {
        super.onPause();
        n.Jz().e(this);
    }

    protected void onResume() {
        super.onResume();
        n.Jz().d(this);
    }

    protected final int getLayoutId() {
        return R.i.dlK;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        Bitmap bitmap = null;
        this.hvY = (ImageView) findViewById(R.h.cpX);
        TextView textView = (TextView) findViewById(R.h.cqb);
        TextView textView2 = (TextView) findViewById(R.h.cqd);
        TextView textView3 = (TextView) findViewById(R.h.cqc);
        this.zcK = (Button) findViewById(R.h.cqa);
        Button button = (Button) findViewById(R.h.cqe);
        textView.setText(this.zcH);
        textView3.setText(getString(R.l.cqc, new Object[]{this.zcH}));
        if (this.zcG == 1) {
            Bitmap a;
            this.hvY.setBackgroundDrawable(com.tencent.mm.bv.a.b(this, R.k.dyn));
            textView2.setText(getString(R.l.dEX) + this.zcF);
            String s = com.tencent.mm.a.g.s(this.zcF.getBytes());
            ar.Hg();
            if (c.isSDCardAvailable()) {
                b kS = af.OD().kS(s);
                a = kS != null ? m.a(kS.Ns(), this) : null;
            } else {
                a = n.Jz().bg(ac.getContext());
            }
            if (a != null) {
                this.hvY.setImageBitmap(a);
            } else {
                this.hvY.setImageDrawable(com.tencent.mm.bv.a.b(this, R.k.dyn));
            }
        }
        if (this.zcG == 0) {
            this.hvY.setBackgroundDrawable(com.tencent.mm.bv.a.b(this, R.k.dyo));
            textView2.setText(getString(R.l.dEZ) + this.zcF);
            long bY = (long) o.bY(this.zcF);
            if (bY != 0) {
                bitmap = com.tencent.mm.ad.b.aO(bY);
            }
            if (bitmap == null) {
                this.hvY.setImageDrawable(com.tencent.mm.bv.a.b(this, R.k.dyo));
            } else {
                this.hvY.setImageBitmap(bitmap);
            }
            button.setVisibility(0);
        }
        if (this.zcG == 2) {
            Bitmap iO;
            this.zcK.setText(R.l.enw);
            this.hvY.setBackgroundDrawable(com.tencent.mm.bv.a.b(this, R.g.bBC));
            textView2.setText(getString(R.l.dER) + this.zcF);
            ar.Hg();
            if (c.isSDCardAvailable()) {
                iO = com.tencent.mm.ad.b.iO(this.zcI);
            } else {
                iO = n.Jz().bg(ac.getContext());
            }
            if (iO != null) {
                this.hvY.setImageBitmap(iO);
            } else {
                this.hvY.setImageDrawable(com.tencent.mm.bv.a.b(this, R.g.bBC));
            }
            if (TextUtils.isEmpty(this.zcH)) {
                textView.setText(bh.VS(this.zcF));
                textView3.setText(getString(R.l.cqc, new Object[]{bh.VS(this.zcF)}));
            }
        }
        if (this.zcG == 3) {
            this.zcK.setText(R.l.epG);
            Bitmap a2 = j.a(new d(this.zcO, this.zcO));
            if (a2 != null) {
                this.hvY.setImageBitmap(a2);
            } else {
                this.hvY.setImageResource(R.k.bBB);
            }
            button.setVisibility(8);
        }
        this.zcK.setOnClickListener(new 1(this));
        button.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
    }

    public final void jh(String str) {
        if (this.zcF != null && !this.zcF.equals("")) {
            long iT = com.tencent.mm.ad.b.iT(str);
            if (iT > 0 && this.zcF.equals(String.valueOf(iT)) && this.zcG == 0) {
                this.hvY.setImageBitmap(com.tencent.mm.ad.b.a(str, false, -1));
            }
        }
    }
}
