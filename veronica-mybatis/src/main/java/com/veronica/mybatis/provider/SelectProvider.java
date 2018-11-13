package com.veronica.mybatis.provider;

import com.veronica.mybatis.model.BaseModel;

public class SelectProvider<T extends BaseModel> {
    private static String selectSql;

    private void sqlCreate(T t) {
        BaseModel model = (BaseModel) t;
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        model.getCriteria().forEach((K, V) -> {
            sb.append(K);
            sb.append(" ");
            sb.append(V);
            sb.append(" ");
            sb.append(K);
        });
    }

    public String getSql() {
        return selectSql;
    }

}
