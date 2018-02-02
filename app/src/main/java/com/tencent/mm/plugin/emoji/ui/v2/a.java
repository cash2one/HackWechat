package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class a extends u implements OnScrollListener, OnItemClickListener, e, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.h.a, b, com.tencent.mm.pluginsdk.model.i.a, com.tencent.mm.sdk.e.j.a, c, d, MMPullDownView.e {
    ListView Fv;
    private View kgl;
    private final int lAD = 131074;
    private final int lAE = 131075;
    private final int lAF = 131076;
    private final String lAG = "product_id";
    private final String lAH = "progress";
    private final String lAI = DownloadInfo.STATUS;
    private n lAJ;
    private int lAK;
    private f lAL;
    private h lAM;
    private com.tencent.mm.sdk.b.c lAO = new com.tencent.mm.sdk.b.c<cs>(this) {
        final /* synthetic */ a lFm;

        {
            this.lFm = r2;
            this.xen = cs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cs csVar = (cs) bVar;
            if (csVar != null) {
                a aVar = this.lFm;
                String str = csVar.fqU.fqV;
                int i = csVar.fqU.status;
                int i2 = csVar.fqU.progress;
                x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), csVar.fqU.fqW);
                if (!(aVar.lxL == null || aVar.lxL.luB == null)) {
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        aVar.m(obtain);
                    } else {
                        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", Integer.valueOf(i));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt(DownloadInfo.STATUS, i);
                        obtain2.what = 131076;
                        aVar.m(obtain2);
                    }
                    com.tencent.mm.plugin.emoji.a.a.f xU = aVar.lxL.luB.xU(str);
                    if (xU != null) {
                        xU.luQ = r4;
                    }
                }
            }
            return false;
        }
    };
    private g lAP;
    private boolean lAQ = false;
    private LinkedList<sd> lAR = new LinkedList();
    private LinkedList<sf> lAS = new LinkedList();
    EmojiStoreVpHeader lAq;
    private MMPullDownView lAt;
    private TextView lAu;
    private int lAw = -1;
    private boolean lAx;
    private View lAy;
    private byte[] lAz;
    private final int lFf = 131077;
    public EmojiStoreV2HotBarView lFg;
    private boolean lFh = false;
    private boolean lFi = false;
    private boolean lFj = false;
    private af lFk = new 1(this);
    private OnMenuItemClickListener lFl = new OnMenuItemClickListener(this) {
        final /* synthetic */ a lFm;

        {
            this.lFm = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.lFm.thisActivity().finish();
            return false;
        }
    };
    private ProgressDialog ltM;
    com.tencent.mm.plugin.emoji.a.a.a lxL;
    private ActionBar mActionBar;
    private com.tencent.mm.ui.b mActionBarHelper;

    public abstract com.tencent.mm.plugin.emoji.a.a.a aCj();

    public abstract int aCq();

    public abstract boolean aDq();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.mActionBar = ((ActionBarActivity) thisActivity()).getSupportActionBar();
        View inflate = v.fv(getContext()).inflate(R.i.cZW, null);
        this.mActionBarHelper = new com.tencent.mm.ui.b(inflate);
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.cO();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.cN();
        this.mActionBar.cP();
        this.mActionBar.setCustomView(inflate);
        this.mActionBar.show();
        com.tencent.mm.ui.b bVar = this.mActionBarHelper;
        bVar.iiq.setText(R.l.eaj);
        if (com.tencent.mm.bv.a.ey(bVar.iiq.getContext())) {
            bVar.iiq.setTextSize(0, com.tencent.mm.bv.a.ew(bVar.iiq.getContext()) * ((float) com.tencent.mm.bv.a.ab(bVar.iiq.getContext(), com.tencent.mm.w.a.e.bum)));
        }
        this.mActionBarHelper.p(new OnClickListener(this) {
            final /* synthetic */ a lFm;

            {
                this.lFm = r1;
            }

            public final void onClick(View view) {
                if (this.lFm.isScreenEnable() && this.lFm.lFl != null) {
                    this.lFm.lFl.onMenuItemClick(null);
                }
            }
        });
        showOptionMenu(true);
        addIconOptionMenu(0, R.k.dvc, new 5(this));
        com.tencent.mm.sdk.b.a.xef.b(this.lAO);
        i.aBE().lwM.c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.lFj = true;
        this.lxL = aCj();
        this.lxL.luC = this;
        this.kgl = findViewById(R.h.empty);
        this.lAu = (TextView) this.kgl.findViewById(R.h.cef);
        this.lAy = getLayoutInflater().inflate(R.i.dfK, null);
        this.lAy.setVisibility(8);
        this.lAq = new EmojiStoreVpHeader(getContext());
        this.Fv = (ListView) findViewById(16908298);
        this.Fv.addHeaderView(this.lAq);
        if (!aDq()) {
            this.lFg = new EmojiStoreV2HotBarView(getContext());
            EmojiStoreV2HotBarView emojiStoreV2HotBarView = this.lFg;
            if (emojiStoreV2HotBarView.lFZ != null) {
                emojiStoreV2HotBarView.lFZ.setVisibility(8);
            }
            emojiStoreV2HotBarView = this.lFg;
            if (emojiStoreV2HotBarView.lFX != null) {
                int aa = com.tencent.mm.bv.a.aa(emojiStoreV2HotBarView.getContext(), R.f.bvy);
                int aa2 = com.tencent.mm.bv.a.aa(emojiStoreV2HotBarView.getContext(), R.f.bvB);
                int aa3 = com.tencent.mm.bv.a.aa(emojiStoreV2HotBarView.getContext(), R.f.bvJ);
                emojiStoreV2HotBarView.lFX.setPadding(aa3, aa, aa3, aa2);
            }
            this.Fv.addHeaderView(this.lFg);
        }
        this.Fv.addFooterView(this.lAy);
        this.Fv.setAdapter(this.lxL);
        if (aDq()) {
            this.Fv.setOnItemClickListener(this);
        } else {
            ((com.tencent.mm.plugin.emoji.a.h) this.lxL).lul = this;
        }
        this.Fv.setOnScrollListener(this);
        this.Fv.setLongClickable(false);
        this.Fv.setOnTouchListener(new 6(this));
        this.lxL.luA = this.Fv;
        this.lAt = (MMPullDownView) findViewById(R.h.cto);
        if (this.lAt != null) {
            this.lAt.mp(false);
            this.lAt.ycC = this;
            this.lAt.ycq = this;
            this.lAt.ycB = this;
            this.lAt.mo(false);
            this.lAt.mn(false);
            this.lAt.ycL = true;
        }
        if (this.lFh) {
            aDn();
        }
    }

    public void onStart() {
        super.onStart();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        ar.CG().a(411, (e) this);
        ar.CG().a(423, (e) this);
        if (this.lFh) {
            if (this.lFk != null) {
                this.lFk.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.lxL == null || this.lxL.luB == null)) {
                this.lxL.luB.aAK();
                this.lxL.amg();
            }
            ar.Hg();
            if (((Boolean) com.tencent.mm.z.c.CU().get(208900, Boolean.valueOf(false))).booleanValue()) {
                aBw();
                ar.Hg();
                com.tencent.mm.z.c.CU().set(208900, Boolean.valueOf(false));
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", Boolean.valueOf(z));
        super.setUserVisibleHint(z);
        this.lFh = z;
        if (!this.lFi && this.lFj) {
            aDn();
        }
    }

    public void onPause() {
        super.onPause();
        ar.CG().b(411, (e) this);
        ar.CG().b(423, (e) this);
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.lAq != null) {
            this.lAq.aDj();
        }
        if (this.lFk != null) {
            this.lFk.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.lxL != null) {
            this.lxL.clear();
            this.lxL = null;
        }
        if (this.lAq != null) {
            this.lAq.aDj();
            this.lAq.clear();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.lAO);
        i.aBE().lwM.j(this);
    }

    public void onDetach() {
        super.onDetach();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void aDn() {
        int i = 0;
        this.lFi = true;
        this.lAM = new h();
        this.lAM.kaK = thisActivity();
        this.lAM.lxN = this;
        this.lAM.lxL = this.lxL;
        if (aDq()) {
            this.lAM.lxO = 1;
        } else {
            this.lAM.lxO = 2;
        }
        this.lAM.lxR = this;
        this.lAK = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
        abz DA = i.aBE().lwO.DA(aCq());
        f a = n.a(DA);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aCq());
        objArr[1] = Integer.valueOf(DA == null ? 0 : DA.wkH);
        x.d(str, str2, objArr);
        if (a != null && a.lxC.size() > 0) {
            int size;
            int i2;
            int i3;
            this.lAQ = true;
            this.kgl.setVisibility(8);
            this.lAt.setVisibility(0);
            a(this.lAw, a);
            if (DA != null) {
                size = DA.wkT == null ? 0 : DA.wkT.size();
                i2 = DA.wkQ;
                int i4 = DA.wkR;
                i3 = i2;
                i2 = size;
                size = i4;
            } else {
                size = 0;
                i3 = 0;
                i2 = 0;
            }
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", Integer.valueOf(i3), Integer.valueOf(aCq()));
            if (this.lxL != null && aDq()) {
                this.lxL.oD(i3 + i2);
                this.lxL.oE(size);
            }
            aCp();
            i = 1;
        }
        if (i == 0 || this.lFk == null) {
            eB(true);
        } else {
            this.lFk.postDelayed(new Runnable(this) {
                final /* synthetic */ a lFm;

                {
                    this.lFm = r1;
                }

                public final void run() {
                    this.lFm.eB(false);
                }
            }, 3000);
        }
    }

    public final void eB(boolean z) {
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", Boolean.valueOf(z), Boolean.valueOf(aDp()));
        if (!z) {
            aDp();
        }
        ak(this.lAz);
        aDo();
    }

    private void ak(byte[] bArr) {
        int aCq = aCq();
        int i = this.lAK == 1 ? 1 : 2;
        if (bArr != null) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", bArr.toString());
            this.lAJ = new n(aCq, bArr, i);
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.lAJ = new n(aCq, i);
    }

    private void aDo() {
        ar.CG().a(this.lAJ, 0);
    }

    private static boolean aDp() {
        ar.Hg();
        ((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_STORE_LAST_REFRESH_TIME_LONG, Long.valueOf(0))).longValue();
        return true;
    }

    private void a(int i, f fVar) {
        Object obj = 1;
        Object obj2 = null;
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        int i2;
        switch (i) {
            case -1:
                this.lAL = fVar;
                i2 = 1;
                break;
            case 0:
                this.lAL = fVar;
                obj = null;
                break;
            case 1:
                this.lAL = fVar;
                i2 = 1;
                obj = null;
                break;
            case 2:
                if (this.lAL == null) {
                    this.lAL = new f();
                }
                this.lAL.oL(fVar.lxB);
                this.lAL.aA(fVar.lxC);
                i2 = 1;
                obj = null;
                break;
            default:
                obj = null;
                break;
        }
        if (this.lAL != null) {
            this.lAL.aBv();
        }
        if (this.lAL != null && r1 != null) {
            if (obj != null) {
                if (this.lAL == null) {
                    x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
                } else {
                    this.lAR = (LinkedList) this.lAL.lxE;
                    this.lAS = (LinkedList) this.lAL.lxF;
                    if (this.lAR != null) {
                        this.lAq.c(this.lAR, this.lAS);
                    } else if (this.lAL.lxD != null) {
                        this.lAR = new LinkedList();
                        this.lAR.add(this.lAL.lxD);
                        this.lAq.c(this.lAR, this.lAS);
                    }
                }
            }
            if (this.lxL != null) {
                this.lxL.b(this.lAL);
            }
        }
    }

    private void aCp() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.lxL.luB, (com.tencent.mm.pluginsdk.model.i.a) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
        switch (kVar.getType()) {
            case 411:
                n nVar = (n) kVar;
                if (nVar != null && nVar.mType == aCq()) {
                    int i3;
                    int i4;
                    int i5 = 0;
                    if (nVar == null || nVar.aBU() == null) {
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                    } else {
                        if (this.lxL.aAG() <= 0 && aDq()) {
                            if (nVar.aBU().wkT == null) {
                                i5 = 0;
                            } else {
                                i5 = nVar.aBU().wkT.size();
                            }
                            this.lxL.oF(i5);
                        }
                        i3 = nVar.aBU().wkQ;
                        i4 = i5;
                        i5 = nVar.aBU().wkR;
                    }
                    x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(nVar.mType));
                    if (this.lxL != null && this.lxL.aAF() <= 0 && aDq()) {
                        this.lxL.oD(i3 + this.lxL.aAG());
                        this.lxL.oE(i5);
                    }
                    this.lAx = false;
                    this.lAy.setVisibility(8);
                    Object obj = (i == 0 || i == 4) ? 1 : null;
                    if (obj != null) {
                        this.kgl.setVisibility(8);
                        this.lAt.setVisibility(0);
                        n nVar2 = (n) kVar;
                        f a = n.a(nVar2.aBU());
                        this.lAz = nVar2.lyZ;
                        abz aBU;
                        if (i2 == 0) {
                            aBU = nVar2.aBU();
                            a(this.lAw, a);
                            d(aBU);
                            this.lAw = 0;
                        } else if (i2 == 2) {
                            aBU = nVar2.aBU();
                            a(this.lAw, a);
                            aCp();
                            d(aBU);
                            this.lAw = 2;
                        } else if (i2 == 3) {
                            a(this.lAw, a);
                            this.lAw = 1;
                        } else {
                            this.kgl.setVisibility(0);
                            this.lAt.setVisibility(8);
                            this.lAu.setText(R.l.eax);
                        }
                    } else if (!this.lAQ) {
                        this.kgl.setVisibility(0);
                        this.lAt.setVisibility(8);
                        this.lAu.setText(R.l.eay);
                    }
                    if (aDq()) {
                        if (!(nVar.aBU() == null || nVar.aBU().wkT == null || nVar.aBU().wkT.size() <= 0)) {
                            for (i3 = 0; i3 < nVar.aBU().wkT.size(); i3++) {
                                com.tencent.mm.plugin.report.service.g.pQN.h(13223, Integer.valueOf(0), Integer.valueOf(((sf) nVar.aBU().wkT.get(i3)).fgt), ((sf) nVar.aBU().wkT.get(i3)).fon, Integer.valueOf(0));
                            }
                        }
                        if (nVar.aBU().wkR > 0 && nVar.aBU().wkI != null && nVar.aBU().wkI.size() > nVar.aBU().wkQ + nVar.aBU().wkR) {
                            for (i3 = 0; i3 < nVar.aBU().wkR; i3++) {
                                com.tencent.mm.plugin.report.service.g.pQN.h(13223, Integer.valueOf(0), ((so) nVar.aBU().wkI.get(nVar.aBU().wkQ + i3)).vIR, ((so) nVar.aBU().wkI.get(nVar.aBU().wkQ + i3)).war, Integer.valueOf(1));
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                x.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean azk() {
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        eC(true);
        return true;
    }

    public final boolean azl() {
        return false;
    }

    public final boolean azm() {
        return false;
    }

    private void d(abz com_tencent_mm_protocal_c_abz) {
        if (this.lAw == -1) {
            ar.Dm().F(new 8(this, com_tencent_mm_protocal_c_abz));
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar.aAu() == 9) {
            yG(getString(R.l.dGS));
        }
        if (!aDq()) {
            this.lAM.lxO = 2;
        } else if (aVar.mPosition >= 0 && aVar.mPosition < this.lxL.aAE()) {
            this.lAM.lxO = 3;
        } else if (aVar.mPosition < this.lxL.aAE() || aVar.mPosition >= this.lxL.aAF() + this.lxL.aAE()) {
            this.lAM.lxO = 1;
        } else {
            this.lAM.lxO = 19;
        }
        this.lAM.a(aVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.Fv.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.lxL.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.lxL.oG(headerViewsCount);
            a(oG, headerViewsCount);
            if (aDq() && this.lxL.aAF() > 0 && headerViewsCount >= this.lxL.aAE() && headerViewsCount < this.lxL.aAE() + this.lxL.aAF() && oG.luN != null) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13223, Integer.valueOf(1), oG.luN.vIR, oG.luN.war, Integer.valueOf(1), Integer.valueOf(0));
            }
        }
    }

    public final void mv(int i) {
        if (i >= 0 && i < ((com.tencent.mm.plugin.emoji.a.h) this.lxL).aAI()) {
            a(this.lxL.oG(i), i);
        }
    }

    private void a(com.tencent.mm.plugin.emoji.a.a.f fVar, int i) {
        if (fVar == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.luM == com.tencent.mm.plugin.emoji.a.a.f.a.luV) {
            sf sfVar = fVar.luO;
            if (sfVar == null) {
                x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                m.a(getContext(), sfVar, false);
            }
        } else {
            so soVar = fVar.luN;
            if (soVar == null) {
                x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            int i2;
            if (!aDq()) {
                i2 = 2;
            } else if (i >= 0 && i < this.lxL.aAE()) {
                i2 = 3;
            } else if (i < this.lxL.aAE() || i >= this.lxL.aAF() + this.lxL.aAE()) {
                i2 = 1;
            } else {
                i2 = 19;
            }
            m.a(getContext(), soVar, i2, fVar.mStatus, fVar.sm, thisActivity().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.lAw == 0 || this.lAx) {
            x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        eC(true);
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.lAM != null) {
            this.lAM.onActivityResult(i, i2, intent);
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    public final void I(String str, String str2, String str3) {
        this.lAP = new g(str, str2, str3);
        ar.CG().a(this.lAP, 0);
    }

    public final void aBw() {
        this.lAz = null;
        this.lAw = -1;
        eC(false);
    }

    private void eC(boolean z) {
        if (this.lAx) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.lAx = true;
        if (z) {
            this.lAy.setVisibility(0);
        }
        ak(this.lAz);
        aDo();
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            yG(getString(R.l.dHc));
        }
    }

    public final void m(Message message) {
        if (this.lFk != null) {
            this.lFk.sendMessage(message);
        }
    }

    private void yG(String str) {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        Context thisActivity = thisActivity();
        getString(R.l.dGO);
        this.ltM = com.tencent.mm.ui.base.h.a(thisActivity, str, true, new 9(this));
    }

    protected static void aCt() {
    }

    public final void u(ArrayList<q> arrayList) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.lxL != null) {
            if (this.lFk != null) {
                this.lFk.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.lxL.luB);
        }
    }

    public final void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.lFk != null) {
            this.lFk.sendEmptyMessageDelayed(131074, 50);
        }
    }

    protected int getForceOrientation() {
        return 1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lAq != null) {
            this.lAq.requestLayout();
        }
        setRequestedOrientation(1);
    }
}
