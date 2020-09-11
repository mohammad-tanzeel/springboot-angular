package tanzeel.apiwithspringboot.service;

import tanzeel.apiwithspringboot.model.Parent;
import tanzeel.apiwithspringboot.repository.ParentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(final ParentRepository parentRepository){this.parentRepository = parentRepository;}

    @Transactional(readOnly = true)
    public List<Parent> getAllParents(final int count){
        return this.parentRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Parent> getParent(final int id){return this.parentRepository.findById(id);}
}
