package com.tencent.mm.vending.j;

public class a {
    public Object[] zDa;

    public final <T> T get(int i) {
        if (this.zDa.length <= i) {
            return null;
        }
        return this.zDa[i];
    }

    public final int size() {
        if (this.zDa == null) {
            return 0;
        }
        return this.zDa.length;
    }

    public static <$1> b<$1> cr($1 $1) {
        a bVar = new b();
        bVar.zDa = new Object[]{$1};
        return (b) bVar;
    }

    public static <$1, $2> c<$1, $2> v($1 $1, $2 $2) {
        a cVar = new c();
        cVar.zDa = new Object[]{$1, $2};
        return (c) cVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.zDa) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }
}
