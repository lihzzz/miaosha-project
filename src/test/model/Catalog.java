package test.model;

public class Catalog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Catalog.id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Catalog.name
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Catalog.user_id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    private Long userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Catalog.id
     *
     * @return the value of Catalog.id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Catalog.id
     *
     * @param id the value for Catalog.id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Catalog.name
     *
     * @return the value of Catalog.name
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Catalog.name
     *
     * @param name the value for Catalog.name
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Catalog.user_id
     *
     * @return the value of Catalog.user_id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Catalog.user_id
     *
     * @param userId the value for Catalog.user_id
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}