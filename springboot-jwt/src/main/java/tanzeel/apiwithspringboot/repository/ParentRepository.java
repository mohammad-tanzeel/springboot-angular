package tanzeel.apiwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tanzeel.apiwithspringboot.model.Parent;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {

    // custom query to search to blog post by title or content
    List<Parent> findByEmailContaining(String email);

}
