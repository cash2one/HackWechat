package com.tencent.liteav;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class d {
    private static String a = "TXCDataReport";
    private HashMap b = new HashMap(100);
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private String i;
    private long j;
    private int k;
    private long l;
    private boolean m;
    private long n;
    private int o;
    private boolean p = false;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private String v = "";

    public d(Context context) {
        this.h = context.getApplicationContext();
        this.i = TXCCommonUtil.getAppVersion();
        this.o = 5000;
        this.u = 0;
    }

    public void a() {
        o();
        this.l = -1;
        this.q = System.currentTimeMillis();
    }

    public void b() {
        if (this.m) {
            m();
            return;
        }
        TXCLog.e(a, "push " + this.c + " failed!");
        k();
    }

    public void c() {
        if (!this.m) {
            TXCLog.e(a, "play " + this.c + " failed");
            if (this.p) {
                b(false);
            } else {
                g();
            }
        } else if (this.p) {
            p();
        } else {
            h();
        }
        if (this.p) {
            j();
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.v = str;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void d() {
        if (!(this.m || TextUtils.isEmpty(TXCStatus.c(this.v, 7012)))) {
            l();
            this.m = true;
        }
        if (this.n <= 0) {
            this.n = TXCTimeUtil.getTimeTick();
        }
        if (this.m && TXCTimeUtil.getTimeTick() - this.n > 5000) {
            n();
            this.n = TXCTimeUtil.getTimeTick();
        }
    }

    public void e() {
        if (!this.m) {
            long b = TXCStatus.b(this.v, 6001);
            long b2 = TXCStatus.b(this.v, 7104);
            if (!(b == 0 && b2 == 0)) {
                if (this.p) {
                    b(true);
                } else {
                    f();
                }
                this.o = 5000;
                this.m = true;
            }
        }
        if (this.n <= 0) {
            this.n = TXCTimeUtil.getTimeTick();
        }
        if (this.m && TXCTimeUtil.getTimeTick() > this.n + ((long) this.o)) {
            if (this.p) {
                q();
                this.o = 5000;
            } else {
                i();
                this.o = TXCDRApi.getStatusReportInterval();
                if (this.o < 5000) {
                    this.o = 5000;
                }
                if (this.o > 300000) {
                    this.o = 300000;
                }
            }
            this.l = TXCStatus.b(this.v, 6004);
            this.n = TXCTimeUtil.getTimeTick();
        }
    }

    private void f() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.T, a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.T, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, a.T, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_network_type", (long) c("u32_network_type"));
        long b = TXCStatus.b(this.v, 7107);
        long b2 = TXCStatus.b(this.v, 7108);
        if (b2 != -1) {
            b2 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_dns_time", b2);
        String c = TXCStatus.c(this.v, 7110);
        TXCDRApi.txSetEventValue(str, a.T, "u32_server_ip", c);
        long b3 = TXCStatus.b(this.v, 7109);
        if (b3 != -1) {
            b3 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_connect_server_time", b3);
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_stream_begin", -1);
        this.j = TXCStatus.b(this.v, 6001) - b;
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_first_i_frame", this.j);
        b = TXCStatus.b(this.v, 7103) - b;
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_first_frame_down", b);
        TXCDRApi.txSetEventValue(str, a.T, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.T, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, a.T, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.T, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, a.T);
        TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + utcTimeTick + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=" + b2 + " u32_server_ip=" + c + " u32_connect_server_time=" + b3 + " u32_stream_begin=-1 u32_first_i_frame" + "=" + this.j + " u32_first_frame_down=" + b + " str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u32_isp2p=" + this.k);
    }

    private void g() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.T, a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.T, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, a.T, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_network_type", (long) c("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_dns_time", -1);
        TXCDRApi.txSetEventValue(str, a.T, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_stream_begin", -1);
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_first_i_frame", -1);
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_first_frame_down", -1);
        TXCDRApi.txSetEventValue(str, a.T, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.T, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, a.T, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.T, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, a.T, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, a.T);
        TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + utcTimeTick + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=-1 u32_server_ip" + "= u32_connect_server_time=-1 u32_stream_begin" + "=-1 u32_first_i_frame=-1 u32_first_frame_down" + "=-1 str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u32_isp2p=" + this.k);
    }

    private void h() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.V, a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.V, "u64_timestamp", utcTimeTick);
        long timeTick = (TXCTimeUtil.getTimeTick() - TXCStatus.b(this.v, 7107)) / 1000;
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_result", timeTick);
        long b = TXCStatus.b(this.v, 6003);
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_block_time", b);
        TXCDRApi.txSetEventValue(str, a.V, "str_app_version", this.i);
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_isp2p", (long) this.k);
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_load", TXCStatus.b(this.v, 2001));
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_load_cnt", TXCStatus.b(this.v, 2002));
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_max_load", TXCStatus.b(this.v, 2003));
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_first_i_frame", this.j);
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_speed_cnt", TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_BEGIN));
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_nodata_cnt", TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS));
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_avg_cache_time", TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_LOADING));
        TXCDRApi.txSetEventIntValue(str, a.V, "u32_is_real_time", TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER));
        TXCDRApi.nativeReportEvent(str, a.V);
        TXCLog.d(a, "report evt 40102: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " u32_result=" + timeTick + " u32_avg_block_time=" + b + " str_app_version=" + this.i + " u32_isp2p=" + this.k + " u32_avg_load=" + TXCStatus.b(this.v, 2001) + " u32_load_cnt=" + TXCStatus.b(this.v, 2002) + " u32_max_load=" + TXCStatus.b(this.v, 2003) + " u32_first_i_frame=" + this.j + " u32_speed_cnt=" + TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_BEGIN) + " u32_nodata_cnt=" + TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) + " u32_avg_cache_time=" + TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_LOADING) + " u32_is_real_time=" + TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER));
    }

    private void i() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.U, a.al, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, a.U, "u32_avg_net_speed", (long) c("u32_avg_net_speed"));
        TXCDRApi.txSetEventIntValue(str, a.U, "u32_fps", (long) (c("u32_fps") / 10));
        long b = TXCStatus.b(this.v, 6004);
        if (this.l == -1 || b < this.l) {
            TXCDRApi.txSetEventIntValue(str, a.U, "u32_avg_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, a.U, "u32_avg_block_count", b - this.l);
        }
        this.l = b;
        int[] a = com.tencent.liteav.basic.util.a.a();
        b = TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_END);
        TXCDRApi.txSetEventIntValue(str, a.U, "u32_avg_cache_count", b);
        TXCDRApi.txSetEventIntValue(str, a.U, "u32_cpu_usage", (long) a[1]);
        TXCDRApi.txSetEventIntValue(str, a.U, "u32_app_cpu_usage", (long) a[0]);
        TXCDRApi.txSetEventValue(str, a.U, "str_app_version", this.i);
        TXCDRApi.txSetEventIntValue(str, a.U, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, a.U);
        if (this.p) {
            this.t++;
            this.s += b;
            if (b > this.r) {
                this.r = b;
            }
        }
    }

    private void j() {
        Map hashMap = new HashMap();
        String c = TXCStatus.c(this.v, 7113);
        String c2 = TXCStatus.c(this.v, 7114);
        String c3 = TXCStatus.c(this.v, 7115);
        int d = TXCStatus.d(this.v, 7105);
        String c4 = TXCStatus.c(this.v, 7106);
        int d2 = TXCStatus.d(this.v, 7111);
        hashMap.put("stream_url", c);
        hashMap.put("stream_id", c2);
        hashMap.put("bizid", c3);
        hashMap.put("err_code", String.valueOf(d));
        hashMap.put("err_info", c4);
        hashMap.put("channel_type", String.valueOf(d2));
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.q;
        hashMap.put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.q)));
        hashMap.put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(currentTimeMillis)));
        hashMap.put("total_time", String.valueOf(j));
        j = TXCStatus.b(this.v, 6003);
        currentTimeMillis = TXCStatus.b(this.v, 6006);
        long b = TXCStatus.b(this.v, 6005);
        if (j != 0) {
            currentTimeMillis /= j;
        } else {
            currentTimeMillis = 0;
        }
        hashMap.put("block_count", String.valueOf(j));
        hashMap.put("block_duration_max", String.valueOf(b));
        hashMap.put("block_duration_avg", String.valueOf(currentTimeMillis));
        if (this.t != 0) {
            currentTimeMillis = this.s / this.t;
        } else {
            currentTimeMillis = 0;
        }
        hashMap.put("jitter_cache_max", String.valueOf(this.r));
        hashMap.put("jitter_cache_avg", String.valueOf(currentTimeMillis));
        c3 = TXCDRApi.txCreateToken();
        d = a.ae;
        int i = a.ak;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.h, c3, d, i, tXCDRExtInfo);
        TXCLog.d(a, "report evt 40402: token=" + c3);
        for (Entry entry : hashMap.entrySet()) {
            c2 = (String) entry.getKey();
            c = (String) entry.getValue();
            TXCLog.e(a, "RealTimePlayStatisticInfo: " + c2 + " = " + c);
            if (!(c2 == null || c2.length() <= 0 || c == null)) {
                TXCDRApi.txSetEventValue(c3, d, c2, c);
            }
        }
        TXCDRApi.nativeReportEvent(c3, d);
        this.p = false;
        this.q = 0;
        this.t = 0;
        this.s = 0;
        this.r = 0;
    }

    private void k() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.c;
        long b = TXCStatus.b(this.v, 7013);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.P, a.ak, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
        TXCDRApi.txSetEventValue(str, a.P, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_network_type", (long) c("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_dns_time", -1);
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventValue(str, a.P, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_resolution", (long) ((this.d << 16) | this.e));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_audio_samplerate", (long) this.g);
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_bitrate", (long) this.f);
        TXCDRApi.txSetEventValue(str, a.P, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.P, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_channel_type", b);
        TXCDRApi.txSetEventValue(str, a.P, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.P, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.nativeReportEvent(str, a.P);
        TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time" + "=-1 u32_server_ip= u32_video_resolution" + "=" + ((this.d << 16) | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + b + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + c("u32_max_load"));
    }

    private void l() {
        long j;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.c;
        String c = TXCStatus.c(this.v, 7012);
        long b = TXCStatus.b(this.v, 7009);
        long b2 = TXCStatus.b(this.v, 7010);
        if (b2 != -1) {
            j = b2 - b;
        } else {
            j = b2;
        }
        b2 = TXCStatus.b(this.v, 7011);
        if (b2 != -1) {
            b = b2 - b;
        } else {
            b = b2;
        }
        long b3 = TXCStatus.b(this.v, 7013);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.P, a.ak, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.P, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, a.P, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_network_type", (long) c("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_dns_time", j);
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_connect_server_time", b);
        TXCDRApi.txSetEventValue(str, a.P, "u32_server_ip", c);
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_resolution", (long) ((this.d << 16) | this.e));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_audio_samplerate", (long) this.g);
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_bitrate", (long) this.f);
        TXCDRApi.txSetEventValue(str, a.P, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.P, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, a.P, "u32_channel_type", b3);
        TXCDRApi.txSetEventValue(str, a.P, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.P, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.nativeReportEvent(str, a.P);
        TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=" + j + " u32_connect_server_time=" + b + " u32_server_ip=" + c + " u32_video_resolution=" + ((this.d << 16) | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + b3 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + c("u32_max_load"));
    }

    private void m() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.c;
        long b = TXCStatus.b(this.v, 7009);
        long b2 = TXCStatus.b(this.v, 7013);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.R, a.ak, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.R, "u64_timestamp", utcTimeTick);
        b = (TXCTimeUtil.getTimeTick() - b) / 1000;
        TXCDRApi.txSetEventIntValue(str, a.R, "u32_result", b);
        TXCDRApi.txSetEventValue(str, a.R, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.R, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, a.R, "u32_channel_type", b2);
        TXCDRApi.txSetEventValue(str, a.R, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.R, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, a.R, "u32_ip_count_quic", String.valueOf(TXCStatus.d(this.v, 7016)));
        TXCDRApi.txSetEventValue(str, a.R, "u32_connect_count_quic", String.valueOf(TXCStatus.d(this.v, 7017)));
        TXCDRApi.txSetEventValue(str, a.R, "u32_connect_count_tcp", String.valueOf(TXCStatus.d(this.v, 7018)));
        TXCDRApi.nativeReportEvent(str, a.R);
        TXCLog.d(a, "report evt 40002: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " u32_result=" + b + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + b2 + " str_app_version=" + this.i + " dev_uuid=" + this.b.get("dev_uuid"));
    }

    private void n() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        tXCDRExtInfo.url = this.c;
        int[] a = com.tencent.liteav.basic.util.a.a();
        int i = a[0];
        int i2 = a[1];
        long b = TXCStatus.b(this.v, 7013);
        int d = TXCStatus.d(this.v, 7004);
        int d2 = TXCStatus.d(this.v, 7003);
        double e = TXCStatus.e(this.v, 4001);
        int d3 = TXCStatus.d(this.v, 7005);
        int d4 = TXCStatus.d(this.v, 7002);
        int d5 = TXCStatus.d(this.v, 7001);
        int d6 = TXCStatus.d(this.v, 4004);
        String c = TXCStatus.c(this.v, 7012);
        String c2 = TXCStatus.c(this.v, 7014);
        String c3 = TXCStatus.c(this.v, 7015);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.Q, a.ak, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_avg_audio_bitrate", (long) d4);
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_avg_video_bitrate", (long) d5);
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_avg_net_speed", (long) (d + d2));
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_fps", (long) ((int) e));
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_avg_cache_size", (long) d3);
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_cpu_usage", (long) i2);
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_app_cpu_usage", (long) i);
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_channel_type", b);
        TXCDRApi.txSetEventValue(str, a.Q, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.Q, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.Q, "u32_hw_enc", (long) d6);
        TXCDRApi.txSetEventValue(str, a.Q, "str_server_ip", c);
        TXCDRApi.txSetEventValue(str, a.Q, "str_quic_connection_id", c2);
        TXCDRApi.txSetEventValue(str, a.Q, "str_quic_connection_stats", c3);
        TXCDRApi.nativeReportEvent(str, a.Q);
    }

    private int c(String str) {
        Number number = (Number) this.b.get(str);
        if (number != null) {
            return number.intValue();
        }
        return 0;
    }

    private void o() {
        this.m = false;
        this.n = 0;
        this.b.put("str_user_id", com.tencent.liteav.basic.util.a.a(this.h));
        this.b.put("str_device_type", com.tencent.liteav.basic.util.a.b());
        this.b.put("str_device_type", com.tencent.liteav.basic.util.a.b());
        this.b.put("u32_network_type", Integer.valueOf(com.tencent.liteav.basic.util.a.c(this.h)));
        this.b.put("token", com.tencent.liteav.basic.util.a.c());
        this.b.put("str_package_name", com.tencent.liteav.basic.util.a.b(this.h));
        this.b.put("dev_uuid", com.tencent.liteav.basic.util.a.d(this.h));
    }

    private void b(boolean z) {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.W, a.al, tXCDRExtInfo);
        this.u = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventValue(str, a.W, "u64_timestamp", String.valueOf(this.u));
        TXCDRApi.txSetEventValue(str, a.W, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.W, "u32_network_type", (long) c("u32_network_type"));
        long b = TXCStatus.b(this.v, 7107);
        long b2 = TXCStatus.b(this.v, 7108);
        if (b2 != -1) {
            b2 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, a.W, "u32_dns_time", z ? b2 : -1);
        String c = TXCStatus.c(this.v, 7110);
        TXCDRApi.txSetEventValue(str, a.W, "u32_server_ip", z ? c : "");
        long b3 = TXCStatus.b(this.v, 7109);
        if (b3 != -1) {
            b3 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, a.W, "u32_connect_server_time", z ? b3 : -1);
        TXCDRApi.txSetEventIntValue(str, a.W, "u32_stream_begin", -1);
        this.j = TXCStatus.b(this.v, 6001) - b;
        TXCDRApi.txSetEventIntValue(str, a.W, "u32_first_i_frame", this.j);
        long b4 = TXCStatus.b(this.v, 7103) - b;
        TXCDRApi.txSetEventIntValue(str, a.W, "u32_first_frame_down", b4);
        TXCDRApi.txSetEventValue(str, a.W, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.W, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, a.W, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.W, "dev_uuid", (String) this.b.get("dev_uuid"));
        int d = TXCStatus.d(this.v, 2013);
        TXCDRApi.txSetEventValue(str, a.W, "u32_max_cache_time", String.valueOf(d));
        int d2 = TXCStatus.d(this.v, 2012);
        TXCDRApi.txSetEventValue(str, a.W, "u32_min_cache_time", String.valueOf(d2));
        int d3 = TXCStatus.d(this.v, 7105);
        TXCDRApi.txSetEventValue(str, a.W, "u64_err_code", String.valueOf(d3));
        String c2 = TXCStatus.c(this.v, 7106);
        TXCDRApi.txSetEventValue(str, a.W, "str_err_info", c2);
        int d4 = TXCStatus.d(this.v, 7112);
        TXCDRApi.txSetEventValue(str, a.W, "u32_link_type", String.valueOf(d4));
        int d5 = TXCStatus.d(this.v, 7111);
        TXCDRApi.txSetEventValue(str, a.W, "u32_channel_type", String.valueOf(d5));
        TXCDRApi.nativeReportEvent(str, a.W);
        TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + this.u + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + c("u32_network_type") + " u32_dns_time=" + b2 + " u32_server_ip=" + c + " u32_connect_server_time=" + b3 + " u32_stream_begin=-1 u32_first_i_frame" + "=" + this.j + " u32_first_frame_down=" + b4 + " str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u32_max_cache_time=" + d + " u32_min_cache_time=" + d2 + " u64_err_code=" + d3 + " str_err_info=" + c2 + " u32_link_type=" + d4 + " u32_channel_type=" + d5);
    }

    private void p() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.Y, a.al, tXCDRExtInfo);
        TXCDRApi.txSetEventValue(str, a.Y, "u64_begin_timestamp", String.valueOf(this.u));
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_end_timestamp", utcTimeTick);
        long j = (utcTimeTick - this.u) / 1000;
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_playtime", j);
        TXCDRApi.txSetEventValue(str, a.Y, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, a.Y, "u32_network_type", (long) c("u32_network_type"));
        String c = TXCStatus.c(this.v, 7110);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_server_ip", c);
        TXCDRApi.txSetEventValue(str, a.Y, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, a.Y, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, a.Y, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.Y, "dev_uuid", (String) this.b.get("dev_uuid"));
        long b = TXCStatus.b(this.v, 6003);
        long b2 = TXCStatus.b(this.v, 6005);
        long b3 = TXCStatus.b(this.v, 6006);
        long j2 = 0;
        if (b > 0) {
            j2 = b3 / b;
        }
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_block_count", b);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_block_duration_max", b2);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_block_duration_avg", j2);
        b3 = TXCStatus.b(this.v, 6009);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_jitter_cache_max", b3);
        long b4 = TXCStatus.b(this.v, 6008);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_jitter_cache_avg", b4);
        long b5 = TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_LOADING);
        TXCDRApi.txSetEventIntValue(str, a.Y, "u64_audio_cache_avg", b5);
        int d = TXCStatus.d(this.v, 7112);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_link_type", String.valueOf(d));
        long d2 = (long) TXCStatus.d(this.v, 2001);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_avg_load", String.valueOf(d2));
        long d3 = (long) TXCStatus.d(this.v, 2002);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_load_cnt", String.valueOf(d3));
        long d4 = (long) TXCStatus.d(this.v, 2003);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_max_load", String.valueOf(d4));
        int d5 = TXCStatus.d(this.v, 7111);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_channel_type", String.valueOf(d5));
        int d6 = TXCStatus.d(this.v, 7116);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_ip_count_quic", String.valueOf(d6));
        d6 = TXCStatus.d(this.v, 7117);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_connect_count_quic", String.valueOf(d6));
        d6 = TXCStatus.d(this.v, 7118);
        TXCDRApi.txSetEventValue(str, a.Y, "u32_connect_count_tcp", String.valueOf(d6));
        TXCDRApi.nativeReportEvent(str, a.Y);
        TXCLog.d(a, "report evt 40102: token=" + str + " str_stream_url=" + this.c + " u64_begin_timestamp=" + this.u + " u64_end_timestamp=" + utcTimeTick + " u64_playtime=" + j + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + c("u32_network_type") + " u32_server_ip=" + c + " str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u64_block_count=" + b + " u64_block_duration_max=" + b2 + " u64_block_duration_avg=" + j2 + " u64_jitter_cache_max=" + b3 + " u64_jitter_cache_avg=" + b4 + " u64_audio_cache_avg=" + b5 + " u32_link_type=" + d + " u32_avg_load=" + d2 + " u32_load_cnt=" + d3 + " u32_max_load=" + d4 + " u32_channel_type=" + d5);
    }

    private void q() {
        int i;
        int i2 = 2;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, a.X, a.al, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_net_speed", (long) (TXCStatus.d(this.v, 7102) + TXCStatus.d(this.v, 7101)));
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_fps", (long) ((int) TXCStatus.e(this.v, 6002)));
        long b = TXCStatus.b(this.v, 6004);
        if (this.l == -1 || b < this.l) {
            TXCDRApi.txSetEventIntValue(str, a.X, "u32_video_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, a.X, "u32_video_block_count", b - this.l);
        }
        this.l = b;
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_video_cache_count", TXCStatus.b(this.v, TXLiveConstants.PLAY_EVT_PLAY_END));
        int[] a = com.tencent.liteav.basic.util.a.a();
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_cpu_usage", (long) a[1]);
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_app_cpu_usage", (long) a[0]);
        TXCDRApi.txSetEventValue(str, a.X, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, a.X, "str_device_type", (String) this.b.get("str_device_type"));
        if (TXCStatus.d(this.v, 5002) == 0) {
            i = 2;
        } else {
            i = 1;
        }
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_video_decode_type", (long) i);
        if (TXCStatus.d(this.v, 2015) != 0) {
            i2 = 1;
        }
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_audio_decode_type", (long) i2);
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_network_type", (long) c("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_video_cache_time", (long) TXCStatus.d(this.v, 6007));
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_audio_cache_time", (long) TXCStatus.d(this.v, 2010));
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_audio_jitter", (long) TXCStatus.d(this.v, 2011));
        TXCDRApi.txSetEventIntValue(str, a.X, "u32_audio_drop", (long) TXCStatus.d(this.v, 2014));
        TXCDRApi.txSetEventValue(str, a.X, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.u) / 1000));
        TXCDRApi.txSetEventValue(str, a.X, "u32_link_type", String.valueOf(TXCStatus.d(this.v, 7112)));
        TXCDRApi.txSetEventValue(str, a.X, "u32_channel_type", String.valueOf(TXCStatus.d(this.v, 7111)));
        TXCDRApi.nativeReportEvent(str, a.X);
    }
}
