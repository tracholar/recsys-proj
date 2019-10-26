package com.tracholar.articlerecsys.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RssRepository extends CrudRepository<Rss, Long> {
    List<Rss> findByTitleLike(String title);

    @Query("select r from Rss r where title like ?")
    List<Rss> getRss(String title);
}
