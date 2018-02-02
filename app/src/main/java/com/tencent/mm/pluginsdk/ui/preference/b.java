package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.j;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.b.ca;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import junit.framework.Assert;

public final class b {
    public boolean fLH;
    public String fpL;
    public String hef;
    public long id;
    public String pjU;
    public int qra;
    public String username;
    public String vtm;

    public static b a(Context context, f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        long j = fVar.xjy;
        boolean To = fVar.To();
        String str7 = fVar.field_talker;
        String str8 = fVar.field_msgContent;
        int i = fVar.field_type;
        int i2 = 0;
        if (i == 0) {
            a Xr = a.Xr(str8);
            str = Xr.rYX;
            str2 = Xr.fpL;
            str3 = Xr.xzj;
            str4 = Xr.xzk;
            i2 = Xr.scene;
            str5 = null;
        } else if (To) {
            d Xu = d.Xu(str8);
            str = Xu.rYX;
            str2 = Xu.fpL;
            str5 = Xu.content;
            if (Xu.xzv == 1) {
                str4 = null;
                str3 = null;
                str6 = Xu.xzx;
            } else {
                str4 = null;
                str3 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        b a = a(context, j, To, str7, str8, i, str, str2, str3, str4, str5, i2);
        a.vtm = str6;
        return a;
    }

    public static b a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        b bVar = new b();
        bVar.id = j;
        bVar.fLH = !z;
        x.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        if (i == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.fpL = str4;
                switch (i2) {
                    case 4:
                        bVar.hef = context.getString(R.l.dQR);
                        break;
                    case 10:
                    case 11:
                        com.tencent.mm.sdk.b.b fnVar = new fn();
                        fnVar.fuR.fuO = str5;
                        fnVar.fuR.fuP = str6;
                        com.tencent.mm.sdk.b.a.xef.m(fnVar);
                        bVar.hef = context.getString(R.l.dQU, new Object[]{bh.az(fnVar.fuS.fuT, "")});
                        break;
                    case 31:
                        bVar.hef = context.getString(R.l.dRd);
                        break;
                    case 32:
                        bVar.hef = context.getString(R.l.dQX);
                        break;
                    case 58:
                    case 59:
                    case 60:
                        bVar.pjU = a.Xr(str2).pjU;
                        bVar.hef = context.getString(R.l.dQS);
                        break;
                    default:
                        bVar.hef = context.getString(R.l.dQW);
                        break;
                }
            }
            x.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + str);
            return null;
        } else if (z) {
            bVar.username = str3;
            bVar.fpL = str4;
            if (str7 == null || str7.trim().equals("")) {
                bVar.hef = context.getString(R.l.eig);
            } else {
                bVar.hef = str7;
            }
        } else {
            bVar.username = str;
            bVar.hef = str2;
        }
        return bVar;
    }

    public static b a(Context context, ca caVar) {
        x.d("MicroMsg.FMessageProvider", "build lbs, talker = " + caVar.field_sayhiuser + ", scene = " + caVar.field_scene);
        b bVar = new b();
        bVar.id = caVar.xjy;
        bVar.fLH = caVar.field_isSend == 1;
        bVar.username = caVar.field_sayhiuser;
        bVar.qra = caVar.field_scene;
        if (caVar.field_isSend == 1) {
            bVar.hef = caVar.field_content;
        } else {
            d Xu = d.Xu(caVar.field_content);
            if (Xu.content == null || Xu.content.trim().equals("")) {
                bVar.hef = context.getString(R.l.dRf);
            } else {
                bVar.hef = Xu.content;
            }
            bVar.fpL = Xu.fpL;
        }
        return bVar;
    }

    public static b a(Context context, j jVar) {
        x.d("MicroMsg.FMessageProvider", "build shake, talker = " + jVar.field_talker + ", scene = " + jVar.field_scene);
        b bVar = new b();
        bVar.id = jVar.xjy;
        bVar.fLH = jVar.field_isSend == 1;
        bVar.username = jVar.field_sayhiuser;
        bVar.qra = jVar.field_scene;
        if (jVar.field_isSend == 1) {
            bVar.hef = jVar.field_content;
        } else {
            d Xu = d.Xu(jVar.field_content);
            if (Xu.content == null || Xu.content.trim().equals("")) {
                bVar.hef = context.getString(R.l.dRf);
            } else {
                bVar.hef = Xu.content;
            }
            bVar.fpL = Xu.fpL;
        }
        return bVar;
    }

    public static b[] a(Context context, f[] fVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (fVarArr == null || fVarArr.length == 0 || fVarArr[0] == null) ? "null" : fVarArr[0].field_talker;
        x.d(str, stringBuilder.append(str2).toString());
        if (fVarArr == null || fVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            return null;
        }
        b[] bVarArr = new b[fVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, fVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, ca[] caVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (caVarArr == null || caVarArr.length == 0 || caVarArr[0] == null) ? "null" : caVarArr[0].field_sayhiuser;
        x.d(str, stringBuilder.append(str2).toString());
        if (caVarArr == null || caVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            return null;
        }
        b[] bVarArr = new b[caVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, caVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, j[] jVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (jVarArr == null || jVarArr.length == 0 || jVarArr[0] == null) ? "null" : jVarArr[0].field_sayhiuser;
        x.d(str, stringBuilder.append(str2).toString());
        if (jVarArr == null || jVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            return null;
        }
        b[] bVarArr = new b[jVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, jVarArr[i]);
        }
        return bVarArr;
    }

    public static void aT(String str, int i) {
        f[] fVarArr;
        h[] hVarArr;
        b[] a;
        j[] jVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            x.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            j[] nf = l.Tz().nf(str);
            fVarArr = null;
            hVarArr = null;
            a = a(ac.getContext(), nf);
            jVarArr = nf;
        } else if (i == 18) {
            x.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
            ca[] na = l.Ty().na(str);
            fVarArr = null;
            ca[] caVarArr = na;
            a = a(ac.getContext(), na);
            jVarArr = null;
        } else {
            f[] mV = l.Tw().mV(str);
            fVarArr = mV;
            hVarArr = null;
            a = a(ac.getContext(), mV);
            jVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                b bVar = a[i3];
                au auVar = new au();
                auVar.setContent(bVar.hef);
                int hp = s.hp(bVar.username);
                if (fVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(fVarArr[i2].field_createTime);
                } else if (hVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(hVarArr[i2].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(jVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                auVar.dS(bVar.username);
                auVar.setType(hp);
                if (bVar.fLH) {
                    auVar.eQ(2);
                    auVar.eR(1);
                } else {
                    auVar.eQ(6);
                    auVar.eR(0);
                }
                ar.Hg();
                long Q = c.Fa().Q(auVar);
                Assert.assertTrue(Q != -1);
                x.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + Q);
                i3++;
                i2 = i4;
            }
            au auVar2 = new au();
            if (fVarArr != null) {
                auVar2.aq(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr != null) {
                auVar2.aq((hVarArr[hVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                auVar2.aq((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            auVar2.dS(str);
            auVar2.setContent(ac.getContext().getString(R.l.eRx));
            auVar2.setType(10000);
            auVar2.eQ(6);
            auVar2.eR(0);
            ar.Hg();
            x.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + c.Fa().Q(auVar2));
        }
    }

    public static com.tencent.mm.storage.x b(f fVar) {
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        if (fVar == null) {
            return xVar;
        }
        if (fVar.field_type == 0) {
            a Xr = a.Xr(fVar.field_msgContent);
            xVar = new com.tencent.mm.storage.x();
            xVar.setUsername(Xr.rYX);
            xVar.cZ(Xr.gfN);
            xVar.dc(Xr.getDisplayName());
            xVar.dd(Xr.hwU);
            xVar.de(Xr.hwV);
            xVar.eD(Xr.fWf);
            xVar.dq(Xr.getProvince());
            xVar.dr(Xr.getCity());
            xVar.dp(Xr.signature);
            xVar.ez(Xr.tmE);
            xVar.du(Xr.fWu);
            xVar.dD(Xr.vtc);
            return xVar;
        }
        d Xu = d.Xu(fVar.field_msgContent);
        xVar = new com.tencent.mm.storage.x();
        xVar.setUsername(Xu.rYX);
        xVar.cZ(Xu.gfN);
        xVar.dc(Xu.fpL);
        xVar.dd(Xu.hwU);
        xVar.de(Xu.hwV);
        xVar.eD(Xu.fWf);
        xVar.dp(Xu.signature);
        xVar.dq(Xu.getProvince());
        xVar.dr(Xu.getCity());
        return xVar;
    }
}
