package mapper;

import domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("insert into board (title, writer, content) values (#{title}, #{writer}, #{content}) ")
    public void insert(Board board);

    @Select("select * from board order by id desc")
    List<Board> selectAll();

    @Select("select * from board where id = #{id}")
    Board selectOne(int id);

    @Delete("delete from board where id=#{id}")
    void delete(int id);

    @Update("update board set title = #{title}, content=#{content} where id = #{id}")
    void update(Board board);
}
