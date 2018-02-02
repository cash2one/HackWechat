package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

@a(3)
public class ShareToFacebookRedirectUI extends MMActivity implements e {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private String ilD;
    private String ilE;
    private String ilF;
    private String ilG;
    private r ilH;

    static /* synthetic */ void a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        x.e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.aF(shareToFacebookRedirectUI.mController.xIM.getString(R.l.dGO), shareToFacebookRedirectUI.mController.xIM.getString(R.l.eel));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(433, this);
        this.ilD = getIntent().getStringExtra("title");
        this.ilE = getIntent().getStringExtra("digest");
        this.ilF = getIntent().getStringExtra("img");
        this.ilG = getIntent().getStringExtra("link");
        x.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[]{this.ilD, this.ilE, this.ilF, this.ilG});
        if (q.Gt()) {
            XC();
            XD();
            return;
        }
        Intent intent = new Intent(this, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        startActivityForResult(intent, 0);
    }

    protected void onDestroy() {
        ar.CG().b(433, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i(TAG, "type:%d, code:%d, msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        aWs();
        this.ilH.dismiss();
        if (i == 4 && i2 == -68) {
            if (bh.ov(str)) {
                str = "error";
            }
            aF(getString(R.l.dGO), str);
        } else if (i == 0 && i2 == 0) {
            String string = getString(R.l.ePi);
            AnonymousClass1 anonymousClass1 = new OnDismissListener(this) {
                final /* synthetic */ ShareToFacebookRedirectUI ilI;

                {
                    this.ilI = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.bu(this, string);
            finish();
        } else {
            h.a(this.mController.xIM, "err(" + i2 + "," + i + ")", getString(R.l.dGO), new OnClickListener(this) {
                final /* synthetic */ ShareToFacebookRedirectUI ilI;

                {
                    this.ilI = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ilI.finish();
                }
            }, null);
        }
    }

    private void XC() {
        x.i(TAG, "refreshFacebookToken");
        ar.Hg();
        long c = bh.c((Long) c.CU().get(65831, null));
        ar.Hg();
        String ou = bh.ou((String) c.CU().get(65830, null));
        if (bh.bz(c) <= 86400000 || ou.length() <= 0) {
            XD();
            return;
        }
        com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
        cVar.ZI(ou);
        new com.tencent.mm.ui.account.h(cVar, new com.tencent.mm.aa.a(this) {
            final /* synthetic */ ShareToFacebookRedirectUI ilI;

            {
                this.ilI = r1;
            }

            public final void k(Bundle bundle) {
                super.k(bundle);
            }

            public final void onError(int i, String str) {
                x.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", new Object[]{Integer.valueOf(i), str});
                super.onError(i, str);
                if (i == 3) {
                    ShareToFacebookRedirectUI.a(this.ilI);
                }
            }
        }).cnV();
    }

    private void XD() {
        x.i(TAG, "doSend");
        com.tencent.mm.pluginsdk.ui.applet.e.a aVar = new com.tencent.mm.pluginsdk.ui.applet.e.a(this);
        String str = this.ilD;
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(aVar.mContext, (int) (20.0f * com.tencent.mm.bv.a.eu(aVar.mContext)));
        if (!bh.ov(str)) {
            aVar.vnq.P(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(aVar.mContext, str.toString(), (float) fromDPToPix));
        }
        aVar.Sq(this.ilF).Sp(this.ilE).Ss(getString(R.l.dEq)).BW(R.l.dGE).a(new 4(this, aVar)).pyk.show();
    }

    private void aF(String str, String str2) {
        h.a(this.mController.xIM, str2, str, new 5(this), null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i == 0 && i2 == -1 && intent != null) {
            x.i(TAG, "bind facebooksucc %b", new Object[]{Boolean.valueOf(intent.getBooleanExtra("bind_facebook_succ", false))});
            if (intent.getBooleanExtra("bind_facebook_succ", false)) {
                XC();
                XD();
                return;
            }
        }
        finish();
    }
}
