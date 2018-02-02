package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.R;
import com.tencent.mm.au.a;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c {
    public static bth X(LinkedList<ayc> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        bth com_tencent_mm_protocal_c_bth = new bth();
        com_tencent_mm_protocal_c_bth.wUx = linkedList.size();
        com_tencent_mm_protocal_c_bth.wUy = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ayc com_tencent_mm_protocal_c_ayc = (ayc) it.next();
            btg com_tencent_mm_protocal_c_btg = new btg();
            com_tencent_mm_protocal_c_btg.wQd = Dl(com_tencent_mm_protocal_c_ayc.wvP);
            com_tencent_mm_protocal_c_btg.wFo = com_tencent_mm_protocal_c_ayc.wFo;
            com_tencent_mm_protocal_c_bth.wUy.add(com_tencent_mm_protocal_c_btg);
        }
        return com_tencent_mm_protocal_c_bth;
    }

    private static int Dl(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                int i2 = 0;
                while (i < address.length) {
                    int i3 = (address[i] & 255) | (i2 << 8);
                    i++;
                    i2 = i3;
                }
                x.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i2));
                return i2;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        return 0;
    }

    public static int aUN() {
        Context context = ac.getContext();
        if (an.is2G(context)) {
            return 1;
        }
        if (an.is3G(context)) {
            return 3;
        }
        if (an.is4G(context)) {
            return 5;
        }
        if (an.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static String Dm(String str) {
        return str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    }

    public static String rI(int i) {
        Context context = ac.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.ers);
            case 2:
                return context.getString(R.l.ers);
            case 6:
                return context.getString(R.l.ero);
            case 7:
                return context.getString(R.l.erp);
            default:
                return context.getString(R.l.ers);
        }
    }

    public static CharSequence h(Context context, long j) {
        return DateFormat.format(context.getString(R.l.eiQ), j);
    }

    public static String ap(Context context, String str) {
        int i = 0;
        String[] stringArray = context.getResources().getStringArray(R.c.brb);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = bh.getInt(str, 0);
        } catch (Exception e) {
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String dC(long j) {
        Object obj = 1;
        Context context = ac.getContext();
        if ((dD(j) == 0 ? 1 : null) != null) {
            return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
        }
        if (dD(j) != -1) {
            obj = null;
        }
        if (obj != null) {
            return context.getString(R.l.eqz);
        }
        return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
    }

    private static long dD(long j) {
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        return (j / timeInMillis2) - (Calendar.getInstance().getTimeInMillis() / timeInMillis2);
    }

    public static String dE(long j) {
        Context context = ac.getContext();
        if (((double) j) <= 60.0d) {
            return context.getString(R.l.eqE, new Object[]{String.valueOf(j)});
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        return context.getString(R.l.eqD, new Object[]{String.valueOf(i)});
    }

    public static boolean cX(Context context) {
        int i;
        if (d.bIq()) {
            i = R.l.epw;
        } else if (d.bIr()) {
            i = R.l.epv;
        } else if (a.Qk()) {
            i = R.l.epu;
        } else if (com.tencent.mm.p.a.AW()) {
            i = R.l.epr;
        } else {
            boolean z;
            if (q.a.vcp == null || !q.a.vcp.bEJ()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i = R.l.epu;
            } else {
                i = 0;
            }
        }
        if (i == 0) {
            return true;
        }
        h.h(context, i, R.l.dGO);
        return false;
    }

    public static void c(MMActivity mMActivity, String str) {
        ((ClipboardManager) mMActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public static String aUO() {
        String string = ac.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (bh.ov(string)) {
            return a.aUL();
        }
        return string.replace("+", "");
    }

    public static boolean aUP() {
        return g.zY().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0;
    }

    public static aid aUQ() {
        ar.Hg();
        Object obj = com.tencent.mm.z.c.CU().get(w.a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, null);
        if (obj != null) {
            aid com_tencent_mm_protocal_c_aid = new aid();
            try {
                com_tencent_mm_protocal_c_aid.aF(bh.VD(obj.toString()));
                x.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", com_tencent_mm_protocal_c_aid.wpr, com_tencent_mm_protocal_c_aid.nGK, com_tencent_mm_protocal_c_aid.fon, com_tencent_mm_protocal_c_aid.nfe, com_tencent_mm_protocal_c_aid.wps, com_tencent_mm_protocal_c_aid.wpt, com_tencent_mm_protocal_c_aid.wpu, com_tencent_mm_protocal_c_aid.wpv, com_tencent_mm_protocal_c_aid.wpC);
                return com_tencent_mm_protocal_c_aid;
            } catch (IOException e) {
                x.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", e.getMessage());
            }
        }
        return null;
    }
}
