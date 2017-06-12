package models.status;

import models.forum.ForumJDBCTemplate;
import models.post.PostJDBCTemplate;
import models.thread.ThreadJDBCTemplate;
import models.user.UserJDBCTemplate;
import models.voice.VoiceJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by magomed on 20.03.17.
 */

@Service
@Transactional
public class StatusJDBCTemplate {
    private final JdbcTemplate jdbcTemplate;
    private final UserJDBCTemplate userJDBCTemplate;
    private final ForumJDBCTemplate forumJDBCTemplate;
    private final PostJDBCTemplate postJDBCTemplate;
    private final ThreadJDBCTemplate threadJDBCTemplate;
    private final VoiceJDBCTemplate voiceJDBCTemplate;
//    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(StatusJDBCTemplate.class);


    @Autowired
    public StatusJDBCTemplate(VoiceJDBCTemplate voiceJDBCTemplate, JdbcTemplate jdbcTemplate, UserJDBCTemplate userJDBCTemplate, ForumJDBCTemplate forumJDBCTemplate, PostJDBCTemplate postJDBCTemplate, ThreadJDBCTemplate threadJDBCTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userJDBCTemplate = userJDBCTemplate;
        this.forumJDBCTemplate = forumJDBCTemplate;
        this.threadJDBCTemplate = threadJDBCTemplate;
        this.postJDBCTemplate = postJDBCTemplate;
        this.voiceJDBCTemplate = voiceJDBCTemplate;
    }

    public Status getStatus() {
        final Status status = new Status(userJDBCTemplate.getCount(), forumJDBCTemplate.getCount(),  threadJDBCTemplate.getCount(), postJDBCTemplate.getCount());
//        LOGGER.debug("get status success");
        return status;
    }

    public void clearTable() {
        postJDBCTemplate.clearTable();
        forumJDBCTemplate.clearTable();
        threadJDBCTemplate.clearTable();
        userJDBCTemplate.clearTable();
        voiceJDBCTemplate.clearTable();
    }
}
