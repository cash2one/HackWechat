package com.google.android.gms.common.server.response;

import com.google.android.gms.c.s;
import com.google.android.gms.c.x;
import com.google.android.gms.c.y;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {
    private Object a(Field field) {
        String pa = field.pa();
        if (field.pc() != null) {
            field.pa();
            w.a(oU() == null, "Concrete field shouldn't be value object: %s", field.pa());
            field.oZ();
            try {
                return getClass().getMethod("get" + Character.toUpperCase(pa.charAt(0)) + pa.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        field.pa();
        return oU();
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return Field.b(field) != null ? field.aPf.convertBack(obj) : obj;
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.oW() == 11) {
            stringBuilder.append(((FastJsonResponse) field.pc().cast(obj)).toString());
        } else if (field.oW() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(x.aY((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map<String, Field<?, ?>> oT();

    protected abstract Object oU();

    protected abstract boolean oV();

    public String toString() {
        Map oT = oT();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : oT.keySet()) {
            Field field = (Field) oT.get(str);
            if (field.oY() != 11) {
                field.pa();
                if (oV()) {
                    Object a = a(field, a(field));
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("{");
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\":");
                    if (a != null) {
                        switch (field.oY()) {
                            case 8:
                                stringBuilder.append("\"").append(s.j((byte[]) a)).append("\"");
                                break;
                            case 9:
                                stringBuilder.append("\"").append(s.k((byte[]) a)).append("\"");
                                break;
                            case 10:
                                y.a(stringBuilder, (HashMap) a);
                                break;
                            default:
                                if (!field.oX()) {
                                    a(stringBuilder, field, a);
                                    break;
                                }
                                a(stringBuilder, field, (ArrayList) a);
                                break;
                        }
                    }
                    stringBuilder.append("null");
                }
            } else if (field.oZ()) {
                field.pa();
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            } else {
                field.pa();
                throw new UnsupportedOperationException("Concrete types not supported");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
