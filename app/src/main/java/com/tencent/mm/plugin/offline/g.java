package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.HashSet;
import java.util.Map;

public final class g {
    public static String TAG = "MicroMsg.OfflineGetMsgLogic";
    public static int oVA = CdnLogic.kMediaTypeBackupFile;
    public static int oVB = 10001;
    public static int oVC;
    public static int oVo = 5000;
    private static int oVp;
    private static int oVq = 5000;
    public static int oVr = 0;
    public static int oVs = 24;
    public static int oVt = 4;
    public static int oVu = 8;
    public static int oVv = 23;
    public static int oVw = 6;
    public static int oVx = 5;
    public static int oVy = 20;
    public static int oVz = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    public e oVD = new 1(this);
    public boolean oVE = true;
    public ak oVF = new ak(new 2(this), false);
    public int status = 0;

    static /* synthetic */ void bgU() {
        x.i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        k dVar = new d();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(dVar, 0);
    }

    static {
        oVp = 30000;
        oVC = oVq;
        com.tencent.mm.kernel.g.Dk();
        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, null);
        if (obj != null) {
            int intValue;
            intValue = ((Integer) obj).intValue();
            oVC = intValue;
            if (intValue == 0) {
                oVC = oVq;
            }
        }
        com.tencent.mm.kernel.g.Dk();
        obj = com.tencent.mm.kernel.g.Dj().CU().get(a.BUSINESS_OFFLINE_GETMSG_MAX_POS_TIME_INT, Integer.valueOf(0));
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                oVp = intValue;
            }
        }
    }

    public static int bgS() {
        return oVp;
    }

    public g() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(385, this.oVD);
    }

    private static boolean a(r rVar) {
        boolean z = false;
        if (rVar != null) {
            x.i(TAG, "isOrderClosed lastest status req_key=" + rVar.field_reqkey);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(oVz));
        hashSet.add(Integer.valueOf(oVw));
        hashSet.add(Integer.valueOf(oVx));
        hashSet.add(Integer.valueOf(oVt));
        hashSet.add(Integer.valueOf(-1));
        if (rVar == null || hashSet.contains(Integer.valueOf(rVar.field_status))) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("isOrderClosed true;status==null?");
            if (rVar == null) {
                z = true;
            }
            x.i(str, stringBuilder.append(z).toString());
            if (rVar != null) {
                x.i(TAG, "isOrderClosed status.field_status=" + rVar.field_status);
            }
            return true;
        }
        x.i(TAG, "isOrderClosed false");
        if (rVar != null) {
            x.i(TAG, "status=" + rVar.field_status + ";req_key=" + rVar.field_reqkey);
            return false;
        }
        x.i(TAG, "isOrderClosed status=null");
        return false;
    }

    public static boolean dF(String str, String str2) {
        Object obj;
        String str3;
        int i;
        if (bh.ov(str2)) {
            x.i(TAG, "shouldDeal appmsg is null");
            obj = null;
        } else {
            String str4;
            String str5;
            Object[] objArr;
            Object[] objArr2;
            int i2;
            boolean z;
            Map y = bi.y(str2, "sysmsg");
            str3 = (String) y.get(".sysmsg.paymsg.req_key");
            i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            k.bgX();
            r GR = k.bhb().GR(str3);
            k.bgX();
            r bhf = k.bhb().bhf();
            boolean a = a(bhf);
            if (GR != null) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 63, 1, true);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 64, 1, true);
            }
            String str6;
            if (bhf != null) {
                str6 = TAG;
                Object[] objArr3 = new Object[3];
                objArr3[0] = bhf.field_reqkey;
                objArr3[1] = Integer.valueOf(bhf.field_status);
                str4 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
                str5 = str6;
                objArr = objArr3;
                objArr2 = objArr3;
                i2 = 2;
                z = a;
            } else {
                str4 = TAG;
                str6 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(a);
                i2 = 1;
                if (GR == null) {
                    z = true;
                    str5 = str4;
                    str4 = str6;
                    objArr2 = objArr;
                } else {
                    z = false;
                    str5 = str4;
                    str4 = str6;
                    objArr2 = objArr;
                }
            }
            objArr[i2] = Boolean.valueOf(z);
            x.i(str5, str4, objArr2);
            if (GR == null) {
                if (bhf == null) {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", str3, Integer.valueOf(i));
                    obj = 1;
                } else if (a) {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", str3, Integer.valueOf(i), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                    obj = 1;
                } else {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", str3, Integer.valueOf(i), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                    obj = null;
                }
            } else if (a(GR)) {
                x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", GR.field_reqkey, Integer.valueOf(i), Integer.valueOf(GR.field_status));
                obj = null;
            } else if (bhf == null) {
                x.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", str3, Integer.valueOf(i), Integer.valueOf(GR.field_status));
                k.bgX();
                k.bhb().GS(str3);
                obj = null;
            } else {
                x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", str3, Integer.valueOf(i), Integer.valueOf(GR.field_status), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                if (GR.field_reqkey.equals(bhf.field_reqkey)) {
                    if (db(bhf.field_status, i)) {
                        x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", str3, Integer.valueOf(i), Integer.valueOf(GR.field_status), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                        obj = 1;
                    } else {
                        x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", str3, Integer.valueOf(i), Integer.valueOf(GR.field_status), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                        if (bhf.field_status != i) {
                            x.i(TAG, "mark reqKey: %s as give up", str3);
                            k.bgX();
                            k.bhb().GS(str3);
                        }
                        obj = null;
                    }
                } else if (a) {
                    x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", str3, Integer.valueOf(i), Integer.valueOf(GR.field_status), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                    obj = 1;
                } else {
                    x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", str3, Integer.valueOf(i), Integer.valueOf(GR.field_status), bhf.field_reqkey, Integer.valueOf(bhf.field_status));
                    k.bgX();
                    k.bhb().GS(str3);
                    obj = null;
                }
            }
        }
        if (obj != null) {
            k.bgX();
            r bhf2 = k.bhb().bhf();
            y = bi.y(str2, "sysmsg");
            i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            str3 = (String) y.get(".sysmsg.paymsg.req_key");
            if (i == 24) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 58, 1, true);
            } else if (i == 6) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 59, 1, true);
            } else if (i == 4 || i == 5 || i == 20) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 60, 1, true);
            } else if (i == 23) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 66, 1, true);
            }
            if (bhf2 == null || bhf2.field_reqkey == null || !bhf2.field_reqkey.equals(str3)) {
                r rVar = new r();
                rVar.field_reqkey = str3;
                if (!bh.ov(str)) {
                    rVar.field_ack_key = str;
                }
                rVar.field_status = oVr;
                a(rVar, i);
            } else {
                a(bhf2, i);
            }
            x.i(TAG, "dealMsg true");
            return true;
        }
        x.i(TAG, "dealMsg false");
        return false;
    }

    private static boolean db(int i, int i2) {
        x.i(TAG, "checkStatus from=" + i + ";to=" + i2);
        if (i == i2) {
            return false;
        }
        if (i == oVr) {
            return true;
        }
        if (i == oVs) {
            if (i2 != oVs) {
                return true;
            }
            return false;
        } else if (i == oVw) {
            if (i2 == oVz) {
                return true;
            }
            return false;
        } else if (i == oVx) {
            if (i2 == oVz) {
                return true;
            }
            return false;
        } else if (i == oVt) {
            if (i2 == oVz) {
                return true;
            }
            return false;
        } else if (i == oVy) {
            if (i2 == oVz) {
                return true;
            }
            return false;
        } else if (i == oVu || i == oVv) {
            if (i2 == oVw || i2 == oVz) {
                return true;
            }
            return false;
        } else if (i != oVB) {
            return false;
        } else {
            if (i2 == oVw || i2 == oVz) {
                return true;
            }
            return false;
        }
    }

    private static boolean a(r rVar, int i) {
        if (i == oVt) {
            i = oVz;
        }
        boolean db = db(rVar.field_status, i);
        x.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", Boolean.valueOf(db), Integer.valueOf(rVar.field_status), Integer.valueOf(i));
        if (db) {
            rVar.field_status = i;
            k.bgX();
            k.bhb().b(rVar);
        }
        return db;
    }

    public static void bQ(String str, int i) {
        if (!bh.ov(str)) {
            k.bgX();
            r GR = k.bhb().GR(str);
            if (GR != null) {
                a(GR, i);
                return;
            }
            GR = new r();
            GR.field_reqkey = str;
            GR.field_status = i;
            k.bgX();
            k.bhb().b(GR);
        }
    }

    public static void bgT() {
        long j;
        x.i(TAG, "endAllOldOrder");
        k.bgX();
        com.tencent.mm.plugin.offline.b.a bhb = k.bhb();
        x.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", Integer.valueOf(bhb.bhh()), bhb.bhg());
        Cursor a = bhb.gJP.a(String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[]{"rowid", "OfflineOrderStatus", "rowid"}), null, 2);
        if (a == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
            j = 0;
        } else {
            a.moveToFirst();
            j = (a.isAfterLast() || a.getColumnCount() <= 0) ? 0 : a.getLong(0);
            a.close();
        }
        if (j - 10 > 0) {
            x.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", Long.valueOf(j), String.format("DELETE FROM %s WHERE %s < %d;", new Object[]{"OfflineOrderStatus", "rowid", Long.valueOf(j - 10)}));
            bhb.gJP.fx("OfflineOrderStatus", r2);
        } else {
            x.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", Long.valueOf(j));
        }
        bhb.gJP.fx("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + oVz + " where status!=" + oVz);
    }

    public final void stop() {
        if (com.tencent.mm.plugin.offline.c.a.bij()) {
            x.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.oVF.cfK());
            if (!this.oVF.cfK()) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 62, 1, true);
                this.oVF.TG();
            }
        }
    }
}
