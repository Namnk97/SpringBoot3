package com.example.booking_online.locale;


import com.example.booking_online.constant.Message;
import com.example.booking_online.constant.TrackingContextEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.context.i18n.LocaleContextHolder;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.example.booking_online.constant.Constants.PATH_ERROR;
import static com.example.booking_online.constant.Constants.PATH_MESSAGE;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("all")
public class Translator {

    private static final MultiResourceBundleControl control
            = new MultiResourceBundleControl(PATH_MESSAGE + PATH_ERROR, PATH_MESSAGE, PATH_ERROR);

    public static String toMessage(Message msg, Object... args) {
        String lang = ThreadContext.get(TrackingContextEnum.LANG.getThreadKey());
        Locale locale = LocaleContextHolder.getLocale();
        if (lang != null) {
            locale = "vi".equalsIgnoreCase(lang)? new Locale("vi", "VN") : new Locale("en", "US");
        }
        return getMessage(msg.toString(), locale, getArgTranslate(args));
    }

    public static String toMessage(String msg, Object... args) {
        String lang = ThreadContext.get(TrackingContextEnum.LANG.getThreadKey());
        Locale locale = LocaleContextHolder.getLocale();
        if (lang != null) {
            locale = "vi".equalsIgnoreCase(lang)? new Locale("vi", "VN") : new Locale("en", "US");
        }
        return getMessage(msg, locale, getArgTranslate(args));
    }

    private static Object[] getArgTranslate(Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] argsTranslate = new Object[args.length];
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                // translate message args
                argsTranslate[i] = getMessage(String.valueOf(args[i]), locale);
            }
        }

        return argsTranslate;
    }

    private static String getMessage(String code, Locale locale, Object... args) {
        ResourceBundle resourceBundle = ResourceBundle
                .getBundle(control.getBaseName(), locale, control);
        String message;
        try {
            message = resourceBundle.getString(code);
            if (args.length > 0) {
                return MessageFormat.format(message, args);
            }
        } catch (Exception ex) {
            log.error(">>> Can not get message with code {}", code);
            message = code;
        }

        return message;
    }
}
