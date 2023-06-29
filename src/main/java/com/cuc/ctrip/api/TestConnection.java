package com.cuc.ctrip.api;

import com.cuc.ctrip.api.config.SQL;

public class TestConnection {
    public static void main(String[] args) {
        SQL.GetResults("select Top 3 * from Sales.Orders");
    }
}
