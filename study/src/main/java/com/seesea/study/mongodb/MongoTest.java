package com.seesea.study.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/25 10:35
 * @Author xie
 */
public abstract class MongoTest<T> {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存
     * @param t
     */
    public void save(T t){
        log.info("[Mongo Dao ]save:" + t);
        this.mongoTemplate.save(t);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    public T queryById(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        log.info("[Mongo Dao ]queryById:" + query);
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 分页查询
     * @param query
     * @param start
     * @param size
     * @return
     */
    public List<T> getPage(Query query, int start, int size){
        query.skip(start);
        query.limit(size);
        log.info("[Mongo Dao ]queryPage:" + query + "(" + start +"," + size +")");
        List<T> lists = this.mongoTemplate.find(query, this.getEntityClass());
        return lists;
    }

    /**
     * 查询
     * @param query
     * @return
     */
    public Long getPageCount(Query query){
        log.info("[Mongo Dao ]queryPageCount:" + query);
        return this.mongoTemplate.count(query, this.getEntityClass());
    }


    /**
     * 删除
     * @param id
     */
//    public void deleteById(String id) {
//        Criteria criteria = Criteria.where("_id").in(id);
//        if(null!=criteria){
//            Query query = new Query(criteria);
//            log.info("[Mongo Dao ]deleteById:" + query);
//            if(null!=query && this.queryOne(query)!=null){
//                this.delete(query);
//            }
//        }
//    }


    /**
     * 删除
     * @param t
     */
    public void delete(T t){
        log.info("[Mongo Dao ]delete:" + t);
        this.mongoTemplate.remove(t);
    }

    /**
     * 修改第一个
     * @param query
     * @param update
     */
    public void updateFirst(Query query,Update update){
        log.info("[Mongo Dao ]updateFirst:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
    }

    /**
     * 修改所有
     * @param query
     * @param update
     */
    public void updateMulti(Query query, Update update){
        log.info("[Mongo Dao ]updateMulti:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    /**
     * 查找更新
     * @param query
     * @param update
     */
    public void updateInser(Query query, Update update){
        log.info("[Mongo Dao ]updateInser:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.upsert(query, update, this.getEntityClass());
    }

    protected abstract Class<T> getEntityClass();

}
