package com.tracholar.articlerecsys;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.db.MysqlDB;
import com.tracholar.recommend.engine.DetailFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArticleFetcher implements DetailFetcher<Article, Article> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, Article> fetchFromMysql(List<String> ids) {
        Map<String, Article> articles = new HashMap<>();

        try {
            StringBuffer idStr = new StringBuffer();
            for (String id : ids) {
                if (idStr.length() > 0) idStr.append(",");
                idStr.append(id);
            }

            Connection conn = MysqlDB.getInstance();
            String sql = String.format("select * from article where id in (%s)", idStr.toString());
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Article article = new Article();
                String id = rs.getString("id");
                article.setId(id);
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("body"));
                article.setUrl(rs.getString("link"));
                article.setAuthor(rs.getString("site"));

                articles.put(id, article);
            }

            logger.debug("Fetcher article sql: {}", sql);

        } catch (SQLException e) {
            logger.error("获取新闻文章失败！ {}", e);
        }
        return articles;
    }

    @Override
    public List<Article> fetch(@NotNull List<Article> arr) {
        List<String> ids = arr.stream().map(e -> e.getId()).collect(Collectors.toList());
        Map<String, Article> articles = fetchFromMysql(ids);
        List<Article> res = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            Article rankData = arr.get(i);
            String id = rankData.getId();
            if (articles.containsKey(id)) {
                Article article = articles.get(id);
                article.setRank(rankData.getRank());
                article.setScore(rankData.getScore());

                res.add(article);
            }
        }
        return res;
    }
}
