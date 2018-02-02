package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Gallery;
import android.widget.Toast;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView$a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    private static int hbn = 0;
    private static int hbo = 0;
    private Context context;
    private af handler = new af();
    List<b> hiv;
    boolean qQH = false;
    an qQS = an.xyY;
    b rBT;
    Gallery rBU;
    private boolean rBV = true;
    HashMap<Integer, Integer> rBW = new HashMap();
    HashMap<Integer, Long> rBX = new HashMap();
    HashMap<Integer, Long> rBY = new HashMap();
    boolean rBZ = false;
    private MultiTouchImageView$a rCA = new 6(this);
    boolean rCa = false;
    boolean rCb = false;
    boolean rCc = false;
    boolean rCd = false;
    private boolean rCe = true;
    private boolean rCf = true;
    private float rCg = 1.0f;
    MMPageControlView rCh;
    Runnable rCi = null;
    private String rCj = "";
    private int rCk = -1;
    int rCl = -1;
    private boolean rCm = false;
    long rCn = 0;
    private HashSet<String> rCo = new HashSet();
    private Map<String, Boolean> rCp;
    private int rCq = 0;
    private int rCr = 0;
    private boolean rCs = false;
    c rCt;
    private HashMap<String, m> rCu = new HashMap();
    int rCv = -1;
    HashSet<String> rCw = new HashSet();
    public int rCx = 0;
    public int rCy = 0;
    private HashMap<String, a> rCz = new HashMap();
    boolean rzb = false;
    boolean rzd = false;
    public String username;

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str) {
        x.d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", str);
        if (!snsInfoFlip.rCz.containsKey(str)) {
            a aVar = new a(snsInfoFlip);
            aVar.het = snsInfoFlip.getCount();
            aVar.networkType = bBb();
            aVar.rCE = System.currentTimeMillis();
            aVar.rCG = str;
            snsInfoFlip.rCz.put(str, aVar);
            x.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        init(context);
    }

    public final boolean bzn() {
        return this.rzb;
    }

    private void init(Context context) {
        this.rCn = System.currentTimeMillis();
        this.context = context;
        View inflate = inflate(context, g.qHs, this);
        if (com.tencent.mm.ui.base.g.coK()) {
            inflate.findViewById(f.qCg).setVisibility(0);
            this.rBU = (Gallery) inflate.findViewById(f.qCg);
        } else {
            inflate.findViewById(f.qCh).setVisibility(0);
            this.rBU = (Gallery) inflate.findViewById(f.qCh);
        }
        if (this.rBU instanceof MMGestureGallery) {
            this.rBU.setSpacing(50);
            ((MMGestureGallery) this.rBU).zlf = new 1(this, context);
            ((MMGestureGallery) this.rBU).zlh = new 2(this);
        }
        this.rCh = (MMPageControlView) findViewById(f.qGi);
        this.rCh.ych = g.qIm;
        this.rCp = new HashMap();
    }

    public final void xC(int i) {
        this.infoType = i;
    }

    public final b bAW() {
        if (this.rBU == null) {
            return null;
        }
        return (b) this.rBU.getSelectedItem();
    }

    private static int b(String str, bnp com_tencent_mm_protocal_c_bnp) {
        Iterator it = com_tencent_mm_protocal_c_bnp.wQo.vYd.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((aqr) it.next()).nGJ)) {
                return i;
            }
        }
        return 0;
    }

    private void a(aqr com_tencent_mm_protocal_c_aqr, int i, String str) {
        long j = 0;
        if (this.rBU != null && (this.rBU instanceof MMGestureGallery)) {
            float f;
            float f2;
            if (com_tencent_mm_protocal_c_aqr.wxH != null) {
                f = com_tencent_mm_protocal_c_aqr.wxH.wyv;
                f2 = com_tencent_mm_protocal_c_aqr.wxH.wyu;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            float f3;
            if (f <= 0.0f || f2 <= 0.0f) {
                Options UL = d.UL(com_tencent_mm_protocal_c_aqr.nGJ.startsWith("Locall_path") ? am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.m(com_tencent_mm_protocal_c_aqr) : am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.d(com_tencent_mm_protocal_c_aqr));
                if (UL != null) {
                    f3 = (float) UL.outWidth;
                    f2 = (float) UL.outHeight;
                }
            } else {
                f3 = f2;
                f2 = f;
            }
            if (f2 > 0.0f && r5 > 0.0f) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) this.rBU;
                if (!this.rCd || ((double) r5) * 1.0d <= ((double) f2) * 2.0d) {
                    x.d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.yes = false;
                } else {
                    x.d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.yes = true;
                }
            }
        }
        if (this.rCt != null) {
            this.rCt.xH(i);
        }
        m Lm = ae.bvv().Lm(str);
        if (Lm != null) {
            ax.c(Lm, i);
        }
        if (this.rCk == -1) {
            this.rCk = i;
        }
        this.rCl = 1;
        String str2 = com_tencent_mm_protocal_c_aqr.nGJ;
        if (bh.ov(str)) {
            this.rsv.ep((i + 1) + " / " + this.rBT.getCount(), null);
            return;
        }
        Lm = (m) this.rCu.get(str);
        if (Lm == null) {
            Lm = ae.bvv().Lm(str);
            this.rCu.put(str, Lm);
        }
        m mVar = Lm;
        if (mVar != null) {
            String str3;
            if (com_tencent_mm_protocal_c_aqr.ktN == 2) {
                if (this.rBU instanceof MMGestureGallery) {
                    ((MMGestureGallery) this.rBU).zli = false;
                }
            } else if (this.rBU instanceof MMGestureGallery) {
                ((MMGestureGallery) this.rBU).zli = true;
            }
            if (com_tencent_mm_protocal_c_aqr.ktN != 6) {
                ae.aNT().post(new 3(this));
            }
            x.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
            if (this.rCv != i) {
                this.rBW.put(Integer.valueOf(i), Integer.valueOf((this.rBW.containsKey(Integer.valueOf(i)) ? ((Integer) this.rBW.get(Integer.valueOf(i))).intValue() : 0) + 1));
                this.rBX.put(Integer.valueOf(i), Long.valueOf(bh.Wq()));
                if (this.rCv >= 0) {
                    long longValue;
                    if (this.rBX.containsKey(Integer.valueOf(this.rCv))) {
                        longValue = ((Long) this.rBX.get(Integer.valueOf(this.rCv))).longValue();
                    } else {
                        longValue = 0;
                    }
                    if (longValue > 0) {
                        this.rBX.put(Integer.valueOf(this.rCv), Long.valueOf(0));
                        if (this.rBY.containsKey(Integer.valueOf(this.rCv))) {
                            j = ((Long) this.rBY.get(Integer.valueOf(this.rCv))).longValue();
                        }
                        longValue = bh.bA(longValue);
                        j += longValue;
                        this.rBY.put(Integer.valueOf(this.rCv), Long.valueOf(j));
                        x.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.rCv + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                    }
                }
                if (this.rzb && this.rBT != null) {
                    b bVar = (b) this.rBT.getItem(this.rCv);
                    if (bVar != null) {
                        str3 = bVar.fHC.nGJ;
                        x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", str3);
                        if (this.rCz.containsKey(str3)) {
                            a aVar = (a) this.rCz.get(str3);
                            aVar.networkType = bBb();
                            if (aVar.rCF != -1) {
                                aVar.rCD = 1;
                                aVar.qXQ = aVar.rCF - aVar.rCE;
                                x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", Long.valueOf(aVar.qXQ));
                            } else {
                                aVar.rCD = 2;
                                aVar.rCF = System.currentTimeMillis();
                                aVar.qXQ = aVar.rCF - aVar.rCE;
                                x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", Long.valueOf(aVar.qXQ));
                            }
                        }
                    }
                }
            }
            this.rCv = i;
            if (this.rsu != null) {
                this.rsu.LO(str);
            }
            int i2 = mVar.field_createTime;
            bnp bxV = mVar.bxV();
            String l = az.l(this.context, ((long) i2) * 1000);
            str3 = null;
            if (!(bxV == null || bxV.wQo == null || bxV.wQo.vYd.size() <= 1)) {
                str3 = (((b) this.hiv.get(i)).raH + 1) + " / " + bxV.wQo.vYd.size();
                this.rCl = b(str2, bxV);
            }
            this.rsv.ep(l, str3);
            this.rsv.ci(str, i);
            if (this.rBT != null) {
                this.rBT.xG(i);
            }
        }
    }

    public final void a(List<b> list, String str, int i, v vVar, a aVar) {
        ae.bvq().a(this);
        this.hiv = list;
        this.rCm = this.hiv.size() > 1;
        ai.Km(str);
        this.rsu = vVar;
        this.rsv = aVar;
        this.rBT = new b(this, this.context);
        this.rBU.setAdapter(this.rBT);
        if (i >= 0 && i < this.hiv.size()) {
            this.rBU.setSelection(i);
            if (this.rCf) {
                this.rCf = false;
                aqr com_tencent_mm_protocal_c_aqr = ((b) this.hiv.get(i)).fHC;
                if (com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.wxH == null || com_tencent_mm_protocal_c_aqr.wxH.wyv <= 0.0f) {
                    this.rCg = 1.0f;
                } else {
                    this.rCg = com_tencent_mm_protocal_c_aqr.wxH.wyu / com_tencent_mm_protocal_c_aqr.wxH.wyv;
                }
            }
        }
        this.rBU.setFadingEdgeLength(0);
        this.rBU.setOnItemSelectedListener(new 4(this));
        if (this.rBV) {
            this.rBU.setOnItemLongClickListener(new 5(this));
        }
        if (this.rBZ && this.rBT.getCount() > 1) {
            this.rCh.setVisibility(0);
            this.rCh.eR(this.rBT.getCount(), i);
        }
        if (this.rzd && !bh.ov(((b) this.rBT.getItem(i)).raG)) {
            LL(am.r(ae.getAccSnsPath(), ((b) this.rBT.getItem(i)).fHC.nGJ) + i.l(((b) this.rBT.getItem(i)).fHC));
        }
    }

    public final long bzm() {
        b bVar = (b) this.rBU.getSelectedItem();
        String str = bVar == null ? "" : bVar.raG;
        if (bh.ov(str)) {
            return 0;
        }
        m Lm = ae.bvv().Lm(str);
        return Lm == null ? 0 : Lm.field_snsId;
    }

    public final int getPosition() {
        return this.rCl;
    }

    private void bAX() {
        if (this.rBU.getSelectedItem() != null && this.rBT != null) {
            int selectedItemPosition = this.rBU.getSelectedItemPosition();
            if (this.rBZ && this.rBT.getCount() > 1) {
                this.rCh.setVisibility(0);
                this.rCh.xa(selectedItemPosition);
            }
            aqr com_tencent_mm_protocal_c_aqr = ((b) this.rBU.getSelectedItem()).fHC;
            this.rCw.add(com_tencent_mm_protocal_c_aqr.nGJ);
            String str = ((b) this.rBU.getSelectedItem()).raG;
            String str2 = com_tencent_mm_protocal_c_aqr.nGJ;
            if (bh.ov(this.rCj) || !this.rCj.equals(str2)) {
                this.rCj = "";
            }
            a(com_tencent_mm_protocal_c_aqr, selectedItemPosition, str);
        }
    }

    public final void aHq() {
        if (this.rBT != null) {
            x.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.rBT.notifyDataSetChanged();
            bAX();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.rBT != null) {
            this.rBT.bBg();
            this.rBT.clear();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.rCs = true;
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.rCs = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void bAY() {
        x.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.rBT != null) {
            this.rBT.bBg();
            this.rBT.clear();
        }
        ae.bvq().b(this);
    }

    public final int bAZ() {
        if (this.rBU == null) {
            return -1;
        }
        this.hiv.remove(this.rBU.getSelectedItemPosition());
        this.rBT.notifyDataSetChanged();
        bAX();
        return this.rBT.getCount();
    }

    public final int getCount() {
        if (this.rBT != null) {
            return this.rBT.getCount();
        }
        return 0;
    }

    public final aqr bzo() {
        if (this.rBT != null) {
            int selectedItemPosition = this.rBU.getSelectedItemPosition();
            if (this.hiv != null && selectedItemPosition < this.hiv.size()) {
                return ((b) this.hiv.get(selectedItemPosition)).fHC;
            }
        }
        return null;
    }

    public final int bBa() {
        int i = 0;
        int i2 = 0;
        for (b bVar : this.hiv) {
            ae.bvs();
            if (FileOp.bO(com.tencent.mm.plugin.sns.model.g.C(bVar.fHC))) {
                i2++;
            }
            int i3 = i + 1;
            if (i3 > 9) {
                break;
            }
            i = i3;
        }
        return i2;
    }

    public final void aE(String str, boolean z) {
        aqr com_tencent_mm_protocal_c_aqr;
        if (!z) {
            com_tencent_mm_protocal_c_aqr = ((b) this.rBU.getSelectedItem()).fHC;
            if (!(com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || !com_tencent_mm_protocal_c_aqr.nGJ.equals(str))) {
                Toast.makeText(this.context, this.context.getString(j.qKx), 0).show();
                this.rCj = str;
            }
        }
        this.rCy++;
        if (this.rzb) {
            x.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", str, Boolean.valueOf(z));
            if (z && this.rCz.containsKey(str)) {
                a aVar = (a) this.rCz.get(str);
                aVar.rCF = System.currentTimeMillis();
                aVar.networkType = bBb();
                x.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.rCp.put(str, Boolean.valueOf(true));
            }
        }
        if (this.rBT != null && ((b) this.rBU.getSelectedItem()) != null) {
            com_tencent_mm_protocal_c_aqr = ((b) this.rBU.getSelectedItem()).fHC;
            if (com_tencent_mm_protocal_c_aqr != null && com_tencent_mm_protocal_c_aqr.nGJ != null && com_tencent_mm_protocal_c_aqr.nGJ.equals(str)) {
                this.rBT.notifyDataSetChanged();
                if (this.rzd && com_tencent_mm_protocal_c_aqr != null) {
                    String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                    String l = i.l(com_tencent_mm_protocal_c_aqr);
                    if (FileOp.bO(r + l)) {
                        l = r + l;
                        Intent intent = new Intent();
                        x.i("MicroMsg.FlipView", "edit image path:%s", l);
                        intent.putExtra("before_photo_edit", l);
                        intent.putExtra("from_scene", JsApiGetAudioState.CTRL_INDEX);
                        intent.putExtra("after_photo_edit", "");
                        intent.putExtra("Retr_Compress_Type", 0);
                        intent.putExtra("Retr_Msg_Type", 0);
                        intent.putExtra("Retr_FromMainTimeline", bzn());
                        com.tencent.mm.bm.d.b(this.context, "photoedit", ".ui.MMNewPhotoEditUI", intent);
                    }
                }
            }
        }
    }

    public final void aF(String str, boolean z) {
        x.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            aqr com_tencent_mm_protocal_c_aqr = ((b) this.rBU.getSelectedItem()).fHC;
            if (!(com_tencent_mm_protocal_c_aqr == null || com_tencent_mm_protocal_c_aqr.nGJ == null || !com_tencent_mm_protocal_c_aqr.nGJ.equals(str))) {
                Toast.makeText(this.context, this.context.getString(j.qKy), 0).show();
                this.rCj = str;
            }
        }
        if (this.rBT != null) {
            this.rBT.notifyDataSetChanged();
        }
    }

    private static int bBb() {
        Context context = ac.getContext();
        if (com.tencent.mm.sdk.platformtools.an.is2G(context)) {
            return 1;
        }
        if (com.tencent.mm.sdk.platformtools.an.is3G(context)) {
            return 2;
        }
        if (com.tencent.mm.sdk.platformtools.an.is4G(context)) {
            return 3;
        }
        if (com.tencent.mm.sdk.platformtools.an.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public final void bBc() {
        for (a aVar : this.rCz.values()) {
            if (aVar.rCD != -1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(11601, Integer.valueOf(aVar.het), Integer.valueOf(aVar.rCD), Long.valueOf(aVar.qXQ), Integer.valueOf(aVar.networkType));
                x.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(aVar.het), Integer.valueOf(aVar.rCD), Long.valueOf(aVar.qXQ), Integer.valueOf(aVar.networkType));
            } else if (aVar.rCE != -1) {
                if (aVar.rCF != -1) {
                    aVar.rCD = 1;
                } else {
                    aVar.rCD = 2;
                    aVar.rCF = System.currentTimeMillis();
                }
                aVar.qXQ = aVar.rCF - aVar.rCE;
                com.tencent.mm.plugin.report.service.g.pQN.h(11601, Integer.valueOf(aVar.het), Integer.valueOf(aVar.rCD), Long.valueOf(aVar.qXQ), Integer.valueOf(aVar.networkType));
                x.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(aVar.het), Integer.valueOf(aVar.rCD), Long.valueOf(aVar.qXQ), Integer.valueOf(aVar.networkType));
            }
        }
        this.rCz.clear();
    }
}
