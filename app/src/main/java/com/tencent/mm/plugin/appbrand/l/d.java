package com.tencent.mm.plugin.appbrand.l;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.bc.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public final class d implements f {
    public final boolean aU(String str, String str2) {
        InputStream open;
        OutputStream outputStream = null;
        try {
            open = ac.getContext().getAssets().open(str2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.WxaFTSSearchLogic", "file inputStream is null.");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                return true;
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.c(open);
                e.a(outputStream);
            }
        } else {
            e.c(open);
            return false;
        }
    }

    public final String Rh() {
        return m.Rh();
    }

    public final int Ri() {
        return m.Ri();
    }

    public final Intent QM() {
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    public final String r(Map<String, String> map) {
        return m.r(map);
    }

    public final Map<String, String> abK() {
        return m.b(201, true, 64);
    }

    public final Properties o(File file) {
        return m.o(file);
    }
}
