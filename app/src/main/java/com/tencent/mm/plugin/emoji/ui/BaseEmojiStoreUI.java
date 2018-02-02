package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.model.i$a;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView$e;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, e, a, com.tencent.mm.plugin.emoji.model.h.b, i$a, j.a, c, d, MMPullDownView$e {
    private static Map<String, Long> lAN;
    protected ListView Fv;
    protected View kgl;
    private final int lAA = 65537;
    private final int lAB = CdnLogic.kMediaTypeBackupFile;
    private final int lAC = 2002;
    protected final int lAD = 131074;
    private final int lAE = 131075;
    private final int lAF = 131076;
    private final String lAG = "product_id";
    private final String lAH = "progress";
    private final String lAI = DownloadInfo.STATUS;
    private n lAJ;
    private int lAK;
    private f lAL;
    private h lAM;
    private com.tencent.mm.sdk.b.c lAO;
    protected g lAP;
    protected boolean lAQ = false;
    private LinkedList<sd> lAR = new LinkedList();
    private LinkedList<sf> lAS = new LinkedList();
    protected EmojiStoreVpHeader lAq;
    protected View lAr;
    protected StoreBannerEmojiView lAs;
    protected MMPullDownView lAt;
    protected TextView lAu;
    protected boolean lAv = false;
    int lAw = -1;
    private boolean lAx;
    private View lAy;
    byte[] lAz;
    private ProgressDialog ltM;
    com.tencent.mm.plugin.emoji.a.a.a lxL;
    private com.tencent.mm.plugin.emoji.h.b lxT;

    private class b implements OnMenuItemClickListener {
        final /* synthetic */ BaseEmojiStoreUI lAV;

        private b(BaseEmojiStoreUI baseEmojiStoreUI) {
            this.lAV = baseEmojiStoreUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.lAV.finish();
            return true;
        }
    }

    public abstract int aCh();

    public abstract int aCi();

    public abstract com.tencent.mm.plugin.emoji.a.a.a aCj();

    public abstract int aCq();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lAM = new h();
        initView();
        this.lAK = getIntent().getIntExtra("preceding_scence", 2);
        if (i.aBE().lwM != null) {
            i.aBE().lwM.c(this);
        }
        this.lAO = new a(this, (byte) 0);
        com.tencent.mm.sdk.b.a.xef.b(this.lAO);
        this.lAM.kaK = this;
        this.lAM.lxL = this.lxL;
        this.lAM.lxO = aCh();
        this.lAM.lxR = this;
        boolean aCy = aCy();
        if (aCy) {
            aCy = aCv();
        }
        s(false, aCy);
        if (lAN == null) {
            lAN = new HashMap();
        }
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        lAN.put(getClass().toString(), Long.valueOf(r0));
        this.lxT = new com.tencent.mm.plugin.emoji.h.b(1005);
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(411, this);
        ar.CG().a(423, this);
        ar.CG().a(413, this);
        ar.CG().a(717, this);
        if (aCn() && this.lAq != null) {
            this.lAq.aDi();
        }
        Boolean.valueOf(false);
        this.lAM.lxM = false;
        if (this.lxL != null && this.lxL.luB != null) {
            this.lxL.luB.aAK();
            this.lxL.amg();
        }
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(411, this);
        ar.CG().b(423, this);
        ar.CG().b(413, this);
        ar.CG().b(717, this);
        aCt();
        if (aCn() && this.lAq != null) {
            this.lAq.aDj();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lxL != null) {
            this.lxL.clear();
            this.lxL = null;
        }
        if (aCn() && this.lAq != null) {
            this.lAq.clear();
        }
        i.aBE().lwM.j(this);
        com.tencent.mm.sdk.b.a.xef.c(this.lAO);
        ar.CG().c(this.lAP);
        if (this.lAM != null) {
            h hVar = this.lAM;
            hVar.lxL = null;
            hVar.lxR = null;
            hVar.kaK = null;
        }
    }

    protected int getLayoutId() {
        return R.i.dfL;
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3 = -1;
        String str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str3 = "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        aCx();
        switch (kVar.getType()) {
            case 411:
                n nVar = (n) kVar;
                if (nVar == null || nVar.mType != aCq()) {
                    str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                    str3 = "no some scene type. this ui type:%d callbak type:%d";
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aCq());
                    if (nVar != null) {
                        i3 = nVar.mType;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    return;
                }
                this.lAx = false;
                this.lAy.setVisibility(8);
                f fVar = null;
                try {
                    fVar = n.a(nVar.aBU());
                } catch (Exception e) {
                    x.k("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[]{e.toString()});
                }
                if (fVar != null) {
                    boolean z = i == 0 || i == 4;
                    if (z) {
                        this.kgl.setVisibility(8);
                        this.lAv = false;
                        this.lAz = nVar.lyZ;
                        abz aBU;
                        if (i2 == 0) {
                            aBU = nVar.aBU();
                            a(fVar, false, true);
                            b(aBU);
                            this.lAw = 0;
                            return;
                        } else if (i2 == 2) {
                            aBU = nVar.aBU();
                            a(this.lAw, fVar, false, false);
                            aCp();
                            b(aBU);
                            this.lAw = 2;
                            return;
                        } else if (i2 == 3) {
                            a(this.lAw, fVar, false, false);
                            this.lAw = 1;
                            return;
                        } else {
                            this.kgl.setVisibility(0);
                            this.lAv = true;
                            if (aCq() == 7) {
                                this.lAu.setText(R.l.eaZ);
                                return;
                            } else {
                                this.lAu.setText(R.l.eax);
                                return;
                            }
                        }
                    }
                }
                if (!this.lAQ) {
                    this.kgl.setVisibility(0);
                    this.lAv = true;
                    this.lAu.setText(R.l.eay);
                    return;
                }
                return;
            case 413:
                q qVar = (q) kVar;
                Message message;
                if (i == 0 && i2 == 0) {
                    i.aBE().lwM.XQ(qVar.lyH);
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.xIM.getString(R.l.dGR);
                    m(message);
                } else {
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.xIM.getString(R.l.dZM);
                    m(message);
                }
                cp(CdnLogic.kMediaTypeBackupFile, 800);
                return;
            case 423:
                g gVar = (g) kVar;
                if (i == 0 && i2 == 0) {
                    a(gVar);
                    return;
                }
                str2 = gVar.lyH;
                str3 = gVar.lyJ;
                final String str4 = gVar.lyI;
                com.tencent.mm.ui.base.h.a(this, getString(R.l.eat, new Object[]{str4}), "", new OnClickListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI lAV;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.lAV.J(str2, str3, str4);
                        this.lAV.aCu();
                        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        this.lAV.bd(str2, 0);
                    }
                }, new 2(this));
                bc(gVar.lyH, -1);
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.lAz = null;
                    s(false, true);
                    return;
                }
                return;
            default:
                x.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (aCn() || aCo()) {
            if (i != 0) {
                i--;
            } else {
                return;
            }
        }
        if (i >= 0 && i < this.lxL.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.lxL.oG(i);
            if (oG == null) {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (oG.luM == com.tencent.mm.plugin.emoji.a.a.f.a.luV) {
                sf sfVar = oG.luO;
                if (sfVar == null) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    m.a(this.mController.xIM, sfVar, false);
                }
            } else {
                so soVar = oG.luN;
                if (soVar == null) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                m.a(this.mController.xIM, soVar, aCh(), oG.mStatus, oG.sm, getIntent().getStringExtra("to_talker_name"), aCi());
            }
        }
    }

    protected void aCg() {
        this.lxL = aCj();
        this.lxL.luC = this;
    }

    protected void yD(String str) {
    }

    protected void aCk() {
    }

    protected void aCl() {
        if (aCm()) {
            this.lAt = (MMPullDownView) findViewById(R.h.cto);
            if (this.lAt != null) {
                this.lAt.mp(false);
                this.lAt.ycC = this;
                this.lAt.ycq = this;
                this.lAt.ycB = this;
                this.lAt.mo(false);
                this.lAt.mn(false);
            }
        }
    }

    protected boolean aCm() {
        return true;
    }

    public void initView() {
        setBackBtn(new b());
        aCg();
        this.kgl = findViewById(R.h.empty);
        this.lAu = (TextView) this.kgl.findViewById(R.h.cef);
        this.lAy = getLayoutInflater().inflate(R.i.dfK, null);
        this.lAy.setVisibility(8);
        if (aCn()) {
            this.lAq = new EmojiStoreVpHeader(this.mController.xIM);
        }
        if (aCo()) {
            this.lAr = LayoutInflater.from(this).inflate(R.i.dgi, null);
            int i = EmojiStoreVpHeader.aT(this.mController.xIM)[0];
            this.lAr.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.lAs = (StoreBannerEmojiView) this.lAr.findViewById(R.h.cdn);
        }
        this.Fv = (ListView) findViewById(16908298);
        this.Fv.setOnItemClickListener(this);
        if (aCn()) {
            this.Fv.addHeaderView(this.lAq);
        } else if (aCo()) {
            this.Fv.addHeaderView(this.lAr);
        }
        if (aCz()) {
            this.Fv.addFooterView(this.lAy);
        }
        aCk();
        this.Fv.setAdapter(this.lxL);
        this.Fv.setOnScrollListener(this);
        this.lxL.luA = this.Fv;
        aCl();
    }

    protected final void s(boolean z, boolean z2) {
        n nVar;
        this.lAx = true;
        if (z) {
            this.lAy.setVisibility(0);
        }
        Object obj = this.lAz;
        int aCq = aCq();
        int aCs = aCs();
        int aCr = aCr();
        if (obj != null) {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[]{obj.toString()});
            nVar = new n(aCq, obj, aCs);
            if (aCq == 7) {
                nVar.lzb = aCr;
            }
        } else {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            nVar = new n(aCq, aCs);
            if (aCq == 7) {
                nVar.lzb = aCr;
            }
        }
        this.lAJ = nVar;
        ar.CG().a(this.lAJ, 0);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            aCw();
        }
    }

    public final boolean azk() {
        s(true, false);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    public final void k(Message message) {
        switch (message.what) {
            case 2002:
                String str = (String) message.obj;
                if (isFinishing()) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.ltM != null) {
                    this.ltM.setMessage(str);
                    return;
                } else {
                    return;
                }
            case CdnLogic.kMediaTypeBackupFile /*20001*/:
                aCx();
                return;
            case 65537:
                c((abz) message.obj);
                return;
            default:
                return;
        }
    }

    public void l(Message message) {
        String string;
        switch (message.what) {
            case 131074:
                if (this.lxL != null) {
                    this.lxL.notifyDataSetChanged();
                    aCA();
                    return;
                }
                return;
            case 131075:
                if (this.lxL != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.lxL.bd(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.lxL != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.lxL.bc(string, message.getData().getInt(DownloadInfo.STATUS));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean aCn() {
        return true;
    }

    protected boolean aCo() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.lAw == 0 || this.lAx) {
            x.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        s(true, false);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void aCp() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.lxL.luB, this);
    }

    protected void a(g gVar) {
        bd(gVar.lyH, 0);
    }

    private void bd(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        m(obtain);
    }

    private void bc(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt(DownloadInfo.STATUS, i);
        obtain.what = 131076;
        m(obtain);
    }

    protected final g J(String str, String str2, String str3) {
        this.lAP = new g(str, str2, str3);
        return this.lAP;
    }

    public int aCr() {
        return 0;
    }

    protected int aCs() {
        if (this.lAK == 1) {
            return 1;
        }
        return 2;
    }

    protected final void aCt() {
        ar.CG().c(this.lAJ);
    }

    protected final void aCu() {
        ar.CG().a(this.lAP, 0);
    }

    protected boolean aCv() {
        abz DA = i.aBE().lwO.DA(aCq());
        f a = n.a(DA);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aCq());
        objArr[1] = Integer.valueOf(DA == null ? 0 : DA.wkH);
        x.d(str, str2, objArr);
        if (a == null) {
            return false;
        }
        boolean z;
        if (a.lxC.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[]{Integer.valueOf(a.lxC.size())});
            a(a, true, false);
            return z;
        }
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    protected final void aCw() {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.dGO);
        this.ltM = com.tencent.mm.ui.base.h.a(this, getString(R.l.dHc), true, new 3(this));
    }

    protected final void aCx() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }

    protected void a(f fVar, boolean z, boolean z2) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (fVar != null && fVar.lxC.size() > 0) {
            this.lAQ = true;
            this.kgl.setVisibility(8);
            this.lAv = false;
        }
        a(this.lAw, fVar, z, z2);
        aCp();
    }

    private void a(int i, f fVar, boolean z, boolean z2) {
        boolean z3 = false;
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.lAL = fVar;
                break;
            case 1:
                this.lAL = fVar;
                break;
            case 2:
                if (this.lAL == null) {
                    this.lAL = new f();
                }
                if (fVar != null) {
                    this.lAL.oL(fVar.lxB);
                    this.lAL.aA(fVar.lxC);
                    break;
                }
                break;
            default:
                if (this.lAL != null) {
                    this.lAL.aBv();
                }
                a(z3, this.lAL, z, z2);
        }
        z3 = true;
        if (this.lAL != null) {
            this.lAL.aBv();
        }
        a(z3, this.lAL, z, z2);
    }

    protected void a(boolean z, f fVar, boolean z2, boolean z3) {
        if (this.lAL != null && z) {
            if (aCn()) {
                if (this.lAL == null || this.lAL.lxD == null || this.lAL.lxD.waf == null) {
                    x.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
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

    private void b(abz com_tencent_mm_protocal_c_abz) {
        if (this.lAw == -1) {
            Message obtain = Message.obtain();
            obtain.what = 65537;
            obtain.obj = com_tencent_mm_protocal_c_abz;
            if (this.lBv != null) {
                this.lBv.sendMessage(obtain);
            }
        }
    }

    protected void c(abz com_tencent_mm_protocal_c_abz) {
        int i = 0;
        if (com_tencent_mm_protocal_c_abz != null) {
            String str = "MicroMsg.emoji.BaseEmojiStoreUI";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_abz == null ? 0 : com_tencent_mm_protocal_c_abz.wkH);
            if (!(com_tencent_mm_protocal_c_abz == null || com_tencent_mm_protocal_c_abz.vHG == null)) {
                i = com_tencent_mm_protocal_c_abz.vHG.bke();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(aCq());
            x.d(str, str2, objArr);
            i.aBE().lwO.a(aCq(), com_tencent_mm_protocal_c_abz);
        }
    }

    public final boolean azl() {
        return false;
    }

    public final boolean azm() {
        return false;
    }

    public void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            aCI();
            cp(131074, 50);
        }
    }

    public void g(String str, int i, int i2, String str2) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (this.lxL != null && this.lxL.luB != null) {
            if (i == 6) {
                bd(str, i2);
            } else {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                bc(str, i);
            }
            com.tencent.mm.plugin.emoji.a.a.f xU = this.lxL.luB.xU(str);
            if (xU != null) {
                xU.luQ = str2;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aAt();
        objArr[1] = TextUtils.isEmpty(aVar.aAv()) ? "" : aVar.aAv();
        objArr[2] = Integer.valueOf(aVar.aAu());
        x.i(str, str2, objArr);
        if (aVar.aAu() == 9) {
            String string = getString(R.l.dGS);
            if (isFinishing()) {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(R.l.dGO);
                this.ltM = com.tencent.mm.ui.base.h.a(this, string, true, new OnCancelListener(this) {
                    final /* synthetic */ BaseEmojiStoreUI lAV;

                    {
                        this.lAV = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ar.CG().cancel(413);
                    }
                });
            }
        }
        this.lAM.a(aVar);
    }

    protected boolean aCy() {
        return false;
    }

    public final void u(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.lxL != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a(arrayList, this.lxL.luB);
            if (this.lBw != null) {
                this.lBw.removeMessages(131074);
                this.lBw.sendEmptyMessage(131074);
            }
        }
    }

    public final void I(String str, String str2, String str3) {
        J(str, str2, str3);
        aCu();
    }

    public final void aBw() {
        this.lAz = null;
        this.lAw = -1;
        s(false, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.lAM.onActivityResult(i, i2, intent);
    }

    protected boolean aCz() {
        return true;
    }

    public void aCA() {
    }
}
