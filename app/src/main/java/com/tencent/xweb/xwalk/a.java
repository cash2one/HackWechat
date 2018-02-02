package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.d;
import com.tencent.xweb.g;
import com.tencent.xweb.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.R;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class a implements d {
    Context Aqf;
    WebView Asp;
    ScrollView Asq = null;
    TextView Asr = null;
    TextView Ass = null;
    TextView Ast = null;
    View Asu;
    boolean Asv = false;
    String Asw = "tools";

    public a(WebView webView) {
        this.Aqf = webView.getContext();
        this.Asp = webView;
        cIW();
        cIU();
    }

    public final void cIz() {
        if (k.cIo().Aqh) {
            a(k.cIo().Aqh, null, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean acp(String str) {
        Set<String> queryParameterNames;
        boolean z;
        if (str.contains("public.debugxweb.qq.com")) {
            Uri parse = Uri.parse(str);
            queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.size() <= 0) {
                return true;
            }
            for (String str2 : queryParameterNames) {
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1157057597:
                            if (str2.equals("enable_local_debug")) {
                                z = false;
                                break;
                            }
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            k.cIo().Aqf.getSharedPreferences("wcwebview", 0).edit().putBoolean("m_bEnableLocalDebug", parse.getBooleanQueryParameter("enable_local_debug", false)).commit();
                            break;
                        default:
                            break;
                    }
                }
            }
            return true;
        }
        boolean z2 = k.cIo().Aqf.getSharedPreferences("wcwebview", 0).getBoolean("m_bEnableLocalDebug", false);
        if (str.contains("debugxweb.qq.com")) {
            Uri parse2 = Uri.parse(str);
            queryParameterNames = parse2.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() != 0) {
                boolean z3 = false;
                boolean z4 = false;
                for (String str22 : queryParameterNames) {
                    if (str22 != null) {
                        switch (str22.hashCode()) {
                            case -604633792:
                                if (str22.equals("kill_all")) {
                                    z = true;
                                    break;
                                }
                            case -82035977:
                                if (str22.equals("inspector")) {
                                    z = false;
                                    break;
                                }
                            case 386281809:
                                if (str22.equals("set_grayvalue")) {
                                    z = true;
                                    break;
                                }
                            case 724449292:
                                if (str22.equals("use_testconfig")) {
                                    z = true;
                                    break;
                                }
                            default:
                                z = true;
                                break;
                        }
                        switch (z) {
                            case false:
                                z = parse2.getBooleanQueryParameter("inspector", false);
                                k.cIo().oa(z);
                                a(z, null, true);
                                z4 = true;
                                continue;
                            case true:
                                z = parse2.getBooleanQueryParameter("use_testconfig", false);
                                k.cIo().oc(z);
                                if (z) {
                                    bv("使用测试config", true);
                                } else {
                                    bv("使用正式config", true);
                                }
                                z4 = true;
                                continue;
                            case true:
                                try {
                                    int parseInt = Integer.parseInt(parse2.getQueryParameter("set_grayvalue"));
                                    XWalkEnvironment.setGrayValueForTest(parseInt);
                                    bv("灰度值设为" + (parseInt % 10000), true);
                                    z4 = true;
                                    continue;
                                } catch (Exception e) {
                                    bv("灰度值设置失败，参数解析错误", true);
                                    z4 = true;
                                    break;
                                }
                            case true:
                                adh();
                                z = true;
                                z3 = true;
                                break;
                        }
                    }
                    z = z3;
                    z3 = z4;
                    z4 = z3;
                    z3 = z;
                }
                if (z3) {
                    adh();
                    return true;
                } else if (z4) {
                    return true;
                }
            } else if (!z2) {
                return true;
            } else {
                cIX();
                return true;
            }
        }
        return z2 ? acs(str) : false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean acs(String str) {
        if (!str.contains("debugxweb.qq.com")) {
            return false;
        }
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.size() == 0) {
            cIX();
            return true;
        }
        for (String str2 : queryParameterNames) {
            String str22;
            if (str22 != null) {
                boolean z;
                switch (str22.hashCode()) {
                    case -974615216:
                        if (str22.equals("show_webview_version")) {
                            z = true;
                            break;
                        }
                    case -748036674:
                        if (str22.equals("set_appbrand_config")) {
                            z = true;
                            break;
                        }
                    case 368659514:
                        if (str22.equals("clear_commands")) {
                            z = true;
                            break;
                        }
                    case 603805332:
                        if (str22.equals("load_local_xwalk")) {
                            z = false;
                            break;
                        }
                    case 989541982:
                        if (str22.equals("check_xwalk_update")) {
                            z = true;
                            break;
                        }
                    case 1874228874:
                        if (str22.equals("set_web_config")) {
                            z = true;
                            break;
                        }
                    case 2135256815:
                        if (str22.equals("set_config_url")) {
                            z = true;
                            break;
                        }
                    default:
                        z = true;
                        break;
                }
                c valueOf;
                switch (z) {
                    case false:
                        od(false);
                        break;
                    case true:
                        try {
                            valueOf = c.valueOf(parse.getQueryParameter("set_web_config"));
                            k.cIo().a("tools", valueOf);
                            bv("打开网页将使用:" + valueOf, true);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case true:
                        try {
                            valueOf = c.valueOf(parse.getQueryParameter("set_appbrand_config"));
                            k.cIo().a("appbrand", valueOf);
                            k.cIo().a("support", valueOf);
                            switch (18.ArC[valueOf.ordinal()]) {
                                case 1:
                                    k.cIo().a(com.tencent.xweb.g.a.RT_TYPE_MMV8);
                                    bv("打开小程序将使用:" + valueOf, true);
                                    break;
                                case 2:
                                    k.cIo().a(com.tencent.xweb.g.a.RT_TYPE_X5);
                                    bv("打开小程序将使用:" + valueOf, true);
                                    break;
                                case 3:
                                    k.cIo().a(com.tencent.xweb.g.a.RT_TYPE_MMV8);
                                    bv("打开小程序将使用:" + valueOf, true);
                                    break;
                                default:
                                    break;
                            }
                        } catch (Exception e2) {
                            break;
                        }
                    case true:
                        z = parse.getBooleanQueryParameter("show_webview_version", false);
                        k.cIo().ob(true);
                        cIU();
                        k.cIo().ob(z);
                        break;
                    case true:
                        com.tencent.xweb.a.a(null, "0");
                        break;
                    case true:
                        try {
                            str22 = parse.getQueryParameter("set_config_url");
                            XWalkEnvironment.setTestDownLoadUrl(this.Aqf, str22);
                            bv("测试连接设置为:" + str22, true);
                            break;
                        } catch (Exception e3) {
                            bv("测试连接设置失败，格式错误", true);
                            break;
                        }
                    case true:
                        cIY();
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }

    private void cIU() {
        if (k.cIo().Aqj && this.Ast == null) {
            View scrollView = new ScrollView(this.Aqf);
            this.Ast = new TextView(this.Aqf);
            this.Ast.setBackgroundColor(-1);
            scrollView.addView(this.Ast);
            this.Ast.setOnClickListener(new 1(this));
            cIV();
            this.Asp.getTopView().addView(scrollView);
        }
    }

    final void cIV() {
        if (this.Ast != null) {
            String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
            String str = "\n\n" + this.Asp.getAbstractInfo();
            if (WebView.getCurWebType() != c.AqB) {
                str = str + "\n xwebsdk is = 17 apk ver is " + XWalkEnvironment.getAvailableVersion();
            }
            StringBuilder append = new StringBuilder().append(str).append("\n\n current js engine: =  ").append(g.cIm()).append("\n prefered js engine =  ").append(g.b(com.tencent.xweb.g.a.RT_TYPE_AUTO, "appbrand", this.Aqf)).append("\n isWaitingForUpdate = ");
            com.tencent.xweb.xwalk.a.c.cJb();
            CharSequence stringBuilder = append.append(com.tencent.xweb.xwalk.a.c.cJc()).append("\n local gray value = ").append(XWalkEnvironment.getGrayValue()).append("\n config url = ").append(xWalkUpdateConfigUrl).append("\n\n apilevel = ").append(VERSION.SDK_INT).append("\n device is  ").append(Build.BRAND).append(" ").append(Build.MODEL).toString();
            xWalkUpdateConfigUrl = com.tencent.xweb.a.getAbstractInfo();
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump commands start:------\n" + xWalkUpdateConfigUrl + "\n ------dump commands end------";
            }
            xWalkUpdateConfigUrl = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (com.tencent.xweb.xwalk.a.c.cJd()) {
                    xWalkUpdateConfigUrl = (((((xWalkUpdateConfigUrl + "going to update to apk ver = " + com.tencent.xweb.xwalk.a.c.cJh().AtB) + "\n update time is = " + simpleDateFormat.format(new Date(com.tencent.xweb.xwalk.a.c.cJh().AtK))) + "\n is patch update = " + com.tencent.xweb.xwalk.a.c.cJh().AtJ) + "\n can use cellular = " + com.tencent.xweb.xwalk.a.c.cJh().AtA) + "\n try count = " + com.tencent.xweb.xwalk.a.c.cJh().AtM) + "\n";
                }
                xWalkUpdateConfigUrl = xWalkUpdateConfigUrl + " last fetch config time = " + simpleDateFormat.format(new Date(com.tencent.xweb.xwalk.a.c.cJh().AtI));
            } catch (Exception e) {
            }
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump schedule updateInfo start:------\n" + xWalkUpdateConfigUrl + "\n ------dump schedule updateInfo end------";
            }
            xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkInitializeLog();
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump xweb log------\n" + xWalkUpdateConfigUrl;
            }
            this.Ast.setText(stringBuilder);
        }
    }

    final void cIW() {
        if (k.cIo().Aqi && this.Ass == null) {
            this.Ass = new TextView(this.Aqf);
            this.Ass.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ a Asx;

                {
                    this.Asx = r1;
                }

                public final boolean onLongClick(View view) {
                    this.Asx.cIX();
                    return true;
                }
            });
            if (this.Ass != null) {
                CharSequence versionInfo = this.Asp.getVersionInfo();
                int indexOf = versionInfo.indexOf(",apkversion");
                if (indexOf > 0) {
                    versionInfo = versionInfo.substring(0, indexOf);
                }
                this.Ass.setText(versionInfo);
            }
            this.Asp.getTopView().addView(this.Ass);
        }
    }

    final void e(c cVar) {
        switch (18.ArC[cVar.ordinal()]) {
            case 1:
                ((RadioButton) this.Asu.findViewById(R.id.WV_XWALK)).setChecked(true);
                return;
            case 2:
                ((RadioButton) this.Asu.findViewById(R.id.WV_X5)).setChecked(true);
                return;
            case 3:
                ((RadioButton) this.Asu.findViewById(R.id.WV_SYS)).setChecked(true);
                return;
            case 4:
                ((RadioButton) this.Asu.findViewById(R.id.WV_AUTO)).setChecked(true);
                return;
            default:
                return;
        }
    }

    final boolean cIX() {
        if (this.Asu != null) {
            this.Asu.setVisibility(0);
        } else {
            this.Asu = ((LayoutInflater) this.Aqf.getSystemService("layout_inflater")).inflate(R.layout.debug_menu, this.Asp.getTopView(), true).findViewById(R.id.view_root);
            ((Button) this.Asu.findViewById(R.id.button_close_menu)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a Asx;

                {
                    this.Asx = r1;
                }

                public final void onClick(View view) {
                    this.Asx.Asu.setVisibility(8);
                }
            });
            CheckBox checkBox = (CheckBox) this.Asu.findViewById(R.id.checked_show_version);
            checkBox.setChecked(k.cIo().Aqi);
            checkBox.setOnCheckedChangeListener(new 20(this));
            ((TextView) this.Asu.findViewById(R.id.check_text)).setOnClickListener(new 21(this, checkBox));
            EditText editText = (EditText) this.Asu.findViewById(R.id.txtin_grayvalue);
            if (editText != null) {
                editText.setInputType(2);
                editText.setText(XWalkEnvironment.getGrayValue());
                editText.addTextChangedListener(new 22(this, editText));
            }
            ((Spinner) this.Asu.findViewById(R.id.selector_webviewmodule)).setOnItemSelectedListener(new 23(this));
            ((RadioGroup) this.Asu.findViewById(R.id.web_select)).setOnCheckedChangeListener(new 24(this));
            switch (18.ApR[k.cIo().Aqk.ordinal()]) {
                case 1:
                    ((RadioButton) this.Asu.findViewById(R.id.v8_auto)).setChecked(true);
                    break;
                case 2:
                    ((RadioButton) this.Asu.findViewById(R.id.v8_sys)).setChecked(true);
                    break;
                case 3:
                    ((RadioButton) this.Asu.findViewById(R.id.v8_x5)).setChecked(true);
                    break;
                case 4:
                    ((RadioButton) this.Asu.findViewById(R.id.v8_nativescript)).setChecked(true);
                    break;
                case 5:
                    ((RadioButton) this.Asu.findViewById(R.id.v8_mmv8)).setChecked(true);
                    break;
            }
            ((RadioGroup) this.Asu.findViewById(R.id.v8_select)).setOnCheckedChangeListener(new 25(this));
            ((Button) this.Asu.findViewById(R.id.button_kill)).setOnClickListener(new 2(this));
            Button button = (Button) this.Asu.findViewById(R.id.btn_debug);
            a(k.cIo().Aqh, button, false);
            button.setOnClickListener(new 3(this, button));
            ((Button) this.Asu.findViewById(R.id.button_clear)).setOnClickListener(new 4(this));
            ((Button) this.Asu.findViewById(R.id.button_refreshLog)).setOnClickListener(new 5(this));
            ((Button) this.Asu.findViewById(R.id.button_loadLocalApk)).setOnClickListener(new 6(this));
            button = (Button) this.Asu.findViewById(R.id.button_config);
            button.setText(k.cIo().Aql ? "使用正式版config" : "使用测试config");
            button.setOnClickListener(new 7(this, button));
            ((Button) this.Asu.findViewById(R.id.button_update)).setOnClickListener(new 8(this));
            ((TextView) this.Asu.findViewById(R.id.txtVersion)).setText(this.Asp.getVersionInfo() + "\n" + XWalkInitializer.getXWalkInitializeLog());
            ((LinearLayout) this.Asu.findViewById(R.id.config_memu)).setVisibility(8);
            ((Button) this.Asu.findViewById(R.id.button_change_to_xweb)).setOnClickListener(new 9(this));
            ((Button) this.Asu.findViewById(R.id.button_change_to_x5)).setOnClickListener(new 10(this));
            ((Button) this.Asu.findViewById(R.id.button_change_to_sys)).setOnClickListener(new 11(this));
            ((Button) this.Asu.findViewById(R.id.button_change_to_auto)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a Asx;

                {
                    this.Asx = r1;
                }

                public final void onClick(View view) {
                    k.cIo().a("tools", c.AqA);
                    k.cIo().a("appbrand", c.AqA);
                    k.cIo().a("support", c.AqA);
                    this.Asx.act("已使用AUTO，点任意位置重启进程生效\n");
                }
            });
            ((Button) this.Asu.findViewById(R.id.button_advanced)).setOnClickListener(new 14(this));
        }
        return true;
    }

    final void cIY() {
        com.tencent.xweb.a.a(null, "0");
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.putBoolean("bCanUseCellular", true);
        edit.putLong("nTimeToUpdate", 100);
        edit.commit();
        com.tencent.xweb.xwalk.a.c.cJh().AtI = 100;
        com.tencent.xweb.xwalk.a.c.cJh().AtA = true;
        com.tencent.xweb.xwalk.a.c.cJh().AtK = 100;
        new b(this, this.Aqf).cJa();
    }

    final void adh() {
        ActivityManager activityManager = (ActivityManager) this.Aqf.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                String str = runningAppProcessInfo.processName;
                if (str == null || !str.contains("com.tencent.mm") || runningAppProcessInfo.processName.contains("tools") || runningAppProcessInfo.processName.contains("appbrand") || runningAppProcessInfo.processName.contains("support")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
        Process.killProcess(myPid);
    }

    public final void a(boolean z, Button button, boolean z2) {
        try {
            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, z);
        } catch (Exception e) {
        }
        try {
            if (VERSION.SDK_INT >= 19) {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } catch (Exception e2) {
        }
        try {
            com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception e3) {
        }
        if (z2 && this.Asp.getX5WebViewExtension() != null) {
            if (z) {
                this.Asp.loadUrl("http://debugx5.qq.com/?inspector=true");
            } else {
                this.Asp.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
        }
        if (button == null) {
            return;
        }
        if (z) {
            button.setText("关闭远程调试模式");
        } else {
            button.setText("打开远程调试模式");
        }
    }

    final void od(boolean z) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            bv("请确认应用权限，在权限管理打开应用的读写存储权限", true);
        } else if (externalStorageDirectory.listFiles() == null) {
            bv("请确认应用权限，在权限管理打开应用的读写存储权限", true);
        } else {
            externalStorageDirectory.toString();
            try {
                File[] listFiles = new File(externalStorageDirectory.getPath() + "/apkxwebtest").listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    bv("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    return;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getName().endsWith(".zip")) {
                        String absolutePath = listFiles[i].getAbsolutePath();
                        String name = listFiles[i].getName();
                        if (z) {
                            new Builder(this.Aqf).setTitle("提示").setMessage("确定加载:" + name + "?").setPositiveButton("确定", new 16(this, absolutePath, name, z)).setNegativeButton("取消", new 15(this)).show();
                            return;
                        } else {
                            x(absolutePath, name, z);
                            return;
                        }
                    }
                }
                bv("apkxwebtest目录下没有.zip文件", true);
            } catch (Exception e) {
                bv("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
            }
        }
    }

    final void x(String str, String str2, boolean z) {
        UpdateConfig aVar = new a(str, str2);
        try {
            File file = new File(XWalkEnvironment.getDownloadZipDir(aVar.apkVer));
            if (file.exists()) {
                file.delete();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
        try {
            Integer onHandleFile = XWalkUpdater.onHandleFile(aVar);
            if (onHandleFile.intValue() == 0) {
                bv("安装" + str2 + "成功", z);
            } else {
                bv("安装" + str2 + "失败,错误码=" + onHandleFile, true);
            }
        } catch (Exception e2) {
            bv("安装失败", true);
            Log.e("WebDebugPage", "install local apk failed : " + e2.getMessage());
        }
    }

    final void bv(String str, boolean z) {
        if (z) {
            Builder builder = new Builder(this.Aqf);
            builder.setMessage(str);
            builder.create().show();
            return;
        }
        Log.e("WebDebugPage", str);
    }

    final void act(String str) {
        Builder builder = new Builder(this.Aqf);
        builder.setMessage(str);
        builder.create();
        builder.setCancelable(true);
        builder.setOnCancelListener(new 17(this));
        builder.show();
    }
}
