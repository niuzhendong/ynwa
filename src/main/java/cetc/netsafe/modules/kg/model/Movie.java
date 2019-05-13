package cetc.netsafe.modules.kg.model;
/**
 * 测试用
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
public class Movie {

    private Long nodeId;

    private String title;

    private int released;

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getTitle() {
        return title;
    }

    public int getReleased() {
        return released;
    }


}
