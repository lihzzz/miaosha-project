package test.model;

import java.util.Date;

public class Vote {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Vote.id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Vote.createTime
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Vote.user_id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    private Long userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Vote.id
     *
     * @return the value of Vote.id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Vote.id
     *
     * @param id the value for Vote.id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Vote.createTime
     *
     * @return the value of Vote.createTime
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Vote.createTime
     *
     * @param createtime the value for Vote.createTime
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Vote.user_id
     *
     * @return the value of Vote.user_id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Vote.user_id
     *
     * @param userId the value for Vote.user_id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}