package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class h {
    private static volatile h tTk = null;
    private p tTl = null;

    private h() {
    }

    public static h bWJ() {
        if (tTk == null) {
            synchronized (h.class) {
                if (tTk == null) {
                    tTk = new h();
                }
            }
        }
        return tTk;
    }

    public final p bWK() {
        if (this.tTl != null) {
            return this.tTl;
        }
        ar.Hg();
        String str = (String) c.CU().get(a.xvp, "");
        x.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", new Object[]{str});
        if (bh.ov(str)) {
            return null;
        }
        byte[] VD = bh.VD(str);
        if (VD.length <= 0) {
            return null;
        }
        this.tTl = ba(VD);
        String str2 = "WNNoteKeepTopManager";
        String str3 = "getCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.tTl != null ? this.tTl.bVU() : "null";
        x.d(str2, str3, objArr);
        return this.tTl;
    }

    public final void a(p pVar) {
        this.tTl = pVar;
        byte[] b = b(this.tTl);
        String str = "";
        if (b != null && b.length > 0) {
            str = bh.by(b);
        }
        String str2 = "WNNoteKeepTopManager";
        String str3 = "setCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.tTl != null ? this.tTl.bVU() : "null";
        x.i(str2, str3, objArr);
        x.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", new Object[]{str});
        ar.Hg();
        c.CU().a(a.xvp, bh.ou(str));
    }

    private static p ba(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        Exception e;
        Throwable th;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
                try {
                    x.e("WNNoteKeepTopManager", "toObject exception:%s", new Object[]{e});
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e3) {
                            x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e3});
                            return null;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e4) {
                            x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e4});
                            throw th;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
            try {
                p pVar = (p) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pVar;
                } catch (Exception e42) {
                    x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e42});
                    return pVar;
                }
            } catch (Exception e5) {
                e3 = e5;
                x.e("WNNoteKeepTopManager", "toObject exception:%s", new Object[]{e3});
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e3 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            x.e("WNNoteKeepTopManager", "toObject exception:%s", new Object[]{e3});
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    private static byte[] b(p pVar) {
        ObjectOutputStream objectOutputStream;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        if (pVar != null) {
            ByteArrayOutputStream byteArrayOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = bArr;
                    try {
                        x.e("WNNoteKeepTopManager", "toByteArray exception:%s", new Object[]{e});
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                                x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e3});
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e32) {
                                x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e32});
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    objectOutputStream = bArr;
                    th = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(pVar);
                    objectOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Exception e322) {
                        x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e322});
                    }
                } catch (Exception e4) {
                    e322 = e4;
                    x.e("WNNoteKeepTopManager", "toByteArray exception:%s", new Object[]{e322});
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                }
            } catch (Exception e5) {
                e322 = e5;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                x.e("WNNoteKeepTopManager", "toByteArray exception:%s", new Object[]{e322});
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th32) {
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                th = th32;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return bArr;
    }
}
