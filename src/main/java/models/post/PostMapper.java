package models.post;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by magomed on 19.03.17.
 */
public class PostMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        Post post = new Post();
        post.setAuthor(resultSet.getString("author"));
        post.setCreated(resultSet.getTimestamp("created"));
        post.setForum(resultSet.getString("forum"));
        post.setId(resultSet.getInt("id"));
        post.setMessage(resultSet.getString("message"));
        post.setParentId(resultSet.getInt("parent_id"));
        post.setThread(resultSet.getInt("thread"));
        post.setEdited(resultSet.getBoolean("isEdited"));
        return post;
    }
}
