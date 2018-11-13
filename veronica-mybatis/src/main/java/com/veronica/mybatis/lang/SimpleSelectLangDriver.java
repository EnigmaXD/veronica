package com.veronica.mybatis.lang;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import com.google.common.base.CaseFormat;
import com.veronica.mybatis.annotation.From;

public class SimpleSelectLangDriver extends XMLLanguageDriver implements LanguageDriver {
    // private final Pattern resultPattern =
    // Pattern.compile("\\(#\\{(result)\\}\\)");
    private final Pattern fromPattern = Pattern.compile("\\(#\\{(from)\\}\\)");
    private final Pattern wherePattern = Pattern.compile("\\(#\\{(where)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = wherePattern.matcher(script);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<where>");

            for (Field field : parameterType.getDeclaredFields()) {
                String tmp = "<if test=\"pojo._field != null\">AND _column=#{pojo._field}</if>";
                sb.append(tmp.replaceAll("_field", field.getName()).replaceAll("_column",
                        CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName())));
            }

            sb.append("</where>");

            script = matcher.replaceAll(sb.toString());
            script = "<script>" + script + "</script>";
        }
        Matcher fromMatcher = fromPattern.matcher(script);
        if (fromMatcher.find()) {
            if (parameterType.isAnnotationPresent(From.class)) {
                script = fromMatcher.replaceAll(parameterType.getAnnotation(From.class).value());
            }
        }

        return super.createSqlSource(configuration, script, parameterType);
    }
}
