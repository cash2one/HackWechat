package com.tencent.mm.cache;

import android.os.Parcel;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MCacheItem$a {
    public static Map<Class<?>, Method> gBA = new HashMap();
    public static Map<Class<?>, Method> gBB = new HashMap();

    MCacheItem$a() {
    }

    static {
        try {
            gBA.put(byte[].class, MCacheItem$a.class.getMethod("keep_writeByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Short.TYPE, MCacheItem$a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Short.class, MCacheItem$a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Boolean.TYPE, MCacheItem$a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Boolean.class, MCacheItem$a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Integer.TYPE, MCacheItem$a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Integer.class, MCacheItem$a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Float.TYPE, MCacheItem$a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Float.class, MCacheItem$a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Double.TYPE, MCacheItem$a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Double.class, MCacheItem$a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Long.TYPE, MCacheItem$a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(Long.class, MCacheItem$a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
            gBA.put(String.class, MCacheItem$a.class.getMethod("keep_writeString", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(byte[].class, MCacheItem$a.class.getMethod("keep_readByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Short.TYPE, MCacheItem$a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Short.class, MCacheItem$a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Boolean.TYPE, MCacheItem$a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Boolean.class, MCacheItem$a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Integer.TYPE, MCacheItem$a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Integer.class, MCacheItem$a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Float.TYPE, MCacheItem$a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Float.class, MCacheItem$a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Double.TYPE, MCacheItem$a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Double.class, MCacheItem$a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Long.TYPE, MCacheItem$a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(Long.class, MCacheItem$a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
            gBB.put(String.class, MCacheItem$a.class.getMethod("keep_readString", new Class[]{Parcel.class, Field.class, Object.class}));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeByteArray(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeByteArray((byte[]) field.get(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeShort(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeInt(field.getShort(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeBoolean(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeInt(field.getBoolean(obj) ? 1 : 0);
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeInt(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeInt(field.getInt(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeFloat(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeFloat(field.getFloat(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeDouble(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeDouble(field.getDouble(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeLong(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeLong(field.getLong(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_writeString(Parcel parcel, Field field, Object obj) {
        try {
            parcel.writeString((String) field.get(obj));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readByteArray(Parcel parcel, Field field, Object obj) {
        try {
            field.set(obj, parcel.createByteArray());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readShort(Parcel parcel, Field field, Object obj) {
        try {
            field.setShort(obj, (short) parcel.readInt());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readBoolean(Parcel parcel, Field field, Object obj) {
        try {
            field.setBoolean(obj, parcel.readInt() != 0);
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readInt(Parcel parcel, Field field, Object obj) {
        try {
            field.setInt(obj, parcel.readInt());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readFloat(Parcel parcel, Field field, Object obj) {
        try {
            field.setFloat(obj, parcel.readFloat());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readDouble(Parcel parcel, Field field, Object obj) {
        try {
            field.setDouble(obj, parcel.readDouble());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readLong(Parcel parcel, Field field, Object obj) {
        try {
            field.set(obj, Long.valueOf(parcel.readLong()));
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public static void keep_readString(Parcel parcel, Field field, Object obj) {
        try {
            field.set(obj, parcel.readString());
        } catch (Throwable e) {
            x.e("MicroMsg.MCacheItem", "exception:%s", new Object[]{bh.i(e)});
        }
    }
}
