package com.lxs.mms.auth.db.mongo.service;

import com.lxs.mms.auth.config.TokenConfig;
import com.lxs.mms.auth.db.mongo.bean.TokenCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 封装Token集合的相关操作。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Component
public class TokenService {
    @Autowired
    private TokenConfig tokenConfig;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 确保在字段{@link TokenCollection#updateDate}创建TTL索引。
     * 过期时间取决{@link TokenConfig#expireInSec}。
     */
    @PostConstruct
    public void checkTTLIndex() {
        Index ttlIndex = new Index("updateDate", Sort.Direction.ASC);
        ttlIndex.expire(tokenConfig.getExpireInSec(), TimeUnit.SECONDS);
        mongoTemplate.indexOps(TokenCollection.class).ensureIndex(ttlIndex);
    }

    public void saveToken(String token, String id) {
        TokenCollection tc = new TokenCollection();
        tc.setId(id);
        tc.setToken(token);
        tc.setUpdateDate(new Date());

        mongoTemplate.save(tc);
    }

    public TokenCollection updateToken(String token) {
        Query q = new Query(Criteria.where("token").is(token));
        Update u = new Update();
        u.currentTimestamp("updateDate");
        return mongoTemplate.findAndModify(q, u, TokenCollection.class);
    }
}
