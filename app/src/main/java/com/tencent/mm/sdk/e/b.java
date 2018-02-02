package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Map<Class<?>, Object> gBA = new HashMap();
    private static final Map<Class<?>, Object> gBB = new HashMap();
    private static final Map<Class<?>, String> xjx = new HashMap();

    static {
        try {
            gBA.put(byte[].class, new Object() {
            });
            gBA.put(Short.TYPE, new Object() {
            });
            gBA.put(Short.class, new Object() {
            });
            gBA.put(Boolean.TYPE, new Object() {
            });
            gBA.put(Boolean.class, new Object() {
            });
            gBA.put(Integer.TYPE, new Object() {
            });
            gBA.put(Integer.class, new Object() {
            });
            gBA.put(Float.TYPE, new Object() {
            });
            gBA.put(Float.class, new Object() {
            });
            gBA.put(Double.TYPE, new Object() {
            });
            gBA.put(Double.class, new Object() {
            });
            gBA.put(Long.TYPE, new Object() {
            });
            gBA.put(Long.class, new Object() {
            });
            gBA.put(String.class, new Object() {
            });
            gBB.put(byte[].class, new Object() {
            });
            gBB.put(Short.TYPE, new Object() {
            });
            gBB.put(Short.class, new Object() {
            });
            gBB.put(Boolean.TYPE, new Object() {
            });
            gBB.put(Boolean.class, new Object() {
            });
            gBB.put(Integer.TYPE, new Object() {
            });
            gBB.put(Integer.class, new Object() {
            });
            gBB.put(Float.TYPE, new Object() {
            });
            gBB.put(Float.class, new Object() {
            });
            gBB.put(Double.TYPE, new Object() {
            });
            gBB.put(Double.class, new Object() {
            });
            gBB.put(Long.TYPE, new Object() {
            });
            gBB.put(Long.class, new Object() {
            });
            gBB.put(String.class, new Object() {
            });
            xjx.put(byte[].class, "BLOB");
            xjx.put(Short.TYPE, "SHORT");
            xjx.put(Short.class, "SHORT");
            xjx.put(Boolean.TYPE, "INTEGER");
            xjx.put(Boolean.class, "INTEGER");
            xjx.put(Integer.TYPE, "INTEGER");
            xjx.put(Integer.class, "INTEGER");
            xjx.put(Float.TYPE, "FLOAT");
            xjx.put(Float.class, "FLOAT");
            xjx.put(Double.TYPE, "DOUBLE");
            xjx.put(Double.class, "DOUBLE");
            xjx.put(Long.TYPE, "LONG");
            xjx.put(Long.class, "LONG");
            xjx.put(String.class, "TEXT");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static String C(Class<?> cls) {
        return (String) xjx.get(cls);
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getBlob(i));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), (byte[]) field.get(obj));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
            } else {
                field.set(obj, Short.valueOf(cursor.getShort(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), Short.valueOf(field.getShort(obj)));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(c.b(field), Integer.valueOf(field.getInt(obj)));
            } else {
                contentValues.put(c.b(field), (Integer) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
            } else {
                field.set(obj, Float.valueOf(cursor.getFloat(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(c.b(field), Float.valueOf(field.getFloat(obj)));
            } else {
                contentValues.put(c.b(field), (Float) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
            } else {
                field.set(obj, Double.valueOf(cursor.getDouble(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(c.b(field), Double.valueOf(field.getDouble(obj)));
            } else {
                contentValues.put(c.b(field), (Double) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
            } else {
                field.set(obj, Long.valueOf(cursor.getLong(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(c.b(field), Long.valueOf(field.getLong(obj)));
            } else {
                contentValues.put(c.b(field), (Long) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getString(i));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), (String) field.get(obj));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }
}
