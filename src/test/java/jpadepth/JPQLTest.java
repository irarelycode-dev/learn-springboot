package jpadepth;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpadepth.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Root.class)
public class JPQLTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpqlBasic() {
        List resultList = em.createQuery("Select c from Course c").getResultList();
        logger.info("Select c from Course:" + resultList);
    }

    @Test
    public void jpqlTyped() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c:" + resultList);
    }

    @Test
    public void jpqlTypedWhere() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%100 steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c where name like '%100 steps':" + resultList);
    }

}
