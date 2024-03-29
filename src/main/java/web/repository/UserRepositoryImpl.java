package web.repository;

import org.springframework.stereotype.Repository;
import web.models.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("from Users", Users.class).getResultList();
    }

    @Override
    public void createUser(Users person) {
        entityManager.persist(person);
    }

    @Override
    public void updateUser(Users user) {
        entityManager.merge(user);
    }

    @Override
    public Users readUser(int id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Users user = readUser(id);
        entityManager.remove(user);
    }
}
