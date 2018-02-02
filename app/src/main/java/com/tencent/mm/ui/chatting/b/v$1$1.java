package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.l;
import com.tencent.mm.aq.n;
import com.tencent.mm.aq.o;
import com.tencent.mm.k.b;
import com.tencent.mm.l.a;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.v.1;
import com.tencent.mm.ui.chatting.b.v.2;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;

class v$1$1 implements Runnable {
    final /* synthetic */ 1 yBd;

    v$1$1(1 1) {
        this.yBd = 1;
    }

    public final void run() {
        ar.Dm().tS();
        v vVar = this.yBd.yBc;
        Intent intent = this.yBd.kvq;
        String str = this.yBd.yBb;
        if (intent != null) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            l.bj(intent.getLongExtra("KSelectImgUseTime", 0));
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                x.e("MicroMsg.ChattingUI.SendImgImp", "send image list is null or nil");
            } else {
                ArrayList lp;
                x.i("MicroMsg.ChattingUI.SendImgImp", "sendMutiImage rawUserName:%s %s", new Object[]{vVar.fhr.csk(), stringArrayListExtra.toString()});
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("GalleryUI_ImgIdList");
                if (integerArrayListExtra == null || (integerArrayListExtra.size() == 1 && ((Integer) integerArrayListExtra.get(0)).intValue() == -1)) {
                    lp = n.Pn().lp(str);
                } else {
                    lp = integerArrayListExtra;
                }
                if (intent == null || stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    x.e("MicroMsg.ChattingUI.SendImgImp", "filelist is empty!");
                } else {
                    boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (booleanExtra2) {
                        g.pQN.h(11095, new Object[]{Integer.valueOf(1)});
                    } else {
                        g.pQN.h(11095, new Object[]{Integer.valueOf(0)});
                    }
                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                    x.i("MicroMsg.ChattingUI.SendImgImp", "dkimgsource source:%d  isTakePhoto:%b rotateCount:%d compressImg:%b rawUserName:%s", new Object[]{Integer.valueOf(3), Boolean.valueOf(booleanExtra), Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra2), vVar.fhr.csk()});
                    if (vVar.fhr.csw() == null || vVar.fhr.csw().isEnable()) {
                        LatLongData latLongData;
                        if (booleanExtra) {
                            latLongData = (LatLongData) intent.getParcelableExtra("KlatLng");
                            if (latLongData != null) {
                                x.d("MicroMsg.ChattingUI.SendImgImp", "latLongData %f %f", new Object[]{Float.valueOf(latLongData.fzt), Float.valueOf(latLongData.hBL)});
                                g gVar = g.pQN;
                                Object[] objArr = new Object[4];
                                objArr[0] = Integer.valueOf((int) (latLongData.fzt * 1000000.0f));
                                objArr[1] = Integer.valueOf((int) (latLongData.hBL * 1000000.0f));
                                objArr[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                objArr[3] = Integer.valueOf(1);
                                gVar.h(11345, objArr);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int zD = b.zD();
                        int zF = b.zF();
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            if (str2 == null || str2.equals("") || !e.bO(str2)) {
                                x.d("MicroMsg.ChattingUI.SendImgImp", " doSendImage : filePath is null or empty");
                            } else {
                                if (!booleanExtra) {
                                    latLongData = ExifHelper.UK(str2);
                                    if (latLongData != null) {
                                        x.i("MicroMsg.ChattingUI.SendImgImp", "latLongData %f %f", new Object[]{Float.valueOf(latLongData.fzt), Float.valueOf(latLongData.hBL)});
                                        g gVar2 = g.pQN;
                                        Object[] objArr2 = new Object[4];
                                        objArr2[0] = Integer.valueOf((int) (latLongData.fzt * 1000000.0f));
                                        objArr2[1] = Integer.valueOf((int) (latLongData.hBL * 1000000.0f));
                                        objArr2[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                        objArr2[3] = Integer.valueOf(1);
                                        gVar2.h(11345, objArr2);
                                    } else {
                                        x.d("MicroMsg.ChattingUI.SendImgImp", "cannot get location");
                                    }
                                }
                                if (!vVar.yvQ.a(str, str2, arrayList2, zD, zF)) {
                                    arrayList.add(str2);
                                }
                            }
                        }
                        if (!g.V(vVar.fhr.csi())) {
                            int i = 98;
                            if (booleanExtra) {
                                i = intent.getBooleanExtra("is_long_click", false) ? 99 : 97;
                            }
                            g.pQN.a(106, (long) i, 1, false);
                            g.pQN.a(106, booleanExtra2 ? 94 : 95, 1, false);
                            if (arrayList.size() > 0) {
                                if (lp == null || lp.size() <= 0) {
                                    o.Pu().a(vVar.fhr.csv(), str, arrayList, intExtra, booleanExtra2, R.g.bAH);
                                } else {
                                    o.Pu().a(lp, vVar.fhr.csv(), str, arrayList, intExtra, booleanExtra2, R.g.bAH);
                                }
                            }
                            if (arrayList2.size() > 0) {
                                o.Pu().a(vVar.fhr.csv(), str, arrayList2, intExtra, booleanExtra2, R.g.bAH);
                            }
                            vVar.fhr.mM(true);
                            vVar.fhr.css().post(new 2(vVar));
                        }
                    } else {
                        h.b(vVar.fhr.csq().getContext(), vVar.fhr.csw().xzU.XH("").equalsIgnoreCase("@t.qq.com") ? vVar.fhr.csq().getMMString(R.l.ejj) : vVar.fhr.csq().getMMString(R.l.ejh, new Object[]{a.fb(vVar.fhr.csw().name)}), vVar.fhr.csq().getMMString(R.l.dGO), true);
                    }
                }
            }
        }
        ad adVar = this.yBd.yBc.yvS;
        Intent intent2 = this.yBd.kvq;
        if (intent2 != null) {
            ArrayList stringArrayListExtra2 = intent2.getStringArrayListExtra("key_select_video_list");
            if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                x.e("MicroMsg.ChattingUI.VideoImp", "send video list is null or nil");
            } else if (ab.bC(adVar.fhr.csq().getContext())) {
                adVar.aj(stringArrayListExtra2);
            } else {
                h.a(adVar.fhr.csq().getContext(), R.l.eSZ, R.l.dGO, new ad$3(adVar, stringArrayListExtra2), null);
            }
        }
        if (this.yBd.yBc.fhr.csC() != null) {
            this.yBd.yBc.fhr.csC().j(this.yBd.pa, this.yBd.kvq);
        }
        ar.Dm().cfE();
    }
}
