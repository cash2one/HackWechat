package com.google.android.gms.tagmanager;

import com.google.android.gms.c.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ai {
    private static final Object bcG = null;
    private static Long bcH = new Long(0);
    private static Double bcI = new Double(0.0d);
    private static ah bcJ = ah.rc();
    private static String bcK = new String("");
    private static Boolean bcL = new Boolean(false);
    private static List<Object> bcM = new ArrayList(0);
    private static Map<Object, Object> bcN = new HashMap();
    private static a bcO = an(bcK);

    private static String am(Object obj) {
        return obj == null ? bcK : obj.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a an(Object obj) {
        int i = 1;
        boolean z = false;
        a aVar = new a();
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof String) {
            aVar.type = 1;
            aVar.aWb = (String) obj;
        } else if (obj instanceof List) {
            aVar.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object an : list) {
                a an2 = an(an);
                if (an2 == bcO) {
                    return bcO;
                }
                r0 = r1 || an2.aWl;
                r5.add(an2);
                r1 = r0;
            }
            aVar.aWc = (a[]) r5.toArray(new a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            aVar.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                a an3 = an(entry.getKey());
                a an4 = an(entry.getValue());
                if (an3 == bcO || an4 == bcO) {
                    return bcO;
                }
                r0 = r1 || an3.aWl || an4.aWl;
                r5.add(an3);
                arrayList.add(an4);
                r1 = r0;
            }
            aVar.aWd = (a[]) r5.toArray(new a[0]);
            aVar.aWe = (a[]) arrayList.toArray(new a[0]);
            z = r1;
        } else {
            long j;
            if (!((obj instanceof Double) || (obj instanceof Float))) {
                if (obj instanceof ah) {
                    if (((ah) obj).bcF) {
                        r0 = false;
                    } else {
                        int i2 = 1;
                    }
                }
                r0 = false;
                if (r0) {
                    if (!((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof ah) && ((ah) obj).bcF))) {
                        i = 0;
                    }
                    if (i != 0) {
                        aVar.type = 6;
                        if (obj instanceof Number) {
                            m.qC();
                            j = 0;
                        } else {
                            j = ((Number) obj).longValue();
                        }
                        aVar.aWh = j;
                    } else if (obj instanceof Boolean) {
                        new StringBuilder("Converting to Value from unknown object type: ").append(obj != null ? "null" : obj.getClass().toString());
                        m.qC();
                        return bcO;
                    } else {
                        aVar.type = 8;
                        aVar.aWi = ((Boolean) obj).booleanValue();
                    }
                } else {
                    aVar.type = 1;
                    aVar.aWb = obj.toString();
                }
            }
            r0 = true;
            if (r0) {
                i = 0;
                if (i != 0) {
                    aVar.type = 6;
                    if (obj instanceof Number) {
                        m.qC();
                        j = 0;
                    } else {
                        j = ((Number) obj).longValue();
                    }
                    aVar.aWh = j;
                } else if (obj instanceof Boolean) {
                    if (obj != null) {
                    }
                    new StringBuilder("Converting to Value from unknown object type: ").append(obj != null ? "null" : obj.getClass().toString());
                    m.qC();
                    return bcO;
                } else {
                    aVar.type = 8;
                    aVar.aWi = ((Boolean) obj).booleanValue();
                }
            } else {
                aVar.type = 1;
                aVar.aWb = obj.toString();
            }
        }
        aVar.aWl = z;
        return aVar;
    }

    public static String b(a aVar) {
        return am(d(aVar));
    }

    public static Boolean c(a aVar) {
        Object d = d(aVar);
        if (d instanceof Boolean) {
            return (Boolean) d;
        }
        String am = am(d);
        return "true".equalsIgnoreCase(am) ? Boolean.TRUE : "false".equalsIgnoreCase(am) ? Boolean.FALSE : bcL;
    }

    public static Object d(a aVar) {
        int i = 0;
        if (aVar == null) {
            return bcG;
        }
        a[] aVarArr;
        int length;
        switch (aVar.type) {
            case 1:
                return aVar.aWb;
            case 2:
                ArrayList arrayList = new ArrayList(aVar.aWc.length);
                aVarArr = aVar.aWc;
                length = aVarArr.length;
                while (i < length) {
                    Object d = d(aVarArr[i]);
                    if (d == bcG) {
                        return bcG;
                    }
                    arrayList.add(d);
                    i++;
                }
                return arrayList;
            case 3:
                if (aVar.aWd.length != aVar.aWe.length) {
                    new StringBuilder("Converting an invalid value to object: ").append(aVar.toString());
                    m.qC();
                    return bcG;
                }
                Map hashMap = new HashMap(aVar.aWe.length);
                while (i < aVar.aWd.length) {
                    Object d2 = d(aVar.aWd[i]);
                    Object d3 = d(aVar.aWe[i]);
                    if (d2 == bcG || d3 == bcG) {
                        return bcG;
                    }
                    hashMap.put(d2, d3);
                    i++;
                }
                return hashMap;
            case 4:
                m.qC();
                return bcG;
            case 5:
                m.qC();
                return bcG;
            case 6:
                return Long.valueOf(aVar.aWh);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                aVarArr = aVar.aWj;
                length = aVarArr.length;
                while (i < length) {
                    String b = b(aVarArr[i]);
                    if (b == bcK) {
                        return bcG;
                    }
                    stringBuffer.append(b);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.aWi);
            default:
                new StringBuilder("Failed to convert a value of type: ").append(aVar.type);
                m.qC();
                return bcG;
        }
    }

    public static a rd() {
        return bcO;
    }
}
