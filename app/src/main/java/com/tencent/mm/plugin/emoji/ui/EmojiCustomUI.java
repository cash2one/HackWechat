package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.aq.a.c.d;
import com.tencent.mm.aq.a.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EmojiCustomUI extends MMActivity implements OnItemClickListener, e {
    private l hEq = new 16(this);
    private HeaderGridView lBA;
    private View lBB;
    private Button lBC;
    private Button lBD;
    private a lBE = a.lzr;
    private View lBF;
    private TextView lBG;
    private Button lBH;
    private boolean lBI = false;
    private boolean lBJ = false;
    private boolean lBK = false;
    private a lBL = a.lCb;
    private ArrayList<String> lBM = new ArrayList();
    private OnClickListener lBN = new 1(this);
    private OnClickListener lBO = new 11(this);
    private OnClickListener lBP = new 12(this);
    private final j.a lBQ = new j.a(this) {
        final /* synthetic */ EmojiCustomUI lBU;

        {
            this.lBU = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (!bh.ov(str)) {
                if ((str.length() == 32 || str.equals("event_update_emoji")) && this.lBU.lBz != null) {
                    this.lBU.lBz.aCR();
                    this.lBU.lBz.notifyDataSetChanged();
                }
            }
        }
    };
    private final c lBR = new 14(this);
    private d lBS = new d(this) {
        final /* synthetic */ EmojiCustomUI lBU;

        {
            this.lBU = r1;
        }

        public final byte[] f(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof EmojiInfo)) {
                    return com.tencent.mm.plugin.emoji.e.e.aAR().a((EmojiInfo) obj);
                }
            }
            return null;
        }
    };
    private EmojiInfo lBT;
    private int lBy = c.lCf;
    private b lBz;
    private ProgressDialog ltM;
    private af mHandler = new 17(this);

    static /* synthetic */ void d(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "topCustom mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.lBM == null ? 0 : emojiCustomUI.lBM.size());
        x.i(str, str2, objArr);
        if (emojiCustomUI.lBM == null || emojiCustomUI.lBM.size() <= 0) {
            x.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.yG(emojiCustomUI.getString(R.l.ebv));
        ArrayList arrayList = emojiCustomUI.lBM;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "topSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.c(3, emojiCustomUI.lBM), 0);
        }
    }

    static /* synthetic */ void g(EmojiCustomUI emojiCustomUI) {
        x.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", new Object[]{emojiCustomUI.lBE.toString()});
        if (emojiCustomUI.lBy != c.lCg && !emojiCustomUI.lBJ) {
            switch (10.lBX[emojiCustomUI.lBE.ordinal()]) {
                case 1:
                    emojiCustomUI.lBK = false;
                    emojiCustomUI.enableOptionMenu(0, true);
                    emojiCustomUI.aCM();
                    emojiCustomUI.oN(c.lCf);
                    return;
                case 2:
                    emojiCustomUI.enableOptionMenu(0, false);
                    i.aBB();
                    if (BKGLoaderManager.aAP()) {
                        emojiCustomUI.lBK = false;
                        emojiCustomUI.lBF.setVisibility(0);
                        emojiCustomUI.a(a.lCa);
                        emojiCustomUI.ev(true);
                    } else {
                        i.aBB();
                        if (BKGLoaderManager.aCc() && !emojiCustomUI.lBK) {
                            emojiCustomUI.lBK = true;
                            emojiCustomUI.aCM();
                            emojiCustomUI.a(a.lCb);
                        }
                    }
                    if (emojiCustomUI.lBy != c.lCh) {
                        emojiCustomUI.oN(c.lCh);
                        return;
                    }
                    return;
                case 3:
                    emojiCustomUI.lBK = false;
                    emojiCustomUI.enableOptionMenu(0, false);
                    if (emojiCustomUI.mHandler != null) {
                        emojiCustomUI.mHandler.removeMessages(1003);
                    }
                    emojiCustomUI.lBF.setVisibility(0);
                    emojiCustomUI.ev(false);
                    emojiCustomUI.a(a.lBZ);
                    emojiCustomUI.oN(c.lCi);
                    return;
                case 4:
                    emojiCustomUI.lBK = false;
                    emojiCustomUI.enableOptionMenu(0, false);
                    emojiCustomUI.aCM();
                    emojiCustomUI.oN(c.lCi);
                    return;
                case 5:
                    emojiCustomUI.lBK = false;
                    emojiCustomUI.enableOptionMenu(0, true);
                    emojiCustomUI.lBF.setVisibility(0);
                    int ckG = i.aBE().lwL.ckG();
                    int i = i.aBB().lzq.lzB;
                    emojiCustomUI.lBG.setText(R.l.ebm);
                    emojiCustomUI.lBG.setText(String.format(emojiCustomUI.getString(R.l.ebm), new Object[]{Integer.valueOf(i - ckG), Integer.valueOf(i)}));
                    emojiCustomUI.lBH.setVisibility(4);
                    emojiCustomUI.oN(c.lCi);
                    return;
                case 6:
                    emojiCustomUI.lBK = false;
                    emojiCustomUI.enableOptionMenu(0, true);
                    emojiCustomUI.aCM();
                    emojiCustomUI.oN(c.lCf);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void j(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "deleteEmoji mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.lBM == null ? 0 : emojiCustomUI.lBM.size());
        x.i(str, str2, objArr);
        if (emojiCustomUI.lBM == null || emojiCustomUI.lBM.size() <= 0) {
            x.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.yG(emojiCustomUI.getString(R.l.dZN));
        ArrayList arrayList = emojiCustomUI.lBM;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "deleteSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.c(2, emojiCustomUI.lBM), 0);
        }
        x.i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", new Object[]{Boolean.valueOf(emojiCustomUI.lBI)});
        if (emojiCustomUI.lBI) {
            emojiCustomUI.lBI = false;
            ar.Hg();
            com.tencent.mm.z.c.CU().set(348162, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.aAM();
        }
        emojiCustomUI.aCN();
    }

    private void a(a aVar) {
        x.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[]{aVar.toString()});
        this.lBL = aVar;
        switch (10.lBW[aVar.ordinal()]) {
            case 1:
                this.lBH.setVisibility(4);
                return;
            case 2:
                this.lBH.setVisibility(0);
                this.lBH.setText(R.l.ebn);
                return;
            case 3:
                this.lBH.setVisibility(0);
                this.lBH.setText(R.l.ebo);
                return;
            default:
                return;
        }
    }

    private void ev(boolean z) {
        int ckG = i.aBE().lwL.ckG();
        int i = i.aBB().lzq.lzB;
        if (ckG != i || z) {
            int i2;
            if (i == 0) {
                i2 = ckG;
            } else {
                i2 = 0;
            }
            i += i2;
            this.lBG.setText(String.format(getString(z ? R.l.ebs : R.l.ebl), new Object[]{Integer.valueOf(i - ckG), Integer.valueOf(i)}));
            return;
        }
        this.lBG.setText(R.l.ebq);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.lBz = new b(this);
        this.lBz.aCR();
        initView();
        i.aBB().eu(true);
        oN(c.lCf);
        ar.Hg();
        x.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.z.c.CU().get(w.a.xno, Boolean.valueOf(true))).booleanValue())});
        if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.xno, Boolean.valueOf(true))).booleanValue()) {
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.e(), 0);
        }
        i.aBE().lwL.c(this.lBQ);
        g.pQN.a(406, 9, 1, false);
        g.pQN.a(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.emoji.sync.a aBB = i.aBB();
        c cVar = this.lBR;
        BKGLoaderManager bKGLoaderManager = aBB.lzq;
        if (bKGLoaderManager.lzQ == null) {
            bKGLoaderManager.lzQ = new HashSet();
        }
        if (!bKGLoaderManager.lzQ.contains(cVar)) {
            bKGLoaderManager.lzQ.add(cVar);
        }
        aCN();
        ar.CG().a(698, this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.emoji.sync.a aBB = i.aBB();
        c cVar = this.lBR;
        BKGLoaderManager bKGLoaderManager = aBB.lzq;
        if (bKGLoaderManager.lzQ == null) {
            bKGLoaderManager.lzQ = new HashSet();
        }
        if (bKGLoaderManager.lzQ.contains(cVar)) {
            bKGLoaderManager.lzQ.remove(cVar);
        }
        ar.CG().b(698, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        i.aBE().lwL.j(this.lBQ);
        i.aBB().eu(false);
        BKGLoaderManager bKGLoaderManager = i.aBB().lzq;
        if (bKGLoaderManager.lzH) {
            bKGLoaderManager.lzH = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dfB;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        this.lBF = getLayoutInflater().inflate(R.i.dfD, null);
        this.lBG = (TextView) this.lBF.findViewById(R.h.cPY);
        this.lBH = (Button) this.lBF.findViewById(R.h.cPX);
        this.lBH.setOnClickListener(this.lBN);
        this.lBA = (HeaderGridView) findViewById(R.h.cMk);
        HeaderGridView headerGridView = this.lBA;
        View view = this.lBF;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof HeaderGridView$c)) {
            HeaderGridView.a aVar = new HeaderGridView.a((byte) 0);
            ViewGroup bVar = new b(headerGridView, headerGridView.getContext());
            bVar.addView(view);
            aVar.view = view;
            aVar.xXP = bVar;
            aVar.data = null;
            aVar.isSelectable = false;
            headerGridView.xXO.add(aVar);
            if (adapter != null) {
                ((HeaderGridView$c) adapter).mDataSetObservable.notifyChanged();
            }
            this.lBA.a(this.lBz);
            this.lBA.setOnItemClickListener(this);
            this.lBA.setFocusableInTouchMode(false);
            this.lBB = findViewById(R.h.cMj);
            this.lBC = (Button) findViewById(R.h.cMl);
            this.lBC.setOnClickListener(this.lBO);
            this.lBD = (Button) findViewById(R.h.cMm);
            this.lBD.setOnClickListener(this.lBP);
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.lBz != null) {
            int size = i - (this.lBA.xXO.size() * 5);
            if (this.lBy == c.lCf && size == this.lBz.aCQ()) {
                ar.Hg();
                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                    if (this.lBz.aCQ() >= n.aBn()) {
                        h.a(this, getString(R.l.eby), "", new 18(this));
                    } else {
                        k.Q(this);
                    }
                    g.pQN.h(11596, new Object[]{Integer.valueOf(0)});
                } else {
                    u.fI(this);
                    return;
                }
            }
            if (this.lBy == c.lCg && size < this.lBz.aCQ()) {
                EmojiInfo oO = this.lBz.oO(size);
                d dVar = null;
                if (view != null) {
                    dVar = (d) view.getTag();
                }
                if (oO.field_catalog == EmojiGroupInfo.xAc) {
                    h.h(this.mController.xIM, R.l.dQH, R.l.dQH).show();
                } else if (this.lBM.contains(oO.Nr())) {
                    r2 = oO.Nr();
                    if (this.lBM != null) {
                        this.lBM.remove(r2);
                    }
                    if (dVar != null) {
                        dVar.lCm.setChecked(false);
                        this.lBz.notifyDataSetChanged();
                    }
                    x.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[]{oO.Nr()});
                } else {
                    r2 = oO.Nr();
                    if (this.lBM != null) {
                        this.lBM.add(r2);
                    }
                    if (dVar != null) {
                        dVar.lCm.setChecked(true);
                    }
                    x.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[]{oO.Nr()});
                }
                aCL();
                if (dVar == null) {
                    this.lBz.notifyDataSetChanged();
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX /*205*/:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 3);
                        ar.Hg();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.z.c.Fp());
                        com.tencent.mm.plugin.emoji.b.ifs.a(intent2, com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, this, intent);
                        return;
                    }
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX /*206*/:
                    if (intent == null) {
                        x.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    final int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra != null && stringExtra.length() > 0) {
                        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                        StringBuilder stringBuilder = new StringBuilder();
                        ar.Hg();
                        String stringBuilder2 = stringBuilder.append(com.tencent.mm.z.c.Fp()).append(stringExtra).toString();
                        this.lBT = i.aBE().lwL.XU(stringExtra);
                        com.tencent.mm.ui.tools.a.b aac = com.tencent.mm.ui.tools.a.b.aac(stringBuilder2);
                        aac.hX = com.tencent.mm.k.b.zD();
                        aac.GM(com.tencent.mm.k.b.zE()).a(new com.tencent.mm.ui.tools.a.b.a(this) {
                            final /* synthetic */ EmojiCustomUI lBU;

                            public final void a(com.tencent.mm.ui.tools.a.b bVar) {
                                if (this.lBU.lBT == null) {
                                    if (intExtra == 0) {
                                        this.lBU.lBT = i.aBE().lwL.c(stringExtra, "", EmojiGroupInfo.xAe, EmojiInfo.xAl, bVar.znI, "");
                                    } else {
                                        this.lBU.lBT = i.aBE().lwL.c(stringExtra, "", EmojiGroupInfo.xAe, EmojiInfo.xAm, bVar.znI, "");
                                    }
                                }
                                i.aBA().a(this.lBU.mController.xIM, this.lBU.lBT, 1, q.FS());
                                if (this.lBU.lBz != null) {
                                    this.lBU.lBz.aCR();
                                    this.lBU.lBz.notifyDataSetChanged();
                                }
                            }

                            public final void aCH() {
                                h.a(this.lBU.mController.xIM, this.lBU.mController.xIM.getString(R.l.dZI), "", this.lBU.mController.xIM.getString(R.l.epk), false, null);
                            }
                        });
                        return;
                    }
                    return;
                case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                    if (this.lBz != null) {
                        this.lBz.aCR();
                        this.lBz.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    x.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    public void onBackPressed() {
        if (this.lBy == c.lCg) {
            oN(c.lCf);
        } else {
            super.onBackPressed();
        }
    }

    private void oN(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lBy = i;
        switch (10.lBY[i - 1]) {
            case 1:
                setBackBtn(new 3(this));
                enableBackMenu(true);
                addTextOptionMenu(0, getString(R.l.eaq), new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI lBU;

                    {
                        this.lBU = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.lBU.oN(c.lCg);
                        g.pQN.h(11596, new Object[]{Integer.valueOf(1)});
                        return true;
                    }
                });
                this.lBB.setVisibility(8);
                aCN();
                aCJ();
                break;
            case 2:
                setBackBtn(new 5(this));
                addTextOptionMenu(0, getString(R.l.dFl), new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI lBU;

                    {
                        this.lBU = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.lBU.oN(c.lCf);
                        return true;
                    }
                });
                this.lBB.setVisibility(0);
                aCM();
                aCL();
                break;
            case 3:
                aCK();
                break;
            case 4:
                break;
        }
        aCK();
        if (this.lBz != null) {
            this.lBz.aCR();
            this.lBz.notifyDataSetChanged();
        }
        x.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void aCJ() {
        if (this.lBM != null) {
            this.lBM.clear();
        }
        x.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    }

    private void aCK() {
        this.lBB.setVisibility(this.lBy == c.lCg ? 0 : 8);
    }

    private void aCL() {
        if (this.lBy == c.lCg) {
            if ((this.lBM == null ? 0 : this.lBM.size()) > 0) {
                this.lBC.setText(getResources().getString(R.l.dEw));
                this.lBC.setEnabled(true);
                this.lBD.setEnabled(true);
            } else {
                this.lBC.setText(getResources().getString(R.l.dEw));
                this.lBC.setEnabled(false);
                this.lBD.setEnabled(false);
            }
            setMMTitle(getResources().getString(R.l.eae, new Object[]{Integer.valueOf(r0)}));
        }
    }

    private boolean yF(String str) {
        String str2 = str;
        h.a(this.mController.xIM, str2, "", "", getString(R.l.epk), null, null);
        return true;
    }

    private void aCM() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1003, 0);
        }
    }

    private void aCN() {
        boolean z = true;
        i.aBB();
        if (an.isConnected(ac.getContext())) {
            if (this.lBz == null || this.lBz.aCQ() <= n.aBn()) {
                z = false;
            } else {
                this.lBI = true;
                this.lBF.setVisibility(0);
                int i = R.l.ebk;
                this.lBG.setTextColor(getResources().getColor(R.e.btB));
                this.lBG.setText(getString(i, new Object[]{Integer.valueOf(n.aBn())}));
                this.lBH.setVisibility(8);
                this.lBz.notifyDataSetChanged();
                enableOptionMenu(0, true);
                this.lBJ = true;
            }
            if (!z) {
                this.lBJ = false;
                return;
            }
            return;
        }
        aCM();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar instanceof com.tencent.mm.plugin.emoji.f.c) {
            switch (((com.tencent.mm.plugin.emoji.f.c) kVar).hyU) {
                case 2:
                    aCx();
                    if (i == 0 && i2 == 0) {
                        for (int i3 = 0; i3 < this.lBM.size(); i3++) {
                            x.i("MicroMsg.emoji.EmojiCustomUI", "mSelectedList md5:%s", new Object[]{this.lBM.get(i3)});
                            g.pQN.k(10613, (String) this.lBM.get(i3));
                        }
                        com.tencent.mm.plugin.emoji.sync.a aBB = i.aBB();
                        ArrayList arrayList = this.lBM;
                        BKGLoaderManager bKGLoaderManager = aBB.lzq;
                        String str2 = "MicroMsg.BKGLoader.BKGLoaderManager";
                        String str3 = "cleanUploadTasks size%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
                        x.i(str2, str3, objArr);
                        if (bKGLoaderManager.lzO != null && arrayList != null && bKGLoaderManager.lzO.size() > 0 && arrayList.size() > 0) {
                            com.tencent.mm.plugin.emoji.sync.d dVar;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String str4 = (String) it.next();
                                if (!bh.ov(str4)) {
                                    Iterator it2 = bKGLoaderManager.lzO.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.emoji.sync.d) it2.next();
                                        if (!bh.ov(dVar.getKey()) && dVar.getKey().equalsIgnoreCase(str4)) {
                                            arrayList2.add(dVar);
                                        }
                                    }
                                }
                            }
                            if (bKGLoaderManager.lzO != null && bKGLoaderManager.lzO.size() > 0 && arrayList2.size() > 0) {
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    bKGLoaderManager.lzO.remove((com.tencent.mm.plugin.emoji.sync.d) it3.next());
                                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "clean upload task :%s", new Object[]{dVar.getKey()});
                                }
                            }
                            arrayList2.clear();
                        }
                        i.aBE().lwL.cU(this.lBM);
                        aCJ();
                        aCL();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        return;
                    }
                    x.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    yF(getString(R.l.ebu));
                    return;
                case 3:
                    aCx();
                    if (i == 0 && i2 == 0) {
                        i.aBE().lwL.cV(this.lBM);
                        aCJ();
                        aCL();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        return;
                    }
                    yF(getString(R.l.ebu));
                    return;
                default:
                    return;
            }
        }
        x.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    }

    private void yG(String str) {
        getString(R.l.dGO);
        this.ltM = h.a(this, str, true, new 9(this));
    }

    private void aCx() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }
}
