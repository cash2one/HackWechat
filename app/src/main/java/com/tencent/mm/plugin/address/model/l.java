package com.tencent.mm.plugin.address.model;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l {
    private static final Pattern ime = Pattern.compile("(-|\\s)+");
    public a ima = new a();
    public final List<RcptItem> imb = new ArrayList();
    public final HashMap<String, List<RcptItem>> imc = new HashMap();
    public final HashMap<String, List<RcptItem>> imd = new HashMap();
    public String path;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void XH() {
        BufferedReader bufferedReader;
        String readLine;
        Throwable e;
        InputStream open;
        BufferedReader bufferedReader2;
        InputStream inputStream;
        int size;
        Object obj;
        String str;
        int i;
        String str2;
        String substring;
        String[] split;
        RcptItem rcptItem;
        Object obj2;
        List list;
        File file;
        x.i("MicroMsg.WalletAddrMgr", "load data");
        ar.Hg();
        String FC = c.FC();
        x.d("MicroMsg.WalletAddrMgr", "initAddressData");
        AssetManager assets = ac.getContext().getAssets();
        BufferedReader bufferedReader3 = null;
        String str3 = "";
        String str4 = "";
        List arrayList = new ArrayList();
        boolean z = false;
        FileReader fileReader;
        try {
            fileReader = new FileReader(FC + "address");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    arrayList.clear();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                    }
                    try {
                        fileReader.close();
                        bufferedReader.close();
                        z = true;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.WalletAddrMgr", e2, "", new Object[0]);
                        z = true;
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.WalletAddrMgr", e2, "", new Object[0]);
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.WalletAddrMgr", e22, "", new Object[0]);
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (!z) {
                            try {
                                arrayList.clear();
                                open = assets.open("address");
                                bufferedReader2 = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                                while (true) {
                                    try {
                                        readLine = bufferedReader2.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        arrayList.add(readLine);
                                    } catch (IOException e4) {
                                        e22 = e4;
                                        inputStream = open;
                                    }
                                }
                                bufferedReader2.close();
                                open.close();
                                try {
                                    bufferedReader2.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.WalletAddrMgr", e222, "", new Object[0]);
                                }
                                if (open != null) {
                                }
                            } catch (IOException e5) {
                                e222 = e5;
                                bufferedReader2 = bufferedReader;
                                inputStream = null;
                                try {
                                    x.printErrStackTrace("MicroMsg.WalletAddrMgr", e222, "", new Object[0]);
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (Throwable e2222) {
                                            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e2222, "", new Object[0]);
                                        }
                                    }
                                } catch (Throwable th) {
                                    e2222 = th;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (Throwable e6) {
                                            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e6, "", new Object[0]);
                                        }
                                    }
                                    throw e2222;
                                }
                            } catch (Throwable th2) {
                                e2222 = th2;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                throw e2222;
                            }
                        }
                        x.d("MicroMsg.WalletAddrMgr", "read from addr " + z);
                        size = arrayList.size();
                        obj = str4;
                        str = str3;
                        i = 0;
                        while (i < size) {
                            readLine = (String) arrayList.get(i);
                            str2 = i + 1 >= size ? "" : (String) arrayList.get(i + 1);
                            readLine = readLine.replace("\t", "-").replace("　", "-");
                            str3 = str2.replace("\t", "-").replace("　", "-");
                            str2 = readLine.substring(0, 6);
                            substring = readLine.substring(6);
                            split = ime.split("-" + substring);
                            rcptItem = split.length != 3 ? null : new RcptItem(split[1], str2, split[2]);
                            if (rcptItem != null) {
                                x.w("MicroMsg.WalletAddrMgr", "analyze address data. missing " + substring);
                                obj2 = obj;
                                str2 = str;
                            } else if (!substring.startsWith("----")) {
                                if (!this.imd.containsKey(obj)) {
                                    this.imd.put(obj, new ArrayList());
                                }
                                list = (List) this.imd.get(obj);
                                list.add(rcptItem);
                                this.imd.put(obj, list);
                                obj2 = obj;
                                str2 = str;
                            } else if (!substring.startsWith("---")) {
                                if (!this.imc.containsKey(str)) {
                                    this.imc.put(str, new ArrayList());
                                }
                                list = (List) this.imc.get(str);
                                if (aG(str3, "----")) {
                                    rcptItem.ilZ = true;
                                }
                                list.add(rcptItem);
                                this.imc.put(str, list);
                                readLine = str2;
                                str2 = str;
                            } else if (substring.startsWith("-")) {
                                if (aG(str3, "---")) {
                                    rcptItem.ilZ = true;
                                }
                                this.imb.add(rcptItem);
                                obj2 = obj;
                            } else {
                                obj2 = obj;
                                str2 = str;
                            }
                            str = str2;
                            i++;
                            obj = obj2;
                        }
                        this.path = FC + "addrmgr";
                        file = new File(this.path);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        this.ima = (a) new a().aF(decrypt(e.d(this.path, 0, -1), XJ()));
                    } catch (Throwable th3) {
                        e2222 = th3;
                        bufferedReader3 = bufferedReader;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable e62) {
                                x.printErrStackTrace("MicroMsg.WalletAddrMgr", e62, "", new Object[0]);
                                throw e2222;
                            }
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        throw e2222;
                    }
                }
            } catch (IOException e7) {
                e2222 = e7;
                bufferedReader = null;
                x.printErrStackTrace("MicroMsg.WalletAddrMgr", e2222, "", new Object[0]);
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (z) {
                    arrayList.clear();
                    open = assets.open("address");
                    bufferedReader2 = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                    while (true) {
                        readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                    }
                    bufferedReader2.close();
                    open.close();
                    bufferedReader2.close();
                    if (open != null) {
                    }
                }
                x.d("MicroMsg.WalletAddrMgr", "read from addr " + z);
                size = arrayList.size();
                obj = str4;
                str = str3;
                i = 0;
                while (i < size) {
                    readLine = (String) arrayList.get(i);
                    if (i + 1 >= size) {
                    }
                    readLine = readLine.replace("\t", "-").replace("　", "-");
                    str3 = str2.replace("\t", "-").replace("　", "-");
                    str2 = readLine.substring(0, 6);
                    substring = readLine.substring(6);
                    split = ime.split("-" + substring);
                    if (split.length != 3) {
                    }
                    if (rcptItem != null) {
                        x.w("MicroMsg.WalletAddrMgr", "analyze address data. missing " + substring);
                        obj2 = obj;
                        str2 = str;
                    } else if (!substring.startsWith("----")) {
                        if (this.imd.containsKey(obj)) {
                            this.imd.put(obj, new ArrayList());
                        }
                        list = (List) this.imd.get(obj);
                        list.add(rcptItem);
                        this.imd.put(obj, list);
                        obj2 = obj;
                        str2 = str;
                    } else if (!substring.startsWith("---")) {
                        if (this.imc.containsKey(str)) {
                            this.imc.put(str, new ArrayList());
                        }
                        list = (List) this.imc.get(str);
                        if (aG(str3, "----")) {
                            rcptItem.ilZ = true;
                        }
                        list.add(rcptItem);
                        this.imc.put(str, list);
                        readLine = str2;
                        str2 = str;
                    } else if (substring.startsWith("-")) {
                        if (aG(str3, "---")) {
                            rcptItem.ilZ = true;
                        }
                        this.imb.add(rcptItem);
                        obj2 = obj;
                    } else {
                        obj2 = obj;
                        str2 = str;
                    }
                    str = str2;
                    i++;
                    obj = obj2;
                }
                this.path = FC + "addrmgr";
                file = new File(this.path);
                if (file.exists()) {
                    file.mkdir();
                }
                this.ima = (a) new a().aF(decrypt(e.d(this.path, 0, -1), XJ()));
            } catch (Throwable th4) {
                e2222 = th4;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
                throw e2222;
            }
        } catch (IOException e8) {
            e2222 = e8;
            fileReader = null;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e2222, "", new Object[0]);
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (z) {
                arrayList.clear();
                open = assets.open("address");
                bufferedReader2 = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                while (true) {
                    readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                bufferedReader2.close();
                open.close();
                bufferedReader2.close();
                if (open != null) {
                }
            }
            x.d("MicroMsg.WalletAddrMgr", "read from addr " + z);
            size = arrayList.size();
            obj = str4;
            str = str3;
            i = 0;
            while (i < size) {
                readLine = (String) arrayList.get(i);
                if (i + 1 >= size) {
                }
                readLine = readLine.replace("\t", "-").replace("　", "-");
                str3 = str2.replace("\t", "-").replace("　", "-");
                str2 = readLine.substring(0, 6);
                substring = readLine.substring(6);
                split = ime.split("-" + substring);
                if (split.length != 3) {
                }
                if (rcptItem != null) {
                    x.w("MicroMsg.WalletAddrMgr", "analyze address data. missing " + substring);
                    obj2 = obj;
                    str2 = str;
                } else if (!substring.startsWith("----")) {
                    if (this.imd.containsKey(obj)) {
                        this.imd.put(obj, new ArrayList());
                    }
                    list = (List) this.imd.get(obj);
                    list.add(rcptItem);
                    this.imd.put(obj, list);
                    obj2 = obj;
                    str2 = str;
                } else if (!substring.startsWith("---")) {
                    if (this.imc.containsKey(str)) {
                        this.imc.put(str, new ArrayList());
                    }
                    list = (List) this.imc.get(str);
                    if (aG(str3, "----")) {
                        rcptItem.ilZ = true;
                    }
                    list.add(rcptItem);
                    this.imc.put(str, list);
                    readLine = str2;
                    str2 = str;
                } else if (substring.startsWith("-")) {
                    obj2 = obj;
                    str2 = str;
                } else {
                    if (aG(str3, "---")) {
                        rcptItem.ilZ = true;
                    }
                    this.imb.add(rcptItem);
                    obj2 = obj;
                }
                str = str2;
                i++;
                obj = obj2;
            }
            this.path = FC + "addrmgr";
            file = new File(this.path);
            if (file.exists()) {
                file.mkdir();
            }
            this.ima = (a) new a().aF(decrypt(e.d(this.path, 0, -1), XJ()));
        } catch (Throwable th5) {
            e2222 = th5;
            fileReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw e2222;
        }
        if (z) {
            arrayList.clear();
            open = assets.open("address");
            bufferedReader2 = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
            while (true) {
                readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader2.close();
            open.close();
            bufferedReader2.close();
            if (open != null) {
            }
        }
        x.d("MicroMsg.WalletAddrMgr", "read from addr " + z);
        size = arrayList.size();
        obj = str4;
        str = str3;
        i = 0;
        while (i < size) {
            readLine = (String) arrayList.get(i);
            if (i + 1 >= size) {
            }
            readLine = readLine.replace("\t", "-").replace("　", "-");
            str3 = str2.replace("\t", "-").replace("　", "-");
            str2 = readLine.substring(0, 6);
            substring = readLine.substring(6);
            split = ime.split("-" + substring);
            if (split.length != 3) {
            }
            if (rcptItem != null) {
                x.w("MicroMsg.WalletAddrMgr", "analyze address data. missing " + substring);
                obj2 = obj;
                str2 = str;
            } else if (!substring.startsWith("----")) {
                if (this.imd.containsKey(obj)) {
                    this.imd.put(obj, new ArrayList());
                }
                list = (List) this.imd.get(obj);
                list.add(rcptItem);
                this.imd.put(obj, list);
                obj2 = obj;
                str2 = str;
            } else if (!substring.startsWith("---")) {
                if (this.imc.containsKey(str)) {
                    this.imc.put(str, new ArrayList());
                }
                list = (List) this.imc.get(str);
                if (aG(str3, "----")) {
                    rcptItem.ilZ = true;
                }
                list.add(rcptItem);
                this.imc.put(str, list);
                readLine = str2;
                str2 = str;
            } else if (substring.startsWith("-")) {
                if (aG(str3, "---")) {
                    rcptItem.ilZ = true;
                }
                this.imb.add(rcptItem);
                obj2 = obj;
            } else {
                obj2 = obj;
                str2 = str;
            }
            str = str2;
            i++;
            obj = obj2;
        }
        this.path = FC + "addrmgr";
        file = new File(this.path);
        if (file.exists()) {
            file.mkdir();
        }
        try {
            this.ima = (a) new a().aF(decrypt(e.d(this.path, 0, -1), XJ()));
        } catch (Throwable e22222) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e22222, "", new Object[0]);
        }
    }

    public final b jh(int i) {
        for (int i2 = 0; i2 < this.ima.imi.size(); i2++) {
            b bVar = (b) this.ima.imi.get(i2);
            if (bVar.id == i) {
                return bVar;
            }
        }
        return null;
    }

    public final boolean a(b bVar) {
        if (this.ima == null) {
            this.ima = new a();
        }
        for (int i = 0; i < this.ima.imi.size(); i++) {
            if (((b) this.ima.imi.get(i)).id == bVar.id) {
                this.ima.imi.remove(i);
                return true;
            }
        }
        return false;
    }

    public final boolean p(LinkedList<bax> linkedList) {
        this.ima.imi.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bax com_tencent_mm_protocal_c_bax = (bax) it.next();
            b bVar = new b();
            bVar.id = com_tencent_mm_protocal_c_bax.id;
            bVar.imr = com_tencent_mm_protocal_c_bax.wHG.wJF;
            bVar.iml = com_tencent_mm_protocal_c_bax.wHA.wJF;
            bVar.imo = com_tencent_mm_protocal_c_bax.wHD.wJF;
            bVar.imm = com_tencent_mm_protocal_c_bax.wHB.wJF;
            bVar.imp = com_tencent_mm_protocal_c_bax.wHE.wJF;
            bVar.imq = com_tencent_mm_protocal_c_bax.wHF.wJF;
            bVar.imk = com_tencent_mm_protocal_c_bax.wHz.wJF;
            bVar.imn = com_tencent_mm_protocal_c_bax.wHC.wJF;
            this.ima.imi.add(bVar);
        }
        return true;
    }

    public final void XI() {
        try {
            byte[] toByteArray = this.ima.toByteArray();
            long currentTimeMillis = System.currentTimeMillis();
            toByteArray = encrypt(toByteArray, XJ());
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            e.b(this.path, toByteArray, toByteArray.length);
            x.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
        }
    }

    private byte[] XJ() {
        return g.s(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            return null;
        }
    }

    public final List<RcptItem> oM(String str) {
        return this.imc.containsKey(str) ? (List) this.imc.get(str) : new ArrayList();
    }

    public final List<RcptItem> oN(String str) {
        return this.imd.containsKey(str) ? (List) this.imd.get(str) : new ArrayList();
    }

    private static boolean aG(String str, String str2) {
        if (str.substring(6).startsWith(str2)) {
            return true;
        }
        return false;
    }

    public final RcptItem t(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        RcptItem f = f(this.imb, str);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return null;
        }
        f = f(oM(f.code), str2);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return null;
        }
        if (TextUtils.isEmpty(str3)) {
            return f;
        }
        RcptItem f2 = f(oN(f.code), str3);
        if (f2 != null) {
            return f2;
        }
        return f;
    }

    private static RcptItem f(List<RcptItem> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            RcptItem rcptItem = (RcptItem) list.get(i);
            if (rcptItem != null && str.equals(rcptItem.name)) {
                return rcptItem;
            }
        }
        return null;
    }

    public final boolean u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        RcptItem f = f(this.imb, str);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return false;
        }
        f = f(oM(f.code), str2);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return false;
        }
        if (TextUtils.isEmpty(str3) || f(oN(f.code), str3) != null) {
            return true;
        }
        return false;
    }
}
