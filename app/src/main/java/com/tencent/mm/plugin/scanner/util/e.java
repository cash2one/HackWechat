package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.ab;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.ac.a.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class e implements com.tencent.mm.ae.e, a {
    public String appId;
    public String bhd;
    public int fqd;
    public String fqg;
    public String imagePath;
    private ProgressDialog kGT = null;
    private Activity mActivity;
    public int moj;
    private int pZV;
    private String pZW;
    private Bundle pZX;
    a pZY = null;
    private Map<k, Integer> pZZ = new HashMap();

    public e() {
        onResume();
    }

    public final void a(Activity activity, String str, int i, int i2, int i3, a aVar, Bundle bundle) {
        x.i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mActivity = activity;
        this.pZV = i;
        this.pZW = str;
        this.pZY = aVar;
        this.pZX = bundle;
        if (bh.ov(str)) {
            x.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
        } else if (ar.CG().Km() == 0) {
            Toast.makeText(activity, activity.getString(R.l.eiE), 0).show();
            if (this.pZY != null) {
                this.pZY.m(0, null);
            }
        } else {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            if (bh.ov(str2)) {
                x.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[]{str, Boolean.valueOf(true), Boolean.valueOf(true)});
                int vK;
                int vg;
                b lmVar;
                if (str.startsWith("weixin://wxpay/bizpayurl")) {
                    x.i("MicroMsg.QBarStringHandler", "do native pay");
                    vK = vK(this.pZV);
                    vg = vg(vK);
                    lmVar = new lm();
                    lmVar.fCP.url = str;
                    lmVar.fCP.fCR = vg;
                    lmVar.fCP.scene = vK;
                    lmVar.fCP.context = this.mActivity;
                    if (vg == 13) {
                        x.d("MicroMsg.QBarStringHandler", "add source and sourceType");
                        lmVar.fCP.bhd = this.bhd;
                        lmVar.fCP.fqd = this.fqd;
                    }
                    lmVar.fqI = new 1(this, lmVar);
                    com.tencent.mm.sdk.b.a.xef.a(lmVar, Looper.myLooper());
                    new af(Looper.getMainLooper()).postDelayed(new 3(this), 200);
                    return;
                } else if (str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f")) {
                    if (this.pZY != null) {
                        this.pZY.m(5, null);
                    }
                    h.a(this.mActivity, 1, str, vg(vK(this.pZV)), null);
                    if (this.pZY != null) {
                        this.pZY.m(3, null);
                        return;
                    }
                    return;
                } else if (str.startsWith("wxp://wbf2f")) {
                    if (this.pZY != null) {
                        this.pZY.m(5, null);
                    }
                    h.a(this.mActivity, 6, str, vg(vK(this.pZV)), null);
                    if (this.pZY != null) {
                        this.pZY.m(3, null);
                        return;
                    }
                    return;
                } else if (i2 == 22 && str.startsWith("m")) {
                    x.d("MicroMsg.QBarStringHandler", "go to reward");
                    if (this.pZY != null) {
                        this.pZY.m(5, null);
                    }
                    r2 = vg(vK(this.pZV));
                    str2 = "";
                    if (bundle != null) {
                        str2 = bundle.getString("stat_url", "");
                    }
                    vg = 1;
                    if (this.moj == 37) {
                        vg = 2;
                    } else if (this.moj == 38) {
                        vg = 3;
                    } else if (this.moj == 40) {
                        vg = 4;
                    }
                    h.a(this.mActivity, str, r2, str2, vg);
                    if (this.pZY != null) {
                        this.pZY.m(3, null);
                        return;
                    }
                    return;
                } else if (str.startsWith("https://payapp.weixin.qq.com/qr/")) {
                    x.d("MicroMsg.QBarStringHandler", "f2f pay material");
                    if (this.pZY != null) {
                        this.pZY.m(5, null);
                    }
                    vK = vK(this.pZV);
                    vg = vg(vK);
                    lmVar = new ol();
                    lmVar.fGq.fGs = str;
                    lmVar.fGq.scene = vK;
                    lmVar.fGq.type = 0;
                    lmVar.fGq.fqH = new WeakReference(this.mActivity);
                    lmVar.fGq.fqI = new 4(this, lmVar, vg);
                    com.tencent.mm.sdk.b.a.xef.m(lmVar);
                    return;
                } else if (i2 == 22 && str.startsWith("n")) {
                    x.d("MicroMsg.QBarStringHandler", "qr reward pay material");
                    if (this.pZY != null) {
                        this.pZY.m(5, null);
                    }
                    String str3 = "";
                    if (bundle != null) {
                        str3 = bundle.getString("stat_url", "");
                    }
                    int vK2 = vK(this.pZV);
                    int vg2 = vg(vK2);
                    lmVar = new ol();
                    lmVar.fGq.fGs = str;
                    lmVar.fGq.scene = vK2;
                    lmVar.fGq.type = 1;
                    lmVar.fGq.fqH = new WeakReference(this.mActivity);
                    lmVar.fGq.fqI = new 5(this, lmVar, vg2, str3, vK2);
                    com.tencent.mm.sdk.b.a.xef.m(lmVar);
                    return;
                } else if (str.startsWith("wxhb://f2f")) {
                    x.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
                    if (i2 == 19) {
                        if (this.pZY != null) {
                            this.pZY.m(5, null);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("key_share_url", str);
                        d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", intent, 1);
                        return;
                    }
                    return;
                } else {
                    String str4 = this.appId;
                    x.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{str, Integer.valueOf(this.pZV), Integer.valueOf(this.moj > 0 ? this.moj : vK(this.pZV))});
                    k lVar = new l(str, r2, i2, i3, str4, (int) System.currentTimeMillis(), new byte[0]);
                    this.pZZ.put(lVar, Integer.valueOf(1));
                    ar.CG().a(lVar, 0);
                    if (this.kGT != null) {
                        this.kGT.dismiss();
                    }
                    activity.getString(R.l.dGO);
                    this.kGT = com.tencent.mm.ui.base.h.a(activity, activity.getString(R.l.eBB), true, new 7(this, lVar));
                    if (this.pZY != null) {
                        this.pZY.m(5, null);
                        return;
                    }
                    return;
                }
            }
            a(activity, i, str2, false);
        }
    }

    private static int vg(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }

    public final void bpA() {
        x.i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.pZW = null;
        this.mActivity = null;
        onPause();
    }

    public final void onResume() {
        x.i("MicroMsg.QBarStringHandler", "onResume");
        ar.CG().a(106, this);
        ar.CG().a(233, this);
        ar.CG().a(666, this);
    }

    public final void onPause() {
        x.i("MicroMsg.QBarStringHandler", "onPause");
        ar.CG().b(106, this);
        ar.CG().b(233, this);
        ar.CG().b(666, this);
    }

    private void a(Activity activity, int i, String str, boolean z) {
        int i2 = 2;
        x.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[]{str});
        if (i != 2) {
            i2 = 1;
        }
        k acVar = new ac(str, i2, 5, z);
        this.pZZ.put(acVar, Integer.valueOf(1));
        ar.CG().a(acVar, 0);
        activity.getString(R.l.dGO);
        this.kGT = com.tencent.mm.ui.base.h.a(activity, activity.getString(R.l.eHP), new 6(this, acVar));
    }

    private static int vK(int i) {
        if (i == 1) {
            return 34;
        }
        if (i == 0) {
            return 4;
        }
        if (i == 3) {
            return 42;
        }
        return 30;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            String str2 = "MicroMsg.QBarStringHandler";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            x.e(str2, str3, objArr);
            if (this.pZY != null) {
                this.pZY.m(2, null);
                return;
            }
            return;
        }
        if (!this.pZZ.containsKey(kVar)) {
            if (kVar instanceof aa) {
                x.e("MicroMsg.QBarStringHandler", "emotion scan scene");
            } else {
                x.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                return;
            }
        }
        this.pZZ.remove(kVar);
        if (this.kGT != null) {
            this.kGT.dismiss();
            this.kGT = null;
        }
        if (i == 4 && i2 == -4) {
            com.tencent.mm.ui.base.h.a(this.mActivity, R.l.eBw, R.l.dGO, new 8(this));
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (ar.CG().Kn()) {
                    ar.CG().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (ab.bC(this.mActivity)) {
                    com.tencent.mm.pluginsdk.ui.k.eo(this.mActivity);
                } else {
                    Toast.makeText(this.mActivity, this.mActivity.getString(R.l.eiD, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.mActivity, this.mActivity.getString(R.l.eiE, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            if (this.pZY != null) {
                this.pZY.m(1, null);
            }
        } else if (i == 4 && i2 == -2004) {
            com.tencent.mm.ui.base.h.h(this.mActivity, R.l.eBr, R.l.dGO);
            if (this.pZY != null) {
                this.pZY.m(1, null);
            }
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.mActivity, this.mActivity.getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.pZY != null) {
                this.pZY.m(1, null);
            }
        } else if (kVar.getType() == 106) {
            bem So;
            com.tencent.mm.g.b.af WO;
            com.tencent.mm.ag.d jK;
            com.tencent.mm.ag.d.b bVar;
            Intent intent;
            Bundle bundle;
            ac acVar = (ac) kVar;
            if (!acVar.hOh) {
                bem So2 = acVar.So();
                if (com.tencent.mm.storage.x.Dn(So2.wvf) && So2.wvm != null && !bh.ov(So2.wvm.hvI) && com.tencent.mm.modelappbrand.a.it(So2.wvm.hvI)) {
                    int vK = this.moj > 0 ? this.moj : vK(this.pZV);
                    x.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{this.pZW, Integer.valueOf(this.pZV), Integer.valueOf(vK)});
                    final k lVar = new l(this.pZW, null, 43, 0, new byte[0]);
                    this.pZZ.put(lVar, Integer.valueOf(1));
                    ar.CG().a(lVar, 0);
                    if (this.kGT != null) {
                        this.kGT.dismiss();
                    }
                    Context context = this.mActivity;
                    this.mActivity.getString(R.l.dGO);
                    this.kGT = com.tencent.mm.ui.base.h.a(context, this.mActivity.getString(R.l.eBB), true, new OnCancelListener(this) {
                        final /* synthetic */ e qab;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ar.CG().c(lVar);
                            if (this.qab.pZY != null) {
                                this.qab.pZY.m(1, null);
                            }
                        }
                    });
                    obj = 1;
                    if (obj == null) {
                        So = ((ac) kVar).So();
                        str3 = n.a(So.vYI);
                        x.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + So.vYI);
                        com.tencent.mm.ad.n.Jz().f(str3, n.a(So.vHb));
                        if (this.kGT != null && this.kGT.isShowing()) {
                            x.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                            this.kGT.dismiss();
                        }
                        if (bh.ou(str3).length() <= 0) {
                            ar.Hg();
                            WO = c.EY().WO(str3);
                            if (WO != null && com.tencent.mm.l.a.fZ(WO.field_type) && WO.cia()) {
                                jK = y.Mf().jK(str3);
                                jK.bI(false);
                                bVar = jK.hoq;
                                if (bVar.hou != null) {
                                    bVar.hoK = bVar.hou.optInt("ScanQRCodeType", 0);
                                }
                                if (!((bVar.hoK != 1 ? 1 : null) == null || jK.Le())) {
                                    intent = new Intent();
                                    intent.putExtra("Chat_User", str3);
                                    intent.putExtra("finish_direct", true);
                                    com.tencent.mm.plugin.scanner.b.ifs.e(intent, this.mActivity);
                                    obj = 1;
                                }
                            }
                            switch (this.pZV) {
                                case 0:
                                case 2:
                                    vK = 30;
                                    break;
                                case 1:
                                    vK = 45;
                                    break;
                                default:
                                    vK = 30;
                                    break;
                            }
                            Intent intent2 = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent2, So, vK);
                            if (!(WO == null || com.tencent.mm.l.a.fZ(WO.field_type))) {
                                intent2.putExtra("Contact_IsLBSFriend", true);
                            }
                            if ((So.wvf & 8) > 0) {
                                g.pQN.k(10298, str3 + "," + vK);
                            }
                            if (this.mActivity != null) {
                                com.tencent.mm.plugin.scanner.b.ifs.d(intent2, this.mActivity);
                                g gVar = g.pQN;
                                Object[] objArr2 = new Object[6];
                                objArr2[0] = Integer.valueOf(com.tencent.mm.storage.x.Dn(So.wvf) ? 0 : 1);
                                objArr2[1] = Integer.valueOf(this.fqd);
                                objArr2[2] = Integer.valueOf(this.pZV);
                                objArr2[3] = this.imagePath;
                                objArr2[4] = this.pZW;
                                objArr2[5] = bh.ou(this.fqg);
                                gVar.h(14268, objArr2);
                            }
                            obj = 1;
                        } else {
                            if (this.mActivity != null) {
                                Toast.makeText(this.mActivity, R.l.eIi, 0).show();
                            }
                            obj = null;
                        }
                        if (obj == null) {
                            if (this.pZY != null) {
                                bundle = new Bundle();
                                bundle.putString("geta8key_fullurl", n.a(((ac) kVar).So().vYI));
                                bundle.putInt("geta8key_action_code", 4);
                                this.pZY.m(3, bundle);
                            }
                        } else if (this.pZY != null) {
                            this.pZY.m(1, null);
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                So = ((ac) kVar).So();
                str3 = n.a(So.vYI);
                x.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + So.vYI);
                com.tencent.mm.ad.n.Jz().f(str3, n.a(So.vHb));
                x.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                this.kGT.dismiss();
                if (bh.ou(str3).length() <= 0) {
                    if (this.mActivity != null) {
                        Toast.makeText(this.mActivity, R.l.eIi, 0).show();
                    }
                    obj = null;
                } else {
                    ar.Hg();
                    WO = c.EY().WO(str3);
                    jK = y.Mf().jK(str3);
                    jK.bI(false);
                    bVar = jK.hoq;
                    if (bVar.hou != null) {
                        bVar.hoK = bVar.hou.optInt("ScanQRCodeType", 0);
                    }
                    if (bVar.hoK != 1) {
                    }
                    intent = new Intent();
                    intent.putExtra("Chat_User", str3);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.scanner.b.ifs.e(intent, this.mActivity);
                    obj = 1;
                }
                if (obj == null) {
                    if (this.pZY != null) {
                        this.pZY.m(1, null);
                    }
                } else if (this.pZY != null) {
                    bundle = new Bundle();
                    bundle.putString("geta8key_fullurl", n.a(((ac) kVar).So().vYI));
                    bundle.putInt("geta8key_action_code", 4);
                    this.pZY.m(3, bundle);
                }
            }
        } else if (kVar.getType() == 233) {
            int i3;
            String RE = ((l) kVar).RE();
            Bundle bundle2 = new Bundle();
            bundle2.putString("geta8key_fullurl", RE);
            bundle2.putInt("geta8key_action_code", ((l) kVar).RG());
            if (this.pZY != null) {
                this.pZY.m(4, bundle2);
            }
            if (this.moj > 0) {
                i3 = this.moj;
            } else {
                i3 = vK(this.pZV);
            }
            x.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[]{Integer.valueOf(i3)});
            boolean a = com.tencent.mm.plugin.ac.a.c.a(this, (l) kVar, new OnClickListener(this) {
                final /* synthetic */ e qab;

                {
                    this.qab = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.qab.pZY != null) {
                        this.qab.pZY.m(1, null);
                    }
                }
            }, this.pZW, i3, this.pZV, new 10(this), this.pZX);
            if (a || ((l) kVar).RG() != 4) {
                x.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[]{Boolean.valueOf(a)});
                if (!a && this.pZY != null) {
                    this.pZY.m(1, null);
                    return;
                }
                return;
            }
            a(this.mActivity, this.pZV, RE, true);
        } else if (kVar.getType() != 666) {
        } else {
            if (i != 0 || i2 != 0) {
                x.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
            } else if (kVar instanceof aa) {
                x.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[]{((aa) kVar).Sm().vIR});
                Intent intent3 = new Intent();
                intent3.putExtra("extra_id", r0);
                intent3.putExtra("preceding_scence", 11);
                intent3.putExtra("download_entrance_scene", 14);
                d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", intent3);
                x.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
                if (this.pZY != null) {
                    this.pZY.m(3, null);
                }
            }
        }
    }

    public final Context getContext() {
        return this.mActivity;
    }

    public final void hs(boolean z) {
        if (z) {
            if (this.pZY != null) {
                this.pZY.m(1, null);
            }
        } else if (this.pZY != null) {
            this.pZY.m(3, null);
        }
    }
}
