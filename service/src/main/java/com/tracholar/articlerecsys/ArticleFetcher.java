package com.tracholar.articlerecsys;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.db.MysqlDB;
import com.tracholar.recommend.data.HasId;
import com.tracholar.recommend.engine.DetailFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleFetcher implements DetailFetcher<Article> {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private List<Article> fetchFromMysql(List<HasId> ids) {
        List<Article> articles = new ArrayList<>();

        try {
            StringBuffer idStr = new StringBuffer();
            for(HasId<String> id : ids) {
                if(idStr.length() > 0) idStr.append(",");
                idStr.append(id.getId());
            }

            Connection conn = MysqlDB.getInstance();
            String sql = String.format("select * from article where id in (%s)",idStr.toString());
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getString("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("body"));
                article.setUrl(rs.getString("link"));
                article.setAuthor(rs.getString("site"));

                articles.add(article);
            }

            logger.debug("Fetcher article sql: {}", sql);

        }catch (SQLException e){
            logger.error("获取新闻文章失败！ {}", e);
        }
        return articles;
    }
    public List<Article> fetch(List<HasId> arr){
        List<Article> articles = fetchFromMysql(arr);

        return articles;
    }

}
