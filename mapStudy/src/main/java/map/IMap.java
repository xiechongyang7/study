package map;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/23 上午 10:16
 * @author xiechongyang
 */
public interface IMap<K> {

    /**
     * 增加
     * @param key
     * @param value
     * @return
     */
    void put(String key,K value);

    /**
     * 删除
     * @return
     */
    int remove(String key);

    /**
     * 修改
     * @return
     */
    int update();

    /**
     * 查询
     * @return
     */
    K get(String key);

    /**
     * 查看长度
     * @return
     */
    int getLength();
}
