package com.tencent.mm.view.f;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bu.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a {
    public int RT;
    private final String TAG;
    public int irz;
    public int kbf;
    public int kbg;
    public int lHW;
    public int mNk;
    private Context tI;
    public String vpS;
    public int zDD;
    public int zGA;
    public int zGB;
    public int zGC;
    public int zGD;
    public String zGE;
    public int zGF;
    public boolean zGG;
    public boolean zGH;
    public boolean zGI;
    public boolean zGJ;
    public boolean zGK;
    public boolean zGL;
    public boolean zGM;
    public boolean zGN;
    public boolean zGO;
    public int[] zGP;
    public boolean zGQ;
    public boolean zGR;
    public ArrayList<com.tencent.mm.view.c.a> zGS;
    public HashMap<String, Integer> zGT;
    public c zGU;
    public volatile boolean zGV;
    public int zGs;
    public int zGt;
    public int zGu;
    public int zGv;
    public int zGw;
    public int zGx;
    public int zGy;
    private int zGz;
    public int zeR;

    public enum a {
        RECOMMEND,
        DEFAULT,
        EMOJI
    }

    public a() {
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
        this.zeR = 0;
        this.zGB = 0;
        this.RT = 0;
        this.mNk = 0;
        this.zGE = "";
        this.zGF = 0;
        this.zGN = false;
        this.zGO = false;
        this.zGS = new ArrayList();
        this.zGT = new HashMap();
        this.zGV = false;
        this.tI = ac.getContext();
        this.zGs = this.tI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.m.a.c.bxh);
        this.lHW = this.tI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.m.a.c.lIU);
        this.zGt = this.tI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.m.a.c.lIT);
        this.zGy = com.tencent.mm.bv.a.fromDPToPix(this.tI, 48);
        this.zGz = com.tencent.mm.bv.a.fromDPToPix(this.tI, 43);
        this.zGv = com.tencent.mm.bv.a.fromDPToPix(this.tI, 86);
        this.zGw = com.tencent.mm.bv.a.fromDPToPix(this.tI, 80);
        this.zGx = com.tencent.mm.bv.a.fromDPToPix(this.tI, 65);
        this.zGu = com.tencent.mm.bv.a.aa(this.tI, com.tencent.mm.plugin.m.a.c.buo);
        this.zGD = com.tencent.mm.bv.a.fromDPToPix(this.tI, 6);
        this.zGE = "TAG_DEFAULT_TAB";
        this.zGF = 0;
        this.zDD = com.tencent.mm.bv.a.aa(this.tI, com.tencent.mm.plugin.m.a.c.lJa);
        this.zGA = com.tencent.mm.bv.a.aa(this.tI, com.tencent.mm.plugin.m.a.c.buo);
        cBe();
        cAV();
    }

    public final void onPause() {
        this.zGL = false;
        cAU();
        long currentTimeMillis = System.currentTimeMillis();
        bis com_tencent_mm_protocal_c_bis = new bis();
        if (!(this.zGT == null || this.zGT.isEmpty())) {
            for (String str : this.zGT.keySet()) {
                bit com_tencent_mm_protocal_c_bit = new bit();
                com_tencent_mm_protocal_c_bit.vIR = str;
                com_tencent_mm_protocal_c_bit.vLg = ((Integer) this.zGT.get(str)).intValue();
                com_tencent_mm_protocal_c_bis.wMd.add(com_tencent_mm_protocal_c_bit);
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().a(com_tencent_mm_protocal_c_bis);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        cBd();
    }

    public static boolean cAR() {
        boolean CX;
        boolean CX2;
        Exception exception;
        try {
            if (((h) g.Dg().CN()).DS()) {
                com.tencent.mm.bu.a.cdS();
                b bVar = com.tencent.mm.bu.a.xbo;
                CX = b.CX(208913);
                try {
                    com.tencent.mm.bu.a.cdS();
                    b bVar2 = com.tencent.mm.bu.a.xbo;
                    CX2 = b.CX(208899);
                } catch (Exception e) {
                    Exception exception2 = e;
                    CX2 = CX;
                    exception = exception2;
                    x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{exception.toString()});
                    CX = CX2;
                    CX2 = false;
                    if (!CX2) {
                    }
                    return true;
                }
            }
            CX = false;
            CX2 = false;
        } catch (Exception e2) {
            exception = e2;
            CX2 = false;
            x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{exception.toString()});
            CX = CX2;
            CX2 = false;
            if (CX2) {
            }
            return true;
        }
        if (CX2 || r0) {
            return true;
        }
        return false;
    }

    public static boolean cAS() {
        boolean aQ;
        Exception e;
        boolean aQ2;
        try {
            if (((h) g.Dg().CN()).DS()) {
                aQ = com.tencent.mm.s.c.Bq().aQ(262147, 266244);
                try {
                    aQ2 = com.tencent.mm.s.c.Bq().aQ(262149, 266244);
                } catch (Exception e2) {
                    e = e2;
                    x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
                    aQ2 = false;
                    if (!aQ) {
                    }
                    return true;
                }
            }
            aQ2 = false;
            aQ = false;
        } catch (Exception e3) {
            e = e3;
            aQ = false;
            x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            aQ2 = false;
            if (aQ) {
            }
            return true;
        }
        if (aQ || r0) {
            return true;
        }
        return false;
    }

    public final int aaq(String str) {
        if ("TAG_DEFAULT_TAB".equals(str)) {
            return this.zGy;
        }
        return this.zGv;
    }

    public final void Hw(int i) {
        this.kbf = i;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(this.kbf)});
    }

    public final int cAT() {
        if (this.kbg <= 1) {
            this.kbg = akV()[0];
        }
        return this.kbg;
    }

    public final void aar(String str) {
        if (!bh.ov(str)) {
            this.zGE = str;
        }
    }

    public final void cAU() {
        if (!bh.ov(this.zGE) && !this.zGG) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", new Object[]{this.zGE, Integer.valueOf(this.zGF)});
            com.tencent.mm.bu.a.cdS();
            b bVar = com.tencent.mm.bu.a.xbo;
            b.UB(this.zGE);
        }
    }

    public final void cAV() {
        if (!this.zGG) {
            com.tencent.mm.bu.a.cdS();
            b bVar = com.tencent.mm.bu.a.xbo;
            this.zGE = b.aQ(-29414086, "TAG_DEFAULT_TAB");
            this.zGF = bh.a((Integer) this.zGT.get(this.zGE), 0);
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", new Object[]{this.zGE, Integer.valueOf(this.zGF)});
        } else if (!this.zGE.equals("TAG_DEFAULT_TAB")) {
            this.zGE = "TAG_DEFAULT_TAB";
            this.zGF = bh.a((Integer) this.zGT.get(this.zGE), 0);
        }
    }

    public static EmojiGroupInfo cAW() {
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
        return emojiGroupInfo;
    }

    public static EmojiGroupInfo cAX() {
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.xAc);
        return emojiGroupInfo;
    }

    public static boolean d(EmojiGroupInfo emojiGroupInfo) {
        return emojiGroupInfo != null && emojiGroupInfo.field_packStatus == 1;
    }

    public final boolean cAY() {
        com.tencent.mm.bu.a.cdS();
        b bVar = com.tencent.mm.bu.a.xbo;
        return b.CX(66832) && !this.zGM;
    }

    public final com.tencent.mm.view.c.a aas(String str) {
        if (this.zGS == null || str == null) {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            return null;
        }
        Iterator it = this.zGS.iterator();
        while (it.hasNext()) {
            com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) it.next();
            if (aVar == null) {
                x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (aVar.lyH == null) {
                x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (aVar.lyH.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public final com.tencent.mm.view.c.a Hx(int i) {
        if (this.zGS == null) {
            return null;
        }
        return (com.tencent.mm.view.c.a) this.zGS.get(Hy(i));
    }

    public final int Hy(int i) {
        if (this.zGP == null || i >= this.zGP.length || i <= 0) {
            return 0;
        }
        return this.zGP[i];
    }

    public final int cAZ() {
        String str = this.zGE;
        if (this.zGS != null) {
            for (int i = 0; i < this.zGS.size(); i++) {
                com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) this.zGS.get(i);
                if (aVar != null && aVar.lyH.equals(str)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public final com.tencent.mm.view.c.a cBa() {
        return aas(this.zGE);
    }

    public final void cBb() {
        this.mNk = 0;
        if (this.zGS != null) {
            com.tencent.mm.view.c.a aVar;
            Iterator it = this.zGS.iterator();
            while (it.hasNext()) {
                aVar = (com.tencent.mm.view.c.a) it.next();
                this.mNk = aVar.cAJ() + this.mNk;
            }
            if (this.zGS != null) {
                try {
                    this.zGP = new int[this.mNk];
                    int i = 0;
                    int i2 = 0;
                    loop1:
                    while (i < this.zGS.size()) {
                        aVar = (com.tencent.mm.view.c.a) this.zGS.get(i);
                        int i3 = i2;
                        i2 = 0;
                        while (i2 < aVar.cAJ()) {
                            if (i3 >= this.mNk) {
                                break loop1;
                            }
                            int i4 = i3 + 1;
                            this.zGP[i3] = i;
                            i2++;
                            i3 = i4;
                        }
                        i++;
                        i2 = i3;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
                }
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", new Object[]{Integer.valueOf(this.mNk)});
        }
    }

    public final int aat(String str) {
        int i = 4;
        if (bh.ov(str)) {
            return 0;
        }
        if (str.equals("TAG_DEFAULT_TAB")) {
            if (cBc()) {
                return 7;
            }
            return cAT() / this.zGz;
        } else if (this.kbf <= 0) {
            return 0;
        } else {
            if (str.equals("TAG_STORE_TAB")) {
                return 3;
            }
            int cAT = cAT() / this.zGw;
            if (!cBc()) {
                i = cAT;
            } else if (cAT <= 4) {
                i = cAT;
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[]{Integer.valueOf(i)});
            return i;
        }
    }

    public final int dA(String str, int i) {
        return (this.kbf - (aaq(str) * i)) / (i + 1);
    }

    public static boolean isSDCardAvailable() {
        if (!((h) g.Dg().CN()).DS()) {
            return true;
        }
        g.Dk();
        return g.Dj().isSDCardAvailable();
    }

    public final boolean cBc() {
        if (this.RT == 0) {
            int[] akV = akV();
            if (akV[0] < akV[1]) {
                this.RT = 1;
            } else {
                this.RT = 2;
            }
        }
        return this.RT == 1;
    }

    private int[] akV() {
        int[] iArr = new int[2];
        if (this.tI instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.tI).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.tI.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public final void cBd() {
        if (this.zGU != null) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            com.tencent.mm.sdk.b.a.xef.c(this.zGU);
            this.zGU = null;
        }
    }

    public final int getColumnWidth() {
        int i = 4;
        if (this.zeR == 0) {
            int cAT = cAT() / this.zGw;
            if (!cBc()) {
                i = cAT;
            } else if (cAT <= 4) {
                i = cAT;
            }
            this.zeR = cAT() / i;
        }
        return this.zeR;
    }

    public final void cBe() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.zGT == null) {
            this.zGT = new HashMap();
        }
        this.zGT.clear();
        bis aAZ = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aAZ();
        if (!(aAZ == null || aAZ.wMd == null || aAZ.wMd.isEmpty())) {
            Iterator it = aAZ.wMd.iterator();
            while (it.hasNext()) {
                bit com_tencent_mm_protocal_c_bit = (bit) it.next();
                this.zGT.put(com_tencent_mm_protocal_c_bit.vIR, Integer.valueOf(com_tencent_mm_protocal_c_bit.vLg));
            }
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
