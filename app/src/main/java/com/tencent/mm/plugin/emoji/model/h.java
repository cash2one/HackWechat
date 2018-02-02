package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

public final class h {
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    public Context kaK;
    public a lxL;
    public boolean lxM = false;
    public Fragment lxN;
    public int lxO;
    public long lxP = 0;
    public String lxQ = "";
    public b lxR;
    private String lxS;
    private b lxT = new b(2003);
    public String lxU;
    private Context tI = ac.getContext();

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar != null && aVar.ltl != null && this.lxL != null && this.lxL.luB != null) {
            so soVar = aVar.ltl.luN;
            if (soVar != null) {
                String str;
                String str2 = soVar.vIR;
                String str3 = soVar.war;
                String str4 = soVar.waC;
                String str5 = soVar.waD;
                int aAu = aVar.aAu();
                (aVar.ltl == null ? null : Integer.valueOf(aVar.ltl.luP)).intValue();
                c cVar = this.lxL.luB;
                boolean z = cVar.luK;
                boolean z2 = aVar.ltl.luR;
                String str6 = "MicroMsg.emoji.PayOrDownloadComponent";
                String str7 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    str = str4;
                }
                objArr[1] = str;
                objArr[2] = Integer.valueOf(aAu);
                x.i(str6, str7, objArr);
                this.lxS = str2;
                int i;
                ak xX;
                switch (aAu) {
                    case -1:
                        if (e.a(soVar)) {
                            i = 3;
                        } else if (e.b(soVar) || (!z && TextUtils.isEmpty(soVar.wau))) {
                            i = 3;
                        } else if (z) {
                            xX = cVar.xX(str2);
                            if (TextUtils.isEmpty(xX.xyF)) {
                                i = xX.xyD;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 4;
                        }
                        this.lxL.bc(str2, i);
                        return;
                    case 0:
                        if (this.lxL != null) {
                            this.lxL.bc(str2, 3);
                            return;
                        }
                        return;
                    case 3:
                    case 5:
                        if (com.tencent.mm.plugin.emoji.h.a.d(soVar)) {
                            com.tencent.mm.plugin.emoji.f.a.aBJ();
                            com.tencent.mm.plugin.emoji.f.a.aBK();
                            return;
                        }
                        I(str2, null, str3);
                        if (this.lxL != null) {
                            this.lxL.bd(str2, 0);
                        }
                        x.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        g.pQN.h(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(this.lxO), "", str2, Long.valueOf(this.lxP), this.lxQ});
                        return;
                    case 4:
                    case 12:
                        if (!this.lxM) {
                            Intent intent = new Intent();
                            intent.putExtra("key_product_id", str2);
                            if (z) {
                                intent.putExtra("key_currency_type", "");
                                intent.putExtra("key_price", str4);
                            } else {
                                intent.putExtra("key_currency_type", str5);
                                intent.putExtra("key_price", str4);
                            }
                            d.b(this.kaK, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                            this.lxM = true;
                            g.pQN.h(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.lxO), "", str2, Long.valueOf(this.lxP), this.lxQ});
                            return;
                        }
                        return;
                    case 7:
                        if (z2) {
                            if ((this.lxN != null ? 1 : null) != null) {
                                b bVar = this.lxT;
                                Fragment fragment = this.lxN;
                                x.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                                Intent intent2 = new Intent();
                                intent2.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                                intent2.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                                d.a(fragment, ".ui.transmit.SelectConversationUI", intent2, bVar.jKN);
                                fragment.getActivity().overridePendingTransition(R.a.bqo, R.a.bqa);
                            } else {
                                this.lxT.n((Activity) this.kaK);
                            }
                            this.lxT.lIH = str2;
                            g.pQN.h(12069, new Object[]{Integer.valueOf(1), str2});
                            return;
                        } else if (aVar.ltl.luT) {
                            str4 = aVar.ltl.luN.vIR;
                            String str8 = aVar.ltl.luN.war;
                            str2 = this.lxU;
                            if (this.kaK != null) {
                                i = this.lxO == 9 ? 3 : 4;
                                Intent intent3 = new Intent();
                                intent3.setClass(this.kaK, EmojiStoreV2RewardUI.class);
                                intent3.putExtra("extra_id", str4);
                                intent3.putExtra("extra_name", str8);
                                intent3.putExtra("name", str2);
                                intent3.putExtra("scene", this.lxO);
                                intent3.putExtra("pageType", i);
                                intent3.putExtra("searchID", this.lxP);
                                this.kaK.startActivity(intent3);
                                g.pQN.h(12738, new Object[]{str4, Integer.valueOf(i), Integer.valueOf(this.lxO), Integer.valueOf(0)});
                                return;
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                            return;
                        } else {
                            return;
                        }
                    case 9:
                        ar.CG().a(new q(str2, 2), 0);
                        return;
                    case 10:
                        xX = cVar.xX(str2);
                        if (xX != null) {
                            switch (xX.xyE) {
                                case 10233:
                                    str = getString(R.l.dZV);
                                    break;
                                case 10234:
                                    str = getString(R.l.dZQ);
                                    break;
                                case 10235:
                                    str = getString(R.l.ebt);
                                    break;
                                default:
                                    str = getString(R.l.ebx);
                                    break;
                            }
                            com.tencent.mm.ui.base.h.b(this.kaK, str, null, true);
                            return;
                        }
                        return;
                    case 11:
                        x.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                        return;
                    default:
                        x.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                        return;
                }
            }
        }
    }

    private void I(String str, String str2, String str3) {
        if (this.lxR != null) {
            this.lxR.I(str, str2, str3);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            x.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:" + i3);
            str = intent.getStringExtra("key_err_msg");
            x.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:" + str);
        }
        String str2 = str;
        this.lxM = false;
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    if (this.lxL != null && this.lxL.luB != null) {
                        if (intent != null && r0 == 0) {
                            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                            Object obj = null;
                            int size = stringArrayListExtra.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj2;
                                String str3 = (String) stringArrayListExtra.get(i4);
                                str = (String) stringArrayListExtra2.get(i4);
                                ak xX = this.lxL.luB.xX(str3);
                                if (this.lxS.equals(str3)) {
                                    obj = 1;
                                    I(str3, str, xX.lEM);
                                    this.lxL.bd(this.lxS, 0);
                                    com.tencent.mm.ui.base.h.bu(this.kaK, str2);
                                    x.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str3});
                                    if (stringArrayListExtra.size() > 1) {
                                        x.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                        if (this.lxR != null) {
                                            this.lxR.aBw();
                                            obj2 = 1;
                                        }
                                    }
                                    obj2 = obj;
                                } else {
                                    this.lxL.bc(this.lxS, 5);
                                    obj2 = obj;
                                }
                                i4++;
                                obj = obj2;
                            }
                            if (obj == null) {
                                yy(str2);
                            }
                            if (com.tencent.mm.z.q.Ge()) {
                                g.pQN.a(166, 4, 1, false);
                                return;
                            } else {
                                g.pQN.a(166, 0, 1, false);
                                return;
                            }
                        } else if (intent != null && r0 == 100000002) {
                            I(this.lxS, null, this.lxL.luB.xX(this.lxS).lEM);
                            this.lxL.bd(this.lxS, 0);
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{this.lxS});
                            yy(str2);
                            if (com.tencent.mm.z.q.Ge()) {
                                g.pQN.a(166, 7, 1, false);
                                return;
                            } else {
                                g.pQN.a(166, 3, 1, false);
                                return;
                            }
                        } else if (intent == null || r0 != 1) {
                            if (!(this.lxS == null || this.lxL == null || this.lxL.luB == null)) {
                                this.lxL.luB.xV(this.lxS);
                                com.tencent.mm.plugin.emoji.a.a xT = this.lxL.xT(this.lxS);
                                if (xT != null) {
                                    xT.aAz();
                                }
                            }
                            yy(str2);
                            if (com.tencent.mm.z.q.Ge()) {
                                g.pQN.a(166, 5, 1, false);
                            } else {
                                g.pQN.a(166, 1, 1, false);
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[]{str2});
                            return;
                        } else {
                            if (com.tencent.mm.z.q.Ge()) {
                                g.pQN.a(166, 6, 1, false);
                            } else {
                                g.pQN.a(166, 2, 1, false);
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                            return;
                        }
                    }
                    return;
                case 2003:
                    str = this.lxT.lIH;
                    if (!bh.ov(str)) {
                        b.a(intent, str, (Activity) this.kaK);
                        g.pQN.h(12069, new Object[]{Integer.valueOf(3), str});
                        return;
                    }
                    return;
                default:
                    x.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                    return;
            }
        } else if (i != 2001) {
        } else {
            if (com.tencent.mm.z.q.Ge()) {
                g.pQN.a(166, 6, 1, false);
            } else {
                g.pQN.a(166, 2, 1, false);
            }
        }
    }

    private void yy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.dZY);
        }
        com.tencent.mm.ui.base.h.a(this.kaK, str, "", new 1(this));
    }

    private String getString(int i) {
        return this.tI.getString(i);
    }
}
