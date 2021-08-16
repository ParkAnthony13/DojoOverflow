package parkanthony.doo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.doo.models.Question;
import parkanthony.doo.models.Tag;
import parkanthony.doo.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	public List<Question> allItems(){
		return questionRepository.findAll();
	}
	public Question createItem(Question b) {
		return questionRepository.save(b);
	}
	public Question updateItem(Question b) {
		return questionRepository.save(b);
	}
	public Question findQuestion(Long id) {
		Optional<Question> optionalItem = questionRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
}
