package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ActionBarContainer;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.b.b.a;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public final class f {
    public p fhr;
    public int qra = 0;
    public q yvR;
    public b yvU;
    public u yvY;
    public j yvZ;
    public c ywd;
    protected LinearLayout yzj;
    protected LinearLayout yzk;
    private List<String> yzl = new LinkedList();
    String yzm;
    public ActionBarContainer yzn = null;
    public q yzo = null;
    public b yzp;
    public View yzq;
    public final s yzr = new a(this);
    public a yzs = new 1(this);
    public final d.a yzt = new d.a(this) {
        final /* synthetic */ f yzA;

        {
            this.yzA = r1;
        }

        public final void jh(final String str) {
            this.yzA.fhr.css().postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 yzC;

                public final void run() {
                    if (!bh.ov(this.yzC.yzA.yzm) && !bh.ov(str) && str.equals(this.yzC.yzA.yzm)) {
                        this.yzC.yzA.cts();
                    }
                }
            }, 1000);
        }
    };
    public OnMenuItemClickListener yzu = new 5(this);
    final int yzv = 1;
    final int yzw = 2;
    public final OnMenuItemClickListener yzx = new 6(this);
    private View yzy = null;
    private View yzz = null;

    static /* synthetic */ void a(f fVar) {
        String str = bh.ov(fVar.yzm) ? fVar.fhr.csi().field_username : fVar.yzm;
        if (str != null && !str.equals("")) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Encryptusername", true);
            if (fVar.fhr.csl()) {
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_IsLbsChattingProfile", true);
                intent.putExtra("Contact_Scene", 18);
            } else {
                g.pQN.h(11004, new Object[]{fVar.yzm, Integer.valueOf(2)});
            }
            com.tencent.mm.bm.d.b(fVar.fhr.csq().getContext(), "profile", ".ui.ContactInfoUI", intent);
        }
    }

    public f(p pVar) {
        this.fhr = pVar;
    }

    public final void ctp() {
        if (this.fhr.csx().getHeaderViewsCount() > 0) {
            this.yzj = (LinearLayout) this.fhr.csx().findViewById(R.h.csZ);
        } else {
            this.yzj = (LinearLayout) this.fhr.csq().getLayoutInflater().inflate(R.i.dem, null);
            this.fhr.csx().addHeaderView(this.yzj);
        }
        this.yzj.removeAllViews();
        cts();
    }

    public final boolean ctq() {
        return this.fhr.csq().isSupportNavigationSwipeBack();
    }

    private View m(ViewGroup viewGroup) {
        if (this.yzq == null) {
            if (viewGroup == null) {
                this.yzq = v.fv(this.fhr.csq().getContext()).inflate(R.i.cZW, null);
            } else {
                this.yzq = v.fv(this.fhr.csq().getContext()).inflate(R.i.cZW, viewGroup, false);
            }
            return this.yzq;
        } else if (this.yzq.getParent() == null) {
            return this.yzq;
        } else {
            if (this.yzq.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.yzq.getParent()).removeView(this.yzq);
                return this.yzq;
            }
            if (viewGroup == null) {
                this.yzq = v.fv(this.fhr.csq().getContext()).inflate(R.i.cZW, null);
            } else {
                this.yzq = v.fv(this.fhr.csq().getContext()).inflate(R.i.cZW, viewGroup, false);
            }
            return this.yzq;
        }
    }

    public final void ctr() {
        ActionBar supportActionBar;
        View m;
        if (this.fhr.csq().isCurrentActivity || !ctq()) {
            supportActionBar = ((ActionBarActivity) this.fhr.csq().thisActivity()).getSupportActionBar();
            m = m(null);
            supportActionBar.setCustomView(m);
            this.yzp = new b(m);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.yzn.findViewById(R.h.action_bar);
            x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "mActionBarContainer %s", new Object[]{this.yzn});
            m = this.yzn.findViewById(R.h.action_context_bar);
            x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "ctxView %s", new Object[]{m});
            viewGroup.setVisibility(0);
            ActionBar supportActionBar2 = this.yzo.getSupportActionBar();
            View m2 = m(viewGroup);
            supportActionBar2.setCustomView(m2);
            this.yzp = new b(m2);
            int height = supportActionBar2.getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = this.fhr.csq().getMMResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    height = this.fhr.csq().getMMResources().getDimensionPixelSize(R.f.buF);
                } else {
                    height = this.fhr.csq().getMMResources().getDimensionPixelSize(R.f.buG);
                }
            }
            m2.setMinimumHeight(height);
            LayoutParams layoutParams = m2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = height;
            m2.setLayoutParams(layoutParams);
            supportActionBar = supportActionBar2;
        }
        this.yzp.lL(false);
        supportActionBar.setDisplayOptions((((supportActionBar.getDisplayOptions() | 16) & -5) & -3) & -9);
        this.yzl.clear();
        this.yzl.add(this.fhr.csq().getStringExtra("Chat_User"));
        this.fhr.csq().setBackBtn(this.yzu);
    }

    public final void cts() {
        Object obj = null;
        if (this.fhr.csd()) {
            String str;
            String crz = this.fhr.crz();
            ar.Hg();
            com.tencent.mm.storage.q hD = c.Fh().hD(crz);
            if (hD != null && hD.Ms().size() == 2) {
                int size = hD.Ms().size();
                for (int i = 0; i < size; i++) {
                    str = (String) hD.Ms().get(i);
                    if (g.Zi(str)) {
                        break;
                    }
                }
            }
            str = null;
            this.yzm = str;
            if (bh.ov(this.yzm) || !this.fhr.csu()) {
                ctw();
            } else {
                ctu();
            }
        } else if (!g.Zi(this.fhr.crz()) || this.fhr.csj()) {
            q qVar = this.yvR;
            if (qVar.fhr.csl()) {
                h nb = l.Ty().nb(qVar.fhr.vS());
                if (!(qVar.kvB == null && nb == null)) {
                    qVar.yAv.ctu();
                }
                obj = 1;
            }
            if (obj == null) {
                ctw();
                ctv();
            }
        } else {
            this.yzm = this.fhr.crz();
            ctu();
        }
        ctx();
        ctt();
    }

    final void ctt() {
        if (this.fhr.csq().getActivity() == null) {
            x.w("MicroMsg.ChattingUI.ChattingHeadereMgr", "getActivity is null");
            return;
        }
        ctz();
        ViewGroup viewGroup = (ViewGroup) this.fhr.csq().findViewById(R.h.bTx);
        com.tencent.mm.pluginsdk.ui.b.a a = e.a(this.fhr.csq().getContext(), e.a.zaG, new Object[]{com.tencent.mm.z.b.b.b.his});
        if (viewGroup != null && a != null && a.getView() != null && this.yzz == null) {
            this.yzz = a.getView();
            viewGroup.addView(this.yzz, new LayoutParams(-1, -2));
        }
    }

    @SuppressLint({"ResourceType"})
    public final void ctu() {
        ctw();
        if (this.yzk == null) {
            g.a(this.fhr.csq(), R.h.cVV);
            this.yzk = (LinearLayout) this.fhr.csq().findViewById(R.h.cii);
        }
        this.yzk.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.fhr.csq().getLayoutInflater().inflate(R.i.del, null);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.bJb);
        String str = this.yzm;
        if (bh.ov(str)) {
            str = this.fhr.csi().field_username;
        }
        Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
        if (a == null) {
            imageView.setImageResource(R.k.bBB);
        } else {
            imageView.setImageBitmap(a);
        }
        Button button = (Button) linearLayout.findViewById(R.h.bSM);
        if (this.fhr.csl()) {
            q qVar = this.yvR;
            LinearLayout linearLayout2 = this.yzk;
            if (qVar.kvB == null) {
                h nb = l.Ty().nb(qVar.fhr.vS());
                if (nb != null) {
                    ((TextView) linearLayout.findViewById(R.h.bJa)).setText(nb.field_sayhicontent);
                    ((Button) linearLayout.findViewById(R.h.bSM)).setText(R.l.dRz);
                } else {
                    linearLayout2.setVisibility(8);
                }
            } else if (qVar.yAw) {
                ((TextView) linearLayout.findViewById(R.h.bJa)).setText(R.l.dRB);
                button.setVisibility(8);
            } else {
                ((TextView) linearLayout.findViewById(R.h.bJa)).setText(R.l.dRC);
                ((Button) linearLayout.findViewById(R.h.bSM)).setText(R.l.dRA);
            }
        }
        imageView.setOnClickListener(new 7(this));
        button.setOnClickListener(new 8(this, linearLayout));
        g.pQN.h(11004, new Object[]{this.yzm, Integer.valueOf(1)});
        this.yzk.addView(linearLayout, new LayoutParams(-1, -2));
    }

    private void ctv() {
        if (!this.fhr.csd() && this.yzj != null) {
            ctw();
            com.tencent.mm.pluginsdk.ui.b.a a = e.a(this.fhr.csq().getContext(), e.a.zax, new Object[]{this.fhr.crz(), this.fhr.csX()});
            if (!(a == null || a.getView() == null)) {
                this.yzj.addView(a.getView(), new LayoutParams(-1, -2));
                this.yzj.setVisibility(0);
            }
            g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, new Object[]{this.fhr.crz(), Integer.valueOf(1), Integer.valueOf(0)});
        }
    }

    private void ctw() {
        if (this.yzj != null) {
            this.yzj.removeAllViews();
        }
        if (this.yzk != null) {
            this.yzk.setVisibility(8);
            this.yzk.removeAllViews();
        }
    }

    final void ctx() {
        if (this.fhr.csq().getActivity() == null) {
            x.w("MicroMsg.ChattingUI.ChattingHeadereMgr", "getActivity is null");
            return;
        }
        cty();
        ViewGroup viewGroup = (ViewGroup) this.fhr.csq().findViewById(R.h.bTE);
        com.tencent.mm.pluginsdk.ui.b.a a = e.a(this.fhr.csq().getContext(), e.a.zay, new Object[]{this.fhr.crz(), this.fhr.csX(), Boolean.valueOf(this.fhr.csd())});
        if (viewGroup != null && a != null && a.getView() != null && this.yzy == null) {
            this.yzy = a.getView();
            viewGroup.addView(this.yzy, new LayoutParams(-1, -2));
        }
    }

    final void cty() {
        ViewGroup viewGroup = (ViewGroup) this.fhr.csq().findViewById(R.h.bTE);
        if (viewGroup != null && this.yzy != null) {
            viewGroup.removeView(this.yzy);
            this.yzy = null;
        }
    }

    final void ctz() {
        ViewGroup viewGroup = (ViewGroup) this.fhr.csq().findViewById(R.h.bTx);
        if (viewGroup != null && this.yzz != null) {
            viewGroup.removeView(this.yzz);
            this.yzz = null;
        }
    }

    public final int ctA() {
        if (this.yzj == null || !this.yzj.isShown()) {
            return 0;
        }
        return this.yzj.getHeight() + 0;
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.yzp.p(new 9(this, onMenuItemClickListener));
    }
}
