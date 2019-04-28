package map;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/23 上午 10:08
 * @author xiechongyang
 */
public class MyMap<K> implements IMap<K>{

    /**
     * 不想被序列化关键字transient
     */
    transient Node<K>[] table = null;//表
    private int size;//表大小
    private int length = 1;//表长度

    public MyMap(int size) {
        this.size = size;
    }

    static class Node<K>{
        final int hashCode;
        final String key;
        K value;
        Node<K> next;//子节点

        public Node(int hashCode, String key, K value, Node<K> next) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K> getNode(int hashCode, String key, K value, Node<K> next){
        return new Node<K>(hash(key),key,value,null);
    }

    /**
     * 增加
     * @param key
     * @param value
     * @return
     */
    @Override
    public void put(String key,K value) {
        if(null == key){
            return;
        }
        int index = 1;
        if(null == table){
            table = (Node<K>[])new Node[size];
            table[index-1] = getNode(hash(key),key,value,null);
        }else {
            while(index <= length){
                if(table[index-1].hashCode == hash(key)){
                    table[index-1] = getNode(hash(key),key,value,null);
                    break;
                }
                index++;
            }
            if(index>length){
                table[index-1] = getNode(hash(key),key,value,null);
                ++length;
            }
        }
        if(length == size){
            addSize();
        }
    }

    private void addSize(){
        size = size*2;
        Node<K>[] nodes = (Node<K>[])new Node[size];
        System.arraycopy(this.table,0,nodes,0,this.table.length);
        this.table = null;
        this.table = nodes;
    }

    /**
     * 删除
     * @return
     */
    @Override
    public int remove(String key) {
        int index = 1;
        while (index<=length){
            if(hash(key) == hash(table[index-1].key)){
                table[index-1] = table[length-1];
                table[length-1] = null;
                length--;
                return 1;
            }
        }
        return 0;
    }

    /**
     * 修改
     *
     * @return
     */
    @Override
    public int update() {
        return 0;
    }

    /**
     * 查询
     *
     * @return
     */
    @Override
    public K get(String key) {

        int index= 1;
        while (index<=length){
            if(hash(key) == hash(table[index-1].key)){
                return table[index-1].value;
            }
            index++;
        }

        return null;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public int getLength(){
        return this.length;
    }
}
