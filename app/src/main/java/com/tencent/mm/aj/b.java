package com.tencent.mm.aj;

import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.io.ObjectInputStream;

public final class b {
    public static Object h(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Exception e;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            try {
                readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (Exception e2) {
                    x.w("MicroMsg.ObjectUtil", "Read close exception:" + e2.getMessage());
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.w("MicroMsg.ObjectUtil", "Read exception:" + e2.getMessage());
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e22) {
                            x.w("MicroMsg.ObjectUtil", "Read close exception:" + e22.getMessage());
                        }
                    }
                    return readObject;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e222) {
                            x.w("MicroMsg.ObjectUtil", "Read close exception:" + e222.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            objectInputStream = objectInputStream2;
            x.w("MicroMsg.ObjectUtil", "Read exception:" + e222.getMessage());
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return readObject;
        } catch (Throwable th3) {
            objectInputStream = objectInputStream2;
            th = th3;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
        return readObject;
    }
}
