package com.veronica.mybatis.model;

import java.util.Map;

public class BaseModel {

    // {
    // if (criteriaMap == null) {
    //
    // ImmutableMap.Builder<String, String> builder = new Builder<String,
    // String>();
    // Field[] fields = this.getClass().getDeclaredFields();
    // for (Field field : fields) {
    // if (field.isAnnotationPresent(Criteria.class)) {
    // Criteria criteria = field.getAnnotation(Criteria.class);
    // if (StringUtils.isEmpty(criteria.column())) {
    // builder.put(field.getName(), criteria.type().name());
    // } else {
    // builder.put(criteria.column(), criteria.type().name());
    // }
    // }
    // }
    // criteriaMap = builder.build();
    //
    // System.out.println("after init");
    // } else {
    // System.out.println("already init");
    // }
    //
    // }

    private static Map<String, String> criteriaMap;
    private static String tableName;

    public String getTableName() {

        return tableName;
    }

    public Map<String, String> getCriteria() {

        return criteriaMap;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        criteriaMap.forEach((K, V) -> {
            sb.append(K);
            sb.append(V);
        });
        return sb.toString();
    }

}
