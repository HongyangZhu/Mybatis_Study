
import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.ID_Utils;
import utils.MybatisUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class helloTest {
    @Test
    public void addBlog_test() {

        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog01 = new Blog();
        blog01.setId(ID_Utils.getID());
        blog01.setTitle("This is Title01");
        blog01.setAuthor("Author01");
        blog01.setCreateTime(new Date());
        blog01.setViews(9999);
        mapper.addBlog(blog01);


        Blog blog02 = new Blog();
        blog02.setId(ID_Utils.getID());
        blog02.setTitle("This is Title02");
        blog02.setAuthor("Author02");
        blog02.setCreateTime(new Date());
        blog02.setViews(9999);
        mapper.addBlog(blog02);

        session.commit();
        session.close();

    }

    @Test
    public void queryBlogIF_test() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map01 = new HashMap<>();
        map01.put("title", "This is Title01");
        map01.put("author", "Author01");
        List<Blog> blogs = mapper.queryBlogIF(map01);
        for (Blog blog : blogs) {
            System.out.println(blog.toString());
        }
        session.close();
    }

    @Test
    public void queryBlogChoose_test() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map01 = new HashMap<>();
        map01.put("views", "9999");
        List<Blog> blogs = mapper.queryBlogChoose(map01);
        for (Blog blog : blogs) {
            System.out.println(blog.toString());
        }
        session.close();
    }
}
