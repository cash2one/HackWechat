package com.tencent.mm.aq.a.b;

import com.tencent.mm.a.e;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.c.f;
import com.tencent.mm.aq.a.g.b;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class a implements com.tencent.mm.aq.a.c.a {
    private f hEe;

    private String a(String str, c cVar) {
        String str2 = cVar.hDC;
        if (str2 == null || str2.length() == 0) {
            str2 = cVar.hDD;
            if (!(str2 == null || str2.length() == 0)) {
                str2 = str2 + File.separator + this.hEe.lB(str);
            }
        }
        if (cVar.hDz && bh.ov(r0)) {
            str2 = b.PM() + File.separator + this.hEe.lB(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    private String b(String str, c cVar) {
        String str2 = cVar.hDE;
        if (str2 == null || str2.length() == 0) {
            String str3 = cVar.hDC;
            if (str3 != null && str3.length() > 0) {
                str2 = cVar.hDD;
                if (str2 == null || str2.length() == 0 || !str3.startsWith(str2)) {
                    x.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", new Object[]{str3});
                    throw new IllegalArgumentException("SFS can't deal with absolute path: " + str3);
                }
                str2 = str3.substring(str2.length());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
            }
        }
        if (str2 == null || str2.length() == 0) {
            str2 = this.hEe.lB(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    public final boolean a(String str, byte[] bArr, c cVar) {
        SFSContext sFSContext = cVar.hDW;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                String str2 = "";
                if (com.tencent.mm.modelsfs.f.ml(b)) {
                    str2 = com.tencent.mm.modelsfs.f.mo(b);
                    b = com.tencent.mm.modelsfs.f.mm(b);
                }
                outputStream = sFSContext.au(b, str2);
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (outputStream == null) {
                    return false;
                }
                try {
                    outputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } else {
            String a = a(str, cVar);
            if (a == null) {
                return false;
            }
            File parentFile = new File(a).getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            parentFile = new File(a);
            if (!parentFile.exists()) {
                try {
                    parentFile.createNewFile();
                } catch (Throwable e5) {
                    x.i("MicroMsg.imageloader.DefaultImageDiskCache", bh.i(e5));
                }
            }
            if (bArr != null && e.b(a, bArr, bArr.length) < 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(String str, c cVar) {
        SFSContext sFSContext = cVar.hDW;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            return sFSContext.iF(b);
        }
        String a = a(str, cVar);
        if (a != null) {
            return new File(a).delete();
        }
        return false;
    }

    public final void PL() {
        b.PO();
    }

    public final InputStream d(String str, c cVar) {
        try {
            SFSContext sFSContext = cVar.hDW;
            String b;
            if (sFSContext != null) {
                b = b(str, cVar);
                if (b == null) {
                    return null;
                }
                return sFSContext.openRead(b);
            }
            b = a(str, cVar);
            if (b != null) {
                return new FileInputStream(b);
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public final void a(f fVar) {
        this.hEe = fVar;
    }
}
