package com.ujiuye.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class JdbcUtil {
    static ComboPooledDataSource pds = new ComboPooledDataSource();
    static QueryRunner qr = new QueryRunner(pds);

    public static QueryRunner getQr(){
        return qr;
    }
}
