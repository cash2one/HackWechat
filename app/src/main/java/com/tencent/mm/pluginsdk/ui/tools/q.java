package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiPauseDownloadTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q {
    static Pattern vzd = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    String beo;
    String jcZ;
    String vza;
    String vzb;
    int vzc;

    public q(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.vza = "";
        this.vzb = "";
        this.vzc = -1;
        this.beo = "/";
        this.jcZ = "";
        Matcher matcher = vzd.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.vza = group.toLowerCase();
            }
            group = matcher.group(2);
            if (group != null) {
                this.jcZ = group;
            }
            group = matcher.group(3);
            if (group != null) {
                this.vzb = group;
            }
            group = matcher.group(4);
            if (group != null && group.length() > 0) {
                try {
                    this.vzc = Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    throw new Exception("Bad port");
                }
            }
            String group2 = matcher.group(5);
            if (group2 != null && group2.length() > 0) {
                if (group2.charAt(0) == '/') {
                    this.beo = group2;
                } else {
                    this.beo = "/" + group2;
                }
            }
            if (this.vzc == JsApiPauseDownloadTask.CTRL_INDEX && this.vza.equals("")) {
                this.vza = "https";
            } else if (this.vzc == -1) {
                if (this.vza.equals("https")) {
                    this.vzc = JsApiPauseDownloadTask.CTRL_INDEX;
                } else {
                    this.vzc = 80;
                }
            }
            if (this.vza.equals("")) {
                this.vza = "http";
                return;
            }
            return;
        }
        throw new Exception("Bad address");
    }

    public final String toString() {
        String str = "";
        if ((this.vzc != JsApiPauseDownloadTask.CTRL_INDEX && this.vza.equals("https")) || (this.vzc != 80 && this.vza.equals("http"))) {
            str = ":" + Integer.toString(this.vzc);
        }
        String str2 = "";
        if (this.jcZ.length() > 0) {
            str2 = this.jcZ + "@";
        }
        return this.vza + "://" + str2 + this.vzb + str + this.beo;
    }
}
