package com.tracholar.articlerecsys.recall;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.articlerecsys.data.ReqContext;
import com.tracholar.articlerecsys.data.User;
import com.tracholar.recommend.abtest.ABTestKey;
import com.tracholar.recommend.abtest.ABTestable;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Recall;
import com.tracholar.recommend.data.RecallResult;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TimeRecall  implements Recall<User, ReqContext>, ABTestable {
    private ABTestKey abTestKey;

    public List<RecallResult> recall(User user, ReqContext ctx){
        List<RecallResult> results = new ArrayList<>();
        Article article = new Article();
        article.setId("1234567");
        article.setAuthor("tracholar");
        results.add(article);

        return results;
    }
}
