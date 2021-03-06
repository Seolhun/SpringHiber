package com.shun.blog.repository.stack;

import com.shun.blog.model.stack.Stack;
import com.shun.blog.repository.AbstractRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StackRepositoryImpl extends AbstractRepository<Long, Stack> implements StackRepository {
    private static final Logger LOG = LoggerFactory.getLogger(StackRepositoryImpl.class);

    @Override
    public void insert(Stack stack) {
        persist(stack);
    }

    @Override
    public Stack selectById(Long id) throws Exception {
        LOG.info("param : StackRepository.selectById {}", id);
        return getByLong(id);
    }

    @Override
    public Stack selectByName(String name) throws Exception {
        LOG.info("param : StackRepository.selectByName {}", name.toString());
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Stack) criteria.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Stack> selectListForAdmin(Stack stack) throws Exception {
        LOG.info("param : StackRepository.selectList {}", stack.toString());
        // 검색 로직
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("deletedFlag", false));
        criteria.add(Restrictions.eq("errorFlag", "N"));
        criteria.add(Restrictions.eq("langDepth", 0));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Stack>)criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Stack> selectListForAdminWithError(Stack stack) throws Exception {
        LOG.info("param : StackRepository.selectList {}", stack.toString());
        // 검색 로직
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("deletedFlag", false));
        criteria.add(Restrictions.eq("langDepth", 0));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Stack>)criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Stack> selectList(Stack stack) throws Exception {
        LOG.info("param : StackRepository.selectList {}", stack.toString());
        // 검색 로직
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("deletedFlag", false));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Stack>)criteria.list();
    }

    @Override
    public int getCount() throws Exception {
        // 검색 로직
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("deletedFlag", false));
        return ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    @Override
    public void deleteById(Long id) {
        LOG.info("param : StackRepository.deleteById {}", id);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Stack blog = (Stack) criteria.uniqueResult();
        delete(blog);
    }
}
