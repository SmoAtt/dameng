package com.cuc.dameng.api;

import com.cuc.dameng.api.config.R;
import com.cuc.dameng.api.config.SQL;
import com.cuc.dameng.api.util.HttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class presee {
    // 检测接口
    private static String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/table_infer/PortThroughput";
    // 官网获取的 API Key 更新为你注册的
    private static String clientId = "wX3WMuAMlsWqOhq0xNmg3Gef";
    // 官网获取的 Secret Key 更新为你注册的
    private static String clientSecret = "5CAE9AtQBnOMotKyu8chSeQwVMunGzxk";



        // 定义 DM JDBC 驱动串
        static String jdbcString = "dm.jdbc.driver.DmDriver";
        // 定义 DM URL 连接串
        static String urlString = "jdbc:dm://36.140.31.145:30259/hiveTodm8";
        // 定义连接用户名
        static String userName = "SYSDBA";
        // 定义连接用户口令
        static String password = "SYSDBA";
        // 定义连接对象
        static Connection conn = null;
        // 定义 SQL 语句执行对象
        static Statement state = null;
        // 定义结果集对象
        static ResultSet rs = null;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        LocalDate currentDate = LocalDate.of(2022, 12, 31);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        //1.加载 JDBC 驱动程序
        System.out.println("Loading JDBC Driver...");
        Class.forName(jdbcString);
        //2.连接 DM 数据库
        System.out.println("Connecting to DM Server...");
        conn = DriverManager.getConnection(urlString, userName, password);
        //3.通过连接对象创建 java.sql.Statement 对象
        state = conn.createStatement();


        while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate)) {
            String jsonString = "{\"data\":[{\"Time\":\"" + currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "\",\"Port\":\"太仓港\"}]}";

            try {
                // 获取token:注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
                String accessToken = "24.0480e86d7b79ce94f479e159ea798f76.2592000.1691648730.282335-36010602";

                // 获取返回结果集
                String result = HttpUtil.post(url, accessToken, "application/json", jsonString);
                System.out.println(result);

                // 解析返回结果集，获取NUM属性值
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(result);
                JsonNode numNode = jsonNode.get("batch_result");
                String num = numNode.get(0).get("Num").asText();

                // 构造SQL语句
                String sql = "INSERT INTO JES.INCOMINGSHIPS_TAICANG_DAY_AUGUST(DATE, WORKPORTNAME, NUMB)\n" +
                        "VALUES('" + currentDate + "', '太仓港', " + num + ")";

                // 执行SQL语句
                state.execute(sql);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // 暂停5秒
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 增加一天
            currentDate = currentDate.plusDays(1);
        }
        rs.close();
        state.close();
        conn.close();
    }
}
