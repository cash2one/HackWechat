package com.google.android.gms.c;

import com.google.android.gms.c.av.a.a;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class au {
    private static int a(String str, a[] aVarArr) {
        int i = 14;
        for (a aVar : aVarArr) {
            if (i == 14) {
                if (aVar.type == 9 || aVar.type == 2 || aVar.type == 6) {
                    i = aVar.type;
                } else if (aVar.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + aVar.type + " for key " + str);
                }
            } else if (aVar.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + aVar.type);
            }
        }
        return i;
    }

    private static a a(List<Asset> list, Object obj) {
        a aVar = new a();
        if (obj == null) {
            aVar.type = 14;
            return aVar;
        }
        aVar.aZA = new a.a();
        if (obj instanceof String) {
            aVar.type = 2;
            aVar.aZA.aZC = (String) obj;
        } else if (obj instanceof Integer) {
            aVar.type = 6;
            aVar.aZA.aZG = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            aVar.type = 5;
            aVar.aZA.aZF = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            aVar.type = 3;
            aVar.aZA.aZD = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            aVar.type = 4;
            aVar.aZA.aZE = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.aZA.aZI = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            aVar.type = 7;
            aVar.aZA.aZH = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            aVar.type = 1;
            aVar.aZA.aZB = (byte[]) obj;
        } else if (obj instanceof String[]) {
            aVar.type = 11;
            aVar.aZA.aZL = (String[]) obj;
        } else if (obj instanceof long[]) {
            aVar.type = 12;
            aVar.aZA.aZM = (long[]) obj;
        } else if (obj instanceof float[]) {
            aVar.type = 15;
            aVar.aZA.aZN = (float[]) obj;
        } else if (obj instanceof Asset) {
            aVar.type = 13;
            a.a aVar2 = aVar.aZA;
            list.add((Asset) obj);
            aVar2.aZO = (long) (list.size() - 1);
        } else if (obj instanceof i) {
            aVar.type = 9;
            i iVar = (i) obj;
            TreeSet treeSet = new TreeSet(iVar.bdp.keySet());
            av.a[] aVarArr = new av.a[treeSet.size()];
            Iterator it = treeSet.iterator();
            r1 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                aVarArr[r1] = new av.a();
                aVarArr[r1].name = str;
                aVarArr[r1].aZy = a((List) list, iVar.get(str));
                r1++;
            }
            aVar.aZA.aZJ = aVarArr;
        } else if (obj instanceof ArrayList) {
            aVar.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            a[] aVarArr2 = new a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                a a = a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    aVarArr2[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            aVar.aZA.aZK = aVarArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return aVar;
    }

    public static i a(a aVar) {
        i iVar = new i();
        for (av.a aVar2 : aVar.aZu.aZw) {
            a(aVar.aZv, iVar, aVar2.name, aVar2.aZy);
        }
        return iVar;
    }

    private static ArrayList a(List<Asset> list, a.a aVar, int i) {
        ArrayList arrayList = new ArrayList(aVar.aZK.length);
        for (a aVar2 : aVar.aZK) {
            if (aVar2.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                i iVar = new i();
                for (av.a aVar3 : aVar2.aZA.aZJ) {
                    a(list, iVar, aVar3.name, aVar3.aZy);
                }
                arrayList.add(iVar);
            } else if (i == 2) {
                arrayList.add(aVar2.aZA.aZC);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(aVar2.aZA.aZG));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void a(List<Asset> list, i iVar, String str, a aVar) {
        int i = aVar.type;
        if (i == 14) {
            iVar.putString(str, null);
            return;
        }
        a.a aVar2 = aVar.aZA;
        if (i == 1) {
            iVar.bdp.put(str, aVar2.aZB);
        } else if (i == 11) {
            iVar.bdp.put(str, aVar2.aZL);
        } else if (i == 12) {
            iVar.bdp.put(str, aVar2.aZM);
        } else if (i == 15) {
            iVar.bdp.put(str, aVar2.aZN);
        } else if (i == 2) {
            iVar.putString(str, aVar2.aZC);
        } else if (i == 3) {
            iVar.bdp.put(str, Double.valueOf(aVar2.aZD));
        } else if (i == 4) {
            iVar.bdp.put(str, Float.valueOf(aVar2.aZE));
        } else if (i == 5) {
            iVar.putLong(str, aVar2.aZF);
        } else if (i == 6) {
            iVar.bdp.put(str, Integer.valueOf(aVar2.aZG));
        } else if (i == 7) {
            iVar.bdp.put(str, Byte.valueOf((byte) aVar2.aZH));
        } else if (i == 8) {
            iVar.bdp.put(str, Boolean.valueOf(aVar2.aZI));
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            iVar.a(str, (Asset) list.get((int) aVar2.aZO));
        } else if (i == 9) {
            i iVar2 = new i();
            for (av.a aVar3 : aVar2.aZJ) {
                a(list, iVar2, aVar3.name, aVar3.aZy);
            }
            iVar.bdp.put(str, iVar2);
        } else if (i == 10) {
            i = a(str, aVar2.aZK);
            ArrayList a = a(list, aVar2, i);
            if (i == 14) {
                iVar.putStringArrayList(str, a);
            } else if (i == 9) {
                iVar.bdp.put(str, a);
            } else if (i == 2) {
                iVar.putStringArrayList(str, a);
            } else if (i == 6) {
                iVar.bdp.put(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    public static av.a[] a(i iVar, List<Asset> list) {
        TreeSet treeSet = new TreeSet(iVar.bdp.keySet());
        av.a[] aVarArr = new av.a[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = iVar.get(str);
            aVarArr[i] = new av.a();
            aVarArr[i].name = str;
            aVarArr[i].aZy = a((List) list, obj);
            i++;
        }
        return aVarArr;
    }
}
