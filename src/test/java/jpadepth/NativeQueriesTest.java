package jpadepth;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jpadepth.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Root.class)
@Transactional
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void nativeQueries() {
        Query query = em.createNativeQuery("Select * from course");
        List resultList = query.getResultList();
        logger.info("Select * from course:" + resultList);
    }

    @Test
    public void nativeQueriesPositionParameter() {
        Query query = em.createNativeQuery("select * from course where id=?", Course.class);
        query.setParameter(1, 1L);
        List resultList = query.getResultList();
        logger.info("select * from course:" + resultList);
    }

    @Test
    public void nativeQueriesNamedParameter() {
        Query query = em.createNativeQuery("select * from course where id=:id", Course.class);
        query.setParameter("id", 1L);
        List resultList = query.getResultList();
        logger.info("select * from course:" + resultList);
    }

    @Test
    public void nativeQueryUpdate() {
        Query query = em.createNativeQuery("update course set last_updated_date=current_timestamp()", Course.class);
        int noOfRows = query.executeUpdate();
        logger.info("noOfRowsUpdated:" + noOfRows);
    }

}
