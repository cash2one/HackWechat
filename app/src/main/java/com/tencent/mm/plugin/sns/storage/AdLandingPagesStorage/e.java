package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y$a;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.z.c.c;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xwalk.core.R$styleable;

public final class e {
    public static int rnX = 750;
    public static int rnY = 10;
    private static Set<a> rnZ = null;

    private static boolean xg(int i) {
        if (i == 101 || i == 103) {
            return false;
        }
        return true;
    }

    private static boolean xh(int i) {
        if (i == 103) {
            return true;
        }
        return false;
    }

    public static float a(double d, int i, int i2, int i3) {
        if (i == 0) {
            return (float) d;
        }
        if (i2 == 0) {
            return (float) d;
        }
        return (float) ac.aw((((float) ((WindowManager) com.tencent.mm.sdk.platformtools.ac.getContext().getSystemService("window")).getDefaultDisplay().getWidth()) * (((float) d) * ((float) i3))) / ((float) i2));
    }

    private static s a(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        s sVar;
        int VI = bh.VI((String) map.get(str + ".type"));
        int VI2 = bh.VI((String) map.get(str + ".subType"));
        s uVar;
        double VK;
        double VK2;
        int VI3;
        String str2;
        String str3;
        String str4;
        int i5;
        CharSequence charSequence;
        String str5;
        switch (VI) {
            case 1:
                uVar = new u();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.rhh = bh.az((String) map.get(str + ".content"), "");
                uVar.textAlignment = bh.VI((String) map.get(str + ".textAlignment"));
                uVar.rhi = bh.az((String) map.get(str + ".fontColor"), "");
                uVar.gUh = a(bh.VK((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.rhj = (bh.VI((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.rhc) > 0;
                uVar.rhk = (bh.VI((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.rhd) > 0;
                uVar.rhl = (bh.VI((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.rhe) > 0;
                uVar.maxLines = bh.VI((String) map.get(str + ".maxLines"));
                uVar.rhm = bh.VI((String) map.get(str + ".fontType"));
                sVar = uVar;
                break;
            case 21:
                s bVar;
                if (VI2 == 2) {
                    bVar = new b();
                    bVar.fFm = (String) map.get(str + ".appid");
                    bVar.rfT = (String) map.get(str + ".appPageUrlAndroid");
                    bVar.channelId = (String) map.get(str + ".channelId");
                    bVar.uC = (String) map.get(str + ".pkg");
                    bVar.rfI = bh.VI((String) map.get(str + ".platform"));
                    bVar.rfJ = (String) map.get(str + ".warningAndroid");
                    bVar.rfK = (String) map.get(str + ".btnBgColorTheme");
                    bVar.rfM = (String) map.get(str + ".btnBgColorThemePressed");
                    bVar.rfL = (String) map.get(str + ".btnBgColorThemeDisable");
                    bVar.rfN = (String) map.get(str + ".btnBorderColorTheme");
                    bVar.rfP = (String) map.get(str + ".btnBorderColorThemePressed");
                    bVar.rfO = (String) map.get(str + ".btnBorderColorThemeDisable");
                    bVar.rfQ = (String) map.get(str + ".fontColor");
                    bVar.rfS = (String) map.get(str + ".fontColorPressed");
                    bVar.rfR = (String) map.get(str + ".fontColorDisable");
                    uVar = bVar;
                } else if (VI2 == 4) {
                    bVar = new f();
                    bVar.kKG = bh.az((String) map.get(str + ".cardTpId"), "");
                    bVar.kLw = bh.az((String) map.get(str + ".cardExt"), "");
                    uVar = bVar;
                } else if (VI2 == 7) {
                    bVar = new k();
                    bVar.rga = bh.az((String) map.get(str + ".jumpCanvasId"), "");
                    bVar.rgb = bh.az((String) map.get(str + ".jumpCanvasExt"), "");
                    bVar.rgc = bh.VI((String) map.get(str + ".jumpCanvasNoStore"));
                    bVar.rgd = bh.VI((String) map.get(str + ".btnCanvasEnterType"));
                    bVar.rge = bh.VI((String) map.get(str + ".btnCanvasSource"));
                    uVar = bVar;
                } else if (VI2 == 8) {
                    bVar = new j();
                    bVar.username = (String) map.get(str + ".weappUserName");
                    bVar.fIk = (String) map.get(str + ".weappPath");
                    uVar = bVar;
                } else if (VI2 == 9) {
                    VK = bh.VK((String) map.get(str + ".location.$x"));
                    VK2 = bh.VK((String) map.get(str + ".location.$y"));
                    VI3 = bh.VI((String) map.get(str + ".location.$scale"));
                    str2 = (String) map.get(str + ".location.$label");
                    str3 = (String) map.get(str + ".location.$poiname");
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                        return null;
                    }
                    uVar = new g(new g$a(VK, VK2, VI3, str2, str3));
                } else if (VI2 == 10) {
                    str4 = str + ".phoneNumList.phoneNum";
                    List arrayList = new ArrayList();
                    i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            charSequence = (String) map.get(str4);
                        } else {
                            str5 = (String) map.get(str4 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence)) {
                            arrayList.add(charSequence);
                            i5++;
                        } else if (arrayList.isEmpty()) {
                            return null;
                        } else {
                            uVar = new i(arrayList);
                        }
                    }
                } else {
                    uVar = new l();
                }
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.title = bh.az((String) map.get(str + ".btnTitle"), "");
                uVar.rgf = bh.VI((String) map.get(str + ".btnType"));
                uVar.rgg = bh.az((String) map.get(str + ".btnJumpUrl"), "");
                uVar.rgh = bh.az((String) map.get(str + ".btnJumpApp"), "");
                uVar.rgi = bh.az((String) map.get(str + ".fontColor"), "");
                uVar.azb = a(bh.VK((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.textAlignment = bh.VI((String) map.get(str + ".btnAlignment"));
                uVar.rgj = a(bh.VK((String) map.get(str + ".borderSize")), i, i2, i3);
                uVar.height = a(bh.VK((String) map.get(str + ".btnHeight")), i, i2, i3);
                uVar.rgk = bh.az((String) map.get(str + ".btnBgColorTheme"), "");
                uVar.rgl = bh.az((String) map.get(str + ".btnBorderColorTheme"), "");
                uVar.rgm = bh.az((String) map.get(str + ".btnBgImgUrl"), "");
                uVar.rgn = bh.VI((String) map.get(str + ".bCanLongPress"));
                uVar.rgo = bh.VI((String) map.get(str + ".bHideActionSheet"));
                uVar.rgp = bh.VI((String) map.get(str + ".hideProductActionHeader"));
                uVar.rgq = bh.VI((String) map.get(str + ".showProductActionCancelButton"));
                uVar.rgs = bh.az((String) map.get(str + ".productActionTitle"), "");
                uVar.rgr = bh.az((String) map.get(str + ".productActionBuffer"), "");
                uVar.rgt = bh.az((String) map.get(str + ".productActionIconUrl"), "");
                if (map.containsKey(str + ".productActionItem.componentItem.type")) {
                    uVar.rgu = a((Map) map, i, i3, i2, i4, str + ".productActionItem.componentItem");
                }
                sVar = uVar;
                break;
            case 41:
                uVar = new p();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.rgz = bh.az((String) map.get(str + ".pureImageUrl"), "");
                uVar.rgA = bh.az((String) map.get(str + ".bgColor"), "");
                if (map.containsKey(str + ".bgColorAlpha") && uVar.rgA.length() > 0) {
                    Map<String, String> map2 = map;
                    uVar.rgA = String.format("#%02x%s", new Object[]{Integer.valueOf((int) (bh.VK((String) map2.get(str + ".bgColorAlpha")) * 255.0d)), uVar.rgA.substring(1)});
                }
                uVar.width = a(bh.VK((String) map.get(str + ".imageWidth")), i, i2, i3);
                uVar.height = a(bh.VK((String) map.get(str + ".imageHeight")), i, i2, i3);
                uVar.rgw = false;
                sVar = uVar;
                break;
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                uVar = new o();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.rgz = bh.az((String) map.get(str + ".panoramaImageUrl"), "");
                uVar.width = a(bh.VK((String) map.get(str + ".imageWidth")), i, i2, i3);
                uVar.height = a(bh.VK((String) map.get(str + ".imageHeight")), i, i2, i3);
                sVar = uVar;
                break;
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                uVar = new p();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.rgz = bh.az((String) map.get(str + ".fullScreenImageUrl"), "");
                uVar.rgw = true;
                sVar = uVar;
                break;
            case 61:
                uVar = new q();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.rgB = bh.az((String) map.get(str + ".sightVideoUrl"), "");
                uVar.rgC = bh.az((String) map.get(str + ".sightThumbUrl"), "");
                uVar.rgD = bh.az((String) map.get(str + ".streamVideoUrl"), "");
                uVar.rgE = bh.az((String) map.get(str + ".jumpText"), "");
                uVar.rga = bh.az((String) map.get(str + ".jumpCanvasId"), "");
                uVar.rgb = bh.az((String) map.get(str + ".jumpCanvasExt"), "");
                uVar.rgc = bh.VI((String) map.get(str + ".jumpCanvasNoStore"));
                try {
                    uVar.rgF = Color.parseColor((String) map.get(str + ".jumpTextColor"));
                } catch (Exception e) {
                    uVar.rgF = Color.rgb(255, 255, 255);
                }
                try {
                    uVar.rgG = Color.parseColor((String) map.get(str + ".separatorColor"));
                } catch (Exception e2) {
                    uVar.rgG = Color.rgb(255, 255, 255);
                }
                uVar.width = a(bh.VK((String) map.get(str + ".sightDisplayWidth")), i, i2, i3);
                uVar.height = a(bh.VK((String) map.get(str + ".sightDisplayHeight")), i, i2, i3);
                uVar.rgH = bh.VI((String) map.get(str + ".sightDisplayType"));
                sVar = uVar;
                break;
            case 62:
                uVar = new w();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.rgD = bh.az((String) map.get(str + ".streamVideoUrl"), "");
                uVar.rhn = bh.az((String) map.get(str + ".streamVideoThumb"), "");
                uVar.width = a(bh.VK((String) map.get(str + ".streamDisplayWidth")), i, i2, i3);
                uVar.height = a(bh.VK((String) map.get(str + ".streamDisplayHeight")), i, i2, i3);
                uVar.rho = bh.VI((String) map.get(str + ".streamDisplayType"));
                sVar = uVar;
                break;
            case 81:
                uVar = new v();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.nvp = bh.az((String) map.get(str + ".webviewUrl"), "");
                sVar = uVar;
                break;
            case 82:
                uVar = new x();
                uVar.url = bh.az((String) map.get(str + ".webviewUrl"), "");
                sVar = uVar;
                break;
            case 102:
                sVar = c(map, str, i, i2, i3, i4);
                break;
            case 104:
                List b = b(map, str, i, i2, i3, i4);
                sVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
                sVar.ayR = b;
                break;
            case 121:
            case 122:
                int argb;
                double a = (double) a(bh.VK((String) map.get(str + ".topLineSize")), i, i2, i3);
                double a2 = (double) a(bh.VK((String) map.get(str + ".bottomLineSize")), i, i2, i3);
                if (xi(i4)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (VI != 121) {
                    if (VI != 122) {
                        sVar = null;
                        break;
                    }
                    str4 = str + ".phoneNumList.phoneNum";
                    List arrayList2 = new ArrayList();
                    i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            charSequence = (String) map.get(str4);
                        } else {
                            str5 = (String) map.get(str4 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence)) {
                            arrayList2.add(charSequence);
                            i5++;
                        } else if (!arrayList2.isEmpty()) {
                            sVar = new d(a, a2, argb, arrayList2);
                            break;
                        } else {
                            return null;
                        }
                    }
                }
                VK = bh.VK((String) map.get(str + ".location.$x"));
                VK2 = bh.VK((String) map.get(str + ".location.$y"));
                VI3 = bh.VI((String) map.get(str + ".location.$scale"));
                str2 = (String) map.get(str + ".location.$label");
                str3 = (String) map.get(str + ".location.$poiname");
                if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                    s hVar = new h(a, a2, new h$a(VK, VK2, VI3, str2, str3), argb);
                    break;
                }
                return null;
                break;
            case 131:
                uVar = new t();
                uVar.rgL = VI;
                uVar.fpn = VI2;
                uVar.label = bh.az((String) map.get(str + ".label"), "");
                uVar.value = (float) bh.VK((String) map.get(str + ".value"));
                uVar.rhb = bh.az((String) map.get(str + ".foregroundImage"), "");
                uVar.azb = a(bh.VK((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.iMN = bh.az((String) map.get(str + ".backgroundColor"), "");
                sVar = uVar;
                break;
            case 132:
                sVar = a(map, str, i, i2, i3);
                break;
            default:
                return null;
        }
        if (sVar == null) {
            return sVar;
        }
        sVar.rgS = xi(i4);
        sVar.type = VI;
        sVar.fpn = VI2;
        a(sVar, (Map) map, str, i, i2, i3);
        return sVar;
    }

    private static y a(Map<String, String> map, String str, int i, int i2, int i3) {
        y yVar = new y();
        try {
            String str2 = str + ".radarChart";
            yVar.rhp = (String) map.get(str2 + ".borderImg");
            yVar.rhw = (String) map.get(str2 + ".maskImg");
            yVar.rhr = (String) map.get(str2 + ".coverColor");
            yVar.rhs = Color.parseColor((String) map.get(str2 + ".labelFont.$color"));
            yVar.rht = (int) a(bh.VK((String) map.get(str2 + ".labelFont.$size")), i, i2, i3);
            yVar.rhu = Color.parseColor((String) map.get(str2 + ".scoreFont.$color"));
            yVar.rhv = (int) a(bh.VK((String) map.get(str2 + ".scoreFont.$size")), i, i2, i3);
            yVar.rhq = a(bh.VK((String) map.get(str2 + ".borderImgWidth")), i, i2, i3);
            String str3 = str2 + ".itemList.item";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str2 = str3 + i4;
                } else {
                    str2 = str3;
                }
                y$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a = new y$a();
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.label = (String) map.get(str2 + ".label");
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.rhx = (String) map.get(str2 + ".score");
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.value = (float) bh.VK((String) map.get(str2 + ".value"));
                if (TextUtils.isEmpty(com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.label) && TextUtils.isEmpty(com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.rhx)) {
                    break;
                }
                yVar.pYN.add(com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a);
                i4++;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bh.i(e));
        }
        return yVar;
    }

    private static List<s> b(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        List<s> arrayList = new ArrayList();
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            s a = a((Map) map, i, i3, i2, i4, str3);
            if (a == null) {
                return arrayList;
            }
            if (a.rgW) {
                arrayList.add(a);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
            }
            i5++;
        }
    }

    private static m c(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        m mVar = new m();
        try {
            int parseColor = Color.parseColor((String) map.get(str + ".bgColorTheme"));
            mVar.backgroundColor = (((int) (bh.getDouble((String) map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (parseColor & 16777215);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "%s", new Object[]{bh.i(e)});
            mVar.backgroundColor = Color.argb(51, 0, 0, 0);
        }
        String str2 = (str + ".componentGroupList") + ".componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            parseColor = bh.VI((String) map.get(str3 + ".type"));
            s sVar = null;
            if (xg(parseColor)) {
                sVar = a((Map) map, str3, i, i2, i3, i4);
            }
            if (sVar == null) {
                return mVar;
            }
            if (sVar.rgW) {
                mVar.rgv.add(sVar);
            }
            i5++;
        }
    }

    private static n d(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        s nVar = new n();
        a(nVar, (Map) map, str, i, i2, i3);
        nVar.rgx = bh.VI((String) map.get(str + ".pageCtrType"));
        nVar.rgy = bh.VI((String) map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        String str2 = str + ".componentGroupList.componentGroup";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            m mVar = new m();
            String str4 = str3 + ".componentItem";
            int i6 = 0;
            while (true) {
                String str5;
                if (i6 == 0) {
                    str5 = str4;
                } else {
                    str5 = str4 + i6;
                }
                int VI = bh.VI((String) map.get(str5 + ".type"));
                s sVar = null;
                if (xg(VI)) {
                    sVar = a((Map) map, str5, i, i2, i3, i4);
                }
                if (sVar == null) {
                    break;
                }
                if (sVar.rgW) {
                    mVar.rgv.add(sVar);
                }
                i6++;
            }
            if (mVar.rgv.size() == 0) {
                return nVar;
            }
            nVar.rgv.add(mVar);
            i5++;
        }
    }

    private static void a(s sVar, Map<String, String> map, String str, int i, int i2, int i3) {
        boolean z = true;
        sVar.rgL = bh.VI((String) map.get(str + ".type"));
        sVar.type = sVar.rgL;
        sVar.rgK = bh.az((String) map.get(str + ".id"), "");
        sVar.rgM = a(bh.VK((String) map.get(str + ".paddingTop")), i, i2, i3);
        sVar.rgN = a(bh.VK((String) map.get(str + ".paddingBottom")), i, i2, i3);
        sVar.rgO = a(bh.VK((String) map.get(str + ".paddingLeft")), i, i2, i3);
        sVar.rgP = a(bh.VK((String) map.get(str + ".paddingRight")), i, i2, i3);
        sVar.fpn = bh.VI((String) map.get(str + ".subType"));
        sVar.rgT = bh.az((String) map.get(str + ".cellBackgroundColor"), "");
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            sVar.rgW = "1".equals(map.get(str2));
        } else {
            sVar.rgW = true;
        }
        str2 = str + ".noReport";
        if (map.containsKey(str2)) {
            if (!"1".equals(map.get(str2))) {
                z = false;
            }
            sVar.rgX = z;
        } else {
            sVar.rgX = false;
        }
        Object az = bh.az((String) map.get(str + ".layoutWidth"), "");
        Object az2 = bh.az((String) map.get(str + ".layoutHeight"), "");
        if (TextUtils.isEmpty(az)) {
            sVar.rgQ = 2.14748365E9f;
        } else {
            double VK = bh.VK(az);
            if (VK < 0.0d) {
                sVar.rgQ = (float) VK;
            } else {
                sVar.rgQ = a(VK, i, i2, i3);
            }
        }
        if (TextUtils.isEmpty(az2)) {
            sVar.rgR = 2.14748365E9f;
        } else {
            double VK2 = bh.VK(az2);
            if (VK2 < 0.0d) {
                sVar.rgR = (float) VK2;
            } else {
                sVar.rgR = a(VK2, i, i2, i3);
            }
        }
        str2 = (String) map.get(str + ".verticalAlignment");
        String str3 = (String) map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str2)) {
            sVar.rgU = -1;
        } else {
            sVar.rgU = bh.VI(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            sVar.rgV = -1;
        } else {
            sVar.rgV = bh.VI(str3);
        }
    }

    private static s e(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        s rVar = new r();
        rVar.rgJ = bh.VI((String) map.get(str + ".subType"));
        a(rVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            int VI = bh.VI((String) map.get(str3 + ".type"));
            s sVar = null;
            if (xg(VI)) {
                sVar = a((Map) map, str3, i, i2, i3, i4);
            } else if (xh(VI)) {
                sVar = e(map, str3, i, i2, i3, i4);
            }
            if (sVar == null) {
                return rVar;
            }
            if (sVar.rgW) {
                rVar.rgI.add(sVar);
            }
            i5++;
        }
    }

    public static LinkedList<c> m(String str, String str2, String str3, String str4) {
        int i;
        LinkedList<c> linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        String str5 = "";
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\{\\{.*?\\}\\}", str5);
        }
        Map y = bi.y(str, str2);
        if (y == null) {
            com.tencent.mm.sdk.platformtools.x.w("AdLandingPagesParseHelper", " parse landingpages xml is error ," + str);
            return linkedList;
        }
        String str6;
        int VI = bh.VI((String) y.get("." + str2 + ".adCanvasInfo.sizeType"));
        int VI2 = bh.VI((String) y.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
        int VI3 = bh.VI((String) y.get("." + str2 + ".adCanvasInfo.basicWidth"));
        if (VI2 == 0 && VI == 1) {
            i = rnY;
        } else {
            i = VI2;
        }
        if (VI3 == 0 && VI == 1) {
            VI3 = rnX;
        }
        String str7 = ".adCanvasInfo.PageList.Page";
        if (bh.ov(str2) || str7.equals("adCanvasInfo")) {
            str6 = str7;
        } else {
            str6 = "." + str2 + str7;
        }
        int i2 = 0;
        while (true) {
            String str8;
            if (i2 == 0) {
                str8 = str6;
            } else {
                str8 = str6 + i2;
            }
            c cVar = new c();
            cVar.rnN = bh.az((String) y.get(str8 + ".backgroundCover"), "");
            cVar.iMN = bh.az((String) y.get(str8 + ".backgroundColor"), "");
            cVar.rnO = bh.VI((String) y.get(new StringBuilder().append(str8).append(".backgroundCover.$isAddBlur").toString())) > 0;
            cVar.id = i2;
            str7 = str8 + ".if";
            if (y.containsKey(str7)) {
                cVar.rgW = "1".equals(y.get(str7));
            } else {
                cVar.rgW = true;
            }
            if (cVar.rgW) {
                String str9 = str8 + ".componentItemList.componentItem";
                int i3 = 0;
                while (true) {
                    s a;
                    if (i3 == 0) {
                        str8 = str9;
                    } else {
                        str8 = str9 + i3;
                    }
                    try {
                        a = a(y, VI, i, VI3, !TextUtils.isEmpty(cVar.iMN) ? Color.parseColor(cVar.iMN) : 0, str8);
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bh.i(e));
                        a = a(y, VI, i, VI3, 0, str8);
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.rgW) {
                        if (a.type == 21) {
                            ((l) a).rea = str4;
                            ((l) a).reb = str3;
                        }
                        a(a, y, str8, VI, VI3, i);
                        cVar.rnP.add(a);
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                    }
                    i3++;
                }
                if (cVar.rnP.size() == 0) {
                    break;
                }
                linkedList.add(cVar);
            }
            i2++;
        }
        if (linkedList.size() > 0) {
            ((c) linkedList.get(0)).rnQ = true;
        }
        return linkedList;
    }

    private static s a(Map<String, String> map, int i, int i2, int i3, int i4, String str) {
        int VI = bh.VI((String) map.get(str + ".type"));
        if (xg(VI)) {
            try {
                return a((Map) map, str, i, i3, i2, i4);
            } catch (Exception e) {
                return a((Map) map, str, i, i3, i2, 0);
            }
        }
        Object obj;
        if (VI == 101) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return d(map, str, i, i3, i2, i4);
        }
        if (xh(VI)) {
            return e(map, str, i, i3, i2, i4);
        }
        com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the type" + VI + " is not client known type");
        return null;
    }

    public static LinkedList<c> c(String str, String str2, String str3, String str4, String str5) {
        String str6 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str7;
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    str7 = (String) next;
                    String string = jSONObject.getString(str7);
                    if (!bh.ov(string)) {
                        str7 = str6.replace("{{" + str7 + "}}", "<![CDATA[" + string + "]]>");
                        str6 = str7;
                    }
                }
                str7 = str6;
                str6 = str7;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the json is parsed error : " + str);
        }
        return m(str6, str2, str4, str5);
    }

    private static boolean xi(int i) {
        int i2 = i | WebView.NIGHT_MODE_COLOR;
        return i2 - WebView.NIGHT_MODE_COLOR > -1 - i2;
    }

    private static boolean Lf(String str) {
        return bh.VI(bh.az((String) bi.y(str, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1;
    }

    private static boolean b(String str, Context context, boolean z, int i) {
        String str2 = (String) bi.y(str, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (z) {
            try {
                str2 = l(str2, "exp=" + c.IG().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + i);
            } catch (URISyntaxException e) {
            }
            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "canvas jump url " + str2);
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    private static String l(String str, String... strArr) {
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(strArr[0]).append("&");
        }
        if (stringBuilder.length() <= 1) {
            return str;
        }
        String stringBuilder2;
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String query = uri.getQuery();
        if (query == null) {
            stringBuilder2 = deleteCharAt.toString();
        } else {
            stringBuilder2 = query + "&" + deleteCharAt.toString();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
    }

    private static boolean bxN() {
        com.tencent.mm.storage.c fn = c.IF().fn("100150");
        if (!fn.isValid()) {
            return false;
        }
        int i = bh.getInt((String) fn.chI().get("openCanvas"), 0);
        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public static boolean z(Intent intent, Context context) {
        int i = 0;
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !el(stringExtra, "adCanvasInfo")) {
                com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{stringExtra});
            } else {
                String str = "";
                boolean Lf = Lf(stringExtra);
                if (Lf) {
                    str = c.IG().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (TextUtils.isEmpty(str)) {
                        i = bxN();
                    } else {
                        int da = c.IG().da("Sns_Canvas_GameShare_JumpWay", 0);
                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "abtestvalue = " + da);
                        if (da != 0) {
                            i = 1;
                        }
                    }
                } else {
                    i = 1;
                }
                if (i == 0) {
                    return b(stringExtra, context, Lf, intent.getIntExtra("sns_landig_pages_from_source", -1));
                }
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, SnsAdNativeLandingPagesUI.class);
                intent2.putExtra("sns_landing_pages_expid", str);
                context.startActivity(intent2);
                return true;
            }
        }
        return false;
    }

    public static boolean a(bnp com_tencent_mm_protocal_c_bnp, Activity activity) {
        String str = com_tencent_mm_protocal_c_bnp.rLO;
        long longValue = new BigInteger(com_tencent_mm_protocal_c_bnp.nGJ).longValue();
        List list = com_tencent_mm_protocal_c_bnp.wQo.vYd;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !el(str, "adCanvasInfo")) {
                com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{str});
            } else {
                String expIdByKey;
                boolean z;
                String str2 = "";
                boolean Lf = Lf(str);
                if (Lf) {
                    expIdByKey = c.IG().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    z = c.IG().da("Sns_Canvas_GameShare_JumpWay", 0) != 0;
                    if (!z && bxN()) {
                        z = true;
                    }
                } else {
                    expIdByKey = str2;
                    z = true;
                }
                if (z) {
                    com.tencent.mm.plugin.sns.storage.m eR = ae.bvv().eR(longValue);
                    Intent intent = new Intent();
                    if (eR != null) {
                        intent.putExtra("sns_landing_pages_share_sns_id", eR.bxW());
                        intent.putExtra("sns_landing_pages_rawSnsId", eR.bxV().nGJ);
                        intent.putExtra("sns_landing_pages_ux_info", eR.byA());
                        intent.putExtra("sns_landing_pages_aid", eR.byv());
                        intent.putExtra("sns_landing_pages_traceid", eR.byw());
                        intent.putExtra("sns_landing_pages_rec_src", eR.byC());
                    }
                    if (list != null && list.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                    }
                    intent.putExtra("sns_landing_pages_expid", expIdByKey);
                    intent.putExtra("sns_landig_pages_from_source", 11);
                    intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landing_pages_xml", str);
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    activity.startActivity(intent);
                    return true;
                }
                b(str, activity, Lf, 11);
            }
        }
        return false;
    }

    public static boolean Lg(String str) {
        return el(str, "adCanvasInfo");
    }

    public static boolean el(String str, String str2) {
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String name;
        if (rnZ == null && rnZ == null) {
            rnZ = new HashSet();
            try {
                inputStream = com.tencent.mm.sdk.platformtools.ac.getContext().getAssets().open("sns/canvas_valid_type.xml");
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(inputStream, "UTF-8");
                int i = -1;
                int eventType = newPullParser.getEventType();
                int i2 = -1;
                while (eventType != 1) {
                    int i3;
                    if (eventType == 2) {
                        boolean z;
                        name = newPullParser.getName();
                        if ("canvastype".equals(name)) {
                            eventType = 0;
                            z = false;
                        } else if ("pagetype".equals(name)) {
                            eventType = 1;
                            z = true;
                        } else if ("componenttype".equals(name)) {
                            eventType = 2;
                            z = true;
                        } else if ("subtype".equals(name)) {
                            z = true;
                            eventType = i2;
                        } else {
                            eventType = i2;
                            z = true;
                        }
                        if (!z) {
                            i2 = bh.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1 ? bh.getInt(newPullParser.getAttributeValue(null, "val"), -1) : -1;
                            switch (z) {
                                case false:
                                case true:
                                case true:
                                    i = eventType;
                                    continue;
                                case true:
                                    if (!(eventType == -1 || i == -1 || i2 == -1)) {
                                        a aVar = new a((byte) 0);
                                        aVar.roa = eventType;
                                        aVar.rob = i;
                                        aVar.roc = i2;
                                        rnZ.add(aVar);
                                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "valid canvas type " + aVar);
                                        break;
                                    }
                            }
                        }
                        i2 = i;
                        i = eventType;
                    } else {
                        i3 = i;
                        i = i2;
                        i2 = i3;
                    }
                    eventType = newPullParser.next();
                    i3 = i2;
                    i2 = i;
                    i = i3;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bh.i(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bh.i(e22));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
            }
        }
        if (rnZ == null || rnZ.isEmpty()) {
            return false;
        }
        Map y = bi.y(str, str2);
        if (y == null || y.isEmpty()) {
            com.tencent.mm.sdk.platformtools.x.w("AdLandingPagesParseHelper", "invalid landingpages xml," + str);
            return false;
        }
        a aVar2 = new a((byte) 0);
        aVar2.roa = 0;
        aVar2.rob = bh.VI((String) y.get(".adCanvasInfo.type"));
        aVar2.roc = bh.VI((String) y.get(".adCanvasInfo.subtype"));
        if (rnZ.contains(aVar2)) {
            name = ".adCanvasInfo.PageList.Page";
            int i4 = 0;
            while (true) {
                String str3;
                aVar2.roa = 1;
                if (i4 == 0) {
                    str3 = name;
                } else {
                    str3 = name + i4;
                }
                if (y.containsKey(str3 + ".componentItemList.componentItem.type")) {
                    aVar2.rob = bh.VI((String) y.get(str3 + ".type"));
                    aVar2.roc = bh.VI((String) y.get(str3 + ".subType"));
                    if (rnZ.contains(aVar2)) {
                        String str4 = str3 + ".componentItemList.componentItem";
                        aVar2.roa = 2;
                        int i5 = 0;
                        while (true) {
                            if (i5 == 0) {
                                str3 = str4;
                            } else {
                                str3 = str4 + i5;
                            }
                            if (y.containsKey(str3 + ".type")) {
                                aVar2.rob = bh.VI((String) y.get(str3 + ".type"));
                                aVar2.roc = bh.VI((String) y.get(str3 + ".subType"));
                                if (rnZ.contains(aVar2)) {
                                    i5++;
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid component type " + aVar2);
                                    return false;
                                }
                            }
                            i4++;
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid page type " + aVar2);
                        return false;
                    }
                }
                aVar2.roa = 2;
                for (Entry entry : y.entrySet()) {
                    if (entry.getKey() != null && ((String) entry.getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")) {
                        String str5 = (String) entry.getKey();
                        String replace = ((String) entry.getKey()).replace(".type", ".subType");
                        aVar2.rob = bh.VI((String) y.get(str5));
                        aVar2.roc = bh.VI((String) y.get(replace));
                        if (!rnZ.contains(aVar2)) {
                            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid component type " + aVar2);
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid canvas type " + aVar2);
        return false;
    }

    public static String w(com.tencent.mm.plugin.sns.storage.m mVar) {
        if (mVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the snsinfo is null");
            return null;
        } else if (mVar.xl(32)) {
            com.tencent.mm.plugin.sns.storage.e byB = mVar.byB();
            if (byB == null) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                return null;
            }
            com.tencent.mm.plugin.sns.storage.b bxR = mVar.bxR();
            if (bxR == null) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adxml is null");
                return null;
            }
            a bxT = mVar.bxT();
            if (bxT == null) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adInfo is null");
                return null;
            } else if (!bxR.bwt()) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                return null;
            } else if (bxT.red != null && bxT.red.size() != 0) {
                return m(byB.field_adxml, bxT.red);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                return null;
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            return null;
        }
    }

    public static String m(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
            return null;
        } else if (map == null || map.size() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
            return null;
        } else {
            LinkedList m = m(str, "adxml", "adId", "");
            for (String str2 : map.keySet()) {
                if (!bh.ov(str2)) {
                    String str3 = (String) map.get(str2);
                    if (!bh.ov(str3)) {
                        String str4;
                        Iterator it = m.iterator();
                        String str5 = null;
                        while (it.hasNext()) {
                            Iterator it2 = ((c) it.next()).rnP.iterator();
                            while (it2.hasNext()) {
                                s sVar = (s) it2.next();
                                if ((sVar instanceof f) && !bh.ov(((f) sVar).kKG) && ((f) sVar).kKG.equals(str2)) {
                                    str4 = ((f) sVar).kLw;
                                    break;
                                }
                            }
                            str4 = str5;
                            if (str4 != null) {
                                break;
                            }
                            str5 = str4;
                        }
                        str4 = str5;
                        if (!bh.ov(r2)) {
                            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "old card ext is " + r2 + " and new card ext is " + str3);
                            str = str.replace(r2, str3);
                            try {
                                str = str.replace(bh.VG(r2), bh.VG(str3));
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the xml is error");
                            }
                        }
                    }
                }
            }
            return str;
        }
    }
}
