package cn.wangdpwin.test.base.search;

/**
 * @Author: wangdongpeng
 * @Date: 2019/7/18 下午8:13
 * @Description
 * @Version 1.0
 */
public abstract class AbstractSearch {
    Node startNode;
    Node goalNode;

    public AbstractSearch(Node startNode, Node goalNode){
        this.startNode = startNode;
        this.goalNode = goalNode;
    }

    public abstract boolean execute();
}
