package test.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.model.BlogComment;
import test.model.BlogCommentExample;

public interface BlogCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    long countByExample(BlogCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int deleteByExample(BlogCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int insert(BlogComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int insertSelective(BlogComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    List<BlogComment> selectByExample(BlogCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_comment
     *
     * @mbg.generated Fri Oct 11 10:29:56 CST 2019
     */
    int updateByExample(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);
}