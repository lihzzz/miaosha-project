package test.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.model.Vote;
import test.model.VoteExample;

public interface VoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    long countByExample(VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int deleteByExample(VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int insert(Vote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int insertSelective(Vote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    List<Vote> selectByExample(VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    Vote selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") Vote record, @Param("example") VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int updateByExample(@Param("record") Vote record, @Param("example") VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int updateByPrimaryKeySelective(Vote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Vote
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int updateByPrimaryKey(Vote record);
}