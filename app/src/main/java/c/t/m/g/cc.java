package c.t.m.g;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public final class cc {
    private static Handler a = m.i();
    private static boolean b = true;
    private static boolean c = true;

    private static int a(String str, int i) {
        int i2 = 1;
        if (str.equals("HLDisconnEvent")) {
            return -2;
        }
        int i3;
        String str2;
        if (i != 0) {
            i3 = (i == -4 || i == -3 || i == -288) ? 1 : 0;
            if (i3 == 0) {
                str2 = "self_report_fail_rate";
                if (i != 0) {
                    i3 = (i != -4 || i == -3 || i == -288) ? 1 : 0;
                    if (i3 == 0) {
                        i2 = 50;
                    }
                }
                return v.a(str2, 0, 100, i2);
            }
        }
        str2 = "self_report_succ_rate";
        if (i != 0) {
            if (i != -4) {
            }
            if (i3 == 0) {
                i2 = 50;
            }
        }
        return v.a(str2, 0, 100, i2);
    }

    public static void a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        a.post(new cd(str, i, i2, str2, map, map2, z));
    }

    public static void b(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        a.post(new ce(str, i, i2, str2, map, map2, z));
    }

    static /* synthetic */ void a(String str, int i, int i2, String str2, Map map, Map map2, boolean z, boolean z2) {
        int i3;
        Object obj;
        Iterator it;
        Object obj2;
        int i4;
        Object obj3;
        int a;
        String str3;
        Object obj4;
        int i5;
        String str4;
        StringBuilder stringBuilder;
        CharSequence h;
        boolean z3;
        if (z) {
            try {
                if (p.l()) {
                    i3 = -288;
                    obj = null;
                } else {
                    p.e();
                    int i6;
                    if (!p.h()) {
                        i3 = -4;
                        i6 = 1;
                    } else if (!y.a()) {
                        i3 = -3;
                        str2 = "ping failed, " + str2;
                        i6 = 1;
                    }
                }
                if (map2 != null) {
                    if (map2.containsKey("B83")) {
                        map2.put("B83", cg.a(Long.parseLong((String) map2.get("B83")), "yyyy-MM-dd HH:mm:ss.SSS"));
                    }
                    if (map2.containsKey("B84")) {
                        map2.put("B84", cg.a(Long.parseLong((String) map2.get("B84")), "yyyy-MM-dd HH:mm:ss.SSS"));
                    }
                }
                if (map != null) {
                    it = map.keySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                if (map2 != null) {
                    it = map2.keySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                if (i == m.b()) {
                    if (!b && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
                        b = false;
                        obj2 = 1;
                        if (z2) {
                            i4 = 100;
                            obj3 = 1;
                        } else {
                            if (i == 2) {
                                if ("event".equals((String) map.get("B15"))) {
                                    a = a(str, i3);
                                }
                                str3 = "";
                                if ("HLConnEvent".equals(str)) {
                                    if (i3 == 0) {
                                        if (i3 != -4) {
                                        }
                                        obj4 = 1;
                                        if (obj4 != null) {
                                        }
                                    } else {
                                        str3 = "report_conn_succ_rate";
                                    }
                                    if (i3 == 0) {
                                        if (i3 != -4) {
                                        }
                                        obj4 = 1;
                                        if (obj4 != null) {
                                            i4 = 100;
                                        } else {
                                            i4 = 1;
                                        }
                                    } else {
                                        i4 = 1;
                                    }
                                    i5 = i4;
                                    i4 = 0;
                                    str4 = str3;
                                    a = i5;
                                } else if ("HLSecurityEvent".equals(str)) {
                                    if (i3 == 0) {
                                    }
                                    if (i3 == 0) {
                                    }
                                    i5 = i3 == 0 ? 1 : 100;
                                    i4 = 0;
                                    str4 = i3 == 0 ? "report_security_req_succ_rate" : "report_security_req_fail_rate";
                                    a = i5;
                                } else if ("HLDisconnEvent".equals(str)) {
                                    if (!"HLReqRspEvent".equals(str)) {
                                    }
                                    if (obj2 == null) {
                                    }
                                    if (i3 == 0) {
                                        if (i3 != -4) {
                                        }
                                        obj4 = 1;
                                        if (obj4 != null) {
                                        }
                                    } else {
                                        str3 = "report_req_succ_rate";
                                    }
                                    if (i3 == 0) {
                                        if (i3 != -4) {
                                        }
                                        obj4 = 1;
                                        if (obj4 != null) {
                                            i4 = 100;
                                        } else {
                                            i4 = 1;
                                        }
                                    } else {
                                        i4 = 1;
                                    }
                                    i5 = i4;
                                    i4 = 0;
                                    str4 = str3;
                                    a = i5;
                                } else {
                                    i4 = 0;
                                    str4 = "report_disconn_rate";
                                    a = 50;
                                }
                                if (i4 == 0) {
                                    if (v.a("report_all_events", 0, 1, 0) == 1) {
                                        i4 = v.a(str4, 0, 100, a);
                                    } else {
                                        i4 = 100;
                                    }
                                }
                                a = i4;
                            } else {
                                a = a(str, i3);
                            }
                            obj4 = null;
                            if (a > 0) {
                            }
                            obj4 = 1;
                            i5 = a;
                            obj3 = obj4;
                            i4 = i5;
                        }
                        if (obj3 != null) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put("B9", String.valueOf(i4));
                            str3 = "B7";
                            stringBuilder = new StringBuilder();
                            if (obj != null) {
                                i4 = i2;
                            } else {
                                i4 = i3;
                            }
                            map.put(str3, stringBuilder.append(i4).toString());
                            if (obj2 != null) {
                                map.put("B28", "1");
                            }
                            map.put("B1", m.g());
                            map.put("B2", m.b);
                            map.put("B30", m.e());
                            map.put("B3", String.valueOf(i));
                            h = m.h();
                            if (!TextUtils.isEmpty(h)) {
                                map.put("B4", h);
                            }
                            map.put("B5", cb.a());
                            h = p.c();
                            if (!TextUtils.isEmpty(h)) {
                                map.put("B29", h);
                            }
                            if (v.a("access_report_detail", 0, 1, 1) == 1) {
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                map.put("B6", p.b());
                                map.put("B8", str2);
                                map.put("D1", m.c());
                                map.put("D2", m.d());
                                map.put("D3", m.d);
                            }
                            if (i2 == 0) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            v.a(str, z3, map);
                        }
                    } else if (c && "HLHttpDirect".equals(str)) {
                        String str5 = (String) map.get("B15");
                        if (!cg.a(str5) && str5.equals("app")) {
                            c = false;
                            int i7 = 1;
                            if (z2) {
                                if (i == 2) {
                                    a = a(str, i3);
                                } else {
                                    if ("HLHttpDirect".equals(str) && map != null) {
                                        if ("event".equals((String) map.get("B15"))) {
                                            a = a(str, i3);
                                        }
                                    }
                                    str3 = "";
                                    if ("HLConnEvent".equals(str)) {
                                        if (i3 == 0) {
                                            str3 = "report_conn_succ_rate";
                                        } else {
                                            if (i3 != -4 || i3 == -3 || i3 == -288) {
                                                obj4 = 1;
                                            } else {
                                                obj4 = null;
                                            }
                                            str3 = obj4 != null ? "report_conn_nonet_fail_rate" : "report_conn_other_fail_rate";
                                        }
                                        if (i3 == 0) {
                                            i4 = 1;
                                        } else {
                                            if (i3 != -4 || i3 == -3 || i3 == -288) {
                                                obj4 = 1;
                                            } else {
                                                obj4 = null;
                                            }
                                            if (obj4 != null) {
                                                i4 = 1;
                                            } else {
                                                i4 = 100;
                                            }
                                        }
                                        i5 = i4;
                                        i4 = 0;
                                        str4 = str3;
                                        a = i5;
                                    } else if ("HLSecurityEvent".equals(str)) {
                                        i5 = i3 == 0 ? 1 : 100;
                                        i4 = 0;
                                        str4 = i3 == 0 ? "report_security_req_succ_rate" : "report_security_req_fail_rate";
                                        a = i5;
                                    } else if ("HLDisconnEvent".equals(str)) {
                                        i4 = 0;
                                        str4 = "report_disconn_rate";
                                        a = 50;
                                    } else if ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str)) {
                                        if (obj2 == null && i3 == 0) {
                                            i4 = 0;
                                            str4 = "report_req_ssl_first_rate";
                                            a = 1;
                                        } else {
                                            if (i3 == 0) {
                                                str3 = "report_req_succ_rate";
                                            } else {
                                                if (i3 != -4 || i3 == -3 || i3 == -288) {
                                                    obj4 = 1;
                                                } else {
                                                    obj4 = null;
                                                }
                                                str3 = obj4 != null ? "report_req_nonet_fail_rate" : "report_req_other_fail_rate";
                                            }
                                            if (i3 == 0) {
                                                i4 = 1;
                                            } else {
                                                if (i3 != -4 || i3 == -3 || i3 == -288) {
                                                    obj4 = 1;
                                                } else {
                                                    obj4 = null;
                                                }
                                                if (obj4 != null) {
                                                    i4 = 1;
                                                } else {
                                                    i4 = 100;
                                                }
                                            }
                                            i5 = i4;
                                            i4 = 0;
                                            str4 = str3;
                                            a = i5;
                                        }
                                    } else if ("HLPushEvent".equals(str)) {
                                        i4 = 0;
                                        str4 = "report_push_rate";
                                        a = 10;
                                    } else if ("B_DLSDK_Result".equals(str)) {
                                        i4 = 0;
                                        str4 = "report_mass_download_rate";
                                        a = 100;
                                    } else if ("HLDownTiny".equals(str)) {
                                        i4 = 0;
                                        str4 = "report_ease_download_rate";
                                        a = 10;
                                    } else if ("HLHeartBeat".equals(str)) {
                                        i5 = i3 == 0 ? 10 : 20;
                                        i4 = 0;
                                        str4 = i3 == 0 ? "report_heartbeat_succ_rate" : "report_heartbeat_fail_rate";
                                        a = i5;
                                    } else {
                                        i4 = -1;
                                        str4 = str3;
                                        a = 0;
                                    }
                                    if (i4 == 0) {
                                        if (v.a("report_all_events", 0, 1, 0) == 1) {
                                            i4 = 100;
                                        } else {
                                            i4 = v.a(str4, 0, 100, a);
                                        }
                                    }
                                    a = i4;
                                }
                                obj4 = null;
                                if (a > 0 || a >= 100) {
                                    if (a == -1 || a == 100) {
                                        obj4 = 1;
                                    }
                                    i5 = a;
                                    obj3 = obj4;
                                    i4 = i5;
                                } else {
                                    if (new Random().nextInt(100) <= a) {
                                        obj4 = 1;
                                    } else {
                                        obj4 = null;
                                    }
                                    i5 = a;
                                    obj3 = obj4;
                                    i4 = i5;
                                }
                            } else {
                                i4 = 100;
                                obj3 = 1;
                            }
                            if (obj3 != null) {
                                if (map == null) {
                                    map = new HashMap();
                                }
                                if (i4 > 0 && i4 < 100) {
                                    map.put("B9", String.valueOf(i4));
                                }
                                str3 = "B7";
                                stringBuilder = new StringBuilder();
                                if (obj != null) {
                                    i4 = i3;
                                } else {
                                    i4 = i2;
                                }
                                map.put(str3, stringBuilder.append(i4).toString());
                                if (obj2 != null) {
                                    map.put("B28", "1");
                                }
                                map.put("B1", m.g());
                                map.put("B2", m.b);
                                map.put("B30", m.e());
                                map.put("B3", String.valueOf(i));
                                h = m.h();
                                if (TextUtils.isEmpty(h)) {
                                    map.put("B4", h);
                                }
                                map.put("B5", cb.a());
                                h = p.c();
                                if (TextUtils.isEmpty(h)) {
                                    map.put("B29", h);
                                }
                                if (v.a("access_report_detail", 0, 1, 1) == 1) {
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    map.put("B6", p.b());
                                    if (!(i3 == -4 || TextUtils.isEmpty(str2))) {
                                        map.put("B8", str2);
                                    }
                                    map.put("D1", m.c());
                                    map.put("D2", m.d());
                                    map.put("D3", m.d);
                                }
                                if (i2 == 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                v.a(str, z3, map);
                            }
                        }
                    }
                }
                obj2 = null;
                if (z2) {
                    if (i == 2) {
                        a = a(str, i3);
                    } else {
                        if ("event".equals((String) map.get("B15"))) {
                            a = a(str, i3);
                        }
                        str3 = "";
                        if ("HLConnEvent".equals(str)) {
                            if (i3 == 0) {
                                str3 = "report_conn_succ_rate";
                            } else {
                                if (i3 != -4) {
                                }
                                obj4 = 1;
                                if (obj4 != null) {
                                }
                            }
                            if (i3 == 0) {
                                i4 = 1;
                            } else {
                                if (i3 != -4) {
                                }
                                obj4 = 1;
                                if (obj4 != null) {
                                    i4 = 1;
                                } else {
                                    i4 = 100;
                                }
                            }
                            i5 = i4;
                            i4 = 0;
                            str4 = str3;
                            a = i5;
                        } else if ("HLSecurityEvent".equals(str)) {
                            if (i3 == 0) {
                            }
                            if (i3 == 0) {
                            }
                            i5 = i3 == 0 ? 1 : 100;
                            i4 = 0;
                            str4 = i3 == 0 ? "report_security_req_succ_rate" : "report_security_req_fail_rate";
                            a = i5;
                        } else if ("HLDisconnEvent".equals(str)) {
                            i4 = 0;
                            str4 = "report_disconn_rate";
                            a = 50;
                        } else {
                            if ("HLReqRspEvent".equals(str)) {
                            }
                            if (obj2 == null) {
                            }
                            if (i3 == 0) {
                                str3 = "report_req_succ_rate";
                            } else {
                                if (i3 != -4) {
                                }
                                obj4 = 1;
                                if (obj4 != null) {
                                }
                            }
                            if (i3 == 0) {
                                i4 = 1;
                            } else {
                                if (i3 != -4) {
                                }
                                obj4 = 1;
                                if (obj4 != null) {
                                    i4 = 1;
                                } else {
                                    i4 = 100;
                                }
                            }
                            i5 = i4;
                            i4 = 0;
                            str4 = str3;
                            a = i5;
                        }
                        if (i4 == 0) {
                            if (v.a("report_all_events", 0, 1, 0) == 1) {
                                i4 = 100;
                            } else {
                                i4 = v.a(str4, 0, 100, a);
                            }
                        }
                        a = i4;
                    }
                    obj4 = null;
                    if (a > 0) {
                    }
                    obj4 = 1;
                    i5 = a;
                    obj3 = obj4;
                    i4 = i5;
                } else {
                    i4 = 100;
                    obj3 = 1;
                }
                if (obj3 != null) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put("B9", String.valueOf(i4));
                    str3 = "B7";
                    stringBuilder = new StringBuilder();
                    if (obj != null) {
                        i4 = i3;
                    } else {
                        i4 = i2;
                    }
                    map.put(str3, stringBuilder.append(i4).toString());
                    if (obj2 != null) {
                        map.put("B28", "1");
                    }
                    map.put("B1", m.g());
                    map.put("B2", m.b);
                    map.put("B30", m.e());
                    map.put("B3", String.valueOf(i));
                    h = m.h();
                    if (TextUtils.isEmpty(h)) {
                        map.put("B4", h);
                    }
                    map.put("B5", cb.a());
                    h = p.c();
                    if (TextUtils.isEmpty(h)) {
                        map.put("B29", h);
                    }
                    if (v.a("access_report_detail", 0, 1, 1) == 1) {
                        if (map2 != null) {
                            map.putAll(map2);
                        }
                        map.put("B6", p.b());
                        map.put("B8", str2);
                        map.put("D1", m.c());
                        map.put("D2", m.d());
                        map.put("D3", m.d);
                    }
                    if (i2 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    v.a(str, z3, map);
                }
            } catch (Throwable th) {
                return;
            }
        }
        i3 = i2;
        obj = null;
        if (map2 != null) {
            if (map2.containsKey("B83")) {
                map2.put("B83", cg.a(Long.parseLong((String) map2.get("B83")), "yyyy-MM-dd HH:mm:ss.SSS"));
            }
            if (map2.containsKey("B84")) {
                map2.put("B84", cg.a(Long.parseLong((String) map2.get("B84")), "yyyy-MM-dd HH:mm:ss.SSS"));
            }
        }
        if (map != null) {
            it = map.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (map2 != null) {
            it = map2.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (i == m.b()) {
            if (!b) {
            }
            String str52 = (String) map.get("B15");
            c = false;
            int i72 = 1;
            if (z2) {
                i4 = 100;
                obj3 = 1;
            } else {
                if (i == 2) {
                    if ("event".equals((String) map.get("B15"))) {
                        a = a(str, i3);
                    }
                    str3 = "";
                    if ("HLConnEvent".equals(str)) {
                        if (i3 == 0) {
                            if (i3 != -4) {
                            }
                            obj4 = 1;
                            if (obj4 != null) {
                            }
                        } else {
                            str3 = "report_conn_succ_rate";
                        }
                        if (i3 == 0) {
                            if (i3 != -4) {
                            }
                            obj4 = 1;
                            if (obj4 != null) {
                                i4 = 100;
                            } else {
                                i4 = 1;
                            }
                        } else {
                            i4 = 1;
                        }
                        i5 = i4;
                        i4 = 0;
                        str4 = str3;
                        a = i5;
                    } else if ("HLSecurityEvent".equals(str)) {
                        if (i3 == 0) {
                        }
                        if (i3 == 0) {
                        }
                        i5 = i3 == 0 ? 1 : 100;
                        i4 = 0;
                        str4 = i3 == 0 ? "report_security_req_succ_rate" : "report_security_req_fail_rate";
                        a = i5;
                    } else if ("HLDisconnEvent".equals(str)) {
                        if ("HLReqRspEvent".equals(str)) {
                        }
                        if (obj2 == null) {
                        }
                        if (i3 == 0) {
                            if (i3 != -4) {
                            }
                            obj4 = 1;
                            if (obj4 != null) {
                            }
                        } else {
                            str3 = "report_req_succ_rate";
                        }
                        if (i3 == 0) {
                            if (i3 != -4) {
                            }
                            obj4 = 1;
                            if (obj4 != null) {
                                i4 = 100;
                            } else {
                                i4 = 1;
                            }
                        } else {
                            i4 = 1;
                        }
                        i5 = i4;
                        i4 = 0;
                        str4 = str3;
                        a = i5;
                    } else {
                        i4 = 0;
                        str4 = "report_disconn_rate";
                        a = 50;
                    }
                    if (i4 == 0) {
                        if (v.a("report_all_events", 0, 1, 0) == 1) {
                            i4 = v.a(str4, 0, 100, a);
                        } else {
                            i4 = 100;
                        }
                    }
                    a = i4;
                } else {
                    a = a(str, i3);
                }
                obj4 = null;
                if (a > 0) {
                }
                obj4 = 1;
                i5 = a;
                obj3 = obj4;
                i4 = i5;
            }
            if (obj3 != null) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put("B9", String.valueOf(i4));
                str3 = "B7";
                stringBuilder = new StringBuilder();
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i3;
                }
                map.put(str3, stringBuilder.append(i4).toString());
                if (obj2 != null) {
                    map.put("B28", "1");
                }
                map.put("B1", m.g());
                map.put("B2", m.b);
                map.put("B30", m.e());
                map.put("B3", String.valueOf(i));
                h = m.h();
                if (TextUtils.isEmpty(h)) {
                    map.put("B4", h);
                }
                map.put("B5", cb.a());
                h = p.c();
                if (TextUtils.isEmpty(h)) {
                    map.put("B29", h);
                }
                if (v.a("access_report_detail", 0, 1, 1) == 1) {
                    if (map2 != null) {
                        map.putAll(map2);
                    }
                    map.put("B6", p.b());
                    map.put("B8", str2);
                    map.put("D1", m.c());
                    map.put("D2", m.d());
                    map.put("D3", m.d);
                }
                if (i2 == 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                v.a(str, z3, map);
            }
        }
        obj2 = null;
        if (z2) {
            if (i == 2) {
                a = a(str, i3);
            } else {
                if ("event".equals((String) map.get("B15"))) {
                    a = a(str, i3);
                }
                str3 = "";
                if ("HLConnEvent".equals(str)) {
                    if (i3 == 0) {
                        str3 = "report_conn_succ_rate";
                    } else {
                        if (i3 != -4) {
                        }
                        obj4 = 1;
                        if (obj4 != null) {
                        }
                    }
                    if (i3 == 0) {
                        i4 = 1;
                    } else {
                        if (i3 != -4) {
                        }
                        obj4 = 1;
                        if (obj4 != null) {
                            i4 = 1;
                        } else {
                            i4 = 100;
                        }
                    }
                    i5 = i4;
                    i4 = 0;
                    str4 = str3;
                    a = i5;
                } else if ("HLSecurityEvent".equals(str)) {
                    if (i3 == 0) {
                    }
                    if (i3 == 0) {
                    }
                    i5 = i3 == 0 ? 1 : 100;
                    i4 = 0;
                    str4 = i3 == 0 ? "report_security_req_succ_rate" : "report_security_req_fail_rate";
                    a = i5;
                } else if ("HLDisconnEvent".equals(str)) {
                    i4 = 0;
                    str4 = "report_disconn_rate";
                    a = 50;
                } else {
                    if ("HLReqRspEvent".equals(str)) {
                    }
                    if (obj2 == null) {
                    }
                    if (i3 == 0) {
                        str3 = "report_req_succ_rate";
                    } else {
                        if (i3 != -4) {
                        }
                        obj4 = 1;
                        if (obj4 != null) {
                        }
                    }
                    if (i3 == 0) {
                        i4 = 1;
                    } else {
                        if (i3 != -4) {
                        }
                        obj4 = 1;
                        if (obj4 != null) {
                            i4 = 1;
                        } else {
                            i4 = 100;
                        }
                    }
                    i5 = i4;
                    i4 = 0;
                    str4 = str3;
                    a = i5;
                }
                if (i4 == 0) {
                    if (v.a("report_all_events", 0, 1, 0) == 1) {
                        i4 = 100;
                    } else {
                        i4 = v.a(str4, 0, 100, a);
                    }
                }
                a = i4;
            }
            obj4 = null;
            if (a > 0) {
            }
            obj4 = 1;
            i5 = a;
            obj3 = obj4;
            i4 = i5;
        } else {
            i4 = 100;
            obj3 = 1;
        }
        if (obj3 != null) {
            if (map == null) {
                map = new HashMap();
            }
            map.put("B9", String.valueOf(i4));
            str3 = "B7";
            stringBuilder = new StringBuilder();
            if (obj != null) {
                i4 = i3;
            } else {
                i4 = i2;
            }
            map.put(str3, stringBuilder.append(i4).toString());
            if (obj2 != null) {
                map.put("B28", "1");
            }
            map.put("B1", m.g());
            map.put("B2", m.b);
            map.put("B30", m.e());
            map.put("B3", String.valueOf(i));
            h = m.h();
            if (TextUtils.isEmpty(h)) {
                map.put("B4", h);
            }
            map.put("B5", cb.a());
            h = p.c();
            if (TextUtils.isEmpty(h)) {
                map.put("B29", h);
            }
            if (v.a("access_report_detail", 0, 1, 1) == 1) {
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("B6", p.b());
                map.put("B8", str2);
                map.put("D1", m.c());
                map.put("D2", m.d());
                map.put("D3", m.d);
            }
            if (i2 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            v.a(str, z3, map);
        }
    }
}
