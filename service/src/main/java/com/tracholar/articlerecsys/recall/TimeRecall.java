package com.tracholar.articlerecsys.recall;

import com.tracholar.articlerecsys.data.Article;
import com.tracholar.recommend.data.IContext;
import com.tracholar.recommend.data.IUser;
import com.tracholar.recommend.engine.Recall;
import com.tracholar.recommend.engine.RecallResult;

import java.util.ArrayList;
import java.util.List;

public class TimeRecall  implements Recall {
    public List<RecallResult> recall(IUser user, IContext ctx){
        List<RecallResult> results = new ArrayList<>();
        Article article = new Article();
        article.setId(1234567L);
        results.add(article);

        return results;
    }
}
