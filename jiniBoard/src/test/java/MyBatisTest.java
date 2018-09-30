import domain.Board;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import mapper.BoardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {config.RootConfig.class})
@Log4j
public class MyBatisTest {
    @Autowired
    private DataSource dataSource;

    private BoardMapper mapper;

    public MyBatisTest() {
    }

    @Test
    public void DSTest() {
        try(Connection connection = dataSource.getConnection())  {
            System.out.println("Connection !!!!: "+connection.getCatalog());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertTest() {
        List<Board> boardList = mapper.selectAll();
        System.out.println(boardList.size());
    }
}
