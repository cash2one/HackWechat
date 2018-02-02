package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.R;
import com.tencent.mm.bx.b;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.k;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import junit.framework.Assert;
import org.xwalk.core.R$styleable;

public final class h {
    private static WeakReference<TextPaint> gAV;
    private static int gAW = 0;
    private static int gAX = 0;
    public String gAT = "";
    public String gAU = "";
    public String mTitle = "";

    public static String a(Context context, String str, String str2, int i) {
        return i.SH(b.cgX().Wj(a(0, str2, str, i, context)));
    }

    public static String g(Context context, String str, String str2) {
        String hP;
        if (s.eV(str)) {
            hP = ba.hP(str2);
            if (hP != null) {
                hP = r.gu(hP.trim());
            } else {
                hP = r.gu(str);
            }
        } else {
            hP = r.gu(str);
        }
        if (str.contains("@bottle")) {
            return context.getResources().getQuantityString(R.j.duE, 1, new Object[]{Integer.valueOf(1)});
        }
        if (bh.ov(hP) && s.eV(str)) {
            hP = context.getString(R.l.dSN);
        }
        return b.cgX().Wj(hP);
    }

    public static String b(x xVar) {
        Context context = ac.getContext();
        if (xVar == null) {
            return context.getString(R.l.dMZ);
        }
        String city;
        if (RegionCodeDecoder.XE(xVar.getCountryCode())) {
            city = xVar.getCity();
            if (!bh.ov(city)) {
                return city;
            }
            city = r.gw(xVar.getProvince());
            if (!bh.ov(city)) {
                return city;
            }
            RegionCodeDecoder.cjP();
            return RegionCodeDecoder.getLocName(xVar.getCountryCode());
        }
        city = r.gw(xVar.getProvince());
        return bh.ov(city) ? context.getString(R.l.dMZ) : city;
    }

    public static String b(au auVar, PString pString, PString pString2, PInt pInt, boolean z) {
        return bh.ou(a(auVar.field_imgPath, auVar.field_isSend, auVar.field_talker, i.SH(auVar.cjd() ? auVar.cjE() : auVar.field_content), auVar.getType(), ac.getContext(), pString, pString2, pInt, true, z));
    }

    public static String a(int i, String str, String str2, int i2, Context context) {
        return bh.ou(a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(String str, int i, String str2, String str3, int i2, Context context, PString pString, PString pString2, PInt pInt, boolean z, boolean z2) {
        Object obj;
        Throwable e;
        String[] split;
        String[] split2;
        Assert.assertTrue("context is null", context != null);
        String str4 = "username is null";
        boolean z3 = str2 != null && str2.length() > 0;
        Assert.assertTrue(str4, z3);
        if (!z) {
            if (!s.gK(str2) || q.Gk()) {
                if (s.gM(str2)) {
                    if (((q.FW() & 64) != 0 ? 1 : null) == null) {
                        obj = 1;
                    }
                }
                obj = (!s.gQ(str2) || q.Gn()) ? null : 1;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return context.getString(R.l.eMu);
            }
        }
        if (!s.gQ(str2)) {
            Object obj2;
            int hO;
            String substring;
            String str5;
            String str6;
            Object obj3;
            int indexOf;
            Object obj4;
            String str7;
            Object obj5;
            a fT;
            c EI;
            d Xu;
            au.a Xr;
            au.a EK;
            aj Xp;
            a fT2;
            a fT3;
            com.tencent.mm.y.b bVar;
            CharSequence Eq;
            String str8 = "";
            String str9 = "";
            str4 = "";
            if (str3 == null || !z) {
                obj2 = null;
            } else {
                str3 = ex(str3);
                obj2 = 1;
            }
            pString.value = str3;
            if (i == 0 && s.eV(str2)) {
                hO = ba.hO(str3);
                if (hO > 0) {
                    str9 = str3.substring(0, hO).trim();
                    str4 = r.L(str9, str2);
                    substring = (str3 + " ").substring(hO + 1);
                    str5 = str4;
                    str6 = str9;
                    obj3 = null;
                    if (!s.hd(str2) || s.hm(str2)) {
                        indexOf = str3.indexOf(":");
                        if (indexOf != -1) {
                            pString2.value = str3.substring(0, indexOf);
                            str3 = str3.substring(indexOf + 1);
                        }
                        obj4 = null;
                        str7 = str3;
                    } else {
                        ar.Hg();
                        ae WY = com.tencent.mm.z.c.Fd().WY(str2);
                        if ((WY != null && WY.gc(2097152)) || z2) {
                            obj3 = 1;
                            indexOf = str3.indexOf(":");
                            if (indexOf != -1) {
                                pString2.value = str3.substring(0, indexOf);
                                int i3 = 1;
                                str7 = str3.substring(indexOf + 1);
                            }
                        }
                        obj4 = obj3;
                        str7 = str3;
                    }
                    switch (i2) {
                        case -1879048191:
                        case -1879048190:
                        case -1879048189:
                            str7 = "";
                            substring = context.getString(R.l.dGZ);
                            str4 = null;
                            obj5 = null;
                            break;
                        case -1879048188:
                            str7 = "";
                            substring = context.getString(R.l.dHb);
                            str4 = null;
                            obj5 = null;
                            break;
                        case -1879048186:
                            fT = a.fT(bh.VH(substring));
                            if (fT == null) {
                                str = "";
                                substring = str6.length() <= 0 ? str6 + ": " + fT.title : fT.title;
                                if (!s.hd(str2) && r17 == null) {
                                    pString2.value = str6;
                                }
                                pString.value = str6.length() <= 0 ? "%s: " + fT.title : fT.title;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            }
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            return "";
                        case -1879048185:
                        case -1879048183:
                        case -1879048176:
                            str = context.getString(R.l.dDN);
                            substring = str6.length() <= 0 ? str6 + ": " : "";
                            if (!s.hd(str2) && r17 == null) {
                                pString2.value = str6;
                            }
                            pString.value = str6.length() <= 0 ? "%s: " : "";
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str;
                            break;
                        case 3:
                        case 23:
                        case 33:
                            str = context.getString(R.l.dGj);
                            substring = str6.length() <= 0 ? str6 + ": " : "";
                            pString.value = str6.length() <= 0 ? "%s: " : "";
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str;
                            break;
                        case 11:
                        case 36:
                            str4 = null;
                            obj5 = null;
                            str7 = a(context, i, str2, str7, null, pString, pString2);
                            substring = str8;
                            break;
                        case 13:
                        case 39:
                            str4 = null;
                            obj5 = null;
                            str7 = a(context, i, str2, str7, context.getString(R.l.dGj), pString, pString2);
                            substring = str8;
                            break;
                        case 34:
                            if (x.Wx(str2) && !x.Wz(str2) && !s.gK(str2) && !s.gM(str2)) {
                                if (!(str7 == null || str7.length() <= 0 || s.gL(str2))) {
                                    if (s.eV(str2)) {
                                        n nVar = new n(str7);
                                        str7 = nVar.hVz + ": ";
                                        pString.value = "%s:";
                                        pString2.value = nVar.hVz;
                                    } else {
                                        str7 = "";
                                    }
                                }
                                substring = context.getString(R.l.dGY);
                                str4 = null;
                                obj5 = null;
                                break;
                            }
                            str4 = null;
                            obj5 = null;
                            str7 = a(context, i, str2, str7, context.getString(R.l.dGY), pString, pString2);
                            substring = str8;
                            break;
                        case 35:
                            if (bh.ou(str7).length() > 0) {
                                ar.Hg();
                                EI = com.tencent.mm.z.c.Fa().EI(str7);
                                substring = context.getString(R.l.eiW, new Object[]{EI.hMK, EI.title});
                                pString.value = substring;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str8;
                                break;
                            }
                        case 37:
                            if (str7 != null && str7.length() > 0) {
                                Xu = d.Xu(str7);
                                if (Xu.rYX != null && Xu.rYX.length() > 0) {
                                    switch (Xu.scene) {
                                        case 18:
                                            str4 = null;
                                            obj5 = null;
                                            str7 = context.getString(R.l.ejd, new Object[]{Xu.getDisplayName()});
                                            substring = str8;
                                            break;
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                            str4 = null;
                                            obj5 = null;
                                            str7 = context.getString(R.l.ejn, new Object[]{Xu.getDisplayName()});
                                            substring = str8;
                                            break;
                                        case 25:
                                            substring = context.getString(R.l.eip, new Object[]{Xu.getDisplayName()});
                                            pString.value = substring;
                                            str4 = null;
                                            obj5 = null;
                                            str7 = substring;
                                            substring = str8;
                                            break;
                                        default:
                                            str7 = context.getString(R.l.ejt, new Object[]{Xu.getDisplayName()});
                                            pString.value = str7;
                                            break;
                                    }
                                }
                                substring = str8;
                                str4 = null;
                                obj5 = null;
                                break;
                            }
                        case 40:
                            if (str7 != null && str7.length() > 0) {
                                Xr = au.a.Xr(str7);
                                if (Xr.rYX != null && Xr.rYX.length() > 0) {
                                    str7 = context.getString(R.l.eiJ, new Object[]{Xr.getDisplayName()});
                                    pString.value = str7;
                                }
                                substring = str8;
                                str4 = null;
                                obj5 = null;
                                break;
                            }
                        case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                            if (bh.ou(str7).length() > 0) {
                                if (s.eV(str2)) {
                                    substring = ba.hP(str7);
                                    break;
                                }
                                substring = str2;
                                ar.Hg();
                                EK = com.tencent.mm.z.c.Fa().EK(str7);
                                ar.Hg();
                                str4 = com.tencent.mm.z.c.EY().WO(substring).AQ();
                                if (s.eV(str4)) {
                                    str4 = m.B(m.gm(str4));
                                }
                                if (i != 1) {
                                    str7 = context.getString(R.l.eir, new Object[]{str4, EK.getDisplayName()});
                                    pString.value = context.getString(R.l.eir, new Object[]{"%s", EK.getDisplayName()});
                                    pString2.value = substring;
                                    substring = str8;
                                    str4 = null;
                                    obj5 = null;
                                    break;
                                }
                                str7 = context.getString(R.l.eiq, new Object[]{str4, EK.getDisplayName()});
                                pString.value = context.getString(R.l.eiq, new Object[]{"%s", EK.getDisplayName()});
                                pString2.value = substring;
                                substring = str8;
                                str4 = null;
                                obj5 = null;
                                break;
                            }
                        case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                        case 62:
                            if (x.Wx(str2) && !x.Wz(str2) && !s.gK(str2) && !s.gM(str2)) {
                                if (!(str7 == null || str7.length() <= 0 || s.gL(str2))) {
                                    if (s.eV(str2)) {
                                        p pVar = new p(str7);
                                        str7 = pVar.hVz + ": ";
                                        pString.value = "%s:";
                                        pString2.value = pVar.hVz;
                                    } else {
                                        str7 = "";
                                    }
                                }
                                substring = context.getString(R.l.dGX);
                                str4 = null;
                                obj5 = null;
                                break;
                            }
                            str4 = null;
                            obj5 = null;
                            str7 = a(context, i, str2, str7, context.getString(R.l.dGX), pString, pString2);
                            substring = str8;
                            break;
                        case 47:
                        case 1048625:
                            Xp = aj.Xp(str7);
                            substring = Xp.hVz + ": ";
                            if (str == null || str.length() != 32) {
                                str = context.getString(R.l.dEG);
                            }
                            pString.value = "";
                            pString2.value = Xp.hVz;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str;
                            break;
                        case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (bh.ou(str7).length() > 0) {
                                if (s.eV(str2)) {
                                    str4 = str2;
                                } else {
                                    hO = ba.hO(str7);
                                    if (hO == -1) {
                                        substring = str7.substring(0, hO).trim();
                                    } else {
                                        substring = str2;
                                    }
                                    ba.hQ(str7);
                                    str4 = substring;
                                }
                                if (i != 1) {
                                    substring = context.getString(R.l.esY);
                                    pString.value = context.getString(R.l.esY);
                                    pString2.value = str4;
                                    str4 = null;
                                    obj5 = null;
                                    str7 = substring;
                                    substring = str8;
                                    break;
                                }
                                substring = context.getString(R.l.esY);
                                pString.value = substring;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str8;
                                break;
                            }
                        case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                        case 16777265:
                        case 268435505:
                        case 553648177:
                            substring = bh.VH(substring);
                            fT2 = a.fT(substring);
                            if (fT2 == null) {
                                switch (fT2.type) {
                                    case 1:
                                        str = "";
                                        substring = str6.length() <= 0 ? str6 + ": " + fT2.title : fT2.title;
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " + fT2.title : fT2.title;
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 2:
                                        str = context.getString(R.l.dGj);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 3:
                                        str = context.getString(R.l.dFJ);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        obj5 = 1;
                                        str4 = fT2.title;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 4:
                                        str = context.getString(R.l.dGX);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        obj5 = 1;
                                        str4 = fT2.title;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 5:
                                        str = context.getString(R.l.dGU);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!(s.hd(str2) || r17 != null || s.hm(str2))) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        obj5 = 1;
                                        str4 = fT2.getTitle();
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 6:
                                        str = context.getString(R.l.dFj);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        obj5 = 1;
                                        str4 = fT2.title;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 7:
                                        str = context.getString(R.l.dDN);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 8:
                                        str = context.getString(R.l.dEH);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 15:
                                    case 26:
                                    case 27:
                                        str = context.getString(R.l.dEI);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 16:
                                        str = "";
                                        str4 = context.getString(R.l.dOP);
                                        substring = str6.length() <= 0 ? str6 + ": " + str4 + fT2.title : str4 + fT2.title;
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        if (str6.length() > 0) {
                                            str4 = "%s: " + str4;
                                        }
                                        pString.value = str4;
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 17:
                                        str = "";
                                        substring = str6.length() <= 0 ? str6 + ": " + fT2.title : fT2.title;
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " + fT2.title : fT2.title;
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 19:
                                        str = context.getString(R.l.dGs);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 24:
                                        substring = "";
                                        if (!bh.ov(fT2.description)) {
                                            hO = fT2.description.indexOf("\n");
                                            str4 = fT2.description;
                                            if (hO <= 0) {
                                                hO = fT2.description.length();
                                            }
                                            substring = str4.substring(0, hO);
                                        }
                                        str = context.getString(R.l.egY) + substring;
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " : "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 25:
                                        str = context.getString(R.l.dEy);
                                        substring = str6.length() <= 0 ? str6 + ": " : "";
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                        }
                                        pString.value = "";
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 33:
                                    case 36:
                                        str = "";
                                        str4 = context.getString(R.l.dDR);
                                        substring = str6.length() <= 0 ? str6 + ": " + str4 + fT2.title : str4 + fT2.title;
                                        if (!(s.hd(str2) || r17 != null || s.hm(str2))) {
                                            pString2.value = str6;
                                        }
                                        pString.value = str6.length() <= 0 ? "%s: " + str4 + fT2.title : str4 + fT2.title;
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str;
                                        break;
                                    case 34:
                                        str = "";
                                        substring = context.getString(R.l.dOP);
                                        if (i != 1) {
                                            str4 = substring + fT2.hcr;
                                            pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                                        } else {
                                            str4 = substring + fT2.hcq;
                                            pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                                        }
                                        if (!s.hd(str2) && r17 == null) {
                                            pString2.value = str6;
                                            substring = str;
                                            obj5 = null;
                                            str7 = str4;
                                            str4 = null;
                                            break;
                                        }
                                    case 40:
                                        if (k.fX(substring).hea != 19) {
                                            substring = context.getString(R.l.dDN);
                                            str4 = null;
                                            obj5 = null;
                                            break;
                                        }
                                        substring = context.getString(R.l.dGs);
                                        str4 = null;
                                        obj5 = null;
                                        break;
                                    default:
                                        substring = context.getString(R.l.dDN);
                                        str7 = "";
                                        str4 = null;
                                        obj5 = null;
                                        break;
                                }
                            }
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            return "";
                        case 50:
                        case 53:
                            if (str7.equals(au.xzd)) {
                                if (str7.equals(au.xzc)) {
                                    str7 = "";
                                    substring = context.getString(R.l.dHb);
                                    str4 = null;
                                    obj5 = null;
                                    break;
                                }
                            }
                            str7 = "";
                            substring = context.getString(R.l.dHa);
                            str4 = null;
                            obj5 = null;
                            break;
                        case 52:
                            str7 = "";
                            substring = context.getString(R.l.dHa);
                            str4 = null;
                            obj5 = null;
                            break;
                        case 55:
                        case 57:
                            substring = com.tencent.mm.ah.a.b(com.tencent.mm.ah.a.a.ky(str7));
                            pString.value = substring;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str8;
                            break;
                        case 12299999:
                            str7 = "";
                            substring = context.getString(R.l.dHa);
                            str4 = null;
                            obj5 = null;
                            break;
                        case 285212721:
                            if (obj2 != null) {
                                str7 = ey(str7);
                            }
                            substring = ex(((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vK(str7));
                            pString.value = substring;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str8;
                            break;
                        case 318767153:
                            pString.value = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vJ(str7);
                            substring = pString.value;
                            str4 = null;
                            obj5 = null;
                            break;
                        case 335544369:
                            fT3 = a.fT(bh.VH(substring));
                            if (fT3.hbw != 0) {
                                if (fT3.hbw == 1) {
                                    substring = context.getString(R.l.eIc);
                                } else if (fT3.hbw == 2) {
                                    substring = context.getString(R.l.eIe);
                                } else if (fT3.hbw == 3) {
                                    substring = context.getString(R.l.eId);
                                }
                                str7 = "";
                                pString2.value = str6;
                                pString.value = "";
                                str4 = null;
                                obj5 = null;
                                break;
                            }
                            substring = context.getString(R.l.eIf);
                            str7 = "";
                            pString2.value = str6;
                            pString.value = "";
                            str4 = null;
                            obj5 = null;
                        case 369098801:
                            switch (a.fT(bh.VH(substring)).hbw) {
                                case 10000:
                                    substring = context.getString(R.l.dGm);
                                    break;
                                case HardCoderJNI.sHCENCODEVIDEOTIMEOUT /*20000*/:
                                    substring = context.getString(R.l.dGo);
                                    break;
                                default:
                                    substring = context.getString(R.l.dGl);
                                    break;
                            }
                            str4 = str6.length() <= 0 ? str6 + ": " : "";
                            if (!s.hd(str2) && r17 == null) {
                                pString2.value = str6;
                            }
                            pString.value = "";
                            obj5 = null;
                            str7 = str4;
                            str4 = null;
                            break;
                        case 402653233:
                            str4 = bh.VH(substring);
                            str = "";
                            substring = "";
                            fT = a.fT(str4);
                            if (fT != null) {
                                pString.value = context.getString(R.l.eIn) + bh.ou(fT.title);
                                substring = pString.value;
                            }
                            pString2.value = str6;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str;
                            break;
                        case 419430449:
                            str4 = bh.VH(substring);
                            str = "";
                            substring = "";
                            fT = a.fT(str4);
                            if (fT != null) {
                                obj = i != 1 ? 1 : null;
                                switch (fT.hcd) {
                                    case 1:
                                        if (obj == null) {
                                            pString.value = context.getString(R.l.dHj);
                                            break;
                                        }
                                        pString.value = context.getString(R.l.dHg);
                                        break;
                                    case 3:
                                        if (obj == null) {
                                            pString.value = context.getString(R.l.dHe);
                                            break;
                                        }
                                        pString.value = context.getString(R.l.dHh);
                                        break;
                                    case 4:
                                        if (obj == null) {
                                            pString.value = context.getString(R.l.dHf);
                                            break;
                                        }
                                        pString.value = context.getString(R.l.dHi);
                                        break;
                                    default:
                                        pString.value = bh.ou(fT.title);
                                        break;
                                }
                                substring = pString.value;
                            }
                            pString2.value = str6;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str;
                            break;
                        case 436207665:
                        case 469762097:
                            str4 = bh.VH(substring);
                            str = "";
                            substring = "";
                            fT = a.fT(str4);
                            if (fT != null) {
                                if (i != 1) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    pString.value = "[" + fT.hcE + "]" + fT.hcB;
                                } else if (bh.ov(str5)) {
                                    pString.value = bh.ou(str5) + ": [" + fT.hcE + "]" + fT.hcA;
                                } else {
                                    pString.value = "[" + fT.hcE + "]" + fT.hcA;
                                }
                                substring = pString.value;
                            }
                            if (!s.hd(str2) && r17 == null) {
                                pString2.value = str6;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            }
                        case 452984881:
                            fT = a.fT(bh.VH(substring));
                            if (fT == null) {
                                str = "";
                                str9 = context.getString(R.l.dOP);
                                substring = str6.length() <= 0 ? str6 + ": " + str9 + fT.title : str9 + fT.title;
                                if (!s.hd(str2) && r17 == null) {
                                    pString2.value = str6;
                                }
                                pString.value = str6.length() <= 0 ? "%s: " + str9 + fT.title : str9 + fT.title;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            }
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            return "";
                        case 503316529:
                            str7 = "";
                            fT3 = a.fT(substring);
                            if (fT3 != null) {
                                try {
                                    str7 = URLDecoder.decode(fT3.content, "UTF-8");
                                    substring = i.SH(str7);
                                    try {
                                        pString.value = substring;
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str8;
                                    } catch (Exception e2) {
                                        e = e2;
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Notification.Wording", e, "", new Object[0]);
                                        str4 = null;
                                        obj5 = null;
                                        str7 = substring;
                                        substring = str8;
                                        if (!s.gL(str2)) {
                                            if (bh.ov(str7)) {
                                                pString.value = "";
                                            }
                                            if (bh.ov(str6)) {
                                                str7 = h(str7, str6, str5);
                                                if (bh.ov(pString2.value)) {
                                                    pString.value = h(pString.value, str6, "%s");
                                                    pString2.value = str6;
                                                }
                                                str7 = com.tencent.mm.compatible.util.n.eN(str7);
                                                pString.value = com.tencent.mm.compatible.util.n.eN(pString.value);
                                                str7 = str7 + substring;
                                                pString.value += substring;
                                                if (z) {
                                                    if (pString.value.length() == 32) {
                                                        break;
                                                    }
                                                    obj = null;
                                                    if (obj == null) {
                                                        a(i2, pString, pString2, pInt);
                                                    }
                                                }
                                                if (obj5 == null) {
                                                    substring = str7.concat(" " + bh.ou(str4));
                                                } else {
                                                    substring = str7;
                                                }
                                                return bh.ou(substring);
                                            }
                                            if (!s.hd(str2)) {
                                            }
                                            str7 = substring;
                                            if (bh.ov(str7)) {
                                                if (i != 0) {
                                                    pString.value = "%s:" + str7;
                                                } else {
                                                    pString.value = context.getString(R.l.dFB) + ":" + str7;
                                                }
                                                if (!z) {
                                                    return r.gu(pString2.value) + ":" + str7;
                                                }
                                                a(i2, pString, pString2, pInt);
                                                substring = str7;
                                                substring = substring.concat(" " + str4);
                                                if (obj2 != null) {
                                                    substring = ey(substring);
                                                }
                                                return bh.ou(substring);
                                            }
                                            pString.value = "";
                                            pString2.value = "";
                                            return "";
                                        } else if (1 != i) {
                                            str4 = null;
                                            split = str7.split(":");
                                            if (split != null) {
                                                break;
                                            }
                                            pString.value = "";
                                            return null;
                                        } else if (bh.ov(substring)) {
                                            pString.value = substring;
                                            return substring;
                                        } else {
                                            split2 = str7.split("@bottle:");
                                            if (split2.length <= 1) {
                                                pString.value = split2[1];
                                                return split2[1];
                                            }
                                            pString.value = "";
                                            return null;
                                        }
                                    }
                                } catch (Throwable e3) {
                                    e = e3;
                                    substring = str7;
                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Notification.Wording", e, "", new Object[0]);
                                    str4 = null;
                                    obj5 = null;
                                    str7 = substring;
                                    substring = str8;
                                    if (!s.gL(str2)) {
                                        if (bh.ov(str7)) {
                                            pString.value = "";
                                        }
                                        if (bh.ov(str6)) {
                                            if (s.hd(str2)) {
                                            }
                                            str7 = substring;
                                            if (bh.ov(str7)) {
                                                if (i != 0) {
                                                    pString.value = context.getString(R.l.dFB) + ":" + str7;
                                                } else {
                                                    pString.value = "%s:" + str7;
                                                }
                                                if (!z) {
                                                    return r.gu(pString2.value) + ":" + str7;
                                                }
                                                a(i2, pString, pString2, pInt);
                                                substring = str7;
                                                substring = substring.concat(" " + str4);
                                                if (obj2 != null) {
                                                    substring = ey(substring);
                                                }
                                                return bh.ou(substring);
                                            }
                                            pString.value = "";
                                            pString2.value = "";
                                            return "";
                                        }
                                        str7 = h(str7, str6, str5);
                                        if (bh.ov(pString2.value)) {
                                            pString.value = h(pString.value, str6, "%s");
                                            pString2.value = str6;
                                        }
                                        str7 = com.tencent.mm.compatible.util.n.eN(str7);
                                        pString.value = com.tencent.mm.compatible.util.n.eN(pString.value);
                                        str7 = str7 + substring;
                                        pString.value += substring;
                                        if (z) {
                                            if (pString.value.length() == 32) {
                                            }
                                            obj = null;
                                            if (obj == null) {
                                                a(i2, pString, pString2, pInt);
                                            }
                                        }
                                        if (obj5 == null) {
                                            substring = str7;
                                        } else {
                                            substring = str7.concat(" " + bh.ou(str4));
                                        }
                                        return bh.ou(substring);
                                    } else if (1 != i) {
                                        str4 = null;
                                        split = str7.split(":");
                                        if (split != null) {
                                        }
                                        pString.value = "";
                                        return null;
                                    } else if (bh.ov(substring)) {
                                        split2 = str7.split("@bottle:");
                                        if (split2.length <= 1) {
                                            pString.value = "";
                                            return null;
                                        }
                                        pString.value = split2[1];
                                        return split2[1];
                                    } else {
                                        pString.value = substring;
                                        return substring;
                                    }
                                }
                            }
                            break;
                        case 520093745:
                            fT3 = a.fT(bh.VH(substring));
                            if (fT3 == null) {
                                str = "";
                                str4 = context.getString(R.l.dOP);
                                if (i != 1) {
                                    str4 = str4 + fT3.hcr;
                                    pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                                } else {
                                    str4 = str4 + fT3.hcq;
                                    pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                                }
                                if (!s.hd(str2) && r17 == null) {
                                    pString2.value = str6;
                                    substring = str;
                                    obj5 = null;
                                    str7 = str4;
                                    str4 = null;
                                    break;
                                }
                            }
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            return "";
                        case 536870961:
                            str4 = bh.VH(substring);
                            str = "";
                            substring = "";
                            fT = a.fT(str4);
                            if (fT != null) {
                                bVar = (com.tencent.mm.y.b) fT.r(com.tencent.mm.y.b.class);
                                if ((i != 1 ? 1 : null) == null) {
                                    pString.value = context.getString(R.l.epj, new Object[]{bVar.haR});
                                } else {
                                    pString.value = context.getString(R.l.epj, new Object[]{bVar.haS});
                                }
                                substring = pString.value;
                                pString2.value = str6;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            }
                        case 570425393:
                            Eq = ((e) g.h(e.class)).Eq(str7);
                            if (Eq == null) {
                                substring = Eq.toString();
                            } else {
                                substring = "";
                            }
                            pString.value = substring;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str8;
                            break;
                        default:
                            substring = str8;
                            str4 = null;
                            obj5 = null;
                            break;
                    }
                    if (!s.gL(str2)) {
                        if (bh.ov(str7)) {
                            pString.value = "";
                        }
                        if (bh.ov(str6)) {
                            if (str5 != null && str5.length() > 0) {
                                str7 = h(str7, str6, str5);
                            }
                            if (bh.ov(pString2.value)) {
                                pString.value = h(pString.value, str6, "%s");
                                pString2.value = str6;
                            }
                            str7 = com.tencent.mm.compatible.util.n.eN(str7);
                            pString.value = com.tencent.mm.compatible.util.n.eN(pString.value);
                            str7 = str7 + substring;
                            pString.value += substring;
                            if (z) {
                                if (pString.value.length() == 32 || !(i2 == 47 || i2 == 1048625)) {
                                    obj = null;
                                } else {
                                    pString.value = str7;
                                    obj = 1;
                                }
                                if (obj == null) {
                                    a(i2, pString, pString2, pInt);
                                }
                            }
                            if (obj5 == null) {
                                substring = str7.concat(" " + bh.ou(str4));
                            } else {
                                substring = str7;
                            }
                            return bh.ou(substring);
                        }
                        if (s.hd(str2) || r17 != null || s.hm(str2)) {
                            if (substring != null && substring.length() > 0) {
                                str7 = substring;
                            }
                            if (bh.ov(str7)) {
                                pString.value = "";
                                pString2.value = "";
                                return "";
                            }
                            if (i != 0) {
                                pString.value = "%s:" + str7;
                            } else {
                                pString.value = context.getString(R.l.dFB) + ":" + str7;
                            }
                            if (!z) {
                                return r.gu(pString2.value) + ":" + str7;
                            }
                            a(i2, pString, pString2, pInt);
                            substring = str7;
                        } else {
                            if (substring == null || substring.length() <= 0) {
                                substring = str7;
                            } else {
                                pString.value = substring;
                            }
                            if (z) {
                                a(i2, pString, pString2, pInt);
                            }
                        }
                        if (!(obj5 == null || str4 == null)) {
                            substring = substring.concat(" " + str4);
                        }
                        if (obj2 != null) {
                            substring = ey(substring);
                        }
                        return bh.ou(substring);
                    } else if (1 != i) {
                        str4 = null;
                        split = str7.split(":");
                        if (split != null || split.length <= 0) {
                            pString.value = "";
                            return null;
                        }
                        str9 = split[0];
                        if (!bh.ov(str9)) {
                            ar.Hg();
                            x WO = com.tencent.mm.z.c.EY().WO(str9);
                            if (!(WO == null || WO.getCity() == null)) {
                                str4 = WO.getCity();
                            }
                            if (str4 == null || str4.length() <= 0) {
                                str4 = WO.getProvince();
                            }
                        }
                        if (bh.ov(substring)) {
                            split2 = str7.split("@bottle:");
                            if (split2.length > 1) {
                                pString.value = str4 + ": " + split2[1];
                                return str4 + ": " + split2[1];
                            }
                            pString.value = str4;
                            return str4;
                        }
                        pString.value = str4 + ": " + substring;
                        return str4 + ": " + substring;
                    } else if (bh.ov(substring)) {
                        pString.value = substring;
                        return substring;
                    } else {
                        split2 = str7.split("@bottle:");
                        if (split2.length <= 1) {
                            pString.value = split2[1];
                            return split2[1];
                        }
                        pString.value = "";
                        return null;
                    }
                }
            }
            substring = str3;
            str5 = str4;
            str6 = str9;
            obj3 = null;
            if (s.hd(str2)) {
            }
            indexOf = str3.indexOf(":");
            if (indexOf != -1) {
                pString2.value = str3.substring(0, indexOf);
                str3 = str3.substring(indexOf + 1);
            }
            obj4 = null;
            str7 = str3;
            switch (i2) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    str7 = "";
                    substring = context.getString(R.l.dGZ);
                    str4 = null;
                    obj5 = null;
                    break;
                case -1879048188:
                    str7 = "";
                    substring = context.getString(R.l.dHb);
                    str4 = null;
                    obj5 = null;
                    break;
                case -1879048186:
                    fT = a.fT(bh.VH(substring));
                    if (fT == null) {
                        str = "";
                        if (str6.length() <= 0) {
                        }
                        pString2.value = str6;
                        if (str6.length() <= 0) {
                        }
                        pString.value = str6.length() <= 0 ? "%s: " + fT.title : fT.title;
                        str4 = null;
                        obj5 = null;
                        str7 = substring;
                        substring = str;
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    return "";
                case -1879048185:
                case -1879048183:
                case -1879048176:
                    str = context.getString(R.l.dDN);
                    if (str6.length() <= 0) {
                    }
                    pString2.value = str6;
                    if (str6.length() <= 0) {
                    }
                    pString.value = str6.length() <= 0 ? "%s: " : "";
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str;
                    break;
                case 3:
                case 23:
                case 33:
                    str = context.getString(R.l.dGj);
                    if (str6.length() <= 0) {
                    }
                    if (str6.length() <= 0) {
                    }
                    pString.value = str6.length() <= 0 ? "%s: " : "";
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str;
                    break;
                case 11:
                case 36:
                    str4 = null;
                    obj5 = null;
                    str7 = a(context, i, str2, str7, null, pString, pString2);
                    substring = str8;
                    break;
                case 13:
                case 39:
                    str4 = null;
                    obj5 = null;
                    str7 = a(context, i, str2, str7, context.getString(R.l.dGj), pString, pString2);
                    substring = str8;
                    break;
                case 34:
                    if (x.Wx(str2)) {
                        break;
                    }
                    str4 = null;
                    obj5 = null;
                    str7 = a(context, i, str2, str7, context.getString(R.l.dGY), pString, pString2);
                    substring = str8;
                    break;
                case 35:
                    if (bh.ou(str7).length() > 0) {
                        ar.Hg();
                        EI = com.tencent.mm.z.c.Fa().EI(str7);
                        substring = context.getString(R.l.eiW, new Object[]{EI.hMK, EI.title});
                        pString.value = substring;
                        str4 = null;
                        obj5 = null;
                        str7 = substring;
                        substring = str8;
                        break;
                    }
                case 37:
                    Xu = d.Xu(str7);
                    switch (Xu.scene) {
                        case 18:
                            str4 = null;
                            obj5 = null;
                            str7 = context.getString(R.l.ejd, new Object[]{Xu.getDisplayName()});
                            substring = str8;
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            str4 = null;
                            obj5 = null;
                            str7 = context.getString(R.l.ejn, new Object[]{Xu.getDisplayName()});
                            substring = str8;
                            break;
                        case 25:
                            substring = context.getString(R.l.eip, new Object[]{Xu.getDisplayName()});
                            pString.value = substring;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str8;
                            break;
                        default:
                            str7 = context.getString(R.l.ejt, new Object[]{Xu.getDisplayName()});
                            pString.value = str7;
                            break;
                    }
                    substring = str8;
                    str4 = null;
                    obj5 = null;
                    break;
                case 40:
                    Xr = au.a.Xr(str7);
                    str7 = context.getString(R.l.eiJ, new Object[]{Xr.getDisplayName()});
                    pString.value = str7;
                    substring = str8;
                    str4 = null;
                    obj5 = null;
                    break;
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    if (bh.ou(str7).length() > 0) {
                        if (s.eV(str2)) {
                            substring = ba.hP(str7);
                            break;
                        }
                        substring = str2;
                        ar.Hg();
                        EK = com.tencent.mm.z.c.Fa().EK(str7);
                        ar.Hg();
                        str4 = com.tencent.mm.z.c.EY().WO(substring).AQ();
                        if (s.eV(str4)) {
                            str4 = m.B(m.gm(str4));
                        }
                        if (i != 1) {
                            str7 = context.getString(R.l.eiq, new Object[]{str4, EK.getDisplayName()});
                            pString.value = context.getString(R.l.eiq, new Object[]{"%s", EK.getDisplayName()});
                            pString2.value = substring;
                            substring = str8;
                            str4 = null;
                            obj5 = null;
                            break;
                        }
                        str7 = context.getString(R.l.eir, new Object[]{str4, EK.getDisplayName()});
                        pString.value = context.getString(R.l.eir, new Object[]{"%s", EK.getDisplayName()});
                        pString2.value = substring;
                        substring = str8;
                        str4 = null;
                        obj5 = null;
                        break;
                    }
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                case 62:
                    if (x.Wx(str2)) {
                        break;
                    }
                    str4 = null;
                    obj5 = null;
                    str7 = a(context, i, str2, str7, context.getString(R.l.dGX), pString, pString2);
                    substring = str8;
                    break;
                case 47:
                case 1048625:
                    Xp = aj.Xp(str7);
                    substring = Xp.hVz + ": ";
                    str = context.getString(R.l.dEG);
                    pString.value = "";
                    pString2.value = Xp.hVz;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str;
                    break;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    if (bh.ou(str7).length() > 0) {
                        if (s.eV(str2)) {
                            str4 = str2;
                        } else {
                            hO = ba.hO(str7);
                            if (hO == -1) {
                                substring = str2;
                            } else {
                                substring = str7.substring(0, hO).trim();
                            }
                            ba.hQ(str7);
                            str4 = substring;
                        }
                        if (i != 1) {
                            substring = context.getString(R.l.esY);
                            pString.value = substring;
                            str4 = null;
                            obj5 = null;
                            str7 = substring;
                            substring = str8;
                            break;
                        }
                        substring = context.getString(R.l.esY);
                        pString.value = context.getString(R.l.esY);
                        pString2.value = str4;
                        str4 = null;
                        obj5 = null;
                        str7 = substring;
                        substring = str8;
                        break;
                    }
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                case 16777265:
                case 268435505:
                case 553648177:
                    substring = bh.VH(substring);
                    fT2 = a.fT(substring);
                    if (fT2 == null) {
                        switch (fT2.type) {
                            case 1:
                                str = "";
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " + fT2.title : fT2.title;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 2:
                                str = context.getString(R.l.dGj);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 3:
                                str = context.getString(R.l.dFJ);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                obj5 = 1;
                                str4 = fT2.title;
                                str7 = substring;
                                substring = str;
                                break;
                            case 4:
                                str = context.getString(R.l.dGX);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                obj5 = 1;
                                str4 = fT2.title;
                                str7 = substring;
                                substring = str;
                                break;
                            case 5:
                                str = context.getString(R.l.dGU);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                obj5 = 1;
                                str4 = fT2.getTitle();
                                str7 = substring;
                                substring = str;
                                break;
                            case 6:
                                str = context.getString(R.l.dFj);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                obj5 = 1;
                                str4 = fT2.title;
                                str7 = substring;
                                substring = str;
                                break;
                            case 7:
                                str = context.getString(R.l.dDN);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 8:
                                str = context.getString(R.l.dEH);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                pString.value = "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 15:
                            case 26:
                            case 27:
                                str = context.getString(R.l.dEI);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                pString.value = "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 16:
                                str = "";
                                str4 = context.getString(R.l.dOP);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() > 0) {
                                    str4 = "%s: " + str4;
                                }
                                pString.value = str4;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 17:
                                str = "";
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " + fT2.title : fT2.title;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 19:
                                str = context.getString(R.l.dGs);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 24:
                                substring = "";
                                if (bh.ov(fT2.description)) {
                                    hO = fT2.description.indexOf("\n");
                                    str4 = fT2.description;
                                    if (hO <= 0) {
                                        hO = fT2.description.length();
                                    }
                                    substring = str4.substring(0, hO);
                                }
                                str = context.getString(R.l.egY) + substring;
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " : "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 25:
                                str = context.getString(R.l.dEy);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                pString.value = "";
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 33:
                            case 36:
                                str = "";
                                str4 = context.getString(R.l.dDR);
                                if (str6.length() <= 0) {
                                }
                                pString2.value = str6;
                                if (str6.length() <= 0) {
                                }
                                pString.value = str6.length() <= 0 ? "%s: " + str4 + fT2.title : str4 + fT2.title;
                                str4 = null;
                                obj5 = null;
                                str7 = substring;
                                substring = str;
                                break;
                            case 34:
                                str = "";
                                substring = context.getString(R.l.dOP);
                                if (i != 1) {
                                    str4 = substring + fT2.hcq;
                                    if (str6.length() <= 0) {
                                    }
                                    pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                                } else {
                                    str4 = substring + fT2.hcr;
                                    if (str6.length() <= 0) {
                                    }
                                    pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                                }
                                pString2.value = str6;
                                substring = str;
                                obj5 = null;
                                str7 = str4;
                                str4 = null;
                                break;
                            case 40:
                                if (k.fX(substring).hea != 19) {
                                    substring = context.getString(R.l.dGs);
                                    str4 = null;
                                    obj5 = null;
                                    break;
                                }
                                substring = context.getString(R.l.dDN);
                                str4 = null;
                                obj5 = null;
                                break;
                            default:
                                substring = context.getString(R.l.dDN);
                                str7 = "";
                                str4 = null;
                                obj5 = null;
                                break;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    return "";
                case 50:
                case 53:
                    if (str7.equals(au.xzd)) {
                        if (str7.equals(au.xzc)) {
                            str7 = "";
                            substring = context.getString(R.l.dHb);
                            str4 = null;
                            obj5 = null;
                            break;
                        }
                    }
                    str7 = "";
                    substring = context.getString(R.l.dHa);
                    str4 = null;
                    obj5 = null;
                    break;
                case 52:
                    str7 = "";
                    substring = context.getString(R.l.dHa);
                    str4 = null;
                    obj5 = null;
                    break;
                case 55:
                case 57:
                    substring = com.tencent.mm.ah.a.b(com.tencent.mm.ah.a.a.ky(str7));
                    pString.value = substring;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str8;
                    break;
                case 12299999:
                    str7 = "";
                    substring = context.getString(R.l.dHa);
                    str4 = null;
                    obj5 = null;
                    break;
                case 285212721:
                    if (obj2 != null) {
                        str7 = ey(str7);
                    }
                    substring = ex(((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vK(str7));
                    pString.value = substring;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str8;
                    break;
                case 318767153:
                    pString.value = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vJ(str7);
                    substring = pString.value;
                    str4 = null;
                    obj5 = null;
                    break;
                case 335544369:
                    fT3 = a.fT(bh.VH(substring));
                    if (fT3.hbw != 0) {
                        if (fT3.hbw == 1) {
                            substring = context.getString(R.l.eIc);
                        } else if (fT3.hbw == 2) {
                            substring = context.getString(R.l.eIe);
                        } else if (fT3.hbw == 3) {
                            substring = context.getString(R.l.eId);
                        }
                        str7 = "";
                        pString2.value = str6;
                        pString.value = "";
                        str4 = null;
                        obj5 = null;
                        break;
                    }
                    substring = context.getString(R.l.eIf);
                    str7 = "";
                    pString2.value = str6;
                    pString.value = "";
                    str4 = null;
                    obj5 = null;
                case 369098801:
                    switch (a.fT(bh.VH(substring)).hbw) {
                        case 10000:
                            substring = context.getString(R.l.dGm);
                            break;
                        case HardCoderJNI.sHCENCODEVIDEOTIMEOUT /*20000*/:
                            substring = context.getString(R.l.dGo);
                            break;
                        default:
                            substring = context.getString(R.l.dGl);
                            break;
                    }
                    if (str6.length() <= 0) {
                    }
                    pString2.value = str6;
                    pString.value = "";
                    obj5 = null;
                    str7 = str4;
                    str4 = null;
                    break;
                case 402653233:
                    str4 = bh.VH(substring);
                    str = "";
                    substring = "";
                    fT = a.fT(str4);
                    if (fT != null) {
                        pString.value = context.getString(R.l.eIn) + bh.ou(fT.title);
                        substring = pString.value;
                    }
                    pString2.value = str6;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str;
                    break;
                case 419430449:
                    str4 = bh.VH(substring);
                    str = "";
                    substring = "";
                    fT = a.fT(str4);
                    if (fT != null) {
                        if (i != 1) {
                        }
                        switch (fT.hcd) {
                            case 1:
                                if (obj == null) {
                                    pString.value = context.getString(R.l.dHg);
                                    break;
                                }
                                pString.value = context.getString(R.l.dHj);
                                break;
                            case 3:
                                if (obj == null) {
                                    pString.value = context.getString(R.l.dHh);
                                    break;
                                }
                                pString.value = context.getString(R.l.dHe);
                                break;
                            case 4:
                                if (obj == null) {
                                    pString.value = context.getString(R.l.dHi);
                                    break;
                                }
                                pString.value = context.getString(R.l.dHf);
                                break;
                            default:
                                pString.value = bh.ou(fT.title);
                                break;
                        }
                        substring = pString.value;
                    }
                    pString2.value = str6;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str;
                    break;
                case 436207665:
                case 469762097:
                    str4 = bh.VH(substring);
                    str = "";
                    substring = "";
                    fT = a.fT(str4);
                    if (fT != null) {
                        if (i != 1) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            pString.value = "[" + fT.hcE + "]" + fT.hcB;
                        } else if (bh.ov(str5)) {
                            pString.value = "[" + fT.hcE + "]" + fT.hcA;
                        } else {
                            pString.value = bh.ou(str5) + ": [" + fT.hcE + "]" + fT.hcA;
                        }
                        substring = pString.value;
                    }
                    pString2.value = str6;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str;
                    break;
                case 452984881:
                    fT = a.fT(bh.VH(substring));
                    if (fT == null) {
                        str = "";
                        str9 = context.getString(R.l.dOP);
                        if (str6.length() <= 0) {
                        }
                        pString2.value = str6;
                        if (str6.length() <= 0) {
                        }
                        pString.value = str6.length() <= 0 ? "%s: " + str9 + fT.title : str9 + fT.title;
                        str4 = null;
                        obj5 = null;
                        str7 = substring;
                        substring = str;
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    return "";
                case 503316529:
                    str7 = "";
                    fT3 = a.fT(substring);
                    if (fT3 != null) {
                        str7 = URLDecoder.decode(fT3.content, "UTF-8");
                        substring = i.SH(str7);
                        pString.value = substring;
                        str4 = null;
                        obj5 = null;
                        str7 = substring;
                        substring = str8;
                        break;
                    }
                case 520093745:
                    fT3 = a.fT(bh.VH(substring));
                    if (fT3 == null) {
                        str = "";
                        str4 = context.getString(R.l.dOP);
                        if (i != 1) {
                            str4 = str4 + fT3.hcq;
                            if (str6.length() <= 0) {
                            }
                            pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                        } else {
                            str4 = str4 + fT3.hcr;
                            if (str6.length() <= 0) {
                            }
                            pString.value = str6.length() <= 0 ? "%s: " + str4 : str4;
                        }
                        pString2.value = str6;
                        substring = str;
                        obj5 = null;
                        str7 = str4;
                        str4 = null;
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    return "";
                case 536870961:
                    str4 = bh.VH(substring);
                    str = "";
                    substring = "";
                    fT = a.fT(str4);
                    if (fT != null) {
                        bVar = (com.tencent.mm.y.b) fT.r(com.tencent.mm.y.b.class);
                        if (i != 1) {
                        }
                        if ((i != 1 ? 1 : null) == null) {
                            pString.value = context.getString(R.l.epj, new Object[]{bVar.haS});
                        } else {
                            pString.value = context.getString(R.l.epj, new Object[]{bVar.haR});
                        }
                        substring = pString.value;
                        pString2.value = str6;
                        str4 = null;
                        obj5 = null;
                        str7 = substring;
                        substring = str;
                        break;
                    }
                case 570425393:
                    Eq = ((e) g.h(e.class)).Eq(str7);
                    if (Eq == null) {
                        substring = "";
                    } else {
                        substring = Eq.toString();
                    }
                    pString.value = substring;
                    str4 = null;
                    obj5 = null;
                    str7 = substring;
                    substring = str8;
                    break;
                default:
                    substring = str8;
                    str4 = null;
                    obj5 = null;
                    break;
            }
            if (!s.gL(str2)) {
                if (bh.ov(str7)) {
                    pString.value = "";
                }
                if (bh.ov(str6)) {
                    if (s.hd(str2)) {
                    }
                    str7 = substring;
                    if (bh.ov(str7)) {
                        if (i != 0) {
                            pString.value = context.getString(R.l.dFB) + ":" + str7;
                        } else {
                            pString.value = "%s:" + str7;
                        }
                        if (!z) {
                            return r.gu(pString2.value) + ":" + str7;
                        }
                        a(i2, pString, pString2, pInt);
                        substring = str7;
                        substring = substring.concat(" " + str4);
                        if (obj2 != null) {
                            substring = ey(substring);
                        }
                        return bh.ou(substring);
                    }
                    pString.value = "";
                    pString2.value = "";
                    return "";
                }
                str7 = h(str7, str6, str5);
                if (bh.ov(pString2.value)) {
                    pString.value = h(pString.value, str6, "%s");
                    pString2.value = str6;
                }
                str7 = com.tencent.mm.compatible.util.n.eN(str7);
                pString.value = com.tencent.mm.compatible.util.n.eN(pString.value);
                str7 = str7 + substring;
                pString.value += substring;
                if (z) {
                    if (pString.value.length() == 32) {
                    }
                    obj = null;
                    if (obj == null) {
                        a(i2, pString, pString2, pInt);
                    }
                }
                if (obj5 == null) {
                    substring = str7;
                } else {
                    substring = str7.concat(" " + bh.ou(str4));
                }
                return bh.ou(substring);
            } else if (1 != i) {
                str4 = null;
                split = str7.split(":");
                if (split != null) {
                }
                pString.value = "";
                return null;
            } else if (bh.ov(substring)) {
                split2 = str7.split("@bottle:");
                if (split2.length <= 1) {
                    pString.value = "";
                    return null;
                }
                pString.value = split2[1];
                return split2[1];
            } else {
                pString.value = substring;
                return substring;
            }
        } else if (z) {
            return "";
        } else {
            boolean Gn = q.Gn();
            ar.Hg();
            long a = bh.a((Long) com.tencent.mm.z.c.CU().get(65793, null), 0);
            if (!Gn) {
                return context.getString(R.l.eMu);
            } else if (a == 0) {
                return context.getString(R.l.eiY);
            } else if (bh.by(a) * 1000 <= 1209600000) {
                return "";
            } else {
                return context.getString(R.l.eiX, new Object[]{Long.valueOf((bh.by(a) * 1000) / 86400000)});
            }
        }
    }

    private static String a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        String str4 = "";
        if (s.gK(str) || s.gM(str)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(":");
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (x.Wx(substring) || x.Wz(substring)) {
                        str4 = r.gu(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (x.Wx(str) || x.Wz(str)) {
            r.gu(str);
            pString2.value = str;
            if (i == 1) {
                StringBuilder append = new StringBuilder().append(context.getString(R.l.eja, new Object[]{""}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                return pString.value;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            return pString.value;
        }
        if (bh.ou(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            return pString.value;
        }
        pString.value = context.getString(i == 1 ? R.l.eja : R.l.ejk) + (str3 == null ? str2 : str3);
        append = new StringBuilder().append(context.getString(i == 1 ? R.l.eja : R.l.ejk, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        return append.append(str2).toString();
    }

    private static String ex(String str) {
        if (str != null) {
            return str.replaceAll("%", "%%");
        }
        return str;
    }

    private static String h(String str, String str2, String str3) {
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        return indexOf >= 0 ? str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length()) : str;
    }

    private static String ey(String str) {
        if (str != null) {
            return str.replaceAll("%%", "%");
        }
        return str;
    }

    public static String ez(String str) {
        if (str == null) {
            return "";
        }
        return str.length() >= 150 ? str.substring(0, 150) + "..." : str;
    }

    private static void a(int i, PString pString, PString pString2, PInt pInt) {
        int i2 = 150;
        if (pString.value.length() != 32 || (i != 47 && i != 1048625)) {
            if (pString.value.length() >= 150) {
                String str = pString.value;
                String str2 = pString.value;
                while (i2 < str2.length()) {
                    if (str2.charAt(i2) != '%') {
                        break;
                    }
                    i2++;
                }
                i2 = str2.length();
                pString.value = str.substring(0, i2);
            }
            TextPaint textPaint = gAV == null ? null : (TextPaint) gAV.get();
            if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
                pInt.value = 0;
                return;
            }
            CharSequence format;
            try {
                format = String.format(pString.value, new Object[]{pString2.value});
            } catch (Exception e) {
                format = pString.value;
            }
            pString.value = TextUtils.ellipsize(format, textPaint, (float) (gAW > 0 ? gAW : BackwardSupportUtil.b.b(ac.getContext(), 200.0f)), TruncateAt.END).toString();
            pInt.value = 1;
        }
    }

    public static void fu(int i) {
        gAW = i;
    }

    public static void fv(int i) {
        gAX = i;
    }

    public static void a(TextPaint textPaint) {
        if (gAV == null || gAV.get() == null) {
            gAV = new WeakReference(textPaint);
        }
    }

    public static String c(Context context, String str, boolean z) {
        return z ? b.cgX().Wj(str) : context.getString(R.l.epB);
    }

    public static String a(Context context, String str, int i, int i2, int i3, boolean z) {
        if (z) {
            String Wj = b.cgX().Wj(str);
            if (i3 <= 1) {
                return Wj;
            }
            return context.getResources().getQuantityString(R.j.duF, i3, new Object[]{Integer.valueOf(i3)}) + Wj;
        }
        return context.getResources().getQuantityString(R.j.duG, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static String d(Context context, String str, boolean z) {
        if (z) {
            return b.cgX().Wj(str);
        }
        return context.getString(R.l.ezf);
    }
}
