package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.order.model.a.a {
    public c pcG;

    static /* synthetic */ void a(Context context, String str, MallTransactionObject mallTransactionObject) {
        String az;
        Intent intent = new Intent();
        Uri parse = Uri.parse(str);
        String str2 = mallTransactionObject.fuI;
        String deviceID = q.getDeviceID(context);
        String str3 = "bssid";
        String str4 = d.DEVICE_TYPE;
        String str5 = Build.MODEL;
        String yT = q.yT();
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                az = bh.az(connectionInfo.getBSSID(), "");
                x.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", new Object[]{parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", az).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", yT).build().toString()});
                intent.putExtra("rawUrl", az);
                intent.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
                com.tencent.mm.bm.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        }
        az = str3;
        x.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", new Object[]{parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", az).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", yT).build().toString()});
        intent.putExtra("rawUrl", az);
        intent.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
        com.tencent.mm.bm.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public final List<Preference> a(final Context context, f fVar, final MallTransactionObject mallTransactionObject) {
        Object obj;
        CharSequence string;
        f fVar2;
        com.tencent.mm.l.a WO;
        h hVar;
        List<Preference> arrayList = new ArrayList();
        if (mallTransactionObject.fjw == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(bh.ov(mallTransactionObject.paB) || bh.ov(mallTransactionObject.iOg))) {
            d dVar = new d(context);
            dVar.lRA = mallTransactionObject.iOg;
            dVar.mName = mallTransactionObject.paB;
            dVar.mOnClickListener = new 1(this, mallTransactionObject, context);
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.pdg = e.d(mallTransactionObject.ljg, mallTransactionObject.paz);
        if (obj != null) {
            string = context.getString(i.uTg);
        } else if (mallTransactionObject.pak == 11) {
            string = context.getString(i.uTG);
        } else {
            string = context.getString(i.uTf);
        }
        iVar.setTitle(string);
        if (!bh.ov(mallTransactionObject.par)) {
            iVar.Hp(mallTransactionObject.par);
        }
        arrayList.add(iVar);
        boolean z = false;
        if (mallTransactionObject.ljg != mallTransactionObject.paF) {
            h hVar2 = new h(context);
            hVar2.pdd = false;
            hVar2.pde = true;
            arrayList.add(hVar2);
            fVar2 = new f(context);
            fVar2.setContent(e.d(mallTransactionObject.paF, mallTransactionObject.paz));
            fVar2.setTitle(i.uTy);
            arrayList.add(fVar2);
            z = true;
        }
        if (!(mallTransactionObject.ljg == mallTransactionObject.paF || bh.ov(mallTransactionObject.paE))) {
            g gVar = new g(context);
            gVar.setTitle(i.uTn);
            gVar.jKn = fVar;
            String[] split = mallTransactionObject.paE.split("\n");
            if (split.length == 1) {
                gVar.pcW = split[0];
            } else {
                gVar.pcW = context.getString(i.uTo, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.paF - mallTransactionObject.ljg, mallTransactionObject.paz)});
                gVar.a(split, TruncateAt.MIDDLE);
            }
            arrayList.add(gVar);
        }
        h hVar3 = new h(context);
        hVar3.pdd = z;
        hVar3.pde = true;
        arrayList.add(hVar3);
        if (obj == null && !bh.ov(mallTransactionObject.paO)) {
            g.Dk();
            WO = ((h) g.h(h.class)).EY().WO(mallTransactionObject.paO);
            if (WO != null && ((int) WO.gJd) > 0) {
                String AQ = WO.AQ();
                f fVar3 = new f(context);
                fVar3.setTitle(i.uzD);
                fVar3.setContent(AQ);
                arrayList.add(fVar3);
            }
        }
        if (!(mallTransactionObject.pak != 31 || obj == null || bh.ov(mallTransactionObject.paV))) {
            g.Dk();
            WO = ((h) g.h(h.class)).EY().WO(mallTransactionObject.paV);
            if (WO != null && ((int) WO.gJd) > 0) {
                AQ = WO.AQ();
                fVar3 = new f(context);
                fVar3.setTitle(i.uTw);
                fVar3.setContent(AQ);
                arrayList.add(fVar3);
            }
        }
        if (!bh.ov(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar2 = new f(context);
                if (mallTransactionObject.pak == 32 || mallTransactionObject.pak == 33 || mallTransactionObject.pak == 31) {
                    fVar2.setTitle(i.uTk);
                } else {
                    fVar2.setTitle(i.uTw);
                }
                fVar2.setContent(mallTransactionObject.desc);
                arrayList.add(fVar2);
            } else {
                fVar2 = new f(context);
                if (mallTransactionObject.pak == 31) {
                    fVar2.setTitle(i.uTC);
                } else {
                    fVar2.setTitle(i.uzl);
                }
                if (bh.ov(mallTransactionObject.pap)) {
                    fVar2.setContent(mallTransactionObject.desc);
                } else {
                    String string2 = context.getString(i.uTj);
                    fVar2.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new 2(this, mallTransactionObject, fVar2, fVar));
                }
                arrayList.add(fVar2);
            }
        }
        if (!bh.ov(mallTransactionObject.paZ)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uzL);
            fVar2.setContent(mallTransactionObject.paZ);
            arrayList.add(fVar2);
        }
        if (!bh.ov(mallTransactionObject.paY)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uTR);
            fVar2.setContent(mallTransactionObject.paY);
            arrayList.add(fVar2);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.paQ)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uTi);
            fVar2.setContent(mallTransactionObject.paQ);
            arrayList.add(fVar2);
        }
        if (!bh.ov(mallTransactionObject.pao)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uTx);
            fVar2.setContent(mallTransactionObject.pao);
            arrayList.add(fVar2);
        }
        if (!bh.ov(mallTransactionObject.pat)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uTJ);
            if (mallTransactionObject.pak != 31 || com.tencent.mm.z.q.FS().equals(mallTransactionObject.paO) || mallTransactionObject.paP <= 0 || bh.ov(mallTransactionObject.paO) || bh.ov(mallTransactionObject.fuI)) {
                fVar2.setContent(mallTransactionObject.pat);
                if (!bh.ov(mallTransactionObject.pau)) {
                    fVar2.Ho(mallTransactionObject.pau);
                }
            } else {
                string2 = context.getString(i.uOc);
                fVar2.a(mallTransactionObject.pat + " " + string2, mallTransactionObject.pat.length() + 1, (string2.length() + mallTransactionObject.pat.length()) + 1, new 3(this, context, mallTransactionObject));
            }
            arrayList.add(fVar2);
        }
        fVar2 = new f(context);
        fVar2.setTitle(i.uTm);
        fVar2.setContent(e.HD(mallTransactionObject.hzW));
        arrayList.add(fVar2);
        if (!bh.ov(mallTransactionObject.pax)) {
            f fVar4 = new f(context);
            fVar4.setTitle(i.uTz);
            AQ = mallTransactionObject.pax;
            if (!bh.ov(mallTransactionObject.pay)) {
                AQ = AQ + "(" + mallTransactionObject.pay + ")";
            }
            fVar4.setContent(AQ);
            arrayList.add(fVar4);
        }
        if (!bh.ov(mallTransactionObject.fuI)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uzJ);
            fVar2.setContent(mallTransactionObject.fuI);
            arrayList.add(fVar2);
        }
        if (!bh.ov(mallTransactionObject.paw)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uTH);
            if (mallTransactionObject.pak == 8) {
                fVar2.setContent(context.getString(i.uTI));
                c cVar = new c(context);
                final Bitmap b = com.tencent.mm.bs.a.a.b(context, mallTransactionObject.paw, 5, 0);
                cVar.pcO = e.aaE(mallTransactionObject.paw);
                cVar.hkT = b;
                cVar.mOnClickListener = new OnClickListener(this) {
                    final /* synthetic */ a pcI;

                    public final void onClick(View view) {
                        if (this.pcI.pcG != null) {
                            a aVar = this.pcI;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.paw;
                            if (aVar.pcG != null) {
                                aVar.pcG.fS(str, str);
                                aVar.pcG.oXQ = bitmap;
                                aVar.pcG.oXR = bitmap;
                                aVar.pcG.cBV();
                            }
                            this.pcI.pcG.u(view, true);
                        }
                    }
                };
                arrayList.add(fVar2);
                arrayList.add(cVar);
            } else {
                fVar2.setContent(mallTransactionObject.paw);
                arrayList.add(fVar2);
            }
        }
        Object obj2 = mallTransactionObject.oZZ.size() == 0 ? null : 1;
        if (obj2 != null || (bh.ov(mallTransactionObject.paJ) && bh.ov(mallTransactionObject.paA) && bh.ov(mallTransactionObject.pac))) {
            hVar = new h(context);
            hVar.pdd = true;
            hVar.kej = false;
            arrayList.add(hVar);
        } else {
            hVar = new h(context);
            hVar.pdd = true;
            arrayList.add(hVar);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (obj2 != null) {
            j jVar = new j(context);
            if (mallTransactionObject.paa == 1) {
                if (!(bh.ov(mallTransactionObject.paJ) && bh.ov(mallTransactionObject.paA) && bh.ov(mallTransactionObject.pac))) {
                    if (bh.ov(mallTransactionObject.paK)) {
                        jVar.pdh = context.getString(i.uTN);
                    } else {
                        jVar.pdh = mallTransactionObject.paK;
                    }
                    jVar.pdi = new OnClickListener(this) {
                        final /* synthetic */ a pcI;

                        public final void onClick(View view) {
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!bh.ov(mallTransactionObject.paA)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(i.uTL));
                            }
                            if (!bh.ov(mallTransactionObject.pac)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(i.uTM));
                            }
                            if (!bh.ov(mallTransactionObject.paJ)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(i.uTO));
                            }
                            if (linkedList2.size() == 1) {
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                return;
                            }
                            com.tencent.mm.ui.base.h.a(context, null, linkedList, linkedList2, null, true, new 1(this));
                        }
                    };
                }
            } else if (!bh.ov(mallTransactionObject.paK)) {
                jVar.pdh = mallTransactionObject.paK;
                jVar.pdi = new OnClickListener(this) {
                    final /* synthetic */ a pcI;

                    public final void onClick(View view) {
                        a.a(context, mallTransactionObject.paJ, mallTransactionObject);
                    }
                };
            }
            jVar.oZZ = mallTransactionObject.oZZ;
            jVar.mOnClickListener = new 7(this, context, mallTransactionObject);
            hVar = new h(context);
            hVar.pdd = true;
            arrayList.add(hVar);
            arrayList.add(jVar);
        }
        return arrayList;
    }
}
