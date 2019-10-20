package com.tracholar.articlerecsys.recall;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.articlerecsys.db.MysqlDB;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Recall;
import com.tracholar.recommend.data.RecallResult;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TimeRecall extends BaseRecall {
    public List<RecallResult> recall(User user, ReqContext ctx){
        List<RecallResult> results = new ArrayList<>();

        try {
            Connection conn = MysqlDB.getInstance();
            String sql = "select id from article order by `date` desc limit 100";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getString("id"));

                results.add(article);
            }

        }catch (SQLException e) {
            loger.error("从MySQL读取数据失败!{}", e);
        }
        return results;
    }
}
