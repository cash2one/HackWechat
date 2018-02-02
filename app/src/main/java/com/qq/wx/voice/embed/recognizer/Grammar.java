package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.xwalk.core.XWalkUpdater;

public class Grammar {
    public static String mData = null;
    public static String mDataPath = null;
    public static String mSo = null;
    private f a;
    private a b;
    private boolean c;
    private boolean d;
    private ArrayList e;

    public Grammar() {
        this.a = null;
        this.b = new a();
        this.c = false;
        this.d = false;
        this.e = null;
        this.a = new f();
    }

    private String a() {
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            ((d) this.e.get(i2)).bgq = a(((d) this.e.get(i2)).userName);
            ((d) this.e.get(i2)).bgr = a(((d) this.e.get(i2)).bgo);
            ((d) this.e.get(i2)).bgs = a(((d) this.e.get(i2)).bgp);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        while (i < this.e.size()) {
            String str = ((d) this.e.get(i)).bgq;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            str = ((d) this.e.get(i)).bgr;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            str = ((d) this.e.get(i)).bgs;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private static String a(String str) {
        return new String(str).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "").replaceAll("0", "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
    }

    public int begin() {
        return GrammarNative.begin();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int checkFiles(Context context, String str, String str2, String str3) {
        if (this.c) {
            return 0;
        }
        if (context == null || str == null || str2 == null || str3 == null) {
            return -303;
        }
        int d;
        if (VERSION.SDK_INT >= 24) {
            d = this.a.d("/vendor/lib/", str2, str3);
        } else if (str.compareTo("/system/lib") == 0 || str.compareTo("/system/lib/") == 0) {
            d = this.a.d(str, str2, str3);
            if (d < 0) {
                return d;
            }
            mDataPath = this.a.b;
            mData = "libwxvoiceembed.bin";
            mSo = "libwxvoiceembed.so";
            this.c = true;
            return 0;
        }
        d = this.a.a(context, str, str2, str3);
        if (d < 0) {
            return d;
        }
        mDataPath = this.a.b;
        mData = "libwxvoiceembed.bin";
        mSo = "libwxvoiceembed.so";
        this.c = true;
        return 0;
    }

    public int end() {
        return GrammarNative.end();
    }

    public int getResult(a aVar) {
        int result = GrammarNative.getResult(this);
        if (result < 0) {
            return result;
        }
        aVar.text = this.b.text;
        if (this.b.name == null) {
            aVar.name = null;
            return 0;
        }
        int i = 0;
        while (i < this.e.size()) {
            if (((d) this.e.get(i)).bgq.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                return 0;
            } else if (((d) this.e.get(i)).bgr.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                return 0;
            } else if (((d) this.e.get(i)).bgs.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                return 0;
            } else {
                i++;
            }
        }
        return 0;
    }

    public int init(ArrayList arrayList) {
        if (this.d) {
            return 0;
        }
        if (arrayList == null) {
            return -303;
        }
        try {
            System.load(mDataPath + "/" + mSo);
            this.e = arrayList;
            String a = a();
            try {
                if (GrammarNative.init(mDataPath.getBytes(), mData.getBytes(), a.toString().getBytes("GBK")) < 0) {
                    new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                    return XWalkUpdater.ERROR_SET_VERNUM;
                }
                this.d = true;
                return 0;
            } catch (UnsupportedEncodingException e) {
                new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                return XWalkUpdater.ERROR_SET_VERNUM;
            }
        } catch (Exception e2) {
            return -205;
        }
    }

    public void onGetResult(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null) {
            try {
                this.b.text = new String(bArr, "GBK");
            } catch (UnsupportedEncodingException e) {
                return;
            }
        }
        this.b.text = null;
        if (bArr3 != null) {
            this.b.name = new String(bArr3, "GBK");
            return;
        }
        this.b.name = null;
    }

    public int recognize(byte[] bArr, int i) {
        return GrammarNative.recognize(bArr, i);
    }

    public int update(ArrayList arrayList) {
        if (arrayList == null) {
            return -303;
        }
        this.e = arrayList;
        try {
            return GrammarNative.update(a().getBytes("GBK")) >= 0 ? 0 : -106;
        } catch (UnsupportedEncodingException e) {
            return -106;
        }
    }
}
