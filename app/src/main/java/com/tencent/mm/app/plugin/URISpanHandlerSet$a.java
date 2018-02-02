package com.tencent.mm.app.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface URISpanHandlerSet$a {
    URISpanHandlerSet$PRIORITY uD() default URISpanHandlerSet$PRIORITY.NORMAL;
}
