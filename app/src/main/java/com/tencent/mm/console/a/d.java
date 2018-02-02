package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.normsg.a.c;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements a {
    static {
        b.a(new d(), new String[]{"//normsg"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (!com.tencent.mm.sdk.a.b.ceK()) {
            return false;
        }
        if (strArr.length < 2) {
            return false;
        }
        int intValue;
        String toLowerCase;
        long nanoTime;
        int i;
        CharSequence t;
        long nanoTime2;
        try {
            if (strArr.length >= 3) {
                intValue = Integer.valueOf(strArr[2]).intValue();
                toLowerCase = strArr[1].toLowerCase();
                nanoTime = System.nanoTime();
                i = -1;
                switch (toLowerCase.hashCode()) {
                    case -1621532861:
                        if (toLowerCase.equals("testturing")) {
                            i = 9;
                            break;
                        }
                        break;
                    case -1422437344:
                        if (toLowerCase.equals("testrpp")) {
                            i = 8;
                            break;
                        }
                        break;
                    case -625689748:
                        if (toLowerCase.equals("checksofttype")) {
                            boolean z = true;
                            break;
                        }
                        break;
                    case 1078188459:
                        if (toLowerCase.equals("checkmsglevel")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 2078454342:
                        if (toLowerCase.equals("checksofttype2")) {
                            i = 2;
                            break;
                        }
                        break;
                    case 2078454343:
                        if (toLowerCase.equals("checksofttype3")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 2078454344:
                        if (toLowerCase.equals("checksofttype4")) {
                            i = 4;
                            break;
                        }
                        break;
                    case 2078454345:
                        if (toLowerCase.equals("checksofttype5")) {
                            i = 5;
                            break;
                        }
                        break;
                    case 2078454346:
                        if (toLowerCase.equals("checksofttype6")) {
                            i = 6;
                            break;
                        }
                        break;
                    case 2078454347:
                        if (toLowerCase.equals("checksofttype7")) {
                            i = 7;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        c.oSr.tZ(intValue);
                        break;
                    case 1:
                        c.oSr.ua(intValue);
                        break;
                    case 2:
                        c.oSr.ub(intValue);
                        break;
                    case 3:
                        c.oSr.uc(intValue);
                        break;
                    case 4:
                        c.oSr.ud(intValue);
                        break;
                    case 5:
                        c.oSr.ue(intValue);
                        break;
                    case 6:
                        c.oSr.uf(intValue);
                        break;
                    case 7:
                        c.oSr.ug(intValue);
                        break;
                    case 8:
                        t = com.tencent.mm.plugin.normsg.a.d.oSu.t(true, true);
                        com.tencent.mm.plugin.secinforeport.a.d.qfi.IX(t);
                        com.tencent.mm.plugin.secinforeport.a.d.qfi.bX(t, 0);
                        com.tencent.mm.pluginsdk.h.c.a(context, "normsg", t);
                        Toast.makeText(context, "result is copied to clipboard.", 0).show();
                        break;
                    case 9:
                        com.tencent.mm.plugin.normsg.a.d.oSu.T(1, 1, 4);
                        ag.h(new 1(this), 4000);
                        Toast.makeText(context, "turing info is reported.", 0).show();
                        break;
                    default:
                        return false;
                }
                nanoTime2 = System.nanoTime() - nanoTime;
                t = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
                x.i("MicroMsg.NorMsgTest", t);
                Toast.makeText(context, t, 0).show();
                return true;
            }
        } catch (Exception e) {
        }
        intValue = 1;
        toLowerCase = strArr[1].toLowerCase();
        nanoTime = System.nanoTime();
        i = -1;
        switch (toLowerCase.hashCode()) {
            case -1621532861:
                if (toLowerCase.equals("testturing")) {
                    i = 9;
                    break;
                }
                break;
            case -1422437344:
                if (toLowerCase.equals("testrpp")) {
                    i = 8;
                    break;
                }
                break;
            case -625689748:
                if (toLowerCase.equals("checksofttype")) {
                    boolean z2 = true;
                    break;
                }
                break;
            case 1078188459:
                if (toLowerCase.equals("checkmsglevel")) {
                    i = 0;
                    break;
                }
                break;
            case 2078454342:
                if (toLowerCase.equals("checksofttype2")) {
                    i = 2;
                    break;
                }
                break;
            case 2078454343:
                if (toLowerCase.equals("checksofttype3")) {
                    i = 3;
                    break;
                }
                break;
            case 2078454344:
                if (toLowerCase.equals("checksofttype4")) {
                    i = 4;
                    break;
                }
                break;
            case 2078454345:
                if (toLowerCase.equals("checksofttype5")) {
                    i = 5;
                    break;
                }
                break;
            case 2078454346:
                if (toLowerCase.equals("checksofttype6")) {
                    i = 6;
                    break;
                }
                break;
            case 2078454347:
                if (toLowerCase.equals("checksofttype7")) {
                    i = 7;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                c.oSr.tZ(intValue);
                break;
            case 1:
                c.oSr.ua(intValue);
                break;
            case 2:
                c.oSr.ub(intValue);
                break;
            case 3:
                c.oSr.uc(intValue);
                break;
            case 4:
                c.oSr.ud(intValue);
                break;
            case 5:
                c.oSr.ue(intValue);
                break;
            case 6:
                c.oSr.uf(intValue);
                break;
            case 7:
                c.oSr.ug(intValue);
                break;
            case 8:
                t = com.tencent.mm.plugin.normsg.a.d.oSu.t(true, true);
                com.tencent.mm.plugin.secinforeport.a.d.qfi.IX(t);
                com.tencent.mm.plugin.secinforeport.a.d.qfi.bX(t, 0);
                com.tencent.mm.pluginsdk.h.c.a(context, "normsg", t);
                Toast.makeText(context, "result is copied to clipboard.", 0).show();
                break;
            case 9:
                com.tencent.mm.plugin.normsg.a.d.oSu.T(1, 1, 4);
                ag.h(new 1(this), 4000);
                Toast.makeText(context, "turing info is reported.", 0).show();
                break;
            default:
                return false;
        }
        nanoTime2 = System.nanoTime() - nanoTime;
        t = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
        x.i("MicroMsg.NorMsgTest", t);
        Toast.makeText(context, t, 0).show();
        return true;
    }
}
