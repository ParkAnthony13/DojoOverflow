package parkanthony.doo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.doo.models.Tag;
import parkanthony.doo.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public Tag createTag(Tag b) {
		return tagRepository.save(b);
	}
	public Tag checkIfTagExists(String subject) {
		Tag optionalItem = tagRepository.findBySubject(subject);
		if(optionalItem==null) {
			return null;
		} else {
			return optionalItem;
		}
	}
	public Tag findTag(Long id) {
		Optional<Tag> optionalItem = tagRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
}
