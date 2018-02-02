package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.DatePicker;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.av.b.9;
import com.tencent.mm.bc.j;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelgeo.a.b;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.webview.fts.c.1;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ae;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI;
import com.tencent.mm.plugin.webview.ui.tools.a.a$a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.protocal.c.bry;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.protocal.c.bxe;
import com.tencent.mm.protocal.c.bxf;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.cbo;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.as;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.t;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaLink;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xwalk.core.R$styleable;

public final class g implements a {
    private static final char[] jRP = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] jRQ = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static final HashSet<String> jkm;
    public static int tHA = -1;
    private static final LinkedList<Runnable> tHY = new LinkedList();
    private static boolean tHZ = false;
    public static Context tHz;
    private static a tIa = new 114();
    private Context context;
    public e fBH;
    public final int fDl;
    private WXMediaMessage fzc;
    private Map<String, akt> gyC = new ConcurrentHashMap();
    private c gyy = null;
    private ProgressDialog iln = null;
    private com.tencent.mm.sdk.b.c jcH;
    private String kGH = null;
    private af mHG;
    public HashSet<String> mWj;
    public boolean maM = false;
    private ProgressDialog nIK;
    private float pYC = 0.0f;
    private com.tencent.mm.sdk.b.c qsf = new 32(this);
    public com.tencent.mm.sdk.b.c qsg = new 33(this);
    private c tHB = null;
    public boolean tHC = false;
    private final j tHD;
    private final d tHE;
    private long tHF = 0;
    private int tHG;
    private int tHH = -1;
    private Map<String, String> tHI = new ConcurrentHashMap();
    private Map<String, List<aku>> tHJ = new ConcurrentHashMap();
    private List<akt> tHK = new CopyOnWriteArrayList();
    private boolean tHL = false;
    private long tHM = 0;
    LocationManager tHN = null;
    private String tHO = "-1000.0";
    private String tHP = "-1000.0";
    private boolean tHQ = false;
    private SensorEventListener tHR = new SensorEventListener(this) {
        final /* synthetic */ g tIj;

        {
            this.tIj = r1;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                this.tIj.pYC = sensorEvent.values[0];
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private b tHS = null;
    public i tHT;
    public com.tencent.mm.sdk.b.c tHU = new 55(this);
    public final Map<String, b> tHV = new HashMap();
    public String tHW;
    public final List<String> tHX = new LinkedList();
    public i tHp;
    public i tHq;
    public HashSet<String> tHr;
    public Bundle tHs;
    private String tHt = null;
    public HashMap<String, String> tHu = null;
    public HashMap<String, String> tHv = null;
    public String tHw = null;
    public e tHx;
    private e tHy;
    public final Map<Integer, c> tIb = new HashMap();
    private int tIc = 0;
    private int tId = 1000;
    public volatile i tIe = null;
    public final com.tencent.mm.sdk.b.c tIf = new 21(this);

    class AnonymousClass106 implements o$a {
        final /* synthetic */ String fgO;
        final /* synthetic */ String hAS;
        final /* synthetic */ String jde;
        final /* synthetic */ g tIj;
        final /* synthetic */ f tIp;
        final /* synthetic */ String tIq;
        final /* synthetic */ String tIr;
        final /* synthetic */ String tIs;
        final /* synthetic */ boolean tJt = true;
        final /* synthetic */ String tJu;
        final /* synthetic */ String tJv;

        AnonymousClass106(g gVar, f fVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
            this.tIj = gVar;
            this.tIp = fVar;
            this.jde = str;
            this.fgO = str2;
            this.hAS = str3;
            this.tIq = str4;
            this.tIr = str5;
            this.tIs = str6;
            this.tJu = str7;
            this.tJv = str8;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                this.tIj.a(this.tIp, this.jde, this.fgO, this.hAS, this.tIq, this.tIr, str, this.tIs);
                if (this.tJt) {
                    com.tencent.mm.bm.d.a(this.tIj.context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.fgO));
                } else if (this.tIj.context != null) {
                    h.bu(this.tIj.context, this.tIj.context.getResources().getString(R.l.dGG));
                }
                this.tIj.em(1, 1);
                this.tIj.a(this.tIj.tHp, this.tJu, null);
                return;
            }
            this.tIj.em(1, 3);
            this.tIj.a(this.tIj.tHp, this.tJv, null);
        }
    }

    static /* synthetic */ void B(g gVar) {
        try {
            gVar.fBH.e(12, new Bundle(0));
            gVar.fBH.e(11, new Bundle(0));
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "clearCloseWindowConfirmDialogInfo, exception = %s", new Object[]{e});
        }
    }

    static /* synthetic */ boolean B(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenProductViewWithPid");
        String str = (String) iVar.pox.get("pid");
        String str2 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Integer valueOf = Integer.valueOf(bh.getInt((String) iVar.pox.get(DownloadSettingTable$Columns.TYPE), 0));
        int i = bh.getInt((String) iVar.pox.get("view_type"), 0);
        String str3 = (String) iVar.pox.get("ext_info");
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_source_url", str2);
        return gVar.a(valueOf, 8, i, str3, intent);
    }

    static /* synthetic */ boolean C(g gVar, i iVar) {
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        x.i("MicroMsg.MsgHandler", "dogetBrandWCPayBindCardRequest JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            gVar2.fCW = 4;
            com.tencent.mm.pluginsdk.wallet.h.b((MMActivity) gVar.context, gVar2, 7, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean D(g gVar, i iVar) {
        String str = (String) iVar.pox.get(DownloadSettingTable$Columns.TYPE);
        x.v("MicroMsg.MsgHandler", "doGeoLocation, geoType = %s", new Object[]{str});
        if (bh.ov(str) || jkm.contains(str)) {
            gVar.gyy = c.OP();
            if (gVar.gyy == null) {
                x.e("MicroMsg.MsgHandler", "doGeoLocation fail, iGetLocation is null");
                gVar.a(iVar, "geo_location:fail", null);
            } else {
                str = (String) gVar.tHp.pox.get(DownloadSettingTable$Columns.TYPE);
                if (gVar.tHS == null) {
                    gVar.tHS = new b(gVar) {
                        final /* synthetic */ g tIj;

                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                            return false;
                        }

                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, Bundle bundle) {
                            if (!z) {
                                return true;
                            }
                            x.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
                            if (this.tIj.gyy != null) {
                                this.tIj.gyy.c(this.tIj.tHS);
                            }
                            if (this.tIj.tHS == null) {
                                x.w("MicroMsg.MsgHandler", "already callback");
                                return false;
                            }
                            this.tIj.tHS = null;
                            Map hashMap = new HashMap();
                            hashMap.put("longitude", Float.valueOf(f));
                            this.tIj.tHP = String.valueOf(f);
                            hashMap.put("latitude", Float.valueOf(f2));
                            this.tIj.tHO = String.valueOf(f2);
                            hashMap.put("speed", Double.valueOf(d));
                            hashMap.put("accuracy", Double.valueOf(d2));
                            hashMap.put(DownloadSettingTable$Columns.TYPE, str);
                            if (bundle != null) {
                                hashMap.put("indoor_building_id", bundle.getString("indoor_building_id"));
                                hashMap.put("indoor_building_floor", bundle.getString("indoor_building_floor"));
                                hashMap.put("indoor_building_type", Integer.valueOf(bundle.getInt("indoor_building_type")));
                            }
                            this.tIj.a(this.tIj.tHp, "geo_location:ok", hashMap);
                            return false;
                        }
                    };
                }
                if (gVar.mHG == null) {
                    gVar.mHG = new af(Looper.getMainLooper());
                }
                gVar.mHG.postDelayed(new Runnable(gVar) {
                    final /* synthetic */ g tIj;

                    {
                        this.tIj = r1;
                    }

                    public final void run() {
                        if (this.tIj.gyy != null) {
                            this.tIj.gyy.c(this.tIj.tHS);
                        }
                        if (this.tIj.tHS == null) {
                            x.w("MicroMsg.MsgHandler", "already callback");
                            return;
                        }
                        this.tIj.tHS = null;
                        this.tIj.a(this.tIj.tHp, "geo_location:fail_timeout", null);
                    }
                }, 20000);
                if (bh.ov(str) || str.equalsIgnoreCase("gcj02")) {
                    gVar.gyy.b(gVar.tHS, false);
                } else if (str.equalsIgnoreCase("wgs84")) {
                    gVar.gyy.a(gVar.tHS, false);
                } else {
                    x.e("MicroMsg.MsgHandler", "startGeoLocation, should not reach here !!!!!");
                    gVar.tHS = null;
                    gVar.a(gVar.tHp, "geo_location:fail_unsupported_type_startgeo", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doGeoLocation fail, unsupported type = %s", new Object[]{str});
            gVar.a(iVar, "geo_location:fail_unsupported_type", null);
        }
        return true;
    }

    static /* synthetic */ boolean I(g gVar, i iVar) {
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        x.i("MicroMsg.MsgHandler", "doOpenWXCredit JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            gVar2.fCW = 6;
            com.tencent.mm.pluginsdk.wallet.h.b((MMActivity) gVar.context, gVar2, 9, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean J(g gVar, final i iVar) {
        if (gVar.tHs == null) {
            x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, jsapiArgs is null");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        } else if (gVar.tHs.getBoolean("isFromService", false)) {
            String string = gVar.tHs.getString("jsapi_args_appid");
            String string2 = gVar.tHs.getString("sendAppMsgToUserName");
            k.a(iVar.tJH, false, null, string);
            gVar.fzc = f(iVar);
            if (gVar.fzc == null) {
                x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, appmsg is null");
                gVar.a(iVar, "send_service_app_msg:fail", null);
            } else {
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(string, true);
                if (bh.ov(string2)) {
                    x.e("MicroMsg.MsgHandler", "toUser is null");
                    gVar.a(iVar, "send_service_app_msg:fail", null);
                } else {
                    final String str = (String) iVar.pox.get("img_url");
                    com.tencent.mm.plugin.report.service.g.pQN.h(10923, new Object[]{Integer.valueOf(13), aZ.field_appId, Integer.valueOf(1)});
                    if (bh.ov(str)) {
                        gVar.a(aZ, "", string2, str, null, null, null, null);
                        h.bu(gVar.context, gVar.context.getString(R.l.dGy));
                        gVar.a(iVar, "send_service_app_msg:ok", null);
                        gVar.aT(iVar);
                    } else {
                        o.Pv().a(str, new 16(gVar, h.a(gVar.context, gVar.context.getResources().getString(R.l.dGB), true, new OnCancelListener(gVar) {
                            final /* synthetic */ g tIj;

                            public final void onCancel(DialogInterface dialogInterface) {
                                o.Pv().le(str);
                                this.tIj.a(iVar, "send_service_app_msg:fail", null);
                            }
                        }), aZ, string2, str, iVar));
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, not from service");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean L(g gVar, i iVar) {
        String str = (String) iVar.pox.get("title");
        String str2 = (String) iVar.pox.get("singer");
        String str3 = (String) iVar.pox.get("epname");
        String str4 = (String) iVar.pox.get("coverImgUrl");
        String str5 = (String) iVar.pox.get("dataUrl");
        String str6 = (String) iVar.pox.get("lowbandUrl");
        String str7 = (String) iVar.pox.get("webUrl");
        String str8 = (String) iVar.pox.get("appId");
        String str9 = str4 == null ? "" : str4;
        k.a(iVar.tJH, false, null, str8);
        x.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str, str2, str3, str9, str5, str6, str7, str8});
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3) || bh.ov(str9) || bh.ov(str6) || bh.ov(str5) || bh.ov(str7)) {
            gVar.a(iVar, "playMusic:fail", null);
        } else {
            com.tencent.mm.av.b.Qo();
            com.tencent.mm.av.a.a aVar = (com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class);
            String str10 = str5.hashCode();
            String str11 = com.tencent.mm.compatible.util.e.bnF;
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            com.tencent.mm.av.b.b(aVar.a(7, str9, str, str2, str7, str6, str5, str10, str11, stringBuilder.append(com.tencent.mm.z.c.Fi()).append(str9.hashCode()).toString(), str3, str8));
            gVar.a(iVar, "playMusic:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean M(g gVar, i iVar) {
        boolean z = false;
        String str = (String) iVar.pox.get("ssid");
        String str2 = (String) iVar.pox.get("password");
        x.d("MicroMsg.MsgHandler", "doConnectToWifi, ssid : %s, password : %s, encryptType : %s, hidessid : %s", new Object[]{str, str2, (String) iVar.pox.get(DownloadSettingTable$Columns.TYPE), (String) iVar.pox.get("isHidden")});
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "ssid is null");
            gVar.a(iVar, "connecttowifi:failed_ssid_invalid", null);
        } else {
            int i = bh.getInt(r0, 0);
            if (i == 0 || !bh.ov(str2)) {
                if (bh.getInt(r1, 0) == 1) {
                    z = true;
                }
                ag.y(new 50(gVar, str, str2, z, i));
                gVar.a(iVar, "connecttowifi:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "encrypt type, while the password is null");
                gVar.a(iVar, "connecttowifi:failed_password_invalid", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean N(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetTransferMoneyRequest JSOAUTH");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            Intent intent = new Intent();
            intent.putExtra("scene", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.fqJ);
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.b(gVar.context, "remittance", ".ui.RemittanceAdapterUI", intent, 11);
        }
        return true;
    }

    static /* synthetic */ boolean O(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.fqJ);
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "wallet_index", ".ui.WalletOpenViewProxyUI", intent, 17, false);
        }
        return true;
    }

    static /* synthetic */ boolean P(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseCard JSOAUTH");
        String str = (String) iVar.pox.get("app_id");
        int i = bh.getInt((String) iVar.pox.get("location_id"), 0);
        String str2 = (String) iVar.pox.get("sign_type");
        String str3 = (String) iVar.pox.get("card_sign");
        int i2 = bh.getInt((String) iVar.pox.get("time_stamp"), 0);
        String str4 = (String) iVar.pox.get("nonce_str");
        String str5 = (String) iVar.pox.get("card_id");
        String str6 = (String) iVar.pox.get("card_type");
        if ("INVOICE".equalsIgnoreCase(str6)) {
            gVar.a(iVar, "choose_card:fail", new HashMap());
            return false;
        }
        int i3 = bh.getInt((String) iVar.pox.get("can_multi_select"), 0);
        k.a(iVar.tJH, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("shop_id", i);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i2);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("card_tp_id", str5);
        intent.putExtra("card_type", str6);
        intent.putExtra("can_multi_select", i3);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 13, false);
        }
        return true;
    }

    static /* synthetic */ boolean Q(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseInvoice JSOAUTH");
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("signType");
        String str3 = (String) iVar.pox.get("cardSign");
        int i = bh.getInt((String) iVar.pox.get("timestamp"), 0);
        String str4 = (String) iVar.pox.get("nonceStr");
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 36, false);
        }
        return true;
    }

    static /* synthetic */ boolean R(g gVar, i iVar) {
        String str = (String) iVar.pox.get("card_list");
        String str2 = (String) iVar.pox.get("src_username");
        String str3 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str4 = (String) iVar.pox.get("tempalate_id");
        x.i("MicroMsg.MsgHandler", "doBatchAddCard consumedCardId %s", new Object[]{(String) iVar.pox.get("consumedCardId")});
        x.i("MicroMsg.MsgHandler", "doBatchAddCard %s", new Object[]{iVar.pox.toString()});
        x.i("MicroMsg.MsgHandler", "doBatchAddCard src_username is %s, scene is %d, stasticScene is %d", new Object[]{str2, Integer.valueOf(bh.getInt((String) iVar.pox.get("webview_scene"), 0) == 25 ? 16 : 7), Integer.valueOf(bh.getInt((String) iVar.pox.get("stastic_scene"), 0))});
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", str);
        intent.putExtra("key_from_scene", r6);
        intent.putExtra("key_stastic_scene", r7);
        intent.putExtra("src_username", str2);
        intent.putExtra("js_url", str3);
        intent.putExtra("key_consumed_card_id", r4);
        intent.putExtra("key_template_id", str4);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "card", ".ui.CardAddEntranceUI", intent, 16, false);
        }
        return true;
    }

    static /* synthetic */ boolean V(g gVar, i iVar) {
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        k.a(iVar.tJH, false, null, str);
        x.i("MicroMsg.MsgHandler", "doPlayVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (bh.ov(str) || bh.ov(str2)) {
            gVar.a(iVar, "playVoice:fail_missing arguments", null);
        } else {
            WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
            if (Oo != null) {
                ag.y(new 70(gVar, Oo, str2));
                gVar.a(iVar, "playVoice:ok", null);
            } else {
                gVar.a(iVar, "playVoice:fail_arguments error", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean W(g gVar, i iVar) {
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        k.a(iVar.tJH, false, null, str);
        x.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (bh.ov(str) || bh.ov(str2)) {
            gVar.a(iVar, "pauseVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
            if (Oo != null) {
                ag.y(new Runnable(gVar) {
                    final /* synthetic */ g tIj;

                    public final void run() {
                        com.tencent.mm.sdk.b.b ezVar = new ez();
                        ezVar.ftT.op = 4;
                        ezVar.ftT.fileName = Oo.fileName;
                        com.tencent.mm.sdk.b.a.xef.m(ezVar);
                    }
                });
                gVar.a(iVar, "pauseVoice:ok", null);
            } else {
                gVar.a(iVar, "pauseVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean X(g gVar, i iVar) {
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        x.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        k.a(iVar.tJH, false, null, str);
        if (bh.ov(str) || bh.ov(str2)) {
            gVar.a(iVar, "stopVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
            if (Oo != null) {
                ag.y(new Runnable(gVar) {
                    final /* synthetic */ g tIj;

                    public final void run() {
                        com.tencent.mm.sdk.b.b ezVar = new ez();
                        ezVar.ftT.op = 2;
                        ezVar.ftT.fileName = Oo.fileName;
                        com.tencent.mm.sdk.b.a.xef.m(ezVar);
                    }
                });
                gVar.a(iVar, "stopVoice:ok", null);
            } else {
                gVar.a(iVar, "stopVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ i a(g gVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (gVar.context == null || gVar.context.getResources() == null) {
            x.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
            return null;
        } else if (gVar.context instanceof Activity) {
            String bUx = gVar.bUx();
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            return com.tencent.mm.pluginsdk.ui.applet.e.a(((MMActivity) gVar.context).mController, str2, str3, str5, null, true, gVar.context.getResources().getString(R.l.dGA), new AnonymousClass106(gVar, aZ, str, str4, str3, str6, str7, bUx, true, str8, str9));
        } else {
            x.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
            return null;
        }
    }

    static /* synthetic */ void a(g gVar, e eVar, i iVar, String str) {
        String str2 = null;
        gVar.maM = false;
        if (iVar != null) {
            str2 = iVar.tJG;
        }
        try {
            eVar.a(str2, str, i.ap(null), true);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void a(g gVar, String str, String str2, String str3) {
        ar.Hg();
        String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", str);
        EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(str);
        if (XU == null && com.tencent.mm.a.e.bO(H)) {
            int i = p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.xAe;
            emojiInfo.field_type = i;
            emojiInfo.field_size = com.tencent.mm.a.e.bN(H);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            if (!bh.ov(str3)) {
                emojiInfo.field_activityid = str3;
            }
            com.tencent.mm.plugin.emoji.model.i.aBE().lwL.n(emojiInfo);
            XU = emojiInfo;
        }
        if (XU != null) {
            x.i("MicroMsg.MsgHandler", "doAddAction %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.emoji.model.i.aBA().a(gVar.context, XU, 18, q.FS()))});
            if (com.tencent.mm.plugin.emoji.model.i.aBA().a(gVar.context, XU, 18, q.FS())) {
                gVar.a(gVar.tHp, "addToEmoticon:ok", null);
                return;
            } else {
                gVar.a(gVar.tHp, "addToEmoticon:fail", null);
                return;
            }
        }
        gVar.a(gVar.tHp, "addToEmoticon:fail", null);
    }

    static /* synthetic */ boolean a(g gVar, i iVar, int i) {
        String str = "";
        if (iVar.pox.containsKey("canvasId")) {
            str = iVar.pox.get("canvasId").toString();
        }
        int i2 = 0;
        if (iVar.pox.containsKey("preLoad")) {
            i2 = bh.VI(iVar.pox.get("preLoad").toString());
        }
        int i3 = 0;
        if (iVar.pox.containsKey("noStore")) {
            i3 = bh.VI(iVar.pox.get("noStore").toString());
        }
        String str2 = "";
        if (iVar.pox.containsKey("extraData")) {
            str2 = iVar.pox.get("extraData").toString();
        }
        String str3 = "";
        if (iVar.pox.containsKey("adInfoXml")) {
            str3 = iVar.pox.get("adInfoXml").toString();
        }
        String str4 = "";
        if (iVar.pox.containsKey("sessionId")) {
            str4 = iVar.pox.get("sessionId").toString();
        }
        String str5 = "";
        if (iVar.pox.containsKey("adBuffer")) {
            str5 = iVar.pox.get("adBuffer").toString();
        }
        String str6 = "";
        if (iVar.pox.containsKey("canvasExt")) {
            str6 = iVar.pox.get("canvasExt").toString();
        }
        x.i("MicroMsg.MsgHandler", "doOpenCanvas canvasid %s, getCanvasSource %d, preLoad %d, noStore %d, extra %s source %d adInfoXml %s, sessionId %s, adBuffer %s, canvasExt %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i), str3, str4, str5, str6});
        Map hashMap = new HashMap();
        if (bh.ov(str) || "0".equals(str)) {
            hashMap.put("ret", Integer.valueOf(-1));
            hashMap.put("ret_msg", "invalid page id = " + str);
            gVar.a(iVar, "doOpenCanvas:fail", hashMap);
            return false;
        }
        com.tencent.mm.sdk.b.b lbVar = new lb();
        lbVar.fCn.fCp = str;
        lbVar.fCn.fqf = str6;
        lbVar.fCn.fCq = i2;
        lbVar.fCn.fCr = i3;
        lbVar.fCn.cOY = i;
        com.tencent.mm.sdk.b.a.xef.m(lbVar);
        if (i2 != 1) {
            String str7 = lbVar.fCo.fCs;
            Intent intent = new Intent();
            String str8 = "sns_landing_pages_xml";
            if (str7 == null) {
                str7 = "";
            }
            intent.putExtra(str8, str7);
            if (i == 1) {
                intent.putExtra("sns_landing_pages_canvasid", str);
                intent.putExtra("sns_landig_pages_from_source", 15);
                intent.putExtra("sns_landing_pages_search_extra", str2);
                intent.putExtra("sns_landing_pages_sessionId", str4);
                intent.putExtra("sns_landing_pages_ad_buffer", str5);
                intent.putExtra("sns_landing_pages_canvas_ext", str6);
            } else {
                intent.putExtra("sns_landing_pages_pageid", bh.VJ(str));
                intent.putExtra("sns_landig_pages_from_source", 13);
                intent.putExtra("sns_landing_pages_extra", str2);
            }
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            intent.putExtra("sns_landing_pages_no_store", i3);
            intent.putExtra("sns_landing_pages_ad_info", str3);
            com.tencent.mm.bm.d.b(gVar.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        }
        hashMap.put("ret", Integer.valueOf(0));
        gVar.a(iVar, "doOpenCanvas:succ", hashMap);
        return true;
    }

    static /* synthetic */ boolean a(g gVar, i iVar, boolean z) {
        String str = (String) iVar.pox.get("designerId");
        int i = bh.getInt((String) iVar.pox.get("designerUin"), 0);
        String str2 = (String) iVar.pox.get("tagId");
        String str3 = (String) iVar.pox.get("tagDesc");
        String str4 = (String) iVar.pox.get("keyword");
        int i2 = bh.getInt((String) iVar.pox.get("tid"), 0);
        String az = bh.az((String) iVar.pox.get("title"), "");
        String az2 = bh.az((String) iVar.pox.get("desc"), "");
        String az3 = bh.az((String) iVar.pox.get("iconUrl"), "");
        String az4 = bh.az((String) iVar.pox.get("secondUrl"), "");
        int i3 = bh.getInt((String) iVar.pox.get("pageType"), 0);
        long j = bh.getLong((String) iVar.pox.get("searchID"), 0);
        x.d("MicroMsg.MsgHandler", "cpan emoji openDesignerEmojiView:%d", new Object[]{Long.valueOf(j)});
        Intent intent = new Intent();
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
        intent.putExtra("headurl", az4);
        intent.putExtra("set_iconURL", az3);
        intent.putExtra("set_desc", az2);
        intent.putExtra("pageType", i3);
        intent.putExtra("set_title", az);
        intent.putExtra("set_id", i2);
        x.i("MicroMsg.MsgHandler", "openDesignerEmojiView event: designerID:%s tagID:%s tagDesc:%s keyword:%s", new Object[]{str, str2, str3, str4});
        if (!bh.ov(str4)) {
            intent.putExtra("keyword", str4);
            intent.putExtra("searchID", j);
            com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok" + str4, null);
            if (z) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13055, new Object[]{Integer.valueOf(2), "", "", "", Integer.valueOf(com.tencent.mm.ak.a.Nj()), Long.valueOf(j)});
            }
            return true;
        } else if (!bh.ov(str)) {
            intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, str);
            intent.putExtra("searchID", j);
            com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok" + str, null);
            return true;
        } else if (bh.ov(str2)) {
            com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok", null);
            return true;
        } else {
            intent.putExtra("tag_id", str2);
            intent.putExtra("tag_desc", str3);
            com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            gVar.a(iVar, "openDesignerEmojiView:ok" + str2, null);
            return true;
        }
    }

    static /* synthetic */ boolean a(g gVar, String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT >= 18 && defaultAdapter != null) {
            com.tencent.mm.sdk.b.a.xef.b(gVar.qsf);
            String ou = bh.ou(str);
            gVar.tHI.put(ou, ou);
            x.i("MicroMsg.MsgHandler", "[MsgHandler][doStartIBeaconRange]op=true,iBeacon = %s", new Object[]{ou});
            Editor edit = ac.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", true);
            edit.commit();
            if (ar.Hj()) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xqb, Boolean.valueOf(true));
            }
            com.tencent.mm.sdk.b.b djVar = new dj();
            djVar.frU.frW = ou;
            djVar.frU.frT = true;
            com.tencent.mm.sdk.b.a.xef.m(djVar);
        }
        return true;
    }

    static /* synthetic */ boolean aF(g gVar, i iVar) {
        String str = (String) iVar.pox.get("gameId");
        if (bh.ov(str)) {
            str = (String) iVar.pox.get("appId");
        }
        x.i("MicroMsg.MsgHandler", "openGameDetail, appid = %s", new Object[]{str});
        if (bh.ov(str)) {
            gVar.a(iVar, "openGameDetail:fail", null);
        } else {
            com.tencent.mm.sdk.b.b gmVar = new gm();
            gmVar.fwC.appId = str;
            gmVar.fwC.scene = 5;
            gmVar.fwC.actionCode = 2;
            gmVar.fwC.context = gVar.context;
            com.tencent.mm.sdk.b.a.xef.m(gmVar);
            gVar.a(iVar, "openGameDetail:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aG(g gVar, i iVar) {
        int i = bh.getInt((String) iVar.pox.get("jumpView"), 0);
        int i2 = bh.getInt((String) iVar.pox.get("jumpType"), 0);
        String str = (String) iVar.pox.get("extInfo");
        com.tencent.mm.sdk.b.b lgVar = new lg();
        lgVar.fCD.fCE = i;
        lgVar.fCD.jumpType = i2;
        lgVar.fCD.extraInfo = str;
        lgVar.fCD.context = gVar.context;
        com.tencent.mm.sdk.b.a.xef.m(lgVar);
        gVar.a(iVar, "gameCenterJump:ok", null);
        return true;
    }

    static /* synthetic */ boolean aH(g gVar, i iVar) {
        int i = bh.getInt((String) iVar.pox.get("downloaderType"), 0);
        String str = (String) iVar.pox.get("countryCode");
        int i2 = bh.getInt((String) iVar.pox.get("showAllLog"), 0);
        com.tencent.mm.sdk.b.b goVar = new go();
        goVar.fwG.fwH = i;
        goVar.fwG.fwI = i2;
        goVar.fwG.countryCode = str;
        com.tencent.mm.sdk.b.a.xef.m(goVar);
        gVar.a(iVar, "setGameDebugConfig:ok", null);
        return true;
    }

    static /* synthetic */ boolean aJ(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetRecevieBizHongBaoRequest");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, 22);
        }
        return true;
    }

    static /* synthetic */ boolean aK(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doOpenMyDeviceProfile");
        if (gVar.context != null) {
            String str = (String) iVar.pox.get("deviceType");
            if (bh.ov(str)) {
                x.e("MicroMsg.MsgHandler", "deviceType is null");
                gVar.a(iVar, "openMyDeviceProfile:fail_no deviceType", null);
            } else {
                String str2 = (String) iVar.pox.get("deviceId");
                if (bh.ov(str2)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    gVar.a(iVar, "openMyDeviceProfile:fail_no deviceId", null);
                } else {
                    Intent intent = new Intent();
                    if (!(gVar.context instanceof Activity)) {
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    intent.putExtra("device_type", str);
                    intent.putExtra("device_id", str2);
                    com.tencent.mm.bm.d.b(gVar.context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent);
                    gVar.a(iVar, "openMyDeviceProfile:ok", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "context is null");
            gVar.a(iVar, "openMyDeviceProfile:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean aL(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: doGetIbgPrepayRequest");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            gVar2.vzJ = 2;
            com.tencent.mm.pluginsdk.wallet.h.a((MMActivity) gVar.context, gVar2, 27, gVar);
            long j = bh.getLong((String) iVar.pox.get("message_id"), 0);
            int i = bh.getInt((String) iVar.pox.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.pQN.h(10593, new Object[]{gVar2.fCU, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.fCV), gVar2.url});
            gVar.tHH = gVar.aU(iVar);
        }
        return true;
    }

    static /* synthetic */ boolean aM(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: doGetIbgTransactionRequest");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            gVar.tHG = bh.getInt((String) iVar.pox.get("closeWebAfterPayDetailBack"), 0);
            MMActivity mMActivity = (MMActivity) gVar.context;
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            mMActivity.jwN = gVar;
            com.tencent.mm.bm.d.a(mMActivity, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent, 25, true);
            long j = bh.getLong((String) iVar.pox.get("message_id"), 0);
            int i = bh.getInt((String) iVar.pox.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.pQN.h(10593, new Object[]{gVar2.fCU, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.fCV), gVar2.url});
        }
        return true;
    }

    static /* synthetic */ boolean aN(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToWXWallet");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("key_wallet_region", 1);
            com.tencent.mm.bm.d.a(gVar.context, "mall", ".ui.MallIndexUI", intent, false);
            gVar.a(iVar, "jump_to_wx_wallet:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aO(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doScanCover");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 2);
        if (com.tencent.mm.p.a.aV(gVar.context) || com.tencent.mm.au.a.Qj()) {
            x.i("MicroMsg.MsgHandler", "VoipOutOfPackageUtil.checkCameraUsingAndShowToast fail");
            gVar.a(iVar, "scanCover:fail", null);
        } else {
            com.tencent.mm.bm.d.a(gVar.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            gVar.a(iVar, "sacnCover:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aP(g gVar, i iVar) {
        if (gVar.f("nfcIsConnect", 4001, new Bundle())) {
            gVar.a(iVar, "nfcIsConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aQ(g gVar, i iVar) {
        if (gVar.f("nfcConnect", 4002, new Bundle())) {
            gVar.a(iVar, "nfcConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aR(g gVar, i iVar) {
        if (gVar.f("nfcTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdu", (String) iVar.pox.get("apdu"));
            Bundle e = gVar.e("nfcTransceive", 4003, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcTransceive:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aS(g gVar, i iVar) {
        if (gVar.f("nfcBatchTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdus", (String) iVar.pox.get("apdus"));
            bundle.putBoolean("breakIfFail", bh.getInt((String) iVar.pox.get("breakIfFail"), 1) == 1);
            Bundle e = gVar.e("nfcBatchTransceive", 4004, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcBatchTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcBatchTransceive:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcBatchTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aT(g gVar, i iVar) {
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetId", 4002, bundle)) {
            bundle = gVar.e("nfcGetId", 4005, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.ID, bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcGetId result : " + bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
                gVar.a(iVar, "nfcGetId:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcGetId:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aU(g gVar, i iVar) {
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetInfo", 4002, bundle)) {
            bundle = gVar.e("nfcGetInfo", 4008, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("info", bundle.getString("info"));
                gVar.a(iVar, "nfcGetInfo:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetInfo callback fail!");
                gVar.a(iVar, "nfcGetInfo:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aV(g gVar, i iVar) {
        int i = 0;
        boolean z = bh.getInt((String) iVar.pox.get("isShowNfcSwitchGuide"), 1) == 1;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(gVar.context);
        if (defaultAdapter == null) {
            gVar.a(iVar, "nfcCheckState:nfc_not_support", null);
        } else {
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xoW, Integer.valueOf(0))).intValue();
            ar.Hg();
            int intValue2 = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xoX, Integer.valueOf(0))).intValue();
            if (intValue == 2 || (intValue == 0 && intValue2 != 1)) {
                i = 1;
            }
            if (i != 0) {
                if (z) {
                    ag.y(new 81(gVar, iVar));
                } else {
                    gVar.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                }
            } else if (defaultAdapter.isEnabled()) {
                gVar.a(iVar, "nfcCheckState:nfc_ok", null);
            } else if (z) {
                ag.y(new 82(gVar, iVar));
            } else {
                gVar.a(iVar, "nfcCheckState:nfc_off", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean al(g gVar, i iVar) {
        if (gVar.context instanceof MMActivity) {
            String str = (String) iVar.pox.get("key");
            int i = bh.getInt((String) iVar.pox.get("procint"), 0);
            int i2 = bh.getInt((String) iVar.pox.get("dataint"), 0);
            Intent intent = new Intent();
            intent.putExtra("encryptKey", str);
            intent.putExtra("procInterval", i);
            intent.putExtra("dataInterval", i2);
            intent.putExtra("exdevice_airkiss_open_type", 1);
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.b(gVar.context, "exdevice", ".ui.ExdeviceConnectWifiUI", intent, 19);
        } else {
            gVar.a(iVar, "configWXDeviceWiFi:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean ao(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doVerifyWCPayPassword JSOAUTH");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("scene", 1);
            intent.putExtra("pay_channel", gVar2.fqJ);
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 20, false);
        }
        return true;
    }

    static /* synthetic */ boolean ap(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView JSOAUTH");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.fCT);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.fqJ);
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "wallet_index", ".ui.WalletSendC2CMsgUI", intent, 18, false);
        }
        return true;
    }

    static /* synthetic */ boolean aq(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doBatchViewCard JSOAUTH");
        String str = (String) iVar.pox.get("card_list");
        String str2 = (String) iVar.pox.get("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", str);
        intent.putExtra("key_template_id", str2);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "card", ".ui.CardViewEntranceUI", intent, 23, false);
        }
        gVar.maM = false;
        return true;
    }

    static /* synthetic */ boolean ar(g gVar, i iVar) {
        Object obj = iVar.pox.get(DownloadSettingTable$Columns.TYPE);
        String obj2 = obj == null ? "0" : obj.toString();
        x.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, type is : %s", new Object[]{obj2});
        String str = (String) iVar.pox.get("src_username");
        if (obj2.equals("0") || obj2.equals("1") || obj2.equals("2")) {
            String str2 = (String) iVar.pox.get("apKey");
            x.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, ap key is : %s", new Object[]{str2});
            String str3 = bh.ov(str2) ? "" : str2;
            if (obj2.equals("0") && bh.ov(str3)) {
                gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
            } else {
                ag.y(new 78(gVar, obj2, str3, str, (String) iVar.pox.get("sessionKey")));
                gVar.a(iVar, "connectToFreeWifi:ok", null);
            }
        } else {
            gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
        }
        return true;
    }

    static /* synthetic */ void b(g gVar, int i) {
        if (i == 1) {
            gVar.a(gVar.tHT, "startVoipCall:cancel", null);
        } else if (i == 2) {
            gVar.a(gVar.tHT, "startVoipCall:hangup", null);
        } else if (i == 3) {
            gVar.a(gVar.tHT, "startVoipCall:network error", null);
        } else if (i == 4) {
            gVar.a(gVar.tHT, "startVoipCall:param not match", null);
        } else {
            gVar.a(gVar.tHT, "startVoipCall:unknow", null);
        }
    }

    static /* synthetic */ boolean b(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.pox.get("username");
        gVar.PH((String) iVar.pox.get("scene"));
        return gVar.PK(str);
    }

    static /* synthetic */ boolean b(g gVar, i iVar, boolean z) {
        x.i("MicroMsg.MsgHandler", "openDesignerProfile");
        String str = (String) iVar.pox.get("designerId");
        x.d("MicroMsg.MsgHandler", "cpan emoji openDesignerProfile:%d", new Object[]{Long.valueOf(bh.getLong((String) iVar.pox.get("searchID"), 0))});
        if (bh.ov(str)) {
            x.w("MicroMsg.MsgHandler", "openDesignerProfile failed designer id is null.");
            gVar.a(iVar, "openDesignerProfile", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, str);
        intent.putExtra("extra_scence", 12);
        intent.putExtra("searchID", r4);
        com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
        gVar.a(iVar, "openDesignerProfile", null);
        if (z) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13055, new Object[]{Integer.valueOf(3), "", str, "", Integer.valueOf(com.tencent.mm.ak.a.Nj()), Long.valueOf(r4)});
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean bA(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.fts.e bRy = com.tencent.mm.plugin.webview.modeltools.f.bRy();
        Map map = iVar.pox;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "clickSnsMusicPlayButton %s", new Object[]{map.toString()});
        boolean t = com.tencent.mm.plugin.webview.fts.f.t(map, "isLoop");
        boolean t2 = com.tencent.mm.plugin.webview.fts.f.t(map, "needStartMusicUI");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "snsid");
        int o = bh.o(map.get("webview_instance_id"), -1);
        if (com.tencent.mm.av.b.Qq()) {
            asv Qs = com.tencent.mm.av.b.Qs();
            if (Qs.wAi == 9 && Qs.vVZ.equals(r)) {
                com.tencent.mm.av.b.Qo();
            }
        }
        if (t2 && bRy.tmp != null) {
            ag.y(new 9(bRy.tmp, true));
        }
        bnp mG = ((m) com.tencent.mm.kernel.g.h(m.class)).mG(com.tencent.mm.plugin.webview.fts.f.r(map, "objectXmlDesc"));
        com.tencent.mm.av.a.a aVar = (com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class);
        ar.Hg();
        asv a = aVar.a(com.tencent.mm.z.c.FC(), mG, 9);
        a.wAA = t;
        com.tencent.mm.av.b.a(a);
        if (t2) {
            Intent intent = new Intent();
            intent.putExtra("key_scene", 4);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bm.d.b(ac.getContext(), "music", ".ui.MusicMainUI", intent);
        }
        bRy.tmi.add(Integer.valueOf(o));
        return false;
    }

    static /* synthetic */ boolean bJ(g gVar, i iVar) {
        gVar.maM = false;
        String str = (String) iVar.pox.get("brandUsername");
        Intent QM = com.tencent.mm.bc.b.QM();
        QM.putExtra("ftsneedkeyboard", true);
        QM.putExtra("ftsbizscene", 19);
        QM.putExtra("ftsType", 2);
        Map b = com.tencent.mm.bc.b.b(19, true, 2);
        b.put("userName", str);
        QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(b));
        QM.putExtra("key_load_js_without_delay", true);
        QM.putExtra("ftsbizusername", str);
        com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM);
        return false;
    }

    static /* synthetic */ boolean bN(g gVar, i iVar) {
        String str = (String) iVar.pox.get("cardType");
        if (bh.ov(str) || gVar.context == null) {
            gVar.a(iVar, "scanLicence:fail", null);
        } else {
            if (!gVar.tHE.a(str, gVar.context, new 28(gVar, str, iVar))) {
                Map hashMap = new HashMap(1);
                hashMap.put("cardType", str);
                gVar.a(iVar, "scanLicence:type not supported", hashMap);
            }
        }
        return true;
    }

    static /* synthetic */ boolean bP(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do ecard jsapi check");
        com.tencent.mm.sdk.b.b clVar = new cl();
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        clVar.fqB.appId = gVar2.appId;
        clVar.fqB.fqD = gVar2.timeStamp;
        clVar.fqB.nonceStr = gVar2.nonceStr;
        clVar.fqB.packageExt = gVar2.packageExt;
        clVar.fqB.signature = gVar2.fCT;
        clVar.fqB.signType = gVar2.signType;
        clVar.fqB.fqE = gVar2.url;
        clVar.fqB.fqF = (String) iVar.pox.get("ecardType");
        clVar.fqB.fqG = (String) iVar.pox.get("openScene");
        clVar.fqB.fqH = new WeakReference(gVar.context);
        clVar.fqB.token = (String) iVar.pox.get("token");
        clVar.fqB.fqI = new 31(gVar, clVar, iVar);
        clVar.fqB.fqJ = gVar2.fqJ;
        com.tencent.mm.sdk.b.a.xef.m(clVar);
        return true;
    }

    static /* synthetic */ boolean bc(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.fts.c bRz = com.tencent.mm.plugin.webview.modeltools.f.bRz();
        Map map = iVar.pox;
        int o = bh.o(map.get("webview_instance_id"), -1);
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(map, "poiId");
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bff = new bff();
        com_tencent_mm_protocal_c_bff.wKo = r2;
        com_tencent_mm_protocal_c_bff.vPs = r;
        aVar.hmj = com_tencent_mm_protocal_c_bff;
        aVar.hmk = new bfg();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchpoi";
        aVar.hmi = 2608;
        u.a(aVar.JZ(), new 1(bRz, o, r, r2));
        return false;
    }

    static /* synthetic */ boolean bo(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.modeltools.f.bRy();
        Map map = iVar.pox;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics: %s", new Object[]{map.toString()});
        int c = com.tencent.mm.plugin.webview.fts.f.c(map, "logId", 0);
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics reporting %d, logString %s", new Object[]{Integer.valueOf(c), com.tencent.mm.plugin.webview.fts.f.r(map, "logString")});
        com.tencent.mm.bc.g.t(c, r0);
        return false;
    }

    static /* synthetic */ boolean bq(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.fts.e bRy = com.tencent.mm.plugin.webview.modeltools.f.bRy();
        Map map = iVar.pox;
        boolean t = com.tencent.mm.plugin.webview.fts.f.t(map, "hasResult");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "query");
        int c = com.tencent.mm.plugin.webview.fts.f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.fts.f.c(map, "scene", 0);
        x.d("MicroMsg.FTS.FTSWebViewLogic", "searchDataHashResult %b %s %d", new Object[]{Boolean.valueOf(t), r, Integer.valueOf(c)});
        com.tencent.mm.plugin.webview.fts.e.e eVar = bRy.tmo;
        if (eVar.scene == c2 && eVar.fDj != null && eVar.fDj.equals(r) && eVar.mPx == c) {
            eVar.foh = t;
        } else {
            x.w("MicroMsg.FTS.FTSWebViewLogic", "setHahResultNotSame: %s VS %s | %d VS %d | %d VS %d", new Object[]{eVar.fDj, r, Integer.valueOf(eVar.mPx), Integer.valueOf(c), Integer.valueOf(eVar.scene), Integer.valueOf(c2)});
        }
        return false;
    }

    static /* synthetic */ boolean bs(g gVar, i iVar) {
        boolean z = true;
        gVar.maM = false;
        com.tencent.mm.plugin.webview.modeltools.f.bRy();
        Map map = iVar.pox;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "openEmotionPage %s", new Object[]{map});
        int c = com.tencent.mm.plugin.webview.fts.f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.fts.f.c(map, "scene", 0);
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(map, "activityId");
        String str = "";
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("extra_scence", c2);
        intent.putExtra("extra_type", c);
        intent.putExtra("searchID", r);
        intent.putExtra("docID", com.tencent.mm.plugin.webview.fts.f.r(map, "docID"));
        intent.putExtra("activityId", r2);
        switch (c) {
            case 1:
                intent.putExtra("extra_id", com.tencent.mm.plugin.webview.fts.f.r(map, "productID"));
                intent.putExtra("preceding_scence", 18);
                intent.putExtra("download_entrance_scene", 27);
                intent.putExtra("searchID", bh.getLong(r, 0));
                str = ".ui.EmojiStoreDetailUI";
                break;
            case 2:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.fts.f.r(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.fts.f.r(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.fts.f.r(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.fts.f.r(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.fts.f.r(map, "thumb"));
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.webview.fts.f.r(map, "designerId"));
                intent.putExtra("extra_product_id", com.tencent.mm.plugin.webview.fts.f.r(map, "productID"));
                intent.putExtra("productUrl", com.tencent.mm.plugin.webview.fts.f.r(map, "productUrl"));
                intent.putExtra("extra_product_name", com.tencent.mm.plugin.webview.fts.f.r(map, "productName"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.fts.f.r(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.fts.f.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.fts.f.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 3:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.fts.f.r(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.fts.f.r(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.fts.f.r(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.fts.f.r(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.fts.f.r(map, "thumb"));
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.webview.fts.f.r(map, "designerId"));
                intent.putExtra("name", com.tencent.mm.plugin.webview.fts.f.r(map, "designerName"));
                intent.putExtra("headurl", com.tencent.mm.plugin.webview.fts.f.r(map, "designerThumb"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.fts.f.r(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.fts.f.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.fts.f.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 4:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.fts.f.r(map, "express"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.fts.f.r(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.fts.f.r(map, "thumb"));
                intent.putExtra("extra_article_name", com.tencent.mm.plugin.webview.fts.f.r(map, "sourceTitle"));
                intent.putExtra("extra_article_url", com.tencent.mm.plugin.webview.fts.f.r(map, "articleSource"));
                intent.putExtra("disableAddSticker", com.tencent.mm.plugin.webview.fts.f.c(map, "disableAddSticker", 0) > 0);
                str = "needSavePhotosAlbum";
                if (com.tencent.mm.plugin.webview.fts.f.c(map, "needSavePhotosAlbum", 0) <= 0) {
                    z = false;
                }
                intent.putExtra(str, z);
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.fts.f.r(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.fts.f.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.fts.f.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
        }
        if (!bh.ov(str)) {
            com.tencent.mm.bm.d.b(ac.getContext(), "emoji", str, intent);
        }
        return false;
    }

    static /* synthetic */ boolean bt(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.modeltools.f.bRy();
        return com.tencent.mm.plugin.webview.fts.e.ah(iVar.pox);
    }

    static /* synthetic */ boolean bx(g gVar, i iVar) {
        int i = bh.getInt((String) iVar.pox.get("cmd"), 0);
        String str = (String) iVar.pox.get("param");
        com.tencent.mm.sdk.b.b gqVar = new gq();
        gqVar.fwK.pK = i;
        gqVar.fwK.fwF = str;
        com.tencent.mm.sdk.b.a.xef.m(gqVar);
        Map hashMap = new HashMap();
        hashMap.put("result", gqVar.fwL.fwM);
        gVar.a(iVar, "getGameMessages:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean by(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetWebPayCheckoutCounterRequst start");
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fCT);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("pay_channel", gVar2.fqJ);
        ((MMActivity) gVar.context).jwN = gVar;
        com.tencent.mm.bm.d.a(gVar.context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, 28, false);
        return true;
    }

    static /* synthetic */ boolean bz(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.fts.e bRy = com.tencent.mm.plugin.webview.modeltools.f.bRy();
        Map map = iVar.pox;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "setSnsObjectDescList");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, SlookAirButtonFrequentContactAdapter.DATA);
        boolean t = com.tencent.mm.plugin.webview.fts.f.t(map, "append");
        Runnable aVar = new com.tencent.mm.plugin.webview.fts.e.a(bRy, (byte) 0);
        aVar.data = r;
        aVar.tmA = t;
        com.tencent.mm.sdk.f.e.post(aVar, "append_music_list_task");
        return false;
    }

    static /* synthetic */ boolean c(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGoVideoPlayerUI");
        String str = (String) iVar.pox.get("streamingUrl");
        int i = (int) bh.getDouble((String) iVar.pox.get("streamingVideoTime"), 0.0d);
        String str2 = (String) iVar.pox.get("btnTitle");
        String str3 = (String) iVar.pox.get("jumpUrl");
        String str4 = (String) iVar.pox.get("shareTitle");
        String str5 = (String) iVar.pox.get("shareThumbUrl");
        int i2 = bh.getInt((String) iVar.pox.get("shareBtnHidden"), 0);
        String str6 = (String) iVar.pox.get("reportArgs");
        int i3 = bh.getInt((String) iVar.pox.get("needReportData"), 0);
        Intent intent = new Intent();
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", str);
        intent.putExtra("StreamWording", str2);
        intent.putExtra("StremWebUrl", str3);
        intent.putExtra("KThumUrl", str5);
        intent.putExtra("KMediaId", "fakeid_" + str5.hashCode());
        intent.putExtra("KMediaVideoTime", i);
        intent.putExtra("KMediaTitle", str4);
        intent.putExtra("ShareBtnHidden", i2);
        intent.putExtra("ReportArgs", str6);
        intent.putExtra("NeedReportData", i3);
        com.tencent.mm.bm.d.b(gVar.context, "sns", ".ui.VideoAdPlayerUI", intent);
        gVar.a(iVar, "playStreamingVideo:ok", null);
        return true;
    }

    static /* synthetic */ boolean c(g gVar, i iVar, boolean z) {
        ((MMActivity) gVar.context).jwN = gVar;
        int i = z ? 49 : 48;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", q.FV());
        bundle.putInt("k_server_scene", 2);
        bundle.putBoolean("key_is_need_video", z);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("key_function_name", iVar.tJI);
        bundle.putInt("key_business_type", 1);
        x.v("MicroMsg.MsgHandler", "alvinluo facedetect current url: %s", new Object[]{gVar.aeq()});
        String qE = gVar.qE(qE);
        if (qE == null) {
            qE = (String) iVar.pox.get("appId");
        }
        bundle.putString("k_app_id", qE);
        bundle.putString("request_verify_pre_info", (String) iVar.pox.get("request_verify_pre_info"));
        com.tencent.mm.sdk.b.b nmVar = new nm();
        nmVar.fFA.context = gVar.context;
        nmVar.fFA.fFC = i;
        nmVar.fFA.extras = bundle;
        com.tencent.mm.sdk.b.a.xef.m(nmVar);
        x.i("MicroMsg.MsgHandler", "start face detect event result: %b", new Object[]{Boolean.valueOf(nmVar.fFB.fFD)});
        if (!nmVar.fFB.fFD) {
            ((MMActivity) gVar.context).jwN = null;
            gVar.a(iVar, z ? "requestWxFacePictureVerifyUnionVideo:fail" : "requestWxFacePictureVerify:fail", i.aa(nmVar.fFB.extras));
        }
        return true;
    }

    static /* synthetic */ boolean cB(g gVar, i iVar) {
        String ou = bh.ou((String) iVar.pox.get("toUsername"));
        String ou2 = bh.ou((String) iVar.pox.get("scene"));
        String ou3 = bh.ou((String) iVar.pox.get(DownloadSettingTable$Columns.TYPE));
        String ou4 = bh.ou((String) iVar.pox.get("allowBackCamera"));
        String ou5 = bh.ou((String) iVar.pox.get("showOther"));
        String ou6 = bh.ou((String) iVar.pox.get("avatarUrl"));
        String ou7 = bh.ou((String) iVar.pox.get("context"));
        x.i("MicroMsg.MsgHandler", "doStartVoipCS,toUserName:" + ou + ",scene:" + ou2 + ",type:" + ou3 + ",allowBackCamera:" + ou4 + ",showOther:" + ou5 + ",avatarUrl:" + ou6 + ",voipCSContext:" + ou7);
        String str = (String) iVar.pox.get("appId");
        if (str == null || str.equals("") || ou == null || ou.equals("")) {
            gVar.a(iVar, "startVoipCall:param invalid", null);
        } else {
            gVar.tHT = iVar;
            com.tencent.mm.sdk.b.a.xef.b(gVar.tHU);
            if (ou.equals("testacs")) {
                Intent intent = new Intent();
                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                com.tencent.mm.bm.d.b(ac.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("voipCSBizId", ou);
                intent2.putExtra("voipCSScene", ou2);
                intent2.putExtra("voipCSType", ou3);
                intent2.putExtra("voipCSAppId", str);
                intent2.putExtra("voipCSAllowBackCamera", ou4);
                intent2.putExtra("voipCSShowOther", ou5);
                intent2.putExtra("voipCSAvatarUrl", ou6);
                intent2.putExtra("voipCSContext", ou7);
                com.tencent.mm.bm.d.b(ac.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent2);
            }
        }
        return true;
    }

    static /* synthetic */ boolean cF(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doOpenLuckyMoneyDetailView");
        String str = (String) iVar.pox.get("sendId");
        int parseInt = Integer.parseInt((String) iVar.pox.get("hbKind"));
        if (bh.ov(str)) {
            gVar.a(iVar, "openLuckyMoneyDetailView:fail", null);
        } else {
            x.i("MicroMsg.MsgHandler", "sendId: %s, hbKind: %s", new Object[]{str, Integer.valueOf(parseInt)});
            Intent intent = new Intent();
            intent.putExtra("key_sendid", str);
            intent.putExtra("key_jump_from", 4);
            if (parseInt == 2) {
                com.tencent.mm.bm.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
            } else {
                com.tencent.mm.bm.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            }
            gVar.a(iVar, "openLuckyMoneyDetailView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cG(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doResendRemittanceMsg");
        String str = (String) iVar.pox.get("transactionId");
        String str2 = (String) iVar.pox.get("receiverName");
        if (bh.ov(str) || bh.ov(str2)) {
            gVar.a(iVar, "doResendRemittanceMsg:fail", null);
        } else {
            h.a(gVar.context, R.l.eQg, R.l.dGt, R.l.eQh, R.l.dEn, new 30(gVar, str, str2, iVar), new 41(gVar));
        }
        return true;
    }

    static /* synthetic */ boolean cJ(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doPreviewVideo(), localId:%s", new Object[]{(String) iVar.pox.get("localId")});
        WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(r0);
        if (Oo == null) {
            x.e("MicroMsg.MsgHandler", "the item is null");
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (TextUtils.isEmpty(Oo.iLu)) {
            x.e("MicroMsg.MsgHandler", "the File item not exist for localId:%s", new Object[]{Oo.fus});
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (new File(Oo.iLu).exists()) {
            Intent intent = new Intent();
            intent.putExtra("key_video_path", Oo.iLu);
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).jwN = gVar;
                com.tencent.mm.bm.d.b(gVar.context, "card", ".ui.CardGiftVideoUI", intent, 46);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "the File not exist for origFilePath:%s", new Object[]{Oo.iLu});
            gVar.a(iVar, "previewVideo:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean cP(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "getLocalWePkgInfo call");
        ag.y(new 25(gVar, iVar));
        return true;
    }

    static /* synthetic */ boolean cQ(g gVar, i iVar) {
        boolean z = false;
        String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openGameWebView:fail_invalid_url", null);
        } else {
            int i;
            boolean z2;
            String ou;
            Intent intent;
            com.tencent.mm.sdk.b.b gnVar;
            String ou2 = bh.ou((String) iVar.pox.get("orientation"));
            if (!bh.ov(ou2)) {
                if (ou2.equals("horizontal")) {
                    i = 0;
                } else if (ou2.equals("vertical")) {
                    i = 1;
                } else if (ou2.equals("sensor")) {
                    i = 4;
                }
                z2 = bh.ou((String) iVar.pox.get("fullscreen")).equals("true");
                if (bh.ou((String) iVar.pox.get("disable_swipe_back")).equals("1")) {
                    z = true;
                }
                ou = bh.ou((String) iVar.pox.get("gameAppid"));
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_scene", 32);
                intent.putExtra("KPublisherId", "game_webview");
                intent.putExtra("screen_orientation", i);
                intent.putExtra("show_full_screen", z2);
                intent.putExtra("disable_swipe_back", z);
                intent.putExtra("game_hv_menu_appid", ou);
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.fBH, new 26(gVar, intent));
                gnVar = new gn();
                gnVar.fwD.pK = 2;
                gnVar.fwD.fwF = ou;
                com.tencent.mm.sdk.b.a.xef.m(gnVar);
                gVar.a(iVar, "openGameWebView:ok", null);
            }
            i = -1;
            if (bh.ou((String) iVar.pox.get("fullscreen")).equals("true")) {
            }
            if (bh.ou((String) iVar.pox.get("disable_swipe_back")).equals("1")) {
                z = true;
            }
            ou = bh.ou((String) iVar.pox.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", "game_webview");
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z2);
            intent.putExtra("disable_swipe_back", z);
            intent.putExtra("game_hv_menu_appid", ou);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.fBH, new 26(gVar, intent));
            gnVar = new gn();
            gnVar.fwD.pK = 2;
            gnVar.fwD.fwF = ou;
            com.tencent.mm.sdk.b.a.xef.m(gnVar);
            gVar.a(iVar, "openGameWebView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cS(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doLoginOrAuthorize!");
        Runnable 115 = new 115(gVar, iVar);
        if (tHZ) {
            tHY.add(115);
            x.i("MicroMsg.MsgHandler", "add to authJsApiQueue!");
        } else {
            tHZ = true;
            115.run();
        }
        return true;
    }

    static /* synthetic */ boolean cT(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: start do check is support face detect");
        com.tencent.mm.sdk.b.b hkVar = new hk();
        com.tencent.mm.sdk.b.a.xef.m(hkVar);
        boolean z = hkVar.fxI.fxJ;
        int i = hkVar.fxI.fxK;
        x.i("MicroMsg.MsgHandler", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), hkVar.fxI.fxL, Integer.valueOf(hkVar.fxI.fxM)});
        Map hashMap = new HashMap();
        hashMap.put("err_code", String.valueOf(i));
        hashMap.put("err_msg", r3);
        hashMap.put("lib_version_code", String.valueOf(r0));
        gVar.a(iVar, "doCheckIsSupportFaceDetect: ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean cX(g gVar, i iVar) {
        String ou = bh.ou((String) iVar.pox.get("base64DataString"));
        String ou2 = bh.ou((String) iVar.pox.get("thumbUrl"));
        String ou3 = bh.ou((String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        String ou4 = bh.ou((String) iVar.pox.get("activityId"));
        if (!bh.ov(ou)) {
            ar.Dm().F(new 97(gVar, ou, iVar, ou2, ou4));
        } else if (bh.ov(ou3)) {
            x.e("MicroMsg.MsgHandler", "doAddToEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "addToEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            x.i("MicroMsg.MsgHandler", "doAddToEmoticon use url:%s", new Object[]{ou3});
            File file = new File(gVar.context.getCacheDir(), com.tencent.mm.a.g.s(ou3.getBytes()));
            if (file.exists()) {
                ar.Dm().F(new 98(gVar, file, ou2, ou4));
            } else {
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                com_tencent_mm_aq_a_a_c_a.hDA = true;
                com_tencent_mm_aq_a_a_c_a.hDC = file.getAbsolutePath();
                com_tencent_mm_aq_a_a_c_a.hEd = new Object[]{file.getAbsolutePath()};
                com.tencent.mm.plugin.emoji.model.i.aBe().a(ou3, null, com_tencent_mm_aq_a_a_c_a.PK(), new 99(gVar, ou3, ou2, ou4, iVar));
            }
        }
        return true;
    }

    static /* synthetic */ boolean cY(g gVar, i iVar) {
        String ou = bh.ou((String) iVar.pox.get("base64DataString"));
        String ou2 = bh.ou((String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        String ou3 = bh.ou((String) iVar.pox.get("activityId"));
        if (!bh.ov(ou)) {
            ar.Dm().F(new 100(gVar, ou, iVar, ou3));
        } else if (bh.ov(ou2)) {
            x.e("MicroMsg.MsgHandler", "doShareEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "shareEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            x.i("MicroMsg.MsgHandler", "doShareEmoticon use url:%s", new Object[]{ou2});
            File file = new File(gVar.context.getCacheDir(), com.tencent.mm.a.g.s(ou2.getBytes()));
            if (file.exists()) {
                ar.Dm().F(new 101(gVar, file, ou3));
            } else {
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                com_tencent_mm_aq_a_a_c_a.hDA = true;
                com_tencent_mm_aq_a_a_c_a.hDC = file.getAbsolutePath();
                com_tencent_mm_aq_a_a_c_a.hEd = new Object[]{file.getAbsolutePath()};
                com.tencent.mm.plugin.emoji.model.i.aBe().a(ou2, null, com_tencent_mm_aq_a_a_c_a.PK(), new 102(gVar, ou2, ou3, iVar));
            }
        }
        return true;
    }

    static /* synthetic */ boolean cZ(g gVar, i iVar) {
        ((MMActivity) gVar.context).jwN = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 3);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.pox.get("request_ticket"));
        com.tencent.mm.sdk.b.b nmVar = new nm();
        nmVar.fFA.context = gVar.context;
        nmVar.fFA.fFC = 50;
        nmVar.fFA.extras = bundle;
        com.tencent.mm.sdk.b.a.xef.m(nmVar);
        x.i("MicroMsg.MsgHandler", "hy: start face register rsa event result: %b", new Object[]{Boolean.valueOf(nmVar.fFB.fFD)});
        if (!nmVar.fFB.fFD) {
            ((MMActivity) gVar.context).jwN = null;
            gVar.a(iVar, "requestWxFaceRegisterInternal:fail", i.aa(nmVar.fFB.extras));
        }
        return true;
    }

    static /* synthetic */ boolean ca(g gVar, i iVar) {
        String str = (String) iVar.pox.get("username");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "user name is null or nil");
            gVar.a(iVar, "add_contact:fail", null);
            return false;
        }
        String str2 = (String) iVar.pox.get("profileReportInfo");
        x.i("MicroMsg.MsgHandler", "get scene = %s", new Object[]{(String) iVar.pox.get("scene")});
        final com.tencent.mm.pluginsdk.ui.applet.b bVar = new com.tencent.mm.pluginsdk.ui.applet.b(gVar.context, str, bh.getInt(r0, 91), new 92(gVar, iVar), false, str2);
        ag.y(new Runnable(gVar) {
            final /* synthetic */ g tIj;

            public final void run() {
                bVar.show();
            }
        });
        return true;
    }

    static /* synthetic */ boolean cb(g gVar, i iVar) {
        String str = (String) iVar.pox.get("consumedCardId");
        String str2 = (String) iVar.pox.get("consumedCode");
        x.i("MicroMsg.MsgHandler", "doConsumedShareCard consumedCardId is " + str);
        if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.MsgHandler", "doConsumedShareCard failed, illegal params (id : %s, code : %s)", new Object[]{str, str2});
            gVar.a(iVar, "consumedShareCard:fail", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("key_consumed_card_id", str);
        intent.putExtra("key_consumed_Code", str2);
        ((MMActivity) gVar.context).jwN = gVar;
        com.tencent.mm.bm.d.b(gVar.context, "card", ".sharecard.ui.CardConsumeSuccessUI", intent, 29);
        return true;
    }

    static /* synthetic */ boolean cc(g gVar, i iVar) {
        String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str2 = (String) iVar.pox.get("open_game_webview");
        x.i("MicroMsg.MsgHandler", "open url with extra webview, url = %s", new Object[]{str});
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openUrlWithExtraWebview:fail_invalid_url", null);
        } else {
            final Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("convertActivityFromTranslucent", false);
            if (bh.ou(str2).equals("1")) {
                com.tencent.mm.sdk.b.b kjVar = new kj();
                kjVar.fBG.type = 0;
                kjVar.fBG.context = gVar.context;
                kjVar.fBG.intent = intent;
                kjVar.fBG.fBH = gVar.fBH;
                com.tencent.mm.sdk.b.a.xef.m(kjVar);
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", gVar.fBH, new Runnable(gVar) {
                    final /* synthetic */ g tIj;

                    public final void run() {
                        com.tencent.mm.bm.d.b(this.tIj.context, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
            gVar.a(iVar, "openUrlWithExtraWebview:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean ch(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doSelectSingleContact selectedMode:%d", new Object[]{Integer.valueOf(bh.getInt((String) iVar.pox.get("selectMode"), 0))});
        Intent intent = new Intent();
        if (bh.getInt((String) iVar.pox.get("selectMode"), 0) == 1) {
            intent.putExtra("Select_Conv_Type", 263);
            intent.putExtra("jsapi_select_mode", 1);
        } else {
            intent.putExtra("Select_Conv_Type", 259);
        }
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", q.FS());
        intent.putExtra("scene_from", 4);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bm.d.a((MMActivity) gVar.context, ".ui.transmit.SelectConversationUI", intent, 30, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean cm(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "openEmoticonTopicList");
        int i = bh.getInt((String) iVar.pox.get("tid"), 0);
        String str = (String) iVar.pox.get("title");
        String str2 = (String) iVar.pox.get("desc");
        String str3 = (String) iVar.pox.get("iconUrl");
        String str4 = (String) iVar.pox.get("secondUrl");
        Intent intent = new Intent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_desc", str2);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("extra_scence", 12);
        com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.EmojiStoreTopicUI", intent);
        gVar.a(iVar, "openEmoticonTopicList", null);
        return true;
    }

    static /* synthetic */ boolean cn(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "openEmotionDetailView");
        String str = (String) iVar.pox.get("ProductId");
        x.d("MicroMsg.MsgHandler", "cpan emoji openEmotionDetailView:%d", new Object[]{Long.valueOf(bh.getLong((String) iVar.pox.get("searchID"), 0))});
        if (bh.ov(str)) {
            x.w("MicroMsg.MsgHandler", "openEmotionDetailView failed product id is null.");
            gVar.a(iVar, "openEmotionDetailView", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("preceding_scence", 12);
        intent.putExtra("download_entrance_scene", 12);
        intent.putExtra("searchID", r4);
        if (gVar.tHC) {
            x.i("MicroMsg.MsgHandler", "had start emoji stroe detail ui.");
        } else {
            com.tencent.mm.bm.d.b(gVar.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            gVar.tHC = true;
        }
        gVar.a(iVar, "openEmotionDetailView", null);
        com.tencent.mm.plugin.report.service.g.pQN.h(13055, new Object[]{Integer.valueOf(0), str, "", "", Integer.valueOf(com.tencent.mm.ak.a.Nj()), Long.valueOf(r4)});
        return true;
    }

    static /* synthetic */ boolean co(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.modeltools.f.bRw();
        Map map = iVar.pox;
        String Nh = com.tencent.mm.ak.a.Nh();
        if (bh.ov(Nh)) {
            x.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
            return false;
        }
        int s = com.tencent.mm.plugin.webview.c.a.s(map, DownloadSettingTable$Columns.TYPE);
        String r = com.tencent.mm.plugin.webview.c.a.r(map, "pageName");
        String r2 = com.tencent.mm.plugin.webview.c.a.r(map, "keyword");
        int s2 = com.tencent.mm.plugin.webview.c.a.s(map, "scene");
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("rawUrl", "file://" + Nh + "/" + r + "?type=" + s + "&keyword=" + r2 + "&scene=" + s2 + "&lang=" + com.tencent.mm.sdk.platformtools.w.eL(ac.getContext()) + "&clientType=1&version=" + com.tencent.mm.ak.a.Nj());
        intent.putExtra("keyword", r2);
        intent.putExtra(DownloadSettingTable$Columns.TYPE, s);
        intent.putExtra("sence", s2);
        com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.pQN.h(13055, new Object[]{Integer.valueOf(1), "", "", Integer.valueOf(s), Integer.valueOf(com.tencent.mm.ak.a.Nj()), Long.valueOf(0)});
        com.tencent.mm.sdk.b.b lvVar = new lv();
        lvVar.fDi.type = s;
        lvVar.fDi.fDj = r2;
        lvVar.fDi.fDk = "";
        com.tencent.mm.sdk.b.a.xef.m(lvVar);
        return true;
    }

    static /* synthetic */ boolean cq(g gVar, i iVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.modeltools.f.bRw();
        String r = com.tencent.mm.plugin.webview.c.a.r(iVar.pox, "urlString");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", r);
        com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return false;
    }

    static /* synthetic */ boolean cu(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: start soter auth");
        ((MMActivity) gVar.context).jwN = gVar;
        Bundle ap = i.ap(iVar.pox);
        Intent intent = new Intent();
        intent.putExtras(ap);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        String qE = gVar.qE(gVar.aeq());
        if (qE == null) {
            qE = (String) iVar.pox.get("appId");
        }
        intent.putExtra("key_app_id", qE);
        com.tencent.mm.bm.d.b(gVar.context, "soter_mp", ".ui.SoterAuthenticationUI", intent, 38);
        return true;
    }

    static /* synthetic */ boolean cv(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: do get soter support");
        com.tencent.mm.sdk.b.b hlVar = new hl();
        com.tencent.mm.sdk.b.a.xef.m(hlVar);
        Map hashMap = new HashMap();
        hashMap.put("support_mode", Integer.valueOf(hlVar.fxN.fxO));
        gVar.a(iVar, "getSupportSoter", hashMap);
        gVar.a(iVar, 0, hlVar.fxN.fxO == 1 ? 1 : 0);
        return true;
    }

    static /* synthetic */ boolean cw(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        String str = (String) iVar.pox.get("appId");
        if (gVar.tHs != null) {
            if (TextUtils.isEmpty(str)) {
                str = gVar.tHs.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str)) {
                str = gVar.tHB.PB(gVar.aeq());
            }
        }
        intent.putExtra("appId", str);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fCT);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.aeq());
        ((MMActivity) gVar.context).jwN = gVar;
        com.tencent.mm.bm.d.a(gVar.context, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", intent, 39, false);
        return true;
    }

    static /* synthetic */ boolean cy(g gVar, i iVar) {
        gVar.maM = false;
        String obj = iVar.pox.get("chat_username").toString();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", obj);
        intent.putExtra("finish_direct", true);
        intent.putExtra("expose_edit_mode", true);
        intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bm.d.a((MMActivity) gVar.context, ".ui.chatting.ChattingUI", intent, 40, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean d(g gVar, i iVar) {
        int i = 33;
        String str = (String) iVar.pox.get("webtype");
        String str2 = (String) iVar.pox.get("username");
        String str3 = (String) iVar.pox.get("scene");
        String str4 = (String) iVar.pox.get("profileReportInfo");
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            gVar.PH(str3);
            int i2 = bh.getInt(str, -1);
            if (i2 != -1) {
                k.a(iVar.tJH, false, str2, null);
                switch (i2) {
                    case 1:
                        if (gVar.tHs != null) {
                            i = gVar.tHs.getInt("Contact_Scene", 33);
                        }
                        new com.tencent.mm.pluginsdk.ui.applet.b(gVar.context, str2, i, new 27(gVar, iVar), str4).show();
                        break;
                    default:
                        x.e("MicroMsg.MsgHandler", "unknown addScene = " + i2);
                        gVar.a(iVar, "add_contact:fail", null);
                        break;
                }
            }
            x.e("MicroMsg.MsgHandler", "doAddContact fail, parseInt fail, str = " + str);
            gVar.a(iVar, "add_contact:fail", null);
        } else {
            x.e("MicroMsg.MsgHandler", "doAddContact fail, invalid arguments, webType = " + str + ", username = " + str2);
            gVar.a(iVar, "add_contact:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean d(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.pox.get("appid");
        String str2 = (String) iVar.pox.get("extInfo");
        String str3 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str4 = (String) iVar.pox.get("task_url");
        if (!an.isNetworkConnected(gVar.context)) {
            Toast.makeText(gVar.context, gVar.context.getString(R.l.emh), 0).show();
            gVar.a(iVar, "doResumeDownloadTask:fail_network_not_connected", null);
            x.i("MicroMsg.MsgHandler", "doResumeDownloadTask fail, network not ready");
            u(str, com.tencent.mm.plugin.downloader.model.d.lsa, str2);
        } else if (an.isWifi(gVar.context)) {
            gVar.x(iVar);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(14217, new Object[]{str, Integer.valueOf(4), str3, str4, Integer.valueOf(3)});
            Context context = gVar.context;
            String string = gVar.context.getString(R.l.eWB);
            String string2 = gVar.context.getString(R.l.eWC);
            String string3 = gVar.context.getString(R.l.eWw);
            String string4 = gVar.context.getString(R.l.dEn);
            43 43 = new 43(gVar, str, str3, str4, iVar, jsapiPermissionWrapper);
            h.a(context, string, string2, string3, string4, false, (OnClickListener) 43, (OnClickListener) new 44(gVar, str, str3, str4, iVar), R.e.bui);
        }
        return true;
    }

    static /* synthetic */ boolean dC(g gVar, i iVar) {
        gVar.maM = false;
        if ("1".equals(iVar.pox.get("isDeleteAll"))) {
            com.tencent.mm.plugin.webview.modeltools.f.bRy();
            ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).deleteSOSHistory();
        } else {
            com.tencent.mm.plugin.webview.modeltools.f.bRy();
            ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).deleteSOSHistory((String) iVar.pox.get("query"));
        }
        return false;
    }

    static /* synthetic */ boolean dF(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do open offline pay view");
        ((MMActivity) gVar.context).jwN = gVar;
        Context context = gVar.context;
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fCT);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("key_from_scene", 6);
        intent.putExtra("pay_channel", gVar2.fqJ);
        com.tencent.mm.bm.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent, 60);
        return true;
    }

    static /* synthetic */ boolean dG(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fCT);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("pay_channel", gVar2.fqJ);
        intent.putExtra("intent_jump_package", "wallet");
        x.i("MicroMsg.MsgHandler", "appid %s timeStamp %s nonceStr %s packageExt %s signType %s", new Object[]{bh.az((String) iVar.pox.get("appid"), ""), gVar2.timeStamp, gVar2.nonceStr, gVar2.packageExt, gVar2.signType});
        intent.putExtra("intent_jump_ui", ".bind.ui.WalletBankcardManageUI");
        ((MMActivity) gVar.context).jwN = gVar;
        com.tencent.mm.bm.d.b(gVar.context, "wallet", ".ui.WalletJsApiAdapterUI", intent, 59);
        return true;
    }

    static /* synthetic */ void dN(g gVar, i iVar) {
        if (gVar.context == null) {
            gVar.a(iVar, "chooseIdCard:fail", null);
            return;
        }
        if (!gVar.tHE.a("identity_pay_auth", gVar.context, new 112(gVar, iVar))) {
            gVar.a(iVar, "chooseIdCard:fail", null);
        }
    }

    static /* synthetic */ void dO(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "real scene = %d", new Object[]{Integer.valueOf(3)});
        x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", ""))});
        if (com.tencent.mm.pluginsdk.g.a.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_capture", 3);
            intent.putExtra("key_pick_local_pic_query_source_type", 8);
            intent.putExtra("query_media_type", 1);
            intent.putExtra("key_pick_local_pic_count", 1);
            x.i("MicroMsg.MsgHandler", "doChooseImageIdCard: realScene: %d, querySourceType: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).jwN = gVar;
                com.tencent.mm.bm.d.a(gVar.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 43, false);
                return;
            }
            return;
        }
        gVar.a(iVar, "chooseIdCard:fail", null);
    }

    static /* synthetic */ boolean da(g gVar, i iVar) {
        ((MMActivity) gVar.context).jwN = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", aq.hfP.H("login_user_name", ""));
        bundle.putInt("k_server_scene", 4);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.pox.get("request_ticket"));
        com.tencent.mm.sdk.b.b nmVar = new nm();
        nmVar.fFA.context = gVar.context;
        nmVar.fFA.fFC = 51;
        nmVar.fFA.extras = bundle;
        com.tencent.mm.sdk.b.a.xef.m(nmVar);
        x.i("MicroMsg.MsgHandler", "hy: start face verify rsa event result: %b", new Object[]{Boolean.valueOf(nmVar.fFB.fFD)});
        if (!nmVar.fFB.fFD) {
            ((MMActivity) gVar.context).jwN = null;
            gVar.a(iVar, "requestWxFaceVerifyInternal:fail", i.aa(nmVar.fFB.extras));
        }
        return true;
    }

    static /* synthetic */ boolean dc(g gVar, i iVar) {
        gVar.maM = false;
        String str = (String) iVar.pox.get("selected_user_name");
        Intent intent = new Intent();
        intent.putExtra("list_type", 15);
        intent.putExtra("already_select_contact", str);
        intent.putExtra("titile", gVar.context.getString(R.l.dDo));
        intent.putExtra("list_attr", s.p(new int[]{16384, 1, 4, 1048576}));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bm.d.a((MMActivity) gVar.context, ".ui.contact.SelectContactUI", intent, 54, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean dd(g gVar, i iVar) {
        gVar.maM = false;
        String str = (String) iVar.pox.get("phoneNumber");
        x.d("MicroMsg.MsgHandler", "jsapi makePhoneCall num %s", new Object[]{str});
        if (TextUtils.isEmpty(str)) {
            gVar.a(iVar, "makePhoneCall:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bh.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
            gVar.a(iVar, "makePhoneCall:succ", null);
        }
        return true;
    }

    static /* synthetic */ boolean de(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        intent.putExtra("appId", bh.az((String) iVar.pox.get("appid"), ""));
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.fCT);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar2.url);
        intent.putExtra("reset_pwd_token", gVar2.vzK);
        intent.putExtra("pay_channel", gVar2.fqJ);
        ((MMActivity) gVar.context).jwN = gVar;
        com.tencent.mm.bm.d.b(gVar.context, "wallet", ".pwd.ui.WalletResetPwdAdapterUI", intent, 55);
        return true;
    }

    static /* synthetic */ boolean df(g gVar, i iVar) {
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        x.i("MicroMsg.MsgHandler", "doChooseInvoiceTitle");
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "address", ".ui.InvoiceListUI", intent, 56, false);
        }
        return true;
    }

    static /* synthetic */ boolean do(g gVar, i iVar) {
        gVar.maM = false;
        Map hashMap = new HashMap();
        hashMap.put("query", com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "query"));
        hashMap.put("scene", Integer.valueOf(33));
        if (iVar.pox.containsKey(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
            com.tencent.mm.plugin.webview.modeltools.f.bRz().tlO = new bzr();
            com.tencent.mm.plugin.webview.modeltools.f.bRz().tlO.wZo = new ii();
            com.tencent.mm.plugin.webview.modeltools.f.bRz().tlO.wZo.vOC = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, SlookSmartClipMetaTag.TAG_TYPE_URL);
        }
        com.tencent.mm.plugin.webview.modeltools.f.bRy();
        String r = com.tencent.mm.plugin.webview.fts.f.r(hashMap, "query");
        if (!bh.ov(r)) {
            int c = com.tencent.mm.plugin.webview.fts.f.c(hashMap, "scene", 3);
            int c2 = com.tencent.mm.plugin.webview.fts.f.c(hashMap, DownloadSettingTable$Columns.TYPE, 0);
            String zH = com.tencent.mm.plugin.aj.a.g.zH(c);
            Intent QM = com.tencent.mm.bc.b.QM();
            QM.putExtra("ftsbizscene", c);
            QM.putExtra("ftsType", c2);
            QM.putExtra("sessionId", zH);
            QM.putExtra("ftsQuery", r);
            QM.putExtra("ftsInitToSearch", true);
            hashMap = com.tencent.mm.bc.b.b(c, true, 0);
            hashMap.put("query", r);
            hashMap.put("sessionId", zH);
            QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(hashMap));
            com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QM);
        }
        return false;
    }

    static /* synthetic */ boolean dw(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do handle wcpay buffer");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        com.tencent.mm.sdk.b.b sqVar = new sq();
        sqVar.fKu.action = (String) iVar.pox.get("action");
        sqVar.fKu.buffer = (String) iVar.pox.get("buffer");
        sqVar.fKu.fKy = bh.getInt((String) iVar.pox.get("walletRegion"), 0);
        sqVar.fKu.appId = gVar2.appId;
        sqVar.fKu.fqD = gVar2.timeStamp;
        sqVar.fKu.nonceStr = gVar2.nonceStr;
        sqVar.fKu.fKx = gVar2.fCT;
        sqVar.fKu.signType = gVar2.signType;
        sqVar.fKu.fKw = gVar2.packageExt;
        sqVar.fKu.url = gVar2.url;
        sqVar.fKv.fKz = new 29(gVar, sqVar, iVar);
        com.tencent.mm.sdk.b.a.xef.m(sqVar);
        return true;
    }

    static /* synthetic */ void e(g gVar) {
        com.tencent.mm.sdk.b.a.xef.b(gVar.qsg);
        gVar.tHN = (LocationManager) gVar.context.getSystemService("location");
        tHA = gVar.aU(gVar.tHp);
        gVar.tHx = gVar.fBH;
        tHz = gVar.context;
        gVar.tHq = gVar.tHp;
    }

    static /* synthetic */ boolean f(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "jslog : " + iVar.pox.get("msg"));
        gVar.maM = false;
        return false;
    }

    static /* synthetic */ boolean f(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        iVar.pox.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(262144));
        com.tencent.mm.plugin.webview.modeltools.f.bRz().tlO = new bzr();
        com.tencent.mm.plugin.webview.modeltools.f.bRz().tlO.wZo = new ii();
        com.tencent.mm.plugin.webview.modeltools.f.bRz().tlO.wZo.vOz = 1;
        return gVar.aV(iVar);
    }

    static /* synthetic */ boolean g(g gVar) {
        gVar.maM = false;
        com.tencent.mm.plugin.webview.fts.e bRy = com.tencent.mm.plugin.webview.modeltools.f.bRy();
        x.i("MicroMsg.FTS.FTSWebViewLogic", "getSearchHistory count %d, webviewId %d", new Object[]{Integer.valueOf(20), Integer.valueOf(gVar.fDl)});
        com.tencent.mm.plugin.fts.a.a.g fVar = new com.tencent.mm.plugin.webview.fts.e.f(bRy, (byte) 0);
        fVar.fDj = "";
        fVar.mLW = 20;
        fVar.mLZ = bRy.tmj;
        fVar.tmK = r1;
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).search(8, fVar);
        return false;
    }

    static /* synthetic */ boolean g(g gVar, i iVar) {
        if (an.isConnected(gVar.context)) {
            x.i("MicroMsg.MsgHandler", "getNetworkType, type = " + an.getNetType(gVar.context));
            Map hashMap = new HashMap();
            if (an.is2G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (an.is3G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (an.is4G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (an.isWifi(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, wifi");
                gVar.a(iVar, "network_type:wifi", null);
            } else {
                x.w("MicroMsg.MsgHandler", "getNetworkType, unknown");
                gVar.a(iVar, "network_type:fail", null);
            }
        } else {
            x.i("MicroMsg.MsgHandler", "getNetworkType, not connected");
            gVar.a(iVar, "network_type:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean h(g gVar) {
        if (gVar.context != null && (gVar.context instanceof MMActivity)) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.c(gVar.context, "setting", ".ui.setting.SettingsModifyEmailAddrUI", 58);
        }
        return true;
    }

    static /* synthetic */ boolean h(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.pox.get("appid");
        String str2 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str3 = (String) iVar.pox.get("extInfo");
        String str4 = (String) iVar.pox.get("task_url");
        if (!an.isNetworkConnected(gVar.context)) {
            Toast.makeText(gVar.context, gVar.context.getString(R.l.emh), 0).show();
            gVar.a(iVar, "add_download_task_straight:fail_network_not_connected", null);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, network not ready");
            u(str, com.tencent.mm.plugin.downloader.model.d.lsa, str3);
        } else if (an.isWifi(gVar.context)) {
            gVar.w(iVar);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(14217, new Object[]{str, Integer.valueOf(4), str2, str4, Integer.valueOf(3)});
            Context context = gVar.context;
            String string = gVar.context.getString(R.l.eWB);
            String string2 = gVar.context.getString(R.l.eWC);
            String string3 = gVar.context.getString(R.l.eWw);
            String string4 = gVar.context.getString(R.l.dEn);
            36 36 = new 36(gVar, str, str2, str4, iVar, jsapiPermissionWrapper);
            h.a(context, string, string2, string3, string4, false, (OnClickListener) 36, (OnClickListener) new 37(gVar, str, str2, str4, iVar), R.e.bui);
        }
        return true;
    }

    static /* synthetic */ boolean l(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToInstallUrl");
        String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "jumpurl is null or nil");
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bh.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
        }
        gVar.maM = false;
        return false;
    }

    static /* synthetic */ boolean m(g gVar, i iVar) {
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        x.i("MicroMsg.MsgHandler", "doPay");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            gVar2.vzJ = 1;
            x.i("MicroMsg.MsgHandler", "doPay, pay channel: %s, scene: %s", new Object[]{Integer.valueOf(gVar2.fqJ), Integer.valueOf(gVar2.fCV)});
            com.tencent.mm.pluginsdk.wallet.h.a((MMActivity) gVar.context, gVar2, 4, gVar);
            long j = bh.getLong((String) iVar.pox.get("message_id"), 0);
            int i = bh.getInt((String) iVar.pox.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.pQN.h(10593, new Object[]{gVar2.fCU, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.fCV), gVar2.url});
            gVar.tHH = gVar.aU(iVar);
        }
        return true;
    }

    static /* synthetic */ boolean n(g gVar, i iVar) {
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        x.i("MicroMsg.MsgHandler", "doEditAddress");
        Intent intent = new Intent();
        intent.putExtra("req_url", (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        intent.putExtra("req_app_id", (String) iVar.pox.get("appId"));
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "address", ".ui.WalletSelectAddrUI", intent, 3, false);
        }
        return true;
    }

    static /* synthetic */ boolean o(g gVar, i iVar) {
        Map hashMap = new HashMap();
        if (com.tencent.mm.pluginsdk.ui.tools.e.vwY == null) {
            x.w("MicroMsg.MsgHandler", "HeadingPitchSensorMgr.instance == null, init here");
            com.tencent.mm.pluginsdk.ui.tools.e eVar = new com.tencent.mm.pluginsdk.ui.tools.e();
            r.a(eVar);
            com.tencent.mm.pluginsdk.ui.tools.e.vwY = eVar;
            eVar.ep(gVar.context);
            com.tencent.mm.pluginsdk.ui.tools.e.vwY = eVar;
        }
        hashMap.put("heading", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vwY.ccw()));
        hashMap.put("pitch", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vwY.getPitch()));
        x.i("MicroMsg.MsgHandler", "doGetHeadingAndPitch, heading=[%s], pitch=[%s]", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vwY.ccw()), Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.vwY.getPitch())});
        gVar.a(iVar, "get_heading_and_pitch:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean q(g gVar, i iVar) {
        if (bh.cgC()) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, GP Version not allowed to download");
            gVar.a(iVar, "system:access_denied", null);
            return true;
        }
        String str = (String) iVar.pox.get("task_name");
        String str2 = (String) iVar.pox.get("task_url");
        String str3 = (String) iVar.pox.get("alternative_url");
        long j = bh.getLong((String) iVar.pox.get("task_size"), 0);
        String str4 = (String) iVar.pox.get("file_md5");
        String str5 = (String) iVar.pox.get("extInfo");
        String str6 = (String) iVar.pox.get("fileType");
        String str7 = (String) iVar.pox.get("appid");
        String str8 = (String) iVar.pox.get("package_name");
        String str9 = (String) iVar.pox.get("thumb_url");
        String str10 = (String) iVar.pox.get("title");
        x.i("MicroMsg.MsgHandler", "doAddDownloadTask, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6);
        if (gVar.tHs != null) {
            int i = gVar.tHs.getInt("key_download_restrict", 0);
            if (!bh.ov(gVar.tHs.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14596, new Object[]{r15, Integer.valueOf(i), Integer.valueOf(0)});
            }
            if (i == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to download file");
                gVar.a(iVar, "add_download_task:fail", null);
                return true;
            }
        }
        if (an.isNetworkConnected(gVar.context)) {
            ar.Hg();
            if (!com.tencent.mm.z.c.isSDCardAvailable()) {
                gVar.a(iVar, "add_download_task:fail_sdcard_not_ready", null);
                ag.y(new 39(gVar));
                u(str7, com.tencent.mm.plugin.downloader.model.d.lsb, str5);
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, sdcard not ready");
                return true;
            } else if (j > 0 && !com.tencent.mm.compatible.util.f.aC(j)) {
                gVar.a(iVar, "add_download_task:fail_sdcard_has_not_enough_space", null);
                ag.y(new 40(gVar));
                u(str7, com.tencent.mm.plugin.downloader.model.d.lsb, str5);
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, not enough space, require size = " + j);
                return true;
            } else if (bh.ov(str2)) {
                x.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, url is null");
                gVar.a(iVar, "add_download_task:fail_invalid_url", null);
                u(str7, com.tencent.mm.plugin.downloader.model.d.DOWNLOAD_ERR_URL_INVALID, str5);
                return true;
            } else {
                Intent intent = new Intent();
                intent.setClass(gVar.context, WebViewDownloadUI.class);
                intent.putExtra("task_name", str);
                intent.putExtra("task_url", str2);
                intent.putExtra("alternative_url", str3);
                intent.putExtra("task_size", j);
                intent.putExtra("file_md5", str4);
                intent.putExtra("extInfo", str5);
                intent.putExtra("fileType", str6);
                intent.putExtra("appid", str7);
                intent.putExtra("package_name", str8);
                intent.putExtra("thumb_url", str9);
                intent.putExtra("title", str10);
                intent.putExtra("page_url", (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                intent.putExtra("page_scene", 0);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                gVar.context.startActivity(intent);
                gVar.jcH = new 42(gVar, iVar);
                com.tencent.mm.sdk.b.a.xef.a(gVar.jcH);
                return true;
            }
        }
        gVar.a(iVar, "add_download_task:fail_network_not_connected", null);
        ag.y(new 38(gVar));
        x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, network not ready");
        u(str7, com.tencent.mm.plugin.downloader.model.d.lsa, str5);
        return true;
    }

    static /* synthetic */ boolean r(g gVar, i iVar) {
        long j = bh.getLong((String) iVar.pox.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            gVar.a(iVar, "cancel_download_task:fail", null);
        } else {
            int bX = com.tencent.mm.plugin.downloader.model.f.aAd().bX(j);
            x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + bX);
            if (bX <= 0) {
                gVar.a(iVar, "cancel_download_task:fail", null);
            } else {
                gVar.a(iVar, "cancel_download_task:ok", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean s(g gVar, i iVar) {
        long j = bh.getLong((String) iVar.pox.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            gVar.a(iVar, "pause_download_task:fail", null);
        } else {
            boolean bZ = com.tencent.mm.plugin.downloader.model.f.aAd().bZ(j);
            x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + bZ);
            if (bZ) {
                gVar.a(iVar, "pause_download_task:ok", null);
            } else {
                gVar.a(iVar, "pause_download_task:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean t(g gVar, i iVar) {
        long j = bh.getLong((String) iVar.pox.get("download_id"), -1);
        String str = (String) iVar.pox.get("appid");
        String str2 = (String) iVar.pox.get("appIdArray");
        x.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + j + ",appId = " + str + ",appIds = " + str2);
        if (!bh.ov(str2)) {
            return gVar.a(str2, iVar);
        }
        FileDownloadTaskInfo bY;
        if (j > 0) {
            bY = com.tencent.mm.plugin.downloader.model.f.aAd().bY(j);
        } else if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + j + " or appid is null");
            gVar.a(iVar, "query_download_task:fail", null);
            return true;
        } else {
            bY = com.tencent.mm.plugin.downloader.model.f.aAd().xI(str);
        }
        switch (bY.status) {
            case -1:
                x.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
                gVar.a(iVar, "query_download_task:fail_apilevel_too_low", null);
                return true;
            case 1:
                str2 = "downloading";
                break;
            case 2:
                str2 = "download_pause";
                break;
            case 3:
                if (!com.tencent.mm.a.e.bO(bY.path)) {
                    str2 = "default";
                    break;
                }
                str2 = "download_succ";
                break;
            case 4:
                str2 = "download_fail";
                break;
            default:
                str2 = "default";
                break;
        }
        x.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = " + str2);
        Map hashMap = new HashMap();
        hashMap.put("state", str2);
        hashMap.put("download_id", Long.valueOf(bY.id));
        if (str2 == "downloading" && bY.fwg != 0) {
            hashMap.put("progress", Long.valueOf((long) ((((float) bY.fwf) / ((float) bY.fwg)) * 100.0f)));
        }
        gVar.a(iVar, "query_download_task:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean u(g gVar, i iVar) {
        long j = bh.getLong((String) iVar.pox.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doInstallDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid downloadId = " + j);
        } else {
            FileDownloadTaskInfo bY = com.tencent.mm.plugin.downloader.model.f.aAd().bY(j);
            if (bY.status == -1) {
                x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, apilevel not supported");
                gVar.a(iVar, "install_download_task:fail_apilevel_too_low", null);
            } else if (bY.status != 3) {
                x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid status = " + bY.status);
            } else if (com.tencent.mm.a.e.bO(bY.path)) {
                gVar.a(iVar, com.tencent.mm.pluginsdk.model.app.q.e(gVar.context, Uri.fromFile(new File(bY.path))) ? "install_download_task:ok" : "install_download_task:fail", null);
            }
            return true;
        }
        gVar.a(iVar, "install_download_task:fail", null);
        return true;
    }

    static /* synthetic */ boolean v(g gVar, i iVar) {
        String str = (String) iVar.pox.get("specificview");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "doOpenSpecificView fail, invalid specificview");
            gVar.a(iVar, "specific_view:fail", null);
        } else {
            new Intent().addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            Bundle bundle = new Bundle();
            String str2 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            String str3 = (String) iVar.pox.get("extinfo");
            bundle.putInt("webview_scene", bh.getInt((String) iVar.pox.get("webview_scene"), 0));
            bundle.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, str2);
            bundle.putString("extinfo", str3);
            x.i("MicroMsg.MsgHandler", "doOpenSpecificView, targetView = %s, ret = %b", new Object[]{str, Boolean.valueOf(com.tencent.mm.plugin.webview.a.a.ifs.a(gVar.context, str, bundle))});
            if (com.tencent.mm.plugin.webview.a.a.ifs.a(gVar.context, str, bundle)) {
                gVar.a(iVar, "specific_view:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "doOpenSpecificView, targetView not supported in current wechat version");
                gVar.a(iVar, "specific_view:not_supported", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean x(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToMall");
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("funcId");
        String str3 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        k.a(iVar.tJH, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str);
        intent.putExtra("key_func_id", str2);
        intent.putExtra("key_url", str3);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).jwN = gVar;
            com.tencent.mm.bm.d.a(gVar.context, "mall", ".ui.MallIndexUI", intent, 5, false);
        }
        return true;
    }

    static /* synthetic */ boolean y(g gVar, i iVar) {
        String str = (String) iVar.pox.get(DownloadInfoColumns.PACKAGENAME);
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "doWriteCommData fail, packageName is null");
        } else {
            String str2 = (String) iVar.pox.get(SlookAirButtonFrequentContactAdapter.DATA);
            boolean commit = gVar.context.getSharedPreferences(ac.getPackageName() + "_comm_preferences", 0).edit().putString(str, str2).commit();
            String str3 = "MicroMsg.MsgHandler";
            String str4 = "doWriteCommData, ret = %b, packageName = %s, data length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(commit);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(str2 == null ? 0 : str2.length());
            x.i(str3, str4, objArr);
            if (commit) {
                gVar.a(iVar, "write_comm_data:ok", null);
                return true;
            }
        }
        gVar.a(iVar, "write_comm_data:fail", null);
        return true;
    }

    static {
        HashSet hashSet = new HashSet();
        jkm = hashSet;
        hashSet.add("gcj02");
        jkm.add("wgs84");
    }

    g(int i) {
        this.fDl = i;
        this.maM = false;
        this.tHr = new HashSet();
        this.mWj = new HashSet();
        this.tHB = new c(this.fDl);
        this.tHD = new j();
        this.tHE = new d();
    }

    public final void a(Context context, e eVar) {
        String str = "MicroMsg.MsgHandler";
        String str2 = "set context and callbacker, callbacker %s";
        Object[] objArr = new Object[1];
        objArr[0] = eVar == null ? "null" : eVar.toString();
        x.i(str, str2, objArr);
        this.context = context;
        if (this.tHB != null) {
            this.tHB.a(context, eVar);
        }
        this.fBH = eVar;
    }

    public final void a(Context context, e eVar, e eVar2) {
        x.i("MicroMsg.MsgHandler", "set context, callbacker and service callbacker");
        this.context = context;
        if (this.tHB != null) {
            this.tHB.a(context, eVar);
        }
        this.fBH = eVar;
        this.tHy = eVar2;
    }

    public final Bundle bUv() {
        if (this.tHs == null) {
            this.tHs = new Bundle();
        }
        return this.tHs;
    }

    public final String qE(String str) {
        if (this.tHB != null) {
            return this.tHB.PB(str);
        }
        x.i("MicroMsg.MsgHandler", "getCachedAppId, jsVerifyHelper is null, return null");
        return null;
    }

    private void PH(String str) {
        if (this.tHs == null) {
            this.tHs = new Bundle();
        }
        int i = bh.getInt(str, 33);
        if (this.tHs.getBoolean("KFromBizSearch")) {
            Bundle bundle = this.tHs.getBundle("KBizSearchExtArgs");
            if (bundle != null) {
                i = bundle.getInt("Contact_Scene");
            }
        }
        this.tHs.putInt("Contact_Scene", i);
    }

    private boolean PI(String str) {
        x.i("MicroMsg.MsgHandler", "getFromMenu, functionName = " + str);
        if (!this.tHr.contains(str)) {
            return false;
        }
        this.tHr.remove(str);
        return true;
    }

    public final boolean PJ(String str) {
        x.i("MicroMsg.MsgHandler", "removeInvokedJsApiFromMenu, functionName = %s, succ = %s.", new Object[]{str, Boolean.valueOf(this.mWj.remove(str))});
        return this.mWj.remove(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        if (this.maM) {
            x.w("MicroMsg.MsgHandler", "handleMsg, MsgHandler is busy, old msg will be overrided");
        }
        if (this.tHs != null) {
            this.tHs.setClassLoader(getClass().getClassLoader());
        }
        this.tHp = iVar;
        this.maM = true;
        if (iVar.type.equals("call")) {
            this.tHw = iVar.tJI;
            int OX = com.tencent.mm.plugin.webview.ui.tools.a.OX(iVar.tJI);
            if (-1 != OX) {
                com.tencent.mm.plugin.report.service.g.pQN.a(157, (long) OX, 1, false);
            }
            com.tencent.mm.protocal.c.g Tm = com.tencent.mm.protocal.c.Tm(bh.ou(this.tHw));
            if (Tm == null) {
                x.e("MicroMsg.MsgHandler", "unknown function = %s", new Object[]{this.tHw});
                a(iVar, "system:function_not_exist", null, true);
                return true;
            } else if (Tm.getName() == "recordHistory") {
                x.e("MicroMsg.MsgHandler", "handleMsg access denied func: %s", new Object[]{Tm.getName()});
                a(iVar, "system:access_denied", null, true);
                return true;
            } else {
                if (!this.mWj.contains(Tm.getName())) {
                    if (jsapiPermissionWrapper.CF(Tm.cds()) == 0) {
                        x.e("MicroMsg.MsgHandler", "handleMsg access denied func: %s", new Object[]{Tm.getName()});
                        a(iVar, "system:access_denied", null, true);
                        return true;
                    }
                }
                try {
                    c$a 1 = new 1(this, iVar, jsapiPermissionWrapper, Tm);
                    c cVar = this.tHB;
                    String aeq = this.fBH.aeq();
                    int cds = Tm.cds();
                    String str = iVar.tJI;
                    if (!bh.ov(str)) {
                        String str2;
                        String str3;
                        if (jsapiPermissionWrapper != null && !bh.ov(aeq) && jsapiPermissionWrapper.vAQ != null) {
                            int CF = jsapiPermissionWrapper.CF(cds);
                            x.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[]{str, Integer.valueOf(cds), Integer.valueOf(CF), aeq});
                            String str4 = (String) cVar.tGy.get(aeq);
                            String str5 = bh.ov(str4) ? (String) iVar.pox.get("verifyAppId") : str4;
                            Map map = iVar.tJH;
                            map.put("permissionValue", Integer.valueOf(CF));
                            map.put("appId", str5);
                            switch (CF) {
                                case 0:
                                    1.a(c$a.a.RET_ACCESS_DENIED, null, null, 0, 0);
                                    break;
                                case 1:
                                    1.a(c$a.a.RET_OK, null, null, 0, 0);
                                    break;
                                case 2:
                                    if (!str.equals(ak.NAME)) {
                                        1.a(c$a.a.RET_ACCESS_DENIED, null, null, 0, 0);
                                        break;
                                    }
                                    1.a(c$a.a.RET_OK, null, null, 0, 0);
                                    break;
                                case 4:
                                    alr com_tencent_mm_protocal_c_alr = (alr) cVar.tGx.get(str + aeq);
                                    if (com_tencent_mm_protocal_c_alr != null && com_tencent_mm_protocal_c_alr.vJs == 1) {
                                        1.a(c$a.a.RET_OK, null, null, 0, 0);
                                        break;
                                    }
                                case 3:
                                    String str6;
                                    String str7;
                                    str4 = (String) iVar.pox.get("verifySignature");
                                    str2 = (String) iVar.pox.get("verifyNonceStr");
                                    str3 = (String) iVar.pox.get("verifyTimestamp");
                                    String str8 = (String) iVar.pox.get("verifySignType");
                                    String str9 = (String) iVar.pox.get("scope");
                                    x.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[]{(String) iVar.pox.get("addrSign"), str4});
                                    int i = 0;
                                    if (bh.ov(str4) && !bh.ov(r11)) {
                                        i = 1;
                                        str8 = (String) iVar.pox.get("timeStamp");
                                        str6 = (String) iVar.pox.get("nonceStr");
                                        str7 = (String) iVar.pox.get("signType");
                                        str5 = (String) iVar.pox.get("addrSign");
                                        str3 = (String) iVar.pox.get("appId");
                                    } else if (bh.ov(str4)) {
                                        str7 = str8;
                                        str6 = str2;
                                        str8 = str3;
                                        str3 = str5;
                                        str5 = str4;
                                    } else {
                                        i = 2;
                                        str7 = str8;
                                        str6 = str2;
                                        str8 = str3;
                                        str3 = str5;
                                        str5 = str4;
                                    }
                                    byte[] bArr = null;
                                    JSONObject U = i.a.U(iVar.pox);
                                    if (U != null) {
                                        bArr = U.toString().getBytes();
                                    }
                                    k nVar;
                                    if (CF != 4) {
                                        if (CF == 3) {
                                            nVar = new n(1, aeq, str3, str, str8, str6, str5, str7, bArr, cVar.tsc);
                                            ar.CG().a(1094, cVar);
                                            ar.CG().a(nVar, 0);
                                            break;
                                        }
                                    }
                                    nVar = new l(1, aeq, str3, str, str8, str6, str5, str7, bArr, i, str9, cVar.tsc);
                                    ar.CG().a(1095, cVar);
                                    ar.CG().a(nVar, 0);
                                    break;
                                    break;
                                default:
                                    1.a(c$a.a.RET_FAIL, "unkonwPermission_" + CF, null, 0, 0);
                                    x.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
                                    break;
                            }
                        }
                        str2 = "MicroMsg.webview.JSVerifyHelper";
                        str3 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = aeq;
                        objArr[1] = str;
                        objArr[2] = Boolean.valueOf(jsapiPermissionWrapper != null);
                        x.e(str2, str3, objArr);
                        1.a(c$a.a.RET_FAIL, "localParameters", null, 0, 0);
                    } else {
                        x.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[]{aeq});
                        1.a(c$a.a.RET_ACCESS_DENIED, null, null, 0, 0);
                    }
                    return 1.bUl();
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgHandler", "handleMsg excpetion %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                }
            }
        }
        x.e("MicroMsg.MsgHandler", "unknown type = " + iVar.type);
        this.maM = false;
        return false;
    }

    private boolean b(final i iVar) {
        x.d("MicroMsg.MsgHandler", "doShowDatePicker");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String format;
            String str;
            String str2;
            String str3;
            String str4 = (String) iVar.pox.get("current");
            if (bh.ov(str4)) {
                format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            } else {
                format = str4;
            }
            str4 = (String) iVar.pox.get("range");
            if (bh.ov(str4)) {
                str = null;
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str4);
                String optString = jSONObject.optString("start", "2013-01-01");
                str = jSONObject.optString("end", format);
                str2 = optString;
            }
            str4 = (String) iVar.pox.get("fields");
            if (bh.ov(str4)) {
                str3 = "month";
            } else {
                str3 = str4;
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(format));
            if (this.context == null || !(this.context instanceof Activity)) {
                x.e("MicroMsg.MsgHandler", "context error!");
                return false;
            }
            com.tencent.mm.ui.widget.h hVar = new com.tencent.mm.ui.widget.h(this.context, new OnDateSetListener(this) {
                final /* synthetic */ g tIj;

                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    x.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)});
                    Map hashMap = new HashMap();
                    hashMap.put("selectTime", String.format("%d-%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)}));
                    this.tIj.a(iVar, "showDatePickerView:ok", hashMap);
                }
            }, instance.get(1), instance.get(2), instance.get(5), simpleDateFormat.parse(str2).getTime(), str3);
            hVar.setOnCancelListener(new 63(this, iVar));
            if (!bh.ov(str2)) {
                x.d("MicroMsg.MsgHandler", "min date: %s", new Object[]{str2});
                hVar.getDatePicker().setMinDate(simpleDateFormat.parse(str2).getTime());
            }
            if (!bh.ov(str)) {
                x.d("MicroMsg.MsgHandler", "max date: %s", new Object[]{str});
                hVar.getDatePicker().setMaxDate(simpleDateFormat.parse(str).getTime());
            }
            hVar.show();
            return true;
        } catch (JSONException e) {
        } catch (ParseException e2) {
        }
    }

    private boolean c(i iVar) {
        try {
            String str = (String) this.tHp.pox.get("link");
            k.a(this.tHp.tJH, PI("shareTimeline"), str, null);
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.MsgHandler", "naerCheckIn fail, link is null");
                a(this.tHp, "timeline_check_in:fail", null);
                return true;
            }
            int intValue;
            truncate((String) this.tHp.pox.get("desc"));
            x.i("MicroMsg.MsgHandler", "naerCheckIn, img_url = " + ((String) this.tHp.pox.get("img_url")) + ", title = " + ((String) this.tHp.pox.get("title")) + ", desc = " + ((String) this.tHp.pox.get("desc")));
            str = (String) this.tHp.pox.get("img_width");
            String str2 = (String) this.tHp.pox.get("img_height");
            x.i("MicroMsg.MsgHandler", "naerCheckIn, rawUrl:[%s], shareUrl:[%s]", new Object[]{(String) this.tHp.pox.get("link"), com.tencent.mm.plugin.webview.model.ak.BP((String) this.tHp.pox.get("link"))});
            String str3 = (String) this.tHp.pox.get(DownloadSettingTable$Columns.TYPE);
            this.tHp.pox.get("desc");
            String str4 = (String) this.tHp.pox.get("title");
            String str5 = (String) this.tHp.pox.get("img_url");
            try {
                intValue = Integer.valueOf(str).intValue();
                try {
                    Integer.valueOf(str2);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                intValue = -1;
            }
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_width", intValue);
            intent.putExtra("Ksnsupload_height", intValue);
            intent.putExtra("Ksnsupload_link", r8);
            intent.putExtra("Ksnsupload_title", str4);
            intent.putExtra("Ksnsupload_imgurl", str5);
            intent.putExtra("Ksnsupload_type", 1);
            if (!bh.ov(str3) && str3.equals("music")) {
                intent.putExtra("ksnsis_music", true);
            }
            if (!bh.ov(str3) && str3.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                intent.putExtra("ksnsis_video", true);
            }
            str = (String) this.tHp.pox.get("poiId");
            str2 = (String) this.tHp.pox.get("poiName");
            str3 = (String) this.tHp.pox.get("poiAddress");
            float f = bh.getFloat((String) iVar.pox.get("latitude"), 0.0f);
            float f2 = bh.getFloat((String) iVar.pox.get("longitude"), 0.0f);
            intent.putExtra("kpoi_id", str);
            intent.putExtra("kpoi_name", str2);
            intent.putExtra("Kpoi_address", str3);
            intent.putExtra("k_lat", f);
            intent.putExtra("k_lng", f2);
            com.tencent.mm.bm.d.b(this.context, "sns", ".ui.SnsUploadUI", intent);
            this.maM = false;
            return false;
        } catch (Exception e3) {
            return true;
        }
    }

    private boolean d(i iVar) {
        int i = 0;
        try {
            float f = bh.getFloat((String) iVar.pox.get("latitude"), 0.0f);
            float f2 = bh.getFloat((String) iVar.pox.get("longitude"), 0.0f);
            String uE = uE((String) iVar.pox.get("name"));
            String uE2 = uE((String) iVar.pox.get("address"));
            String uE3 = uE((String) iVar.pox.get("infoUrl"));
            try {
                i = bh.getInt((String) iVar.pox.get("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            if (bh.getInt((String) this.tHp.pox.get("webview_scene"), 0) == 25) {
                intent.putExtra("map_view_type", 9);
                intent.putExtra("kPoi_url", uE3);
            } else {
                intent.putExtra("map_view_type", 7);
            }
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i > 0) {
                intent.putExtra("kwebmap_scale", i);
            }
            intent.putExtra("kPoiName", uE);
            intent.putExtra("Kwebmap_locaion", uE2);
            com.tencent.mm.bm.d.b(this.context, "location", ".ui.RedirectUI", intent);
            a(this.tHp, "open_location:ok", null);
        } catch (Exception e2) {
            a(this.tHp, "open_location:invalid_coordinate", null);
        }
        return true;
    }

    private static String uE(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < jRP.length) {
                String str2 = jRQ[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != jRP.length) {
                stringBuffer.append(jRP[i2]);
                i = jRQ[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    private boolean e(i iVar) {
        try {
            String str = (String) iVar.pox.get("bid");
            Intent intent = new Intent();
            intent.putExtra("sns_bid", str);
            com.tencent.mm.bm.d.b(this.context, "sns", ".ui.ClassifyTimeLineUI", intent);
            a(this.tHp, "open_timeline_checkin_list:ok", null);
        } catch (Exception e) {
        }
        return true;
    }

    private boolean b(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.fzc = f(iVar);
        if (this.fzc == null) {
            x.e("MicroMsg.MsgHandler", "doSendAppMsg fail, appmsg is null");
            a(iVar, "send_app_msg:fail", null);
        } else {
            String string = bUv().getString("scene");
            bUv().remove("scene");
            if (!"friend".equals(string)) {
                k.a(iVar.tJH, PI(GameJsApiSendAppMessage.NAME), null, (String) iVar.pox.get("appid"));
            }
            x.i("MicroMsg.MsgHandler", "send appmsg scene is '%s'", new Object[]{string});
            String string2;
            if ("connector".equals(string)) {
                x.i("MicroMsg.MsgHandler", "directly send to %s", new Object[]{bUw()});
                b(1, -1, new Intent().putExtra("Select_Conv_User", string2));
            } else if ("favorite".equals(string)) {
                x.i("MicroMsg.MsgHandler", "favorite url");
                com.tencent.mm.sdk.b.b cfVar = new cf();
                com.tencent.mm.plugin.webview.model.b.a aVar = new com.tencent.mm.plugin.webview.model.b.a();
                x.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{(String) this.tHp.pox.get("link"), com.tencent.mm.plugin.webview.model.ak.BP((String) this.tHp.pox.get("link"))});
                aVar.url = r4;
                aVar.thumbUrl = (String) this.tHp.pox.get("img_url");
                aVar.title = (String) this.tHp.pox.get("title");
                aVar.desc = (String) this.tHp.pox.get("desc");
                aVar.fFm = (String) this.tHp.pox.get("appid");
                if (this.tHs != null) {
                    string2 = this.tHs.getString("key_snsad_statextstr");
                    aVar.fGG = string2;
                } else {
                    string2 = null;
                }
                try {
                    Bundle e = this.fBH.e(18, null);
                    if (e != null) {
                        String hz = com.tencent.mm.z.u.hz(bh.ou(e.getString("KPublisherId")));
                        com.tencent.mm.z.u.b t = com.tencent.mm.z.u.GK().t(hz, true);
                        t.o("sendAppMsgScene", Integer.valueOf(2));
                        t.o("preChatName", e.getString("preChatName"));
                        t.o("preMsgIndex", Integer.valueOf(e.getInt("preMsgIndex")));
                        t.o("prePublishId", e.getString("prePublishId"));
                        t.o("preUsername", e.getString("preUsername"));
                        t.o("getA8KeyScene", Integer.valueOf(e.getInt("getA8KeyScene")));
                        t.o("referUrl", e.getString("referUrl"));
                        if (!bh.ov(string2)) {
                            t.o("adExtStr", string2);
                        }
                        cfVar.fqp.fqu = hz;
                    }
                } catch (RemoteException e2) {
                    x.e("MicroMsg.MsgHandler", "try to report error, %s", new Object[]{e2});
                }
                if (this.context instanceof Activity) {
                    cfVar.fqp.activity = (Activity) this.context;
                    cfVar.fqp.fqw = 36;
                }
                com.tencent.mm.plugin.webview.model.b.a(cfVar, aVar);
                cfVar.fqp.fqy = new 74(this);
                com.tencent.mm.sdk.b.a.xef.m(cfVar);
                if (cfVar.fqq.ret == 0) {
                    em(3, 1);
                    try {
                        a(aVar.fFm, aVar.thumbUrl, 4, this.fBH.e(85, null));
                    } catch (RemoteException e22) {
                        x.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", new Object[]{e22});
                    }
                } else {
                    em(3, 2);
                    a(this.tHp, "send_fav_msg:fail", null);
                }
            } else if ("enterprise".equals(string)) {
                String bUw = bUw();
                Serializable hashMap = new HashMap();
                hashMap.put("img_url", (String) iVar.pox.get("img_url"));
                hashMap.put("desc", (String) iVar.pox.get("desc"));
                hashMap.put("title", (String) iVar.pox.get("title"));
                hashMap.put("src_username", (String) iVar.pox.get("src_username"));
                hashMap.put("src_displayname", (String) iVar.pox.get("src_displayname"));
                x.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s", new Object[]{(String) iVar.pox.get("img_url"), (String) iVar.pox.get("desc"), (String) iVar.pox.get("title")});
                Intent intent;
                if (com.tencent.mm.ag.f.eE(bUw)) {
                    intent = new Intent();
                    intent.setClassName(this.context, "com.tencent.mm.ui.bizchat.BizChatSelectConversationUI");
                    intent.putExtra("enterprise_biz_name", bUw);
                    intent.putExtra("biz_chat_scene", 1);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).jwN = this;
                        ((MMActivity) this.context).b(this, intent, 37);
                    }
                } else if (com.tencent.mm.ag.f.jX(bUw)) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", bUw);
                    intent.putExtra("enterprise_scene", 3);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).jwN = this;
                        com.tencent.mm.bm.d.b(this.context, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 37);
                    }
                }
            } else if ("wework".equals(string)) {
                ah(iVar);
            } else if ("facebook".equals(string)) {
                Intent intent2 = new Intent();
                intent2.putExtra("title", (String) iVar.pox.get("title"));
                intent2.putExtra("digest", (String) iVar.pox.get("desc"));
                intent2.putExtra("img", (String) iVar.pox.get("img_url"));
                intent2.putExtra("link", (String) iVar.pox.get("link"));
                intent2.setClassName(this.context, "com.tencent.mm.plugin.accountsync.ui.ShareToFacebookRedirectUI");
                this.context.startActivity(intent2);
                a(iVar, "shareQZone:ok", null);
            } else if ("qq".equals(string)) {
                ai(iVar);
            } else {
                x.i("MicroMsg.MsgHandler", "select user to send");
                Serializable hashMap2 = new HashMap();
                if (a(iVar, jsapiPermissionWrapper.gn(89))) {
                    this.fzc = f(iVar);
                }
                if (jsapiPermissionWrapper.gn(JsApiDestroyInstanceAudio.CTRL_INDEX)) {
                    this.tHp.pox.put("share_callback_with_scene", Boolean.valueOf(true));
                } else {
                    this.tHp.pox.put("share_callback_with_scene", Boolean.valueOf(false));
                }
                hashMap2.put("img_url", (String) iVar.pox.get("img_url"));
                hashMap2.put("desc", (String) iVar.pox.get("desc"));
                hashMap2.put("title", (String) iVar.pox.get("title"));
                hashMap2.put(SlookSmartClipMetaTag.TAG_TYPE_URL, (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                x.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s, url=%s", new Object[]{(String) iVar.pox.get("img_url"), (String) iVar.pox.get("desc"), (String) iVar.pox.get("title"), (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL)});
                com.tencent.mm.plugin.report.service.g.pQN.a(157, 5, 1, false);
                Intent intent3 = new Intent();
                intent3.putExtra("Select_Conv_Type", 3);
                intent3.putExtra("scene_from", 2);
                intent3.putExtra("mutil_select_is_ret", true);
                intent3.putExtra("webview_params", hashMap2);
                intent3.putExtra("Retr_Msg_Type", 2);
                if (this.context instanceof MMActivity) {
                    iVar.tJH.put("Internal@AsyncReport", Boolean.valueOf(true));
                    if (bh.getInt((String) iVar.pox.get("open_from_scene"), 0) == 4) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10651, new Object[]{Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(0)});
                    }
                    com.tencent.mm.bm.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent3, 1, this);
                }
            }
        }
        return true;
    }

    private boolean a(i iVar, boolean z) {
        Object string;
        int i;
        c$d com_tencent_mm_plugin_webview_ui_tools_jsapi_c_d = null;
        Object obj = iVar.pox.get("__jsapi_fw_ext_info");
        String str = (String) iVar.pox.get("link");
        if (obj instanceof Bundle) {
            string = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        } else {
            string = null;
        }
        c cVar = this.tHB;
        if (!TextUtils.isEmpty(string)) {
            c$d com_tencent_mm_plugin_webview_ui_tools_jsapi_c_d2 = (c$d) cVar.mZy.get(string);
            if (com_tencent_mm_plugin_webview_ui_tools_jsapi_c_d2 == null) {
                com_tencent_mm_plugin_webview_ui_tools_jsapi_c_d2 = (c$d) cVar.mZy.get(c.BQ(string));
            }
            com_tencent_mm_plugin_webview_ui_tools_jsapi_c_d = com_tencent_mm_plugin_webview_ui_tools_jsapi_c_d2;
        }
        if (TextUtils.isEmpty(str) || r3 == null || r3.tGI == null || r3.tGI.size() <= 0) {
            i = 0;
        } else {
            int i2;
            List<String> linkedList = new LinkedList();
            int indexOf = str.indexOf("://");
            if (indexOf == -1) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            String substring = str.substring(i2 + indexOf);
            for (String str2 : r3.tGI) {
                String str22;
                x.i("MicroMsg.MsgHandler", "now domain : %s", new Object[]{str22});
                if (!TextUtils.isEmpty(str22)) {
                    int i3;
                    int indexOf2 = str22.indexOf("://");
                    if (indexOf2 == -1) {
                        i3 = 1;
                    } else {
                        i3 = 3;
                    }
                    str22 = str22.substring(i3 + indexOf2);
                    if (!str22.contains("/")) {
                        linkedList.add(str22);
                    } else if (substring.equals(str22)) {
                        i2 = 0;
                        break;
                    } else {
                        if (!str22.endsWith("/")) {
                            str22 = str22 + "/";
                        }
                        if (substring.startsWith(str22)) {
                            i2 = 0;
                            break;
                        }
                    }
                }
            }
            boolean z2 = true;
            if (!(i2 == 0 || linkedList.isEmpty())) {
                URI create = URI.create(str);
                String host = create.getHost();
                int port = create.getPort();
                substring = host + ":" + port;
                x.i("MicroMsg.MsgHandler", "share domain : %s", new Object[]{host});
                if (!bh.ov(host)) {
                    for (String str3 : linkedList) {
                        if (host.equals(str3) || host.endsWith("." + str3) || (port != -1 && (substring.equals(str3) || substring.endsWith("." + str3)))) {
                            i = 0;
                            break;
                        }
                    }
                }
            }
            i = i2;
        }
        if (!(i == 0 && z)) {
            try {
                Bundle e = this.fBH.e(84, null);
                if (e != null) {
                    if (TextUtils.isEmpty(string)) {
                        string = com.tencent.mm.plugin.webview.model.ak.BP(e.getString("webview_current_url"));
                    }
                    iVar.pox.put("img_url", "");
                    iVar.pox.put("link", string);
                    iVar.pox.put("desc", e.getString("webview_current_desc"));
                    iVar.pox.put("title", e.getString("webview_current_title"));
                    return true;
                }
            } catch (RemoteException e2) {
                x.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", new Object[]{e2});
            }
        }
        return false;
    }

    private String bUw() {
        String string = bUv().getString("connector_local_send");
        bUv().remove("connector_local_send");
        bUv().putString("connector_local_report", string);
        return string;
    }

    private String bUx() {
        String string = bUv().getString("connector_local_report");
        bUv().remove("connector_local_report");
        return string;
    }

    private static WXMediaMessage f(i iVar) {
        String str = (String) iVar.pox.get("link");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "convert fail, link is null");
            return null;
        }
        x.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{str, com.tencent.mm.plugin.webview.model.ak.BP(str)});
        IMediaObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = r1;
        wXWebpageObject.extInfo = (String) iVar.pox.get("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = (String) iVar.pox.get("title");
        wXMediaMessage.description = (String) iVar.pox.get("desc");
        return wXMediaMessage;
    }

    private boolean g(i iVar) {
        int i = 0;
        this.maM = false;
        String obj = iVar.pox.get("list").toString();
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(obj);
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    auc com_tencent_mm_protocal_c_auc = new auc();
                    com_tencent_mm_protocal_c_auc.wCb = optJSONObject.optInt("cmdId");
                    Object optString = optJSONObject.optString("cmdBuffer");
                    if (TextUtils.isEmpty(optString)) {
                        x.e("MicroMsg.MsgHandler", "doUxSearchOpLog cmdId " + com_tencent_mm_protocal_c_auc.wCb + " , cmdBuffer is empty");
                    } else {
                        com_tencent_mm_protocal_c_auc.wCc = new com.tencent.mm.bq.b(optString.getBytes());
                        linkedList.add(com_tencent_mm_protocal_c_auc);
                    }
                }
                i++;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MsgHandler", bh.i(e));
        }
        if (!linkedList.isEmpty()) {
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmj = new bxd();
            aVar.hmk = new bxe();
            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_opsearch";
            aVar.hmi = 1865;
            com.tencent.mm.ae.b JZ = aVar.JZ();
            ((bxd) JZ.hmg.hmo).wXT = linkedList;
            u.a(JZ, new u.a(this) {
                final /* synthetic */ g tIj;

                {
                    this.tIj = r1;
                }

                public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                    x.i("MicroMsg.MsgHandler", "doUxSearchOpLog rsp errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    return 0;
                }
            });
        }
        a(iVar, "uxSearchOpLog:succ", null);
        return true;
    }

    private boolean h(i iVar) {
        this.maM = false;
        if (iVar.pox.containsKey("actionSheetId")) {
            int VI = bh.VI((String) iVar.pox.get("actionSheetId"));
            Bundle bundle = new Bundle();
            bundle.putInt("actionSheetId", VI);
            try {
                this.fBH.n(com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, bundle);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            }
        }
        a(iVar, "", null);
        return true;
    }

    private boolean i(i iVar) {
        this.maM = false;
        Bundle bundle = new Bundle();
        if (iVar.pox.containsKey("title")) {
            bundle.putString("title", (String) iVar.pox.get("title"));
        }
        if (iVar.pox.containsKey("desc")) {
            bundle.putString("desc", (String) iVar.pox.get("desc"));
        }
        if (iVar.pox.containsKey("items")) {
            bundle.putString("items", (String) iVar.pox.get("items"));
        }
        try {
            this.fBH.n(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX, bundle);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Map hashMap = new HashMap();
        hashMap.put("actionSheetId", Integer.valueOf(bundle.getInt("actionSheetId")));
        a(iVar, iVar.tJI + ":ok", hashMap);
        return true;
    }

    public final boolean PK(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doProfile fail, username is null");
            this.maM = false;
            return false;
        } else if (bh.ov(str)) {
            Toast.makeText(ac.getContext(), this.context.getString(R.l.ejg, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            this.maM = false;
            return false;
        } else {
            if (this.tHp != null) {
                k.a(this.tHp.tJH, PI("profile"), str, null);
            }
            if (ar.Hi()) {
                com.tencent.mm.g.b.af WL;
                ar.Hg();
                com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
                if (WO == null || ((int) WO.gJd) <= 0) {
                    ar.Hg();
                    WL = com.tencent.mm.z.c.EY().WL(str);
                } else {
                    WL = WO;
                }
                final Intent intent = new Intent();
                String str2 = "";
                if (!(this.tHp == null || this.tHp.pox == null || this.tHp.pox.get("profileReportInfo") == null)) {
                    str2 = (String) this.tHp.pox.get("profileReportInfo");
                }
                if (!bh.ov(str2)) {
                    intent.putExtra("key_add_contact_report_info", str2);
                }
                if (this.tHs != null && this.tHs.getBoolean("KFromBizSearch")) {
                    intent.putExtra("Contact_Ext_Args", this.tHs.getBundle("KBizSearchExtArgs"));
                }
                if (WL == null || ((int) WL.gJd) <= 0) {
                    com.tencent.mm.z.ak.a.hfL.a(str, "", new com.tencent.mm.z.ak.b.a(this) {
                        final /* synthetic */ g tIj;

                        public final void v(String str, boolean z) {
                            int i = 42;
                            if (this.tIj.context == null) {
                                x.w("MicroMsg.MsgHandler", "getNow callback, msghandler has already been detached!");
                                this.tIj.a(this.tIj.tHp, "profile:fail", null);
                                return;
                            }
                            if (this.tIj.iln != null) {
                                this.tIj.iln.dismiss();
                            }
                            ar.Hg();
                            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
                            if (WO == null || ((int) WO.gJd) <= 0) {
                                ar.Hg();
                                WO = com.tencent.mm.z.c.EY().WL(str);
                            }
                            if (WO == null || ((int) WO.gJd) <= 0) {
                                z = false;
                            } else {
                                str = WO.field_username;
                            }
                            if (z) {
                                com.tencent.mm.ad.b.I(str, 3);
                                com.tencent.mm.ad.n.JS().iY(str);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("Contact_User", str);
                                if (WO.cia()) {
                                    if (this.tIj.tHs != null) {
                                        i = this.tIj.tHs.getInt("Contact_Scene", 42);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pQN.k(10298, WO.field_username + "," + i);
                                    intent.putExtra("Contact_Scene", i);
                                }
                                this.tIj.ab(intent);
                                this.tIj.a(this.tIj.tHp, "profile:ok", null);
                                return;
                            }
                            Toast.makeText(ac.getContext(), this.tIj.context.getString(R.l.ejg, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                            this.tIj.a(this.tIj.tHp, "profile:fail", null);
                        }
                    });
                    Context context = this.context;
                    this.context.getString(R.l.dGO);
                    this.iln = h.a(context, this.context.getString(R.l.dHc), true, new 107(this, str));
                    return true;
                }
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("Contact_User", WL.field_username);
                if (WL.cia()) {
                    int i;
                    if (this.tHs == null) {
                        i = 42;
                    } else {
                        i = this.tHs.getInt("Contact_Scene", 42);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.k(10298, WL.field_username + "," + i);
                    intent.putExtra("Contact_Scene", i);
                }
                if (com.tencent.mm.l.a.fZ(WL.field_type)) {
                    com.tencent.mm.sdk.b.b oxVar = new ox();
                    oxVar.fGO.intent = intent;
                    oxVar.fGO.username = WL.field_username;
                    com.tencent.mm.sdk.b.a.xef.m(oxVar);
                }
                ab(intent);
                a(this.tHp, "profile:ok", null);
                return false;
            }
            x.e("MicroMsg.MsgHandler", "doProfile, MMCore.hasCfgDefaultUin() is false");
            this.maM = false;
            return false;
        }
    }

    private void ab(final Intent intent) {
        com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "profile", ".ui.ContactInfoUI", this.fBH, new Runnable(this) {
            final /* synthetic */ g tIj;

            public final void run() {
                com.tencent.mm.plugin.webview.a.a.ifs.d(intent, this.tIj.context);
            }
        });
    }

    private boolean j(i iVar) {
        i a;
        if (q.Gz()) {
            ar.Hg();
            bc EY = com.tencent.mm.z.c.Fg().EY("@t.qq.com");
            if (EY == null || bh.ou(EY.name).length() == 0) {
                a = h.a(this.context, R.l.eXZ, R.l.dGO, new 23(this));
                a.setCancelable(false);
                a.setOnDismissListener(new 24(this, iVar));
            } else {
                int i;
                int i2;
                String az = bh.az((String) iVar.pox.get(DownloadSettingTable$Columns.TYPE), "40");
                if (az == null || az.length() <= 0) {
                    i = 40;
                } else {
                    try {
                        i = bh.getInt(az, 40);
                    } catch (Exception e) {
                        i = 40;
                    }
                }
                if (i == 11 || i == 20) {
                    i2 = i;
                } else {
                    i2 = 40;
                }
                az = (String) iVar.pox.get("content");
                String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (az == null || az.trim().length() == 0) {
                    az = "";
                }
                if (str == null || str.length() == 0) {
                    x.e("MicroMsg.MsgHandler", "doWeibo fail, invalid argument, content = " + az + ", url = " + str);
                    a(iVar, "share_weibo:fail_-2", null);
                } else {
                    k.a(iVar.tJH, PI("shareWeibo"), null, null);
                    str = com.tencent.mm.plugin.webview.model.ak.BP(str);
                    Intent intent = new Intent(this.context, ShareToQQWeiboUI.class);
                    intent.putExtra(DownloadSettingTable$Columns.TYPE, i2);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("content", az);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).b(this, intent, 2);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doWeibo fail, qq not binded");
            a = h.a(this.context, R.l.eYb, R.l.dGO, new 13(this), null);
            a.setCancelable(false);
            a.setOnDismissListener(new 22(this, iVar));
        }
        return true;
    }

    private boolean c(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        a(iVar, jsapiPermissionWrapper.gn(88));
        this.fzc = f(iVar);
        if (this.fzc == null) {
            x.e("MicroMsg.MsgHandler", "doTimeline fail, appmsg is null");
        }
        String str = (String) iVar.pox.get("link");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doTimeline fail, link is null");
            a(iVar, "share_timeline:fail", null);
            return true;
        }
        String str2;
        String str3 = (String) iVar.pox.get("desc");
        if (str3 != null) {
            truncate(str3);
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, img_url = " + ((String) iVar.pox.get("img_url")) + ", title = " + ((String) iVar.pox.get("title")) + ", desc = " + ((String) iVar.pox.get("desc")));
        int i = 1;
        String str4 = "";
        int i2 = 0;
        if (this.tHs != null) {
            this.tHs.setClassLoader(getClass().getClassLoader());
            i = this.tHs.getInt("snsWebSource", 1);
            str4 = this.tHs.getString("jsapi_args_appid");
            i2 = bh.getInt(this.tHs.getString("urlAttribute"), 0);
            this.tHs.remove("urlAttribute");
        }
        int i3 = i2;
        int i4 = i;
        str3 = str4;
        if (bh.ov(str3)) {
            str2 = (String) iVar.pox.get("appid");
        } else {
            str2 = str3;
        }
        k.a(iVar.tJH, PI("shareTimeline"), str, str2);
        str3 = (String) iVar.pox.get("img_width");
        str4 = (String) iVar.pox.get("img_height");
        String BP = com.tencent.mm.plugin.webview.model.ak.BP((String) iVar.pox.get("link"));
        x.i("MicroMsg.MsgHandler", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{r3, BP});
        String str5 = (String) iVar.pox.get(DownloadSettingTable$Columns.TYPE);
        iVar.pox.get("desc");
        String str6 = (String) iVar.pox.get("title");
        String str7 = (String) iVar.pox.get("img_url");
        String str8 = (String) iVar.pox.get("src_username");
        String str9 = (String) iVar.pox.get("src_displayname");
        try {
            i2 = Integer.valueOf(str3).intValue();
            try {
                Integer.valueOf(str4);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            i2 = -1;
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", BP);
        intent.putExtra("Ksnsupload_title", str6);
        intent.putExtra("Ksnsupload_imgurl", str7);
        intent.putExtra("Ksnsupload_contentattribute", i3);
        if (com.tencent.mm.z.s.gF(str8)) {
            intent.putExtra("src_username", str8);
            intent.putExtra("src_displayname", str9);
        }
        intent.putExtra("Ksnsupload_source", i4);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bh.ov(str5) && str5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bh.ov(str5) && str5.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str2 != null && str2.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str2);
        }
        str4 = "MicroMsg.MsgHandler";
        str5 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.tHs == null);
        x.i(str4, str5, objArr);
        str3 = null;
        if (this.tHs != null) {
            str4 = this.tHs.getString("K_sns_thumb_url");
            str5 = this.tHs.getString("K_sns_raw_url");
            str6 = bh.az(this.tHs.getString("KSnsStrId"), "");
            str7 = bh.az(this.tHs.getString("KSnsLocalId"), "");
            str3 = this.tHs.getString("key_snsad_statextstr");
            intent.putExtra("key_snsad_statextstr", str3);
            x.i("MicroMsg.MsgHandler", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{str, str5, str4});
            if (!(str5 == null || str == null || !str5.equals(str))) {
                intent.putExtra("KlinkThumb_url", str4);
            }
            intent.putExtra("KSnsStrId", str6);
            intent.putExtra("KSnsLocalId", str7);
            Parcelable parcelable = this.tHs.getParcelable("KSnsAdTag");
            x.i("MicroMsg.MsgHandler", "doTimeline, snsAdTag : %s", new Object[]{parcelable});
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                intent.putExtra("KsnsAdTag", (SnsAdClick) parcelable);
            }
            if (str6 != null && this.tHs.getBoolean("KFromTimeline", false)) {
                com.tencent.mm.sdk.b.b puVar = new pu();
                puVar.fHx.fzW = str6;
                puVar.fHx.frH = str7;
                com.tencent.mm.sdk.b.a.xef.m(puVar);
            }
        }
        try {
            intent.putExtra("ShareUrlOriginal", this.fBH.bRM());
            Bundle e3 = this.fBH.e(18, null);
            intent.putExtra("KPublisherId", e3 == null ? "" : bh.ou(e3.getString("KPublisherId")));
            str = this.fBH.aeq();
            intent.putExtra("ShareUrlOpen", str);
            intent.putExtra("JsAppId", this.tHB.PB(str));
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e4, "", new Object[0]);
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, start activity");
        if (this.context instanceof MMActivity) {
            intent.putExtra("need_result", true);
            try {
                e3 = this.fBH.e(18, null);
                if (e3 != null) {
                    str4 = com.tencent.mm.z.u.hz(bh.ou(e3.getString("KPublisherId")));
                    com.tencent.mm.z.u.b t = com.tencent.mm.z.u.GK().t(str4, true);
                    t.o("sendAppMsgScene", Integer.valueOf(2));
                    t.o("preChatName", e3.getString("preChatName"));
                    t.o("preMsgIndex", Integer.valueOf(e3.getInt("preMsgIndex")));
                    t.o("prePublishId", e3.getString("prePublishId"));
                    t.o("preUsername", e3.getString("preUsername"));
                    t.o(SlookSmartClipMetaTag.TAG_TYPE_URL, BP);
                    t.o("getA8KeyScene", Integer.valueOf(e3.getInt("getA8KeyScene")));
                    t.o("referUrl", e3.getString("referUrl"));
                    if (!bh.ov(str3)) {
                        t.o("adExtStr", str3);
                    }
                    intent.putExtra("reportSessionId", str4);
                }
            } catch (RemoteException e5) {
                x.e("MicroMsg.MsgHandler", "try to attach report args error, %s", new Object[]{e5});
            }
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.a(this.context, "sns", ".ui.SnsUploadUI", intent, 24, false);
        }
        return true;
    }

    private boolean k(i iVar) {
        String str = (String) iVar.pox.get("ad_info");
        String str2 = str + ",";
        String FS = q.FS();
        try {
            String str3;
            Bundle bundle;
            Bundle e = this.fBH.e(18, null);
            if (e != null) {
                String string = e.getString("prePublishId");
                String string2 = e.getString("preChatName");
                String string3 = e.getString("preUsername");
                str3 = str2 + string + "," + string2 + "," + string3 + "," + e.getInt("getA8KeyScene") + ",";
                if (string != null) {
                    try {
                        if (string.startsWith("msg_")) {
                            long parseLong = Long.parseLong(string.substring(4));
                            ar.Hg();
                            com.tencent.mm.g.b.cf F = com.tencent.mm.z.c.Fa().F(string2, parseLong);
                            str3 = str3 + F.getType() + "," + com.tencent.mm.z.m.gl(F.field_talker) + "," + t.N(string3, string2) + "," + aj.bQU() + ",";
                            str3 = str3 + FS;
                            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.a.class)).e(13297, str3, (int) bh.Wo());
                            if (Integer.parseInt(bh.az((String) iVar.pox.get("need_record_page_operation"), "0")) != 0) {
                                bundle = new Bundle();
                                bundle.putString("traceid", str);
                                bundle.putString("username", FS);
                                try {
                                    this.fBH.e(90002, bundle);
                                } catch (RemoteException e2) {
                                }
                            }
                            a(iVar, "adDataReport：ok", null);
                            return true;
                        }
                    } catch (Throwable e3) {
                        Throwable th = e3;
                        str2 = str3;
                        x.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    }
                }
                str3 = str3 + ",,,,";
                str3 = str3 + FS;
                ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.a.class)).e(13297, str3, (int) bh.Wo());
                if (Integer.parseInt(bh.az((String) iVar.pox.get("need_record_page_operation"), "0")) != 0) {
                    bundle = new Bundle();
                    bundle.putString("traceid", str);
                    bundle.putString("username", FS);
                    this.fBH.e(90002, bundle);
                }
                a(iVar, "adDataReport：ok", null);
                return true;
            }
            str3 = str2;
            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.a.class)).e(13297, str3, (int) bh.Wo());
            if (Integer.parseInt(bh.az((String) iVar.pox.get("need_record_page_operation"), "0")) != 0) {
                bundle = new Bundle();
                bundle.putString("traceid", str);
                bundle.putString("username", FS);
                this.fBH.e(90002, bundle);
            }
            a(iVar, "adDataReport：ok", null);
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e4, "", new Object[0]);
            a(iVar, "adDataReport：fail", null);
        }
        return true;
    }

    private boolean l(i iVar) {
        try {
            if (this.fBH != null) {
                Bundle e = this.fBH.e(87, null);
                if (e != null) {
                    if (bh.ou(e.getString("result")).equals("not_return")) {
                        a(iVar, "getWePkgAuthResult:fail_auth_result_not_return", null);
                    } else {
                        String string = e.getString("full_url");
                        int i = e.getInt("set_cookie");
                        if (bh.ov(string)) {
                            a(iVar, "getWePkgAuthResult:fail_full_url_empty", null);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("full_url", string);
                            hashMap.put("set_cookie", Integer.valueOf(i));
                            a(iVar, "getWePkgAuthResult:ok", hashMap);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "doGetWePkgAuthResult exception, " + e2.getMessage());
            a(iVar, "getWePkgAuthResult:fail", null);
        }
        return true;
    }

    private boolean m(i iVar) {
        String str = (String) iVar.pox.get("reportId");
        boolean equals = bh.ou((String) iVar.pox.get("reportInstantly")).equals("1");
        boolean equals2 = bh.ou((String) iVar.pox.get("reportTimeBegin")).equals("1");
        String str2 = (String) iVar.pox.get("reportFormatData");
        String str3 = (String) iVar.pox.get("reportTabsFormatData");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "reportId is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportId", null);
        } else if (bh.ov(str2) && bh.ov(str3)) {
            x.e("MicroMsg.MsgHandler", "reportFormatData && reportTabsFormatData is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportFormatData_reportTabsFormatData", null);
        } else {
            x.i("MicroMsg.MsgHandler", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[]{str, Boolean.valueOf(equals), Boolean.valueOf(equals2), str2, str3});
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", str);
            bundle.putBoolean("game_page_report_instantly", equals);
            bundle.putBoolean("game_page_report_time_begin", equals2);
            bundle.putString("game_page_report_format_data", str2);
            bundle.putString("game_page_report_tabs_format_data", str3);
            try {
                this.fBH.e(95, bundle);
                a(iVar, "reportGamePageTime:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "reportGamePageTime, exception = %s", new Object[]{e});
                a(iVar, "reportGamePageTime:fail", null);
            }
        }
        return true;
    }

    private static String truncate(String str) {
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        if (str.startsWith("https://")) {
            return str.substring(8);
        }
        return str;
    }

    private boolean n(i iVar) {
        String str = (String) iVar.pox.get("current");
        String[] strArr = (String[]) iVar.pox.get("urls");
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.MsgHandler", "doImgPreview fail, urls is null");
            this.maM = false;
        } else {
            Bundle e;
            x.d("MicroMsg.MsgHandler", "doImgPreview ok");
            int i = 0;
            while (i < strArr.length) {
                if (bh.ov(strArr[i]) || strArr[i].equalsIgnoreCase("null")) {
                    x.e("MicroMsg.MsgHandler", "null url, i = %d", new Object[]{Integer.valueOf(i)});
                } else {
                    if (bh.ou(strArr[i]).startsWith("weixin://resourceid/")) {
                        strArr[i] = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(strArr[i]).iLu;
                    }
                    arrayList.add(strArr[i]);
                }
                i++;
            }
            strArr = (String[]) arrayList.toArray(strArr);
            String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (bh.ov(str)) {
                str = strArr[0];
            } else if (str.startsWith("weixin://resourceid/")) {
                str = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str).iLu;
            }
            Intent intent = new Intent();
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr2);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            intent.putExtra("shouldShowScanQrCodeMenu", true);
            try {
                e = this.fBH.e(90001, new Bundle());
                if (e != null) {
                    str = e.getString("cookie", null);
                    if (!bh.ov(str)) {
                        intent.putExtra("cookie", str);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "getCookie fail : %s", new Object[]{e2.getMessage()});
            }
            if (this.context instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            e = new Bundle();
            e.putInt("stat_scene", 4);
            e.putString("stat_url", aeq());
            intent.putExtra("_stat_obj", e);
            com.tencent.mm.plugin.webview.a.a.ifs.t(intent, this.context);
            this.maM = false;
        }
        return false;
    }

    private boolean o(i iVar) {
        try {
            Bundle ap = i.ap(iVar.pox);
            this.fBH.bRO();
            this.fBH.O(ap);
            com.tencent.mm.sdk.b.a.xef.m(new tr());
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
        }
        a(iVar, "close_window:ok", null);
        return true;
    }

    private void a(i iVar, int i, int i2) {
        String str = iVar.tJI;
        if (str.equals("requireSoterBiometricAuthentication") || str.equals("getSupportSoter")) {
            String qE = qE(aeq());
            com.tencent.mm.plugin.soter.c.g gVar = com.tencent.mm.plugin.soter.c.g.rSo;
            com.tencent.mm.plugin.soter.c.g.n(str, qE, i, i2);
        }
    }

    private boolean p(i iVar) {
        this.maM = false;
        int VI = bh.VI(iVar.pox.get("voteResultIndex").toString());
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sns_landing_pages_ad_vote_index", VI);
            this.fBH.n(150, bundle);
        } catch (Exception e) {
        }
        return false;
    }

    private boolean q(i iVar) {
        String str = (String) iVar.pox.get(DownloadInfoColumns.PACKAGENAME);
        if (bh.ov(str)) {
            x.i("MicroMsg.MsgHandler", "packageName is null or nil");
            a(iVar, "get_install_state:no", null);
            return true;
        }
        k.a(iVar.tJH, false, str, null);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    PackageInfo packageInfo = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(this.context, string);
                    int i2 = packageInfo == null ? 0 : packageInfo.versionCode;
                    String str2 = packageInfo == null ? "null" : packageInfo.versionName;
                    x.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + string + ", packageInfo = " + packageInfo + ", version = " + i2 + ", versionName = " + str2);
                    if (obj == null && i2 > 0) {
                        obj = 1;
                    }
                    jSONObject.put(string, i2);
                    jSONObject2.put(string, str2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                hashMap.put("versionName", jSONObject2);
                if (obj != null) {
                    a(iVar, "get_install_state:yes", hashMap);
                } else {
                    a(iVar, "get_install_state:no", null);
                }
                return true;
            }
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "it is not batch get install state");
        }
        PackageInfo packageInfo2 = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(this.context, str);
        int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
        String str3 = packageInfo2 == null ? "null" : packageInfo2.versionName;
        x.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + str + ", packageInfo = " + packageInfo2 + ", version = " + i3 + ", versionName = " + str3);
        if (packageInfo2 == null) {
            a(iVar, "get_install_state:no", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("versionName", str3);
            a(iVar, "get_install_state:yes_" + i3, hashMap2);
        }
        return true;
    }

    private boolean r(i iVar) {
        boolean z;
        boolean z2;
        int i;
        Intent intent;
        String str = (String) iVar.pox.get("desc");
        int i2 = bh.getInt((String) iVar.pox.get("needResult"), 1);
        String str2 = (String) iVar.pox.get("scanType");
        x.i("MicroMsg.MsgHandler", "desc : %s, scene : %d, scanType : %s", new Object[]{str, Integer.valueOf(i2), str2});
        if (bh.ov(str2)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        boolean z3;
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                z3 = z;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    try {
                        str = (String) jSONArray.get(i3);
                        if (str.equalsIgnoreCase("qrCode")) {
                            z = z3;
                            z3 = true;
                        } else if (str.equalsIgnoreCase("barCode")) {
                            z = true;
                            z3 = z2;
                        } else {
                            z = z3;
                            z3 = z2;
                        }
                        i3++;
                        z2 = z3;
                        z3 = z;
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                z3 = z;
                x.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                if (!z2) {
                }
                if (!z2) {
                }
                i = 1;
                if (i2 == 0) {
                    x.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    com.tencent.mm.bm.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
                    a(iVar, "scanQRCode:ok", null);
                } else if (i2 != 1) {
                    x.e("MicroMsg.MsgHandler", "unkown scene");
                    a(iVar, "scanQRCode:fail_invalid_scene", null);
                } else {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    intent.putExtra("key_is_finish_on_scanned", true);
                    intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
                    WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.fDl);
                }
                return true;
            }
        }
        z3 = z;
        if (!z2 && !r1) {
            i = 8;
        } else if (z2 || !r1) {
            i = 1;
        } else {
            i = 4;
        }
        if (i2 == 0) {
            x.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            if (!(com.tencent.mm.p.a.aV(this.context) || com.tencent.mm.au.a.Qj())) {
                com.tencent.mm.bm.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            }
            a(iVar, "scanQRCode:ok", null);
        } else if (i2 != 1) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("key_is_finish_on_scanned", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            if (!(com.tencent.mm.p.a.aV(this.context) || com.tencent.mm.au.a.Qj())) {
                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.fDl);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "unkown scene");
            a(iVar, "scanQRCode:fail_invalid_scene", null);
        }
        return true;
    }

    private boolean s(i iVar) {
        String str = (String) iVar.pox.get("fontSize");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize is null");
            this.maM = false;
        } else {
            x.i("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize = " + str);
            try {
                this.fBH.OK(str);
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "setFontSizeCb, ex = " + e.getMessage());
            }
            this.maM = false;
        }
        return false;
    }

    private boolean t(i iVar) {
        x.d("MicroMsg.MsgHandler", "hy: doGetPayResultReq");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
            com.tencent.mm.sdk.b.b lnVar = new ln();
            lnVar.fCS.appId = gVar.appId;
            lnVar.fCS.partnerId = gVar.partnerId;
            lnVar.fCS.signType = gVar.signType;
            lnVar.fCS.nonceStr = gVar.nonceStr;
            lnVar.fCS.timeStamp = gVar.timeStamp;
            lnVar.fCS.packageExt = gVar.packageExt;
            lnVar.fCS.fCT = gVar.fCT;
            lnVar.fCS.url = gVar.url;
            lnVar.fCS.fCU = gVar.fCU;
            lnVar.fCS.fCV = gVar.fCV;
            lnVar.fCS.fqJ = gVar.fqJ;
            lnVar.fCS.fCW = gVar.fCW;
            com.tencent.mm.sdk.b.a.xef.m(lnVar);
            b(21, -1, null);
        }
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        return true;
    }

    private boolean u(i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenProductView");
        String str = (String) iVar.pox.get("productInfo");
        String str2 = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(new JSONObject(str).getInt("product_type"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_info", str);
        intent.putExtra("key_source_url", str2);
        return a(valueOf, 3, 0, null, intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Integer num, int i, int i2, String str, Intent intent) {
        intent.putExtra("key_product_scene", i);
        x.e("MicroMsg.MsgHandler", "doOpenProductView, productType = %d", new Object[]{num});
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jwN = this;
            switch (num.intValue()) {
                case 0:
                    switch (i2) {
                        case 0:
                            com.tencent.mm.bm.d.b(this.context, "product", ".ui.MallProductUI", intent);
                            a(this.tHp, "open_product_view:ok", null);
                            break;
                        case 1:
                            intent.putExtra("key_Qrcode_Url", str);
                            intent.putExtra("key_ProductUI_getProductInfoScene", 4);
                            com.tencent.mm.bm.d.b(this.context, "scanner", ".ui.ProductUI", intent, 10);
                            break;
                        default:
                            x.e("MicroMsg.MsgHandler", "doOpenProductView fail, productType = %d, viewType = %d", new Object[]{num, Integer.valueOf(i2)});
                    }
                case 10000:
                case HardCoderJNI.sHCENCODEVIDEOTIMEOUT /*20000*/:
                    com.tencent.mm.bm.d.b(this.context, "card", ".ui.CardProductUI", intent);
                    a(this.tHp, "open_product_view:ok", null);
                    break;
                default:
                    x.e("MicroMsg.MsgHandler", "doOpenProductView fail, productType = %d", new Object[]{num});
                    if (i != 8) {
                        a(this.tHp, "open_product_view:fail", null);
                        break;
                    }
                    a(this.tHp, "open_product_view_with_id:fail", null);
                    break;
            }
        }
        a(this.tHp, "open_product_view:fail", null);
        return true;
    }

    private boolean a(final i iVar, int... iArr) {
        if (tHA != -1) {
            this.tHp = Ba(tHA).tHp;
            this.fBH = Ba(tHA).fBH;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT < 18) {
            a(iVar, "startMonitoringBeacons:system unsupported", null);
        } else {
            if (!(defaultAdapter == null || defaultAdapter.getState() == 12)) {
                if (defaultAdapter.getState() == 10) {
                    a(iVar, "startMonitoringBeacons:bluetooth power off", null);
                } else {
                    a(iVar, "startMonitoringBeacons:bluetooth state unknown", null);
                }
            }
            if (iArr == null || iArr.length == 0) {
                if (!this.tHN.isProviderEnabled("gps")) {
                    a(iVar, "startMonitoringBeacons:location service disable", null);
                }
                SensorManager sensorManager = (SensorManager) tHz.getSystemService("sensor");
                sensorManager.registerListener(this.tHR, sensorManager.getDefaultSensor(3), 0);
            }
            if (this.tHQ) {
                a(iVar, "startMonitoringBeacons:already started", null);
            } else {
                this.tHQ = true;
                a(iVar, "startMonitoringBeacons:ok", null);
            }
            if (!(iVar == null || iVar.pox == null)) {
                Object obj = iVar.pox.get("uuid");
                Object obj2 = iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                Object obj3 = iVar.pox.get("ticket");
                String obj4 = obj2 != null ? obj2.toString() : "";
                String obj5 = obj != null ? obj.toString() : "";
                com.tencent.mm.plugin.report.service.g.pQN.h(12101, new Object[]{bh.ou(this.tHB.PB(obj4)), obj4, this.tHO, this.tHP, obj3 != null ? obj3.toString() : ""});
                new StringBuilder("{\"UUID\":\"").append(obj5).append("\",\"Major\":0,\"Minor\":0").append("}");
                final k xVar = new com.tencent.mm.plugin.webview.model.x(obj4, r4, r1);
                ar.CG().a(1702, new com.tencent.mm.ae.e(this) {
                    final /* synthetic */ g tIj;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            bry com_tencent_mm_protocal_c_bry = (bry) xVar.hFi.hmh.hmo;
                            if (com_tencent_mm_protocal_c_bry.lOr == 0) {
                                List<String> list = com_tencent_mm_protocal_c_bry.wTu;
                                if (list == null || list.isEmpty()) {
                                    this.tIj.a(iVar, "startMonitoringBeacons:no uuids", null);
                                } else {
                                    for (String a : list) {
                                        g.a(this.tIj, a);
                                    }
                                }
                            } else {
                                this.tIj.a(iVar, "startMonitoringBeacons:system error", null);
                                x.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", new Object[]{com_tencent_mm_protocal_c_bry.lOs});
                            }
                            ar.CG().b(1702, this);
                        }
                    }
                });
                ar.CG().a(xVar, 0);
            }
        }
        return true;
    }

    public final boolean b(i iVar, int... iArr) {
        if (tHA != -1) {
            this.tHp = Ba(tHA).tHp;
            this.fBH = Ba(tHA).fBH;
        }
        if (VERSION.SDK_INT >= 18) {
            boolean a;
            com.tencent.mm.sdk.b.a.xef.c(this.qsf);
            if (ar.Hj()) {
                ar.Hg();
                a = bh.a((Boolean) com.tencent.mm.z.c.CU().get(w.a.xqg, null), false);
            } else {
                a = false;
            }
            for (String str : this.tHI.keySet()) {
                com.tencent.mm.sdk.b.b djVar = new dj();
                x.i("MicroMsg.MsgHandler", "[MsgHandler][doStopIBeaconRange]op=false,iBeacon = %s", new Object[]{str});
                djVar.frU.frW = str;
                djVar.frU.frT = false;
                if (!a) {
                    com.tencent.mm.sdk.b.a.xef.m(djVar);
                }
            }
            if (ar.Hj()) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xqb, Boolean.valueOf(false));
            }
            Editor edit = ac.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            this.tHI.clear();
            this.gyC.clear();
            this.tHJ.clear();
            this.tHK.clear();
            this.tHQ = false;
            if (iArr == null || iArr.length == 0) {
                a(iVar, "stopMonitoringBeacons:ok", null);
                this.tHQ = false;
            }
        }
        if (!(tHz == null || this.tHR == null)) {
            ((SensorManager) tHz.getSystemService("sensor")).unregisterListener(this.tHR);
        }
        return true;
    }

    private boolean bUy() {
        String aeq;
        x.i("MicroMsg.MsgHandler", "doGetLatestAddress JSOAUTH");
        String str = "";
        try {
            aeq = this.fBH.aeq();
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = str;
        }
        final String str2 = "get_recently_used_address:";
        if (aeq == null) {
            a(this.tHp, str2 + "fail", null);
        } else {
            final com.tencent.mm.sdk.b.b mfVar = new mf();
            mfVar.fDT.appId = (String) this.tHp.pox.get("appId");
            mfVar.fDT.url = aeq;
            mfVar.fDU.errCode = -119;
            mfVar.fqI = new Runnable(this) {
                final /* synthetic */ g tIj;

                public final void run() {
                    x.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(mfVar.fDU.errCode), Boolean.valueOf(mfVar.fDU.fDV)});
                    if (mfVar.fDU.errCode != -119) {
                        if (mfVar.fDU.errCode != 0) {
                            this.tIj.a(this.tIj.tHp, str2 + "fail", null);
                        } else if (mfVar.fDU.fDV) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", mfVar.fDU.fDW);
                            hashMap.put("userName", mfVar.fDU.userName);
                            hashMap.put("telNumber", mfVar.fDU.fDX);
                            hashMap.put("addressPostalCode", mfVar.fDU.fDY);
                            hashMap.put("proviceFirstStageName", mfVar.fDU.fDZ);
                            hashMap.put("addressCitySecondStageName", mfVar.fDU.fEa);
                            hashMap.put("addressCountiesThirdStageName", mfVar.fDU.fEb);
                            hashMap.put("addressDetailInfo", mfVar.fDU.fEc);
                            this.tIj.a(this.tIj.tHp, str2 + "ok", hashMap);
                        } else {
                            this.tIj.a(this.tIj.tHp, str2 + "cancel", null);
                        }
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xef.a(mfVar, Looper.getMainLooper());
        }
        return true;
    }

    private boolean v(i iVar) {
        k.a(iVar.tJH, PI("sendEmail"), null, null);
        String str = (String) iVar.pox.get("title");
        String str2 = "";
        try {
            str2 = com.tencent.mm.plugin.webview.model.ak.BP(this.fBH.aeq());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("composeType", 1);
        intent.putExtra("subject", str);
        intent.putExtra("mail_content", str2);
        com.tencent.mm.bm.d.a(this.context, "qqmail", ".ui.ComposeUI", intent, false);
        a(iVar, "send_email:ok", null);
        return true;
    }

    private boolean w(i iVar) {
        if (bh.cgC()) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, GP Version not allowed to download");
            a(iVar, "system:access_denied", null);
            return true;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(157, 27, 1, false);
        String str = (String) iVar.pox.get("task_name");
        String str2 = (String) iVar.pox.get("task_url");
        String str3 = (String) iVar.pox.get("alternative_url");
        long j = bh.getLong((String) iVar.pox.get("task_size"), 0);
        String str4 = (String) iVar.pox.get("file_md5");
        String str5 = (String) iVar.pox.get("extInfo");
        String str6 = (String) iVar.pox.get("fileType");
        String str7 = (String) iVar.pox.get("appid");
        String str8 = (String) iVar.pox.get("package_name");
        int i = bh.getInt((String) iVar.pox.get("scene"), 1000);
        x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6 + ", reportScene = " + i);
        if (this.tHs != null) {
            int i2 = this.tHs.getInt("key_download_restrict", 0);
            if (!bh.ov(this.tHs.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14596, new Object[]{r14, Integer.valueOf(i2), Integer.valueOf(0)});
            }
            if (i2 == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to download file");
                a(iVar, "add_download_task_straight:fail", null);
                return true;
            }
        }
        ar.Hg();
        if (!com.tencent.mm.z.c.isSDCardAvailable()) {
            Toast.makeText(this.context, this.context.getString(R.l.emj), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_not_ready", null);
            u(str7, com.tencent.mm.plugin.downloader.model.d.lsb, str5);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, sdcard not ready");
            return true;
        } else if (j > 0 && !com.tencent.mm.compatible.util.f.aC(j)) {
            Toast.makeText(this.context, this.context.getString(R.l.emi), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_has_not_enough_space", null);
            u(str7, com.tencent.mm.plugin.downloader.model.d.lsb, str5);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, not enough space, require size = " + j);
            return true;
        } else if (bh.ov(str2)) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, url is null");
            a(iVar, "add_download_task_straight:fail_invalid_url", null);
            u(str7, com.tencent.mm.plugin.downloader.model.d.DOWNLOAD_ERR_URL_INVALID, str5);
            return true;
        } else {
            com.tencent.mm.sdk.b.b gpVar = new gp();
            gpVar.fwJ.url = str2;
            gpVar.fwJ.fqR = str4;
            gpVar.fwJ.extInfo = str5;
            gpVar.fwJ.appId = str7;
            gpVar.fwJ.scene = i;
            com.tencent.mm.sdk.b.a.xef.m(gpVar);
            g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
            com_tencent_mm_plugin_downloader_model_g_a.xL(str2);
            com_tencent_mm_plugin_downloader_model_g_a.xM(str3);
            com_tencent_mm_plugin_downloader_model_g_a.ci(j);
            com_tencent_mm_plugin_downloader_model_g_a.xN(str);
            com_tencent_mm_plugin_downloader_model_g_a.xO(str4);
            com_tencent_mm_plugin_downloader_model_g_a.setAppId(str7);
            com_tencent_mm_plugin_downloader_model_g_a.cu(str8);
            com_tencent_mm_plugin_downloader_model_g_a.ep(true);
            com_tencent_mm_plugin_downloader_model_g_a.ox(bh.getInt(str6, 1));
            com_tencent_mm_plugin_downloader_model_g_a.lw(i);
            long a = com.tencent.mm.plugin.downloader.model.f.aAd().a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, downloadId = " + a);
            if (a <= 0) {
                x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, downloadId = " + a);
                a(iVar, "add_download_task_straight:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("download_id", Long.valueOf(a));
                a(iVar, "add_download_task_straight:ok", hashMap);
            }
            return true;
        }
    }

    private static void u(String str, int i, String str2) {
        com.tencent.mm.sdk.b.b gtVar = new gt();
        gtVar.fwS.appId = str;
        gtVar.fwS.opType = 2;
        gtVar.fwS.fwT = i;
        gtVar.fwS.fqf = str2;
        com.tencent.mm.sdk.b.a.xef.m(gtVar);
    }

    private boolean x(i iVar) {
        long j = bh.getLong((String) iVar.pox.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doResumeDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doResumeDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "resume_download_task:fail", null);
        } else {
            boolean ca = com.tencent.mm.plugin.downloader.model.f.aAd().ca(j);
            x.i("MicroMsg.MsgHandler", "doResumeDownloadTask, ret = " + ca);
            if (ca) {
                a(iVar, "resume_download_task:ok", null);
            } else {
                a(iVar, "resume_download_task:fail", null);
            }
        }
        return true;
    }

    private boolean a(String str, i iVar) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str2;
                    String string = jSONArray.getString(i);
                    FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(string);
                    JSONObject jSONObject2 = new JSONObject();
                    switch (xI.status) {
                        case -1:
                            str2 = "api_not_support";
                            break;
                        case 1:
                            str2 = "downloading";
                            break;
                        case 2:
                            str2 = "download_pause";
                            break;
                        case 3:
                            if (!com.tencent.mm.a.e.bO(xI.path)) {
                                str2 = "default";
                                break;
                            }
                            str2 = "download_succ";
                            break;
                        case 4:
                            str2 = "download_fail";
                            break;
                        default:
                            str2 = "default";
                            break;
                    }
                    jSONObject2.put("download_id", xI.id);
                    jSONObject2.put("state", str2);
                    if (str2 == "downloading" && xI.fwg != 0) {
                        jSONObject2.put("progress", (xI.fwf / xI.fwg) * 100);
                    }
                    jSONObject.put(string, jSONObject2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                a(iVar, "query_download_task:ok", hashMap);
            } else {
                a(iVar, "query_download_task:fail", null);
            }
        } catch (JSONException e) {
            x.e("MicroMsg.MsgHandler", e.getMessage());
            a(iVar, "query_download_task:fail", null);
        }
        return true;
    }

    private boolean y(final i iVar) {
        String str;
        int i;
        IMediaObject wXAppExtendObject;
        WXMediaMessage wXMediaMessage;
        com.tencent.mm.sdk.b.b iqVar;
        if (this.tHs != null) {
            int i2 = this.tHs.getInt("key_download_restrict", 0);
            if (!bh.ov(this.tHs.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14596, new Object[]{r1, Integer.valueOf(i2), Integer.valueOf(1)});
            }
            if (i2 == 1) {
                x.e("MicroMsg.MsgHandler", "not allow tolaunch 3rd app");
                a(iVar, "launch_3rdApp:fail", null);
                return true;
            }
        }
        String str2 = (String) iVar.pox.get(DownloadSettingTable$Columns.TYPE);
        String str3 = (String) iVar.pox.get("appID");
        x.i("MicroMsg.MsgHandler", "lauchTimeInterval = %d", new Object[]{Long.valueOf(bh.Wo() - this.tHF)});
        String str4 = "";
        String str5 = "";
        if (bh.Wo() - this.tHF < 2 && this.tHF > 0) {
            try {
                str4 = this.fBH.aeq();
                str5 = this.tHB.PB(str4);
                str4 = URLEncoder.encode(str4, "UTF-8");
                com.tencent.mm.plugin.report.service.g.pQN.h(13983, new Object[]{Integer.valueOf(5), str4, ""});
                str = str4;
                str4 = str5;
            } catch (Exception e) {
                str4 = "";
                x.e("MicroMsg.MsgHandler", "report lauch3rd failed");
            }
            k.a(iVar.tJH, false, null, str3);
            if (!bh.ov(str2)) {
                try {
                    i = bh.getInt(str2, 0);
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "invalid type", new Object[]{e2.getMessage()});
                }
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
                if (i != 0) {
                    str2 = (String) iVar.pox.get("extInfo");
                    x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
                    if (!bh.ov(str3)) {
                        x.e("MicroMsg.MsgHandler", "appid is null or nil");
                        a(iVar, "launch_3rdApp:fail", null);
                    } else if (com.tencent.mm.plugin.webview.a.a.ift.m(ac.getContext(), str3)) {
                        x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                        a(iVar, "launch_3rdApp:fail", null);
                    } else {
                        wXAppExtendObject = new WXAppExtendObject();
                        wXAppExtendObject.extInfo = str2;
                        wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                        wXMediaMessage.sdkVer = 620823552;
                        wXMediaMessage.messageExt = str2;
                        iqVar = new iq();
                        iqVar.fza.fzc = wXMediaMessage;
                        iqVar.fza.appId = str3;
                        iqVar.fza.context = this.context;
                        iqVar.fza.fzd = new 45(this, iVar);
                        com.tencent.mm.sdk.b.a.xef.m(iqVar);
                    }
                } else if (i != 1) {
                    str2 = (String) iVar.pox.get("signature");
                    str3 = (String) iVar.pox.get(DownloadInfoColumns.PACKAGENAME);
                    x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.pox.get("param")});
                    if (!bh.ov(str2) || bh.ov(str3)) {
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                        a(iVar, "launch_3rdApp:fail_invalid_args", null);
                    } else if (com.tencent.mm.pluginsdk.model.app.p.m(this.context, str3)) {
                        Signature[] aX = com.tencent.mm.pluginsdk.model.app.p.aX(this.context, str3);
                        if (!(aX == null || aX[0] == null)) {
                            String s = com.tencent.mm.a.g.s(aX[0].toByteArray());
                            if (s != null && s.equalsIgnoreCase(str2)) {
                                try {
                                    Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(str3);
                                    if (launchIntentForPackage != null) {
                                        Bundle bundle = new Bundle();
                                        com.tencent.mm.pluginsdk.model.app.p.g(bundle, str5);
                                        launchIntentForPackage.putExtras(bundle);
                                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        bundle = new Bundle();
                                        bundle.putString("current_page_url", str);
                                        bundle.putString("current_page_appid", str4);
                                        com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage, null, new com.tencent.mm.pluginsdk.model.app.g.a(this) {
                                            final /* synthetic */ g tIj;

                                            public final void cG(boolean z) {
                                                this.tIj.a(iVar, "launch_3rdApp:ok", null);
                                            }
                                        }, bundle);
                                    }
                                } catch (Exception e3) {
                                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e3.getMessage()});
                                }
                                a(iVar, "launch_3rdApp:fail", null);
                            }
                        }
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                        a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                    } else {
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                        a(iVar, "launch_3rdApp:fail_not_install", null);
                    }
                } else {
                    a(iVar, "launch_3rdApp:fail_invalid_type", null);
                }
                return true;
            }
            i = 0;
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
            if (i != 0) {
                str2 = (String) iVar.pox.get("extInfo");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
                if (!bh.ov(str3)) {
                    x.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.ift.m(ac.getContext(), str3)) {
                    wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str2;
                    wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620823552;
                    wXMediaMessage.messageExt = str2;
                    iqVar = new iq();
                    iqVar.fza.fzc = wXMediaMessage;
                    iqVar.fza.appId = str3;
                    iqVar.fza.context = this.context;
                    iqVar.fza.fzd = new 45(this, iVar);
                    com.tencent.mm.sdk.b.a.xef.m(iqVar);
                } else {
                    x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                    a(iVar, "launch_3rdApp:fail", null);
                }
            } else if (i != 1) {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            } else {
                str2 = (String) iVar.pox.get("signature");
                str3 = (String) iVar.pox.get(DownloadInfoColumns.PACKAGENAME);
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.pox.get("param")});
                if (bh.ov(str2)) {
                }
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            }
            return true;
        }
        str = str4;
        str4 = str5;
        k.a(iVar.tJH, false, null, str3);
        if (bh.ov(str2)) {
            i = bh.getInt(str2, 0);
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
            if (i != 0) {
                str2 = (String) iVar.pox.get("extInfo");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
                if (!bh.ov(str3)) {
                    x.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.ift.m(ac.getContext(), str3)) {
                    x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                    a(iVar, "launch_3rdApp:fail", null);
                } else {
                    wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str2;
                    wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620823552;
                    wXMediaMessage.messageExt = str2;
                    iqVar = new iq();
                    iqVar.fza.fzc = wXMediaMessage;
                    iqVar.fza.appId = str3;
                    iqVar.fza.context = this.context;
                    iqVar.fza.fzd = new 45(this, iVar);
                    com.tencent.mm.sdk.b.a.xef.m(iqVar);
                }
            } else if (i != 1) {
                str2 = (String) iVar.pox.get("signature");
                str3 = (String) iVar.pox.get(DownloadInfoColumns.PACKAGENAME);
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.pox.get("param")});
                if (bh.ov(str2)) {
                }
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            } else {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            }
            return true;
        }
        i = 0;
        x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
        if (i != 0) {
            str2 = (String) iVar.pox.get("extInfo");
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
            if (!bh.ov(str3)) {
                x.e("MicroMsg.MsgHandler", "appid is null or nil");
                a(iVar, "launch_3rdApp:fail", null);
            } else if (com.tencent.mm.plugin.webview.a.a.ift.m(ac.getContext(), str3)) {
                wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = str2;
                wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823552;
                wXMediaMessage.messageExt = str2;
                iqVar = new iq();
                iqVar.fza.fzc = wXMediaMessage;
                iqVar.fza.appId = str3;
                iqVar.fza.context = this.context;
                iqVar.fza.fzd = new 45(this, iVar);
                com.tencent.mm.sdk.b.a.xef.m(iqVar);
            } else {
                x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                a(iVar, "launch_3rdApp:fail", null);
            }
        } else if (i != 1) {
            a(iVar, "launch_3rdApp:fail_invalid_type", null);
        } else {
            str2 = (String) iVar.pox.get("signature");
            str3 = (String) iVar.pox.get(DownloadInfoColumns.PACKAGENAME);
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.pox.get("param")});
            if (bh.ov(str2)) {
            }
            x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
            a(iVar, "launch_3rdApp:fail_invalid_args", null);
        }
        return true;
    }

    private boolean z(i iVar) {
        String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, url is null");
            a(iVar, "open_url_by_ext_browser:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                this.context.startActivity(intent);
                a(iVar, "open_url_by_ext_browser:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, e = " + e.getMessage());
                a(iVar, "open_url_by_ext_browser:fail", null);
            }
        }
        return true;
    }

    private static byte[] bUz() {
        try {
            com.tencent.mm.sdk.platformtools.h hVar = new com.tencent.mm.sdk.platformtools.h("softtype");
            x.d("MicroMsg.AndroidDevicesReport", "cpu %s", new Object[]{bh.az((String) com.tencent.mm.compatible.d.n.yt().get("Processor"), "")});
            hVar.bG("cpu", r0);
            hVar.bG(TencentLocationListener.RADIO, com.tencent.mm.compatible.d.q.yM());
            hVar.bG("osversion", VERSION.RELEASE);
            String deviceID = com.tencent.mm.compatible.d.q.getDeviceID(ac.getContext());
            String yO = com.tencent.mm.compatible.d.q.yO();
            String yP = com.tencent.mm.compatible.d.q.yP();
            hVar.bG("deviceId", deviceID);
            hVar.bG("imsi", yO);
            hVar.bG("iccid", yP);
            hVar.bG("androidid", com.tencent.mm.compatible.d.q.getAndroidId());
            hVar.bG("serial", com.tencent.mm.compatible.d.q.yQ());
            hVar.bG("model", com.tencent.mm.compatible.d.q.yJ());
            hVar.bG("core_count", com.tencent.mm.compatible.d.n.yy());
            hVar.bG("cpuhardware", bh.az((String) com.tencent.mm.compatible.d.n.yz().get("Hardware"), ""));
            hVar.bG("cpureversion", bh.az((String) com.tencent.mm.compatible.d.n.yz().get("CPU revision"), ""));
            hVar.bG("cpuserial", bh.az((String) com.tencent.mm.compatible.d.n.yz().get("Serial"), ""));
            hVar.bG("Features", bh.az((String) com.tencent.mm.compatible.d.n.yz().get("Features"), ""));
            hVar.bG("wifi-mac", bh.az(com.tencent.mm.compatible.d.q.yG(), ""));
            hVar.bG("bluetooth", bh.az(com.tencent.mm.compatible.d.q.yH(), ""));
            if (!bh.ov(hVar.xeE)) {
                hVar.vt(hVar.xeE);
                hVar.xeE = "";
            }
            x.d("MicroMsg.AndroidDevicesReport", "xmlStr %s", new Object[]{hVar.kmW.toString()});
            x.i("MicroMsg.MsgHandler", "xml %s", new Object[]{deviceID});
            bot com_tencent_mm_protocal_c_bot = new bot();
            com_tencent_mm_protocal_c_bot.wRg = com.tencent.mm.bq.b.bc(com.tencent.mm.compatible.d.q.yF().getBytes()).CD(16);
            x.i("MicroMsg.MsgHandler", bh.by(com_tencent_mm_protocal_c_bot.wRg.oz));
            com_tencent_mm_protocal_c_bot.wRh = deviceID;
            SharedPreferences Hn = as.Hn();
            x.i("MicroMsg.MsgHandler", "cpan aak string:%s md5:%s uin:%d", new Object[]{bh.by(r2), com.tencent.mm.a.g.s(bh.VD(Hn.getString("_auth_key", ""))), Integer.valueOf(Hn.getInt("_auth_uin", 0))});
            x.i("MicroMsg.MsgHandler", "aat len:%d", new Object[]{Integer.valueOf(r2.length)});
            com_tencent_mm_protocal_c_bot.wRi = com.tencent.mm.bq.b.bc(r2);
            com_tencent_mm_protocal_c_bot.uin = r0;
            com.tencent.mm.protocal.ac cdL = com.tencent.mm.protocal.ac.cdL();
            byte[] toByteArray = com_tencent_mm_protocal_c_bot.toByteArray();
            PByteArray pByteArray = new PByteArray();
            if (MMProtocalJni.rsaPublicEncrypt(toByteArray, pByteArray, cdL.vBY.getBytes(), cdL.vBZ.getBytes())) {
                toByteArray = pByteArray.value;
            }
            x.d("MicroMsg.MsgHandler", "cpan buf string:%s ", new Object[]{bh.by(toByteArray)});
            bou com_tencent_mm_protocal_c_bou = new bou();
            com_tencent_mm_protocal_c_bou.wRk = cdL.ver;
            com_tencent_mm_protocal_c_bou.wRj = com.tencent.mm.protocal.d.vAz;
            com_tencent_mm_protocal_c_bou.wRl = com.tencent.mm.protocal.d.DEVICE_TYPE;
            com_tencent_mm_protocal_c_bou.wRm = com.tencent.mm.bq.b.bc(toByteArray);
            x.i("MicroMsg.MsgHandler", "getdevice done");
            return com_tencent_mm_protocal_c_bou.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.MsgHandler", "report error");
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            return null;
        }
    }

    private boolean A(i iVar) {
        String str = "";
        try {
            str = this.fBH.aeq();
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
        }
        x.i("MicroMsg.MsgHandler", "currentUrl %s", new Object[]{str});
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            Object obj = "";
            Map hashMap = new HashMap();
            try {
                x.i("MicroMsg.MsgHandler", "getDeviceInfo");
                obj = Base64.encodeToString(bUz(), 0);
            } catch (Throwable e2) {
                x.e("MicroMsg.MsgHandler", "device info get error %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            hashMap.put("securityInfo", obj);
            a(iVar, "mmsf0001:ok", hashMap);
        } else {
            a(iVar, "system:access_denied", null);
        }
        return true;
    }

    private boolean B(i iVar) {
        Map map = null;
        if (this.context instanceof MMActivity) {
            String aeq;
            x.d("MicroMsg.MsgHandler", "doJumpToBizProfile %s, %s", new Object[]{(String) iVar.pox.get("tousername"), (String) iVar.pox.get("extmsg")});
            try {
                aeq = this.fBH.aeq();
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
            }
            Intent intent = new Intent();
            intent.putExtra("toUserName", r0);
            intent.putExtra("extInfo", r1);
            intent.putExtra("fromURL", aeq);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.ifs.a(intent, (a) this, (MMActivity) this.context);
        } else {
            a(iVar, "jump_to_biz_profile:fail", map);
        }
        return true;
    }

    private boolean C(i iVar) {
        x.i("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo, switch value : %s, title_cn : %s, title_eng : %s, ok_cn : %s,  ok_eng : %s,  cancel_cn : %s,  cancel_eng : %s", new Object[]{(String) iVar.pox.get("switch"), (String) iVar.pox.get("title_cn"), (String) iVar.pox.get("title_eng"), (String) iVar.pox.get("ok_cn"), (String) iVar.pox.get("ok_eng"), (String) iVar.pox.get("cancel_cn"), (String) iVar.pox.get("cancel_eng")});
        Bundle bundle = new Bundle();
        bundle.putString("close_window_confirm_dialog_switch", r0);
        bundle.putString("close_window_confirm_dialog_title_cn", r1);
        bundle.putString("close_window_confirm_dialog_title_eng", r2);
        bundle.putString("close_window_confirm_dialog_ok_cn", r3);
        bundle.putString("close_window_confirm_dialog_ok_eng", r4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", r5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", r6);
        try {
            this.fBH.n(13, bundle);
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
        }
        a(iVar, "setCloseWindowConfirmDialogInfo:ok", null);
        return true;
    }

    private boolean d(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.pox.get("verifyAppId");
        String str2 = (String) iVar.pox.get("verifyJsApiList");
        x.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI, appid : %s, %s, %s, %s, %s", new Object[]{str, (String) iVar.pox.get("verifySignature"), (String) iVar.pox.get("verifyNonceStr"), (String) iVar.pox.get("verifyTimestamp"), (String) iVar.pox.get("verifySignType")});
        k.a(iVar.tJH, false, null, str);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            x.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI jsItem length %s", new Object[]{Integer.valueOf(jSONArray.length())});
            if (jSONArray.length() == 0) {
                a(iVar, "checkJsApi:param is empty", null);
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (!bh.ov(string)) {
                    linkedList.add(string);
                }
            }
            String aeq = this.fBH.aeq();
            int i2 = 0;
            String str3 = "";
            try {
                Bundle e = this.fBH.e(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX, null);
                i2 = e.getInt("key_webview_preverify_info_scene", 0);
                str3 = e.getString("key_webview_preverify_info_source_appid", "");
            } catch (Exception e2) {
                x.e("TAG", "doPreVerifyJSAPI: %s", new Object[]{e2});
            }
            Object obj = this.tHB;
            c$a 49 = new 49(this, jsapiPermissionWrapper, iVar);
            if (bh.ov(str) || linkedList.size() <= 0) {
                x.e("MicroMsg.webview.JSVerifyHelper", "handlePreVerify wrong args, %s", new Object[]{str});
                49.a(c$a.a.RET_FAIL, null, null, 0, 0);
            } else {
                ar.CG().a(1093, obj);
                ar.CG().a(new com.tencent.mm.plugin.webview.model.m(49, aeq, str, linkedList, r9, r10, r11, r12, i2, str3, obj.tsc), 0);
            }
            return true;
        } catch (Exception e22) {
            x.w("MicroMsg.MsgHandler", "exception occur " + e22.getMessage());
            a(iVar, "pre_verify_jsapi:fail", null);
            return true;
        }
    }

    private boolean D(i iVar) {
        Map hashMap = new HashMap();
        try {
            com.tencent.mm.sdk.b.b dcVar = new dc();
            dcVar.frx.fro = true;
            com.tencent.mm.sdk.b.a.xef.m(dcVar);
            if (dcVar.fry.frp) {
                hashMap.put("currentSSID", dcVar.fry.frz);
                a(iVar, "getCurrentSSID:ok", hashMap);
            } else {
                hashMap.put("err_desc", "not on wifi");
                a(iVar, "getCurrentSSID:fail", hashMap);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "getCurrentSSID:fail");
            hashMap.put("err_desc", "not on wifi");
            a(iVar, "getCurrentSSID:fail", hashMap);
        }
        return true;
    }

    private boolean E(i iVar) {
        int bSd = bSd();
        int aRr = aRr();
        String bUA = bUA();
        x.i("MicroMsg.MsgHandler", "Key Scene(%d)", new Object[]{Integer.valueOf(aRr)});
        if (aRr == 27) {
            this.tHt = (String) iVar.pox.get("brandUserName");
            x.i("MicroMsg.MsgHandler", "BrandUserName from shake(%s)", new Object[]{this.tHt});
        } else if (!(bSd == 8 || bSd == -1)) {
            this.kGH = (String) iVar.pox.get("brandUserName");
            x.i("MicroMsg.MsgHandler", "BrandUserName from H5(%s)", new Object[]{this.kGH});
            if (!(bh.ov(bUA) || bh.ov(this.kGH))) {
                x.i("MicroMsg.MsgHandler", "Chat name(%s)", new Object[]{bUA});
                com.tencent.mm.ag.d jS = com.tencent.mm.ag.f.jS(bUA);
                if (jS != null) {
                    com.tencent.mm.ag.d.b bI = jS.bI(false);
                    if (!(bI == null || bI.Ly() == null || !bI.Ly().LH() || bUA.equals(this.kGH))) {
                        a(iVar, "openWXDeviceLib:fail_UsernameError", null);
                        return true;
                    }
                }
            }
        }
        bUA = O(iVar);
        x.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{bUA});
        if (bh.ov(bUA)) {
            a(iVar, "openWXDeviceLib:fail_UsernameError", null);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{bUA, "openWXDeviceLib"});
            String str = "";
            if (iVar.pox.containsKey("connType")) {
                str = (String) iVar.pox.get("connType");
            }
            Object obj;
            if (str.equalsIgnoreCase("lan")) {
                if (this.tHv == null) {
                    this.tHv = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.a bTn = com.tencent.mm.plugin.webview.ui.tools.a.a.bTn();
                    e eVar = this.fBH;
                    x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "tryInit");
                    if (bTn.tBM == null) {
                        bTn.tBM = new a$a(eVar, bUA);
                        com.tencent.mm.sdk.b.a.xef.b(bTn.tBM.tBR);
                        com.tencent.mm.sdk.b.a.xef.b(bTn.tBM.tBS);
                        com.tencent.mm.sdk.b.a.xef.b(bTn.tBM.tBU);
                        com.tencent.mm.sdk.b.a.xef.b(bTn.tBM.tBT);
                        com.tencent.mm.sdk.b.a.xef.b(bTn.tBM.tBV);
                    }
                    com.tencent.mm.sdk.b.b dvVar = new dv();
                    dvVar.fst.fro = true;
                    com.tencent.mm.sdk.b.a.xef.m(dvVar);
                    bTn.hasInit = true;
                    bTn.frn = bUA;
                    bTn.tBO = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.a.bTn());
                    if (an.isWifi(this.context)) {
                        obj = "on";
                    } else {
                        obj = "off";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("minVersion", Integer.valueOf(1));
                    hashMap.put("maxVersion", Integer.valueOf(1));
                    hashMap.put("lanState", obj);
                    a(iVar, "openWXDeviceLib:ok", hashMap);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            } else {
                if (this.tHu == null) {
                    this.tHu = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.b bTq = com.tencent.mm.plugin.webview.ui.tools.a.b.bTq();
                    e eVar2 = this.fBH;
                    x.i("MicroMsg.webview.WebViewExDeviceMgr", "tryInit");
                    if (bTq.tBX == null) {
                        bTq.tBX = new com.tencent.mm.plugin.webview.ui.tools.a.b.a(eVar2, bUA);
                        com.tencent.mm.sdk.b.a.xef.b(bTq.tBX.tCb);
                        com.tencent.mm.sdk.b.a.xef.b(bTq.tBX.tCc);
                        com.tencent.mm.sdk.b.a.xef.b(bTq.tBX.tCd);
                        com.tencent.mm.sdk.b.a.xef.b(bTq.tBX.tBR);
                        com.tencent.mm.sdk.b.a.xef.b(bTq.tBX.qsg);
                    }
                    com.tencent.mm.sdk.b.b dpVar = new dp();
                    dpVar.fsm.op = 1;
                    com.tencent.mm.sdk.b.a.xef.m(dpVar);
                    bTq.hasInit = true;
                    bTq.frn = bUA;
                    bTq.tBO = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.b.bTq());
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        obj = "unknow";
                        switch (defaultAdapter.getState()) {
                            case 10:
                                obj = "off";
                                break;
                            case 11:
                                obj = "resetting";
                                break;
                            case 12:
                                obj = "on";
                                break;
                            default:
                                break;
                        }
                    }
                    obj = "unknow";
                    x.i("MicroMsg.webview.ExDeviceBluetoothUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(ac.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
                    Map hashMap2 = new HashMap();
                    hashMap2.put("minVersion", Integer.valueOf(1));
                    hashMap2.put("maxVersion", Integer.valueOf(1));
                    hashMap2.put("bluetoothState", obj);
                    hashMap2.put("isSupportBLE", ac.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "yes" : "no");
                    if (bSd == 1) {
                        hashMap2.put("OS", "android");
                    }
                    a(iVar, "openWXDeviceLib:ok", hashMap2);
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            }
        }
        return true;
    }

    private boolean F(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().bTo();
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        } else {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().bTo();
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        }
        a(iVar, "closeWXDeviceLib:ok", null);
        return true;
    }

    private boolean G(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
                try {
                    x.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{O(iVar)});
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "startScanWXDevice"});
                    if (bh.ov(O(iVar))) {
                        a(iVar, "startScanWXDevice:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b emVar = new em();
                        emVar.ftd.fro = true;
                        com.tencent.mm.sdk.b.a.xef.m(emVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().tBQ = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "startScanWXDevice:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
                a(iVar, "startScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.compatible.util.f.fM(23) && !((LocationManager) this.context.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            x.d("MicroMsg.MsgHandler", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
            x.e("MicroMsg.MsgHandler", "ScannerInThisAndroidVersionRequireGPSServiceOn");
            a(iVar, "startScanWXDevice:fail_ThisAndroidVersionRequireGPSServiceOn", null);
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            try {
                String O = O(iVar);
                str = (String) iVar.pox.get("btVersion");
                x.i("MicroMsg.MsgHandler", "BtVersion(%s), srcUsername(%s)", new Object[]{str, O});
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "startScanWXDevice"});
                if (bh.ov(O)) {
                    a(iVar, "startScanWXDevice:fail_UsernameError", null);
                } else {
                    com.tencent.mm.sdk.b.b dwVar = new dw();
                    dwVar.fsu.fro = true;
                    dwVar.fsu.frn = O;
                    if (bh.ou(str).equals("ble")) {
                        dwVar.fsu.fsw = 0;
                    } else if (bh.ou(str).equals("bc")) {
                        dwVar.fsu.fsw = 1;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().tBZ = dwVar.fsu.fsw;
                    com.tencent.mm.sdk.b.a.xef.m(dwVar);
                    if (dwVar.fsv.frp) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().tBQ = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    } else {
                        a(iVar, "startScanWXDevice:fail", null);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "startScanWXDevice:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
            a(iVar, "startScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean H(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
                try {
                    str = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "stopScanWXDevice"});
                    if (bh.ov(str)) {
                        a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b emVar = new em();
                        emVar.ftd.fro = false;
                        com.tencent.mm.sdk.b.a.xef.m(emVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().tBQ = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    x.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "stopScanWXDevice:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
                a(iVar, "stopScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "stopScanWXDevice"});
                if (bh.ov(str)) {
                    a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                } else {
                    com.tencent.mm.sdk.b.b dwVar = new dw();
                    dwVar.fsu.fro = false;
                    dwVar.fsu.frn = str;
                    dwVar.fsu.fsw = com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().tBZ;
                    com.tencent.mm.sdk.b.a.xef.m(dwVar);
                    if (dwVar.fsv.frp) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().tBQ = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    } else {
                        x.e("MicroMsg.MsgHandler", "stopScanWXDevice fail");
                        a(iVar, "stopScanWXDevice:fail", null);
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                x.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "stopScanWXDevice:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
            a(iVar, "stopScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean I(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        String O;
        com.tencent.mm.sdk.b.b czVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
                str = (String) iVar.pox.get("deviceId");
                x.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
                if (bh.ov(str)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "connectWXDevice:fail_noDeviceId", null);
                } else {
                    O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "connectWXDevice"});
                    if (bh.ov(O)) {
                        a(iVar, "connectWXDevice:fail_UsernameError", null);
                    } else {
                        if (!(this.tHv == null || this.tHv.containsKey(O))) {
                            this.tHv.put(O, str);
                        }
                        try {
                            czVar = new cz();
                            czVar.frq.fro = true;
                            czVar.frq.frn = O;
                            czVar.frq.ffq = str;
                            com.tencent.mm.sdk.b.a.xef.m(czVar);
                            if (czVar.frr.frp) {
                                a(iVar, "connectWXDevice:ok", null);
                            } else {
                                a(iVar, "connectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(iVar, "connectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "connectWXDevice not init");
                a(iVar, "connectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            str = (String) iVar.pox.get("deviceId");
            x.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
            if (bh.ov(str)) {
                x.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "connectWXDevice:fail_noDeviceId", null);
            } else {
                O = O(iVar);
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "connectWXDevice"});
                if (bh.ov(O)) {
                    a(iVar, "connectWXDevice:fail_UsernameError", null);
                } else {
                    if (!(this.tHu == null || this.tHu.containsValue(str))) {
                        this.tHu.put(O, str);
                    }
                    try {
                        czVar = new cy();
                        czVar.frl.fro = true;
                        czVar.frl.frn = O;
                        czVar.frl.ffq = str;
                        com.tencent.mm.sdk.b.a.xef.m(czVar);
                        if (czVar.frm.frp) {
                            a(iVar, "connectWXDevice:ok", null);
                        } else {
                            a(iVar, "connectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(iVar, "connectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "connectWXDevice not init");
            a(iVar, "connectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean J(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        String O;
        com.tencent.mm.sdk.b.b czVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
                str = (String) iVar.pox.get("deviceId");
                x.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
                if (bh.ov(str)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
                } else {
                    O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "disconnectWXDevice"});
                    if (bh.ov(O)) {
                        a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                    } else {
                        try {
                            czVar = new cz();
                            czVar.frq.fro = false;
                            czVar.frq.frn = O;
                            czVar.frq.ffq = str;
                            com.tencent.mm.sdk.b.a.xef.m(czVar);
                            if (czVar.frr.frp) {
                                a(iVar, "disconnectWXDevice:ok", null);
                                if (this.tHv != null && this.tHv.containsKey(O)) {
                                    this.tHv.remove(O);
                                }
                            } else {
                                a(iVar, "disconnectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(iVar, "disconnectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
                a(iVar, "disconnectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            str = (String) iVar.pox.get("deviceId");
            x.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
            if (bh.ov(str)) {
                x.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
            } else {
                O = O(iVar);
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "disconnectWXDevice"});
                if (bh.ov(O)) {
                    a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                } else {
                    try {
                        czVar = new cy();
                        czVar.frl.fro = false;
                        czVar.frl.frn = O;
                        czVar.frl.ffq = str;
                        com.tencent.mm.sdk.b.a.xef.m(czVar);
                        if (czVar.frm.frp) {
                            a(iVar, "disconnectWXDevice:ok", null);
                            if (this.tHu != null && this.tHu.containsKey(O)) {
                                this.tHu.remove(O);
                            }
                        } else {
                            a(iVar, "disconnectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(iVar, "disconnectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
            a(iVar, "disconnectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean K(i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit || com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
            String str = (String) iVar.pox.get("deviceId");
            String str2 = (String) iVar.pox.get(DownloadSettingTable$Columns.TYPE);
            x.i("MicroMsg.MsgHandler", "doGetWXDeviceTicket, deviceId : %s, type : %s", new Object[]{str, str2});
            if (bh.ov(str) || bh.ov(str2)) {
                x.e("MicroMsg.MsgHandler", "deviceId or type is null");
                a(iVar, "getWXDeviceTicket:fail_wrongParams", null);
            } else {
                try {
                    String O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "getWXDeviceTicket"});
                    if (bh.ov(O)) {
                        a(iVar, "getWXDeviceTicket:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b dgVar = new dg();
                        dgVar.frL.type = bh.getInt(str2, 0);
                        dgVar.frL.frn = O;
                        dgVar.frL.ffq = str;
                        dgVar.frL.frN = iVar.tJG;
                        dgVar.fqI = new 51(this, dgVar, iVar);
                        com.tencent.mm.sdk.b.a.xef.a(dgVar, Looper.getMainLooper());
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "getWXDeviceTicket failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "getWXDeviceTicket:fail_exception", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "getWXDeviceTicket not init");
            a(iVar, "getWXDeviceTicket:fail_notInit", null);
        }
        return true;
    }

    private boolean L(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        com.tencent.mm.sdk.b.b deVar;
        Map hashMap;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
                try {
                    str = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "getWXDeviceInfos"});
                    x.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                    if (bh.ov(str)) {
                        a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                    } else {
                        deVar = new de();
                        deVar.frD.frn = str;
                        deVar.frD.context = this.context;
                        com.tencent.mm.sdk.b.a.xef.m(deVar);
                        if (!deVar.frE.frp || deVar.frE.frC == null) {
                            a(iVar, "getWXDeviceInfos:fail", null);
                        } else {
                            hashMap = new HashMap();
                            hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                            hashMap.put("deviceInfos", deVar.frE.frC.toString());
                            a(iVar, "getWXDeviceInfos:ok", hashMap);
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "getWXDeviceInfos:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
                a(iVar, "getWXDeviceInfos:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            try {
                str = O(iVar);
                com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{str, "getWXDeviceInfos"});
                x.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                if (bh.ov(str)) {
                    a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                } else {
                    deVar = new dd();
                    deVar.frA.frn = str;
                    deVar.frA.context = this.context;
                    com.tencent.mm.sdk.b.a.xef.m(deVar);
                    if (!deVar.frB.frp || deVar.frB.frC == null) {
                        a(iVar, "getWXDeviceInfos:fail", null);
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                        hashMap.put("deviceInfos", deVar.frB.frC.toString());
                        a(iVar, "getWXDeviceInfos:ok", hashMap);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "getWXDeviceInfos:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
            a(iVar, "getWXDeviceInfos:fail_notInit", null);
        }
        return true;
    }

    private boolean M(i iVar) {
        String str = "";
        if (iVar.pox.containsKey("connType")) {
            str = (String) iVar.pox.get("connType");
        }
        String str2;
        String str3;
        String str4;
        Object[] objArr;
        boolean z;
        String O;
        com.tencent.mm.sdk.b.b dzVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bTn().hasInit) {
                str = (String) iVar.pox.get("deviceId");
                str2 = (String) iVar.pox.get("base64Data");
                str3 = "MicroMsg.MsgHandler";
                str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
                objArr = new Object[2];
                objArr[0] = str;
                if (bh.ov(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.i(str3, str4, objArr);
                if (bh.ov(str) || str2 == null) {
                    x.e("MicroMsg.MsgHandler", "deviceId or data is null");
                    a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
                } else {
                    try {
                        O = O(iVar);
                        com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "sendDataToWXDevice"});
                        if (bh.ov(O)) {
                            a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                        } else {
                            dzVar = new dz();
                            dzVar.fsB.frn = O;
                            dzVar.fsB.data = str2;
                            dzVar.fsB.ffq = str;
                            com.tencent.mm.sdk.b.a.xef.m(dzVar);
                            if (dzVar.fsC.frp) {
                                a(iVar, "sendDataToWXDevice:ok", null);
                            } else {
                                a(iVar, "sendDataToWXDevice:fail", null);
                            }
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e.getMessage()});
                        a(iVar, "sendDataToWXDevice:fail_exception", null);
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
                a(iVar, "sendDataToWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            str = (String) iVar.pox.get("deviceId");
            str2 = (String) iVar.pox.get("base64Data");
            str3 = "MicroMsg.MsgHandler";
            str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
            objArr = new Object[2];
            objArr[0] = str;
            if (bh.ov(str2)) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str3, str4, objArr);
            if (bh.ov(str) || str2 == null) {
                x.e("MicroMsg.MsgHandler", "deviceId or data is null");
                a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
            } else {
                try {
                    O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "sendDataToWXDevice"});
                    if (bh.ov(O)) {
                        a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                    } else {
                        dzVar = new dy();
                        dzVar.fsz.frn = O;
                        dzVar.fsz.data = Base64.decode(str2, 0);
                        dzVar.fsz.ffq = str;
                        com.tencent.mm.sdk.b.a.xef.m(dzVar);
                        if (dzVar.fsA.frp) {
                            a(iVar, "sendDataToWXDevice:ok", null);
                        } else {
                            a(iVar, "sendDataToWXDevice:fail", null);
                        }
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e2.getMessage()});
                    a(iVar, "sendDataToWXDevice:fail_exception", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
            a(iVar, "sendDataToWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean N(i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bTq().hasInit) {
            try {
                String str = (String) iVar.pox.get("deviceId");
                String str2 = (String) iVar.pox.get(TencentLocation.EXTRA_DIRECTION);
                x.i("MicroMsg.MsgHandler", "setSendDataDirection, deviceId = %s, direction = %s", new Object[]{str, str2});
                if (bh.ov(str) || bh.ov(str2)) {
                    x.e("MicroMsg.MsgHandler", "wrong args");
                    a(iVar, "setSendDataDirection:fail_wrongParams", null);
                } else {
                    int i = bh.getInt(str2, 0);
                    String O = O(iVar);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11533, new Object[]{O, "setSendDataDirection"});
                    if (bh.ov(O)) {
                        a(iVar, "setSendDataDirection:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b ecVar = new ec();
                        ecVar.fsL.ffq = str;
                        ecVar.fsL.direction = i;
                        ecVar.fsL.clear = false;
                        com.tencent.mm.sdk.b.a.xef.m(ecVar);
                        if (ecVar.fsM.frp) {
                            a(iVar, "setSendDataDirection:ok", null);
                        } else {
                            a(iVar, "setSendDataDirection:fail", null);
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "setSendDataDirection failed : %s", new Object[]{e.getMessage()});
                a(iVar, "setSendDataDirection:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "setSendDataDirection not init");
            a(iVar, "setSendDataDirection:fail_notInit", null);
        }
        return true;
    }

    public String bUA() {
        String str = null;
        try {
            if (this.fBH != null) {
                Bundle e = this.fBH.e(18, null);
                if (e != null) {
                    str = e.getString("preChatName");
                }
            }
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e2});
        }
        return str;
    }

    public int bSd() {
        int i = -1;
        try {
            if (this.fBH != null) {
                Bundle e = this.fBH.e(22, null);
                if (e != null) {
                    i = e.getInt("pay_channel");
                }
            }
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e2});
        }
        return i;
    }

    public int aRr() {
        int i = 0;
        try {
            if (this.fBH != null) {
                Bundle e = this.fBH.e(25, null);
                if (e != null) {
                    i = e.getInt("scene");
                }
            }
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e2});
        }
        return i;
    }

    private int ahG() {
        int i = 0;
        try {
            if (this.fBH != null) {
                Bundle e = this.fBH.e(99, null);
                if (e != null) {
                    i = e.getInt("geta8key_scene");
                }
            }
        } catch (RemoteException e2) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e2});
        }
        return i;
    }

    private String O(i iVar) {
        String bUA = bUA();
        if (aRr() == 27) {
            return this.tHt;
        }
        String str;
        if (bSd() == 8 || bSd() == -1) {
            if (iVar == null) {
                return null;
            }
            str = (String) iVar.pox.get("src_username");
            x.i("MicroMsg.MsgHandler", "key_src_username(%s)", new Object[]{(String) iVar.pox.get("src_username")});
            return str;
        } else if (this.kGH != null) {
            return this.kGH;
        } else {
            if (bh.ov(bUA)) {
                return null;
            }
            x.i("MicroMsg.MsgHandler", "BrandUsername in H5 is null, check if it is in hardBiz chat");
            com.tencent.mm.ag.d jS = com.tencent.mm.ag.f.jS(bUA);
            if (jS == null) {
                return null;
            }
            com.tencent.mm.ag.d.b bI = jS.bI(false);
            if (bI == null || bI.Ly() == null || !bI.Ly().LH()) {
                return null;
            }
            str = (String) iVar.pox.get("src_username");
            x.i("MicroMsg.MsgHandler", "HardBiz chat, key_src_username(%s)", new Object[]{(String) iVar.pox.get("src_username")});
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean P(i iVar) {
        int i;
        int i2;
        Boolean bool;
        int i3;
        Serializable valueOf;
        Intent intent;
        String str = (String) iVar.pox.get("sourceType");
        x.i("MicroMsg.MsgHandler", "source Type = %s", new Object[]{str});
        if (bh.ov(str)) {
            i = 0;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                i2 = 0;
                i = 0;
                while (i2 < jSONArray.length()) {
                    try {
                        if (jSONArray.getString(i2).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                            i |= 1;
                        } else if (jSONArray.getString(i2).equals("camera")) {
                            i |= 2;
                        }
                        i2++;
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                i = 0;
                x.e("MicroMsg.MsgHandler", "doChooseImage: sizeType parsing error");
                if (i != 0) {
                    i2 = i;
                } else {
                    i2 = 3;
                }
                x.i("MicroMsg.MsgHandler", "real scene = %d", new Object[]{Integer.valueOf(i2)});
                x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 113, "", ""))});
            }
        }
        if (i != 0) {
            i2 = 3;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.MsgHandler", "real scene = %d", new Object[]{Integer.valueOf(i2)});
        if (i2 == 2 || i2 == 3) {
            x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 113, "", ""))});
        }
        int i4 = bh.getInt((String) iVar.pox.get("count"), 0);
        str = (String) iVar.pox.get("sizeType");
        Boolean valueOf2 = Boolean.valueOf(false);
        Boolean valueOf3 = Boolean.valueOf(false);
        if (bh.ov(str)) {
            bool = valueOf3;
            valueOf3 = valueOf2;
        } else {
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                bool = valueOf3;
                valueOf3 = valueOf2;
                i3 = 0;
                while (i3 < jSONArray2.length()) {
                    try {
                        if (jSONArray2.getString(i3).equals("original")) {
                            valueOf3 = Boolean.valueOf(true);
                        } else if (jSONArray2.getString(i3).equals("compressed")) {
                            bool = Boolean.valueOf(true);
                        }
                        i3++;
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
                bool = valueOf3;
                valueOf3 = valueOf2;
                x.e("MicroMsg.MsgHandler", "doChooseImage: sizeType parsing error");
                if (!valueOf3.booleanValue()) {
                }
                if (!valueOf3.booleanValue()) {
                }
                valueOf = Boolean.valueOf(false);
                i3 = 8;
                intent = new Intent();
                intent.putExtra("key_pick_local_pic_capture", i2);
                intent.putExtra("key_pick_local_pic_count", i4);
                intent.putExtra("key_pick_local_pic_query_source_type", i3);
                intent.putExtra("key_pick_local_pic_send_raw", valueOf);
                intent.putExtra("query_media_type", 1);
                x.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), valueOf});
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).jwN = this;
                    com.tencent.mm.bm.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
                }
                return true;
            }
        }
        if (!valueOf3.booleanValue() && !r0.booleanValue()) {
            valueOf = Boolean.valueOf(true);
            i3 = 7;
        } else if (valueOf3.booleanValue() || !r0.booleanValue()) {
            valueOf = Boolean.valueOf(false);
            i3 = 8;
        } else {
            valueOf = Boolean.valueOf(false);
            i3 = 7;
        }
        intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i2);
        intent.putExtra("key_pick_local_pic_count", i4);
        intent.putExtra("key_pick_local_pic_query_source_type", i3);
        intent.putExtra("key_pick_local_pic_send_raw", valueOf);
        intent.putExtra("query_media_type", 1);
        x.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), valueOf});
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
        }
        return true;
    }

    private boolean Q(i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.tJH, false, null, str);
            x.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bh.ov(str) || bh.ov(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadImage:fail_missing arguments", null);
            } else {
                a(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadImage", z);
            }
            return true;
        }
        z = true;
        k.a(iVar.tJH, false, null, str);
        x.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadImage:fail_missing arguments", null);
        return true;
    }

    private boolean R(final i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("appId");
        final String str2 = (String) iVar.pox.get("serverId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.tJH, false, null, str);
            x.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
            if (!bh.ov(str) || bh.ov(str2)) {
                a(iVar, "downloadImage:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.model.c.b 53 = new 53(this, str2, iVar);
                com.tencent.mm.plugin.webview.modeltools.f.bRA().a(str, str2, 53);
                x.i("MicroMsg.MsgHandler", "doDownLoadImage, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dGO);
                    this.iln = h.a(context, this.context.getString(R.l.eYj), true, new OnCancelListener(this) {
                        final /* synthetic */ g tIj;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.modeltools.f.bRA().a(53);
                            com.tencent.mm.plugin.webview.modeltools.f.bRA();
                            com.tencent.mm.plugin.webview.model.ac.Ok(str2);
                            this.tIj.a(iVar, "downloadImage:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        k.a(iVar.tJH, false, null, str);
        x.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
        if (bh.ov(str)) {
        }
        a(iVar, "downloadImage:fail_missing arguments", null);
        return true;
    }

    private boolean S(i iVar) {
        boolean z;
        x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile()");
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bh.ov(str) && !bh.ov(str2)) {
                k.a(iVar.tJH, false, null, str);
                WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
                if (Oo != null) {
                    switch (Oo.ftE) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.hrN, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hrN, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hrN, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                    }
                }
                x.e("MicroMsg.MsgHandler", "jssdk file item is null for localId:%s", new Object[]{str2});
                a(iVar, "uploadEncryptMediaFile:file_not_exist", null);
            } else {
                x.e("MicroMsg.MsgHandler", "appId or localid is null");
                a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null");
        a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
        return true;
    }

    private boolean T(final i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseMedia()");
        x.i("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", ""))});
        if (!com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", "")) {
            return true;
        }
        x.i("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", ""))});
        if (!com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")) {
            return true;
        }
        int i;
        String str;
        String ou = bh.ou((String) iVar.pox.get("sourceType"));
        String ou2 = bh.ou((String) iVar.pox.get("mediaType"));
        int min = Math.min(bh.getInt((String) iVar.pox.get("maxDuration"), 10), 10);
        final String ou3 = bh.ou((String) iVar.pox.get("camera"));
        int i2 = bh.getInt((String) iVar.pox.get("count"), 1);
        String ou4 = bh.ou((String) iVar.pox.get("sizeType"));
        x.i("MicroMsg.MsgHandler", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{ou, ou2, Integer.valueOf(min), ou3, Integer.valueOf(i2), ou4});
        final Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_count", i2);
        if (min <= 0) {
            i = 10;
        } else {
            i = min;
        }
        intent.putExtra("key_pick_local_media_duration", i);
        intent.putExtra("query_media_type", 3);
        intent.putExtra("key_pick_local_media_video_type", 2);
        intent.putExtra("key_pick_local_media_sight_type", ou2);
        intent.putExtra("key_pick_local_pic_query_source_type", (ou4.contains("original") ^ ou4.contains("compressed")) != 0 ? 7 : 8);
        intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(ou4.contains("compressed")));
        if (bh.ov(ou)) {
            str = "album|camera";
        } else {
            str = ou;
        }
        if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
            com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.context);
            lVar.b(null, new OnCreateContextMenuListener(this) {
                final /* synthetic */ g tIj;

                {
                    this.tIj = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(0, 1, 0, this.tIj.context.getString(R.l.dEW));
                    contextMenu.add(0, 2, 1, this.tIj.context.getString(R.l.dFa));
                }
            }, new com.tencent.mm.ui.base.p.d(this) {
                final /* synthetic */ g tIj;

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            this.tIj.a(ou3, intent);
                            return;
                        case 2:
                            this.tIj.J(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            lVar.e(new OnCancelListener(this) {
                final /* synthetic */ g tIj;

                public final void onCancel(DialogInterface dialogInterface) {
                    this.tIj.a(iVar, "doChooseMedia:cancel", null);
                }
            });
            lVar.bBX();
            return true;
        } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            J(intent);
            return true;
        } else if (str.contains("camera")) {
            a(ou3, intent);
            return true;
        } else {
            a(iVar, "chooseMedia:fail_sourceType_error", null);
            return true;
        }
    }

    private void a(String str, Intent intent) {
        int i;
        x.i("MicroMsg.MsgHandler", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        ((MMActivity) this.context).jwN = this;
        com.tencent.mm.bm.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    private void J(Intent intent) {
        x.i("MicroMsg.MsgHandler", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", Downloads.RECV_BUFFER_SIZE);
        ((MMActivity) this.context).jwN = this;
        com.tencent.mm.bm.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(i iVar, int i) {
        int i2;
        int i3;
        int i4;
        String ou = bh.ou((String) iVar.pox.get("sourceType"));
        x.i("MicroMsg.MsgHandler", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", new Object[]{ou, bh.ou((String) iVar.pox.get("camera")), Integer.valueOf(i)});
        int i5 = bh.getInt((String) iVar.pox.get("maxDuration"), 60);
        if (ou.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i2 = Downloads.RECV_BUFFER_SIZE;
        } else {
            i2 = 0;
        }
        if (ou.contains("camera")) {
            if (i5 <= 0) {
                a(iVar, "chooseVideo:fail", null);
                return true;
            } else if (r4.equals("front")) {
                i2 |= 16;
            } else {
                i2 |= 256;
            }
        }
        if (i2 == 0) {
            i3 = 4352;
        } else {
            i3 = i2;
        }
        if (i3 == 16 || i3 == 256 || i3 == 4352) {
            if (i == 1) {
                x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 117, "", ""))});
                if (com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 117, "", "")) {
                    x.d("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 118, "", ""))});
                }
                return true;
            }
            x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 115, "", ""))});
            if (!com.tencent.mm.pluginsdk.g.a.a((Activity) this.context, "android.permission.CAMERA", 115, "", "")) {
                return true;
            }
        }
        i2 = bh.getInt((String) iVar.pox.get("quality"), 1);
        if (i2 == 0 || i2 == 1) {
            i4 = i2;
        } else {
            i4 = 1;
        }
        if (i5 > 60) {
            i2 = 60;
        } else {
            i2 = i5;
        }
        x.i("MicroMsg.MsgHandler", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(i4), Integer.valueOf(i2)});
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i3);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i4);
        intent.putExtra("key_pick_local_media_duration", i2);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i);
        x.i("MicroMsg.MsgHandler", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(7)});
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jwN = this;
            if (i == 1) {
                com.tencent.mm.bm.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
            } else {
                com.tencent.mm.bm.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
            }
        }
        return true;
    }

    private boolean U(i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bh.ov(str) && !bh.ov(str2)) {
                k.a(iVar.tJH, false, null, str);
                WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
                if (Oo != null) {
                    switch (Oo.ftE) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.hrP, 202, 2, bd.NAME, z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hrQ, 202, 2, bd.NAME, z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hrS, 202, 2, bd.NAME, z);
                            break;
                    }
                }
                a(iVar, "uploadMediaFile:fail", null);
            } else {
                x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadMediaFile:fail_missing arguments", null);
        return true;
    }

    private void a(final i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final String str5 = str2;
        AnonymousClass59 anonymousClass59 = new com.tencent.mm.plugin.webview.model.c.b(this) {
            final /* synthetic */ g tIj;

            public final void a(boolean z, String str, String str2, String str3) {
                x.i("MicroMsg.MsgHandler", str4 + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!bh.ov(str) && str.equals(str5)) {
                    com.tencent.mm.plugin.webview.modeltools.f.bRA().a(this);
                    if (this.tIj.iln != null) {
                        this.tIj.iln.dismiss();
                        this.tIj.iln = null;
                    }
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        this.tIj.a(iVar, str4 + ":ok", hashMap);
                        return;
                    }
                    this.tIj.a(iVar, str4 + ":fail", null);
                }
            }
        };
        WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
        if (Oo == null) {
            a(iVar, str3 + ":fail", null);
            return;
        }
        com.tencent.mm.aq.e b = o.Pw().b(Long.valueOf(o.Pw().a(Oo.iLu, Oo.iLy ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str6 = Oo.iLu;
        Oo.iLu = o.Pw().m(b.hzQ, "", "");
        x.i("MicroMsg.MsgHandler", "Image Inserted: %s", new Object[]{r2});
        x.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.f.bRA().a(str, str2, i, i2, i3, anonymousClass59))});
        if (!com.tencent.mm.plugin.webview.modeltools.f.bRA().a(str, str2, i, i2, i3, anonymousClass59)) {
            a(iVar, str3 + ":fail", null);
        } else if (z) {
            Context context = this.context;
            this.context.getString(R.l.dGO);
            this.iln = h.a(context, this.context.getString(R.l.eYF), true, new 60(this, anonymousClass59, str2, iVar, str3));
        } else if (this.context instanceof Activity) {
            ((Activity) this.context).finish();
            this.fBH = this.tHy;
        }
        Oo.iLu = str6;
    }

    private void b(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
        if (Oo == null || bh.ov(Oo.iLu) || !com.tencent.mm.a.e.bO(Oo.iLu)) {
            a(iVar, str3 + ":fail_file not exist", null);
        } else if (ab.bC(this.context)) {
            c(iVar, str, str2, i, i2, i3, str3, z);
        } else {
            String fK = bh.fK((long) com.tencent.mm.a.e.bN(Oo.iLu));
            h.a(this.context, this.context.getString(R.l.eWV, new Object[]{fK}), this.context.getString(R.l.dGO), new 61(this, iVar, str, str2, i, i2, i3, str3, z), new 62(this, iVar, str3));
        }
    }

    private void c(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        com.tencent.mm.plugin.webview.model.c.b 64 = new 64(this, str3, str2, iVar);
        boolean a = com.tencent.mm.plugin.webview.modeltools.f.bRA().a(str, str2, i, i2, i3, 64);
        x.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(a)});
        if (a) {
            b bVar = new b((byte) 0);
            bVar.tHp = iVar;
            bVar.tJC = 64;
            this.tHV.put(str2, bVar);
            Bundle bundle = new Bundle();
            bundle.putString("close_window_confirm_dialog_switch", "true");
            bundle.putString("close_window_confirm_dialog_title_cn", this.context.getString(R.l.eWW));
            bundle.putString("close_window_confirm_dialog_title_eng", this.context.getString(R.l.eWW));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.context.getString(R.l.eWT));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.context.getString(R.l.eWT));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.context.getString(R.l.eWU));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.context.getString(R.l.eWU));
            try {
                this.fBH.n(13, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
            }
            if (z) {
                Context context = this.context;
                this.context.getString(R.l.dGO);
                this.iln = h.a(context, this.context.getString(R.l.eYF), true, new 65(this, 64, str2, iVar, str3));
                this.iln.setOnKeyListener(new 66(this));
                return;
            } else if (this.context instanceof Activity) {
                ((Activity) this.context).finish();
                this.fBH = this.tHy;
                return;
            } else {
                return;
            }
        }
        a(iVar, str3 + ":fail", null);
    }

    private boolean V(i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occurred : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bh.ov(str) || bh.ov(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVideo:fail_missing arguments", null);
            } else {
                b(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadVideo", z);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVideo:fail_missing arguments", null);
        return true;
    }

    public final boolean bUB() {
        boolean z = !bh.ov(this.tHW);
        if (z) {
            x.e("MicroMsg.MsgHandler", "in recording state.");
        }
        return z;
    }

    private boolean W(i iVar) {
        if (bUB()) {
            try {
                this.fBH.n(TXLiveConstants.PLAY_EVT_PLAY_LOADING, null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "callback start record failed");
            }
            a(iVar, "startRecord:fail_recording", null);
        } else {
            String str = (String) iVar.pox.get("appId");
            if (bh.ov(str)) {
                x.e("MicroMsg.MsgHandler", "appId is null or nil.");
                a(iVar, "startRecord:fail_missing arguments", null);
            } else {
                k.a(iVar.tJH, false, null, str);
                if (com.tencent.mm.pluginsdk.g.a.aZ(this.context, "android.permission.RECORD_AUDIO")) {
                    WebViewJSSDKFileItem Om = WebViewJSSDKFileItem.Om(ai.Ov(str));
                    Om.appId = str;
                    com.tencent.mm.plugin.webview.modeltools.f.bRB().b(Om);
                    x.i("MicroMsg.MsgHandler", "start record appId : %s, voice file name : %s, voice file path : %s", new Object[]{str, r1, Om.iLu});
                    this.tHW = Om.fus;
                    ag.y(new 67(this, Om, iVar));
                    try {
                        this.fBH.n(TXLiveConstants.PLAY_EVT_PLAY_LOADING, null);
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "callback start record failed");
                    }
                    a(iVar, "startRecord:ok", null);
                } else {
                    WebViewStubTempUI.a(this.context, this.fBH, new String[]{"android.permission.RECORD_AUDIO"}, this.fDl);
                }
            }
        }
        return true;
    }

    private boolean X(i iVar) {
        if (bUB()) {
            String str = (String) iVar.pox.get("appId");
            x.i("MicroMsg.MsgHandler", "stop record appId : %s", new Object[]{str});
            k.a(iVar.tJH, false, null, str);
            WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(this.tHW);
            if (Oo == null || !str.equals(Oo.appId)) {
                x.e("MicroMsg.MsgHandler", "get jssdk file item by id failed or the appid is not corrected, appid is : %s", new Object[]{str});
                a(iVar, "stopRecord:fail", null);
            } else {
                ag.y(new 69(this, Oo));
                x.i("MicroMsg.MsgHandler", "stop record, file name  : %s, file path : %s, localid : %s", new Object[]{Oo.fileName, Oo.iLu, Oo.fus});
                Map hashMap = new HashMap();
                hashMap.put("localId", Oo.fus);
                try {
                    this.fBH.n(TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION, null);
                } catch (RemoteException e) {
                    x.e("MicroMsg.MsgHandler", "callback on stop record failed.");
                }
                a(iVar, "stopRecord:ok", hashMap);
            }
        } else {
            x.w("MicroMsg.MsgHandler", "Do not in recording state.");
            a(iVar, "stopRecord:fail", null);
        }
        return true;
    }

    private boolean Y(i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.tJH, false, null, str);
            x.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bh.ov(str) || bh.ov(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVoice:fail_missing arguments", null);
            } else {
                com.tencent.mm.plugin.webview.model.c.b 73 = new 73(this, str2, iVar);
                x.i("MicroMsg.MsgHandler", "doUploadVoice, add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.f.bRA().b(str, str2, 73))});
                if (!com.tencent.mm.plugin.webview.modeltools.f.bRA().b(str, str2, 73)) {
                    a(iVar, "uploadVoice:fail", null);
                } else if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dGO);
                    this.iln = h.a(context, this.context.getString(R.l.eYF), true, new 75(this, 73, str2, iVar));
                }
            }
            return true;
        }
        z = true;
        k.a(iVar.tJH, false, null, str);
        x.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVoice:fail_missing arguments", null);
        return true;
    }

    private boolean Z(i iVar) {
        boolean z;
        com.tencent.mm.plugin.webview.model.c.b 76;
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("serverId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.tJH, false, null, str);
            x.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bh.ov(str2)) {
                76 = new 76(this, str2, iVar);
                com.tencent.mm.plugin.webview.modeltools.f.bRA().a(str, str2, 76);
                x.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dGO);
                    this.iln = h.a(context, this.context.getString(R.l.eYj), true, new 77(this, 76, str2, iVar));
                }
            } else {
                a(iVar, "downloadVoice:fail_invaild_serverId", null);
            }
            return true;
        }
        z = true;
        k.a(iVar.tJH, false, null, str);
        x.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str2)) {
            76 = new 76(this, str2, iVar);
            com.tencent.mm.plugin.webview.modeltools.f.bRA().a(str, str2, 76);
            x.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
            if (z) {
                Context context2 = this.context;
                this.context.getString(R.l.dGO);
                this.iln = h.a(context2, this.context.getString(R.l.eYj), true, new 77(this, 76, str2, iVar));
            }
        } else {
            a(iVar, "downloadVoice:fail_invaild_serverId", null);
        }
        return true;
    }

    private boolean aa(i iVar) {
        String str = (String) iVar.pox.get("menuList");
        if (bh.ov(str)) {
            a(iVar, "hideMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.fBH.p(3001, bundle);
                a(iVar, "hideMenuItems:ok", null);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "hideMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                a(iVar, "hideMenuItems:param is empty", null);
            }
        }
        return true;
    }

    private boolean ab(i iVar) {
        String str = (String) iVar.pox.get("menuList");
        if (bh.ov(str)) {
            a(iVar, "showMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.fBH.p(3002, bundle);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "showMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e2.getMessage()});
                a(iVar, "showMenuItems:param is empty", null);
            }
            a(iVar, "showMenuItems:ok", null);
        }
        return true;
    }

    private boolean bUC() {
        try {
            this.fBH.p(3003, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doShowOptionMenu, RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.maM = false;
        return false;
    }

    private boolean bUD() {
        try {
            this.fBH.p(TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.maM = false;
        return false;
    }

    private boolean ac(i iVar) {
        try {
            this.fBH.p(3003, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(iVar, "hideAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "hideAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean ad(i iVar) {
        try {
            this.fBH.p(TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(iVar, "showAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "showAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean ae(i iVar) {
        String str = (String) iVar.pox.get("jsApiList");
        if (bh.ov(str)) {
            a(iVar, "checkJsApi:param is empty", null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    a(iVar, "checkJsApi:param is empty", null);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        boolean z;
                        String string = jSONArray.getString(i);
                        if (com.tencent.mm.protocal.c.Tm(string) == null) {
                            if (kz.vAr == null) {
                                Set hashSet = new HashSet();
                                kz.vAr = hashSet;
                                hashSet.add("menu:share:QZone");
                                kz.vAr.add("onImageDownloadProgress");
                                kz.vAr.add("onVoiceUploadProgress");
                                kz.vAr.add("onVoiceDownloadProgress");
                                kz.vAr.add("onVoiceRecordEnd");
                                kz.vAr.add("onVoicePlayBegin");
                                kz.vAr.add("onVoicePlayEnd");
                                kz.vAr.add("onLocalImageUploadProgress");
                                kz.vAr.add(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME);
                                kz.vAr.add(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME);
                                kz.vAr.add("hdOnDeviceStateChanged");
                                kz.vAr.add("activity:state_change");
                                kz.vAr.add("onWXDeviceBluetoothStateChange");
                                kz.vAr.add("onWXDeviceLanStateChange");
                                kz.vAr.add("onWXDeviceBindStateChange");
                                kz.vAr.add("onReceiveDataFromWXDevice");
                                kz.vAr.add("onScanWXDeviceResult");
                                kz.vAr.add("onWXDeviceStateChange");
                                kz.vAr.add("onGetKeyboardHeight");
                                kz.vAr.add("onGetSmiley");
                                kz.vAr.add("onAddShortcutStatus");
                                kz.vAr.add("onMediaFileUploadProgess");
                                kz.vAr.add("onGetA8KeyUrl");
                                kz.vAr.add("onPageStateChange");
                                kz.vAr.add("onGetMsgProofItems");
                                kz.vAr.add("onNavigationBarRightButtonClick");
                                kz.vAr.add("onBackgroundAudioStateChange");
                                kz.vAr.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                                kz.vAr.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                                kz.vAr.add("onArticleReadingBtnClicked");
                                kz.vAr.add("onRecordHistory");
                            }
                            if (!kz.vAr.contains(string)) {
                                z = false;
                                jSONObject.put(string, z);
                            }
                        }
                        z = true;
                        jSONObject.put(string, z);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("checkResult", jSONObject.toString());
                    a(iVar, "checkJsApi:ok", hashMap);
                }
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "checkJsApi:param is empty", null);
            }
        }
        return true;
    }

    private boolean af(i iVar) {
        try {
            int intValue;
            String str = (String) iVar.pox.get("userName");
            try {
                intValue = ((Integer) iVar.pox.get(DownloadSettingTable$Columns.TYPE)).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            a(iVar, "setFreeWifiOwner:ok", null);
            Intent intent = new Intent();
            intent.putExtra("wifi_owner_name", str);
            intent.putExtra("wifi_owner_type", intValue);
            com.tencent.mm.bm.d.a(this.context, "freewifi", ".ui.FreeWifiOwnerUI", intent, false);
        } catch (Exception e2) {
            x.w("MicroMsg.MsgHandler", "setFreeWifiOwner, Exception: %s", new Object[]{e2.getMessage()});
        }
        return false;
    }

    private boolean ag(i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("appId");
        String str2 = (String) iVar.pox.get("localId");
        Object obj = iVar.pox.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bh.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
            k.a(iVar.tJH, false, null, str);
            if (!bh.ov(str) || bh.ov(str2)) {
                x.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
                a(iVar, "translateVoice:fail_missing arguments", null);
            } else {
                WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str2);
                if (Oo != null) {
                    ag.y(new 79(this, z, iVar, str2, Oo));
                } else {
                    a(iVar, "translateVoice:fail_arguments error", null);
                }
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
        k.a(iVar.tJH, false, null, str);
        if (bh.ov(str)) {
        }
        x.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
        a(iVar, "translateVoice:fail_missing arguments", null);
        return true;
    }

    private boolean ah(i iVar) {
        BaseMessage wWMediaLink = new WWMediaLink();
        wWMediaLink.thumbUrl = (String) iVar.pox.get("img_url");
        try {
            wWMediaLink.webpageUrl = com.tencent.mm.plugin.webview.model.ak.BP(this.fBH.aeq());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            wWMediaLink.webpageUrl = (String) iVar.pox.get("link");
        }
        wWMediaLink.title = (String) iVar.pox.get("title");
        wWMediaLink.description = (String) iVar.pox.get("desc");
        WWAPIFactory.iN(this.context).a(wWMediaLink);
        a(iVar, "shareWeWork:ok", null);
        return true;
    }

    private boolean ai(i iVar) {
        if (com.tencent.mm.plugin.webview.stub.a.dO(this.context)) {
            String str = (String) iVar.pox.get("img_url");
            String str2 = (String) iVar.pox.get("title");
            String str3 = (String) iVar.pox.get("desc");
            String string = this.context.getResources().getString(R.l.app_name);
            String str4 = (String) iVar.pox.get("link");
            try {
                if (bh.ov(str4)) {
                    str4 = this.fBH.aeq();
                }
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
            }
            str4 = com.tencent.mm.plugin.webview.model.ak.BP(str4);
            if (bh.ov(str4) || bh.ov(str2) || bh.ov(str3)) {
                x.w("MicroMsg.MsgHandler", "url(%s) or title(%s) or description(%s) is null or nil.", new Object[]{str4, str2, str3});
                a(iVar, "shareQQ:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("image_url", com.tencent.mm.pluginsdk.ui.tools.s.SS(str));
                hashMap.put("title", com.tencent.mm.pluginsdk.ui.tools.s.SS(str2));
                hashMap.put("description", com.tencent.mm.pluginsdk.ui.tools.s.SS(str3));
                hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com.tencent.mm.pluginsdk.ui.tools.s.SS(str4));
                hashMap.put("app_name", com.tencent.mm.pluginsdk.ui.tools.s.SS(string));
                hashMap.put("req_type", com.tencent.mm.pluginsdk.ui.tools.s.SS("1"));
                if (iVar.tJI.equalsIgnoreCase("shareQZone")) {
                    hashMap.put("cflag", com.tencent.mm.pluginsdk.ui.tools.s.SS("1"));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mqqapi://share/to_fri?file_type=news&share_id=1103188687");
                stringBuilder.append("&");
                stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.ar(hashMap));
                x.d("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
                intent.putExtra("pkg_name", "com.tencent.mm");
                intent.getStringExtra("pkg_name");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (bh.k(this.context, intent) && (this.context instanceof Activity)) {
                    ((Activity) this.context).startActivityForResult(intent, 44);
                    a(iVar, iVar.tJI + ":ok", null);
                } else {
                    a(iVar, iVar.tJI + ":fail", null);
                }
            }
        } else {
            x.w("MicroMsg.MsgHandler", "Tencent QQ hasn't installed at all.");
            a(iVar, "shareQQ:fail", null);
        }
        return true;
    }

    private boolean aj(i iVar) {
        String str = (String) iVar.pox.get("desc");
        String str2 = (String) iVar.pox.get("img_url");
        String str3 = (String) iVar.pox.get("link");
        try {
            if (bh.ov(str3)) {
                str3 = this.fBH.aeq();
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
        }
        str3 = com.tencent.mm.plugin.webview.model.ak.BP(str3);
        if (bh.ov(str3)) {
            x.e("MicroMsg.MsgHandler", "link is null or nil.");
            a(iVar, "shareWeiboApp:fail", null);
        } else {
            if (bh.ov(str)) {
                str = ((String) iVar.pox.get("title")) + " " + str3;
            }
            Map hashMap = new HashMap();
            hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(0));
            hashMap.put("openLBS", Integer.valueOf(0));
            hashMap.put("content", com.tencent.mm.pluginsdk.ui.tools.s.SR(str));
            hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com.tencent.mm.pluginsdk.ui.tools.s.SR(str2));
            hashMap.put("thumbnailurl", com.tencent.mm.pluginsdk.ui.tools.s.SR(str2));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("weibo://t.qq.com/proxy/write"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TencentWeibo://Edit?from=weixin&");
            stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.ar(hashMap));
            x.i("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
            intent.putExtra("microblog.intent.extra.ACTION", stringBuilder.toString());
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bh.k(this.context, intent)) {
                this.context.startActivity(intent);
                a(iVar, "shareWeiboApp:ok", null);
            } else {
                a(iVar, "shareWeiboApp:fail", null);
            }
        }
        return true;
    }

    private boolean ak(i iVar) {
        String str = (String) iVar.pox.get("sessionFrom");
        if (bh.ov((String) iVar.pox.get("sessionId"))) {
            a(iVar, "startTempSession:fail_missing arguments", null);
        } else {
            String str2;
            int intValue;
            int i;
            String format;
            Intent intent;
            if (str != null) {
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
            } else {
                str = null;
            }
            str2 = str;
            Object obj = iVar.pox.get("showType");
            if (obj != null) {
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        intValue = bh.getInt((String) obj, 0);
                    } catch (NumberFormatException e2) {
                        intValue = 0;
                    }
                }
                i = bh.getInt(bh.ou((String) iVar.pox.get("scene")), 0);
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.tHB.PB(this.fBH.aeq()), bh.ou(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", i);
                } else {
                    intent.putExtra("translate_link_scene", 4);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            }
            intValue = 0;
            i = bh.getInt(bh.ou((String) iVar.pox.get("scene")), 0);
            try {
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.tHB.PB(this.fBH.aeq()), bh.ou(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", 4);
                } else {
                    intent.putExtra("translate_link_scene", i);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                a(iVar, "startTempSession:fail_exception", null);
            }
        }
        return true;
    }

    private boolean al(i iVar) {
        try {
            String str = (String) iVar.pox.get("userName");
            String str2 = (String) iVar.pox.get("nickName");
            if (bh.ov(str)) {
                a(iVar, "setPageOwner:missing_arguments", null);
            } else {
                this.fBH.eM(str, str2);
                a(iVar, "setPageOwner:ok", null);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "setPageOwner, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    private boolean am(i iVar) {
        try {
            String str = (String) iVar.pox.get("appId");
            String str2 = (String) iVar.pox.get("signature");
            k.a(iVar.tJH, false, null, str);
            if (bh.ov(str)) {
                a(iVar, "get_wechat_verify_ticket:fail ticket", null);
            } else {
                ar.CG().a(1097, new 80(this, iVar));
                ar.CG().a(new com.tencent.mm.plugin.webview.model.g(str, str2), 0);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "getWechatVerifyTicket, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    public final boolean an(i iVar) {
        x.d("MicroMsg.MsgHandler", "doSelectPedometerSource");
        if (this.context == null || !(this.context instanceof MMActivity)) {
            x.e("MicroMsg.MsgHandler", "context is null");
            a(iVar, "selectPedometerSource:fail", null);
        } else {
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.b(this.context, "exdevice", ".ui.ExdeviceAddDataSourceUI", new Intent(), 26);
        }
        return true;
    }

    private Bundle e(String str, int i, Bundle bundle) {
        try {
            return this.fBH.e(i, bundle);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback RemoteException!" + e.toString());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f(String str, int i, Bundle bundle) {
        int i2 = -1;
        Bundle e = e(str, i, bundle);
        if (e != null) {
            i2 = e.getInt(DownloadInfo.STATUS, -1);
        } else {
            x.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback fail!");
        }
        x.i("MicroMsg.MsgHandler", "[NFC] " + str + " result status : " + i2);
        switch (i2) {
            case 0:
                a(this.tHp, str + ":nfc_not_support", null);
                break;
            case 1:
                a(this.tHp, str + ":nfc_off", null);
                break;
            case 2:
                a(this.tHp, str + ":disconnect", null);
                break;
            case 3:
                break;
            case 4:
                a(this.tHp, str + ":card_not_support", null);
                break;
            default:
                a(this.tHp, str + ":fail", null);
                break;
        }
    }

    private boolean ao(i iVar) {
        try {
            Bundle e = this.fBH.e(5001, null);
            if (e != null) {
                int i = e.getInt("webview_video_proxy_init");
                x.i("MicroMsg.MsgHandler", "int webview video proxy : %d", new Object[]{Integer.valueOf(i)});
                Map hashMap = new HashMap();
                hashMap.put("videoProxyInitResult", Integer.valueOf(i));
                if (i == 0) {
                    ah bQR = ah.bQR();
                    bQR.fBH = this.fBH;
                    bQR.hasInit = true;
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(1);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, false);
                    a(iVar, "videoProxyInit:ok", hashMap);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(0);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(2);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(com.tencent.mm.plugin.webview.ui.tools.a.Ay(i));
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    com.tencent.mm.plugin.report.service.g.pQN.a(arrayList2, false);
                    a(iVar, "videoProxyInit:fail", hashMap);
                }
                return false;
            }
        } catch (Exception e2) {
            x.i("MicroMsg.MsgHandler", "doinit webview proxy failed : %s", new Object[]{e2.getMessage()});
        }
        a(iVar, "videoProxyInit:fail", null);
        return false;
    }

    private boolean ap(i iVar) {
        if (ah.bQR().hasInit) {
            String str = (String) iVar.pox.get("webviewVideoProxyCdnUrls");
            x.i("MicroMsg.MsgHandler", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d", new Object[]{str, (String) iVar.pox.get("webviewVideoProxyFileId"), Integer.valueOf(bh.getInt((String) iVar.pox.get("webviewVideoProxyFileSize"), 0)), Integer.valueOf(bh.getInt((String) iVar.pox.get("webviewVideoProxyFileDuration"), 0)), Integer.valueOf(bh.getInt((String) iVar.pox.get("webviewVideoProxyFileType"), 1))});
            if (bh.ov(str)) {
                a(iVar, "videoProxyStartPlay:fail_cdnurl_is_null", null);
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_video_proxy_cdn_urls", str);
                    bundle.putString("webview_video_proxy_fileId", r1);
                    bundle.putInt("webview_video_proxy_file_size", r3);
                    bundle.putInt("webview_video_proxy_file_duration", r4);
                    bundle.putInt("webview_video_proxy_file_type", r2);
                    Bundle e = this.fBH.e(5002, bundle);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(15);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    if (e != null) {
                        int i = e.getInt("webview_video_proxy_play_data_id");
                        str = e.getString("webview_video_proxy_local_url");
                        x.i("MicroMsg.MsgHandler", "invoke result palyDataId = %d, localUrl = %s", new Object[]{Integer.valueOf(i), str});
                        if (i > 0 && !bh.ov(str)) {
                            com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, false);
                            Map hashMap = new HashMap();
                            hashMap.put("videoProxyPlayDataId", Integer.valueOf(i));
                            hashMap.put("videoProxyPlayLocalUrl", str);
                            a(iVar, "videoProxyStartPlay:ok", hashMap);
                            com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, false);
                        }
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "proxy start play failed : %s", new Object[]{e2.getMessage()});
                }
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(142);
                iDKey2.SetKey(16);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, false);
                a(iVar, "videoProxyStartPlay:fail", null);
            }
        } else {
            a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        }
        return false;
    }

    private boolean aq(i iVar) {
        if (ah.bQR().hasInit) {
            int i = bh.getInt((String) iVar.pox.get("webviewVideoProxyPlaydataId"), 0);
            if (i > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                try {
                    this.fBH.e(5003, bundle);
                    a(iVar, "videoProxyStopPlay:ok", null);
                    return false;
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "webview proxy stop play failed : %s", new Object[]{e.getMessage()});
                }
            }
            a(iVar, "videoProxyStopPlay:fail", null);
            return false;
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean ar(i iVar) {
        if (ah.bQR().hasInit) {
            String str = (String) iVar.pox.get("webviewVideoProxyPlayState");
            x.i("MicroMsg.MsgHandler", "set player state : %s", new Object[]{str});
            if (bh.ov(str)) {
                a(iVar, "videoProxySetPlayerState:fail", null);
                return true;
            }
            int i = bh.getInt(str, 0);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_state", i);
                this.fBH.e(5004, bundle);
                a(iVar, "videoProxySetPlayerState:ok", null);
                return false;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "set player state failed : %s", new Object[]{e.getMessage()});
                a(iVar, "videoProxySetPlayerState:fail", null);
                return false;
            }
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean as(i iVar) {
        if (ah.bQR().hasInit) {
            int i = bh.getInt((String) iVar.pox.get("webviewVideoProxyPlaydataId"), 0);
            int i2 = bh.getInt((String) iVar.pox.get("webviewVideoProxyRemainTime"), 0);
            x.i("MicroMsg.MsgHandler", "doWebviewProxySetRemainTime, id = %s, time = %s", new Object[]{r0, r1});
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                bundle.putInt("webview_video_proxy_play_remain_time", i2);
                this.fBH.e(5006, bundle);
                a(iVar, "videoProxySetRemainTime:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "set remain time faild : %s", new Object[]{e.getMessage()});
                a(iVar, "videoProxySetRemainTime:fail", null);
            }
        } else {
            a(iVar, "videoProxySetRemainTime:fail_has_not_init", null);
        }
        return false;
    }

    private boolean at(i iVar) {
        if (ah.bQR().hasInit) {
            String str = (String) iVar.pox.get("webviewVideoProxyPlaydataId");
            x.i("MicroMsg.MsgHandler", "doWebviewProxyPreload, playDataId = %s, duration = %d", new Object[]{str, Integer.valueOf(bh.getInt((String) iVar.pox.get("webviewVideoProxyPreloadTime"), 0))});
            if (bh.ov(str)) {
                x.e("MicroMsg.MsgHandler", "playDataId is null or nil");
                a(iVar, "videoProxyPreload:fail_invaild_play_data_id", null);
            } else {
                try {
                    int i = bh.getInt(str, 0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("webview_video_proxy_play_data_id", i);
                    bundle.putInt("webview_video_proxy_preload_duration", r1);
                    x.i("MicroMsg.MsgHandler", "preload video result = %d", new Object[]{Integer.valueOf(this.fBH.e(5007, bundle).getInt("webview_video_proxy_pre_load_result"))});
                    if (this.fBH.e(5007, bundle).getInt("webview_video_proxy_pre_load_result") == 0) {
                        a(iVar, "videoProxyPreload:ok", null);
                    } else {
                        a(iVar, "videoProxyPreload:fail", null);
                    }
                } catch (Exception e) {
                    a(iVar, "videoProxyPreload:fail", null);
                }
            }
        } else {
            a(iVar, "videoProxyPreload:fail_has_not_init", null);
        }
        return false;
    }

    public final void z(int i, String str, String str2) {
        c Ba = Ba(i);
        if (Ba == null) {
            x.i("MicroMsg.MsgHandler", "onWebViewCacheCallback, get null MsgWrapperBin, may be the webview called cache api has been closed.");
            return;
        }
        i iVar = Ba.tHp;
        Bb(i);
        if (!bh.ou(str2).equalsIgnoreCase("ok")) {
            int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
            if (-1 != a) {
                com.tencent.mm.plugin.webview.modelcache.m.Ap(a);
            }
        }
        if (this.fBH != null) {
            a(this.fBH, iVar, String.format("%s:%s", new Object[]{str, str2}), null, false, true);
        }
    }

    private boolean au(i iVar) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        String str = (String) iVar.pox.get("actionKey");
        String str2 = (String) iVar.pox.get("actionValue");
        x.i("MicroMsg.MsgHandler", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{str, str2});
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue is null");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else if (str.length() <= 0 || str.length() > 32 || str2.length() <= 0 || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            x.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue size is bad");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else {
            String str3 = " ";
            String str4 = " ";
            String str5 = " ";
            try {
                Bundle e = this.fBH.e(77, null);
                if (e != null) {
                    str3 = bh.ou(e.getString("KSessionId"));
                    str4 = bh.ou(e.getString("KUserAgent"));
                    str5 = bh.ou(e.getString("KUrl"));
                    if (TextUtils.isEmpty(str5)) {
                        x.e("MicroMsg.MsgHandler", "doReportActionInfo, url is empty");
                        a(iVar, "reportActionInfo:fail", null);
                        return true;
                    }
                    x.i("MicroMsg.MsgHandler", "doReportActionInfo, sessionId %s, userAgent %s, url %s", new Object[]{str3, str4, str5});
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e2});
            }
            if (TextUtils.isEmpty(qE(str5))) {
                x.e("MicroMsg.MsgHandler", "doReportActionInfo, appId is empty");
                a(iVar, "reportActionInfo:fail", null);
                return true;
            }
            x.i("MicroMsg.MsgHandler", "doReportActionInfo, appId %s", new Object[]{qE(str5)});
            int i = 0;
            if (an.isConnected(this.context)) {
                if (an.isWifi(this.context)) {
                    i = 1;
                } else if (an.is4G(this.context)) {
                    i = 4;
                } else if (an.is3G(this.context)) {
                    i = 3;
                } else if (an.is2G(this.context)) {
                    i = 2;
                }
                x.i("MicroMsg.MsgHandler", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i)});
            }
            long Wo = bh.Wo();
            x.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Integer.valueOf(13379), Long.valueOf(Wo), r10, Integer.valueOf(i), str4, str5, str3, str, str2});
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str6 = URLEncoder.encode(bh.ou(str4), "UTF-8");
                str4 = URLEncoder.encode(str5, "UTF-8");
                try {
                    str5 = URLEncoder.encode(str, "UTF-8");
                } catch (Throwable e3) {
                    str2 = str4;
                    str5 = str6;
                    th = e3;
                    str = str8;
                    x.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.pQN.h(13379, new Object[]{Long.valueOf(Wo), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
                    a(iVar, "reportActionInfo:ok", null);
                    return true;
                }
                try {
                    str = URLEncoder.encode(str2, "UTF-8");
                    obj3 = str5;
                    obj2 = str4;
                    obj = str6;
                } catch (Throwable e32) {
                    str2 = str4;
                    th = e32;
                    str = str5;
                    str5 = str6;
                    x.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.pQN.h(13379, new Object[]{Long.valueOf(Wo), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
                    a(iVar, "reportActionInfo:ok", null);
                    return true;
                }
            } catch (Throwable e322) {
                th = e322;
                str2 = str7;
                str5 = str6;
                str = str8;
                x.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                str4 = str5;
                str5 = str2;
                str2 = str;
                str = str9;
                com.tencent.mm.plugin.report.service.g.pQN.h(13379, new Object[]{Long.valueOf(Wo), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
                a(iVar, "reportActionInfo:ok", null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13379, new Object[]{Long.valueOf(Wo), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
            a(iVar, "reportActionInfo:ok", null);
            return true;
        }
    }

    private boolean av(i iVar) {
        int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
        if (-1 == a) {
            a(this.fBH, iVar, "cache:fail", null, true, false);
            return true;
        }
        int i = -1;
        if (2 == a) {
            i = 2;
        } else if (1 == a) {
            i = 1;
        }
        if (-1 != i) {
            com.tencent.mm.plugin.report.service.g.pQN.a(238, (long) i, 1, false);
        }
        x.i("MicroMsg.MsgHandler", "user not in white list");
        com.tencent.mm.plugin.webview.modelcache.m.Ap(a);
        a(this.fBH, iVar, "cache:not in white list", null, true, false);
        return true;
    }

    private boolean aw(i iVar) {
        x.i("MicroMsg.MsgHandler", "doAddCustomMenuItems start");
        int i;
        if (iVar.pox.containsKey("hideMenu")) {
            i = bh.getInt((String) iVar.pox.get("hideMenu"), 0);
            x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems hideMenu=" + i);
            if (kC(i == 1)) {
                a(iVar, "doAddCustomMenuItems:ok", null);
            } else {
                a(iVar, "doAddCustomMenuItems:fail", null);
            }
        } else {
            kC(false);
            String str = (String) iVar.pox.get("itemList");
            if (bh.ov(str)) {
                x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems fail: key or title must not be null");
                a(iVar, "doAddCustomMenuItems:params error", null);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("key");
                            String optString2 = optJSONObject.optString("title");
                            if (bh.ov(optString) || bh.ov("title")) {
                                x.e("MicroMsg.MsgHandler", "key or title is null,ignore item: " + i);
                            } else {
                                arrayList.add(optString);
                                arrayList2.add(optString2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("keys", arrayList);
                        bundle.putStringArrayList("titles", arrayList2);
                        try {
                            this.fBH.P(bundle);
                            a(iVar, "doAddCustomMenuItems:ok", null);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                            x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems:fail");
                            a(iVar, "doAddCustomMenuItems:fail", null);
                        }
                    }
                } catch (JSONException e2) {
                    x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems eroor, parse itemList to jsonarray error");
                    a(iVar, "doAddCustomMenuItems:params parse error", null);
                }
            }
        }
        return true;
    }

    private boolean ax(i iVar) {
        String str = (String) iVar.pox.get("key");
        if (bh.ov(str)) {
            a(iVar, "getLocalData:fail_key_is_null", null);
        } else {
            try {
                String aeq = this.fBH.aeq();
                String str2 = new String(Base64.encode(str.getBytes(), 0));
                str = this.tHB.PB(aeq);
                com.tencent.mm.plugin.webview.model.af bRE = com.tencent.mm.plugin.webview.modeltools.f.bRE();
                String VZ = bh.VZ(aeq);
                x.i("MicroMsg.WebViewLocalDataStorage", "get value by key = %s, appid = %s, domin = %s", new Object[]{str2, str, VZ});
                if (bh.ov(str2) || bh.ov(str) || bh.ov(aeq) || bh.ov(VZ)) {
                    str = null;
                } else {
                    str = "select value from WebviewLocalData where recordId = " + com.tencent.mm.plugin.webview.model.af.ab(str, VZ, str2);
                    x.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bRE.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        x.e("MicroMsg.WebViewLocalDataStorage", "get cursor is null");
                        str = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            str = rawQuery.getString(0);
                        } else {
                            str = null;
                        }
                        rawQuery.close();
                        x.i("MicroMsg.WebViewLocalDataStorage", "get value : %s for key : %s", new Object[]{str, str2});
                    }
                }
                if (bh.ov(str)) {
                    a(iVar, "getLocalData:fail", null);
                } else {
                    String str3 = new String(Base64.decode(str.getBytes(), 0));
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str3);
                    x.i("MicroMsg.MsgHandler", "get local data, key = %s, value = %s", new Object[]{str2, str3});
                    a(iVar, "getLocalData:ok", hashMap);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(iVar, "getLocalData:fail", null);
            }
        }
        return true;
    }

    private boolean ay(i iVar) {
        String str = (String) iVar.pox.get("key");
        String str2 = (String) iVar.pox.get(SlookAirButtonFrequentContactAdapter.DATA);
        x.i("MicroMsg.MsgHandler", "set local data, key = %s, data = %s", new Object[]{str, str2});
        if (bh.ov(str) || bh.ov(str2)) {
            a(iVar, "setLocalData:fail_param_should_not_null", null);
            return true;
        } else if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            a(iVar, "setLocalData:fail_param_lenght_too_long", null);
            return true;
        } else {
            try {
                String aeq = this.fBH.aeq();
                byte[] encode = Base64.encode(str.getBytes(), 0);
                byte[] encode2 = Base64.encode(str2.getBytes(), 0);
                String str3 = new String(encode);
                String str4 = new String(encode2);
                str2 = this.tHB.PB(aeq);
                com.tencent.mm.plugin.webview.model.af bRE = com.tencent.mm.plugin.webview.modeltools.f.bRE();
                String VZ = bh.VZ(aeq);
                x.i("MicroMsg.WebViewLocalDataStorage", "set data, key = %s, value = %s, url = %s, appId = %s, domin = %s", new Object[]{str3, str4, aeq, str2, VZ});
                if (bh.ov(str3) || bh.ov(aeq) || bh.ov(str2) || bh.ov(VZ)) {
                    str = "fail_params_invalid";
                } else {
                    int ab = com.tencent.mm.plugin.webview.model.af.ab(str2, VZ, str3);
                    str = "select count(*) from WebviewLocalData where appId = '" + str2 + "' and domin = '" + VZ + "'";
                    x.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bRE.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            x.i("MicroMsg.WebViewLocalDataStorage", "now count = %d", new Object[]{Integer.valueOf(rawQuery.getInt(0))});
                            rawQuery.close();
                            if (rawQuery.getInt(0) >= 5) {
                                str = "fail_exceed_max_count";
                            } else {
                                rawQuery = bRE.rawQuery("select count(*) from WebviewLocalData where recordId =" + ab, new String[0]);
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        x.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, count = %d", new Object[]{r7, Integer.valueOf(rawQuery.getInt(0))});
                                        rawQuery.close();
                                        if (rawQuery.getInt(0) > 0) {
                                            x.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, ret = %b", new Object[]{"update WebviewLocalData set value = '" + str4 + "' where recordId =" + ab, Boolean.valueOf(bRE.fx("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ab))});
                                            str = bRE.fx("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ab) ? "ok" : "fail";
                                        }
                                    }
                                    rawQuery.close();
                                }
                            }
                        }
                        rawQuery.close();
                    }
                    com.tencent.mm.sdk.e.c aeVar = new ae();
                    aeVar.field_appId = str2;
                    aeVar.field_domin = VZ;
                    aeVar.field_key = str3;
                    aeVar.field_value = str4;
                    aeVar.field_recordId = ab;
                    x.i("MicroMsg.WebViewLocalDataStorage", "insert data, ret = %b", new Object[]{Boolean.valueOf(bRE.b(aeVar))});
                    str = "ok";
                }
                x.i("MicroMsg.MsgHandler", "doSetLocalData retValue = %s", new Object[]{str});
                a(iVar, "setLocalData:" + str, null);
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(iVar, "setLocalData:fail", null);
                return true;
            }
        }
    }

    private boolean az(i iVar) {
        try {
            String aeq = this.fBH.aeq();
            com.tencent.mm.plugin.webview.model.af bRE = com.tencent.mm.plugin.webview.modeltools.f.bRE();
            String PB = this.tHB.PB(aeq);
            String VZ = bh.VZ(aeq);
            x.i("MicroMsg.WebViewLocalDataStorage", "appid = %s, url = %s, domin = %s", new Object[]{PB, aeq, VZ});
            if (bh.ov(PB) || bh.ov(aeq) || bh.ov(VZ)) {
                aeq = "fail";
            } else {
                aeq = bRE.fx("WebviewLocalData", new StringBuilder("delete from WebviewLocalData where appId = '").append(PB).append("' and domin = '").append(VZ).append("'").toString()) ? "ok" : "fail";
            }
            x.i("MicroMsg.MsgHandler", "doClearLocalData retValue = %s", new Object[]{aeq});
            a(iVar, "clearLocalData:" + aeq, null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
            a(iVar, "clearLocalData:fail", null);
        }
        return true;
    }

    private boolean aA(final i iVar) {
        String aeq;
        String str = (String) iVar.pox.get("useridlist");
        String str2 = (String) iVar.pox.get("chatname");
        final String str3 = (String) iVar.pox.get("chatscene");
        try {
            aeq = this.fBH.aeq();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = null;
        }
        aeq = bh.ou(this.tHB.PB(aeq));
        LinkedList linkedList = new LinkedList();
        String[] split = str.split(";");
        if (split == null || split.length <= 0) {
            a(iVar, "openEnterpriseChat:fail", null);
            return false;
        }
        for (Object add : split) {
            linkedList.add(add);
        }
        y.Ml();
        com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.ag.a.t(aeq, str2, linkedList, new com.tencent.mm.ag.n(this) {
            final /* synthetic */ g tIj;

            public final void a(int i, k kVar) {
                if (i != 0) {
                    this.tIj.a(iVar, "openEnterpriseChat:fail", null);
                    return;
                }
                alh MB = ((com.tencent.mm.ag.a.t) kVar).MB();
                String str;
                if (MB != null && MB.vNw != null && MB.vNw.ret == 0) {
                    str = MB.vNq;
                    String str2 = ((com.tencent.mm.ag.a.t) kVar).hrt;
                    if (str2 == null) {
                        this.tIj.a(iVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.ag.a.c kl = y.Mh().kl(str2);
                    if (kl == null || bh.ov(str)) {
                        this.tIj.a(iVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    Intent intent;
                    if (bh.ov(str3) || !str3.equals("long")) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("key_biz_chat_id", kl.field_bizChatLocalId);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.bm.d.a(this.tIj.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                        intent.putExtra("Main_User", str);
                        intent.putExtra("biz_chat_chat_id", kl.field_bizChatLocalId);
                        intent.putExtra("biz_chat_from_scene", 8);
                        com.tencent.mm.bm.d.a(this.tIj.context, ".ui.LauncherUI", intent);
                    }
                    Map hashMap = new HashMap();
                    if (!(bh.ov(MB.vYj) || bh.ov(MB.vYk))) {
                        hashMap.put("chat_type", MB.vYj);
                        hashMap.put("chat_id", MB.vYk);
                    }
                    this.tIj.a(iVar, "openEnterpriseChat:ok", hashMap);
                } else if (MB == null || MB.vNw == null) {
                    this.tIj.a(iVar, "openEnterpriseChat:fail", null);
                } else {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("err_code", Integer.valueOf(MB.vNw.ret));
                    str = "openEnterpriseChat:fail";
                    if (MB.vNw.ftt != null) {
                        str = MB.vNw.ftt;
                    }
                    this.tIj.a(iVar, str, hashMap2);
                }
            }
        }), 0);
        return true;
    }

    private boolean aB(i iVar) {
        String aeq;
        String str = (String) iVar.pox.get("chatId");
        String str2 = (String) iVar.pox.get("chatType");
        try {
            aeq = this.fBH.aeq();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = null;
        }
        aeq = bh.ou(this.tHB.PB(aeq));
        if (bh.ov(str) || bh.ov(str2) || bh.ov(aeq)) {
            a(iVar, "enterEnterpriseChat:fail_params error", null);
        } else {
            y.Ml();
            com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.ag.a.m(aeq, str, str2, new 84(this, iVar)), 0);
        }
        return true;
    }

    private boolean aC(i iVar) {
        try {
            String ou = bh.ou(this.tHB.PB(this.fBH.aeq()));
            if (bh.ov(ou)) {
                a(iVar, "getEnterpriseChat:fail", null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
                bundle = this.fBH.e(71, bundle);
                String string = bundle.getString("enterprise_context_biz");
                String ba = com.tencent.mm.ag.a.e.ba(bundle.getLong("enterprise_context_bizchatid", -1));
                if (bh.ov(string) || bh.ov(ba)) {
                    a(iVar, "getEnterpriseChat:fail_not in enterprise chat", null);
                } else {
                    com.tencent.mm.ae.e 86 = new 86(this, iVar);
                    com.tencent.mm.kernel.g.Di().gPJ.a(1285, 86);
                    if (!com.tencent.mm.ag.s.k(ou, string, ba)) {
                        com.tencent.mm.ag.s.a(86);
                        a(iVar, "getEnterpriseChat:fail", null);
                    }
                }
            }
        } catch (Exception e) {
            a(iVar, "getEnterpriseChat:fail", null);
        }
        return true;
    }

    private boolean aD(i iVar) {
        String aeq;
        try {
            aeq = this.fBH.aeq();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = null;
        }
        String ou = bh.ou(this.tHB.PB(aeq));
        if (bh.ov(ou)) {
            a(iVar, "openEnterpriseContact:fail", null);
        }
        k iVar2 = new com.tencent.mm.plugin.webview.model.i(ou, aeq, iVar.pox);
        ar.CG().a(1393, new 87(this, iVar, this));
        ar.CG().a(iVar2, 0);
        Context context = this.context;
        this.context.getString(R.l.dGO);
        this.iln = h.a(context, this.context.getString(R.l.dHc), true, new 88(this, iVar2));
        return true;
    }

    private boolean aE(i iVar) {
        String aeq;
        try {
            aeq = this.fBH.aeq();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = null;
        }
        String ou = bh.ou(this.tHB.PB(aeq));
        if (bh.ov(ou)) {
            a(iVar, "selectEnterpriseContact:fail", null);
        }
        iVar.pox.put("groupId", "");
        iVar.pox.put("timestamp", "");
        iVar.pox.put("nonceStr", "");
        iVar.pox.put("signature", "");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray((String) iVar.pox.get(DownloadSettingTable$Columns.TYPE));
            jSONObject.put("fromDepartmentId", Integer.parseInt((String) iVar.pox.get("fromDepartmentId")));
            jSONObject.put("mode", (String) iVar.pox.get("mode"));
            jSONObject.put(DownloadSettingTable$Columns.TYPE, jSONArray);
            String str = (String) iVar.pox.get("selectedDepartmentIds");
            if (str != null) {
                jSONObject.put("selectedDepartmentIds", new JSONArray(str));
            }
            str = (String) iVar.pox.get("selectedUserIds");
            if (str != null) {
                jSONObject.put("selectedUserIds", new JSONArray(str));
            }
            iVar.pox.put("params", jSONObject);
        } catch (JSONException e2) {
        } catch (NumberFormatException e3) {
        }
        k iVar2 = new com.tencent.mm.plugin.webview.model.i(ou, aeq, iVar.pox);
        com.tencent.mm.ae.e 89 = new 89(this, iVar, this);
        ar.CG().a(1393, 89);
        ar.CG().a(iVar2, 0);
        Context context = this.context;
        this.context.getString(R.l.dGO);
        this.iln = h.a(context, this.context.getString(R.l.dHc), true, new 90(this, iVar2, 89));
        return true;
    }

    private boolean aF(i iVar) {
        if (this.fBH == null) {
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
            bundle = this.fBH.e(71, bundle);
            String string = bundle.getString("enterprise_context_biz");
            long j = bundle.getLong("enterprise_context_bizchatid", -1);
            if (bh.ov(string) || j < 0) {
                a(iVar, "sendEnterpriseChat:fail_not in enterprise chat", null);
                return true;
            }
            String str = (String) iVar.pox.get(DownloadSettingTable$Columns.TYPE);
            if ("text".equals(str)) {
                return a(iVar, string, j);
            }
            if ("link".equals(str)) {
                JSONObject jSONObject = new JSONObject((String) iVar.pox.get(SlookAirButtonFrequentContactAdapter.DATA));
                str = jSONObject.optString("link");
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("desc");
                String optString3 = jSONObject.optString("imgUrl");
                if (bh.ov(optString) && bh.ov(optString2)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else if (bh.ov(str)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else {
                    String str2;
                    IMediaObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = str;
                    this.fzc = new WXMediaMessage();
                    this.fzc.mediaObject = wXWebpageObject;
                    this.fzc.title = optString;
                    this.fzc.description = optString2;
                    str = (String) iVar.pox.get("appid");
                    if (this.tHs == null || !TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = this.tHs.getString("jsapi_args_appid");
                    }
                    f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str2, true);
                    if (this.context == null || this.context.getResources() == null) {
                        x.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    } else if (this.context instanceof Activity) {
                        com.tencent.mm.pluginsdk.ui.applet.e.a(((MMActivity) this.context).mController, optString, optString3, optString2, null, true, this.context.getResources().getString(R.l.dGA), new 91(this, optString3, j, aZ, str2, string, iVar));
                        return true;
                    } else {
                        x.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    }
                }
            }
            a(iVar, "sendEnterpriseChat:fail_params error", null);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
    }

    private boolean a(i iVar, String str, long j) {
        String optString = new JSONObject((String) iVar.pox.get(SlookAirButtonFrequentContactAdapter.DATA)).optString("content");
        if (bh.ov(optString)) {
            a(iVar, "sendEnterpriseChat:fail_params error", null);
        } else {
            boolean m;
            com.tencent.mm.ag.a.c ag = y.Mh().ag(j);
            synchronized (com.tencent.mm.ag.a.e.hqR) {
                String HD = com.tencent.mm.ag.a.e.HD();
                com.tencent.mm.ag.a.e.d(ag);
                com.tencent.mm.sdk.b.b orVar = new or();
                orVar.fGI.fGJ = str;
                orVar.fGI.content = optString;
                orVar.fGI.type = com.tencent.mm.z.s.hp(str);
                orVar.fGI.flags = 0;
                m = com.tencent.mm.sdk.b.a.xef.m(orVar);
                com.tencent.mm.ag.a.e.ks(HD);
            }
            if (m) {
                a(iVar, "sendEnterpriseChat:ok", null);
                if (this.context != null) {
                    h.bu(this.context, this.context.getResources().getString(R.l.dGG));
                }
            } else {
                a(iVar, "sendEnterpriseChat:fail", null);
            }
        }
        return true;
    }

    private boolean aG(i iVar) {
        x.i("MicroMsg.MsgHandler", "start doChangePayActivityView");
        com.tencent.mm.sdk.b.b amVar = new am();
        String str = (String) iVar.pox.get("showInfo");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            amVar.foz.foB = jSONObject.getString("buttonTitle");
            str = jSONObject.getString("isButtonEnable");
            String string = jSONObject.getString("isButtonHidden");
            String string2 = jSONObject.getString("isActivityViewHidden");
            x.i("MicroMsg.MsgHandler", "isButtonEnable:" + str + " isButtonHidden:" + string + " isActivityViewHidden:" + string2);
            amVar.foz.foC = bh.getInt(str, 0) > 0;
            am.a aVar = amVar.foz;
            if (bh.getInt(string, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.foD = z;
            am.a aVar2 = amVar.foz;
            if (bh.getInt(string2, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar2.foE = z;
            com.tencent.mm.sdk.b.a.xef.m(amVar);
            if (amVar.foA.fnI) {
                x.i("MicroMsg.MsgHandler", "changePayActivityView:ok");
                a(iVar, "changePayActivityView:ok", null);
            } else {
                x.i("MicroMsg.MsgHandler", "changePayActivityView:fail");
                a(iVar, "changePayActivityView:fail", null);
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
    }

    private boolean aH(i iVar) {
        String str = (String) iVar.pox.get("idKeyDataInfo");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "idkey data is null");
            a(iVar, "reportIDKey:fail_invaild_parms", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(bh.getInt(optJSONObject.optString(SlookAirButtonFrequentContactAdapter.ID), 0));
                    iDKey.SetKey(bh.getInt(optJSONObject.optString("key"), 0));
                    iDKey.SetValue((long) bh.getInt(optJSONObject.optString(DownloadSettingTable$Columns.VALUE), 0));
                    arrayList.add(iDKey);
                }
                if (arrayList.size() > 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
                    a(iVar, "reportIDKey:ok", null);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "parse json array faild : %s", new Object[]{e.getMessage()});
            }
            a(iVar, "reportIDKey:fail", null);
        }
        return false;
    }

    private boolean aI(i iVar) {
        String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openCunstonWebview:fail_invalid_url", null);
            return true;
        }
        int i;
        boolean z;
        String str2;
        boolean z2;
        boolean z3;
        Object obj;
        boolean z4;
        String ou;
        String ou2;
        boolean z5;
        String ou3;
        Intent intent;
        com.tencent.mm.sdk.b.b kjVar;
        String ou4 = bh.ou((String) iVar.pox.get("orientation"));
        if (!bh.ov(ou4)) {
            if (ou4.equals("horizontal")) {
                i = 0;
            } else if (ou4.equals("vertical")) {
                i = 1;
            } else if (ou4.equals("sensor")) {
                i = 4;
            }
            if (bh.ou((String) iVar.pox.get("fullscreen")).equals("true")) {
                z = false;
            } else {
                z = true;
            }
            str2 = (String) iVar.pox.get("top_url");
            ou4 = (String) iVar.pox.get("top_title");
            z2 = false;
            if (this.fBH != null) {
                z2 = this.fBH.e(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
            obj = null;
            if (bh.ou((String) iVar.pox.get("finish_recent_webview")).equals("1")) {
                obj = 1;
            }
            z4 = false;
            if (bh.ou((String) iVar.pox.get("disable_swipe_back")).equals("1")) {
                z4 = true;
            }
            ou = bh.ou((String) iVar.pox.get("username"));
            ou2 = bh.ou((String) iVar.pox.get("open_game_webview"));
            z2 = false;
            if (this.fBH != null) {
                z2 = this.fBH.e(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
            ou3 = bh.ou((String) iVar.pox.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z);
            intent.putExtra("disable_swipe_back", z4);
            intent.putExtra("from_shortcut", z3);
            intent.putExtra("shortcut_user_name", ou);
            if (!(bh.ov(str2) || bh.ov(ou4))) {
                intent.putExtra("keep_top_scene", 2);
                intent.putExtra("custom_keep_top_url", str2);
                intent.putExtra("custom_keep_top_title", ou4);
            }
            intent.putExtra("is_from_keep_top", z5);
            intent.putExtra("game_hv_menu_appid", ou3);
            if (z3) {
                com.tencent.mm.bm.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
            } else if (bh.ou(ou2).equals("1")) {
                com.tencent.mm.bm.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                kjVar = new kj();
                kjVar.fBG.type = 0;
                kjVar.fBG.context = this.context;
                kjVar.fBG.intent = intent;
                kjVar.fBG.fBH = this.fBH;
                com.tencent.mm.sdk.b.a.xef.m(kjVar);
            }
            if (!(obj == null || z3)) {
                ag.h(new Runnable(this) {
                    final /* synthetic */ g tIj;

                    {
                        this.tIj = r1;
                    }

                    public final void run() {
                        try {
                            this.tIj.o(new i());
                        } catch (Exception e) {
                            x.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", new Object[]{e.getMessage()});
                        }
                    }
                }, 200);
            }
            kjVar = new gn();
            kjVar.fwD.pK = 2;
            kjVar.fwD.fwF = ou3;
            com.tencent.mm.sdk.b.a.xef.m(kjVar);
            a(iVar, "openCunstonWebview:ok", null);
            return true;
        }
        i = -1;
        if (bh.ou((String) iVar.pox.get("fullscreen")).equals("true")) {
            z = false;
        } else {
            z = true;
        }
        str2 = (String) iVar.pox.get("top_url");
        ou4 = (String) iVar.pox.get("top_title");
        z2 = false;
        try {
            if (this.fBH != null) {
                z2 = this.fBH.e(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from shortcut exception : %s", new Object[]{e.getMessage()});
            z3 = false;
        }
        obj = null;
        if (bh.ou((String) iVar.pox.get("finish_recent_webview")).equals("1")) {
            obj = 1;
        }
        z4 = false;
        if (bh.ou((String) iVar.pox.get("disable_swipe_back")).equals("1")) {
            z4 = true;
        }
        ou = bh.ou((String) iVar.pox.get("username"));
        ou2 = bh.ou((String) iVar.pox.get("open_game_webview"));
        z2 = false;
        try {
            if (this.fBH != null) {
                z2 = this.fBH.e(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from keep top exception : %s", new Object[]{e2.getMessage()});
            z5 = false;
        }
        ou3 = bh.ou((String) iVar.pox.get("gameAppid"));
        intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("screen_orientation", i);
        intent.putExtra("show_full_screen", z);
        intent.putExtra("disable_swipe_back", z4);
        intent.putExtra("from_shortcut", z3);
        intent.putExtra("shortcut_user_name", ou);
        intent.putExtra("keep_top_scene", 2);
        intent.putExtra("custom_keep_top_url", str2);
        intent.putExtra("custom_keep_top_title", ou4);
        intent.putExtra("is_from_keep_top", z5);
        intent.putExtra("game_hv_menu_appid", ou3);
        if (z3) {
            com.tencent.mm.bm.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
        } else if (bh.ou(ou2).equals("1")) {
            com.tencent.mm.bm.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        } else {
            kjVar = new kj();
            kjVar.fBG.type = 0;
            kjVar.fBG.context = this.context;
            kjVar.fBG.intent = intent;
            kjVar.fBG.fBH = this.fBH;
            com.tencent.mm.sdk.b.a.xef.m(kjVar);
        }
        ag.h(/* anonymous class already generated */, 200);
        kjVar = new gn();
        kjVar.fwD.pK = 2;
        kjVar.fwD.fwF = ou3;
        com.tencent.mm.sdk.b.a.xef.m(kjVar);
        a(iVar, "openCunstonWebview:ok", null);
        return true;
    }

    private boolean aJ(i iVar) {
        String ou = bh.ou((String) iVar.pox.get("orientation"));
        int i = -1;
        if (!bh.ov(ou)) {
            if (ou.equals("horizontal")) {
                i = 0;
            } else if (ou.equals("vertical")) {
                i = 1;
            } else if (ou.equals("sensor")) {
                i = 4;
            } else if (ou.equals("horizontal_unforced")) {
                i = 1001;
            } else if (ou.equals("vertical_unforced")) {
                i = 1002;
            }
        }
        try {
            if (this.fBH != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", i);
                this.fBH.e(HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION, bundle);
                a(iVar, "setScreenOrientation:ok", null);
            } else {
                a(iVar, "setScreenOrientation:fail", null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doSetScreenOrientation exception, " + e.getMessage());
            a(iVar, "setScreenOrientation:fail", null);
        }
        return true;
    }

    private boolean aK(i iVar) {
        x.i("MicroMsg.MsgHandler", "setNavigationBarColor");
        boolean equals = "1".equals((String) iVar.pox.get("actionCode"));
        Bundle bundle = new Bundle();
        if (equals) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            int parseColor;
            int i;
            try {
                parseColor = Color.parseColor((String) iVar.pox.get("color")) | WebView.NIGHT_MODE_COLOR;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", e.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                parseColor = -1;
            }
            try {
                i = (int) (bh.getFloat((String) iVar.pox.get("alpha"), 1.0f) * 255.0f);
                if (i < 0 || i > 255) {
                    i = 255;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", e2.getMessage());
                i = -1;
            }
            bundle.putInt("set_navigation_bar_color_color", parseColor);
            bundle.putInt("set_navigation_bar_color_alpha", i);
        }
        try {
            this.fBH.e(53, bundle);
            a(iVar, "setNavigationBarColor:ok", null);
        } catch (Exception e22) {
            x.e("MicroMsg.MsgHandler", e22.getMessage());
            a(iVar, "setNavigationBarColor:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("emoji_store_json_data", str);
        bundle.putBoolean("emoji_store_new_query", z);
        bundle.putString("emoji_store_page_buf", str2);
        bundle.putLong("emoji_store_search_id", j);
        x.d("MicroMsg.MsgHandler", "cpan emoji getSearchEmotionDataCallBack:%d", new Object[]{Long.valueOf(j)});
        try {
            if (this.fBH != null) {
                this.fBH.n(80001, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "getSearchEmotionDataCallBack exception" + e.getMessage());
        }
    }

    private boolean kC(boolean z) {
        x.e("MicroMsg.MsgHandler", "hideMenuEntry:" + z);
        try {
            this.fBH.kq(z);
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            x.e("MicroMsg.MsgHandler", "hideMenuEntry error");
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return false;
        } catch (Throwable th) {
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        }
    }

    private boolean aL(final i iVar) {
        x.i("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact");
        String str = (String) iVar.pox.get("openid");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact openid is null");
            a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
        } else {
            String str2 = (String) iVar.pox.get("appId");
            if (this.tHs != null && TextUtils.isEmpty(str2)) {
                str2 = this.tHs.getString("jsapi_args_appid");
            }
            if (bh.ov(str2)) {
                x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact appid is null");
                a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
            } else {
                this.fzc = f(iVar);
                final k vVar = new v(str2, str);
                ar.CG().a(1142, new com.tencent.mm.ae.e(this) {
                    final /* synthetic */ g tIj;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (this.tIj.iln != null && this.tIj.iln.isShowing()) {
                            this.tIj.iln.dismiss();
                            this.tIj.iln = null;
                        }
                        if (i == 0 && i2 == 0) {
                            boh com_tencent_mm_protocal_c_boh;
                            v vVar = (v) kVar;
                            if (vVar.gJQ == null) {
                                com_tencent_mm_protocal_c_boh = null;
                            } else {
                                com_tencent_mm_protocal_c_boh = (boh) vVar.gJQ.hmh.hmo;
                            }
                            if (com_tencent_mm_protocal_c_boh != null) {
                                String str2 = com_tencent_mm_protocal_c_boh.username;
                                if (bh.ov(str2)) {
                                    x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
                                } else if (this.tIj.context instanceof MMActivity) {
                                    if (g.a(this.tIj, str2, (String) iVar.pox.get("title"), (String) iVar.pox.get("img_url"), str2, (String) iVar.pox.get("desc"), (String) iVar.pox.get("src_username"), (String) iVar.pox.get("src_displayname"), "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") == null) {
                                        x.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
                                        this.tIj.a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            x.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
                        } else {
                            x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
                        }
                        this.tIj.a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                    }
                });
                ar.CG().a(vVar, 0);
                Context context = this.context;
                this.context.getString(R.l.dGO);
                this.iln = h.a(context, this.context.getString(R.l.dHc), true, new OnCancelListener(this) {
                    final /* synthetic */ g tIj;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ar.CG().c(vVar);
                    }
                });
            }
        }
        return true;
    }

    private boolean bUE() {
        try {
            Bundle bundle = new Bundle(1);
            bundle.putString("place_holder", "place_holder");
            this.fBH.bRO();
            this.fBH.O(bundle);
        } catch (Exception e) {
        }
        return true;
    }

    public final boolean aM(i iVar) {
        x.i("MicroMsg.MsgHandler", "doWCPayRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.fBH.aeq();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bh.ov(str)) {
            intent.putExtra("appId", this.tHB.PB(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fCT);
            try {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, this.fBH.aeq());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("pay_channel", gVar.fqJ);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 34);
        }
        return true;
    }

    public final boolean bUF() {
        x.i("MicroMsg.MsgHandler", "doSwitchWalletCurrency call");
        ((MMActivity) this.context).jwN = this;
        com.tencent.mm.bm.d.b(this.context, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", null, 35);
        return true;
    }

    private boolean aN(i iVar) {
        boolean z;
        String str = (String) iVar.pox.get("clearCookie");
        x.i("MicroMsg.MsgHandler", "clearflag = %s", new Object[]{str});
        if (bh.ov(str) || !str.equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (!bh.ov(str)) {
            str = com.tencent.mm.plugin.webview.modelcache.p.Oy(str);
            if (bh.ov(str)) {
                str = null;
            } else {
                Uri parse = Uri.parse(str);
                str = parse.getHost() + ":" + parse.getPort();
            }
            if (!bh.ov(str)) {
                com.tencent.mm.plugin.webview.modelcache.q.a.bRp().Dm().F(new 108(this, str));
            }
        }
        if (this.fBH != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("clear_webview_cache_clear_cookie", z);
            try {
                this.fBH.e(6001, bundle);
                a(iVar, "clearWebviewCache:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
                a(iVar, "clearWebviewCache:fail", null);
            }
        } else {
            a(iVar, "clearWebviewCache:fail", null);
        }
        return true;
    }

    public final boolean aO(i iVar) {
        x.i("MicroMsg.MsgHandler", "doIdCardRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.pox);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.fBH.aeq();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bh.ov(str)) {
            intent.putExtra("appId", this.tHB.PB(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fCT);
            try {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, this.fBH.aeq());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.putExtra("pay_channel", gVar.fqJ);
            intent.putExtra("real_name_verify_mode", 2);
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 41);
        }
        return true;
    }

    public final boolean aP(i iVar) {
        a(iVar, "uploadIdCardSuccess:ok", null);
        x.i("MicroMsg.MsgHandler", "uploadIdCardSuccess");
        com.tencent.mm.sdk.b.b tgVar = new tg();
        tgVar.fLJ.result = -1;
        com.tencent.mm.sdk.b.a.xef.m(tgVar);
        return true;
    }

    public final boolean aQ(i iVar) {
        x.i("MicroMsg.MsgHandler", "getGameCommInfo call");
        int i = bh.getInt((String) iVar.pox.get("cmd"), 0);
        String str = (String) iVar.pox.get("param");
        Map hashMap;
        if (i != 10002) {
            com.tencent.mm.sdk.b.b gnVar = new gn();
            gnVar.fwD.pK = i;
            gnVar.fwD.fwF = str;
            gnVar.fwD.context = this.context;
            com.tencent.mm.sdk.b.a.xef.m(gnVar);
            x.i("MicroMsg.MsgHandler", "gameCommInfo:%s", new Object[]{gnVar.fwE.result});
            if (bh.ov(gnVar.fwE.result)) {
                a(iVar, "getGameCommInfo:fail", null);
            } else {
                try {
                    hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(gnVar.fwE.result);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    a(iVar, "getGameCommInfo:ok", hashMap);
                } catch (JSONException e) {
                    a(iVar, "getGameCommInfo:fail", null);
                }
            }
        } else if (this.fBH != null) {
            try {
                Bundle e2 = this.fBH.e(97, null);
                if (e2 != null) {
                    int i2 = e2.getInt("web_page_count");
                    hashMap = new HashMap();
                    hashMap.put("webpageCount", Integer.valueOf(i2));
                    a(iVar, "getGameCommInfo:ok", hashMap);
                }
            } catch (RemoteException e3) {
                x.e("MicroMsg.MsgHandler", "doGetGameCommInfo exception, " + e3.getMessage());
                a(iVar, "getGameCommInfo:fail", null);
            }
        }
        return true;
    }

    public final boolean bUG() {
        x.i("MicroMsg.MsgHandler", "openGameRegion call");
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.a(this.context, "game", ".ui.GameRegionSelectUI", null, 42, false);
        }
        return true;
    }

    public final boolean aR(i iVar) {
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.context);
        lVar.b(null, new 109(this), new 110(this, iVar));
        lVar.e(new 111(this, iVar));
        lVar.bBX();
        return true;
    }

    private boolean aS(i iVar) {
        String str;
        if (this.tHs != null) {
            int i = this.tHs.getInt("key_download_restrict", 0);
            if (!bh.ov(this.tHs.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14596, new Object[]{str, Integer.valueOf(i), Integer.valueOf(1)});
            }
            if (i == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to launch application");
                a(iVar, "launchApplication:fail", null);
                return true;
            }
        }
        x.i("MicroMsg.MsgHandler", "launchTimeInterval = %d", new Object[]{Long.valueOf(bh.Wo() - this.tHF)});
        if (bh.Wo() - this.tHF < 2 && this.tHF > 0) {
            try {
                String encode = URLEncoder.encode(this.fBH.aeq(), "UTF-8");
                com.tencent.mm.plugin.report.service.g.pQN.h(13983, new Object[]{Integer.valueOf(5), encode, ""});
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "report launchApplication failed");
            }
        }
        String str2 = (String) iVar.pox.get("appID");
        String str3 = (String) iVar.pox.get("schemeUrl");
        String str4 = (String) iVar.pox.get("parameter");
        int i2 = bh.getInt((String) iVar.pox.get("alertType"), 0);
        k.a(iVar.tJH, false, null, str2);
        x.i("MicroMsg.MsgHandler", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{str2, str3, (String) iVar.pox.get("extInfo"), str4});
        if (bh.ov(str2) && bh.ov(str3)) {
            x.e("MicroMsg.MsgHandler", "appid and scheme is null or nil");
            a(iVar, "launchApplication:fail", null);
            return true;
        }
        Object obj = iVar.pox.get("__jsapi_fw_ext_info");
        str = null;
        if (obj instanceof Bundle) {
            str = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        }
        String PB = this.tHB.PB(str);
        Bundle bundle = new Bundle();
        if (!bh.ov(str)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
            }
        }
        bundle.putString("current_page_appid", PB);
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new alv();
        aVar.hmk = new alw();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.hmi = 1125;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        alv com_tencent_mm_protocal_c_alv = (alv) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_alv.fFm = PB;
        com_tencent_mm_protocal_c_alv.wsO = str2;
        com_tencent_mm_protocal_c_alv.scene = ahG();
        com_tencent_mm_protocal_c_alv.url = str;
        com_tencent_mm_protocal_c_alv.wsP = str3;
        com_tencent_mm_protocal_c_alv.liK = i2;
        com_tencent_mm_protocal_c_alv.wsQ = 0;
        x.i("MicroMsg.MsgHandler", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{PB, str2, Integer.valueOf(com_tencent_mm_protocal_c_alv.scene), com_tencent_mm_protocal_c_alv.url, com_tencent_mm_protocal_c_alv.wsP, Integer.valueOf(com_tencent_mm_protocal_c_alv.liK)});
        u.a(JZ, new 113(this, iVar, str3, bundle, r5, str2, str4));
        return true;
    }

    private boolean a(i iVar, a aVar) {
        String aeq;
        x.i("MicroMsg.MsgHandler", "doLogin!");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        try {
            aeq = this.fBH.aeq();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = null;
        }
        String ou = bh.ou(this.tHB.PB(aeq));
        if (bh.ov(ou)) {
            x.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "doLogin:fail", null);
            aVar.afC();
            return false;
        }
        ar.CG().a(new com.tencent.mm.u.a.c(ou, linkedList, str2, str, new 117(this, iVar, aVar, ou)), 0);
        return true;
    }

    private boolean b(i iVar, a aVar) {
        x.i("MicroMsg.MsgHandler", "doOauthAuthorize!");
        String str = (String) iVar.pox.get("scope");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "scope is null!");
            a(iVar, "authorize:fail", null);
            aVar.afC();
            return true;
        }
        String aeq;
        try {
            aeq = this.fBH.aeq();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            aeq = null;
        }
        aeq = bh.ou(this.tHB.PB(aeq));
        if (bh.ov(aeq)) {
            x.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "authorize:fail", null);
            aVar.afC();
            return false;
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            ar.CG().a(new com.tencent.mm.u.a.a(aeq, linkedList, new 4(this, iVar, aVar, aeq)), 0);
            return true;
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "Exception %s", new Object[]{e2.getMessage()});
            a(iVar, "authorize:fail", null);
            return true;
        }
    }

    public final void em(int i, int i2) {
        String str = "";
        String str2 = " ";
        Bundle bundle = null;
        try {
            if (this.fBH != null) {
                bundle = this.fBH.e(77, null);
            }
            if (bundle != null) {
                str = bundle.getString("KUrl");
                if (TextUtils.isEmpty(str)) {
                    x.e("MicroMsg.MsgHandler", "url is empty");
                    return;
                }
                x.i("MicroMsg.MsgHandler", "sessionId %s", new Object[]{bh.ou(bundle.getString("KSessionId"))});
                if (!bundle.getBoolean("KReportPage", false)) {
                    x.i("MicroMsg.MsgHandler", "not enable report page event control bytes");
                    return;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e});
        }
        if (TextUtils.isEmpty(qE(str))) {
            x.i("MicroMsg.MsgHandler", "appId is null or empty");
            return;
        }
        x.i("MicroMsg.MsgHandler", "appId %s", new Object[]{qE(str)});
        x.i("MicroMsg.MsgHandler", "type %d", new Object[]{Integer.valueOf(this.fzc.mediaObject.type())});
        if (this.fzc.mediaObject.type() == 5) {
            long Wo = bh.Wo();
            x.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Wo), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
            String str3 = "";
            try {
                str = URLEncoder.encode(bh.ou(str), "UTF-8");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                str = str3;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13377, new Object[]{Long.valueOf(Wo), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.MsgHandler", "mmOnActivityResult, requestCode = " + i + ", resultCode = " + i2);
        String str;
        SnsAdClick snsAdClick;
        Object obj;
        String str2;
        String str3;
        String str4;
        String str5;
        String bUx;
        int i3;
        int i4;
        if (i == 1) {
            if (this.fzc == null) {
                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.tHp, "send_app_msg:fail", null);
                return;
            }
            String string;
            f Hg;
            str = (String) this.tHp.pox.get("appid");
            snsAdClick = null;
            if (this.tHs != null) {
                snsAdClick = (SnsAdClick) this.tHs.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.tHs.getString("jsapi_args_appid");
                    obj = this.tHp.bUN().get("Internal@AsyncReport");
                    this.tHp.pox.get("link");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.it(7);
                            }
                            Hg = com.tencent.mm.pluginsdk.model.app.g.Hg(string);
                            if (intent != null) {
                                str2 = null;
                            } else {
                                str2 = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str2 != null || str2.length() == 0) {
                                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                a(this.tHp, "send_app_msg:fail", null);
                                return;
                            }
                            str3 = (String) this.tHp.pox.get("img_url");
                            this.tHp.pox.get("desc");
                            str4 = (String) this.tHp.pox.get("src_username");
                            str5 = (String) this.tHp.pox.get("src_displayname");
                            bUx = bUx();
                            k.a(this.tHp.bUN(), PI(GameJsApiSendAppMessage.NAME), str2, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.tHp, true);
                            }
                            String[] split = str2.split(",");
                            i3 = 0;
                            int i5 = 0;
                            int length = split.length;
                            int i6 = 0;
                            while (i6 < length) {
                                if (split[i6].endsWith("@chatroom")) {
                                    i4 = i3 + 1;
                                    i3 = i5;
                                } else {
                                    int i7 = i3;
                                    i3 = i5 + 1;
                                    i4 = i7;
                                }
                                i6++;
                                i5 = i3;
                                i3 = i4;
                            }
                            Map hashMap = new HashMap();
                            if (this.tHp.pox.get("share_callback_with_scene") != null && ((Boolean) this.tHp.pox.get("share_callback_with_scene")).booleanValue()) {
                                hashMap.put("groupCount", Integer.valueOf(i3));
                                hashMap.put("singleCount", Integer.valueOf(i5));
                            }
                            if (bh.ov(bUx)) {
                                a(null, "", str2, str3, str4, str5, intent == null ? null : intent.getStringExtra("custom_send_text"), bUx);
                                if (this.context != null) {
                                    h.br(this.context, this.context.getResources().getString(R.l.dGG));
                                }
                                em(1, 1);
                                a(this.tHp, "send_app_msg:ok", hashMap);
                                return;
                            } else if (bh.ov(str3)) {
                                a(null, "", str2, str3, str4, str5, null, bUx);
                                h.br(this.context, this.context.getString(R.l.dGy));
                                a(this.tHp, "send_app_msg:ok", hashMap);
                                return;
                            } else {
                                o.Pv().a(str3, new 6(this, h.a(this.context, this.context.getResources().getString(R.l.dGB), true, new 5(this, str3)), Hg, string, str2, str3, str4, str5, bUx, hashMap));
                                return;
                            }
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.it(8);
                            }
                            k.a(this.tHp.bUN(), PI(GameJsApiSendAppMessage.NAME), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.tHp, true);
                            }
                            em(1, 3);
                            a(this.tHp, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            string = str;
            obj = this.tHp.bUN().get("Internal@AsyncReport");
            this.tHp.pox.get("link");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.it(7);
                    }
                    Hg = com.tencent.mm.pluginsdk.model.app.g.Hg(string);
                    if (intent != null) {
                        str2 = intent.getStringExtra("Select_Conv_User");
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        break;
                    }
                    x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                    a(this.tHp, "send_app_msg:fail", null);
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.it(8);
                    }
                    k.a(this.tHp.bUN(), PI(GameJsApiSendAppMessage.NAME), null, string);
                    b(this.tHp, true);
                    em(1, 3);
                    a(this.tHp, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    h.br(this.context, this.context.getResources().getString(R.l.dGG));
                    a(this.tHp, "share_weibo:ok", null);
                    return;
                case 0:
                    a(this.tHp, "share_weibo:cancel", null);
                    return;
                case 1:
                    a(this.tHp, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    return;
                default:
                    a(this.tHp, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    x.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 3) {
            x.i("MicroMsg.MsgHandler", "get callback address, result code = %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1 && intent != null) {
                str = bh.az(intent.getStringExtra("nationalCode"), "");
                r3 = bh.az(intent.getStringExtra("userName"), "");
                r4 = bh.az(intent.getStringExtra("telNumber"), "");
                str2 = bh.az(intent.getStringExtra("addressPostalCode"), "");
                str3 = bh.az(intent.getStringExtra("proviceFirstStageName"), "");
                str4 = bh.az(intent.getStringExtra("addressCitySecondStageName"), "");
                str5 = bh.az(intent.getStringExtra("addressCountiesThirdStageName"), "");
                r9 = bh.az(intent.getStringExtra("addressDetailInfo"), "");
                x.i("MicroMsg.MsgHandler", "first =  " + str3 + " ; detail =" + r9 + "; second = " + str4 + " ; tel = " + r4 + "; third = " + str5);
                if (!bh.ov(r3)) {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("nationalCode", str);
                    hashMap2.put("userName", r3);
                    hashMap2.put("telNumber", r4);
                    hashMap2.put("addressPostalCode", str2);
                    hashMap2.put("proviceFirstStageName", str3);
                    hashMap2.put("addressCitySecondStageName", str4);
                    hashMap2.put("addressCountiesThirdStageName", str5);
                    hashMap2.put("addressDetailInfo", r9);
                    a(this.tHp, "edit_address:ok", hashMap2);
                    return;
                }
            }
            if (i2 == 0) {
                a(this.tHp, "edit_address:cancel", null);
            } else {
                a(this.tHp, "edit_address:fail", null);
            }
        } else if (i == 4) {
            x.i("MicroMsg.MsgHandler", "request pay, resultCode = " + i2);
            if (this.tHH != -1) {
                x.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.tHp = Ba(this.tHH).tHp;
                this.fBH = Ba(this.tHH).fBH;
                this.tHH = -1;
            }
            if (i2 == -1) {
                a(this.tHp, "get_brand_wcpay_request:ok", null);
            } else if (i2 == 5) {
                r2 = new HashMap();
                i3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                r4 = bh.ou(intent.getStringExtra("key_jsapi_pay_err_msg"));
                r2.put("err_code", Integer.valueOf(i3));
                r2.put("err_desc", r4);
                x.e("MicroMsg.MsgHandler", "hy: pay jsapi failed. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i3), r4});
                a(this.tHp, "get_brand_wcpay_request:fail", r2);
            } else {
                a(this.tHp, "get_brand_wcpay_request:cancel", null);
            }
        } else if (i == 27) {
            x.i("MicroMsg.MsgHandler", "request ibg prepay request, resultCode = " + i2);
            if (this.tHH != -1) {
                x.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.tHp = Ba(this.tHH).tHp;
                this.fBH = Ba(this.tHH).fBH;
                this.tHH = -1;
            }
            if (i2 == -1) {
                if (intent != null) {
                    if (intent.hasExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
                        str = null;
                        if (intent.hasExtra("view_port_code")) {
                            str = intent.getStringExtra("view_port_code");
                        }
                        try {
                            this.fBH.eN(intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), str);
                        } catch (RemoteException e) {
                        }
                    }
                }
                a(this.tHp, "get_h5_prepay_request:ok", null);
                return;
            }
            a(this.tHp, "get_h5_prepay_request:cancel", null);
        } else if (i == 5) {
            x.i("MicroMsg.MsgHandler", "request jump to mall, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "jump_wcmall:ok", null);
            } else {
                a(this.tHp, "jump_wcmall:fail", null);
            }
        } else if (i == 6) {
            x.i("MicroMsg.MsgHandler", "request jump to product view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "open_product_view:ok", null);
            } else {
                a(this.tHp, "open_product_view:fail", null);
            }
        } else if (i == 7) {
            x.i("MicroMsg.MsgHandler", "request bind card, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "get_brand_wcpay_bind_card_request:ok", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_brand_wcpay_bind_card_request:ok"});
            } else {
                a(this.tHp, "get_brand_wcpay_bind_card_request:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_brand_wcpay_bind_card_request:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 9) {
            x.i("MicroMsg.MsgHandler", "request open wxcredit, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "get_wcpay_create_credit_card_request:ok", null);
            } else {
                a(this.tHp, "get_wcpay_create_credit_card_request:fail", null);
            }
        } else if (i == 8) {
            x.i("MicroMsg.MsgHandler", "request jumpToBizProfile, resultCode = " + i2);
            switch (i2) {
                case -1:
                    a(this.tHp, "jump_to_biz_profile:ok", null);
                    return;
                case 0:
                    a(this.tHp, "jump_to_biz_profile:cancel", null);
                    return;
                case 2:
                case 3:
                    a(this.tHp, "jump_to_biz_profile:check_fail", null);
                    return;
                default:
                    a(this.tHp, "jump_to_biz_profile:fail", null);
                    x.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 10) {
            if (i2 == 0) {
                x.i("MicroMsg.MsgHandler", "open scan product ui back");
                a(this.tHp, "open_scan_product_view:ok", null);
            }
        } else if (i == 11) {
            x.i("MicroMsg.MsgHandler", "request transfer_money, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "get_transfer_money_request:ok", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_transfer_money_request:ok"});
            } else {
                a(this.tHp, "get_transfer_money_request:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_transfer_money_request:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 17) {
            x.i("MicroMsg.MsgHandler", "request open_wcpay_specific_view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "open_wcpay_specific_view:ok", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "open_wcpay_specific_view:ok"});
            } else {
                a(this.tHp, "open_wcpay_specific_view:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "open_wcpay_specific_view:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 18) {
            x.i("MicroMsg.MsgHandler", "request request_wcpay_send_c2c_msg, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "get_send_c2c_message_request:ok", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_send_c2c_message_request:ok"});
            } else if (i2 == 0) {
                a(this.tHp, "get_send_c2c_message_request:cancel", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_send_c2c_message_request:cancel"});
            } else {
                a(this.tHp, "get_send_c2c_message_request:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_send_c2c_message_request:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 13) {
            x.d("MicroMsg.MsgHandler", "request choose card, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_card_info", bh.az(intent.getStringExtra("choose_card_info"), ""));
                }
                a(this.tHp, "choose_card:ok", r2);
            } else if (i2 == 0) {
                a(this.tHp, "choose_card:cancel", r2);
            } else {
                a(this.tHp, "choose_card:fail", r2);
            }
        } else if (i == 36) {
            x.d("MicroMsg.MsgHandler", "request choose invoice, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_invoice_info", bh.az(intent.getStringExtra("choose_invoice_info"), ""));
                }
                a(this.tHp, "choose_invoice:ok", r2);
            } else if (i2 == 0) {
                a(this.tHp, "choose_invoice:cancel", r2);
            } else {
                a(this.tHp, "choose_invoice:fail", r2);
            }
        } else if (i == 16) {
            x.d("MicroMsg.MsgHandler", "request batch add card, resultCode = " + i2);
            r3 = new HashMap();
            if (intent != null) {
                r3.put("card_list", bh.az(intent.getStringExtra("card_list"), ""));
            }
            if (i2 == -1) {
                a(this.tHp, "batch_add_card:ok", r3);
                return;
            }
            i4 = 2;
            if (intent != null) {
                i4 = intent.getIntExtra("result_code", 2);
            }
            if (i4 == 2) {
                a(this.tHp, "batch_add_card:fail", r3);
            } else {
                a(this.tHp, "batch_add_card:cancel", r3);
            }
        } else if (i == 23) {
            if (i2 == -1) {
                a(this.tHp, "batch_view_card:ok", null);
            } else {
                a(this.tHp, "batch_view_card:fail", null);
            }
        } else if (i == 15) {
            if (this.tHp == null || bh.ov(this.tHp.tJI)) {
                x.e("MicroMsg.MsgHandler", "msg is null");
                return;
            }
            x.i("MicroMsg.MsgHandler", "request to scan qr code, result code = %d, function is %s", new Object[]{Integer.valueOf(i2), this.tHp.tJI});
            if (this.tHp.tJI.equals("scanQRCode")) {
                switch (i2) {
                    case -1:
                        r2 = new HashMap();
                        if (intent != null) {
                            r2.put("resultStr", intent.getStringExtra("key_scan_result"));
                        }
                        a(this.tHp, "scanQRCode:ok", r2);
                        return;
                    case 0:
                        a(this.tHp, "scanQRCode:cancel", null);
                        return;
                    default:
                        a(this.tHp, "scanQRCode:fail", null);
                        return;
                }
            }
        } else if (i == 14) {
            x.i("MicroMsg.MsgHandler", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false))});
            r3 = new HashMap();
            if (intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false)) {
                r3.put("memoryWarning", Boolean.valueOf(true));
            }
            switch (i2) {
                case -1:
                    str = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    x.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{str});
                    if (!bh.ov(str)) {
                        r3.put("localIds", str);
                        str = intent.getStringExtra("key_pick_local_pic_source_type");
                        if (str != null) {
                            r3.put("sourceType", str);
                        }
                        a(this.tHp, "chooseImage:ok", r3);
                        return;
                    }
                    break;
                case 0:
                    a(this.tHp, "chooseImage:cancel", r3);
                    return;
            }
            a(this.tHp, "chooseImage:fail", r3);
        } else if (i == 32) {
            switch (i2) {
                case -1:
                    r3 = intent.getStringExtra("key_pick_local_media_local_id");
                    if (!bh.ov(r3)) {
                        r2 = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(r3);
                        if (r2 != null && (r2 instanceof WebViewJSSDKVideoItem)) {
                            r2 = (WebViewJSSDKVideoItem) r2;
                            Map hashMap3 = new HashMap();
                            hashMap3.put("localId", r3);
                            hashMap3.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(r2.duration));
                            hashMap3.put("height", Integer.valueOf(r2.height));
                            hashMap3.put("size", Integer.valueOf(r2.size));
                            hashMap3.put("width", Integer.valueOf(r2.width));
                            a(this.tHp, "chooseVideo:ok", hashMap3);
                            return;
                        }
                    }
                    a(this.tHp, "chooseVideo:fail", null);
                    return;
                case 0:
                    a(this.tHp, "chooseVideo:cancel", null);
                    return;
                default:
                    a(this.tHp, "chooseVideo:fail", null);
                    return;
            }
        } else if (i == 45) {
            switch (i2) {
                case -1:
                    r3 = intent.getStringExtra("key_pick_local_media_local_id");
                    r4 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                    x.i("MicroMsg.MsgHandler", "localId:%s", new Object[]{r3});
                    x.i("MicroMsg.MsgHandler", "thumbLocalId:%s", new Object[]{r4});
                    if (!bh.ov(r3)) {
                        r2 = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(r3);
                        if (r2 != null && (r2 instanceof WebViewJSSDKVideoItem)) {
                            r2 = (WebViewJSSDKVideoItem) r2;
                            Map hashMap4 = new HashMap();
                            hashMap4.put("localId", r3);
                            hashMap4.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(r2.duration));
                            hashMap4.put("height", Integer.valueOf(r2.height));
                            hashMap4.put("size", Integer.valueOf(r2.size));
                            hashMap4.put("width", Integer.valueOf(r2.width));
                            hashMap4.put("thumbLocalId", r4);
                            a(this.tHp, "recordVideo:ok", hashMap4);
                            return;
                        }
                    }
                    a(this.tHp, "recordVideo:fail", null);
                    return;
                case 0:
                    a(this.tHp, "recordVideo:cancel", null);
                    return;
                default:
                    a(this.tHp, "recordVideo:fail", null);
                    return;
            }
        } else if (i == 47) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA data is null,");
                        a(this.tHp, "chooseMedia:fail", null);
                        return;
                    }
                    i4 = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                    if (i4 == 1) {
                        str = intent.getStringExtra("key_pick_local_media_local_id");
                        r3 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                        x.i("MicroMsg.MsgHandler", "video localId:%s", new Object[]{str});
                        x.i("MicroMsg.MsgHandler", "video thumbLocalId:%s", new Object[]{r3});
                        if (bh.ov(str)) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                            a(this.tHp, "chooseMedia:fail", null);
                            return;
                        }
                        WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str);
                        if (Oo == null || !(Oo instanceof WebViewJSSDKVideoItem)) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                            a(this.tHp, "chooseMedia:fail", null);
                            return;
                        }
                        WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) Oo;
                        x.i("MicroMsg.MsgHandler", "after parse to json data : %s", new Object[]{ai.b(str, r3, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size)});
                        r3 = new HashMap();
                        r3.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(1));
                        r3.put("localIds", str);
                        a(this.tHp, "chooseMedia:ok", r3);
                        return;
                    } else if (i4 == 2) {
                        str = intent.getStringExtra("key_pick_local_media_local_ids");
                        x.i("MicroMsg.MsgHandler", "chooseMedia localIds:%s", new Object[]{str});
                        if (bh.ov(str)) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                            a(this.tHp, "chooseMedia:fail", null);
                            return;
                        }
                        r3 = new HashMap();
                        r3.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(2));
                        r3.put("localIds", str);
                        a(this.tHp, "chooseMedia:ok", r3);
                        return;
                    } else {
                        x.e("MicroMsg.MsgHandler", "type:%d is error", new Object[]{Integer.valueOf(i4)});
                        a(this.tHp, "chooseMedia:fail", null);
                        return;
                    }
                case 0:
                    a(this.tHp, "chooseMedia:cancel", null);
                    return;
                default:
                    a(this.tHp, "chooseMedia:fail", null);
                    return;
            }
        } else if (i == 46) {
            switch (i2) {
                case -1:
                    a(this.tHp, "previewVideo:ok", null);
                    return;
                case 0:
                    a(this.tHp, "previewVideo:cancel", null);
                    return;
                default:
                    a(this.tHp, "previewVideo:fail", null);
                    return;
            }
        } else if (i == 19) {
            x.i("MicroMsg.MsgHandler", "request to config exdevice wifi connection, result code = " + i2);
            switch (i2) {
                case -1:
                    a(this.tHp, "configWXDeviceWiFi:ok", null);
                    return;
                case 0:
                    r2 = null;
                    if (intent != null) {
                        if (!intent.getBooleanExtra("is_wifi_connected", true)) {
                            r2 = new HashMap();
                            r2.put("desc", "wifi_not_connected");
                        }
                    }
                    a(this.tHp, "configWXDeviceWiFi:cancel", r2);
                    return;
                case 1:
                    a(this.tHp, "configWXDeviceWiFi:fail", null);
                    return;
                default:
                    return;
            }
        } else if (i == 20) {
            x.i("MicroMsg.MsgHandler", "request request_verify_wcpay_password, resultCode = " + i2);
            r3 = new HashMap();
            if (i2 == -1) {
                CharSequence charSequence = "";
                if (intent != null) {
                    charSequence = bh.az(intent.getStringExtra("token"), "");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    x.i("MicroMsg.MsgHandler", "checkPwdToken is empty, verifyWCPayPassword:fail");
                    a(this.tHp, "verifyWCPayPassword:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "verifyWCPayPassword:fail"});
                    }
                } else {
                    r3.put("token", charSequence);
                    a(this.tHp, "verifyWCPayPassword:ok", r3);
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "verifyWCPayPassword:ok"});
                    x.i("MicroMsg.MsgHandler", "checkPwdToken is valid, verifyWCPayPassword:ok");
                }
            } else {
                x.i("MicroMsg.MsgHandler", "resultCode is canlcel, verifyWCPayPassword:fail");
                a(this.tHp, "verifyWCPayPassword:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "verifyWCPayPassword:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (21 == i) {
            x.d("MicroMsg.MsgHandler", "hy: callback to see order. directly finish");
            a(this.tHp, "see_order_ok", null);
        } else if (i == 22) {
            x.i("MicroMsg.MsgHandler", "request get_recevie_biz_hongbao_request, resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "get_recevie_biz_hongbao_request:ok", null);
            } else if (i == 0) {
                a(this.tHp, "get_recevie_biz_hongbao_request:cancel", null);
            } else {
                a(this.tHp, "get_recevie_biz_hongbao_request:fail", null);
            }
        } else if (i == 24) {
            if (i2 == -1) {
                em(2, 1);
                if (bh.getInt((String) this.tHp.pox.get("open_from_scene"), 0) == 4) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10651, new Object[]{Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0)});
                }
                try {
                    if (this.fBH != null) {
                        str = (String) this.tHp.pox.get("appId");
                        if (TextUtils.isEmpty(str)) {
                            r3 = (String) this.tHp.pox.get("appid");
                        } else {
                            r3 = str;
                        }
                        a(r3, (String) this.tHp.pox.get("img_url"), 1, this.fBH.e(85, null));
                    }
                } catch (RemoteException e2) {
                    x.e("MicroMsg.MsgHandler", "invokeAsResult : %s", new Object[]{e2});
                }
                a(this.tHp, "share_timeline:ok", null);
                return;
            }
            em(2, 3);
            a(this.tHp, "share_timeline:cancel", null);
        } else if (i == 26) {
            x.d("MicroMsg.MsgHandler", "select pedometer source resultCode = " + i2);
            if (i2 == -1) {
                a(this.tHp, "selectPedometerSource:ok", null);
            } else if (i2 == 0) {
                x.i("MicroMsg.MsgHandler", "selectPedometerSource result cancel");
                a(this.tHp, "selectPedometerSource:cancel", null);
            } else {
                x.e("MicroMsg.MsgHandler", "selectPedometerSource result fail");
                a(this.tHp, "selectPedometerSource:fail", null);
            }
        } else if (i == 25) {
            x.i("MicroMsg.MsgHandler", "hy: get ibg order finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "get_h5_transaction_request:ok", null);
            } else {
                a(this.tHp, "get_h5_transaction_request:cancel", null);
            }
            if (this.tHG == 1 && this.fBH != null) {
                try {
                    this.fBH.bRO();
                    this.fBH.O(null);
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                }
            }
        } else if (i == 28) {
            x.i("MicroMsg.MsgHandler", "get web pay checkout counter request finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                r2 = new HashMap();
                r3 = bh.az(intent.getStringExtra("token"), "");
                r4 = bh.az(intent.getStringExtra("bind_serial"), "");
                r2.put("token", r3);
                r2.put("bind_serial", r4);
                a(this.tHp, "getWebPayCheckoutCounterRequst:ok", r2);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "getWebPayCheckoutCounterRequst:ok"});
            } else {
                a(this.tHp, "getWebPayCheckoutCounterRequst:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "getWebPayCheckoutCounterRequst:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 31) {
            if (i2 != -1) {
                a(this.tHp, "openEnterpriseContact:ok", null);
                return;
            }
            r2 = intent.getBundleExtra("result_data");
            if (r2 != null) {
                str = r2.getString("result");
                r3 = new HashMap();
                r3.put("result", str);
                a(this.tHp, "openEnterpriseContact:ok", r3);
                return;
            }
            a(this.tHp, "openEnterpriseContact:ok", null);
        } else if (i == 53) {
            if (i2 != -1) {
                a(this.tHp, "selectEnterpriseContact:ok", null);
                return;
            }
            r2 = intent.getBundleExtra("result_data");
            if (r2 != null) {
                str = r2.getString("result");
                r3 = new HashMap();
                r3.put("result", str);
                a(this.tHp, "selectEnterpriseContact:ok", r3);
                return;
            }
            a(this.tHp, "selectEnterpriseContact:ok", null);
        } else if (i == 29) {
            r3 = "MicroMsg.MsgHandler";
            r4 = "consumedShareCard:ok(r : %b)";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i2 == -1);
            x.d(r3, r4, objArr);
            if (i2 == -1) {
                a(this.tHp, "consumedShareCard:ok", null);
            } else {
                a(this.tHp, "consumedShareCard:fail", null);
            }
        } else if (i == 113) {
            if (i2 == -1) {
                P(this.tHp);
            } else {
                a(this.tHp, "chooseImage:fail_android_permission_denied", null);
            }
        } else if (i == 116) {
            if (i2 == -1) {
                W(this.tHp);
            } else {
                a(this.tHp, "startRecord:fail_android_permission_denied", null);
            }
        } else if (i == 115) {
            if (i2 == -1) {
                a(this.tHp, 0);
            } else {
                a(this.tHp, "chooseVideo:fail_android_permission_denied", null);
            }
        } else if (i == 117) {
            if (i2 == -1) {
                a(this.tHp, 1);
            } else {
                a(this.tHp, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 118) {
            if (i2 == -1) {
                a(this.tHp, 1);
            } else {
                a(this.tHp, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 119) {
            if (i2 == -1) {
                T(this.tHp);
                return;
            }
            x.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:CAMERA");
            a(this.tHp, "chooseMedia:fail_android_permission_denied", null);
        } else if (i == 120) {
            if (i2 == -1) {
                T(this.tHp);
                return;
            }
            x.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:MICROPHONE");
            a(this.tHp, "chooseMedia:fail_android_permission_denied", null);
        } else if (i == 30) {
            x.i("MicroMsg.MsgHandler", "doSelectSingleContact activtiy callback");
            str = (String) this.tHp.pox.get("appId");
            if (this.tHs == null || !TextUtils.isEmpty(str)) {
                r3 = str;
            } else {
                r3 = this.tHs.getString("jsapi_args_appid");
            }
            int i8 = bh.getInt((String) this.tHp.pox.get("selectMode"), 0);
            x.i("MicroMsg.MsgHandler", "select single contact : appId:%s, busiId:%s, selectedMode:%d", new Object[]{r3, (String) this.tHp.pox.get("busiId"), Integer.valueOf(i8)});
            switch (i2) {
                case -1:
                    if (intent == null) {
                        r4 = null;
                    } else {
                        r4 = intent.getStringExtra("Select_Conv_User");
                    }
                    if (r4 == null || r4.length() == 0) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult,selectSingleContact fail, user is null");
                        a(this.tHp, "selectSingleContact:fail", null);
                        return;
                    } else if (i8 == 0) {
                        k kVar = new com.tencent.mm.plugin.webview.model.k(r3, r4);
                        ar.CG().a(1566, new 7(this));
                        ar.CG().d(kVar);
                        Context context = this.context;
                        this.context.getString(R.l.dGO);
                        this.iln = h.a(context, this.context.getString(R.l.dHc), true, new 8(this, kVar));
                        return;
                    } else if (i8 == 1) {
                        k qVar = new com.tencent.mm.plugin.webview.model.q(r3, str, r4);
                        ar.CG().a(1177, new 9(this));
                        ar.CG().d(qVar);
                        r2 = this.context;
                        this.context.getString(R.l.dGO);
                        this.iln = h.a(r2, this.context.getString(R.l.dHc), true, new 10(this, qVar));
                        return;
                    } else {
                        return;
                    }
                case 0:
                    a(this.tHp, "selectSingleContact:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 34) {
            if (i2 == -1) {
                a(this.tHp, "get_wcpay_realname_verify:ok", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_wcpay_realname_verify:ok"});
            } else if (i2 == 1) {
                a(this.tHp, "get_wcpay_realname_verify:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_wcpay_realname_verify:fail"});
                }
            } else {
                a(this.tHp, "get_wcpay_realname_verify:cancel", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "get_wcpay_realname_verify:cancel"});
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 35) {
            if (i2 == -1) {
                com.tencent.mm.sdk.b.b nkVar = new nk();
                nkVar.fFu.context = this.context;
                com.tencent.mm.sdk.b.a.xef.m(nkVar);
                try {
                    this.fBH.bRO();
                    this.fBH.O(null);
                    return;
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e32, "", new Object[0]);
                    return;
                }
            }
            a(this.tHp, "selectWalletCurrency:cancel", null);
        } else if (i == 37) {
            if (this.fzc == null) {
                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.tHp, "send_app_msg:fail", null);
                return;
            }
            f Hg2;
            long longExtra;
            str = (String) this.tHp.pox.get("appid");
            snsAdClick = null;
            if (this.tHs != null) {
                snsAdClick = (SnsAdClick) this.tHs.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    r4 = this.tHs.getString("jsapi_args_appid");
                    obj = this.tHp.bUN().get("Internal@AsyncReport");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.it(7);
                            }
                            Hg2 = com.tencent.mm.pluginsdk.model.app.g.Hg(r4);
                            if (intent != null) {
                                str2 = intent.getStringExtra("enterprise_biz_name");
                                longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                r9 = intent.getStringExtra("enterprise_share_append_text");
                                if (str2 != null || str2.length() == 0) {
                                    x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                    a(this.tHp, "send_app_msg:fail", null);
                                    return;
                                }
                                str3 = (String) this.tHp.pox.get("img_url");
                                this.tHp.pox.get("desc");
                                str4 = (String) this.tHp.pox.get("src_username");
                                str5 = (String) this.tHp.pox.get("src_displayname");
                                bUx = bUx();
                                k.a(this.tHp.bUN(), PI(GameJsApiSendAppMessage.NAME), str2, r4);
                                if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                    b(this.tHp, true);
                                }
                                if (bh.ov(str3)) {
                                    if (longExtra >= 0) {
                                        com.tencent.mm.ag.a.c ag = y.Mh().ag(longExtra);
                                        synchronized (com.tencent.mm.ag.a.e.hqR) {
                                            String HD = com.tencent.mm.ag.a.e.HD();
                                            com.tencent.mm.ag.a.e.d(ag);
                                            a(Hg2, r4, str2, str3, str4, str5, r9, bUx);
                                            com.tencent.mm.ag.a.e.ks(HD);
                                        }
                                    } else {
                                        a(Hg2, r4, str2, str3, str4, str5, r9, bUx);
                                    }
                                    h.br(this.context, this.context.getString(R.l.dUd));
                                    a(this.tHp, "send_app_msg:ok", null);
                                    return;
                                }
                                o.Pv().a(str3, new 11(this, longExtra, Hg2, r4, str2, str3, str4, str5, r9, bUx));
                                return;
                            }
                            return;
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.it(8);
                            }
                            k.a(this.tHp.bUN(), PI(GameJsApiSendAppMessage.NAME), null, r4);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.tHp, true);
                            }
                            a(this.tHp, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            r4 = str;
            obj = this.tHp.bUN().get("Internal@AsyncReport");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.it(7);
                    }
                    Hg2 = com.tencent.mm.pluginsdk.model.app.g.Hg(r4);
                    if (intent != null) {
                        str2 = intent.getStringExtra("enterprise_biz_name");
                        longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                        r9 = intent.getStringExtra("enterprise_share_append_text");
                        if (str2 != null) {
                            break;
                        }
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                        a(this.tHp, "send_app_msg:fail", null);
                        return;
                    }
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.it(8);
                    }
                    k.a(this.tHp.bUN(), PI(GameJsApiSendAppMessage.NAME), null, r4);
                    b(this.tHp, true);
                    a(this.tHp, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 38) {
            if (i2 == -1) {
                x.i("MicroMsg.MsgHandler", "hy: soter auth ok");
                a(this.tHp, "soter_biometric_authentication:ok", i.aa(intent.getExtras()));
            } else if (i2 == 1) {
                x.w("MicroMsg.MsgHandler", "hy: soter auth failed");
                a(this.tHp, "soter_biometric_authentication:fail", i.aa(intent.getExtras()));
            } else {
                x.e("MicroMsg.MsgHandler", "hy: soter user cancelled");
                a(this.tHp, "soter_biometric_authentication:cancel", i.aa(intent.getExtras()));
            }
        } else if (i == 39) {
            if (i2 == -1) {
                a(this.tHp, "unbind_bank_card:ok", null);
            } else if (i2 == 1) {
                a(this.tHp, "unbind_bank_card:fail", null);
            } else {
                a(this.tHp, "unbind_bank_card:cancel", null);
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
            }
        } else if (i == 40) {
            if (i2 == -1) {
                r4 = new Bundle();
                if (intent != null) {
                    ArrayList b = com.tencent.mm.bf.a.b(intent.getLongArrayExtra("k_outside_expose_proof_item_list"));
                    int size = b.size();
                    String[] strArr = new String[size];
                    String[] strArr2 = new String[size];
                    String[] strArr3 = new String[size];
                    int[] iArr = new int[size];
                    int[] iArr2 = new int[size];
                    for (i3 = 0; i3 < size; i3++) {
                        au auVar = (au) b.get(i3);
                        strArr[i3] = String.valueOf(auVar.wa());
                        if (intent.getBooleanExtra("k_is_group_chat", false)) {
                            strArr2[i3] = ba.hQ(auVar.we());
                            strArr3[i3] = ba.hP(auVar.we());
                        } else {
                            strArr2[i3] = auVar.we();
                            strArr3[i3] = auVar.wd();
                        }
                        if (auVar.wb() == 1) {
                            strArr3[i3] = q.FS();
                        }
                        if (strArr2[i3] == null) {
                            strArr2[i3] = "";
                        }
                        if (strArr3[i3] == null) {
                            strArr3[i3] = "";
                        }
                        if (auVar.aNc()) {
                            iArr[i3] = 49;
                        } else {
                            iArr[i3] = auVar.getType();
                        }
                        iArr2[i3] = (int) (auVar.wc() / 1000);
                    }
                    r4.putStringArray("msgIds", strArr);
                    r4.putStringArray("contents", strArr2);
                    r4.putStringArray("senders", strArr3);
                    r4.putIntArray("msgTypes", iArr);
                    r4.putIntArray("msgTimes", iArr2);
                    try {
                        if (this.fBH != null) {
                            this.fBH.n(48, r4);
                        }
                        a(this.tHp, "select chat record:ok", null);
                        return;
                    } catch (RemoteException e22) {
                        x.w("MicroMsg.MsgHandler", "onGetMsgProofItems exception" + e22.getMessage());
                        a(this.tHp, "select chat record:fail", null);
                        return;
                    }
                }
                a(this.tHp, "select chat record:fail", null);
                return;
            }
            a(this.tHp, "select chat record:cancel", null);
        } else if (i == 41) {
            if (i2 == -1) {
                a(this.tHp, "id_card_realname_verify:ok", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "id_card_realname_verify:ok"});
            } else if (i2 == 1) {
                a(this.tHp, "id_card_realname_verify:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "id_card_realname_verify:fail"});
                }
            } else {
                a(this.tHp, "id_card_realname_verify:cancel", null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "id_card_realname_verify:cancel"});
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 42) {
            if (i2 == -1) {
                if (intent != null) {
                    str = bh.az(intent.getStringExtra("gameRegionName"), "");
                    r3 = new HashMap();
                    r3.put("gameRegionName", str);
                    a(this.tHp, "get game region:ok", r3);
                    return;
                }
                a(this.tHp, "get game region:fail", null);
            } else if (i2 == 1) {
                a(this.tHp, "get game region:fail", null);
            } else {
                a(this.tHp, "get game region:cancel", null);
            }
        } else if (i == 43) {
            x.i("MicroMsg.MsgHandler", "request to open file chooser for id card image, result code = " + i2);
            switch (i2) {
                case -1:
                    r2 = new HashMap();
                    r3 = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    x.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{r3});
                    if (bh.ov(r3)) {
                        a(this.tHp, "chooseIdCard:fail", null);
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(r3);
                        if (jSONArray.length() > 0) {
                            r2.put("localId", jSONArray.get(0).toString());
                            if (intent.getStringExtra("key_pick_local_pic_source_type") != null) {
                                r2.put("sourceType", FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                            }
                            a(this.tHp, "chooseIdCard:ok", r2);
                            return;
                        }
                        a(this.tHp, "chooseImage:fail", null);
                        return;
                    } catch (Throwable e322) {
                        x.printErrStackTrace("MicroMsg.MsgHandler", e322, "", new Object[0]);
                        a(this.tHp, "chooseImage:fail", null);
                        return;
                    }
                case 0:
                    a(this.tHp, "chooseIdCard:cancel", null);
                    return;
                default:
                    a(this.tHp, "chooseImage:fail", null);
                    return;
            }
        } else if (i == 48) {
            x.i("MicroMsg.MsgHandler", "alvinluo: requestWxFacePictureVerify resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "requestWxFacePictureVerify:ok", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.tHp, "requestWxFacePictureVerify:fail", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.tHp, "requestWxFacePictureVerify:cancel", i.aa(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 49) {
            x.i("MicroMsg.MsgHandler", "hy: REQUEST_FACE_DETECT_WITH_VIDEO resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "requestWxFacePictureVerifyUnionVideo:ok", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.tHp, "requestWxFacePictureVerifyUnionVideo:fail", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.tHp, "requestWxFacePictureVerifyUnionVideo:cancel", i.aa(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 52) {
            x.i("MicroMsg.MsgHandler", "share emmotion resultCode: %d", new Object[]{Integer.valueOf(i2)});
            switch (i2) {
                case -1:
                    EmojiInfo n;
                    r4 = bh.az(intent.getStringExtra("Select_Conv_User"), "");
                    r3 = bh.az(intent.getStringExtra("emoji_thumb_path"), "");
                    str2 = bh.az(intent.getStringExtra("emoji_activity_id"), "");
                    EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().aqc().XU(r3);
                    if (XU == null) {
                        ar.Hg();
                        str3 = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", r3);
                        if (com.tencent.mm.a.e.bO(str3)) {
                            i4 = p.UR(str3) ? EmojiInfo.xAm : EmojiInfo.xAl;
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.kQ(r3);
                            emojiInfo.Dv(EmojiInfo.xAe);
                            emojiInfo.setType(i4);
                            emojiInfo.setSize(com.tencent.mm.a.e.bN(str3));
                            emojiInfo.Dw(1);
                            if (!bh.ov(str2)) {
                                emojiInfo.field_activityid = str2;
                            }
                            n = com.tencent.mm.plugin.emoji.model.i.aBE().aqc().n(emojiInfo);
                            for (String str6 : bh.F(bh.az(r4, "").split(","))) {
                                if (n != null) {
                                    com.tencent.mm.plugin.emoji.model.i.aBA().a(str6, n, null);
                                }
                            }
                            a(this.tHp, "shareEmoticon:ok", null);
                            return;
                        }
                    }
                    n = XU;
                    for (String str62 : bh.F(bh.az(r4, "").split(","))) {
                        if (n != null) {
                            com.tencent.mm.plugin.emoji.model.i.aBA().a(str62, n, null);
                        }
                    }
                    a(this.tHp, "shareEmoticon:ok", null);
                    return;
                case 0:
                    a(this.tHp, "shareEmoticon:cancel", null);
                    return;
                default:
                    a(this.tHp, "shareEmoticon:fail", null);
                    return;
            }
        } else if (i == 50) {
            x.i("MicroMsg.MsgHandler", "hy: requestWxFaceRegisterInternal resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "requestWxFaceRegisterInternal:ok", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.tHp, "requestWxFaceRegisterInternal:fail", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.tHp, "requestWxFaceRegisterInternal:cancel", i.aa(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 51) {
            x.i("MicroMsg.MsgHandler", "hy: requestWxFaceVerifyInternal resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "requestWxFaceVerifyInternal:ok", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.tHp, "requestWxFaceVerifyInternal:fail", i.aa(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.tHp, "requestWxFaceVerifyInternal:cancel", i.aa(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 54) {
            if (i2 != -1 || intent == null) {
                a(this.tHp, "slectContact:fail", null);
                return;
            }
            str62 = intent.getStringExtra("Select_Contact");
            r3 = com.tencent.mm.z.r.gu(str62);
            r4 = new Bundle();
            r4.putString("username", str62);
            r4.putString("nickname", r3);
            r4.putInt("ret", 0);
            try {
                if (this.fBH != null) {
                    this.fBH.n(FileUtils.S_IWUSR, r4);
                }
            } catch (RemoteException e222) {
                x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e222.getMessage());
            }
            a(this.tHp, "", null);
        } else if (i == 55) {
            x.i("MicroMsg.MsgHandler", "hy: REQUEST_SET_RESET_WALLET_PWD_REQUEST resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "setWCPayPassword:ok", i.aa(intent != null ? intent.getExtras() : null));
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "setWCPayPassword:ok"});
            } else if (i2 == 0) {
                a(this.tHp, "setWCPayPassword:cancel", i.aa(intent != null ? intent.getExtras() : null));
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "setWCPayPassword:cancel"});
            } else {
                a(this.tHp, "setWCPayPassword:fail", i.aa(intent != null ? intent.getExtras() : null));
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "setWCPayPassword:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
            x.d("MicroMsg.MsgHandler", "WalletJsApiReqKey: " + com.tencent.mm.pluginsdk.wallet.f.ccU());
        } else if (i == 56) {
            x.i("MicroMsg.MsgHandler", "request choose invoice title, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_invoice_title_info", bh.az(intent.getStringExtra("choose_invoice_title_info"), ""));
                }
                a(this.tHp, "chooseInvoiceTitle:ok", r2);
            } else if (i2 == 0) {
                a(this.tHp, "chooseInvoiceTitle:cancel", r2);
            } else {
                a(this.tHp, "chooseInvoiceTitle:fail", r2);
            }
        } else if (i == 57) {
            x.i("MicroMsg.MsgHandler", "request voice login verify, resultCode: %d", new Object[]{Integer.valueOf(i2)});
            r3 = new HashMap();
            if (i2 == -1) {
                r3.put("err_code", Integer.valueOf(0));
                r3.put("err_msg", "verify ok");
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).getIntent().putExtra("VoiceLoginAuthPwd", intent.getStringExtra("VoiceLoginAuthPwd"));
                }
                a(this.tHp, "request voice login verify:ok", r3);
            } else if (i2 == 0) {
                r3.put("err_code", Integer.valueOf(1));
                r3.put("err_msg", "verify cancel");
                a(this.tHp, "request voice login verify:cancel", r3);
            } else {
                r3.put("err_code", Integer.valueOf(2));
                r3.put("err_msg", "verify error");
                a(this.tHp, "request voice login verify:error", r3);
            }
        } else if (i == 59) {
            x.i("MicroMsg.MsgHandler", "hy: REQUEST_OPEN_CARD_LIST resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "openWCPayCardList:ok", i.aa(intent != null ? intent.getExtras() : null));
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "openWCPayCardList:ok"});
            } else if (i2 == 0) {
                a(this.tHp, "openWCPayCardList:fail", i.aa(intent != null ? intent.getExtras() : null));
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "openWCPayCardList:fail"});
                }
            } else {
                a(this.tHp, "openWCPayCardList:fail", i.aa(intent != null ? intent.getExtras() : null));
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "openWCPayCardList:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 60) {
            if (intent != null) {
                str62 = intent.getStringExtra("key_callback");
                x.i("MicroMsg.MsgHandler", "open offline pay view callback: %s", new Object[]{str62});
                a(this.tHp, String.format("openOfflinePayView:%s", new Object[]{str62}), null);
                com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "openOfflinePayView:ok"});
            } else {
                a(this.tHp, "openOfflinePayView:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.ccU(), "openOfflinePayView:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.ccT()) {
                com.tencent.mm.pluginsdk.wallet.f.ccV();
            }
        } else if (i == 58) {
            x.i("MicroMsg.MsgHandler", "request bind email, resultCode %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.tHp, "bindEmail:ok", null);
            } else {
                a(this.tHp, "bindEmail:cancel", null);
            }
        } else if (i == 62) {
            x.i("MicroMsg.MsgHandler", "[openRealnameAuth]resultCode:%d", new Object[]{Integer.valueOf(i2)});
            r2 = new HashMap();
            if (i2 == -1) {
                x.i("MicroMsg.MsgHandler", "openRealnameAuth ok");
                r3 = intent.getStringExtra("intent_auth_token");
                if (bh.ov(r3)) {
                    a(this.tHp, "openRealnameAuth:fail", r2);
                    return;
                }
                r2.put("err_code", Integer.valueOf(0));
                r2.put("auth_token", r3);
                x.d("MicroMsg.MsgHandler", "authToken:%s", new Object[]{r3});
                a(this.tHp, "openRealnameAuth:ok", r2);
            } else if (i2 == 0) {
                x.i("MicroMsg.MsgHandler", "openRealnameAuth cancel");
                a(this.tHp, "openRealnameAuth:cancel", r2);
            } else if (i2 == 1) {
                x.i("MicroMsg.MsgHandler", "openRealnameAuth fail");
                if (intent != null) {
                    i3 = intent.getIntExtra("intent_err_code", -1);
                    r4 = intent.getStringExtra("intent_err_msg");
                    r2.put("err_code", Integer.valueOf(i3));
                    r2.put("err_msg", r4);
                    a(this.tHp, "openRealnameAuth:fail", r2);
                    x.i("MicroMsg.MsgHandler", "openRealnameAuth errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i3), r4});
                    return;
                }
                a(this.tHp, "openRealnameAuth:fail", r2);
            }
        } else if (i != 61) {
        } else {
            if (this.fzc == null) {
                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.tHp, "sendSingleAppMessage:fail", null);
                return;
            }
            switch (i2) {
                case -1:
                    if (intent == null) {
                        r4 = null;
                    } else {
                        r4 = intent.getStringExtra("Select_Conv_User");
                    }
                    if (r4 == null || r4.length() == 0) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                        a(this.tHp, "sendSingleAppMessage:fail", null);
                        return;
                    }
                    obj = this.tHp.pox.get("__jsapi_fw_ext_info");
                    if (obj instanceof Bundle) {
                        str62 = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
                    } else {
                        str62 = null;
                    }
                    str62 = this.tHB.PB(str62);
                    if (bh.ov(str62)) {
                        str62 = (String) this.tHp.pox.get("appId");
                    }
                    k qVar2 = new com.tencent.mm.plugin.webview.model.q(str62, "", r4);
                    ar.CG().a(1177, new 12(this, intent, r4));
                    ar.CG().d(qVar2);
                    r2 = this.context;
                    this.context.getString(R.l.dGO);
                    this.iln = h.a(r2, this.context.getString(R.l.dHc), true, new 14(this, qVar2));
                    return;
                case 0:
                    a(this.tHp, "sendSingleAppMessage:cancel", null);
                    return;
                default:
                    a(this.tHp, "sendSingleAppMessage:fail", null);
                    return;
            }
        }
    }

    private void aT(i iVar) {
        Bundle ap = i.ap(iVar.pox);
        try {
            this.fBH.bRO();
            this.fBH.O(ap);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "SendServiceAppMsg doCloseWindow, ex = " + e.getMessage());
        }
    }

    private boolean a(f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.fzc == null) {
            x.w("MicroMsg.MsgHandler", "doSendAppMsg: but appmsg is null");
            return false;
        }
        o.Pv();
        Bitmap iG = com.tencent.mm.aq.c.iG(str3);
        if (!(iG == null || iG.isRecycled())) {
            x.i("MicroMsg.MsgHandler", "thumb image is not null");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            iG.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            this.fzc.thumbData = byteArrayOutputStream.toByteArray();
        }
        com.tencent.mm.sdk.b.b opVar = new op();
        opVar.fGx.fzc = this.fzc;
        opVar.fGx.appId = str;
        opVar.fGx.appName = fVar == null ? "" : fVar.field_appName;
        opVar.fGx.toUser = str2;
        opVar.fGx.fGy = 2;
        if (bh.ov(str4)) {
            opVar.fGx.fGB = null;
        } else {
            opVar.fGx.fGz = str4;
            opVar.fGx.fGA = str5;
        }
        try {
            String string = this.tHs.getString("key_snsad_statextstr");
            opVar.fGx.fGG = string;
            opVar.fGx.fGC = this.fBH.bRM();
            Bundle e = this.fBH.e(18, null);
            if (e != null) {
                op.a aVar = opVar.fGx;
                String ou = bh.ou(e.getString("KPublisherId"));
                aVar.fGF = ou;
                String hz = com.tencent.mm.z.u.hz(ou);
                com.tencent.mm.z.u.b t = com.tencent.mm.z.u.GK().t(hz, true);
                t.o("sendAppMsgScene", Integer.valueOf(2));
                t.o("preChatName", e.getString("preChatName"));
                t.o("preMsgIndex", Integer.valueOf(e.getInt("preMsgIndex")));
                t.o("prePublishId", e.getString("prePublishId"));
                t.o("preUsername", e.getString("preUsername"));
                t.o("getA8KeyScene", Integer.valueOf(e.getInt("getA8KeyScene")));
                t.o("referUrl", e.getString("referUrl"));
                if (!bh.ov(string)) {
                    t.o("adExtStr", string);
                }
                opVar.fGx.fqu = hz;
            }
            string = this.fBH.aeq();
            opVar.fGx.fGD = string;
            opVar.fGx.fGE = this.tHB.PB(string);
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "init bunddata failed : %s", new Object[]{e2.getMessage()});
        }
        boolean m = com.tencent.mm.sdk.b.a.xef.m(opVar);
        if (!bh.ov(str6)) {
            opVar = new or();
            opVar.fGI.fGJ = str2;
            opVar.fGI.content = str6;
            opVar.fGI.type = com.tencent.mm.z.s.hp(str2);
            opVar.fGI.flags = 0;
            com.tencent.mm.sdk.b.a.xef.m(opVar);
        }
        if (m) {
            try {
                if (this.fBH != null) {
                    a(str, str3, com.tencent.mm.z.s.eV(str2) ? 2 : 3, this.fBH.e(85, null));
                }
            } catch (RemoteException e3) {
                x.e("MicroMsg.MsgHandler", "invokeAsResult : %s", new Object[]{e3});
            }
        }
        if (bh.ov(str7)) {
            return m;
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), str7});
        return m;
    }

    private void a(String str, String str2, int i, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("share_report_pre_msg_url");
            String string2 = bundle.getString("share_report_pre_msg_title");
            String string3 = bundle.getString("share_report_pre_msg_desc");
            String string4 = bundle.getString("share_report_pre_msg_icon_url");
            String string5 = bundle.getString("share_report_pre_msg_appid");
            int i2 = bundle.getInt("share_report_from_scene", 0);
            String string6 = bundle.getString("share_report_biz_username");
            String string7 = bundle.getString("share_report_current_url");
            String string8 = bundle.getString("share_report_current_title");
            String str3 = this.fzc.mediaObject instanceof WXWebpageObject ? ((WXWebpageObject) this.fzc.mediaObject).webpageUrl : "";
            String str4 = this.fzc.title;
            String str5 = this.fzc.description;
            com.tencent.mm.plugin.report.service.g.pQN.h(14062, new Object[]{string, string2, string3, string4, string5, Integer.valueOf(i2), string6, string7, string8, str, str3, str4, str5, str2, Integer.valueOf(i)});
        }
    }

    private void a(i iVar, String str, Map<String, Object> map) {
        a(iVar, str, (Map) map, true);
    }

    public final void a(i iVar, String str, Map<String, Object> map, boolean z) {
        this.maM = false;
        try {
            if (this.fBH != null) {
                this.fBH.a(iVar == null ? null : iVar.tJG, str, i.ap(map), z);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    public final void a(e eVar, i iVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        if (!z2) {
            this.maM = false;
        }
        try {
            eVar.a(iVar == null ? null : iVar.tJG, str, i.ap(map), z);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(i iVar, boolean z) {
        int i = 0;
        if (iVar == null) {
            x.e("MicroMsg.MsgHandler", "msg is null when report.");
            return;
        }
        String str = iVar.tJI;
        Map map = iVar.tJH;
        map.put("isSuccess", Boolean.valueOf(z));
        e eVar = this.fBH;
        if (bh.ov(str)) {
            x.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
        } else {
            String str2;
            String str3;
            boolean c;
            String ou;
            boolean c2;
            int e;
            int e2;
            int i2 = eVar == null ? 1 : 0;
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            if (i2 != 0) {
                try {
                    str4 = "";
                } catch (Exception e3) {
                    x.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + e3.getMessage());
                    str2 = str5;
                    str3 = str4;
                }
            } else {
                str4 = eVar.bRM();
            }
            str6 = i2 != 0 ? "" : eVar.bRN();
            str2 = i2 != 0 ? "" : eVar.aeq();
            str3 = str4;
            if (map != null) {
                c = bh.c((Boolean) map.get("fromMenu"));
                ou = bh.ou((String) map.get("keyParam"));
                str4 = bh.az((String) map.get("appId"), "");
                c2 = bh.c((Boolean) map.get("isSuccess"));
                e = bh.e((Integer) map.get("permissionValue"));
                e2 = bh.e((Integer) map.get("baseErrorCode"));
                i2 = bh.e((Integer) map.get("jsapiErrorCode"));
            } else {
                i2 = 0;
                c2 = false;
                str4 = str7;
                ou = null;
                c = false;
                e2 = 0;
                e = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(URLEncoder.encode(bh.ou(str3)));
            stringBuilder.append(",");
            stringBuilder.append(URLEncoder.encode(bh.ou(str2)));
            stringBuilder.append(",");
            if (str6 == null) {
                str6 = "";
            }
            stringBuilder.append(str6);
            stringBuilder.append(",");
            stringBuilder.append(str == null ? "" : str);
            stringBuilder.append(",");
            stringBuilder.append(c ? "1" : "0");
            stringBuilder.append(",");
            if (ou == null) {
                ou = "";
            }
            stringBuilder.append(ou);
            stringBuilder.append(",");
            stringBuilder.append(str4);
            stringBuilder.append(",");
            stringBuilder.append(c2 ? "1" : "0");
            stringBuilder.append(",");
            stringBuilder.append(e);
            if (!c2) {
                stringBuilder.append(",");
                stringBuilder.append(0);
                stringBuilder.append(",");
                stringBuilder.append(e2);
                stringBuilder.append(",");
                stringBuilder.append(i2);
            }
            String stringBuilder2 = stringBuilder.toString();
            x.d("MicroMsg.WebViewSecurityUtil", "report: " + stringBuilder2);
            com.tencent.mm.plugin.report.service.g.pQN.k(10417, stringBuilder2);
        }
        Object obj = "";
        if (this.tHs != null) {
            obj = this.tHs.getString("key_webview_container_env");
        }
        if ("miniProgram".equals(obj)) {
            e eVar2 = this.fBH;
            if (eVar2 != null) {
                try {
                    Bundle e4 = eVar2.e(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, null);
                    if (e4 != null) {
                        String[] stringArray = e4.getStringArray("key_webview_apbrand_jsapi_report_args");
                        if (stringArray != null && stringArray.length == 19) {
                            stringArray[10] = str;
                            switch (str.hashCode()) {
                                case -1008737020:
                                    if (str.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o.NAME)) {
                                        break;
                                    }
                                default:
                                    i = -1;
                                    break;
                            }
                            switch (i) {
                                case 0:
                                    stringBuilder2 = iVar.pox.get("package").toString();
                                    break;
                                default:
                                    stringBuilder2 = "";
                                    break;
                            }
                            stringArray[11] = stringBuilder2;
                            if ("true".equals(l.a(iVar, "isSuccess"))) {
                                stringBuilder2 = "1";
                            } else {
                                stringBuilder2 = "2";
                            }
                            stringArray[12] = stringBuilder2;
                            stringArray[13] = l.a(iVar, "permissionValue");
                            stringArray[14] = l.a(iVar, "jsapiErrorCode");
                            com.tencent.mm.plugin.report.service.g.pQN.h(14993, l.h(stringArray));
                        }
                    }
                } catch (Exception e32) {
                    x.e("kv_14993", String.valueOf(e32));
                }
            }
        }
    }

    private int aU(i iVar) {
        int hashCode = iVar.hashCode();
        this.tIb.put(Integer.valueOf(hashCode), new c(this, iVar, this.fBH));
        this.maM = false;
        try {
            this.fBH.bRP();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "blockMsg, dealNext ex = %s", new Object[]{e.getMessage()});
        }
        return hashCode;
    }

    public final c Ba(int i) {
        return (c) this.tIb.get(Integer.valueOf(i));
    }

    private void Bb(int i) {
        c cVar = (c) this.tIb.remove(Integer.valueOf(i));
        if (cVar != null) {
            cVar.tHp = null;
            cVar.fBH = null;
        }
    }

    private boolean aV(i iVar) {
        this.maM = false;
        if (com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "scene", 3) == 21) {
            return com.tencent.mm.plugin.webview.fts.l.bPk().W(iVar.pox);
        }
        return com.tencent.mm.plugin.webview.modeltools.f.bRz().W(iVar.pox);
    }

    private boolean aW(i iVar) {
        Map hashMap = new HashMap();
        com.tencent.mm.plugin.webview.modeltools.f.bRy();
        com.tencent.mm.plugin.webview.fts.e.c(iVar.pox, hashMap);
        a(iVar, "getSearchDisplayName:ok", hashMap);
        return true;
    }

    private boolean aX(i iVar) {
        int i;
        JSONArray jSONArray;
        this.maM = false;
        com.tencent.mm.plugin.webview.fts.c bRz = com.tencent.mm.plugin.webview.modeltools.f.bRz();
        Map map = iVar.pox;
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "parseGoToRecVideoListParams, params: %s", new Object[]{map});
        com.tencent.mm.plugin.aj.a.d dVar = new com.tencent.mm.plugin.aj.a.d();
        dVar.fod = com.tencent.mm.plugin.webview.fts.f.r(map, "query");
        dVar.offset = com.tencent.mm.plugin.webview.fts.f.c(map, "offset", 0);
        dVar.hKY = com.tencent.mm.plugin.webview.fts.f.c(map, DownloadSettingTable$Columns.TYPE, 0);
        dVar.scene = com.tencent.mm.plugin.webview.fts.f.c(map, "scene", 3);
        dVar.tjS = com.tencent.mm.plugin.webview.fts.f.r(map, "sugId");
        dVar.tjU = com.tencent.mm.plugin.webview.fts.f.c(map, "sugType", 0);
        dVar.tjT = com.tencent.mm.plugin.webview.fts.f.r(map, "prefixSug");
        dVar.tjP = com.tencent.mm.plugin.webview.fts.f.t(map, "isHomePage") ? 1 : 0;
        dVar.lEK = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        dVar.tjR = com.tencent.mm.plugin.webview.fts.f.c(map, "sceneActionType", 1);
        dVar.tjW = com.tencent.mm.plugin.webview.fts.f.c(map, "displayPattern", 2);
        dVar.tjX = com.tencent.mm.plugin.webview.fts.f.c(map, "sugPosition", 0);
        dVar.tjY = com.tencent.mm.plugin.webview.fts.f.r(map, "sugBuffer");
        String r = com.tencent.mm.plugin.webview.fts.f.r(map, "extReqParams");
        if (!bh.ov(r)) {
            try {
                JSONArray jSONArray2 = new JSONArray(r);
                for (i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i);
                    com.tencent.mm.protocal.c.or orVar = new com.tencent.mm.protocal.c.or();
                    orVar.aAM = jSONObject.optString("key", "");
                    orVar.vXx = (long) jSONObject.optInt("uintValue", 0);
                    orVar.vXy = jSONObject.optString("textValue", "");
                    dVar.tka.add(orVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(map, "videoId");
        if (!bh.ov(r2)) {
            com.tencent.mm.protocal.c.or orVar2 = new com.tencent.mm.protocal.c.or();
            orVar2.aAM = "relevant_vid";
            orVar2.vXy = r2;
            dVar.tka.add(orVar2);
        }
        String r3 = com.tencent.mm.plugin.webview.fts.f.r(map, "expand");
        if (!bh.ov(r3)) {
            orVar2 = new com.tencent.mm.protocal.c.or();
            orVar2.aAM = "relevant_expand";
            orVar2.vXy = r3;
            dVar.tka.add(orVar2);
        }
        String r4 = com.tencent.mm.plugin.webview.fts.f.r(map, "searchId");
        if (!bh.ov(r4)) {
            orVar2 = new com.tencent.mm.protocal.c.or();
            orVar2.aAM = "relevant_pre_searchid";
            orVar2.vXy = r4;
            dVar.tka.add(orVar2);
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "shareOpenID");
        if (!bh.ov(r)) {
            com.tencent.mm.protocal.c.or orVar3 = new com.tencent.mm.protocal.c.or();
            orVar3.aAM = "relevant_shared_openid";
            orVar3.vXy = r;
            dVar.tka.add(orVar3);
        }
        long a = com.tencent.mm.plugin.webview.fts.f.a(map, "relevant_category", -1);
        if (a >= 0) {
            orVar2 = new com.tencent.mm.protocal.c.or();
            orVar2.aAM = "rec_category";
            orVar2.vXx = a;
            dVar.tka.add(orVar2);
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "matchUser");
        if (!bh.ov(r)) {
            try {
                JSONObject jSONObject2 = new JSONObject(r);
                bro com_tencent_mm_protocal_c_bro = new bro();
                com_tencent_mm_protocal_c_bro.ksU = jSONObject2.optString("userName");
                com_tencent_mm_protocal_c_bro.wTn = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_bro.ksU)) {
                    dVar.tjQ.add(com_tencent_mm_protocal_c_bro);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "prefixQuery");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    dVar.tjV.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "tagInfo");
        if (!bh.ov(r)) {
            try {
                jSONObject2 = new JSONObject(r);
                dVar.tjZ = new bnb();
                dVar.tjZ.wQa = jSONObject2.optString("tagText");
                dVar.tjZ.wPZ = jSONObject2.optInt("tagType");
                dVar.tjZ.wQb = jSONObject2.optString("tagExtValue");
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        r = com.tencent.mm.plugin.webview.fts.f.r(map, "numConditions");
        if (!bh.ov(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    atl com_tencent_mm_protocal_c_atl = new atl();
                    com_tencent_mm_protocal_c_atl.wBz = optJSONObject.optLong("from");
                    com_tencent_mm_protocal_c_atl.wBA = optJSONObject.optLong("to");
                    com_tencent_mm_protocal_c_atl.wBy = optJSONObject.optInt("field");
                    dVar.tkb.add(com_tencent_mm_protocal_c_atl);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        dVar.fDl = bh.o(map.get("webview_instance_id"), -1);
        dVar.ael = com.tencent.mm.sdk.platformtools.w.eL(ac.getContext());
        dVar.mLr = com.tencent.mm.plugin.webview.fts.f.c(map, "subType", 0);
        if (com.tencent.mm.bc.m.Rj()) {
            dVar.tkc = com.tencent.mm.plugin.webview.fts.f.c(map, "isWeAppMore", 0);
            if (dVar.tkc == 1) {
                dVar.tkd = new cbo();
                com.tencent.mm.sdk.b.b hwVar = new hw();
                com.tencent.mm.sdk.b.a.xef.m(hwVar);
                dVar.tkd.xaB = hwVar.fyo.fyp;
                dVar.tkd.xaD = com.tencent.mm.modelappbrand.b.hjy;
                dVar.tkd.xaC = com.tencent.mm.plugin.webview.fts.f.c(map, "subType", 0);
                dVar.tkd.wRC = com.tencent.mm.modelappbrand.b.hjx;
                dVar.tkd.xaF = dVar.tjX;
                ar.Hg();
                Object obj = com.tencent.mm.z.c.CU().get(w.a.xtG, null);
                if (obj != null && (obj instanceof String)) {
                    dVar.tkd.xaE = (String) obj;
                }
            }
        }
        if (bRz.tlN == 1) {
            dVar.tke = bRz.tke;
        } else {
            dVar.tke = null;
        }
        com.tencent.mm.plugin.webview.fts.topstory.a.b.d(dVar);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray3 = new JSONArray(com.tencent.mm.plugin.webview.fts.f.r(map, "videoUrls"));
            if (jSONArray3.length() > 0) {
                for (i = 0; i < jSONArray3.length(); i++) {
                    arrayList.add(jSONArray3.getString(i));
                }
            }
        } catch (JSONException e3) {
        }
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "parseGoToRecVideoListParams, videoUrls: %s", new Object[]{arrayList});
        if (!bh.ov(r2)) {
            r = "http://shp.qpic.cn/qqvideo_ori/0/" + r2 + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
            com.tencent.mm.plugin.topstory.a.a.c cVar = new com.tencent.mm.plugin.topstory.a.a.c();
            cVar.title = com.tencent.mm.plugin.webview.fts.f.r(map, "title");
            cVar.sew = r;
            cVar.sex = com.tencent.mm.plugin.webview.fts.f.c(map, "mediaDuration", 0);
            cVar.sey = r2;
            cVar.hbo = 496;
            cVar.hbn = 280;
            cVar.seF = com.tencent.mm.plugin.webview.fts.f.r(map, "strPlayCount");
            cVar.lOX = com.tencent.mm.plugin.webview.fts.f.r(map, "shareUrl");
            cVar.lOY = com.tencent.mm.plugin.webview.fts.f.r(map, "shareTitle");
            cVar.seG = com.tencent.mm.plugin.webview.fts.f.r(map, "titleUrl");
            cVar.rfu = com.tencent.mm.plugin.webview.fts.f.r(map, "shareDesc");
            cVar.sez = com.tencent.mm.plugin.webview.fts.f.r(map, "shareImgUrl");
            cVar.seA = com.tencent.mm.plugin.webview.fts.f.r(map, "shareString");
            cVar.seB = com.tencent.mm.plugin.webview.fts.f.r(map, "shareStringUrl");
            cVar.bhd = com.tencent.mm.plugin.webview.fts.f.r(map, "source");
            cVar.pes = com.tencent.mm.plugin.webview.fts.f.r(map, "sourceUrl");
            cVar.seC = com.tencent.mm.plugin.webview.fts.f.a(map, "relevant_category", -1);
            cVar.seD = com.tencent.mm.plugin.webview.fts.f.r(map, "shareOpenId");
            cVar.seK = com.tencent.mm.plugin.webview.fts.f.r(map, "docID");
            cVar.seM = com.tencent.mm.plugin.webview.fts.f.a(map, "videoSize", 0);
            cVar.timestamp = bh.Wq();
            try {
                JSONObject jSONObject3 = new JSONObject(com.tencent.mm.plugin.webview.fts.f.r(map, "block"));
                cVar.seL = jSONObject3.optLong("resultType");
                cVar.foe = jSONObject3.optLong(DownloadSettingTable$Columns.TYPE);
            } catch (JSONException e4) {
            }
            cVar.seE = r3;
            if (!bh.ov(cVar.videoUrl) && cVar.sex > 0) {
                com.tencent.mm.plugin.webview.fts.topstory.a.e.bPt().NR(cVar.videoUrl);
            }
            com.tencent.mm.plugin.webview.fts.topstory.a.b.a(arrayList, cVar, r3, r4);
        }
        com.tencent.mm.ui.e.i.xEq = true;
        Intent intent = new Intent();
        intent.putExtra("key_proxy_fts_rec_ui", true);
        intent.putExtra("key_scene", 1);
        com.tencent.mm.bm.d.b(this.context, "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent);
        Map hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(0));
        a(iVar, "0", hashMap);
        return false;
    }

    private boolean aY(i iVar) {
        this.maM = false;
        try {
            if (!(this.fBH == null || iVar.pox == null || !iVar.pox.containsKey("view"))) {
                Bundle bundle = new Bundle();
                bundle.putString("fts_key_data", (String) iVar.pox.get("view"));
                this.fBH.n(138, bundle);
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean aZ(i iVar) {
        this.maM = false;
        int VI = bh.VI((String) iVar.pox.get("x"));
        int VI2 = bh.VI((String) iVar.pox.get("y"));
        String str = (String) iVar.pox.get("eventId");
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.pox.get("widgetId"));
        bundle.putInt("x", VI);
        bundle.putInt("y", VI2);
        bundle.putString("eventId", str);
        try {
            if (this.fBH != null) {
                this.fBH.n(100002, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doTapSearchWAWidgetView exception" + e.getMessage());
        }
        a(iVar, "tapSearchWAWidgetView:ok", null);
        return true;
    }

    private boolean ba(i iVar) {
        this.maM = false;
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.pox.get("widgetId"));
        try {
            if (this.fBH != null) {
                this.fBH.n(100001, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doOpenSearchWAWidgetLogView exception" + e.getMessage());
        }
        a(iVar, "openSearchWAWidgetLogView:ok", null);
        return true;
    }

    private boolean bb(i iVar) {
        this.maM = false;
        this.tIc++;
        String str = ((String) iVar.pox.get("appid")) + "_" + this.tIc;
        JSONObject jSONObject = new JSONObject(iVar.pox);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.fBH != null) {
                this.fBH.n(60, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "insertSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bc(i iVar) {
        this.maM = false;
        int i = this.tId;
        this.tId = i + 1;
        Bundle ap = i.ap(iVar.pox);
        if (ap.containsKey("playerId")) {
            i = bh.VI(ap.getString("playerId"));
        } else {
            ap.putString("playerId", String.valueOf(i));
        }
        x.i("MicroMsg.MsgHandler", "inserting video player id %d, params %s", new Object[]{Integer.valueOf(i), iVar.pox});
        try {
            if (this.fBH != null) {
                this.fBH.n(200000, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("playerId", Integer.valueOf(i));
        a(iVar, "insertVideoPlayer:ok", hashMap);
        return true;
    }

    private boolean bd(i iVar) {
        this.maM = false;
        Bundle ap = i.ap(iVar.pox);
        x.i("MicroMsg.MsgHandler", "update video player  params %s", new Object[]{iVar.pox});
        try {
            if (this.fBH != null) {
                this.fBH.n(200001, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "updateVideoPlayer:ok", null);
        return true;
    }

    private boolean be(i iVar) {
        this.maM = false;
        Bundle ap = i.ap(iVar.pox);
        x.i("MicroMsg.MsgHandler", "remove video player   params %s", new Object[]{iVar.pox});
        try {
            if (this.fBH != null) {
                this.fBH.n(200002, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doRemoveVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "removeVideoPlayer:ok", null);
        return true;
    }

    private boolean bf(i iVar) {
        this.maM = false;
        Bundle ap = i.ap(iVar.pox);
        x.i("MicroMsg.MsgHandler", "operate video player  params %s", new Object[]{iVar.pox});
        try {
            if (this.fBH != null) {
                this.fBH.n(200003, ap);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doOperateVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "operateVideoPlayer:ok", null);
        return true;
    }

    private boolean bg(i iVar) {
        this.maM = false;
        JSONObject jSONObject = new JSONObject(iVar.pox);
        String str = (String) iVar.pox.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.fBH != null) {
                this.fBH.n(61, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "removeSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bh(i iVar) {
        this.maM = false;
        JSONObject jSONObject = new JSONObject(iVar.pox);
        String str = (String) iVar.pox.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.fBH != null) {
                this.fBH.n(62, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "updateSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bi(i iVar) {
        this.maM = false;
        com.tencent.mm.plugin.appbrand.m.a aVar = (com.tencent.mm.plugin.appbrand.m.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.a.class);
        String.valueOf(iVar.pox.get("appId"));
        aVar.Zb();
        a(iVar, "preloadMiniProgramEnv:ok", null);
        return true;
    }

    private boolean bj(i iVar) {
        String str;
        List list;
        this.maM = false;
        Object obj = iVar.pox.get("userNames");
        String str2 = ":ok";
        if (obj instanceof String) {
            try {
                List A = A(new JSONArray((String) obj));
                str = str2;
                list = A;
            } catch (Exception e) {
                list = null;
                str = ":fail:param type mismatch";
            }
        } else if (obj instanceof JSONArray) {
            str = str2;
            list = A((JSONArray) obj);
        } else if (obj instanceof String[]) {
            str = str2;
            Object F = bh.F((String[]) obj);
        } else {
            list = null;
            str = ":fail:empty param";
        }
        if (!bh.cA(list)) {
            ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).Z(list);
        }
        a(iVar, "preloadMiniProgramContacts" + str, null);
        return true;
    }

    private static List<String> A(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        return linkedList;
    }

    private boolean bk(i iVar) {
        this.maM = false;
        com.tencent.mm.sdk.b.b qpVar = new qp();
        qpVar.fIi.context = this.context;
        qpVar.fIi.userName = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "userName");
        qpVar.fIi.appId = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "appId");
        qpVar.fIi.fIk = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "relativeURL");
        qpVar.fIi.fIm = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "appVersion", 0);
        qpVar.fIi.scene = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "scene", 1018);
        qpVar.fIi.fnp = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "sceneNote");
        if (bh.ov(qpVar.fIi.fnp)) {
            qpVar.fIi.fnp = com.tencent.mm.compatible.util.p.encode(bh.ou(aeq()));
        }
        qpVar.fIi.fvR = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "downloadURL");
        qpVar.fIi.fIl = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "openType", 0);
        qpVar.fIi.fIn = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "checkSumMd5");
        qpVar.fIi.fIp = false;
        qpVar.fIi.fIq.hjB = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "extJsonInfo");
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        if (qpVar.fIj.fIu) {
            a(iVar, "openWeApp:ok", null);
        } else {
            a(iVar, "openWeApp:fail:" + bh.ou(qpVar.fIj.fIv), null);
        }
        return true;
    }

    private boolean bl(i iVar) {
        this.maM = false;
        x.i("MicroMsg.MsgHandler", "doOpenWeAppPage %s", new Object[]{iVar.pox});
        String r = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "userName");
        String r2 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "relativeURL");
        int c = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "appVersion", 0);
        String r3 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "searchId");
        String r4 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "docId");
        int c2 = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "position", 1);
        int c3 = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "scene", 1000);
        int c4 = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "debugMode", 0);
        if (com.tencent.mm.plugin.webview.modeltools.f.bRz().tke != null) {
            c4 = 1;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        if (c3 == 201) {
            appBrandStatObject.scene = 1006;
        } else if (c3 == 3) {
            appBrandStatObject.scene = 1005;
        } else if (c3 == 16) {
            appBrandStatObject.scene = 1042;
        } else if (c3 == 20) {
            appBrandStatObject.scene = 1053;
        } else {
            appBrandStatObject.scene = 1000;
        }
        String r5 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "statSessionId");
        String r6 = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "statKeywordId");
        appBrandStatObject.fnp = r5 + ":" + r6 + ":" + r3 + ":" + r4 + ":" + c2 + ":" + com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "subScene");
        ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(this.context, r, null, c4, c, r2, appBrandStatObject);
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bxf();
        aVar.hmk = new bxg();
        aVar.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar.hmi = 1873;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        bxf com_tencent_mm_protocal_c_bxf = (bxf) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bxf.wXU = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "statSessionId");
        com_tencent_mm_protocal_c_bxf.wXV = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "statKeywordId");
        com_tencent_mm_protocal_c_bxf.wwM = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "searchId");
        com_tencent_mm_protocal_c_bxf.wII = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "docId");
        com_tencent_mm_protocal_c_bxf.wXW = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "position", 1);
        com_tencent_mm_protocal_c_bxf.pbI = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "userName");
        com_tencent_mm_protocal_c_bxf.wXX = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "appVersion", 0);
        com_tencent_mm_protocal_c_bxf.wXY = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "adBuffer");
        com_tencent_mm_protocal_c_bxf.rYW = c3;
        com_tencent_mm_protocal_c_bxf.wXZ = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "clickExtInfo");
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20StatSessionId", com_tencent_mm_protocal_c_bxf.wXU + ",");
        dVar.q("21KeywordId", com_tencent_mm_protocal_c_bxf.wXV + ",");
        dVar.q("22SearchId", com_tencent_mm_protocal_c_bxf.wwM + ",");
        dVar.q("23DocId", com_tencent_mm_protocal_c_bxf.wII + ",");
        dVar.q("24Pos", com_tencent_mm_protocal_c_bxf.wXW + ",");
        dVar.q("25AppUserName", com_tencent_mm_protocal_c_bxf.pbI + ",");
        dVar.q("26AppVersion", com_tencent_mm_protocal_c_bxf.wXX + ",");
        dVar.q("27AdBuffer", com_tencent_mm_protocal_c_bxf.wXY + ",");
        dVar.q("28AdClickBuffer", com_tencent_mm_protocal_c_bxf.wXZ + ",");
        dVar.q("29scene", c3 + ",");
        x.i("MicroMsg.MsgHandler", "doClickReportScene oreh" + dVar.Sz());
        u.a(JZ, new 18(this, dVar));
        a(iVar, "openWeAppPage:ok", null);
        return true;
    }

    private boolean bm(i iVar) {
        int c = com.tencent.mm.plugin.webview.fts.f.c(iVar.pox, "logId", 0);
        x.i("MicroMsg.MsgHandler", "doSearchRailtime oreh id:%d, value:%s, params:%s", new Object[]{Integer.valueOf(c), com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "logString"), iVar.pox});
        ano com_tencent_mm_protocal_c_ano = new ano();
        com_tencent_mm_protocal_c_ano.wuu = c;
        com_tencent_mm_protocal_c_ano.wuC = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_ano.ksO = 1;
        com_tencent_mm_protocal_c_ano.wuv = new com.tencent.mm.bq.b(r1.getBytes());
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bi();
        aVar.hmk = new bj();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.hmi = 1802;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        bi biVar = (bi) JZ.hmg.hmo;
        ann com_tencent_mm_protocal_c_ann = new ann();
        com_tencent_mm_protocal_c_ann.vOf = com.tencent.mm.protocal.d.vAt;
        com_tencent_mm_protocal_c_ann.vOg = com.tencent.mm.protocal.d.vAs;
        com_tencent_mm_protocal_c_ann.vOh = com.tencent.mm.protocal.d.vAv;
        com_tencent_mm_protocal_c_ann.vOi = com.tencent.mm.protocal.d.vAw;
        com_tencent_mm_protocal_c_ann.vOj = com.tencent.mm.sdk.platformtools.w.cfi();
        com_tencent_mm_protocal_c_ann.wuB = (int) (System.currentTimeMillis() / 1000);
        biVar.vGB = com_tencent_mm_protocal_c_ann;
        biVar.vGC.add(com_tencent_mm_protocal_c_ano);
        u.a(JZ, new u.a(this) {
            final /* synthetic */ g tIj;

            {
                this.tIj = r1;
            }

            public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                x.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (!(i == 0 && i2 == 0)) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(457, 1, 1, false);
                }
                return 0;
            }
        });
        a(iVar, "reportWeAppSearchRealtime:ok", null);
        return true;
    }

    private boolean bn(i iVar) {
        String str = (String) iVar.pox.get("name");
        String str2 = (String) iVar.pox.get("arg");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            str = "arg";
            if (bh.ov(str2)) {
                str2 = "{}";
            }
            jSONObject.put(str, new JSONObject(str2));
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            this.fBH.e(com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, bundle);
            a(iVar, "invokeMiniProgramAPI:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doInvokeMiniProgramApi: %s", new Object[]{e});
            a(iVar, "invokeMiniProgramAPI:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("fts_key_json_data", str);
        bundle2.putString("fts_key_req_id", str2);
        bundle2.putBoolean("fts_key_new_query", z);
        if (bundle != null) {
            bundle2.putBundle("fts_key_data", bundle);
        }
        try {
            if (this.fBH != null) {
                this.fBH.n(119, bundle2);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void c(int i, String str, Map<String, Object> map) {
        Bundle bundle = new Bundle();
        bundle.putInt("FTS_KEY_onStartWebSearch_type", i);
        bundle.putString("FTS_KEY_onStartWebSearch_query", str);
        bundle.putSerializable("FTS_KEY_onStartWebSearch_params", new HashMap(map));
        try {
            if (this.fBH != null) {
                this.fBH.n(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void PD(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        try {
            if (this.fBH != null) {
                this.fBH.n(124, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }

    public final void cK(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_sns_id", str);
        bundle.putInt("fts_key_status", i);
        try {
            if (this.fBH != null) {
                this.fBH.n(125, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onMusicStatusChanged exception" + e.getMessage());
        }
    }

    public final void aO(int i, String str) {
        x.i("MicroMsg.MsgHandler", "onSearchImageListReady ret %d data %s", new Object[]{Integer.valueOf(i), str});
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_ret", i);
        bundle.putString("fts_key_data", str);
        try {
            if (this.fBH != null) {
                this.fBH.n(120, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchImageListReady exception" + e.getMessage());
        }
    }

    public final void c(int i, String str, int i2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_teach_request_type", i);
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i2);
        bundle.putString("requestId", str2);
        try {
            if (this.fBH != null) {
                this.fBH.n(121, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onTeachSearchDataReady exception" + e.getMessage());
        }
    }

    public final void T(String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i);
        bundle.putInt("fts_key_is_expired", i2);
        try {
            if (this.fBH != null) {
                this.fBH.n(142, bundle);
            }
        } catch (Exception e) {
        }
    }

    public final boolean bo(i iVar) {
        boolean z = false;
        int i = bh.getInt(bh.bY(iVar.pox.get(SlookAirButtonFrequentContactAdapter.ID)), 0);
        if (i <= 0) {
            a(iVar, "kvReport:fail", null);
        } else {
            boolean z2;
            String bY = bh.bY(iVar.pox.get(DownloadSettingTable$Columns.VALUE));
            if (bh.getInt(bh.bY(iVar.pox.get("is_important")), 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bh.getInt(bh.bY(iVar.pox.get("is_report_now")), 0) > 0) {
                z = true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(i, bY, z, z2);
            a(iVar, "kvReport:ok", null);
        }
        return true;
    }

    public final String aeq() {
        String str = null;
        if (this.fBH == null) {
            x.i("MicroMsg.MsgHandler", "getCurrentUrl, callbacker is null");
        } else {
            try {
                str = this.fBH.aeq();
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", new Object[]{e});
            }
        }
        return str;
    }

    private boolean bp(i iVar) {
        int i;
        String str = (String) iVar.pox.get("miniProgramAppId");
        if (bh.ov(str)) {
            i = 0;
        } else {
            i = ((com.tencent.mm.plugin.appbrand.m.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.a.class)).pw(str);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("reportId", Integer.valueOf(i));
        a(iVar, "reportMiniProgramPageData:ok", hashMap);
        return true;
    }

    private boolean bq(i iVar) {
        int i = 0;
        String r = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "targetAppId");
        String aeq = aeq();
        String qE = qE(aeq);
        if (bh.ov(qE)) {
            qE = com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "referrerAppId");
        }
        if (bh.ov(r)) {
            a(iVar, "launchMiniProgram:fail_invalid_targetAppId", null);
        } else if (bh.ov(qE)) {
            a(iVar, "launchMiniProgram:fail_invalid_referrerAppId", null);
        } else {
            String ou = bh.ou(com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "envVersion"));
            int i2 = -1;
            switch (ou.hashCode()) {
                case 110628630:
                    if (ou.equals("trial")) {
                        boolean z = true;
                        break;
                    }
                    break;
                case 1559690845:
                    if (ou.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(this.context, aeq, qE, r, i, com.tencent.mm.plugin.webview.fts.f.r(iVar.pox, "path"));
            a(iVar, "launchMiniProgram:ok", null);
        }
        return true;
    }

    private boolean br(i iVar) {
        String str = (String) iVar.pox.get("username");
        if (!bh.ov(str)) {
            ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qL(str);
        }
        a(iVar, "forceUpdateWxaAttr:ok", null);
        return true;
    }

    private boolean bs(i iVar) {
        Bundle bundle = new Bundle(2);
        bundle.putString("set_page_title_text", (String) iVar.pox.get("title"));
        bundle.putString("set_page_title_color", (String) iVar.pox.get("color"));
        try {
            this.fBH.e(43, bundle);
            a(iVar, "setPageTitle:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doSetPageTitle, exception = %s", new Object[]{e});
            a(iVar, "setPageTitle:fail", null);
        }
        return true;
    }

    @Deprecated
    private boolean bt(i iVar) {
        String str = (String) iVar.pox.get("color");
        if (bh.ov(str)) {
            x.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is null or nill");
            a(iVar, "setStatusBarStyle:fail", null);
        } else {
            int i;
            if (str.equalsIgnoreCase("black")) {
                i = 48;
            } else if (str.equalsIgnoreCase("white")) {
                i = 49;
            } else {
                i = -1;
            }
            if (-1 != i) {
                try {
                    this.fBH.e(i, Bundle.EMPTY);
                    a(iVar, "setStatusBarStyle:ok", null);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doSetStatusBarStyle, exception = %s", new Object[]{e});
                    a(iVar, "setStatusBarStyle:fail", null);
                }
            } else {
                x.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is neither black or white");
                a(iVar, "setStatusBarStyle:fail", null);
            }
        }
        return true;
    }

    private boolean bu(i iVar) {
        if (iVar.pox.containsKey("enable")) {
            try {
                boolean parseBoolean = Boolean.parseBoolean((String) iVar.pox.get("enable"));
                Bundle bundle = new Bundle(1);
                bundle.putBoolean("enable_fullscreen_params_enable", parseBoolean);
                this.fBH.e(45, bundle);
                a(iVar, "enableFullScreen:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doEnableFullScreen, exception = %s", new Object[]{e});
                a(iVar, "enableFullScreen:fail", null);
            }
        } else {
            a(iVar, "enableFullScreen:fail_invalid_arguments", null);
        }
        return true;
    }

    private boolean bv(i iVar) {
        String str = (String) iVar.pox.get("left");
        String str2 = (String) iVar.pox.get("right");
        if (bh.ov(str) && bh.ov(str2)) {
            a(iVar, "setNavigationBarButtons:fail", null);
        } else {
            Bundle bundle = new Bundle();
            try {
                str = new JSONObject(str).optString("color", "");
                if (!bh.ov(str)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", str);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean optBoolean = jSONObject.optBoolean("hidden", false);
                String optString = jSONObject.optString("text", "");
                String ou = bh.ou(com.tencent.mm.pluginsdk.ui.tools.s.ST(jSONObject.optString("iconData", "")));
                str = jSONObject.optString("color", "");
                if (optBoolean) {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                } else {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", ou);
                    bundle.putString("set_navigation_bar_buttons_text_color", str);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                a(iVar, "setNavigationBarButtons:fail_invalid_params", null);
            } else {
                try {
                    this.fBH.e(44, bundle);
                    a(iVar, "setNavigationBarButtons:ok", null);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e22, " setNavigationBarButtons invoke ", new Object[0]);
                    a(iVar, "setNavigationBarButtons:fail_invoke", null);
                }
            }
        }
        return true;
    }

    public final boolean bw(i iVar) {
        try {
            this.fBH.e(34, Bundle.EMPTY);
            a(iVar, "enablePullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doEnablePullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "enablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bx(i iVar) {
        try {
            this.fBH.e(35, Bundle.EMPTY);
            a(iVar, "startPullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doStartPullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "startPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean by(i iVar) {
        try {
            this.fBH.e(36, Bundle.EMPTY);
            a(iVar, "stopPullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doStopPullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "stopPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bUH() {
        try {
            this.fBH.e(47, Bundle.EMPTY);
            a(this.tHp, "disablePullDownRefresh:ok", null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            a(this.tHp, "disablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bz(i iVar) {
        this.maM = false;
        String ou = bh.ou((String) iVar.pox.get("placeholder"));
        int i = bh.getInt((String) iVar.pox.get("maxLength"), 0);
        try {
            Bundle bundle = new Bundle(2);
            bundle.putString("show_kb_placeholder", ou);
            bundle.putInt("show_kb_max_length", i);
            this.fBH.e(37, bundle);
            this.tIe = iVar;
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doShowKeyBoard, exception = %s", new Object[]{e});
            a(this.fBH, iVar, "showKeyboard:fail", null, true, true);
        }
        return true;
    }

    public final boolean bA(i iVar) {
        this.maM = false;
        try {
            Bundle e = this.fBH.e(79, new Bundle());
            Map hashMap = new HashMap();
            int i = e.getInt("height", 0);
            if (i > 0) {
                hashMap.put("height", Integer.valueOf(com.tencent.mm.bv.a.ad(ac.getContext(), i)));
                a(this.fBH, iVar, "showSmileyPanel:ok", hashMap, true, true);
            } else {
                a(this.fBH, iVar, "showSmileyPanel:fail", null, true, true);
            }
        } catch (Exception e2) {
            x.i("MicroMsg.MsgHandler", "doShowSmileyPanel, exception = %s", new Object[]{e2});
            a(this.fBH, iVar, "showSmileyPanel:fail", null, true, true);
        }
        return true;
    }

    public final boolean bB(i iVar) {
        String str = (String) iVar.pox.get("place");
        if (bh.ov(str)) {
            a(iVar, "disableBounceScroll:fail", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if ("top".equalsIgnoreCase(jSONArray.getString(i2))) {
                        i = true;
                    }
                }
                if (i == 0) {
                    a(iVar, "disableBounceScroll:ok", null);
                } else {
                    try {
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("webview_disable_bounce_scroll_top", 1);
                        this.fBH.e(38, bundle);
                        a(iVar, "disableBounceScroll:ok", null);
                    } catch (Exception e) {
                        x.i("MicroMsg.MsgHandler", "doDisableBounceScroll, exception = %s", new Object[]{e});
                        a(iVar, "disableBounceScroll:fail", null);
                    }
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.MsgHandler", "doDisableBounceScroll, invalid json array, string = %s", new Object[]{str});
                a(iVar, "disableBounceScroll:fail", null);
            }
        }
        return true;
    }

    public final boolean bC(i iVar) {
        try {
            this.fBH.e(39, new Bundle(0));
            a(iVar, "clearBounceBackground:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doClearBounceBackground, exception = %s", new Object[]{e});
            a(iVar, "clearBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bD(i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("key_set_bounce_background_color", (String) iVar.pox.get("backgroundColor"));
        try {
            this.fBH.e(72, bundle);
            a(iVar, "setBounceBackground:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "setBounceBackground, exception = %s", new Object[]{e});
            a(iVar, "setBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bE(i iVar) {
        int i = bh.getInt(bh.bY(iVar.pox.get(SlookAirButtonFrequentContactAdapter.ID)), 0);
        if (i <= 0) {
            a(iVar, "realtimeReport:fail", null);
            return true;
        }
        Object obj;
        String bY = bh.bY(iVar.pox.get(DownloadSettingTable$Columns.VALUE));
        int i2 = bh.getInt(bh.bY(iVar.pox.get(DownloadSettingTable$Columns.TYPE)), 0);
        com.tencent.mm.plugin.webview.model.e bQA = com.tencent.mm.plugin.webview.model.e.a.bQA();
        if (ar.Hj()) {
            long longValue;
            com.tencent.mm.plugin.webview.model.d bRD = com.tencent.mm.plugin.webview.modeltools.f.bRD();
            Long l = (Long) bRD.trR.get(Integer.valueOf(i));
            if (l != null) {
                longValue = l.longValue();
            } else {
                Cursor a = bRD.hhp.a(String.format("select %s from %s where %s=?", new Object[]{"liftTime", "JsLogBlockList", "logId"}), new String[]{String.valueOf(i)}, 2);
                if (a == null) {
                    longValue = 0;
                } else if (a.moveToFirst()) {
                    longValue = a.getLong(0);
                    a.close();
                } else {
                    a.close();
                    longValue = 0;
                }
            }
            if (longValue != 0 && longValue < bh.Wo()) {
                com.tencent.mm.sdk.platformtools.au auVar = bRD.trR;
                Integer valueOf = Integer.valueOf(i);
                if (valueOf == null) {
                    throw new NullPointerException("key == null");
                }
                if (auVar.get(valueOf) != null) {
                    auVar.r(valueOf, null);
                }
                longValue = 0;
            }
            if (longValue == 0 || longValue < bh.Wo()) {
                ano com_tencent_mm_protocal_c_ano = new ano();
                com_tencent_mm_protocal_c_ano.wuu = i;
                com_tencent_mm_protocal_c_ano.wuv = com.tencent.mm.bq.b.Tl(bY);
                com_tencent_mm_protocal_c_ano.wuD = i2;
                bQA.trW.add(com_tencent_mm_protocal_c_ano);
                obj = 1;
                if (obj == null) {
                    a(iVar, "realtimeReport:ok", null);
                } else {
                    a(iVar, "realtimeReport:fail", null);
                }
                return true;
            }
        }
        x.i("MicroMsg.WebView.JsLogHelper", "kvStat(), acc not ready, skip");
        obj = null;
        if (obj == null) {
            a(iVar, "realtimeReport:fail", null);
        } else {
            a(iVar, "realtimeReport:ok", null);
        }
        return true;
    }

    public final boolean bF(i iVar) {
        String str = (String) iVar.pox.get("latitude");
        String str2 = (String) iVar.pox.get("longitude");
        String str3 = (String) iVar.pox.get("destinationName");
        if (bh.ov(str) || bh.ov(str2)) {
            a(iVar, "openMapNavigateMenu:fail", null);
        } else {
            try {
                double parseDouble = Double.parseDouble(str);
                double parseDouble2 = Double.parseDouble(str2);
                int i = bh.getInt((String) iVar.pox.get("preferMap"), com.tencent.mm.pluginsdk.model.a.a.vda.code);
                if (this.context == null || !(this.context instanceof Activity) || ((Activity) this.context).isFinishing()) {
                    a(iVar, "openMapNavigateMenu:fail", null);
                } else {
                    ag.y(new 20(this, i, parseDouble, parseDouble2, str3, aU(iVar)));
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doOpenMapNavigateMenu, parse double, exception = %s");
                a(iVar, "openMapNavigateMenu:fail", null);
            }
        }
        return true;
    }

    public final Bundle bUI() {
        Bundle bundle = null;
        try {
            bundle = this.fBH.e(33, null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        x.i("MicroMsg.MsgHandler", "getWebViewIntentExtras(%s)", new Object[]{bundle});
        return bundle;
    }

    private boolean bG(i iVar) {
        String str = (String) iVar.pox.get("operationType");
        String str2 = (String) iVar.pox.get("dataUrl");
        k.a(iVar.tJH, false, null, "");
        if (bh.ov(str) || bh.ov(str2)) {
            a(iVar, "operateMusicPlayer:fail", null);
            return true;
        }
        if (str.equalsIgnoreCase("play")) {
            String str3 = (String) iVar.pox.get("title");
            String str4 = (String) iVar.pox.get("singer");
            String str5 = (String) iVar.pox.get("epname");
            String str6 = (String) iVar.pox.get("coverImgUrl");
            String str7 = (String) iVar.pox.get("lowbandUrl");
            String str8 = (String) iVar.pox.get("webUrl");
            iVar.pox.get("lyric");
            x.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str3, str4, str5, str6, str2, str7, str8, ""});
            if (bh.ov(str3) || bh.ov(str4) || bh.ov(str5) || bh.ov(str6) || bh.ov(str7) || bh.ov(str2) || bh.ov(str8)) {
                a(iVar, "operateMusicPlayer:fail", null);
            } else {
                com.tencent.mm.av.b.Qo();
                com.tencent.mm.av.a.a aVar = (com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class);
                String str9 = str2.hashCode();
                String str10 = com.tencent.mm.compatible.util.e.bnF;
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                com.tencent.mm.av.b.b(aVar.a(7, str6, str3, str4, str8, str7, str2, str9, str10, stringBuilder.append(com.tencent.mm.z.c.Fi()).append(str6.hashCode()).toString(), str5, ""));
                a(iVar, "operateMusicPlayer:ok", null);
            }
        } else if (str.equalsIgnoreCase("resume")) {
            if (com.tencent.mm.av.c.lL(str2) && com.tencent.mm.av.b.Qr() && !com.tencent.mm.av.b.Qq()) {
                com.tencent.mm.av.b.xT();
                r0 = 1;
            } else {
                r0 = null;
            }
            if (r0 != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("pause")) {
            if (com.tencent.mm.av.c.lL(str2) && com.tencent.mm.av.b.Qq()) {
                com.tencent.mm.av.b.xS();
                r0 = 1;
            } else {
                r0 = null;
            }
            if (r0 != null) {
                com.tencent.mm.av.b.Qp();
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("seek")) {
            if (com.tencent.mm.av.c.lL(str2) ? com.tencent.mm.av.b.if(bh.getInt(bh.bY(iVar.pox.get("position")), -1) * 1000) : false) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            if (com.tencent.mm.av.c.lL(str2) && com.tencent.mm.av.b.Qr()) {
                com.tencent.mm.av.b.Qo();
                r0 = 1;
            } else {
                r0 = null;
            }
            if (r0 != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else {
            a(iVar, "operateMusicPlayer:fail", null);
        }
        return true;
    }

    private boolean bH(i iVar) {
        String str = (String) iVar.pox.get("dataUrl");
        k.a(iVar.tJH, false, null, (String) iVar.pox.get("appId"));
        if (bh.ov(str)) {
            a(iVar, "getMusicPlayerState:fail_dataUrl_null", null);
        } else {
            x.i("MicroMsg.MsgHandler", "dataUrl : %s, appid : %s", new Object[]{str, r1});
            asv Qs = com.tencent.mm.av.b.Qs();
            if (Qs == null || !Qs.wAo.equals(str)) {
                a(iVar, "getMusicPlayerState:failed_dataUrl_diff", null);
            } else {
                int i;
                int i2;
                com.tencent.mm.av.d Qt = com.tencent.mm.av.b.Qt();
                if (Qt != null) {
                    i = Qt.mDuration;
                    i2 = Qt.mPosition;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (Qt == null || i < 0 || i2 < 0) {
                    a(iVar, "getMusicPlayerState:fail", null);
                } else {
                    i /= 1000;
                    i2 /= 1000;
                    int i3 = Qt.mStatus;
                    int i4 = Qt.hHX;
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                    hashMap.put("currentPosition", Integer.valueOf(i2));
                    hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i3));
                    hashMap.put("downloadPercent", Integer.valueOf(i4));
                    a(iVar, "getMusicPlayerState:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean bI(i iVar) {
        String str = (String) iVar.pox.get("localId");
        if (bh.ov(str)) {
            a(iVar, "getLocalImgData:fail_invaild_localid", null);
        } else {
            WebViewJSSDKFileItem Oo = com.tencent.mm.plugin.webview.modeltools.f.bRB().Oo(str);
            if (!(Oo == null || Oo.jip == null)) {
                int i;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(Oo.jip);
                int i2 = decodeFile != null ? 1 : 0;
                if (decodeFile.isRecycled()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i2 & i) != 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    x.i("MicroMsg.MsgHandler", "rawData lenght = %d, base64 lenght = %d", new Object[]{Integer.valueOf(byteArrayOutputStream.toByteArray().length), Integer.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0).length())});
                    Map hashMap = new HashMap();
                    hashMap.put("localData", r3);
                    a(iVar, "getLocalImgData:ok", hashMap);
                    decodeFile.recycle();
                }
            }
            a(iVar, "getLocalImgData:fail", null);
        }
        return true;
    }

    private boolean bJ(i iVar) {
        int i = 0;
        this.maM = false;
        Bundle bundle = new Bundle();
        try {
            int i2 = bh.getInt(iVar.pox.get("scene").toString().trim(), 0);
            bundle.putInt("scene", i2);
            x.i("MicroMsg.MsgHandler", "doExposePreparation scene:%d", new Object[]{Integer.valueOf(i2)});
            if (-1 == bundle.getInt("scene")) {
                a(iVar, "doExposePreparation fail:unknown scene", null);
            } else {
                bundle = this.fBH.e(73, bundle);
                Map hashMap = new HashMap();
                if (bundle.isEmpty()) {
                    a(iVar, "doExposePreparation fail", null);
                } else {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                            break;
                        case 33:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            break;
                        case 34:
                            hashMap.put("webviewImg", bundle.getString("webviewImg"));
                            hashMap.put("webviewHtml", bundle.getString("webviewHtml"));
                            hashMap.put("content", bundle.getString("content"));
                            x.i("MicroMsg.MsgHandler", "content = " + bundle.getString("content"));
                            break;
                        case 51:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            hashMap.put("msgType", Integer.valueOf(bundle.getInt("msgType")));
                            break;
                        default:
                            a(iVar, "doExposePreparation fail:unknown scene", null);
                            break;
                    }
                    hashMap.put("username", bundle.getString("username"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList stringArrayList = bundle.getStringArrayList("content");
                    if (stringArrayList != null) {
                        int size = stringArrayList.size();
                        while (i < size) {
                            jSONArray.put(stringArrayList.get(i));
                            i++;
                        }
                    }
                    if (hashMap.get("content") == null) {
                        hashMap.put("content", jSONArray.toString());
                    }
                    a(iVar, "doExposePreparation ok", hashMap);
                }
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doExposePreparation exception " + e.getMessage());
            a(iVar, "doExposePreparation fail", null);
        }
        return true;
    }

    private boolean bK(i iVar) {
        try {
            String obj = iVar.pox.get(DownloadSettingTable$Columns.TYPE).toString();
            if (bh.ov(obj)) {
                a(iVar, "openLuckyMoneyHistory:fail", null);
            } else if (obj.equals("send")) {
                r0 = new Intent();
                r0.putExtra("key_type", 1);
                com.tencent.mm.bm.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r0);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            } else if (obj.equals("receive")) {
                r0 = new Intent();
                r0.putExtra("key_type", 2);
                com.tencent.mm.bm.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r0);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doOpenLuckyMoneyHistory error %s", new Object[]{e});
            a(iVar, "openLuckyMoneyHistory:fail", null);
        }
        return true;
    }

    private boolean bL(i iVar) {
        this.maM = false;
        String trim = iVar.pox.get("scene").toString().trim();
        if (!trim.equals("expose")) {
            a(iVar, "openSecurityView fail, scene error : " + trim, null);
        } else if (iVar.pox.get("userData") != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(iVar.pox.get("userData").toString()).nextValue();
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", jSONObject.get("userName").toString());
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 1);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                com.tencent.mm.bm.d.b(this.context, "sns", ".ui.SnsPermissionUI", intent);
                a(iVar, "openSecurityView ok", null);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "openSecurityView error, userData not in json");
                a(iVar, "openSecurityView error,userData not in json", null);
            }
        } else {
            a(iVar, "openSecurityView fail, no userData", null);
        }
        return true;
    }

    private boolean bM(i iVar) {
        String qE = qE(aeq());
        String yE = com.tencent.mm.compatible.d.q.yE();
        String yF = com.tencent.mm.compatible.d.q.yF();
        if (bh.ov(yE) || bh.ov(qE) || bh.ov(yF)) {
            a(iVar, "getOpenDeviceId:fail", null);
        } else {
            yE = com.tencent.mm.sdk.platformtools.ab.UZ(com.tencent.mm.sdk.platformtools.ab.UZ(qE + yE));
            qE = com.tencent.mm.sdk.platformtools.ab.UZ(com.tencent.mm.sdk.platformtools.ab.UZ(qE + yF));
            Map hashMap = new HashMap();
            hashMap.put("deviceid", yE);
            hashMap.put("newDeviceId", qE);
            a(iVar, "getOpenDeviceId:ok", hashMap);
        }
        return true;
    }

    private boolean bN(i iVar) {
        try {
            Bundle e = this.fBH.e(90000, null);
            if (e != null) {
                String str;
                String str2;
                String str3;
                Object[] objArr;
                Map hashMap;
                JSONArray jSONArray;
                String[] stringArray = e.getStringArray("webview_get_route_url_list");
                int i = e.getInt("webview_get_route_url_geta8key_scene");
                if (i == 7) {
                    String string = e.getString("geta8key_username");
                    if (!bh.ov(string)) {
                        com.tencent.mm.ag.d jS = com.tencent.mm.ag.f.jS(string);
                        if (jS != null) {
                            str = jS.field_appId;
                            str2 = "MicroMsg.MsgHandler";
                            str3 = "routeUrl length = %d, scene = %d, appid = %s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = str;
                            x.i(str2, str3, objArr);
                            if (stringArray != null && stringArray.length > 0) {
                                hashMap = new HashMap();
                                jSONArray = new JSONArray();
                                for (Object put : stringArray) {
                                    jSONArray.put(put);
                                }
                                hashMap.put("urls", jSONArray.toString());
                                hashMap.put("scene", Integer.valueOf(i));
                                if (!bh.ov(str)) {
                                    hashMap.put("appid", str);
                                }
                                a(iVar, "getRouteUrl:ok", hashMap);
                                return true;
                            }
                        }
                    }
                }
                str = null;
                str2 = "MicroMsg.MsgHandler";
                str3 = "routeUrl length = %d, scene = %d, appid = %s";
                objArr = new Object[3];
                if (stringArray == null) {
                }
                objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str;
                x.i(str2, str3, objArr);
                hashMap = new HashMap();
                jSONArray = new JSONArray();
                while (r0 < r8) {
                    jSONArray.put(put);
                }
                hashMap.put("urls", jSONArray.toString());
                hashMap.put("scene", Integer.valueOf(i));
                if (bh.ov(str)) {
                    hashMap.put("appid", str);
                }
                a(iVar, "getRouteUrl:ok", hashMap);
                return true;
            }
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "get routeurl failed ; %s", new Object[]{e2.getMessage()});
        }
        a(iVar, "getRouteUrl:fail", null);
        return true;
    }

    private boolean bO(i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetBackgroundAudioState()");
        if (bQ(iVar)) {
            asv Qs = com.tencent.mm.av.b.Qs();
            if (Qs != null) {
                int i;
                int i2;
                com.tencent.mm.av.d Qt = com.tencent.mm.av.b.Qt();
                if (Qt != null) {
                    i = Qt.mDuration;
                    i2 = Qt.mPosition;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (Qt == null || i < 0 || i2 < 0) {
                    x.e("MicroMsg.MsgHandler", "return parameter is invalid");
                    a(iVar, "getBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.sdk.b.a.xef.b(this.tIf);
                    i /= 1000;
                    int i3 = i2 / 1000;
                    int i4 = Qt.mStatus;
                    i2 = Qt.hHX;
                    if (i > 0) {
                        i2 = (i2 * i) / 100;
                    } else {
                        i2 = 0;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                    hashMap.put("currentTime", Integer.valueOf(i3));
                    hashMap.put("paused", Integer.valueOf(i4 == 1 ? 0 : 1));
                    hashMap.put("src", Qs.wAo);
                    hashMap.put("buffered", Integer.valueOf(i2));
                    hashMap.put("title", Qs.wAk);
                    hashMap.put("epname", Qs.wAm);
                    hashMap.put("singer", Qs.wAl);
                    hashMap.put("coverImgUrl", Qs.wAn);
                    hashMap.put("isLive", Integer.valueOf(0));
                    hashMap.put("startTime", Integer.valueOf(Qs.hkt / 1000));
                    hashMap.put("srcId", Qs.hHP);
                    hashMap.put("protocol", Qs.protocol == null ? "" : Qs.protocol);
                    hashMap.put("webUrl", Qs.wAq);
                    hashMap.put("playState", Qt.hHY);
                    x.i("MicroMsg.MsgHandler", "getBackgroundAudioState ok");
                    a(iVar, "getBackgroundAudioState:ok", hashMap);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "currentWrapper is null");
                a(iVar, "getBackgroundAudioState:fail", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "no permission to do get state");
            a(iVar, "getBackgroundAudioState:fail", null);
        }
        return true;
    }

    private boolean e(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String PB;
        String str;
        String OA;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        String str9;
        String str10;
        boolean gn;
        String str11;
        x.i("MicroMsg.MsgHandler", "doSetBackgroundAudioState()");
        com.tencent.mm.sdk.b.a.xef.b(this.tIf);
        CharSequence charSequence = (String) iVar.pox.get("appId");
        if (this.tHs != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.tHs.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                PB = this.tHB.PB(aeq());
                x.i("MicroMsg.MsgHandler", "appId:%s", new Object[]{PB});
                k.a(iVar.tJH, false, null, PB);
                str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (bh.ov(str)) {
                    OA = com.tencent.mm.plugin.webview.modelcache.p.OA(str);
                } else {
                    OA = null;
                }
                str2 = (String) iVar.pox.get("src");
                str3 = (String) iVar.pox.get("lowbandSrc");
                str4 = (String) iVar.pox.get("title");
                str5 = (String) iVar.pox.get("epname");
                str6 = (String) iVar.pox.get("singer");
                str = (String) iVar.pox.get("coverImgUrl");
                str7 = (String) iVar.pox.get("webUrl");
                i = bh.getInt((String) iVar.pox.get("startTime"), 0);
                str8 = (String) iVar.pox.get("srcId");
                str9 = (String) iVar.pox.get("protocol");
                str10 = (String) iVar.pox.get("musicbar_url");
                gn = jsapiPermissionWrapper.gn(308);
                if (str != null) {
                    str11 = "";
                } else {
                    str11 = str;
                }
                x.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", new Object[]{str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(gn), str10});
                if (!bh.ov(str2) || bh.ov(str4)) {
                    x.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
                    a(iVar, "setBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.av.a.a aVar = (com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class);
                    String str12 = str2.hashCode();
                    String str13 = com.tencent.mm.compatible.util.e.bnF;
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    asv a = aVar.a(10, str11, str4, str6, str7, str3, str2, str12, str13, stringBuilder.append(com.tencent.mm.z.c.Fi()).append(str11.hashCode()).toString(), str5, PB);
                    a.wAC = OA;
                    a.hkt = i * 1000;
                    a.hHP = str8;
                    a.protocol = str9;
                    a.wAD = gn;
                    a.wAE = str10;
                    com.tencent.mm.av.b.b(a);
                    x.i("MicroMsg.MsgHandler", "setBackgroundAudioState ok");
                    a(iVar, "setBackgroundAudioState:ok", null);
                }
                return true;
            }
        }
        CharSequence charSequence2 = charSequence;
        x.i("MicroMsg.MsgHandler", "appId:%s", new Object[]{PB});
        k.a(iVar.tJH, false, null, PB);
        str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(str)) {
            OA = null;
        } else {
            OA = com.tencent.mm.plugin.webview.modelcache.p.OA(str);
        }
        str2 = (String) iVar.pox.get("src");
        str3 = (String) iVar.pox.get("lowbandSrc");
        str4 = (String) iVar.pox.get("title");
        str5 = (String) iVar.pox.get("epname");
        str6 = (String) iVar.pox.get("singer");
        str = (String) iVar.pox.get("coverImgUrl");
        str7 = (String) iVar.pox.get("webUrl");
        i = bh.getInt((String) iVar.pox.get("startTime"), 0);
        str8 = (String) iVar.pox.get("srcId");
        str9 = (String) iVar.pox.get("protocol");
        str10 = (String) iVar.pox.get("musicbar_url");
        gn = jsapiPermissionWrapper.gn(308);
        if (str != null) {
            str11 = str;
        } else {
            str11 = "";
        }
        x.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", new Object[]{str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(gn), str10});
        if (bh.ov(str2)) {
        }
        x.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
        a(iVar, "setBackgroundAudioState:fail", null);
        return true;
    }

    private boolean bP(i iVar) {
        String str = (String) iVar.pox.get("operationType");
        x.i("MicroMsg.MsgHandler", "doOperateBackgroundAudio(), optype:%s", new Object[]{str});
        String str2 = (String) iVar.pox.get("appId");
        if (this.tHs != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.tHs.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.tHB.PB(aeq());
            }
        }
        k.a(iVar.tJH, false, null, str2);
        if (!bQ(iVar)) {
            x.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio getMusicPermission is false");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio optype is empty");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else {
            com.tencent.mm.sdk.b.a.xef.b(this.tIf);
            if (str.equalsIgnoreCase("play")) {
                if (com.tencent.mm.av.c.Qu()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio play fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                if (com.tencent.mm.av.c.Qu()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio resume fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("pause")) {
                if (com.tencent.mm.av.c.Qv()) {
                    com.tencent.mm.av.b.Qp();
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio pause fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("seek")) {
                int i = bh.getInt((String) iVar.pox.get("currentTime"), -1);
                x.i("MicroMsg.MsgHandler", "currentTime:%d", new Object[]{Integer.valueOf(i)});
                if (i < 0) {
                    x.e("MicroMsg.MsgHandler", "currentTime is invalid!");
                    a(iVar, "operateBackgroundAudio:fail", null);
                } else if (com.tencent.mm.av.b.if(i * 1000)) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio seek fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (!str.equalsIgnoreCase("stop")) {
                x.e("MicroMsg.MsgHandler", "operateBackgroundAudio fail, invalid opeType");
                a(iVar, "operateBackgroundAudio:fail", null);
            } else if (com.tencent.mm.av.c.Qw()) {
                a(iVar, "operateBackgroundAudio:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "operateBackgroundAudio stop fail");
                a(iVar, "operateBackgroundAudio:fail", null);
            }
        }
        return true;
    }

    private boolean bQ(i iVar) {
        Object PB;
        String str;
        Object obj;
        boolean z;
        String str2;
        String str3;
        Object[] objArr;
        int i = 1;
        asv Qs = com.tencent.mm.av.b.Qs();
        CharSequence charSequence = (String) iVar.pox.get("appId");
        if (this.tHs != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.tHs.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                PB = this.tHB.PB(aeq());
                str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                obj = null;
                if (!bh.ov(str)) {
                    obj = com.tencent.mm.plugin.webview.modelcache.p.OA(str);
                }
                if (Qs == null) {
                    str = Qs.ngo;
                    String OA = com.tencent.mm.plugin.webview.modelcache.p.OA(Qs.wAq);
                    String str4 = Qs.wAC;
                    x.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", new Object[]{PB, str});
                    x.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", new Object[]{obj, OA, str4});
                    if (TextUtils.isEmpty(PB) && PB.equalsIgnoreCase(str)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(OA)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(str4)) {
                        z = true;
                    }
                } else {
                    x.e("MicroMsg.MsgHandler", "currentWrapper is null");
                    z = false;
                }
                str2 = "MicroMsg.MsgHandler";
                str3 = "getMusicPermission hasPermmision:%d";
                objArr = new Object[1];
                if (!z) {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                x.i(str2, str3, objArr);
                return z;
            }
        }
        CharSequence charSequence2 = charSequence;
        str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        obj = null;
        if (bh.ov(str)) {
            obj = com.tencent.mm.plugin.webview.modelcache.p.OA(str);
        }
        if (Qs == null) {
            x.e("MicroMsg.MsgHandler", "currentWrapper is null");
            z = false;
        } else {
            str = Qs.ngo;
            String OA2 = com.tencent.mm.plugin.webview.modelcache.p.OA(Qs.wAq);
            String str42 = Qs.wAC;
            x.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", new Object[]{PB, str});
            x.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", new Object[]{obj, OA2, str42});
            if (TextUtils.isEmpty(PB)) {
            }
            z = false;
            z = true;
            z = true;
        }
        str2 = "MicroMsg.MsgHandler";
        str3 = "getMusicPermission hasPermmision:%d";
        objArr = new Object[1];
        if (z) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        return z;
    }

    private boolean bR(i iVar) {
        String H = aq.hfP.H("login_user_name", "");
        String str = (String) iVar.pox.get("request_ticket");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "requestVoiceLoginVerify, ticket is null");
            a(iVar, "requestVoiceLoginVerify:ticket is null", null);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Kusername", H);
            intent.putExtra("Kvertify_key", str);
            if (this.context instanceof MMActivity) {
                ((MMActivity) this.context).jwN = this;
                com.tencent.mm.bm.d.b(this.context, "voiceprint", ".ui.VoiceLoginUI", intent, 57);
            }
        }
        return true;
    }

    private boolean bS(i iVar) {
        Map hashMap = new HashMap();
        try {
            o(iVar);
            String str = (String) iVar.pox.get("next_step");
            x.i("MicroMsg.MsgHandler", "next_step: %s", new Object[]{str});
            if (!bh.ov(str)) {
                if ("auth_again".equals(str)) {
                    if (this.context != null && (this.context instanceof MMActivity)) {
                        Intent intent = new Intent();
                        if (((MMActivity) this.context).getIntent().hasExtra("VoiceLoginAuthPwd")) {
                            intent.putExtra("VoiceLoginAuthPwd", ((MMActivity) this.context).getIntent().getStringExtra("VoiceLoginAuthPwd"));
                        }
                        ((MMActivity) this.context).setResult(-1);
                    }
                } else if ("get_reg_verify_code".equals(str)) {
                    if (this.context != null && (this.context instanceof MMActivity)) {
                        ((MMActivity) this.context).setResult(-1);
                    }
                } else if ("go_reg_from_login".equals(str) && this.context != null && (this.context instanceof MMActivity)) {
                    ((MMActivity) this.context).setResult(-1);
                }
            }
            hashMap.put("err_code", Integer.valueOf(0));
            hashMap.put("err_msg", "ok");
            a(iVar, "close window and next:ok", hashMap);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
            hashMap.put("err_code", Integer.valueOf(1));
            hashMap.put("err_msg", "fail");
            a(iVar, "close window and next:fail", hashMap);
        }
        return true;
    }

    private boolean bT(i iVar) {
        String str = (String) iVar.pox.get("username");
        if (bh.ov(str)) {
            a(iVar, "open_biz_chat:param_err", null);
        } else {
            ar.Hg();
            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
            if (WO == null || !WO.cia()) {
                a(iVar, "open_biz_chat:not biz username", null);
            } else if (com.tencent.mm.l.a.fZ(WO.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.bm.d.a(this.context, ".ui.chatting.ChattingUI", intent);
                a(iVar, "open_biz_chat:ok", null);
            } else {
                a(iVar, "open_biz_chat:unfollow", null);
            }
        }
        return true;
    }

    private boolean bU(i iVar) {
        String str = (String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(str)) {
            x.i("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView, url is null");
            a(iVar, "openGameUrlWithExtraWebView:fail", null);
        } else {
            int i;
            String str2 = (String) iVar.pox.get("statusBarColor");
            if (bh.ov(str2)) {
                i = 0;
            } else {
                try {
                    i = Color.parseColor(str2);
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView: " + e.getMessage());
                    a(iVar, "openGameUrlWithExtraWebView:fail_invalid_color", null);
                }
            }
            str2 = (String) iVar.pox.get("statusBarStyle");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("customize_status_bar_color", i);
            intent.putExtra("status_bar_style", str2);
            com.tencent.mm.sdk.b.b kjVar = new kj();
            kjVar.fBG.type = 0;
            kjVar.fBG.context = this.context;
            kjVar.fBG.intent = intent;
            kjVar.fBG.fBH = this.fBH;
            com.tencent.mm.sdk.b.a.xef.m(kjVar);
            a(iVar, "openGameUrlWithExtraWebView:ok", null);
        }
        return true;
    }

    private boolean bV(i iVar) {
        String qE = qE(aeq());
        if (bh.ov(qE)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "setGameData:fail_appid_null", null);
        } else {
            String str = (String) iVar.pox.get("key");
            String str2 = (String) iVar.pox.get(DownloadSettingTable$Columns.VALUE);
            String str3 = (String) iVar.pox.get("weight");
            String str4 = (String) iVar.pox.get("expireTime");
            boolean z = bh.getBoolean((String) iVar.pox.get("autoClean"), true);
            if (bh.ov(str) || bh.ov(str2)) {
                x.i("MicroMsg.MsgHandler", "key or value is null");
                a(iVar, "setGameData:fail_null_key", null);
            } else if (com.tencent.mm.plugin.webview.b.b.bPa().a(qE, str, str2, str3, str4, z)) {
                a(iVar, "setGameData:ok", null);
            } else {
                a(iVar, "setGameData:fail_exceed_size", null);
            }
        }
        return true;
    }

    private boolean bW(i iVar) {
        String qE = qE(aeq());
        if (bh.ov(qE)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "getGameData:fail", null);
        } else {
            String str = (String) iVar.pox.get("key");
            if (bh.ov(str)) {
                x.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "getGameData:fail", null);
            } else {
                com.tencent.mm.plugin.webview.b.a eH = com.tencent.mm.plugin.webview.b.b.bPa().eH(qE, str);
                if (bh.ov(eH.field_value)) {
                    a(iVar, "getGameData:ok", null);
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put(DownloadSettingTable$Columns.VALUE, eH.field_value);
                    hashMap.put("weight", eH.field_weight);
                    hashMap.put("expireTime", Long.valueOf(eH.field_expireTime - (System.currentTimeMillis() / 1000)));
                    a(iVar, "getGameData:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean bX(i iVar) {
        String qE = qE(aeq());
        if (bh.ov(qE)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "clearData:fail", null);
        } else {
            String str = (String) iVar.pox.get("keys");
            boolean z = bh.getBoolean((String) iVar.pox.get("clearAllData"), false);
            if (!bh.ov(str)) {
                try {
                    com.tencent.mm.plugin.webview.b.b.bPa().b(qE, new JSONArray(str));
                    a(iVar, "clearGameData:ok", null);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doClearData: " + e.getMessage());
                    a(iVar, "clearGameData:fail", null);
                }
            } else if (z) {
                com.tencent.mm.plugin.webview.b.b.bPa().NV(qE);
                a(iVar, "clearGameData:ok", null);
            } else {
                x.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "clearGameData:fail", null);
            }
        }
        return true;
    }

    private boolean bY(i iVar) {
        this.maM = false;
        a(iVar, "recordHistory:ok", null);
        if (j.Rc().Rd()) {
            String BP = com.tencent.mm.plugin.webview.model.ak.BP((String) iVar.pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
            if (bh.ov(BP)) {
                a(iVar, "recordHistory:fail", null);
            } else {
                boolean z;
                String str;
                String ou;
                int i = bh.getInt((String) iVar.pox.get("webview_scene"), 0);
                if (i == 33 || i == 46) {
                    x.i("MicroMsg.MsgHandler", "hasRecordPermission false, getA8keyScene = " + i);
                    z = false;
                } else if (BP.startsWith("http")) {
                    Uri parse = Uri.parse(BP);
                    str = parse.getHost() + parse.getPath();
                    x.i("MicroMsg.MsgHandler", "hasRecordPermission, hostPath: " + str);
                    String string = com.tencent.mm.plugin.webview.model.y.a.bQK().getString("oauth_host_paths");
                    if (bh.ov(string)) {
                        string = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    String[] split = string.split(";");
                    if (str.contains("weixin110.qq.com")) {
                        z = false;
                    } else if ("weixin110.qq.com;res.wx.qq.com;weops.qq.com;wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;payapp.weixin.qq.com;pay.weixin.qq.com;wx.tenpay.com".contains(parse.getHost().toLowerCase())) {
                        x.i("MicroMsg.MsgHandler", "forbidden host %s", new Object[]{parse.getHost()});
                        z = false;
                    } else {
                        for (String ou2 : split) {
                            if (str.equalsIgnoreCase(ou2)) {
                                z = false;
                                break;
                            }
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    ou2 = bh.ou((String) iVar.pox.get("title"));
                    str = bh.ou((String) iVar.pox.get("source"));
                    String ou3 = bh.ou((String) iVar.pox.get("img_url"));
                    x.i("MicroMsg.MsgHandler", "doRecordHistory link %s,title %s,source %s,imgUrl %s", new Object[]{BP, ou2, str, ou3});
                    com.tencent.mm.plugin.webview.b.e bRF = com.tencent.mm.plugin.webview.modeltools.f.bRF();
                    com.tencent.mm.sdk.e.c dVar = new com.tencent.mm.plugin.webview.b.d();
                    dVar.field_link = BP;
                    if (!bRF.b(dVar, new String[]{"link"})) {
                        dVar = null;
                    }
                    if (dVar != null) {
                        x.i("MicroMsg.MsgHandler", "doRecordHistory update");
                        dVar.field_link = BP;
                        dVar.field_title = ou2;
                        dVar.field_source = str;
                        dVar.field_imgUrl = ou3;
                        dVar.field_timeStamp = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.webview.modeltools.f.bRF().c(dVar, new String[0]);
                    } else {
                        x.i("MicroMsg.MsgHandler", "doRecordHistory insert");
                        com.tencent.mm.plugin.webview.b.e bRF2 = com.tencent.mm.plugin.webview.modeltools.f.bRF();
                        com.tencent.mm.sdk.e.c dVar2 = new com.tencent.mm.plugin.webview.b.d();
                        dVar2.field_link = BP;
                        dVar2.field_title = ou2;
                        dVar2.field_source = str;
                        dVar2.field_imgUrl = ou3;
                        dVar2.field_timeStamp = System.currentTimeMillis() / 1000;
                        dVar2.field_recordId = BP.hashCode() + "_" + System.currentTimeMillis();
                        x.i("MicroMsg.WebViewHistoryStorage", "insert: " + bRF2.b(dVar2));
                        com.tencent.mm.bz.a.post(new e$1(bRF2));
                    }
                    a(iVar, "recordHistory:ok", null);
                } else {
                    a(iVar, "recordHistory:fail", null);
                }
            }
        } else {
            x.i("MicroMsg.MsgHandler", "doRecordHistory switch close");
        }
        return true;
    }

    private boolean bZ(i iVar) {
        Map hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(com.b.a.a.a.hL()));
        hashMap.put("cpuFreqHz", Integer.valueOf(com.b.a.a.a.hM()));
        hashMap.put("memory", Long.valueOf(com.b.a.a.a.s(ac.getContext())));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        a(iVar, "getCpuMenInfo:ok", hashMap);
        return true;
    }

    private boolean ca(i iVar) {
        try {
            x.i("MicroMsg.MsgHandler", "doServiceClick, tid = %s", new Object[]{(String) iVar.pox.get("tid")});
            Bundle bundle = new Bundle();
            bundle.putString("service_click_tid", r0);
            this.fBH.n(70, bundle);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        this.maM = false;
        return false;
    }

    private boolean cb(i iVar) {
        String qE = qE(aeq());
        if (bh.ov(qE)) {
            x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]appid is null, return");
            a(iVar, "openRealnameAuth:fail appid is null", null);
            return false;
        }
        String str = (String) iVar.pox.get("categoryId");
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]categoryId is null, return");
            a(iVar, "openRealnameAuth:fail categoryId is null", null);
            return false;
        }
        Intent putExtra = new Intent().putExtra("intent_appid", qE).putExtra("intent_category_id", str);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).jwN = this;
            com.tencent.mm.bm.d.b(this.context, "appbrand", ".ui.autofill.AppBrandIDCardUI", putExtra, 62);
            return true;
        }
        x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]context is err, return");
        a(iVar, "openRealnameAuth:fail context is err", null);
        return false;
    }

    private boolean cc(i iVar) {
        this.fzc = f(iVar);
        if (this.fzc == null) {
            x.e("MicroMsg.MsgHandler", "doSendSingleAppMessage fail, appmsg is null");
            a(iVar, "sendSingleAppMessage:fail", null);
        } else {
            Serializable hashMap = new HashMap();
            hashMap.put("img_url", (String) iVar.pox.get("img_url"));
            hashMap.put("desc", (String) iVar.pox.get("desc"));
            hashMap.put("title", (String) iVar.pox.get("title"));
            hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, (String) iVar.pox.get("link"));
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 7);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("Select_block_List", q.FS());
            intent.putExtra("Select_block_List", "filehelper," + q.FS());
            intent.putExtra("scene_from", 10);
            intent.putExtra("webview_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            if (this.context instanceof MMActivity) {
                com.tencent.mm.bm.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 61, this);
            }
        }
        return true;
    }
}
