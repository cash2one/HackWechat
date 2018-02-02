package com.tencent.mm.plugin.ipcall.b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.g.a.as;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.bi;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class a {
    public static int nOj = 3;
    public static String nOk = "+";
    public static String nOl = "00";
    public static String nOm = null;
    private static ao nOn = new ao();
    private static HashMap<String, b> nOo = new HashMap();
    private static HashMap<String, String> nOp = new HashMap();
    private static HashMap<String, String> nOq = new HashMap();
    private static HashMap<String, String> nOr = new HashMap();
    private static HashMap<String, String> nOs = new HashMap();

    public static String ak(Context context, String str) {
        String str2 = null;
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!query.isAfterLast()) {
                            if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.Id(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    x.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[]{e.getMessage()});
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } else {
            x.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        }
        return str2;
    }

    public static String al(Context context, String str) {
        String ak = ak(context, str);
        if (bh.ov(ak)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.g(ak, context);
    }

    public static String am(Context context, String str) {
        if (bh.ov(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.g(str, context);
    }

    public static Bitmap an(Context context, String str) {
        return f(context, str, false);
    }

    public static Bitmap f(Context context, String str, boolean z) {
        if (bh.ov(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.a(str, context, z);
    }

    public static Bitmap ao(Context context, String str) {
        String ak = ak(context, str);
        Bitmap bitmap = null;
        if (!bh.ov(ak)) {
            bitmap = f(context, ak, true);
        }
        if (bitmap != null || !NQ()) {
            return bitmap;
        }
        ak = CZ(str);
        x.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[]{ak});
        if (bh.ov(ak)) {
            return bitmap;
        }
        return b.c(ak, 320, 320, 4);
    }

    public static String CZ(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.q.a.vcA.kU(g.s(c.Dm(str).getBytes()));
    }

    public static String Da(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.q.a.vcA.kV(str);
    }

    public static String rH(int i) {
        Context context = ac.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.ezW);
            case 2:
                return context.getString(R.l.ezY);
            case 4:
                return context.getString(R.l.ezV);
            case 5:
                return context.getString(R.l.ezX);
            case 10:
                return context.getString(R.l.ezU);
            default:
                return context.getString(R.l.ezZ);
        }
    }

    private static void aUJ() {
        String str;
        nOp.clear();
        nOq.clear();
        nOr.clear();
        nOs.clear();
        nOo.clear();
        InputStream inputStream = null;
        String str2 = "";
        try {
            inputStream = ac.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bh.i(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = str2;
                } catch (Throwable e22) {
                    x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bh.i(e22)});
                    str = str2;
                }
            } else {
                str = str2;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{bh.i(e3)});
                }
            }
        }
        String[] split = str.trim().split("\n");
        for (String str3 : split) {
            String[] split2 = str3.trim().split(" ");
            if (split2.length < 2) {
                x.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[]{split[r1]});
            } else {
                b bVar = new b();
                bVar.nOt = split2[0];
                bVar.nOu = split2[1];
                RegionCodeDecoder.cjP();
                str3 = RegionCodeDecoder.getLocName(split2[0]);
                if (bh.ov(str3)) {
                    str3 = new Locale("", split2[0]).getDisplayCountry(ac.getResources().getConfiguration().locale);
                }
                bVar.nOv = str3;
                nOr.put(bVar.nOu, bVar.nOt);
                nOs.put(bVar.nOt, bVar.nOu);
                nOp.put(bVar.nOu, bVar.nOv);
                nOq.put(bVar.nOv, bVar.nOu);
                nOo.put(bVar.nOt, bVar);
            }
        }
    }

    public static HashMap<String, b> aUK() {
        if (nOo.size() == 0) {
            aUJ();
        }
        return nOo;
    }

    public static String Db(String str) {
        if (nOo.size() == 0) {
            aUJ();
        }
        if (bh.ov(str)) {
            return null;
        }
        b bVar = (b) nOo.get(str);
        return bVar != null ? bVar.nOv : null;
    }

    public static String Dc(String str) {
        if (nOp.size() == 0) {
            aUJ();
        }
        if (bh.ov(str)) {
            return null;
        }
        return (String) nOp.get(str);
    }

    public static String Dd(String str) {
        if (nOr.size() == 0) {
            aUJ();
        }
        if (bh.ov(str)) {
            return null;
        }
        return (String) nOr.get(str);
    }

    public static int cZ(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return -1;
        }
        int da = da(str, str2);
        if (da != -1 || !str2.startsWith("+")) {
            return da;
        }
        String De = De(str2);
        if (!bh.ov(De)) {
            str2 = str2.substring(("+" + De).length());
        }
        return da(str, str2);
    }

    private static int da(String str, String str2) {
        int i;
        if (com.tencent.mm.pluginsdk.g.a.aZ(ac.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ac.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            String Dm = c.Dm(str2);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        i = query.getInt(query.getColumnIndex("data2"));
                        if (c.Dm(query.getString(query.getColumnIndex("data1"))).equals(Dm)) {
                            return i;
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                Object[] objArr = new Object[1];
                i = e.getMessage();
                objArr[0] = i;
                x.e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", objArr);
            } finally {
                query.close();
            }
            return -1;
        }
        x.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return -1;
    }

    public static String De(String str) {
        if (nOp.size() == 0) {
            aUJ();
        }
        if (Dg(str)) {
            String Dm = c.Dm(Dh(str));
            List<String> arrayList = new ArrayList(nOp.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new a((byte) 0)));
            for (String str2 : arrayList) {
                if (Dm.startsWith(str2)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public static boolean Df(String str) {
        if (nOp.size() == 0) {
            aUJ();
        }
        if (nOp.containsKey(str)) {
            return true;
        }
        return false;
    }

    public static boolean Dg(String str) {
        if (bh.ov(str) || (!str.startsWith(nOk) && !str.startsWith(nOl))) {
            return false;
        }
        return true;
    }

    public static String Dh(String str) {
        if (bh.ov(str)) {
            return str;
        }
        if (str.startsWith(nOk)) {
            return str.substring(nOk.length());
        }
        if (str.startsWith(nOl)) {
            return str.substring(nOl.length());
        }
        return str;
    }

    public static String Di(String str) {
        String Dm = c.Dm(str);
        String Dm2 = c.Dm(Dm);
        String str2 = null;
        if (Dg(Dm2)) {
            str2 = De(Dm2);
        }
        if (bh.ov(str2)) {
            str2 = ao.Vj(Dm);
        } else {
            Dm = Dh(Dm2).substring(str2.length());
            Dm2 = ao.formatNumber(str2, Dm);
            if (!bh.ov(Dm2)) {
                Dm = Dm2;
            }
            str2 = !Dm.startsWith("+") ? "+" + str2 + " " + Dm : "+" + str2 + " " + Dm.replace("+", "");
        }
        if (str2.length() > 25) {
            return str2.substring(0, 25) + "...";
        }
        return str2;
    }

    public static String aUL() {
        if (nOq.size() == 0) {
            aUJ();
        }
        String cgv = bh.cgv();
        if (!bh.ov(cgv)) {
            x.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[]{cgv});
            cgv = (String) nOs.get(cgv.toUpperCase());
            if (!bh.ov(cgv)) {
                x.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{cgv});
                if (!bh.ov(cgv)) {
                    return cgv;
                }
                cgv = bi.HQ().countryCode;
                x.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{cgv});
                if (!bh.ov(cgv)) {
                    cgv = (String) nOs.get(cgv);
                    if (!bh.ov(cgv)) {
                        x.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{cgv});
                        return cgv;
                    }
                }
                x.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{ac.getContext().getString(R.l.dXH)});
                return ac.getContext().getString(R.l.dXH).replace("+", "");
            }
        }
        cgv = "";
        if (!bh.ov(cgv)) {
            return cgv;
        }
        cgv = bi.HQ().countryCode;
        x.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{cgv});
        if (bh.ov(cgv)) {
            cgv = (String) nOs.get(cgv);
            if (bh.ov(cgv)) {
                x.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{cgv});
                return cgv;
            }
        }
        x.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{ac.getContext().getString(R.l.dXH)});
        return ac.getContext().getString(R.l.dXH).replace("+", "");
    }

    public static void aUM() {
        aUJ();
    }

    public static String Dj(String str) {
        if (nOp.size() == 0) {
            aUJ();
        }
        if (!Dg(str)) {
            return str;
        }
        str = c.Dm(Dh(str));
        List<String> arrayList = new ArrayList(nOp.keySet());
        Collections.sort(arrayList, Collections.reverseOrder(new a((byte) 0)));
        for (String str2 : arrayList) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    public static boolean NQ() {
        com.tencent.mm.sdk.b.b asVar = new as();
        com.tencent.mm.sdk.b.a.xef.m(asVar);
        x.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[]{Boolean.valueOf(asVar.foR.fnI)});
        return asVar.foR.fnI;
    }

    public static ArrayList<String> Dk(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.g.a.aZ(ac.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ac.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("contact_id")));
                        query.moveToNext();
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
            return arrayList;
        }
        x.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return arrayList;
    }
}
