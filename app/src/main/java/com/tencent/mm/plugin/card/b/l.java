package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.g.a.or;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static SimpleDateFormat kXB = null;
    private static SimpleDateFormat kXC = null;
    private static SimpleDateFormat kXD = null;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static int wO(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.CardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                x.e("MicroMsg.CardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static int ba(String str, int i) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.CardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                x.e("MicroMsg.CardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static ShapeDrawable z(Context context, int i) {
        return ch(i, context.getResources().getDimensionPixelOffset(R.f.bwg));
    }

    public static ShapeDrawable ch(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static ShapeDrawable d(Context context, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvL);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        return shapeDrawable;
    }

    public static List<b> am(List<kt> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            kt ktVar = (kt) list.get(i);
            b bVar = new b();
            bVar.title = ktVar.title;
            bVar.kJQ = ktVar.kJQ;
            bVar.kNs = ktVar.kNs;
            bVar.url = ktVar.url;
            bVar.vSM = ktVar.vSM;
            bVar.kKb = false;
            bVar.vSN = ktVar.vSN;
            bVar.vSO = ktVar.vSO;
            bVar.oZC = ktVar.oZC;
            bVar.vRx = ktVar.vRx;
            bVar.vRy = ktVar.vRy;
            bVar.kKa = 1;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String bp(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (kXB == null) {
            kXB = new SimpleDateFormat("yyyy.MM.dd");
        }
        return kXB.format(new Date(j2));
    }

    public static boolean wP(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static Bitmap t(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        x.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    public static void u(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.CardUtil", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
    }

    public static boolean b(CardInfo cardInfo) {
        if (cardInfo == null) {
            x.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            return false;
        }
        CardInfo wf = am.auA().wf(cardInfo.field_card_id);
        if (wf == null) {
            boolean b = am.auA().b(cardInfo);
            x.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", Boolean.valueOf(b));
            if (!b) {
                x.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            return b;
        }
        cardInfo.field_stickyIndex = wf.field_stickyIndex;
        cardInfo.field_stickyEndTime = wf.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = wf.field_stickyAnnouncement;
        x.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", Boolean.valueOf(am.auA().c(cardInfo, new String[0])));
        return am.auA().c(cardInfo, new String[0]);
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i) {
        byte[] Q;
        a aVar;
        Bitmap a = j.a(new m(bVar.atB().kJP));
        if (a != null) {
            Q = d.Q(a);
        } else {
            Q = null;
        }
        if (bVar == null) {
            aVar = null;
        } else {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            a aVar2 = new a();
            if (bVar.atB() != null) {
                aVar2.title = bVar.atD().wLJ;
                aVar2.description = bVar.atB().title;
                aVar2.type = 16;
                aVar2.showType = 0;
                aVar2.hbe = 3;
                aVar2.appId = bVar.atB().fFm;
                aVar2.hbu = 0;
                aVar2.thumburl = bVar.atB().kJP;
                aVar2.hcl = i;
                aVar2.hck = bVar.atB().kLa;
                aVar2.url = bVar.atB().vRO;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(bVar.atH()).append("</from_username>");
            if (nY(i)) {
                stringBuilder2.append("<card_id>").append(bVar.atG()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(bVar.atF()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(bVar.atB().kJO).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(bVar.atB().hbM).append("</color>");
            stringBuilder2.append("<card_type_name>").append(bVar.atB().kKZ).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(bVar.atB().kLa).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(bVar.atF()).append("</recommend_card_id>");
            aVar2.hcj = stringBuilder.append(stringBuilder2.toString()).toString();
            aVar2.fys = a.a(aVar2, null, null);
            aVar = aVar2;
        }
        com.tencent.mm.pluginsdk.model.app.l.a(aVar, bVar.atB().fFm, bVar.atB().kLa, str, null, Q);
    }

    public static void bZ(String str, String str2) {
        if (!bh.ov(str)) {
            com.tencent.mm.sdk.b.b orVar = new or();
            orVar.fGI.fGJ = str2;
            orVar.fGI.content = str;
            orVar.fGI.type = s.hp(str2);
            orVar.fGI.flags = 0;
            com.tencent.mm.sdk.b.a.xef.m(orVar);
        }
    }

    public static boolean nY(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    public static boolean nZ(int i) {
        return i == 7 || i == 8 || i == 16 || i == 26;
    }

    public static boolean oa(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    public static boolean nG(int i) {
        switch (i) {
            case 0:
            case 10:
            case 11:
            case 20:
            case 30:
                return true;
            default:
                return false;
        }
    }

    public static void axe() {
        ar.Hg();
        Integer num = (Integer) c.CU().get(282883, null);
        if (num == null || num.intValue() != 1) {
            x.i("MicroMsg.CardUtil", "open card entrance");
            ar.Hg();
            c.CU().set(282883, Integer.valueOf(1));
            com.tencent.mm.s.c.Bq().o(262152, true);
            return;
        }
        x.i("MicroMsg.CardUtil", "card entrance is open");
    }

    public static boolean axf() {
        ar.Hg();
        Integer num = (Integer) c.CU().get(282883, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static void axg() {
        ar.Hg();
        Integer num = (Integer) c.CU().get(w.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            x.i("MicroMsg.CardUtil", "open share card entrance");
            ar.Hg();
            c.CU().a(w.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(1));
            com.tencent.mm.s.c.Bq().o(262152, true);
            return;
        }
        x.i("MicroMsg.CardUtil", "share card entrance is open");
    }

    public static boolean axh() {
        ar.Hg();
        Integer num = (Integer) c.CU().get(w.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static String f(Context context, float f) {
        if (f <= 0.0f) {
            return "";
        }
        if (f > 0.0f && f < 1000.0f) {
            return context.getString(R.l.dOb, new Object[]{((int) f)});
        } else if (f < 1000.0f) {
            return "";
        } else {
            int i = R.l.dOa;
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            return context.getString(i, objArr);
        }
    }

    public static boolean OQ() {
        try {
            return ((LocationManager) ac.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean OR() {
        try {
            return ((LocationManager) ac.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        if (shareCardInfo == null) {
            x.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            return false;
        }
        ShareCardInfo wv = am.auI().wv(shareCardInfo.field_card_id);
        if (wv == null) {
            boolean b = am.auI().b(shareCardInfo);
            x.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", Boolean.valueOf(b));
            if (b) {
                com.tencent.mm.plugin.card.sharecard.a.b.bR(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                x.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            return b;
        }
        shareCardInfo.field_categoryType = wv.field_categoryType;
        shareCardInfo.field_itemIndex = wv.field_itemIndex;
        x.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", Boolean.valueOf(am.auI().c(shareCardInfo, new String[0])));
        return am.auI().c(shareCardInfo, new String[0]);
    }

    public static boolean j(com.tencent.mm.plugin.card.base.b bVar) {
        boolean c;
        if (bVar instanceof CardInfo) {
            c = am.auA().c((CardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            x.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.atF());
            return c;
        } else if (!(bVar instanceof ShareCardInfo)) {
            return false;
        } else {
            c = am.auI().c((ShareCardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            x.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.atF());
            return c;
        }
    }

    public static void wQ(String str) {
        ar.Hg();
        c.CU().a(w.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) str);
    }

    public static String axi() {
        ar.Hg();
        return (String) c.CU().get(w.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) "");
    }

    public static String wR(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        CharSequence gv = r.gv(str);
        CharSequence gu = r.gu(str);
        if (!TextUtils.isEmpty(gv)) {
            return gv;
        }
        if (TextUtils.isEmpty(gu)) {
            return str;
        }
        return gu;
    }

    public static ArrayList<String> an(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        for (String Do : list) {
            Collection Dr = com.tencent.mm.plugin.label.a.a.aUX().Dr(com.tencent.mm.plugin.label.a.a.aUX().Do(Do));
            if (Dr == null || Dr.size() == 0) {
                x.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(Dr);
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public static ArrayList<String> ao(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String Do : list) {
            CharSequence Do2 = com.tencent.mm.plugin.label.a.a.aUX().Do(Do);
            if (!TextUtils.isEmpty(Do2)) {
                arrayList.add(Do2);
            }
        }
        return arrayList;
    }

    public static String wS(String str) {
        List list;
        List<Object> asList = Arrays.asList(str.split(","));
        List linkedList = new LinkedList();
        if (ar.Hj()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                return bh.d(list, ",");
            }
            for (Object obj : asList) {
                Object obj2;
                ar.Hg();
                com.tencent.mm.l.a WO = c.EY().WO(obj2);
                if (!(WO == null || ((int) WO.gJd) == 0)) {
                    obj2 = WO.AQ();
                }
                linkedList.add(obj2);
            }
        }
        list = linkedList;
        return bh.d(list, ",");
    }

    public static bii a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        x.i("MicroMsg.CardUtil", "getShareTag()");
        bii com_tencent_mm_protocal_c_bii = new bii();
        Collection arrayList3;
        int i2;
        String str;
        if (i == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                com_tencent_mm_protocal_c_bii.wLK.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    str = (String) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(str) && wP(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                }
                com_tencent_mm_protocal_c_bii.wLM.addAll(arrayList3);
            }
        } else if (i == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                com_tencent_mm_protocal_c_bii.wLL.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    str = (String) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(str) && wP(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                }
                com_tencent_mm_protocal_c_bii.wLN.addAll(arrayList3);
            }
        }
        return com_tencent_mm_protocal_c_bii;
    }

    public static boolean a(oq oqVar, String str) {
        if (bP(oqVar.vSM)) {
            String str2 = oqVar.title;
            if (wT(str)) {
                x.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            x.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    public static boolean a(b bVar, String str) {
        if (bP(bVar.vSM)) {
            String str2 = bVar.title;
            if (wT(str)) {
                x.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            x.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    private static boolean bP(long j) {
        if ((8 & j) <= 0) {
            return false;
        }
        x.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
        return true;
    }

    private static boolean wT(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "hasShowWarning()");
        ar.Hg();
        String str2 = (String) c.CU().get(w.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void wU(String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            return;
        }
        Object obj2;
        x.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        ar.Hg();
        String str2 = (String) c.CU().get(w.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str2.split(",");
            if (split == null || split.length == 0) {
                x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str2 = str;
            }
            for (Object equals : split) {
                if (str.equals(equals)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                obj2 = str2 + "," + str;
            } else {
                str = str2;
            }
        }
        ar.Hg();
        c.CU().a(w.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, obj2);
    }

    public static String v(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        float f = am.auG().gyA;
        float f2 = am.auG().gyz;
        if (f == -1000.0f || f2 == -85.0f) {
            x.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            return str;
        } else if ((16 & j) <= 0) {
            return str;
        } else {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            x.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:" + str);
            x.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:" + replace);
            return replace;
        }
    }

    public static int wV(String str) {
        if (TextUtils.isEmpty(str) || str.equals(q.FS())) {
            return 0;
        }
        return 1;
    }

    public static Drawable e(Context context, String str, int i) {
        Drawable d = d(context, wO(str), i);
        Drawable ch = ch(wO(str), i);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, ch);
        stateListDrawable.addState(new int[0], d);
        return stateListDrawable;
    }

    public static ColorStateList U(Context context, String str) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, new int[]{context.getResources().getColor(R.e.white), wO(str)});
    }
}
